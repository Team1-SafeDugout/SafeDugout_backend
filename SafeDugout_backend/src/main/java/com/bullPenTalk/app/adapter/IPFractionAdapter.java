package com.bullPenTalk.app.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 * Custom TypeAdapter to handle fractional innings pitched (IP) values from JSON.
 * It converts strings like "10 1/3" to 10.1 and "10 2/3" to 10.2.
 */
public class IPFractionAdapter extends TypeAdapter<Double> {

    @Override
    public Double read(JsonReader in) throws IOException {
        String ipString = in.nextString();

        // Check for empty or non-numeric strings
        if (ipString == null || ipString.isEmpty() || "-".equals(ipString) || "0".equals(ipString)) {
            return 0.0;
        }

        // Handle fractional values like "59 1/3" or "106 2/3"
        if (ipString.contains("/")) {
            String[] parts = ipString.split(" ");
            double wholeInnings = Double.parseDouble(parts[0]);
            
            // Convert "1/3" to 0.1 and "2/3" to 0.2 based on baseball scoring rules
            if (parts[1].equals("1/3")) {
                return wholeInnings + 0.1;
            } else if (parts[1].equals("2/3")) {
                return wholeInnings + 0.2;
            }
        }
        
        // Handle simple decimal values like "1.23" or "10.00"
        return Double.parseDouble(ipString);
    }

    @Override
    public void write(JsonWriter out, Double value) throws IOException {
        // This is not used for this specific problem but is required for the TypeAdapter interface.
        out.value(value);
    }
}
