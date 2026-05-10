CREATE TABLE `users` (
	`id`	BIGINT	NOT NULL,
	`nickname`	VARCHAR(255)	NULL,
	`created_at`	DATETIME	NOT NULL,
	`updated_at`	DATETIME	NOT NULL
);

CREATE TABLE `song_artists` (
	`id`	BIGINT	NOT NULL,
	`artist_id`	BIGINT	NOT NULL,
	`song_id`	BIGINT	NOT NULL
);

CREATE TABLE `songs` (
	`id`	BIGINT	NOT NULL,
	`title`	VARCHAR(255)	NOT NULL,
	`album_id`	BIGINT	NOT NULL,
	`play_time`	INT	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`updated_at`	DATETIME	NOT NULL
);

CREATE TABLE `artists` (
	`id`	BIGINT	NOT NULL,
	`name`	VARCHAR(255)	NOT NULL,
	`type`	ENUM	NOT NULL	COMMENT 'SOLO, GROUP',
	`group_id`	BIGINT	NULL,
	`imageUrl`	TEXT	NULL,
	`created_at`	DATETIME	NOT NULL,
	`updated_at`	DATETIME	NOT NULL
);

CREATE TABLE `album_artists` (
	`id`	BIGINT	NOT NULL,
	`artist_id`	BIGINT	NOT NULL,
	`album_id`	BIGINT	NOT NULL
);

CREATE TABLE `likes` (
	`id`	BIGINT	NOT NULL,
	`user_id`	BIGINT	NOT NULL,
	`song_id`	BIGINT	NOT NULL
);

CREATE TABLE `artist_details` (
	`artist_id`	BIGINT	NOT NULL,
	`comment_count`	INT	NOT NULL,
	`fan_count`	INT	NOT NULL,
	`active_degree`	INT	NOT NULL,
	`credit`	VARCHAR(255)	NULL,
	`debut_year_month`	DATE	NOT NULL,
	`country`	VARCHAR(255)	NULL,
	`agency`	VARCHAR(255)	NULL,
	`award_history`	TEXT	NULL,
	`description`	TEXT	NULL,
	`gender`	ENUM	NULL	COMMENT 'M, F'
);

CREATE TABLE `song_details` (
	`id`	BIGINT	NOT NULL,
	`like_count`	INT	NULL,
	`lyrics`	TEXT	NULL,
	`play_count`	INT	NULL
);

CREATE TABLE `album` (
	`id`	BIGINT	NOT NULL,
	`title`	VARCHAR(255)	NOT NULL,
	`image_url`	TEXT	NULL,
	`release_date`	DATE	NOT NULL,
	`created_at`	DATETIME	NOT NULL,
	`updated_at`	DATETIME	NOT NULL
);

ALTER TABLE `users` ADD CONSTRAINT `PK_USERS` PRIMARY KEY (
	`id`
);

ALTER TABLE `song_artists` ADD CONSTRAINT `PK_SONG_ARTISTS` PRIMARY KEY (
	`id`
);

ALTER TABLE `songs` ADD CONSTRAINT `PK_SONGS` PRIMARY KEY (
	`id`
);

ALTER TABLE `artists` ADD CONSTRAINT `PK_ARTISTS` PRIMARY KEY (
	`id`
);

ALTER TABLE `album_artists` ADD CONSTRAINT `PK_ALBUM_ARTISTS` PRIMARY KEY (
	`id`
);

ALTER TABLE `likes` ADD CONSTRAINT `PK_LIKES` PRIMARY KEY (
	`id`
);

ALTER TABLE `album` ADD CONSTRAINT `PK_ALBUM` PRIMARY KEY (
	`id`
);

