package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.MatchParticipantDto;
import com.fow.pentakode.entity.MatchParticipant;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface MatchParticipantMapper {

  MatchParticipant toEntity(MatchParticipantDto matchParticipantDto);

  MatchParticipantDto toDto(MatchParticipant matchParticipant);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  MatchParticipant partialUpdate(
      MatchParticipantDto matchParticipantDto, @MappingTarget MatchParticipant matchParticipant);
}
