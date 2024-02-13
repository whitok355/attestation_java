0.  Создание БД и таблиц

CREATE DATABASE human_friends;

1. Создать таблицы, соответствующие иерархии из вашей диаграммы классов.

CREATE TABLE `human_friends`.`animals_class` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `class_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `human_friends`.`pets_subclass` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_class_pets` INT NOT NULL,
  `name_subclass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_class_pets_idx` (`id_class_pets` ASC) VISIBLE,
  CONSTRAINT `fk_id_class_pets`
    FOREIGN KEY (`id_class_pets`)
    REFERENCES `human_friends`.`animals_class` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `human_friends`.`pack_animals_subclass` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_class_pack_animals` INT NOT NULL,
  `name_subclass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_class_pack_animals_idx` (`id_class_pack_animals` ASC) VISIBLE,
  CONSTRAINT `fk_id_class_pack_animals`
    FOREIGN KEY (`id_class_pack_animals`)
    REFERENCES `human_friends`.`animals_class` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `human_friends`.`dog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_subclass_pet` INT NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `date_birth` VARCHAR(45) NOT NULL,
  `commands` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_subclass_dog_idx` (`id_subclass_pet` ASC) VISIBLE,
  CONSTRAINT `fk_id_subclass_dog`
    FOREIGN KEY (`id_subclass_pet`)
    REFERENCES `human_friends`.`pets_subclass` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `human_friends`.`cat` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_subclass_pet` INT NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `date_birth` VARCHAR(45) NOT NULL,
  `commands` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_subclass_cat_idx` (`id_subclass_pet` ASC) VISIBLE,
  CONSTRAINT `fk_id_subclass_cat`
    FOREIGN KEY (`id_subclass_pet`)
    REFERENCES `human_friends`.`pets_subclass` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `human_friends`.`hamster` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_subclass_pet` INT NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `date_birth` VARCHAR(45) NOT NULL,
  `commands` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_subclass_hamster_idx` (`id_subclass_pet` ASC) VISIBLE,
  CONSTRAINT `fk_id_subclass_hamster`
    FOREIGN KEY (`id_subclass_pet`)
    REFERENCES `human_friends`.`pets_subclass` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `human_friends`.`horse` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_subclass_pet` INT NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `date_birth` VARCHAR(45) NOT NULL,
  `commands` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_subclass_horse_idx` (`id_subclass_pet` ASC) VISIBLE,
  CONSTRAINT `fk_id_subclass_horse`
    FOREIGN KEY (`id_subclass_pet`)
    REFERENCES `human_friends`.`pets_subclass` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

  CREATE TABLE `human_friends`.`camel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_subclass_pet` INT NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `date_birth` VARCHAR(45) NOT NULL,
  `commands` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_subclass_camel_idx` (`id_subclass_pet` ASC) VISIBLE,
  CONSTRAINT `fk_id_subclass_camel`
    FOREIGN KEY (`id_subclass_pet`)
    REFERENCES `human_friends`.`pets_subclass` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `human_friends`.`donkey` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_subclass_pet` INT NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `date_birth` VARCHAR(45) NOT NULL,
  `commands` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_subclass_donkey_idx` (`id_subclass_pet` ASC) VISIBLE,
  CONSTRAINT `fk_id_subclass_donkey`
    FOREIGN KEY (`id_subclass_pet`)
    REFERENCES `human_friends`.`pets_subclass` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

2. Заполнить таблицы данными о животных, их командах и датами рождения.

INSERT INTO animals_class(class_name) VALUES ("pets"), ("pack animals");

INSERT INTO pack_animals_subclass(id_class_pack_animals, name_subclass) VALUES (2, "horse"), (2, "camel"), (2, "donkey");

INSERT INTO pets_subclass(id_class_pets, name_subclass) VALUES (1, "dog"), (1, "cat"), (1, "hamster");

INSERT INTO dog(id_subclass_pet, nickname, date_birth, commands) VALUES 
	(1, "Тaйсон", DATE("2022-01-22"), "sit, serve, voice"),
    (1, "Джек", DATE("2021-02-12"), "sit, serve, voice");

INSERT INTO cat(id_subclass_pet, nickname, date_birth, commands) VALUES 
    (2, "Хатико", DATE("2017-03-21"), "sit, serve, voice"),
    (2, "Дик", DATE("2019-04-04"), "sit, serve, voice");

INSERT INTO hamster(id_subclass_pet, nickname, date_birth, commands) VALUES 
	(3, "Боня", DATE("2017-01-23"), "sit, serve, voice"),
	(3, "Джеси", DATE("2018-02-09"), "sit, serve, voice");

INSERT INTO horse(id_subclass_pet, nickname, date_birth, commands) VALUES 
	(1, "Лорд", DATE("2022-01-22"), "sit, serve, voice, load, unload"),
    (1, "Альма", DATE("2021-02-12"), "sit, serve, voice, load, unload");

INSERT INTO camel(id_subclass_pet, nickname, date_birth, commands) VALUES 
    (2, "Рич ", DATE("2017-01-23"), "sit, serve, voice, load, unload"),
	(2, "Барон", DATE("2018-02-09"), "sit, serve, voice, load, unload");

INSERT INTO donkey(id_subclass_pet, nickname, date_birth, commands) VALUES 
    (3, "Татошка", DATE("2017-03-21"), "sit, serve, voice, load, unload"),
    (3, "Герда", DATE("2019-04-04"), "sit, serve, voice, load, unload");

3. Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

DELETE FROM camel;

CREATE TABLE `human_friends`.`horse_dunkey` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_subclass_pet` INT NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `date_birth` VARCHAR(45) NOT NULL,
  `commands` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_pack_animal_subclass_idx` (`id_subclass_pet` ASC) VISIBLE,
  CONSTRAINT `fk_id_pack_animal_subclass`
    FOREIGN KEY (`id_subclass_pet`)
    REFERENCES `human_friends`.`pack_animals_subclass` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO horse_dunkey(id_subclass_pet, nickname, date_birth, commands)
	SELECT id_subclass_pet, nickname, date_birth, commands FROM horse
		UNION ALL
	SELECT id_subclass_pet, nickname, date_birth, commands FROM donkey;

SELECT * FROM horse_dunkey;

4. Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

CREATE TABLE `human_friends`.`sort_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_subclass_pet` INT NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `date_birth` VARCHAR(45) NOT NULL,
  `commands` VARCHAR(45) NULL,
  `age` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fr_sort_table_idx` (`id_subclass_pet` ASC) VISIBLE,
  CONSTRAINT `fr_sort_table`
    FOREIGN KEY (`id_subclass_pet`)
    REFERENCES `human_friends`.`pack_animals_subclass` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


