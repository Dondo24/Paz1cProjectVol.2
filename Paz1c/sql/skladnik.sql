-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Skladnik` DEFAULT CHARACTER SET utf8 ;
USE `Skladnik` ;

-- -----------------------------------------------------
-- Table `mydb`.`Sklad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Skladnik`.`Sklad` (
  `id` INT NOT NULL,
  `Nazov` VARCHAR(45) NULL,
  `Adresa` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pouzivatel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Skladnik`.`Pouzivatel` (
  `id` INT NOT NULL,
  `Meno` VARCHAR(45) NULL,
  `Sklad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pouzivatel_Sklad1_idx` (`Sklad_id` ASC),
  CONSTRAINT `fk_Pouzivatel_Sklad1`
    FOREIGN KEY (`Sklad_id`)
    REFERENCES `mydb`.`Sklad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Skladnik`.`Material` (
  `id` INT NOT NULL,
  `Nazov` VARCHAR(45) NULL,
  `Stav` INT NULL,
  `Cena` DOUBLE NULL,
  `Sklad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Material_Sklad1_idx` (`Sklad_id` ASC),
  CONSTRAINT `fk_Material_Sklad1`
    FOREIGN KEY (`Sklad_id`)
    REFERENCES `mydb`.`Sklad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Prijemka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Skladnik`.`Prijemka` (
  `id` INT NOT NULL,
  `Pocet` INT NULL,
  `cena` DOUBLE NULL,
  `Pouzivatel_id` INT NOT NULL,
  `Material_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Prijemka_Pouzivatel_idx` (`Pouzivatel_id` ASC),
  INDEX `fk_Prijemka_Material1_idx` (`Material_id` ASC),
  CONSTRAINT `fk_Prijemka_Pouzivatel`
    FOREIGN KEY (`Pouzivatel_id`)
    REFERENCES `mydb`.`Pouzivatel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prijemka_Material1`
    FOREIGN KEY (`Material_id`)
    REFERENCES `mydb`.`Material` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vydajka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Skladnik`.`Vydajka` (
  `id` INT NOT NULL,
  `Pocet` INT NULL,
  `Pouzivatel_id` INT NOT NULL,
  `Material_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Prijemka_Pouzivatel_idx` (`Pouzivatel_id` ASC),
  INDEX `fk_Vydajka_Material1_idx` (`Material_id` ASC),
  CONSTRAINT `fk_Prijemka_Pouzivatel0`
    FOREIGN KEY (`Pouzivatel_id`)
    REFERENCES `mydb`.`Pouzivatel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vydajka_Material1`
    FOREIGN KEY (`Material_id`)
    REFERENCES `mydb`.`Material` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
