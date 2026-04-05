package com.fow.pentakode.dto;

import com.fow.pentakode.entity.MatchTeam;
import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.fow.pentakode.entity.MatchBan}
 */
public record MatchBanDto(Integer id, MatchTeam matchTeam, MatchDto match, Integer pickTurn,
                          ChampionDto champion, Instant createdAt) implements
    Serializable {

}
