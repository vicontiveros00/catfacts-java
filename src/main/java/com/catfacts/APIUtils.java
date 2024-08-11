package com.catfacts;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class APIUtils {
    public static String callMeowFacts() {
        try {
            URL url = new URL("https://meowfacts.herokuapp.com/");
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            
            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                
                in.close();
                connection.disconnect();
                
                JSONObject jsonResponse = new JSONObject(content.toString());
                JSONArray data = jsonResponse.getJSONArray("data");
                String catFact = data.getString(0);

                return catFact;
            } else {
                throw new Exception("Request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}