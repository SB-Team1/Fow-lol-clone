package com.fow.pentakode.dto;

import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.fow.pentakode.entity.Champion}
 */
public record ChampionDto(Integer id, @Size(max = 100) String nameEn,
                          @Size(max = 100) String nameKr, @Size(max = 255) String imageUrl,
                          Instant createdAt, Instant updatedAt) implements
    Serializable {

}
