package com.demo.democar.dto;

import com.opencsv.bean.CsvBindByPosition;

public class CsvDTO {

    @CsvBindByPosition(position = 0)
    private String brand;
    @CsvBindByPosition(position = 1)
    private String model;
    @CsvBindByPosition(position = 2)
    private String powerType;
    @CsvBindByPosition(position = 3)
    private String priceType;
    @CsvBindByPosition(position = 4)
    private String ageType;
    @CsvBindByPosition(position = 5)
    private String is4wd;
    @CsvBindByPosition(position = 6)
    private String isAutomatic;

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

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    public String getIs4wd() {
        return is4wd;
    }

    public void setIs4wd(String is4wd) {
        this.is4wd = is4wd;
    }

    public String getIsAutomatic() {
        return isAutomatic;
    }

    public void setIsAutomatic(String isAutomatic) {
        this.isAutomatic = isAutomatic;
    }
}
