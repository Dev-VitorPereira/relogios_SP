package com.relogios.relogios_SP.model;

import jakarta.persistence.*;

@Entity
@Table(name = "relogios")
public class Relogio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numberRelogio")
    private String numberRelogio;

    @Column(name = "addressRelogio", columnDefinition = "TEXT")
    private String addressRelogio;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    public Relogio() {
    }

    public Relogio(Long id, String numberRelogio, String addressRelogio, String longitude, String latitude) {
        this.id = id;
        this.numberRelogio = numberRelogio;
        this.addressRelogio = addressRelogio;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    // getters e setters abaixo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberRelogio() {
        return numberRelogio;
    }

    public void setNumberRelogio(String numberRelogio) {
        this.numberRelogio = numberRelogio;
    }

    public String getAddressRelogio() {
        return addressRelogio;
    }

    public void setAddressRelogio(String addressRelogio) {
        this.addressRelogio = addressRelogio;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
