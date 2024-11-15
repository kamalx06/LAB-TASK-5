package com.example.lab_task_5;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {

    // Parse JSON data
    public static List<String> parseJson(String jsonData) {
        List<String> currencyList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject rates = jsonObject.getJSONObject("rates");

            Iterator<String> keys = rates.keys();
            while (keys.hasNext()) {
                String currency = keys.next();
                String value = rates.getString(currency);
                currencyList.add(currency + " - " + value);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return currencyList;
    }
}
