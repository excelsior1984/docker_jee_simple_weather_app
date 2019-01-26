/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodic;

import com.mycompany.test9.Pogoda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author root
 */
public class Util {

    public static Pogoda parse_store(String json) throws JSONException {

        String parsedResult = "";

        JSONObject jsonObject = new JSONObject(json);

        parsedResult += "Number of object = " + jsonObject.length() + "\n\n";

        //"coord"
        JSONObject JSONObject_coord = jsonObject.getJSONObject("coord");
        Double result_lon = JSONObject_coord.getDouble("lon");
        Double result_lat = JSONObject_coord.getDouble("lat");

        //"weather"
        String result_weather;
        JSONArray JSONArray_weather = jsonObject.getJSONArray("weather");

        //"main"
        JSONObject JSONObject_main = jsonObject.getJSONObject("main");
        Double result_temp = JSONObject_main.getDouble("temp");
        Double result_pressure = JSONObject_main.getDouble("pressure");
        Double result_humidity = JSONObject_main.getDouble("humidity");
        Double result_temp_min = JSONObject_main.getDouble("temp_min");
        Double result_temp_max = JSONObject_main.getDouble("temp_max");

        //"wind"
        JSONObject JSONObject_wind = jsonObject.getJSONObject("wind");
        Double result_speed = JSONObject_wind.getDouble("speed");
        //Double result_gust = JSONObject_wind.getDouble("gust");
        Double result_deg = JSONObject_wind.getDouble("deg");
        String result_wind = "wind\tspeed: " + result_speed + "\tdeg: " + result_deg;

        //"name"
        String result_name = jsonObject.getString("name");

        Pogoda pog = new Pogoda();
        pog.setLat(result_lat);
        pog.setLon(result_lon);
        pog.setTemp(result_temp);
        pog.setTempmin(result_temp_min);
        pog.setTempmax(result_temp_max);
        pog.setHumidity(result_humidity);
        pog.setPressure(result_pressure);
        pog.setSpeed(result_speed);
        pog.setDeg(result_deg);
        pog.setName(result_name);

        return pog;

    }
}
