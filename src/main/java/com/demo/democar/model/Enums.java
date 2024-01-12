package com.demo.democar.model;

public interface Enums {

  public static enum EnumPriceType {
    RANGE_0_5(1),
    RANGE_5_10(2),
    RANGE_GT_10(3);

    private Integer type;

    EnumPriceType(Integer v) {
      this.type = v;
    }

    public Integer getType() {
      return type;
    }
  }

  public static enum EnumAgeType {
    RANGE_0_1(1),
    RANGE_1_3(2),
    RANGE_3_5(3),
    RANGE_GT_5(4);

    private Integer type;

    EnumAgeType(Integer v) {
      this.type = v;
    }

    public Integer getType() {
      return type;
    }
  }

  public static enum EnumAPowerSupplyType {
    GASOLINE("G"),
    DIESEL("D"),
    ELECTRIC("E");

    private String type;

    EnumAPowerSupplyType(String v) {
      this.type = v;
    }

    public String getType() {
      return type;
    }
  }


}
