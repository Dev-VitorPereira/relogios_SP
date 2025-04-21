package com.relogios.relogios_SP.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
public class Relogio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberRelogio;
    private String addressRelogio;
    private double longitude;
    private double latitude;

    public Relogio(Long id, int i, String s, double longitude, double latitude) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberRelogio() {
        return numberRelogio;
    }

    public void setNumberRelogio(int numberRelogio) {
        this.numberRelogio = numberRelogio;
    }

    public String getAddressRelogio() {
        return addressRelogio;
    }

    public void setAddressRelogio(String addressRelogio) {
        this.addressRelogio = addressRelogio;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
