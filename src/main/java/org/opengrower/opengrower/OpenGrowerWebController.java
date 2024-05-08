package org.opengrower.opengrower;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class OpenGrowerWebController {
    private final SensorMeasurementRepository sensorMeasurementRepository;
    private final SensorRepository sensorRepository;

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    OpenGrowerWebController(SensorMeasurementRepository sensorMeasurementRepository, SensorRepository sensorRepository) {
        this.sensorMeasurementRepository = sensorMeasurementRepository;
        this.sensorRepository = sensorRepository;
    }

    @GetMapping("/sensors")
    public String sensors(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        final List<Sensor> sensors = sensorRepository.findAll();
        final List<String> sensorNames = new ArrayList<>();
        for(final Sensor sensor : sensors) {
            sensorNames.add(sensor.getName());
        }
        model.addAttribute("sensors", sensorNames);
        return "sensors";
    }

    @GetMapping("/health")
    public String health(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        final List<Sensor> sensors = sensorRepository.findAll();
        final List<String> sensorStates = new ArrayList<>();
        for(final Sensor sensor : sensors) {
            Date now = Calendar.getInstance().getTime();
            long millisSinceLastReading = now.getTime() - sensor.getLatestReadingDate().getTime();
            double minutesSinceLastReading = millisSinceLastReading / 1000.0 / 60.0;
            long millisSinceLastUpdate = now.getTime() - sensorMeasurementRepository
                    .findFirstBySensorOrderByTimeStampDesc(sensor.getName()).getTimeStamp().getTime();
            double minutesSinceLastUpdate = millisSinceLastUpdate / 1000.0 / 60.0;
            String state = sensor.getName() + " " +
                    "minutes since latest irrigation controller check: " + decimalFormat.format(minutesSinceLastReading) + " " +
                    "minutes since latest sensor reading update: " + decimalFormat.format(minutesSinceLastUpdate);
            sensorStates.add(state);
        }
        model.addAttribute("sensorStates", sensorStates);
        return "health";
    }
}