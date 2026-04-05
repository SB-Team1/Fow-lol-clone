package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.MatchBanDto;
import com.fow.pentakode.entity.MatchBan;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface MatchBanMapper {

  MatchBan toEntity(MatchBanDto matchBanDto);

  MatchBanDto toDto(MatchBan matchBan);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  MatchBan partialUpdate(
      MatchBanDto matchBanDto, @MappingTarget MatchBan matchBan);
}
