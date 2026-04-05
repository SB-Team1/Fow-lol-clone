package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.ChampionDto;
import com.fow.pentakode.entity.Champion;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface ChampionMapper {

  Champion toEntity(ChampionDto championDto);

  ChampionDto toDto(Champion champion);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Champion partialUpdate(
      ChampionDto championDto, @MappingTarget Champion champion);
}
