package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.MatchDto;
import com.fow.pentakode.entity.Match;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface MatchMapper {

  Match toEntity(MatchDto matchDto);

  MatchDto toDto(Match match);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Match partialUpdate(
      MatchDto matchDto, @MappingTarget Match match);
}
