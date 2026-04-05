package com.fow.pentakode.mapper;

import com.fow.pentakode.dto.PatchVersionDto;
import com.fow.pentakode.entity.PatchVersion;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface PatchVersionMapper {

  PatchVersion toEntity(PatchVersionDto patchVersionDto);

  PatchVersionDto toDto(PatchVersion patchVersion);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  PatchVersion partialUpdate(
      PatchVersionDto patchVersionDto, @MappingTarget PatchVersion patchVersion);
}