USE `human_friends`;
DROP function IF EXISTS `get_age`;

DELIMITER $$
USE `human_friends`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `get_age`(date Date) RETURNS varchar(10) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
	declare res VARCHAR(10);
    
    SET res = ROUND(timestampdiff(MONTH, date, CURDATE()) / 12, 1);
    
RETURN res;
END$$

DELIMITER ;

INSERT INTO sort_table(id_subclass_pet, nickname, date_birth, commands, age)
	SELECT id_subclass_pet, nickname, date_birth, commands, get_age(date_birth) FROM camel
	WHERE get_age(date_birth) BETWEEN 1 AND 3
		UNION ALL
    SELECT id_subclass_pet, nickname, date_birth, commands, get_age(date_birth) FROM cat
	WHERE get_age(date_birth) BETWEEN 1 AND 3
        UNION ALL
    SELECT id_subclass_pet, nickname, date_birth, commands, get_age(date_birth) FROM dog
	WHERE get_age(date_birth) BETWEEN 1 AND 3
            UNION ALL
    SELECT id_subclass_pet, nickname, date_birth, commands, get_age(date_birth) FROM donkey
	WHERE get_age(date_birth) BETWEEN 1 AND 3
			UNION ALL
    SELECT id_subclass_pet, nickname, date_birth, commands, get_age(date_birth) FROM hamster
	WHERE get_age(date_birth) BETWEEN 1 AND 3
			UNION ALL
    SELECT id_subclass_pet, nickname, date_birth, commands, get_age(date_birth) FROM horse
	WHERE get_age(date_birth) BETWEEN 1 AND 3;
    
SELECT * FROM sort_table;

5. Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

CREATE TABLE all_tables
	SELECT "camel" as table_title, id_subclass_pet, nickname, date_birth, commands, Null as adding FROM camel
	UNION ALL
    SELECT "cat", id_subclass_pet, nickname, date_birth, commands, Null as adding FROM cat
	UNION ALL
    SELECT "dog", id_subclass_pet, nickname, date_birth, commands, Null as adding FROM dog    
 	UNION ALL
    SELECT "donkey", id_subclass_pet, nickname, date_birth, commands, Null as adding FROM donkey   
 	UNION ALL
    SELECT "hamster", id_subclass_pet, nickname, date_birth, commands, Null as adding FROM hamster    
 	UNION ALL
    SELECT "horse", id_subclass_pet, nickname, date_birth, commands, Null as adding FROM horse        
 	UNION ALL
    SELECT "horse_dunkey", id_subclass_pet, nickname, date_birth, commands, Null as adding FROM horse_dunkey         
 	UNION ALL
    SELECT "pack_animals_subclass", id_class_pack_animals, name_subclass, Null as col4, Null as Col5, Null as adding FROM pack_animals_subclass  
 	UNION ALL
    SELECT "pets_subclass", id_class_pets, name_subclass, Null as col4, Null as Col5, Null as adding FROM pets_subclass
    UNION ALL
	SELECT "animals_class", class_name, Null as col2, Null as col3, Null as Col4, Null as Col5 FROM animals_class
    UNION ALL
	SELECT "sort_table", id_subclass_pet, nickname, date_birth, commands, age FROM sort_table;