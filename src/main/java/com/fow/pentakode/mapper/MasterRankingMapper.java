package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.MasterRankingDto;
import com.fow.pentakode.entity.MasterRanking;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface MasterRankingMapper {

  MasterRanking toEntity(MasterRankingDto masterRankingDto);

  MasterRankingDto toDto(MasterRanking masterRanking);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  MasterRanking partialUpdate(
      MasterRankingDto masterRankingDto, @MappingTarget MasterRanking masterRanking);
}
