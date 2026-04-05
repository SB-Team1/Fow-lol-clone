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
@Table(name = "master_ranking")
public class MasterRanking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "champion_id")
  private Champion champion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "puuid")
  private Summoner puuid;

  @Column(name = "master_score")
  private Float masterScore;

  @Column(name = "play_count")
  private Integer playCount;

  @Column(name = "win_rate")
  private Float winRate;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "updated_at")
  private Instant updatedAt;


}
