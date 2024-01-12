package com.demo.democar.repository;

import com.demo.democar.dto.CarDTO;
import com.demo.democar.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Repository
public class CarFilterRepository {

  @Autowired
  private EntityManager em;

  public List<Car> cercaDaFilro(CarDTO dto ) {
    StringBuilder sb = new StringBuilder();

    sb.append("SELECT * FROM cars a WHERE a.ID IS NOT NULL");

    if (dto.getBrand() != null) {
      sb.append(" AND a.BRAND = '" + dto.getBrand() + "'");
    }
    if (dto.getModel() != null) {
      sb.append(" AND a.MODEL = '" + dto.getModel() + "'");
    }
    if (dto.getAgeType() != null) {
      sb.append(" AND a.AGE_TYPE = " + dto.getAgeType().toString());
    }
    if (dto.getPriceType() != null) {
      sb.append(" AND a.PRICE_TYPE = " + dto.getPriceType().toString());
    }
    if (dto.getPowerType() != null) {
      sb.append(" AND a.POWER_TYPE = '" + dto.getPowerType() + "'");
    }
    if (dto.getIs4wd()) {
      sb.append(" AND a.IS_4WD = 1");
    }
    if (dto.getIsAutomatic()) {
      sb.append(" AND a.IS_AUTOMATIC = 1");
    }

    Query q = em.createNativeQuery(sb.toString(),Car.class);


    List<Car> rs = (List<Car>) q.getResultList();

    return rs;
  }

}
