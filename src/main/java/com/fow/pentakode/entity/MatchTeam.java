package com.fow.pentakode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "match_team")
public class MatchTeam {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "match_id")
  private Match match;

  @Column(name = "team_id")
  private Integer teamId;

  @Column(name = "win")
  private Boolean win;

  @Column(name = "total_gold")
  private Integer totalGold;

  @Column(name = "tower_kills")
  private Integer towerKills;

  @Column(name = "dragon_kills")
  private Integer dragonKills;

  @Column(name = "baron_kills")
  private Integer baronKills;

  @Column(name = "first_blood")
  private Boolean firstBlood;

  @Column(name = "created_at")
  private Instant createdAt;
  @OneToMany(mappedBy = "matchTeam")
  private Set<MatchBan> matchBans = new LinkedHashSet<>();


}
