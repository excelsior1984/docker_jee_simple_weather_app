package periodic;

import grabber.GrabberTransportType;
import com.mycompany.test9.Pogoda;
import events.CityQualifier;
import events.CoordsQualifier;
import events.RestEvent;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import grabber.Grabber;
import grabber.GrabberTransport;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;

@Singleton
@Startup
public class WeatherLogger {
    
    public double lat, lon;

    public String city;

    @EJB
    private com.mycompany.test9.PogodaFacade facade;

    @PostConstruct
    void init() {
        this.lat = 0;
        this.lon = 0;
        this.city = null;
    }
    
    public void coordsChanged(@Observes @CoordsQualifier RestEvent event) {
        this.lat = event.lat;
        this.lon = event.lon;
        this.city = event.city;
    }

    public void cityChanged(@Observes @CityQualifier RestEvent event) {
        this.lat = event.lat;
        this.lon = event.lon;
        this.city = event.city;
    }

    @Inject
    @GrabberTransport(GrabberTransportType.CITY)
    private Grabber citySender;

    @Inject
    @GrabberTransport(GrabberTransportType.COORDS)
    private Grabber coordsSender;

    @Schedule(hour = "*", minute = "*/1", persistent = false)
    public void log() {
        Pogoda p1 = null;
        String a1;

        try {
            if (lat == 0 && lon == 0 && city != null) {
                a1 = citySender.getData(0, 0, city);
                System.out.println(a1);
            } else {
                a1 = coordsSender.getData(lat, lon, null);
                System.out.println(a1);
            }
              p1 = Util.parse_store(a1);
              facade.create(p1);
        } catch (Exception e) {

        }

    }
}
