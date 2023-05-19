DROP TABLE IF EXISTS `RankingUnit`;
DROP TABLE IF EXISTS `CharacterClass`;
DROP TABLE IF EXISTS `RoomUnit`;
DROP TABLE IF EXISTS `Room`;
DROP TABLE IF EXISTS `Ranking`;
DROP TABLE IF EXISTS `Account`;
DROP TABLE IF EXISTS `Map`;

CREATE TABLE `Account` (
	`uid`	Integer	NOT NULL	AUTO_INCREMENT,
	`id`	varchar(32)	NOT NULL UNIQUE,
	`password`	varchar(72)	NOT NULL,
	`nickname`	varchar(32)	NOT NULL,
    PRIMARY KEY(`uid`)
);

CREATE TABLE `Ranking` (
	`rankingId`	Integer	NOT NULL	AUTO_INCREMENT,
	`completeTime` BIGINT NOT NULL,
	`created`	Date	NOT NULL DEFAULT (current_date),
  `mapId` Integer NOT NULL,
    PRIMARY KEY(`rankingId`)
);

CREATE TABLE `Room` (
	`roomId`	Integer	NOT NULL	AUTO_INCREMENT,
	`maxUser`	Integer	NOT NULL,
	`currentUser`	Integer	NOT NULL,
	`created`	Date	NOT NULL,
  `mapId` Integer NOT NULL,
    PRIMARY KEY(`roomId`)
) engine=memory;

CREATE TABLE `RankingUnit` (
	`uid`	Integer	NOT NULL,
  `nickname` varchar(32) NOT NULL,
	`rankingId`	Integer	NOT NULL,
	`characterClassId`	Integer	NOT NULL,
    PRIMARY KEY(`uid`, `rankingId`)
);

CREATE TABLE `CharacterClass` (
	`characterClassId`	Integer	NOT NULL	AUTO_INCREMENT,
	`characterclassName`	varchar(32) NOT	NULL,
     PRIMARY KEY(`characterClassId`)
);

CREATE TABLE `RoomUnit` (
	`uid`	Integer	NOT NULL	AUTO_INCREMENT,
	`roomId`	Integer	NOT NULL,
    PRIMARY KEY(`uid`, `roomId`)
) engine=memory;

CREATE TABLE `Map` (
  `mapId` Integer NOT NULL	AUTO_INCREMENT,
  `mapName` varchar(32) NOT NULL,
	  PRIMARY KEY(`mapId`)
);

ALTER TABLE `RankingUnit` ADD CONSTRAINT `FK_User_TO_RankingUnit_1` FOREIGN KEY (
	`uid`
)
REFERENCES `Account` (
	`uid`
);

ALTER TABLE `RankingUnit` ADD CONSTRAINT `FK_Ranking_TO_RankingUnit_1` FOREIGN KEY (
	`rankingId`
)
REFERENCES `Ranking` (
	`rankingId`
);

ALTER TABLE `RankingUnit` ADD CONSTRAINT `FK_CharacterClass_TO_RankingUnit_1` FOREIGN KEY (
	`characterClassId`
)
REFERENCES `CharacterClass` (
	`characterClassId`
);

ALTER TABLE `Ranking` ADD CONSTRAINT `FK_Map_TO_Ranking_1` FOREIGN KEY (
	`mapId`
)
REFERENCES `Map` (
	`mapId`
);

ALTER TABLE `RoomUnit` ADD CONSTRAINT `FK_User_TO_RoomUnit_1` FOREIGN KEY (
	`uid`
)
REFERENCES `Account` (
	`uid`
);

ALTER TABLE `RoomUnit` ADD CONSTRAINT `FK_Room_TO_RoomUnit_1` FOREIGN KEY (
	`roomId`
)
REFERENCES `Room` (
	`roomId`
);

ALTER TABLE `Room` ADD CONSTRAINT `FK_Map_TO_Room_1` FOREIGN KEY (
	`mapId`
)
REFERENCES `Map` (
	`mapId`
);

CREATE INDEX `RankingCompleteTimeIndex` on `Ranking`(completeTime)