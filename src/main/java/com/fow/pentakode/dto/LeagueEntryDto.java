package com.fow.pentakode.dto;

import com.fow.pentakode.entity.LeagueEntry;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link LeagueEntry}
 */
public record LeagueEntryDto(Integer id, SummonerDto summoner, @Size(max = 50) String queueType,
                             @Size(max = 50) String tier, @Size(max = 10) String rank,
                             Integer leaguePoints, Integer wins, Integer losses, Instant createdAt,
                             Instant updatedAt) implements
    Serializable {

}
