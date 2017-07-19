package com.example.android.weatherapppractice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by skim2 on 7/18/2017.
 */

public class HourlyWeatherAdapter extends ArrayAdapter<HourlyWeather> {

    public HourlyWeatherAdapter(Activity context, ArrayList<HourlyWeather> hourlyForecast) {
        super(context, 0, hourlyForecast);
    }

    @Override
    public View getView (int position, final View convertView, ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_daily_forecast_hourly, parent, false);
        }
        final HourlyWeather currentWeather = getItem(position);
        ImageView weatherIcon = (ImageView) listView.findViewById(R.id.weather_icon_image_view);
        TextView tempTextView = (TextView) listView.findViewById(R.id.temp_text_view);
        TextView timeTextView = (TextView) listView.findViewById(R.id.time_text_view);
        if (currentWeather.getmWeatherCondition().equals("Clear")) {
            weatherIcon.setImageResource(R.drawable.sunny);
        } else if (currentWeather.getmWeatherCondition().equals("Partly Cloudy")) {
            weatherIcon.setImageResource(R.drawable.mostly_cloudy);
        } else if (currentWeather.getmWeatherCondition().contains("Cloud")) {
            weatherIcon.setImageResource(R.drawable.cloudy);
        } else if (currentWeather.getmWeatherCondition().equals("Drizzle")) {
            weatherIcon.setImageResource(R.drawable.drizzle);
        } else if (currentWeather.getmWeatherCondition().contains("Thunderstorm")) {
            weatherIcon.setImageResource(R.drawable.thunderstorms);
        } else if (currentWeather.getmWeatherCondition().contains("Snow")) {
            weatherIcon.setImageResource(R.drawable.snow);
        } else if (currentWeather.getmWeatherCondition().equals("Haze")) {
            weatherIcon.setImageResource(R.drawable.haze);
        } else {
            weatherIcon.setImageResource(R.drawable.sunny);
        }

        tempTextView.setText(currentWeather.getmTempCelsius() + "°C");
        timeTextView.setText(currentWeather.getmHour());
        return listView;
    }
}
