package ch.squix.sentimento.rest;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import ch.squix.sentimento.model.sensordata.SensorData;
import ch.squix.sentimento.rest.ping.PingResource;
import ch.squix.sentimento.rest.sensordata.SensorResource;

import com.googlecode.objectify.ObjectifyService;

public class RestApplication extends Application {

    static {
        ObjectifyService.register(SensorData.class);
        // ObjectifyService.register(SpeakerRate.class);
        // ObjectifyService.register(Highscore.class);
    }

    @Override
    public Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
        Router router = new Router(getContext());
        router.attach("/ping", PingResource.class);
        router.attach("/sensor", SensorResource.class);

        return router;
    }

}
