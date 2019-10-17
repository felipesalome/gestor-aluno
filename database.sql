SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+03:00";

CREATE USER 'gestor-aluno'@'localhost' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON `gestor` . * TO 'gestor-aluno'@'localhost';

CREATE DATABASE IF NOT EXISTS `gestor`;

USE `gestor`;

/*!40101 SET NAMES utf8 */

--
-- Estrutura da tabela `curso`
--

CREATE TABLE IF NOT EXISTS `curso` (
	`codigo` int NOT NULL AUTO_INCREMENT,
	`descricao` varchar(50) NOT NULL,
	`ementa` text DEFAULT NULL,
	PRIMARY KEY(`codigo`)
) ENGINE=InnoDB ;

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE IF NOT EXISTS `aluno` (
	`codigo` int NOT NULL AUTO_INCREMENT,
	`nome` varchar(50) NOT NULL,
	PRIMARY KEY(`codigo`)
) ENGINE=InnoDB;

--
-- Estrutura da tabela `curso_aluno`
--

CREATE TABLE IF NOT EXISTS `curso_aluno` (
	`codigo` int NOT NULL AUTO_INCREMENT,
	`codigo_aluno` int NOT NULL,
	`codigo_curso` int NOT NULL,
	PRIMARY KEY(`codigo`),
	KEY `FK_CODIGO_ALUNO` (`codigo_aluno`),
	KEY `FK_CODIGO_CURSO` (`codigo_curso`)
) ENGINE=InnoDB;
