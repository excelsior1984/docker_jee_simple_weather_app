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
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import periodic.Weather;

@ManagedBean
@ViewScoped
//@RequestScoped
public class Miasto {

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

        cities2 = new HashMap<String, String>();

        cities2.put("Warszawa", "warsaw");
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
            msg = new FacesMessage("Selected", city);
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
