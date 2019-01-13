package periodic;


import com.mycompany.test9.Pogoda;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class Weather {
    
    public double lat, lon;
    
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
        System.out.println("LOGGING SINGLETON Weather");
        Date date = new Date();

        System.out.println(date.toString());
        
        System.out.println("lat = " + lat + " lon = " + lon);
        String a1 = Util.getData(Double.toString(lat), Double.toString(lon));

        Pogoda p1=null;
        try {
            p1 = Util.parse_store(a1);
            facade.create(p1);
        } catch (Exception e) {

        }        

    }
}
