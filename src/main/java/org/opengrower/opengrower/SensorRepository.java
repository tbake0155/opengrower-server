package org.opengrower.opengrower;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface SensorRepository extends MongoRepository<Sensor, String> {
        Sensor findDistinctByName(String sensor);
}
