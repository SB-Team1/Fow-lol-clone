-- ==========================================
-- 0. 기존 테이블 및 제약조건 초기화
-- ==========================================
DROP TABLE IF EXISTS MATCH_PARTICIPANT CASCADE;
DROP TABLE IF EXISTS MATCH_BAN CASCADE;
DROP TABLE IF EXISTS MATCH_TEAM CASCADE;
DROP TABLE IF EXISTS CHAMPION_ANALYSIS CASCADE;
DROP TABLE IF EXISTS MASTER_RANKING CASCADE;
DROP TABLE IF EXISTS LEAGUE_ENTRY CASCADE;
DROP TABLE IF EXISTS MATCH CASCADE;
DROP TABLE IF EXISTS PATCH_VERSION CASCADE;
DROP TABLE IF EXISTS CHAMPION CASCADE;
DROP TABLE IF EXISTS SUMMONER CASCADE;

-- ==========================================
-- 1. 기본 테이블 생성
-- ==========================================

CREATE TABLE SUMMONER
(
  puuid           VARCHAR(255) PRIMARY KEY,
  summoner_id     VARCHAR(255) NOT NULL,
  account_id      VARCHAR(255),
  name            VARCHAR(255),
  tag_line        VARCHAR(50),
  profile_icon_id INT,
  revision_date   BIGINT,
  summoner_level  INT,
  created_at      TIMESTAMPTZ,
  updated_at      TIMESTAMPTZ
);

CREATE TABLE CHAMPION
(
  champion_id INT PRIMARY KEY,
  name_en     VARCHAR(100),
  name_kr     VARCHAR(100),
  image_url   VARCHAR(255),
  created_at  TIMESTAMPTZ,
  updated_at  TIMESTAMPTZ
);

CREATE TABLE PATCH_VERSION
(
  version      VARCHAR(50) PRIMARY KEY,
  release_date TIMESTAMP,
  created_at   TIMESTAMPTZ
);

CREATE TABLE MATCH
(
  match_id      VARCHAR(100) PRIMARY KEY,
  game_creation BIGINT,
  game_duration BIGINT,
  game_mode     VARCHAR(50),
  game_type     VARCHAR(50),
  game_version  VARCHAR(50),
  created_at    TIMESTAMPTZ
);

CREATE TABLE LEAGUE_ENTRY
(
  id            SERIAL PRIMARY KEY,
  summoner_id   VARCHAR(255),
  queue_type    VARCHAR(50),
  tier          VARCHAR(50),
  rank          VARCHAR(10),
  league_points INT,
  wins          INT,
  losses        INT,
  created_at    TIMESTAMPTZ,
  updated_at    TIMESTAMPTZ
);

CREATE TABLE MASTER_RANKING
(
  id           SERIAL PRIMARY KEY,
  champion_id  INT,
  puuid        VARCHAR(255),
  master_score REAL,
  play_count   INT,
  win_rate     REAL,
  created_at   TIMESTAMPTZ,
  updated_at   TIMESTAMPTZ
);

CREATE TABLE CHAMPION_ANALYSIS
(
  id          SERIAL PRIMARY KEY,
  champion_id INT,
  version     VARCHAR(50),
  position    VARCHAR(50),
  win_rate    REAL,
  pick_rate   REAL,
  ban_rate    REAL,
  created_at  TIMESTAMPTZ,
  updated_at  TIMESTAMPTZ
);

CREATE TABLE MATCH_TEAM
(
  id           SERIAL PRIMARY KEY,
  match_id     VARCHAR(100),
  team_id      INT,
  win          BOOLEAN,
  total_gold   INT,
  tower_kills  INT,
  dragon_kills INT,
  baron_kills  INT,
  first_blood  BOOLEAN,
  created_at   TIMESTAMPTZ
);

CREATE TABLE MATCH_BAN
(
  id            SERIAL PRIMARY KEY,
  match_team_id INT,
  match_id      VARCHAR(100),
  pick_turn     INT,
  champion_id   INT,
  created_at    TIMESTAMPTZ
);

CREATE TABLE MATCH_PARTICIPANT
(
  id                   SERIAL PRIMARY KEY,
  match_id             VARCHAR(100),
  puuid                VARCHAR(255),
  champion_id          INT,
  team_id              INT,
  win                  BOOLEAN,
  kills                INT,
  deaths               INT,
  assists              INT,
  item0                INT,
  item1                INT,
  item2                INT,
  item3                INT,
  item4                INT,
  item5                INT,
  item6                INT,
  spell1_id            INT,
  spell2_id            INT,
  primary_rune         INT,
  sub_rune             INT,
  total_damage_dealt   INT,
  total_damage_taken   INT,
  total_minions_killed INT,
  vision_score         INT,
  created_at           TIMESTAMPTZ
);

-- ==========================================
-- 2. UNIQUE 제약조건 추가
-- ==========================================
ALTER TABLE SUMMONER
  ADD CONSTRAINT uk_summoner_summoner_id UNIQUE (summoner_id);

-- ==========================================
-- 3. FOREIGN KEY 제약조건 추가
-- ==========================================
ALTER TABLE LEAGUE_ENTRY
  ADD CONSTRAINT fk_league_entry_summoner_id
    FOREIGN KEY (summoner_id) REFERENCES SUMMONER (summoner_id);

ALTER TABLE MASTER_RANKING
  ADD CONSTRAINT fk_master_ranking_champion_id
    FOREIGN KEY (champion_id) REFERENCES CHAMPION (champion_id),
  ADD CONSTRAINT fk_master_ranking_puuid
    FOREIGN KEY (puuid) REFERENCES SUMMONER (puuid);

ALTER TABLE CHAMPION_ANALYSIS
  ADD CONSTRAINT fk_champion_analysis_champion_id
    FOREIGN KEY (champion_id) REFERENCES CHAMPION (champion_id),
  ADD CONSTRAINT fk_champion_analysis_version
    FOREIGN KEY (version) REFERENCES PATCH_VERSION (version);

ALTER TABLE MATCH_TEAM
  ADD CONSTRAINT fk_match_team_match_id
    FOREIGN KEY (match_id) REFERENCES MATCH (match_id);

ALTER TABLE MATCH_BAN
  ADD CONSTRAINT fk_match_ban_match_team_id
    FOREIGN KEY (match_team_id) REFERENCES MATCH_TEAM (id),
  ADD CONSTRAINT fk_match_ban_match_id
    FOREIGN KEY (match_id) REFERENCES MATCH (match_id),
  ADD CONSTRAINT fk_match_ban_champion_id
    FOREIGN KEY (champion_id) REFERENCES CHAMPION (champion_id);

ALTER TABLE MATCH_PARTICIPANT
  ADD CONSTRAINT fk_match_participant_match_id
    FOREIGN KEY (match_id) REFERENCES MATCH (match_id),
  ADD CONSTRAINT fk_match_participant_puuid
    FOREIGN KEY (puuid) REFERENCES SUMMONER (puuid),
  ADD CONSTRAINT fk_match_participant_champion_id
    FOREIGN KEY (champion_id) REFERENCES CHAMPION (champion_id);
