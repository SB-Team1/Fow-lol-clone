package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.SummonerDto;
import com.fow.pentakode.entity.Summoner;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface SummonerMapper {

  Summoner toEntity(SummonerDto summonerDto);

  SummonerDto toDto(Summoner summoner);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Summoner partialUpdate(
      SummonerDto summonerDto, @MappingTarget Summoner summoner);
}
