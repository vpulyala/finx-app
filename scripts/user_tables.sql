CREATE TABLE `finx_db`.`qxma_user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Unique identifier foor  each user in the application.',
  `username` VARCHAR(50) NOT NULL COMMENT 'The string combination used to login to the application and logically identify each user in the application.',
  `password` VARCHAR(50) NOT NULL COMMENT 'The secret string combination used to login the application. Encryted as Base64.',
  `first_name` VARCHAR(100) NOT NULL COMMENT 'The users first name.',
  `last_name` VARCHAR(100) NOT NULL COMMENT 'The users last name.',
  `status` INT(1) NOT NULL COMMENT 'Indicates of the user is 0=INACTIVE or 1=ACTIVE. If the user is inactive, the user should be allowed to login to the application.',
  `is_first_login` INT(1) NOT NULL COMMENT 'Indicates if the user should change their  password because it is their first time logging into the application.  1=The user should change their pssword upon login. 0=The user does not need t ochange password upon login.',
  `role_id` INT(10) NOT NULL COMMENT 'Indicates a reference to the users role.',
  `created_by` BIGINT(20) NULL,
  `creation_date` DATETIME NULL,
  `updated_by` BIGINT(20) NULL DEFAULT NULL,
  `update_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC));

  
  
 CREATE TABLE `finx_db`.`qxma_role` (
  `role_id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'Unique identifier for each role.',
  `role_name` VARCHAR(70) NOT NULL COMMENT 'User friendly name for each role.',
  `role_description` VARCHAR(150) NULL DEFAULT NULL COMMENT 'The description and purpose of each role.',
  `status` INT(1) NOT NULL COMMENT 'The status of a role. 0=INACTIVE, 1=ACTIVE. If a role is inactive, users with the assigned role should be able to login, and the role itself should be assignable. ',
  `created_by` BIGINT(20) NULL,
  `creation_date` DATETIME NULL DEFAULT NULL,
  `updated_by` BIGINT(20) NULL DEFAULT NULL,
  `update_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_id_UNIQUE` (`role_id` ASC));
  
  
ALTER TABLE `finx_db`.`qxma_user` 
ADD UNIQUE INDEX `username_UNIQUE` (`username` ASC),
ADD INDEX `qxma_user_role_idx` (`role_id` ASC);
ALTER TABLE `finx_db`.`qxma_user` 
ADD CONSTRAINT `qxma_user_role`
  FOREIGN KEY (`role_id`)
  REFERENCES `finx_db`.`qxma_role` (`role_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

