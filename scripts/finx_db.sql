-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema finx_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `finx_db` ;

-- -----------------------------------------------------
-- Schema finx_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `finx_db` DEFAULT CHARACTER SET utf8 ;
USE `finx_db` ;

-- -----------------------------------------------------
-- Table `finx_db`.`qxma_address_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_address_type` (
  `adr_type_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL COMMENT 'VALUES:\n1. DELIVERY ADDRESS\n2. DROP-OFF ADDRESS\n3. PICK-UP ADDRESS\n4. RETURN ADDRESS',
  PRIMARY KEY (`adr_type_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_dropoff_rates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_dropoff_rates` (
  `dor_id` INT(11) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(30) NULL DEFAULT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  `rates` DECIMAL(19,2) NULL DEFAULT NULL,
  PRIMARY KEY (`dor_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_bank_acct_class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_bank_acct_class` (
  `ba_id` INT(11) NOT NULL,
  `code` VARCHAR(10) NULL DEFAULT NULL COMMENT '1. BUSINESS\n2. PERSONAL',
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ba_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_bank_acct_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_bank_acct_type` (
  `ba_type` INT(11) NOT NULL,
  `code` VARCHAR(10) NULL DEFAULT NULL COMMENT '1. LOCAL\n2. FOREIGN',
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ba_type`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_bank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_bank` (
  `bank_id` BIGINT(20) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `swift_code` VARCHAR(50) NULL DEFAULT NULL,
  `phone_no` VARCHAR(12) NULL DEFAULT NULL,
  `time_stamp_tz` DATETIME(6) NULL DEFAULT NULL,
  `bank_account_type_ba_type` INT(11) NOT NULL,
  `bank_account_class_ba_id` INT(11) NOT NULL,
  PRIMARY KEY (`bank_id`, `bank_account_type_ba_type`, `bank_account_class_ba_id`),
  INDEX `fk_qxma_ft_bank_bank_account_type1_idx` (`bank_account_type_ba_type` ASC),
  INDEX `fk_qxma_ft_bank_bank_account_class1_idx` (`bank_account_class_ba_id` ASC),
  CONSTRAINT `fk_qxma_ft_bank_bank_account_class1`
    FOREIGN KEY (`bank_account_class_ba_id`)
    REFERENCES `finx_db`.`qxma_ft_bank_acct_class` (`ba_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_bank_bank_account_type1`
    FOREIGN KEY (`bank_account_type_ba_type`)
    REFERENCES `finx_db`.`qxma_ft_bank_acct_type` (`ba_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_charge_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_charge_status` (
  `cs_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(10) NOT NULL COMMENT 'VALUES:\n1. PENDING\n2. PAID\n3. REMITTED',
  `description` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`cs_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_match_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_match_status` (
  `ms_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(20) NOT NULL,
  `description` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`ms_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_party_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_party_type` (
  `pt_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `party_type` VARCHAR(50) NULL DEFAULT NULL COMMENT 'VALUES:\n1. ORGANIZATION\n2. USER',
  PRIMARY KEY (`pt_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_parties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_parties` (
  `party_id` BIGINT(20) NOT NULL,
  `pt_id` BIGINT(20) NOT NULL,
  `external_id` VARCHAR(100) NULL DEFAULT NULL,
  `status` TINYINT(4) NULL DEFAULT NULL,
  `metadata` JSON NULL DEFAULT NULL,
  `created_by` BIGINT(20) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `updated_by` BIGINT(20) NULL DEFAULT NULL,
  `last_disbursed_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`party_id`),
  INDEX `fk_qxma_ft_parties_party_type1_idx` (`pt_id` ASC),
  CONSTRAINT `fk_qxma_ft_parties_party_type1`
    FOREIGN KEY (`pt_id`)
    REFERENCES `finx_db`.`qxma_ft_party_type` (`pt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_charges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_charges` (
  `order_id` BIGINT(20) NOT NULL,
  `charge_status_id` BIGINT(20) NOT NULL,
  `match_status_id` BIGINT(20) NULL DEFAULT NULL,
  `party_id` BIGINT(20) NULL DEFAULT NULL,
  `reference_id` VARCHAR(255) NULL DEFAULT NULL,
  `deposit_id` BIGINT(20) NULL DEFAULT NULL,
  `total_amount` DECIMAL(19,2) NULL DEFAULT '0.00',
  `tendered_amount` DECIMAL(19,2) NULL DEFAULT '0.00',
  `change_amount` DECIMAL(19,2) NULL DEFAULT '0.00',
  `remarks` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL COMMENT 'default to current system date',
  `updated_by` BIGINT(20) NULL DEFAULT NULL,
  `updated_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_qxma_ft_charges_qxma_ft_charge_status1_idx` (`charge_status_id` ASC),
  INDEX `fk_qxma_ft_charges_qxma_ft_match_status1_idx` (`match_status_id` ASC),
  INDEX `fk_qxma_ft_charges_qxma_ft_parties1_idx` (`party_id` ASC),
  CONSTRAINT `fk_qxma_ft_charges_qxma_ft_charge_status1`
    FOREIGN KEY (`charge_status_id`)
    REFERENCES `finx_db`.`qxma_ft_charge_status` (`cs_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_charges_qxma_ft_match_status1`
    FOREIGN KEY (`match_status_id`)
    REFERENCES `finx_db`.`qxma_ft_match_status` (`ms_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_charges_qxma_ft_parties1`
    FOREIGN KEY (`party_id`)
    REFERENCES `finx_db`.`qxma_ft_parties` (`party_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_currencies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_currencies` (
  `currency_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `code` VARCHAR(5) NOT NULL,
  `symbol` VARCHAR(3) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`currency_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_ledger_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_ledger_status` (
  `ledger_status_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(10) NOT NULL COMMENT 'VALUES:\n1. SETTLED\n2. PENDING',
  `description` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`ledger_status_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_ledger_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_ledger_type` (
  `ledger_type_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(10) NOT NULL COMMENT 'VALUES:\n1. PAYABLE\n2. RECEIVABLE',
  `description` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`ledger_type_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_transfer_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_transfer_type` (
  `type_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(30) NOT NULL COMMENT 'Code:\n1. purchase\n2. transfer\n3. refund\n4. reward\n5. escrow\n6. disbursement\n7. settlement\n8. sale\n9. fund\n10. return\n11. claim\n12. collection\n13. collection_reversal\n14. sales_reversal',
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`type_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_wallet_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_wallet_type` (
  `wt_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(30) NULL DEFAULT NULL COMMENT 'Code:\n1. COLLECTION\n2. FUND\n3. SALES\n4. SETTLEMENT',
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`wt_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_wallet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_wallet` (
  `wallet_id` BIGINT(20) NOT NULL,
  `parties_id` BIGINT(20) NOT NULL,
  `wt_id` BIGINT(20) NOT NULL,
  `currency_id` BIGINT(20) NOT NULL,
  `amount` DECIMAL(19,2) NULL DEFAULT '0.00',
  `credit_limit` DECIMAL(19,2) NULL DEFAULT '0.00',
  `max_limit` DECIMAL(19,2) NULL DEFAULT '0.00',
  `status` SMALLINT(1) NULL DEFAULT '1',
  `created_by` BIGINT(20) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `updated_by` BIGINT(20) NULL DEFAULT NULL,
  `updated_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`wallet_id`),
  INDEX `fk_qxma_ft_wallet_qxma_ft_parties1_idx` (`parties_id` ASC),
  INDEX `fk_qxma_ft_wallet_qxma_ft_wallet_type1_idx` (`wt_id` ASC),
  INDEX `fk_qxma_ft_wallet_qxma_ft_currencies1_idx` (`currency_id` ASC),
  CONSTRAINT `fk_qxma_ft_wallet_qxma_ft_currencies1`
    FOREIGN KEY (`currency_id`)
    REFERENCES `finx_db`.`qxma_ft_currencies` (`currency_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_wallet_qxma_ft_parties1`
    FOREIGN KEY (`parties_id`)
    REFERENCES `finx_db`.`qxma_ft_parties` (`party_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_wallet_qxma_ft_wallet_type1`
    FOREIGN KEY (`wt_id`)
    REFERENCES `finx_db`.`qxma_ft_wallet_type` (`wt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_transfer` (
  `transfer_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `from_wallet_id` BIGINT(20) NOT NULL,
  `to_wallet_id` BIGINT(20) NOT NULL,
  `type_id` BIGINT(20) NOT NULL,
  `amount` DECIMAL(19,2) NULL DEFAULT NULL,
  `details` VARCHAR(255) NULL DEFAULT NULL,
  `ip_address` VARCHAR(30) NULL DEFAULT NULL,
  `reference_id` VARCHAR(255) NULL DEFAULT NULL,
  `transaction_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`transfer_id`),
  UNIQUE INDEX `transaction_id_UNIQUE` (`transaction_id` ASC),
  INDEX `fk_qxma_ft_transfer_qxma_ft_wallet1_idx` (`from_wallet_id` ASC),
  INDEX `fk_qxma_ft_transfer_qxma_ft_wallet2_idx` (`to_wallet_id` ASC),
  INDEX `fk_qxma_ft_transfer_qxma_ft_transfer_type1_idx` (`type_id` ASC),
  CONSTRAINT `fk_qxma_ft_transfer_qxma_ft_transfer_type1`
    FOREIGN KEY (`type_id`)
    REFERENCES `finx_db`.`qxma_ft_transfer_type` (`type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_transfer_qxma_ft_wallet1`
    FOREIGN KEY (`from_wallet_id`)
    REFERENCES `finx_db`.`qxma_ft_wallet` (`wallet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_transfer_qxma_ft_wallet2`
    FOREIGN KEY (`to_wallet_id`)
    REFERENCES `finx_db`.`qxma_ft_wallet` (`wallet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_ledger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_ledger` (
  `ledger_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `party_id` BIGINT(20) NOT NULL,
  `currency_id` BIGINT(20) NOT NULL,
  `transfer_id` BIGINT(20) NOT NULL,
  `ledger_type_id` BIGINT(20) NOT NULL,
  `ledger_status_id` BIGINT(20) NOT NULL,
  `breakdown` JSON NULL DEFAULT NULL,
  `amount` DECIMAL(19,2) NULL DEFAULT '0.00',
  `reference_id` VARCHAR(255) NULL DEFAULT NULL,
  `bank_details` JSON NULL DEFAULT NULL,
  `remarks` VARCHAR(255) NULL DEFAULT NULL,
  `period` DATETIME(6) NULL DEFAULT NULL,
  `closed_at` DATETIME(6) NULL DEFAULT NULL,
  `settled_at` DATETIME(6) NULL DEFAULT NULL,
  `settled_by` BIGINT(20) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `updated_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`ledger_id`),
  INDEX `fk_qxma_ft_ledger_qxma_ft_parties1_idx` (`party_id` ASC),
  INDEX `fk_qxma_ft_ledger_qxma_ft_currencies1_idx` (`currency_id` ASC),
  INDEX `fk_qxma_ft_ledger_qxma_ft_ledger_type1_idx` (`ledger_type_id` ASC),
  INDEX `fk_qxma_ft_ledger_qxma_ft_ledger_status1_idx` (`ledger_status_id` ASC),
  INDEX `fk_qxma_ft_ledger_qxma_ft_transfer1_idx` (`transfer_id` ASC),
  CONSTRAINT `fk_qxma_ft_ledger_qxma_ft_currencies1`
    FOREIGN KEY (`currency_id`)
    REFERENCES `finx_db`.`qxma_ft_currencies` (`currency_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_ledger_qxma_ft_ledger_status1`
    FOREIGN KEY (`ledger_status_id`)
    REFERENCES `finx_db`.`qxma_ft_ledger_status` (`ledger_status_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_ledger_qxma_ft_ledger_type1`
    FOREIGN KEY (`ledger_type_id`)
    REFERENCES `finx_db`.`qxma_ft_ledger_type` (`ledger_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_ledger_qxma_ft_parties1`
    FOREIGN KEY (`party_id`)
    REFERENCES `finx_db`.`qxma_ft_parties` (`party_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_ledger_qxma_ft_transfer1`
    FOREIGN KEY (`transfer_id`)
    REFERENCES `finx_db`.`qxma_ft_transfer` (`transfer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_remittance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_remittance` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT(20) NULL DEFAULT NULL,
  `reference_id` VARCHAR(255) NULL DEFAULT NULL,
  `bank_name` VARCHAR(255) NULL DEFAULT NULL,
  `bank_ref` VARCHAR(255) NULL DEFAULT NULL,
  `amount_deposited` DECIMAL(19,2) NULL DEFAULT NULL,
  `created_by` BIGINT(20) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `updated_by` BIGINT(20) NULL DEFAULT NULL,
  `updated_at` DATETIME(6) NULL DEFAULT NULL,
  `remitted_by` VARCHAR(255) NULL DEFAULT NULL,
  `remitted_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_ft_wallet_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_ft_wallet_log` (
  `log_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `wallet_id` BIGINT(20) NOT NULL,
  `transfer_id` BIGINT(20) NOT NULL,
  `amount` DECIMAL(19,2) NULL DEFAULT NULL,
  `running_balance` DECIMAL(19,2) NULL DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  INDEX `fk_qxma_ft_wallet_log_qxma_ft_wallet1_idx` (`wallet_id` ASC),
  INDEX `fk_qxma_ft_wallet_log_qxma_ft_transfer1_idx` (`transfer_id` ASC),
  CONSTRAINT `fk_qxma_ft_wallet_log_qxma_ft_transfer1`
    FOREIGN KEY (`transfer_id`)
    REFERENCES `finx_db`.`qxma_ft_transfer` (`transfer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_ft_wallet_log_qxma_ft_wallet1`
    FOREIGN KEY (`wallet_id`)
    REFERENCES `finx_db`.`qxma_ft_wallet` (`wallet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_payload`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_payload` (
  `payload_id` VARCHAR(15) NOT NULL COMMENT 'Order ID',
  `tracking_number` VARCHAR(50) NOT NULL,
  `type` VARCHAR(10) NULL DEFAULT NULL,
  `consignor` JSON NULL DEFAULT NULL,
  `currency` VARCHAR(3) NULL DEFAULT NULL,
  `fees` JSON NULL DEFAULT NULL,
  `grand_total` DOUBLE NULL DEFAULT NULL,
  `ip_address` VARCHAR(15) NULL DEFAULT NULL,
  `metadata` JSON NULL DEFAULT NULL,
  `parcel` JSON NULL DEFAULT NULL,
  `parent_id` BIGINT(15) NULL DEFAULT NULL,
  `payment` JSON NULL DEFAULT NULL,
  `reference_id` VARCHAR(50) NULL DEFAULT NULL,
  `service` VARCHAR(50) NULL DEFAULT NULL,
  `shipment` VARCHAR(50) NULL DEFAULT NULL,
  `status` VARCHAR(50) NULL DEFAULT NULL,
  `status_updated_at` DATETIME(6) NULL DEFAULT NULL,
  `tat` JSON NULL DEFAULT NULL,
  `group_id` VARCHAR(45) NULL DEFAULT NULL COMMENT 'system generated using UUID - this will used to identify that the transactions have been billed already.',
  `is_disallowed` TINYINT(4) NULL DEFAULT '0',
  PRIMARY KEY (`payload_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_pl_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_pl_address` (
  `da_id` BIGINT(20) NOT NULL,
  `payload_id` VARCHAR(15) NOT NULL,
  `adr_type_id` INT(11) NOT NULL,
  `type` VARCHAR(10) NULL DEFAULT NULL,
  `firstname` VARCHAR(50) NULL DEFAULT NULL,
  `lastname` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `phone_number` VARCHAR(10) CHARACTER SET 'big5' COLLATE 'big5_bin' NULL DEFAULT NULL,
  `mobile_number` VARCHAR(12) NULL DEFAULT NULL,
  `line1` VARCHAR(100) NULL DEFAULT NULL,
  `line2` VARCHAR(100) NULL DEFAULT NULL,
  `district` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `postal_code` VARCHAR(4) NULL DEFAULT NULL,
  `region` VARCHAR(3) NULL DEFAULT NULL,
  `latitude` VARCHAR(10) NULL DEFAULT NULL,
  `longtitude` VARCHAR(10) NULL DEFAULT NULL,
  `country` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`da_id`, `payload_id`, `adr_type_id`),
  INDEX `fk_qxma_pl_address_address_type1_idx` (`adr_type_id` ASC),
  INDEX `fk_qxma_pl_address_qxma_payload1_idx` (`payload_id` ASC),
  CONSTRAINT `fk_qxma_pl_address_address_type1`
    FOREIGN KEY (`adr_type_id`)
    REFERENCES `finx_db`.`qxma_address_type` (`adr_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qxma_pl_address_qxma_payload1`
    FOREIGN KEY (`payload_id`)
    REFERENCES `finx_db`.`qxma_payload` (`payload_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_pl_breakdown`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_pl_breakdown` (
  `bd_id` BIGINT(15) NOT NULL AUTO_INCREMENT,
  `payload_id` VARCHAR(15) NOT NULL,
  `sub_total` DECIMAL(19,2) NULL DEFAULT NULL,
  `shipping` DECIMAL(19,2) NULL DEFAULT NULL,
  `tax` DECIMAL(19,2) NULL DEFAULT NULL,
  `fee` DECIMAL(19,2) NULL DEFAULT NULL,
  `insurance` DECIMAL(19,2) NULL DEFAULT NULL,
  `discount` DECIMAL(19,2) NULL DEFAULT NULL,
  PRIMARY KEY (`bd_id`, `payload_id`),
  INDEX `fk_quadx_ma_breakdown_quadx_ma_payload1_idx` (`payload_id` ASC),
  CONSTRAINT `fk_quadx_ma_breakdown_quadx_ma_payload1`
    FOREIGN KEY (`payload_id`)
    REFERENCES `finx_db`.`qxma_payload` (`payload_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_pl_consignee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_pl_consignee` (
  `consignee_id` BIGINT(20) NOT NULL,
  `payload_id` VARCHAR(15) NOT NULL,
  `firstname` VARCHAR(50) NOT NULL,
  `lastname` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `contact_number` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`consignee_id`, `payload_id`),
  INDEX `fk_quadx_ma_consignee_quadx_ma_payload1_idx` (`payload_id` ASC),
  CONSTRAINT `fk_quadx_ma_consignee_quadx_ma_payload1`
    FOREIGN KEY (`payload_id`)
    REFERENCES `finx_db`.`qxma_payload` (`payload_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_pl_event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_pl_event` (
  `pl_event_id` BIGINT(20) NOT NULL,
  `payload_id` VARCHAR(15) NOT NULL,
  `status` VARCHAR(50) NULL DEFAULT NULL,
  `remarks` VARCHAR(254) NULL DEFAULT NULL,
  `created_by` VARCHAR(50) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `status_updated_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`pl_event_id`, `payload_id`),
  INDEX `fk_quadx_oms_pl_event_quadx_oms_payload_idx` (`payload_id` ASC),
  CONSTRAINT `fk_quadx_oms_pl_event_quadx_oms_payload`
    FOREIGN KEY (`payload_id`)
    REFERENCES `finx_db`.`qxma_payload` (`payload_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_pl_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_pl_item` (
  `item_id` BIGINT(20) NOT NULL,
  `payload_id` VARCHAR(15) NOT NULL,
  `type` VARCHAR(10) NULL DEFAULT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `total` DECIMAL(19,2) NULL DEFAULT NULL,
  `metadata` JSON NULL DEFAULT NULL,
  `insured_value` DECIMAL(19,2) NULL DEFAULT NULL,
  PRIMARY KEY (`item_id`, `payload_id`),
  INDEX `fk_qxma_pl_item_qxma_payload1_idx` (`payload_id` ASC),
  CONSTRAINT `fk_qxma_pl_item_qxma_payload1`
    FOREIGN KEY (`payload_id`)
    REFERENCES `finx_db`.`qxma_payload` (`payload_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_role` (
  `role_id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'Unique identifier for each role.',
  `role_name` VARCHAR(70) NOT NULL COMMENT 'User friendly name for each role.',
  `role_description` VARCHAR(150) NULL DEFAULT NULL COMMENT 'The description and purpose of each role.',
  `status` INT(1) NOT NULL COMMENT 'The status of a role. 0=INACTIVE, 1=ACTIVE. If a role is inactive, users with the assigned role should be able to login, and the role itself should be assignable. ',
  `created_by` BIGINT(20) NULL DEFAULT NULL,
  `creation_date` DATETIME NULL DEFAULT NULL,
  `updated_by` BIGINT(20) NULL DEFAULT NULL,
  `update_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_id_UNIQUE` (`role_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finx_db`.`qxma_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`qxma_user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Unique identifier foor  each user in the application.',
  `username` VARCHAR(50) NOT NULL COMMENT 'The string combination used to login to the application and logically identify each user in the application.',
  `password` VARCHAR(50) NOT NULL COMMENT 'The secret string combination used to login the application. Encryted as Base64.',
  `first_name` VARCHAR(100) NOT NULL COMMENT 'The users first name.',
  `last_name` VARCHAR(100) NOT NULL COMMENT 'The users last name.',
  `status` INT(1) NOT NULL COMMENT 'Indicates of the user is 0=INACTIVE or 1=ACTIVE. If the user is inactive, the user should be allowed to login to the application.',
  `is_first_login` INT(1) NOT NULL COMMENT 'Indicates if the user should change their  password because it is their first time logging into the application.  1=The user should change their pssword upon login. 0=The user does not need t ochange password upon login.',
  `role_id` INT(10) NOT NULL COMMENT 'Indicates a reference to the users role.',
  `created_by` BIGINT(20) NULL DEFAULT NULL,
  `creation_date` DATETIME NULL DEFAULT NULL,
  `updated_by` BIGINT(20) NULL DEFAULT NULL,
  `update_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `qxma_user_role_idx` (`role_id` ASC),
  CONSTRAINT `qxma_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `finx_db`.`qxma_role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

USE `finx_db` ;

-- -----------------------------------------------------
-- Placeholder table for view `finx_db`.`remittance_view`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finx_db`.`remittance_view` (`order_id` INT, `transaction_date` INT, `reference_number` INT, `tracking_number` INT, `client` INT, `amount` INT, `matched_amount` INT, `variance_amount` INT, `order_status` INT, `match_status` INT, `payment_processor` INT);

-- -----------------------------------------------------
-- View `finx_db`.`remittance_view`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `finx_db`.`remittance_view`;
USE `finx_db`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `finx_db`.`remittance_view` AS select `qfc`.`order_id` AS `order_id`,`qfr`.`created_at` AS `transaction_date`,`qfr`.`bank_ref` AS `reference_number`,`qfc`.`reference_id` AS `tracking_number`,'client' AS `client`,`qfr`.`amount_deposited` AS `amount`,`qfc`.`tendered_amount` AS `matched_amount`,`qfc`.`change_amount` AS `variance_amount`,`qfcs`.`code` AS `order_status`,`qfms`.`code` AS `match_status`,'payment_processor' AS `payment_processor` from (((`finx_db`.`qxma_ft_remittance` `qfr` left join `finx_db`.`qxma_ft_charges` `qfc` on((`qfr`.`reference_id` = `qfc`.`reference_id`))) left join `finx_db`.`qxma_ft_charge_status` `qfcs` on((`qfc`.`charge_status_id` = `qfcs`.`cs_id`))) left join `finx_db`.`qxma_ft_match_status` `qfms` on((`qfms`.`ms_id` = `qfc`.`match_status_id`)));

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
