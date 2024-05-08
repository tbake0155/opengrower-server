package org.opengrower.opengrower;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SensorMeasurementRepository extends MongoRepository<SensorMeasurement, String> {
    public List<SensorMeasurement> findBySensor(String sensor);
    public SensorMeasurement findFirstBySensorOrderByTimeStampDesc(String sensor);
    public List<SensorMeasurement> findFirst10BySensorOrderByTimeStampDesc(String Sensor);
    public List<SensorMeasurement> findFirst100BySensorOrderByTimeStampDesc(String Sensor);
}