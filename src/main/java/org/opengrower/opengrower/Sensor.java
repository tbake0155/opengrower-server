package org.opengrower.opengrower;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Calendar;
import java.util.Date;

public class Sensor {
    @Id
    private String id;
    @Indexed
    private String name;
    private Date creationDate;
    private Date latestReadingDate;
    private String state;

    public Sensor(String name) {
        this.name = name;
        this.creationDate = Calendar.getInstance().getTime();
        this.latestReadingDate = Calendar.getInstance().getTime();
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCreationDate(Date creationDate) {this.creationDate = creationDate; }
    public void setLatestReadingDate(Date latestReadingDate) {
        this.latestReadingDate = latestReadingDate;
    }
    public void setState(String state) {this.state = state; }
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public Date getCreationDate() {
        return this.creationDate;
    }
    public Date getLatestReadingDate() {return this.latestReadingDate; }

    public String getState() {return this.state; }

    @Override
    public String toString() {
        return String.format(
                "Sensor[id='%s', name='%s', creationDate='%s', " +
                        "state='%s', latestReadingDate='%s']",
                id, name, creationDate, state, latestReadingDate);
    }

}
