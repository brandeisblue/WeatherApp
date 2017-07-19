package com.example.android.weatherapppractice;

/**
 * Created by skim2 on 7/18/2017.
 */

public class HourlyWeather {

    private String mWeatherCondition;
    private double mTempCelsius;
    private String mHour;

    public HourlyWeather(String weatherCondition, double tempCelsius, String hour) {
        mWeatherCondition = weatherCondition;
        mTempCelsius = tempCelsius;
        mHour = hour;
    }

    public String getmWeatherCondition() {
        return mWeatherCondition;
    }

    public double getmTempCelsius() {
        return mTempCelsius;
    }

    public String getmHour() {
        return mHour;
    }

}
