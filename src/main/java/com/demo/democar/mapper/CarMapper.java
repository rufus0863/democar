package com.demo.democar.mapper;

import com.demo.democar.dto.CarDTO;
import com.demo.democar.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

  CarMapper mapperInstance = Mappers.getMapper(CarMapper.class);

  CarDTO entityToDto(Car entity);
  Car dtoToEntity(CarDTO dto);


}
