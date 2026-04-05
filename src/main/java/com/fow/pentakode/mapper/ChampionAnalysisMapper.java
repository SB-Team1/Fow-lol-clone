package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.ChampionAnalysisDto;
import com.fow.pentakode.entity.ChampionAnalysis;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface ChampionAnalysisMapper {

  ChampionAnalysis toEntity(ChampionAnalysisDto championAnalysisDto);

  ChampionAnalysisDto toDto(ChampionAnalysis championAnalysis);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  ChampionAnalysis partialUpdate(
      ChampionAnalysisDto championAnalysisDto, @MappingTarget ChampionAnalysis championAnalysis);
}
