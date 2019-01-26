package grabber;

import java.io.Serializable;
//import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import grabber.impl.CoordsGrabber;
import grabber.impl.CityGrabber;
import javax.faces.bean.SessionScoped;

@SessionScoped
public class GrabberFactory implements Serializable {

    @Produces
    @GrabberTransport(GrabberTransportType.COORDS)
    public Grabber getCoordsGrabber(CoordsGrabber emailMessageSender) {
        return emailMessageSender;
    }

    @Produces
    @GrabberTransport(GrabberTransportType.CITY)
    public Grabber getCityGrabber() {
        return new CityGrabber();
    }

}
