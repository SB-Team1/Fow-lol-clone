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
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "league_entry")
public class LeagueEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "summoner_id", referencedColumnName = "summoner_id")
  private Summoner summoner;

  @Size(max = 50)
  @Column(name = "queue_type", length = 50)
  private String queueType;

  @Size(max = 50)
  @Column(name = "tier", length = 50)
  private String tier;

  @Size(max = 10)
  @Column(name = "rank", length = 10)
  private String rank;

  @Column(name = "league_points")
  private Integer leaguePoints;

  @Column(name = "wins")
  private Integer wins;

  @Column(name = "losses")
  private Integer losses;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "updated_at")
  private Instant updatedAt;


}
