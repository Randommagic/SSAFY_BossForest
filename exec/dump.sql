# username=test&password=1234 로 로그인 가능.
INSERT INTO 
	`Account` (`uid`,`id`,`password`,`nickname`) 
VALUES 
	(1,'test','$2a$12$nWT9EBa4mJInsHzyBudCRu7AAaUfxAA4c6DwmalXWMZG9Q5PAmjpG','TESTMAN');

INSERT INTO 
	`Map` (`mapId`,`mapName`) 
VALUES 
	(1, 'Boss Raid');

INSERT INTO 
	`CharacterClass` (`characterClassId`,`characterClassName`) 
VALUES 
	(1, 'Warrior'), 
	(2, 'Wizard'), 
	(3, 'Bowman');