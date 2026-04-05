package com.fow.pentakode.dto;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.fow.pentakode.entity.MatchTeam}
 */
public record MatchTeamDto(Integer id, MatchDto match, Integer teamId, Boolean win,
                           Integer totalGold, Integer towerKills, Integer dragonKills,
                           Integer baronKills, Boolean firstBlood, Instant createdAt) implements
    Serializable {

}
