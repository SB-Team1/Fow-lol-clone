package com.fow.pentakode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "match")
public class Match {

  @Id
  @Size(max = 100)
  @Column(name = "match_id", nullable = false, length = 100)
  private String matchId;

  @Column(name = "game_creation")
  private Long gameCreation;

  @Column(name = "game_duration")
  private Long gameDuration;

  @Size(max = 50)
  @Column(name = "game_mode", length = 50)
  private String gameMode;

  @Size(max = 50)
  @Column(name = "game_type", length = 50)
  private String gameType;

  @Size(max = 50)
  @Column(name = "game_version", length = 50)
  private String gameVersion;

  @Column(name = "created_at")
  private Instant createdAt;
  @OneToMany(mappedBy = "match")
  private Set<MatchBan> matchBans = new LinkedHashSet<>();
  @OneToMany(mappedBy = "match")
  private Set<MatchParticipant> matchParticipants = new LinkedHashSet<>();
  @OneToMany(mappedBy = "match")
  private Set<MatchTeam> matchTeams = new LinkedHashSet<>();


}
