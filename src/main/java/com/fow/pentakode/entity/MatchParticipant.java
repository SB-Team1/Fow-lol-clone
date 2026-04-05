package com.fow.pentakode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "match_participant")
public class MatchParticipant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "match_id")
  private Match match;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "puuid")
  private Summoner puuid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "champion_id")
  private Champion champion;

  @Column(name = "team_id")
  private Integer teamId;

  @Column(name = "win")
  private Boolean win;

  @Column(name = "kills")
  private Integer kills;

  @Column(name = "deaths")
  private Integer deaths;

  @Column(name = "assists")
  private Integer assists;

  @Column(name = "item0")
  private Integer item0;

  @Column(name = "item1")
  private Integer item1;

  @Column(name = "item2")
  private Integer item2;

  @Column(name = "item3")
  private Integer item3;

  @Column(name = "item4")
  private Integer item4;

  @Column(name = "item5")
  private Integer item5;

  @Column(name = "item6")
  private Integer item6;

  @Column(name = "spell1_id")
  private Integer spell1Id;

  @Column(name = "spell2_id")
  private Integer spell2Id;

  @Column(name = "primary_rune")
  private Integer primaryRune;

  @Column(name = "sub_rune")
  private Integer subRune;

  @Column(name = "total_damage_dealt")
  private Integer totalDamageDealt;

  @Column(name = "total_damage_taken")
  private Integer totalDamageTaken;

  @Column(name = "total_minions_killed")
  private Integer totalMinionsKilled;

  @Column(name = "vision_score")
  private Integer visionScore;

  @Column(name = "created_at")
  private Instant createdAt;


}
