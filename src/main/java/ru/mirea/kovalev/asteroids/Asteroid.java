package ru.mirea.kovalev.asteroids;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Asteroid {

    @JsonProperty("designation")
    private String designation;

    @JsonProperty("discovery_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime discovery_date;


    public Asteroid() {
    }

    public Asteroid(String designation, LocalDateTime discovery_date) {
        this.designation = designation;
        this.discovery_date = discovery_date;
    }

    public String getDesignation() {
        return designation;
    }

    public LocalDateTime getDiscovery_date() {
        return discovery_date;
    }

    @Override
    public String toString() {
        return "Asteroids{" +
                "designation=" + designation +
                ", discovery_date='" + discovery_date +
                '}';
    }
}
