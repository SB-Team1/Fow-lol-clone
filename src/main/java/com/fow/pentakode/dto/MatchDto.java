package com.fow.pentakode.dto;

import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.fow.pentakode.entity.Match}
 */
public record MatchDto(@Size(max = 100) String matchId, Long gameCreation, Long gameDuration,
                       @Size(max = 50) String gameMode, @Size(max = 50) String gameType,
                       @Size(max = 50) String gameVersion, Instant createdAt) implements
    Serializable {

}
