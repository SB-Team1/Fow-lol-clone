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
@Table(name = "champion")
public class Champion {

  @Id
  @Column(name = "champion_id", nullable = false)
  private Integer id;

  @Size(max = 100)
  @Column(name = "name_en", length = 100)
  private String nameEn;

  @Size(max = 100)
  @Column(name = "name_kr", length = 100)
  private String nameKr;

  @Size(max = 255)
  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "updated_at")
  private Instant updatedAt;
  @OneToMany(mappedBy = "champion")
  private Set<ChampionAnalysis> championAnalyses = new LinkedHashSet<>();
  @OneToMany(mappedBy = "champion")
  private Set<MasterRanking> masterRankings = new LinkedHashSet<>();
  @OneToMany(mappedBy = "champion")
  private Set<MatchBan> matchBans = new LinkedHashSet<>();
  @OneToMany(mappedBy = "champion")
  private Set<MatchParticipant> matchParticipants = new LinkedHashSet<>();


}
