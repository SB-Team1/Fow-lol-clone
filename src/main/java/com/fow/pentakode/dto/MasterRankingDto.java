package com.fow.pentakode.dto;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.fow.pentakode.entity.MasterRanking}
 */
public record MasterRankingDto(Integer id, ChampionDto champion, SummonerDto puuid,
                               Float masterScore, Integer playCount, Float winRate,
                               Instant createdAt, Instant updatedAt) implements
    Serializable {

}
