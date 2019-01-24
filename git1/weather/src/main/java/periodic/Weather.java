package periodic;


import com.mycompany.test9.Pogoda;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class Weather {
    
    public double lat, lon;

    public String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
//        this.lat = 0;
//        this.lon = 0;
    }
    
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
    
    @EJB
    private com.mycompany.test9.PogodaFacade facade;

    @Schedule(hour = "*", minute = "*/1", persistent = false)
    public void log() {
//        System.out.println("LOGGING SINGLETON Weather");
        Date date = new Date();
        System.out.println(date.toString());

        Pogoda p1=null;
        String a1;

        try {
        if(lat == 0 && lon == 0 && city != null) {
            System.out.println("city = " + city);
            System.out.println("lat = " + lat + " lon = " + lon);
            a1 = Util.getData2(city);
        } else {
            System.out.println("city = " + city);
            System.out.println("lat = " + lat + " lon = " + lon);
            a1 = Util.getData(Double.toString(lat), Double.toString(lon));
        }
        

            p1 = Util.parse_store(a1);
            facade.create(p1);
        } catch (Exception e) {

        }        

    }
}
