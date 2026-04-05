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
@Table(name = "champion_analysis")
public class ChampionAnalysis {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "champion_id")
  private Champion champion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "version")
  private PatchVersion version;

  @Size(max = 50)
  @Column(name = "\"position\"", length = 50)
  private String position;

  @Column(name = "win_rate")
  private Float winRate;

  @Column(name = "pick_rate")
  private Float pickRate;

  @Column(name = "ban_rate")
  private Float banRate;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "updated_at")
  private Instant updatedAt;


}
