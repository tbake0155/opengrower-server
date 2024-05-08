package org.opengrower.opengrower;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Calendar;
import java.util.Date;

public class SensorMeasurement {

    @Id
    private String id;
    @Indexed
    private String sensor;
    private Double moisture;
    private Double temperature;
    private Double light;
    public Date timeStamp;

    public SensorMeasurement(){}

    public SensorMeasurement(String sensor, Double moisture, Double temperature, Double humidity,
                           Double light) {
        this.sensor = sensor;
        this.moisture = moisture;
        this.temperature = temperature;
        this.light = light;
        this.timeStamp = Calendar.getInstance().getTime();
    }

    public SensorMeasurement(SensorMeasurement sensorMeasurement) {
        this.id = sensorMeasurement.getId();
        this.sensor = sensorMeasurement.getSensor();
        this.moisture = sensorMeasurement.getMoisture();
        this.temperature = sensorMeasurement.getTemperature();
        this.light = sensorMeasurement.getLight();
        this.timeStamp = Calendar.getInstance().getTime();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public void setMoisture(Double moisture) {
        this.moisture = moisture;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setLight(Double light) {
        this.light = light;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getId() {
        return this.id;
    }

    public String getSensor() {
        return this.sensor;
    }

    public Double getMoisture() {
        return this.moisture;
    }

    public Double getTemperature() {
        return this.temperature;
    }

    public Double getLight() {
        return this.light;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public String toString() {
        return String.format(
                "SensorMasurement[id=%s, sensor='%s', moisture='%s', temperature='%s', " +
                        "light='%s', timeStamp='%s']",
                id, sensor, moisture, temperature, light, timeStamp);
    }

}