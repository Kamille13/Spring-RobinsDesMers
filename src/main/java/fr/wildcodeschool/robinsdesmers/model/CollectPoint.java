package fr.wildcodeschool.robinsdesmers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CollectPoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String infoCollectPoint;

    @NotNull
    private Double latitude;

    @NotNull
    Double longitude;

    @NotNull
    String infoSup;

    @NotNull
    String date;

    @NotNull
    public boolean notHere;

    @NotNull
    String key;


    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private User user;

    public CollectPoint() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfoCollectPoint() {
        return infoCollectPoint;
    }

    public void setInfoCollectPoint(String infoCollectPoint) {
        this.infoCollectPoint = infoCollectPoint;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getInfoSup() {
        return infoSup;
    }

    public void setInfoSup(String infoSup) {
        this.infoSup = infoSup;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isNotHere() {
        return notHere;
    }

    public void setNotHere(boolean notHere) {
        this.notHere = notHere;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
