package ch.squix.sentimento.rest.sensordata;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import ch.squix.sentimento.model.sensordata.SensorData;


public class SensorResource extends ServerResource {

    private static final Logger logger = Logger.getLogger(SensorResource.class.getName());

    @Get(value = "json")
    public String execute() {
        List<SensorData> sensorValues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String sensorIdText = (String) this.getQueryValue("id" + i);
            String valueText = (String) this.getQueryValue("value" + i);
            if (sensorIdText == null || valueText == null) {
                break;
            }
            SensorData sensorData = new SensorData();
            sensorData.setSensorId(Long.valueOf(sensorIdText));
            sensorData.setValue(Double.valueOf(valueText));
            sensorData.setTimestamp(new Date());
            sensorValues.add(sensorData);
        }
        logger.info("Received " + sensorValues.size() + " values by GET");
        if (sensorValues.size() > 0) {
            ofy().save().entities(sensorValues);
        }
        return "Saved " + sensorValues.size() + " values";
    }

}
