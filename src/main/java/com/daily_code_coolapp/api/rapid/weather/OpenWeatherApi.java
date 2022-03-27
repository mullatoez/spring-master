package com.daily_code_coolapp.api.rapid.weather;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OpenWeatherApi {
    public static void main(String[] args) throws IOException {
            getWeather();
    }

   static void getWeather() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://community-open-weather-map.p.rapidapi.com/weather?q=London%2Cuk&lat=0&lon=0&callback=test&id=2172797&lang=null&units=imperial&mode=xml")
                .get()
                .addHeader("X-RapidAPI-Host", "community-open-weather-map.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", "0ab05d0a60msh3236dcb130b0ab7p194355jsnf3be418de9cd")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful())
        {
            //System.out.println(response.body().toString());
            Gson gson = new Gson();
            String json = gson.toJson(response.body());
            System.out.println(json);

        }else {

            System.out.println(response.code());

        }
    }
}
