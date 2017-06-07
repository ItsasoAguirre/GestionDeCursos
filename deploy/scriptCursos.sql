CREATE DATABASE `cursos` /*!40100 COLLATE 'utf8_general_ci' */;
SHOW DATABASES;
/* Entrando a la sesión "localhost" */
USE `cursos`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='cursos';
SHOW TABLE STATUS FROM `cursos`;
SHOW FUNCTION STATUS WHERE `Db`='cursos';
SHOW PROCEDURE STATUS WHERE `Db`='cursos';
SHOW TRIGGERS FROM `cursos`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='cursos';
SHOW ENGINES;
SHOW VARIABLES LIKE 'collation_database';
CREATE TABLE `curso` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(150) NOT NULL DEFAULT '0',
	`codigo` VARCHAR(150) NOT NULL DEFAULT '0'
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
/* Error de SQL (1075): Incorrect table definition; there can be only one auto column and it must be defined as a key */
CREATE TABLE `curso` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(150) NOT NULL DEFAULT '0',
	`codigo` VARCHAR(150) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='cursos';
SHOW TABLE STATUS FROM `cursos`;
SHOW FUNCTION STATUS WHERE `Db`='cursos';
SHOW PROCEDURE STATUS WHERE `Db`='cursos';
SHOW TRIGGERS FROM `cursos`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='cursos';
SHOW CREATE TABLE `cursos`.`curso`;
/* Entrando a la sesión "localhost" */
SHOW CREATE TABLE `cursos`.`curso`;
ALTER TABLE `curso`
	CHANGE COLUMN `nombre` `nombreCurso` VARCHAR(150) NOT NULL DEFAULT '0' AFTER `id`,
	CHANGE COLUMN `codigo` `codigoCurso` VARCHAR(150) NOT NULL DEFAULT '0' AFTER `nombreCurso`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='cursos';
SHOW TABLE STATUS FROM `cursos`;
SHOW FUNCTION STATUS WHERE `Db`='cursos';
SHOW PROCEDURE STATUS WHERE `Db`='cursos';
SHOW TRIGGERS FROM `cursos`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='cursos';
SHOW CREATE TABLE `cursos`.`curso`;
/* Entrando a la sesión "localhost" */
SHOW CREATE TABLE `cursos`.`curso`;