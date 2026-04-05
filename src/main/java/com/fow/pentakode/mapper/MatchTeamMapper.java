package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.MatchTeamDto;
import com.fow.pentakode.entity.MatchTeam;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface MatchTeamMapper {

  MatchTeam toEntity(MatchTeamDto matchTeamDto);

  MatchTeamDto toDto(MatchTeam matchTeam);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  MatchTeam partialUpdate(
      MatchTeamDto matchTeamDto, @MappingTarget MatchTeam matchTeam);
}
