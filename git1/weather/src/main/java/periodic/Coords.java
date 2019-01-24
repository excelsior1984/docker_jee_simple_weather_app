/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodic;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author root
 */
@ManagedBean
//@SessionScoped
@RequestScoped
public class Coords implements Serializable{

    double lat, lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
//        weather.lat = lat;
weather.setCity(null);
        weather.setLat(lat);
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
//        weather.lon = lon;
weather.setCity(null);
        weather.setLon(lon);
    }
    
    public void showData(){
        System.out.println("LAT = " + lat + " LON = " + lon);
        weather.setCity(null);
        weather.setLon(lon);
        weather.setLat(lat);

    }
    
    @EJB
    Weather weather;

}
