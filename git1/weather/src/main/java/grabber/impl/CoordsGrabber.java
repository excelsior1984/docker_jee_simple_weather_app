package grabber.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import grabber.Grabber;
import javax.enterprise.context.Dependent;

/**
 *
 * @author root
 */
@Dependent
public class CoordsGrabber implements Grabber {

    @Override
    public String getData(double lat, double lon, String object) {
        Client client = ClientBuilder.newClient();
        StringBuilder sb = new StringBuilder();
        sb.append("http://api.openweathermap.org/data/2.5/weather?APPID=55cba00e08c109668531fdc82a82bb2b&lat=");
        sb.append(lat);
        sb.append("&lon=");
        sb.append(lon);
        sb.append("&units=metric");
        WebTarget target = null;
        try {
            target = client.target(sb.toString());
        } catch (Exception e) {
            System.out.println("Exeption = " + e);
        }
        return target.request().get(String.class);
    }

}
