package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.LeagueEntryDto;
import com.fow.pentakode.entity.LeagueEntry;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface LeagueEntryMapper {

  LeagueEntry toEntity(LeagueEntryDto leagueEntryDto);

  LeagueEntryDto toDto(LeagueEntry leagueEntry);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  LeagueEntry partialUpdate(
      LeagueEntryDto leagueEntryDto, @MappingTarget LeagueEntry leagueEntry);
}
