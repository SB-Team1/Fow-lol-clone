package com.fow.pentakode.dto;

import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.fow.pentakode.entity.ChampionAnalysis}
 */
public record ChampionAnalysisDto(Integer id, ChampionDto champion, PatchVersionDto version,
                                  @Size(max = 50) String position, Float winRate, Float pickRate,
                                  Float banRate, Instant createdAt, Instant updatedAt) implements
    Serializable {

}
