package com.example.android.weatherapppractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String weatherJson;
    private String dateDay;
    private ArrayList<HourlyWeather> hourlyForecasts = new ArrayList<HourlyWeather>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherJson = "\n" +
                "{\n" +
                "  \"response\": {\n" +
                "  \"version\":\"0.1\",\n" +
                "  \"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\",\n" +
                "  \"features\": {\n" +
                "  \"hourly\": 1\n" +
                "  }\n" +
                "\t}\n" +
                "\t\t,\n" +
                "\t\"hourly_forecast\": [\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"23\",\"hour_padded\": \"23\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"18\",\"mday_padded\": \"18\",\"yday\": \"198\",\"isdst\": \"1\",\"epoch\": \"1500433200\",\"pretty\": \"11:00 PM EDT on July 18, 2017\",\"civil\": \"11:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Tuesday\",\"weekday_name_night\": \"Tuesday Night\",\"weekday_name_abbrev\": \"Tue\",\"weekday_name_unlang\": \"Tuesday\",\"weekday_name_night_unlang\": \"Tuesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"80\", \"metric\": \"27\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Partly Cloudy\",\n" +
                "\t\t\"icon\": \"partlycloudy\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_partlycloudy.gif\",\n" +
                "\t\t\"fctcode\": \"2\",\n" +
                "\t\t\"sky\": \"36\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SW\", \"degrees\": \"236\"},\n" +
                "\t\t\"wx\": \"Partly Cloudy\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"75\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"85\", \"metric\": \"29\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"80\", \"metric\": \"27\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"15\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.06\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"0\",\"hour_padded\": \"00\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500436800\",\"pretty\": \"12:00 AM EDT on July 19, 2017\",\"civil\": \"12:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"79\", \"metric\": \"26\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"72\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"10\",\n" +
                "\t\t\"wspd\": {\"english\": \"1\", \"metric\": \"2\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SW\", \"degrees\": \"229\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"78\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"79\", \"metric\": \"26\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"0\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.07\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"1\",\"hour_padded\": \"01\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500440400\",\"pretty\": \"1:00 AM EDT on July 19, 2017\",\"civil\": \"1:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"79\", \"metric\": \"26\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"10\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"WSW\", \"degrees\": \"250\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"78\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"79\", \"metric\": \"26\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"0\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.06\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"2\",\"hour_padded\": \"02\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500444000\",\"pretty\": \"2:00 AM EDT on July 19, 2017\",\"civil\": \"2:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"78\", \"metric\": \"26\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"8\",\n" +
                "\t\t\"wspd\": {\"english\": \"1\", \"metric\": \"2\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"W\", \"degrees\": \"280\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"79\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"78\", \"metric\": \"26\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"0\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.05\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"3\",\"hour_padded\": \"03\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500447600\",\"pretty\": \"3:00 AM EDT on July 19, 2017\",\"civil\": \"3:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"78\", \"metric\": \"26\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"10\",\n" +
                "\t\t\"wspd\": {\"english\": \"1\", \"metric\": \"2\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"WNW\", \"degrees\": \"302\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"80\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"78\", \"metric\": \"26\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"3\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.04\", \"metric\": \"1017\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"4\",\"hour_padded\": \"04\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500451200\",\"pretty\": \"4:00 AM EDT on July 19, 2017\",\"civil\": \"4:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"77\", \"metric\": \"25\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"12\",\n" +
                "\t\t\"wspd\": {\"english\": \"1\", \"metric\": \"2\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"WNW\", \"degrees\": \"284\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"82\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"77\", \"metric\": \"25\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"5\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.04\", \"metric\": \"1017\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"5\",\"hour_padded\": \"05\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500454800\",\"pretty\": \"5:00 AM EDT on July 19, 2017\",\"civil\": \"5:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"77\", \"metric\": \"25\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"72\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"10\",\n" +
                "\t\t\"wspd\": {\"english\": \"0\", \"metric\": \"0\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"NW\", \"degrees\": \"322\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"85\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"77\", \"metric\": \"25\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"7\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.05\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"6\",\"hour_padded\": \"06\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500458400\",\"pretty\": \"6:00 AM EDT on July 19, 2017\",\"civil\": \"6:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"78\", \"metric\": \"26\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"72\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"11\",\n" +
                "\t\t\"wspd\": {\"english\": \"1\", \"metric\": \"2\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"NNW\", \"degrees\": \"338\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"84\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"78\", \"metric\": \"26\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"9\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.05\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"7\",\"hour_padded\": \"07\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500462000\",\"pretty\": \"7:00 AM EDT on July 19, 2017\",\"civil\": \"7:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"79\", \"metric\": \"26\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"73\", \"metric\": \"23\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"16\",\n" +
                "\t\t\"wspd\": {\"english\": \"0\", \"metric\": \"0\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"WNW\", \"degrees\": \"304\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"82\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"79\", \"metric\": \"26\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"7\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.06\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"8\",\"hour_padded\": \"08\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500465600\",\"pretty\": \"8:00 AM EDT on July 19, 2017\",\"civil\": \"8:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"80\", \"metric\": \"27\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"72\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"17\",\n" +
                "\t\t\"wspd\": {\"english\": \"0\", \"metric\": \"0\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"W\", \"degrees\": \"261\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"1\",\n" +
                "\t\t\"humidity\": \"76\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"85\", \"metric\": \"29\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"80\", \"metric\": \"27\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"5\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.06\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"9\",\"hour_padded\": \"09\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500469200\",\"pretty\": \"9:00 AM EDT on July 19, 2017\",\"civil\": \"9:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"83\", \"metric\": \"28\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"72\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"10\",\n" +
                "\t\t\"wspd\": {\"english\": \"1\", \"metric\": \"2\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"WSW\", \"degrees\": \"243\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"2\",\n" +
                "\t\t\"humidity\": \"70\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"4\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.06\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"10\",\"hour_padded\": \"10\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500472800\",\"pretty\": \"10:00 AM EDT on July 19, 2017\",\"civil\": \"10:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"85\", \"metric\": \"29\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"72\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"10\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SSW\", \"degrees\": \"194\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"4\",\n" +
                "\t\t\"humidity\": \"65\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"5\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.06\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"11\",\"hour_padded\": \"11\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500476400\",\"pretty\": \"11:00 AM EDT on July 19, 2017\",\"civil\": \"11:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"88\", \"metric\": \"31\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"72\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"6\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SSW\", \"degrees\": \"193\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"7\",\n" +
                "\t\t\"humidity\": \"58\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"94\", \"metric\": \"34\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"94\", \"metric\": \"34\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"7\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.05\", \"metric\": \"1018\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"12\",\"hour_padded\": \"12\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500480000\",\"pretty\": \"12:00 PM EDT on July 19, 2017\",\"civil\": \"12:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"11\",\n" +
                "\t\t\"wspd\": {\"english\": \"3\", \"metric\": \"5\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"S\", \"degrees\": \"175\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"9\",\n" +
                "\t\t\"humidity\": \"53\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"96\", \"metric\": \"36\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"96\", \"metric\": \"36\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"4\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.04\", \"metric\": \"1017\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"13\",\"hour_padded\": \"13\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500483600\",\"pretty\": \"1:00 PM EDT on July 19, 2017\",\"civil\": \"1:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"92\", \"metric\": \"33\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"70\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"22\",\n" +
                "\t\t\"wspd\": {\"english\": \"4\", \"metric\": \"6\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"S\", \"degrees\": \"185\"},\n" +
                "\t\t\"wx\": \"Mostly Sunny\",\n" +
                "\t\t\"uvi\": \"10\",\n" +
                "\t\t\"humidity\": \"49\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"24\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.02\", \"metric\": \"1017\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"14\",\"hour_padded\": \"14\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500487200\",\"pretty\": \"2:00 PM EDT on July 19, 2017\",\"civil\": \"2:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"91\", \"metric\": \"33\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"70\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Partly Cloudy\",\n" +
                "\t\t\"icon\": \"partlycloudy\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\n" +
                "\t\t\"fctcode\": \"2\",\n" +
                "\t\t\"sky\": \"31\",\n" +
                "\t\t\"wspd\": {\"english\": \"5\", \"metric\": \"8\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SSE\", \"degrees\": \"159\"},\n" +
                "\t\t\"wx\": \"Partly Cloudy\",\n" +
                "\t\t\"uvi\": \"9\",\n" +
                "\t\t\"humidity\": \"50\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"24\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.01\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"15\",\"hour_padded\": \"15\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500490800\",\"pretty\": \"3:00 PM EDT on July 19, 2017\",\"civil\": \"3:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"92\", \"metric\": \"33\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"70\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Partly Cloudy\",\n" +
                "\t\t\"icon\": \"partlycloudy\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\n" +
                "\t\t\"fctcode\": \"2\",\n" +
                "\t\t\"sky\": \"50\",\n" +
                "\t\t\"wspd\": {\"english\": \"6\", \"metric\": \"10\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SSE\", \"degrees\": \"155\"},\n" +
                "\t\t\"wx\": \"Partly Cloudy\",\n" +
                "\t\t\"uvi\": \"7\",\n" +
                "\t\t\"humidity\": \"49\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"15\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.99\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"16\",\"hour_padded\": \"16\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500494400\",\"pretty\": \"4:00 PM EDT on July 19, 2017\",\"civil\": \"4:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"91\", \"metric\": \"33\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"70\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Partly Cloudy\",\n" +
                "\t\t\"icon\": \"partlycloudy\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\n" +
                "\t\t\"fctcode\": \"2\",\n" +
                "\t\t\"sky\": \"38\",\n" +
                "\t\t\"wspd\": {\"english\": \"7\", \"metric\": \"11\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SSE\", \"degrees\": \"155\"},\n" +
                "\t\t\"wx\": \"Partly Cloudy\",\n" +
                "\t\t\"uvi\": \"5\",\n" +
                "\t\t\"humidity\": \"49\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"15\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.98\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"17\",\"hour_padded\": \"17\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500498000\",\"pretty\": \"5:00 PM EDT on July 19, 2017\",\"civil\": \"5:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"91\", \"metric\": \"33\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"69\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Partly Cloudy\",\n" +
                "\t\t\"icon\": \"partlycloudy\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\n" +
                "\t\t\"fctcode\": \"2\",\n" +
                "\t\t\"sky\": \"40\",\n" +
                "\t\t\"wspd\": {\"english\": \"7\", \"metric\": \"11\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SSE\", \"degrees\": \"157\"},\n" +
                "\t\t\"wx\": \"Partly Cloudy\",\n" +
                "\t\t\"uvi\": \"3\",\n" +
                "\t\t\"humidity\": \"48\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"15\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.97\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"18\",\"hour_padded\": \"18\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500501600\",\"pretty\": \"6:00 PM EDT on July 19, 2017\",\"civil\": \"6:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"91\", \"metric\": \"33\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"69\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"14\",\n" +
                "\t\t\"wspd\": {\"english\": \"6\", \"metric\": \"10\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SSE\", \"degrees\": \"150\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"1\",\n" +
                "\t\t\"humidity\": \"49\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"97\", \"metric\": \"36\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"0\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.96\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"19\",\"hour_padded\": \"19\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500505200\",\"pretty\": \"7:00 PM EDT on July 19, 2017\",\"civil\": \"7:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"91\", \"metric\": \"33\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"68\", \"metric\": \"20\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"8\",\n" +
                "\t\t\"wspd\": {\"english\": \"4\", \"metric\": \"6\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SSE\", \"degrees\": \"163\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"48\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"95\", \"metric\": \"35\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"95\", \"metric\": \"35\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"1\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.96\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"20\",\"hour_padded\": \"20\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500508800\",\"pretty\": \"8:00 PM EDT on July 19, 2017\",\"civil\": \"8:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"69\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"10\",\n" +
                "\t\t\"wspd\": {\"english\": \"3\", \"metric\": \"5\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SSW\", \"degrees\": \"196\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"51\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"95\", \"metric\": \"35\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"95\", \"metric\": \"35\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"3\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.97\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"21\",\"hour_padded\": \"21\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500512400\",\"pretty\": \"9:00 PM EDT on July 19, 2017\",\"civil\": \"9:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"88\", \"metric\": \"31\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"70\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"6\",\n" +
                "\t\t\"wspd\": {\"english\": \"3\", \"metric\": \"5\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"S\", \"degrees\": \"180\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"56\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"93\", \"metric\": \"34\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"93\", \"metric\": \"34\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"3\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.98\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"22\",\"hour_padded\": \"22\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500516000\",\"pretty\": \"10:00 PM EDT on July 19, 2017\",\"civil\": \"10:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"86\", \"metric\": \"30\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"70\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"9\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"SW\", \"degrees\": \"225\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"58\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"4\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.99\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"23\",\"hour_padded\": \"23\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"19\",\"mday_padded\": \"19\",\"yday\": \"199\",\"isdst\": \"1\",\"epoch\": \"1500519600\",\"pretty\": \"11:00 PM EDT on July 19, 2017\",\"civil\": \"11:00 PM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Wednesday\",\"weekday_name_night\": \"Wednesday Night\",\"weekday_name_abbrev\": \"Wed\",\"weekday_name_unlang\": \"Wednesday\",\"weekday_name_night_unlang\": \"Wednesday Night\",\"ampm\": \"PM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"85\", \"metric\": \"29\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"70\", \"metric\": \"21\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"7\",\n" +
                "\t\t\"wspd\": {\"english\": \"1\", \"metric\": \"2\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"WSW\", \"degrees\": \"254\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"61\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"88\", \"metric\": \"31\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"88\", \"metric\": \"31\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"4\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.0\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"0\",\"hour_padded\": \"00\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500523200\",\"pretty\": \"12:00 AM EDT on July 20, 2017\",\"civil\": \"12:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"84\", \"metric\": \"29\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"11\",\n" +
                "\t\t\"wspd\": {\"english\": \"1\", \"metric\": \"2\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"WSW\", \"degrees\": \"257\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"65\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"5\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.0\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"1\",\"hour_padded\": \"01\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500526800\",\"pretty\": \"1:00 AM EDT on July 20, 2017\",\"civil\": \"1:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"83\", \"metric\": \"28\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"17\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"WSW\", \"degrees\": \"257\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"67\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"5\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.99\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"2\",\"hour_padded\": \"02\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500530400\",\"pretty\": \"2:00 AM EDT on July 20, 2017\",\"civil\": \"2:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"82\", \"metric\": \"28\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"13\",\n" +
                "\t\t\"wspd\": {\"english\": \"3\", \"metric\": \"5\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"W\", \"degrees\": \"273\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"70\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"6\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.99\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"3\",\"hour_padded\": \"03\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500534000\",\"pretty\": \"3:00 AM EDT on July 20, 2017\",\"civil\": \"3:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"82\", \"metric\": \"28\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"72\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"10\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"W\", \"degrees\": \"281\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"71\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"5\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.98\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"4\",\"hour_padded\": \"04\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500537600\",\"pretty\": \"4:00 AM EDT on July 20, 2017\",\"civil\": \"4:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"82\", \"metric\": \"28\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"72\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"6\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"WNW\", \"degrees\": \"287\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"72\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"87\", \"metric\": \"31\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"6\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.97\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"5\",\"hour_padded\": \"05\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500541200\",\"pretty\": \"5:00 AM EDT on July 20, 2017\",\"civil\": \"5:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"81\", \"metric\": \"27\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"6\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"NW\", \"degrees\": \"308\"},\n" +
                "\t\t\"wx\": \"Clear\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"72\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"85\", \"metric\": \"29\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"85\", \"metric\": \"29\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"6\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.97\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"6\",\"hour_padded\": \"06\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500544800\",\"pretty\": \"6:00 AM EDT on July 20, 2017\",\"civil\": \"6:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"80\", \"metric\": \"27\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"4\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"NW\", \"degrees\": \"324\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"73\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"85\", \"metric\": \"29\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"80\", \"metric\": \"27\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"6\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.97\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"7\",\"hour_padded\": \"07\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500548400\",\"pretty\": \"7:00 AM EDT on July 20, 2017\",\"civil\": \"7:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"81\", \"metric\": \"27\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"7\",\n" +
                "\t\t\"wspd\": {\"english\": \"2\", \"metric\": \"3\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"NW\", \"degrees\": \"324\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"0\",\n" +
                "\t\t\"humidity\": \"71\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"85\", \"metric\": \"29\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"85\", \"metric\": \"29\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"5\",\n" +
                "\t\t\"mslp\": {\"english\": \"29.98\", \"metric\": \"1015\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"8\",\"hour_padded\": \"08\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500552000\",\"pretty\": \"8:00 AM EDT on July 20, 2017\",\"civil\": \"8:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"84\", \"metric\": \"29\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"5\",\n" +
                "\t\t\"wspd\": {\"english\": \"4\", \"metric\": \"6\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"NNW\", \"degrees\": \"328\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"1\",\n" +
                "\t\t\"humidity\": \"67\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"90\", \"metric\": \"32\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"3\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.0\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"9\",\"hour_padded\": \"09\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500555600\",\"pretty\": \"9:00 AM EDT on July 20, 2017\",\"civil\": \"9:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"86\", \"metric\": \"30\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"11\",\n" +
                "\t\t\"wspd\": {\"english\": \"4\", \"metric\": \"6\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"NNW\", \"degrees\": \"327\"},\n" +
                "\t\t\"wx\": \"Sunny\",\n" +
                "\t\t\"uvi\": \"2\",\n" +
                "\t\t\"humidity\": \"61\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"92\", \"metric\": \"33\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"92\", \"metric\": \"33\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"2\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.0\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t\t,\n" +
                "\t\t{\n" +
                "\t\t\"FCTTIME\": {\n" +
                "\t\t\"hour\": \"10\",\"hour_padded\": \"10\",\"min\": \"00\",\"min_unpadded\": \"0\",\"sec\": \"0\",\"year\": \"2017\",\"mon\": \"7\",\"mon_padded\": \"07\",\"mon_abbrev\": \"Jul\",\"mday\": \"20\",\"mday_padded\": \"20\",\"yday\": \"200\",\"isdst\": \"1\",\"epoch\": \"1500559200\",\"pretty\": \"10:00 AM EDT on July 20, 2017\",\"civil\": \"10:00 AM\",\"month_name\": \"July\",\"month_name_abbrev\": \"Jul\",\"weekday_name\": \"Thursday\",\"weekday_name_night\": \"Thursday Night\",\"weekday_name_abbrev\": \"Thu\",\"weekday_name_unlang\": \"Thursday\",\"weekday_name_night_unlang\": \"Thursday Night\",\"ampm\": \"AM\",\"tz\": \"\",\"age\": \"\",\"UTCDATE\": \"\"\n" +
                "\t\t},\n" +
                "\t\t\"temp\": {\"english\": \"89\", \"metric\": \"32\"},\n" +
                "\t\t\"dewpoint\": {\"english\": \"71\", \"metric\": \"22\"},\n" +
                "\t\t\"condition\": \"Clear\",\n" +
                "\t\t\"icon\": \"clear\",\n" +
                "\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\n" +
                "\t\t\"fctcode\": \"1\",\n" +
                "\t\t\"sky\": \"22\",\n" +
                "\t\t\"wspd\": {\"english\": \"4\", \"metric\": \"6\"},\n" +
                "\t\t\"wdir\": {\"dir\": \"NW\", \"degrees\": \"317\"},\n" +
                "\t\t\"wx\": \"Mostly Sunny\",\n" +
                "\t\t\"uvi\": \"4\",\n" +
                "\t\t\"humidity\": \"55\",\n" +
                "\t\t\"windchill\": {\"english\": \"-9999\", \"metric\": \"-9999\"},\n" +
                "\t\t\"heatindex\": {\"english\": \"96\", \"metric\": \"36\"},\n" +
                "\t\t\"feelslike\": {\"english\": \"96\", \"metric\": \"36\"},\n" +
                "\t\t\"qpf\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"snow\": {\"english\": \"0.0\", \"metric\": \"0\"},\n" +
                "\t\t\"pop\": \"1\",\n" +
                "\t\t\"mslp\": {\"english\": \"30.0\", \"metric\": \"1016\"}\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        try {
            JSONObject jsonRootObject = new JSONObject(weatherJson);
            JSONArray hourlyForecastArray = jsonRootObject.optJSONArray("hourly_forecast");
            for (int i = 0; i < hourlyForecastArray.length(); i++) {
                JSONObject forecast = hourlyForecastArray.getJSONObject(i);
                JSONObject time = forecast.getJSONObject("FCTTIME");
                dateDay = time.getString("mon_abbrev") + " " + time.getString("mday")
                        + " " + time.getString("year") + " " + time.getString("weekday_name");
                String hour = time.getString("civil");
                Double tempMetric = forecast.optJSONObject("temp").getDouble("metric");
                String condition = forecast.getString("condition");
                hourlyForecasts.add(new HourlyWeather(condition, tempMetric, hour));
            }
            /*for (Iterator<String>iter = jsonRootObject.keys(); iter.hasNext();) {
                String key = iter.next();
                if (key.equalsIgnoreCase("FCTTIME")) {
                    JSONObject
                }
            }*/
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //hourlyForecasts.add(new HourlyWeather("Sunny", 20.0, "1:00 AM"));

        HourlyWeatherAdapter hourlyWeatherAdapter = new HourlyWeatherAdapter(this, hourlyForecasts);
        ListView listView = (ListView) findViewById(R.id.hourly_list_view);
        View header = getLayoutInflater().inflate(R.layout.date_day_header_list_view, listView, false);
        TextView dayDateTextView = (TextView) header.findViewById(R.id.date_day_text_view);
        dayDateTextView.setText(dateDay);
        listView.addHeaderView(header);
        listView.setAdapter(hourlyWeatherAdapter);
    }
}
