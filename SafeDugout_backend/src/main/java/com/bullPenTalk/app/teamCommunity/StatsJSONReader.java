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
        GsonBuilder gsonBuilder = new GsonBuilder();

        if ("batter".equalsIgnoreCase(statsType)) {
            fileName = "kbo_batter_" + teamName + ".json";
            listType = new TypeToken<List<BatterRecordDTO>>() {}.getType();
        } else { // 기본값은 "pitcher"
            fileName = "kbo_pitcher_" + teamName + ".json";
            listType = new TypeToken<List<PitcherRecordDTO>>() {}.getType();
            gsonBuilder.registerTypeAdapter(new TypeToken<Double>() {}.getType(), new IPFractionAdapter());
        }

        String filePath = "/kbo_data/" + fileName;
        InputStream inputStream = StatsJSONReader.class.getResourceAsStream(filePath);

        if (inputStream == null) {
            logger.severe("파일을 클래스패스에서 찾을 수 없습니다. 빌드 설정을 확인하십시오: " + filePath);
            throw new IOException("파일을 찾을 수 없습니다: " + filePath + ". 프로젝트 빌드 설정에 파일이 포함되어 있는지 확인하세요.");
        }

        Gson gson = gsonBuilder.create();
        try (InputStreamReader reader = new InputStreamReader(inputStream)) {
            return gson.fromJson(reader, listType);
        }
    }
}
