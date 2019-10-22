SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+03:00";

CREATE USER 'gestor-aluno'@'localhost' IDENTIFIED BY '1234';

DROP DATABASE IF EXISTS `gestor`;
CREATE DATABASE `gestor`;

GRANT ALL PRIVILEGES ON `gestor` . * TO 'gestor-aluno'@'localhost';

USE `gestor`;

/*!40101 SET NAMES utf8 */

--
-- Estrutura da tabela `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso` (
	`codigo` int NOT NULL AUTO_INCREMENT,
	`descricao` varchar(50) NOT NULL,
	`ementa` text DEFAULT NULL,
	PRIMARY KEY(`codigo`)
) ENGINE=InnoDB ;

--
-- Estrutura da tabela `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
	`codigo` int NOT NULL AUTO_INCREMENT,
	`nome` varchar(50) NOT NULL,
	PRIMARY KEY(`codigo`)
) ENGINE=InnoDB;

--
-- Estrutura da tabela `curso_aluno`
--

DROP TABLE IF EXISTS `curso_aluno`;
CREATE TABLE `curso_aluno` (
	`codigo` int NOT NULL AUTO_INCREMENT,
	`codigo_aluno` int NOT NULL,
	`codigo_curso` int NOT NULL,
	PRIMARY KEY(`codigo`),
	KEY `FK_CODIGO_ALUNO` (`codigo_aluno`),
	KEY `FK_CODIGO_CURSO` (`codigo_curso`)
) ENGINE=InnoDB;
