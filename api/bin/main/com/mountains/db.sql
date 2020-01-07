-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mount
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mount
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mount` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mount` ;

-- -----------------------------------------------------
-- Table `mount`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mount`.`country` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `code` VARCHAR(2) NOT NULL,
                                                 `name` VARCHAR(45) NOT NULL,
                                                 PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mount`.`hills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mount`.`hills` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `name` VARCHAR(45) NOT NULL,
                                               `height` INT NOT NULL,
                                               `mount_name` VARCHAR(45) NOT NULL,
                                               `country_id` INT NOT NULL,
                                               PRIMARY KEY (`id`),
                                               INDEX `fk_hills_country_idx` (`country_id` ) ,
                                               CONSTRAINT `fk_hills_country`
                                                   FOREIGN KEY (`country_id`)
                                                       REFERENCES `mount`.`country` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
