package com.fow.pentakode.dto;

import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.fow.pentakode.entity.PatchVersion}
 */
public record PatchVersionDto(@Size(max = 50) String version, Instant releaseDate,
                              Instant createdAt) implements
    Serializable {

}
