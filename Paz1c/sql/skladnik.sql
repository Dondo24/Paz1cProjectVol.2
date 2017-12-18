-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema skladnik
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema skladnik
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `skladnik` DEFAULT CHARACTER SET utf8 ;
USE `skladnik` ;

-- -----------------------------------------------------
-- Table `skladnik`.`Sklad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skladnik`.`Sklad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nazov` VARCHAR(45) NULL,
  `Adresa` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skladnik`.`Pouzivatel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skladnik`.`Pouzivatel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Meno` VARCHAR(45) NULL,
  `heslo` VARCHAR(45) NULL,
  `Sklad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pouzivatel_Sklad1_idx` (`Sklad_id` ASC),
  UNIQUE INDEX `Meno_UNIQUE` (`Meno` ASC),
  CONSTRAINT `fk_Pouzivatel_Sklad1`
    FOREIGN KEY (`Sklad_id`)
    REFERENCES `skladnik`.`Sklad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skladnik`.`Prijemka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skladnik`.`Prijemka` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cena` DOUBLE NULL,
  `Pouzivatel_id` INT NOT NULL,
  `datum` DATETIME NULL,
  `typ_pohybu` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Prijemka_Pouzivatel_idx` (`Pouzivatel_id` ASC),
  CONSTRAINT `fk_Prijemka_Pouzivatel`
    FOREIGN KEY (`Pouzivatel_id`)
    REFERENCES `skladnik`.`Pouzivatel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skladnik`.`Vydajka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skladnik`.`Vydajka` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Pouzivatel_id` INT NOT NULL,
  `cena` DOUBLE NULL,
  `datum` DATETIME NULL,
  `typ_pohybu` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Prijemka_Pouzivatel_idx` (`Pouzivatel_id` ASC),
  CONSTRAINT `fk_Prijemka_Pouzivatel0`
    FOREIGN KEY (`Pouzivatel_id`)
    REFERENCES `skladnik`.`Pouzivatel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skladnik`.`Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skladnik`.`Material` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Nazov` VARCHAR(45) NULL,
  `Stav` INT NULL,
  `Cena` DOUBLE NULL,
  `Sklad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Material_Sklad1_idx` (`Sklad_id` ASC),
  CONSTRAINT `fk_Material_Sklad1`
    FOREIGN KEY (`Sklad_id`)
    REFERENCES `skladnik`.`Sklad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skladnik`.`pohybMaterialu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `skladnik`.`pohybMaterialu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_materialu` INT NULL,
  `pocet` INT NULL,
  `cena` DOUBLE NULL,
  `Prijemka_id` INT NULL,
  `Vydajka_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pohybMaterialu_Prijemka1_idx` (`Prijemka_id` ASC),
  INDEX `fk_pohybMaterialu_Vydajka1_idx` (`Vydajka_id` ASC),
  CONSTRAINT `fk_pohybMaterialu_Prijemka1`
    FOREIGN KEY (`Prijemka_id`)
    REFERENCES `skladnik`.`Prijemka` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pohybMaterialu_Vydajka1`
    FOREIGN KEY (`Vydajka_id`)
    REFERENCES `skladnik`.`Vydajka` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
