package com.fow.pentakode.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.fow.pentakode.entity.Summoner}
 */
public record SummonerDto(@Size(max = 255) String puuid,
                          @NotNull @Size(max = 255) String summonerId,
                          @Size(max = 255) String accountId, @Size(max = 255) String name,
                          @Size(max = 50) String tagLine, Integer profileIconId, Long revisionDate,
                          Integer summonerLevel, Instant createdAt, Instant updatedAt) implements
    Serializable {

}
