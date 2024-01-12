package com.demo.democar.dto;

public class CarDTO {

    private Long id;
    private String brand;
    private String model;
    private Integer priceType;
    private Integer ageType;
    private String powerType;
    private Boolean is4wd = false;
    private Boolean isAutomatic = false;

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
