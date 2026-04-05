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
@Table(name = "patch_version")
public class PatchVersion {

  @Id
  @Size(max = 50)
  @Column(name = "version", nullable = false, length = 50)
  private String version;

  @Column(name = "release_date")
  private Instant releaseDate;

  @Column(name = "created_at")
  private Instant createdAt;
  @OneToMany(mappedBy = "version")
  private Set<ChampionAnalysis> championAnalyses = new LinkedHashSet<>();


}
