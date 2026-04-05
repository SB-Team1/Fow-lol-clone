package com.fow.pentakode.dto;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.fow.pentakode.entity.MatchParticipant}
 */
public record MatchParticipantDto(Integer id, MatchDto match, SummonerDto puuid,
                                  ChampionDto champion, Integer teamId, Boolean win, Integer kills,
                                  Integer deaths, Integer assists, Integer item0, Integer item1,
                                  Integer item2, Integer item3, Integer item4, Integer item5,
                                  Integer item6, Integer spell1Id, Integer spell2Id,
                                  Integer primaryRune, Integer subRune, Integer totalDamageDealt,
                                  Integer totalDamageTaken, Integer totalMinionsKilled,
                                  Integer visionScore, Instant createdAt) implements
    Serializable {

}
