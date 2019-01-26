/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodic;

import events.CoordsQualifier;
import events.RestEvent;
import java.io.Serializable;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author root
 */
@ManagedBean
//@SessionScoped
@RequestScoped
public class CoordsBean implements Serializable {

    double lat, lon;

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

    @Inject
    @CoordsQualifier
    Event<RestEvent> coordsEvent;

    public void setCoords() {
        FacesMessage msg;
        if (lat != 0 || lon != 0) {
            String out = lat + " " + lon;
            msg = new FacesMessage("Selected", out);

            RestEvent event = new RestEvent(lat, lon, null);
            coordsEvent.fire(event);

        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Coords is not selected.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

}
