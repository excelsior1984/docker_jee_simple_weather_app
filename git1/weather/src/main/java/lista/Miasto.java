/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import periodic.Weather;

@ManagedBean
@ViewScoped
public class Miasto {

//    Map<String, Double[]> coords;
    Map<String, String> cities2;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    List<String> cities;

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    @PostConstruct
    public void init() {

        cities = new ArrayList<String>();
        cities.add("Warszawa");
        cities.add("Kraków");
        cities.add("Łódź");
        cities.add("Wrocław");
        cities.add("Poznań");
        cities.add("Gdańsk");

//        coords = new HashMap<String, Double[]>();
//        coords.put("Warszawa", new Double[]{21.01, 52.23});
////        coords.put("Kraków", new Double[]{19.94,50.06});
////        coords.put("Kraków", new Double[]{19.92, 50.04});
//        coords.put("Łódź", new Double[]{19.46, 51.77});
//        coords.put("Wrocław", new Double[]{17.03, 51.11});
//        coords.put("Poznań", new Double[]{16.93, 52.41});
//        coords.put("Gdańsk", new Double[]{18.65, 54.35});

        cities2 = new HashMap<String,String>();

        cities2.put("Warszawa", "warsaw");
//        coords.put("Kraków", new Double[]{19.94,50.06});
        cities2.put("Kraków", "krakow");
        cities2.put("Łódź", "lodz");
        cities2.put("Wrocław", "wroclaw");
        cities2.put("Poznań", "poznan");
        cities2.put("Gdańsk", "gdansk");


    }

    @EJB
    Weather weather;

    public void doWork() {

        FacesMessage msg;
        if (city != null) {
//            String msg1 = "Selected = " + city + " lon = " + coords.get(city)[0] + " lat = " + coords.get(city)[1] ;
            msg = new FacesMessage("Selected", city);
//            msg = new FacesMessage(msg1);
//            System.out.println("Selected = " + city + " lon = " + coords.get(city)[0] + " lat = " + coords.get(city)[1]);
//            weather.setLat(coords.get(city)[1]);
//            weather.setLon(coords.get(city)[0]);
            weather.setLat(0);
            weather.setLon(0);
            System.out.println("getting city = " + cities2.get(city));
            weather.setCity(cities2.get(city));


        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
