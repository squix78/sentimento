package ch.squix.sentimento.model.sensordata;

import java.util.Date;

import lombok.Data;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
@Cache
@Data
public class SensorData {

    @Id
    private Long id;

    @Index
    private Long sensorId;

    @Index
    private Date timestamp;

    private Double value;


}
