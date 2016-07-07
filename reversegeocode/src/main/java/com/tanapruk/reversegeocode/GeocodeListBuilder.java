package com.tanapruk.reversegeocode;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Tanapruk on 8/11/15 AD.
 */
public class GeocodeListBuilder {

    final static private String filepath = "ReverseGeocodeCountryWithName.json";

    public static String getCountryName(Context context , Double latitude, Double longitude) {
        return getGeocodeListFromJSON(context).getCountryName(latitude,longitude);
    }

    public static String getCountryId(Context context, Double latitude, Double longitude) {
        return getGeocodeList(context).getCountryId(latitude,longitude);
    }

    private static GeocodeList getGeocodeList(Context context) {
        return getGeocodeListFromJSON(context);
    }

    private static GeocodeList getGeocodeListFromJSON(Context context) {
        String jsonString = getJSONFromAsset(context);
        Gson gson = new Gson();
        return gson.fromJson(jsonString, GeocodeList.class);
    }

    private static String getJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(filepath);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
