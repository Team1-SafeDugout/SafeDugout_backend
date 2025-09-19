package com.bullPenTalk.app.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class IPFractionAdapter extends TypeAdapter<Double> {
    @Override
    public Double read(JsonReader in) throws IOException {
        // 현재 토큰의 타입을 미리 확인합니다.
        JsonToken peek = in.peek();
        
        // 토큰이 문자열일 경우
        if (peek == JsonToken.STRING) {
            String value = in.nextString();
            
            // "IP"와 같이 소수점이나 '-'가 없는 경우를 처리합니다.
            if (value.contains(".")) {
                return Double.parseDouble(value);
            }
            
            // 값이 "-"인 경우
            if (value.equals("-")) {
                // 이 부분을 0.0으로 처리하여 오류를 방지합니다.
                return 0.0;
            }
            
            // 값이 "분수" 형태인 경우
            String[] parts = value.split("/");
            if (parts.length == 2) {
                try {
                    double numerator = Double.parseDouble(parts[0]);
                    double denominator = Double.parseDouble(parts[1]);
                    // 분모가 0이 아닌지 확인하여 예외를 방지합니다.
                    if (denominator == 0) {
                        return 0.0;
                    }
                    return numerator / denominator;
                } catch (NumberFormatException e) {
                    // 숫자로 변환할 수 없는 경우 기본값을 반환합니다.
                    return 0.0;
                }
            }
            
            // 다른 문자열 형식은 NumberFormatException을 피하기 위해 0.0으로 반환합니다.
            return 0.0;
            
        // 토큰이 숫자일 경우
        } else if (peek == JsonToken.NUMBER) {
            return in.nextDouble();
            
        // 토큰이 null인 경우
        } else if (peek == JsonToken.NULL) {
            in.nextNull();
            return 0.0;
        }
        
        // 그 외의 경우는 무시하고 0.0을 반환합니다.
        in.skipValue();
        return 0.0;
    }

    @Override
    public void write(JsonWriter out, Double value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value);
        }
    }
}
