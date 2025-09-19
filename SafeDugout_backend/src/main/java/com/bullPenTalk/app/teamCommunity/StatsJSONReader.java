package com.bullPenTalk.app.teamCommunity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.bullPenTalk.app.adapter.IPFractionAdapter;
import com.bullPenTalk.app.dto.BatterRecordDTO;
import com.bullPenTalk.app.dto.PitcherRecordDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class StatsJSONReader {
    private static final Logger logger = Logger.getLogger(StatsJSONReader.class.getName());

    private static String getTeamName(Integer teamNumber) {
        switch (teamNumber) {
            case 1: return "doosan";
            case 2: return "lg";
            case 3: return "hanwha";
            case 4: return "samsung";
            case 5: return "ssg";
            case 6: return "kt";
            case 7: return "nc";
            case 8: return "lotte";
            case 9: return "kia";
            case 10: return "kiwoom";
            default: return null;
        }
    }

    public static List<?> readStats(Integer teamNumber, String statsType) throws IOException {
        String teamName = getTeamName(teamNumber);
        if (teamName == null) {
            logger.warning("유효하지 않은 팀 번호: " + teamNumber);
            return Collections.emptyList();
        }

        String fileName;
        Type listType;

        // GsonBuilder를 메서드 내부에서 생성하여,
        // 각 호출마다 새로운 Gson 객체를 만듭니다.
        GsonBuilder gsonBuilder = new GsonBuilder();
        
        // 투수와 타자 기록 모두에 대해 IPFractionAdapter를 등록합니다.
        // 이것이 스택 트레이스 오류를 해결하는 핵심입니다.
        gsonBuilder.registerTypeAdapter(Double.class, new IPFractionAdapter());

        if ("batter".equalsIgnoreCase(statsType)) {
            fileName = "kbo_batter_" + teamName + ".json";
            listType = new TypeToken<List<BatterRecordDTO>>() {}.getType();
        } else {
            fileName = "kbo_pitcher_" + teamName + ".json";
            listType = new TypeToken<List<PitcherRecordDTO>>() {}.getType();
        }

        String filePath = "/kbo_data/" + fileName;
        InputStream inputStream = StatsJSONReader.class.getResourceAsStream(filePath);

        if (inputStream == null) {
            logger.severe("파일을 클래스패스에서 찾을 수 없습니다: " + filePath);
            throw new IOException("파일을 찾을 수 없습니다: " + filePath);
        }

        Gson gson = gsonBuilder.create();
        try (InputStreamReader reader = new InputStreamReader(inputStream)) {
            // 이 시점에서 Gson은 등록된 IPFractionAdapter를 사용하여 데이터를 파싱합니다.
            return gson.fromJson(reader, listType);
        }
    }
}
