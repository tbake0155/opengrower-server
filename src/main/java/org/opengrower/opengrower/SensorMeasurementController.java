package org.opengrower.opengrower;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class SensorMeasurementController {
    private final SensorMeasurementRepository sensorMeasurementRepository;

    private final SensorRepository sensorRepository;

    SensorMeasurementController(SensorMeasurementRepository sensorMeasurementRepository, SensorRepository sensorRepository) {
            this.sensorMeasurementRepository = sensorMeasurementRepository;
            this.sensorRepository = sensorRepository;
        }

        @PostMapping("/measurement")
        SensorMeasurement createSensorMeasurement(@RequestBody SensorMeasurement measurement) {
            SensorMeasurement sensorMeasurement = new SensorMeasurement(measurement);
            if(sensorRepository.findDistinctByName(sensorMeasurement.getSensor()) == null) {
                sensorRepository.save(new Sensor(sensorMeasurement.getSensor()));
            }
            return sensorMeasurementRepository.save(sensorMeasurement);
        }

        @GetMapping("/measurements/{sensor}")
        List<SensorMeasurement> getSensorMeasurements(@PathVariable String sensor) {
            return sensorMeasurementRepository.findBySensor(sensor);
        }

        @GetMapping("/measurements/latest10/{sensor}")
        List<SensorMeasurement> getLatest10SensorMeasurements(@PathVariable String sensor) {
            return sensorMeasurementRepository.findFirst10BySensorOrderByTimeStampDesc(sensor);
        }
        @GetMapping("/measurements/latest100/{sensor}")
            List<SensorMeasurement> getLatest100SensorMeasurements(@PathVariable String sensor) {
            return sensorMeasurementRepository.findFirst100BySensorOrderByTimeStampDesc(sensor);
        }

    }
