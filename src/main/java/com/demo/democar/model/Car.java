package com.demo.democar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="CARS")

public class Car {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "PRICE_TYPE")
    private Integer priceType;

    @Column(name = "AGE_TYPE")
    private Integer ageType;

    @Column(name = "POWER_TYPE")
    private String powerType;

    @Column(name = "IS_4WD")
    private Boolean is4wd;

    @Column(name = "IS_AUTOMATIC")
    private Boolean isAutomatic;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public Integer getAgeType() {
        return ageType;
    }

    public void setAgeType(Integer ageType) {
        this.ageType = ageType;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    public Boolean getIs4wd() {
        return is4wd;
    }

    public void setIs4wd(Boolean is4wd) {
        this.is4wd = is4wd;
    }

    public Boolean getIsAutomatic() {

        return isAutomatic;
    }

    public void setIsAutomatic(Boolean automatic) {
        isAutomatic = automatic;
    }
}

