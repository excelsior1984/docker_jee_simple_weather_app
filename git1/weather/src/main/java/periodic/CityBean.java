package periodic;

import events.CityQualifier;
import events.RestEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
//@RequestScoped
public class CityBean implements Serializable {

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

    @Inject
    @CityQualifier
    Event<RestEvent> cityEvent;

    public void setCity() {

        FacesMessage msg;
        if (city != null) {
            msg = new FacesMessage("Selected", city);
            RestEvent event = new RestEvent(0, 0, cities2.get(city));            
            cityEvent.fire(event);
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
