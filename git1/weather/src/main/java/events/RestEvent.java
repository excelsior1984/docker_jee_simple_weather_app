/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author root
 */
public class RestEvent {
    public double lat;
    public double lon;
    public String city;

    public RestEvent(double lat, double lon, String city) {
        this.lat = lat;
        this.lon = lon;
        this.city = city;
    }
    
    
}
