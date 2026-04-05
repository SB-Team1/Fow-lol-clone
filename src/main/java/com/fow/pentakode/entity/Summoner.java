package com.fow.pentakode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "summoner")
public class Summoner {

  @Id
  @Size(max = 255)
  @Column(name = "puuid", nullable = false)
  private String puuid;

  @Size(max = 255)
  @NotNull
  @Column(name = "summoner_id", nullable = false)
  private String summonerId;

  @Size(max = 255)
  @Column(name = "account_id")
  private String accountId;

  @Size(max = 255)
  @Column(name = "name")
  private String name;

  @Size(max = 50)
  @Column(name = "tag_line", length = 50)
  private String tagLine;

  @Column(name = "profile_icon_id")
  private Integer profileIconId;

  @Column(name = "revision_date")
  private Long revisionDate;

  @Column(name = "summoner_level")
  private Integer summonerLevel;
  @Column(name = "created_at")
  private Instant createdAt;
  @Column(name = "updated_at")
  private Instant updatedAt;
  @OneToMany(mappedBy = "summoner")
  private Set<LeagueEntry> leagueEntries = new LinkedHashSet<>();
  @OneToMany(mappedBy = "puuid")
  private Set<MasterRanking> masterRankings = new LinkedHashSet<>();
  @OneToMany(mappedBy = "puuid")
  private Set<MatchParticipant> matchParticipants = new LinkedHashSet<>();


}
