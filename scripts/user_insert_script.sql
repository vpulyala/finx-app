INSERT INTO `finx_db`.`qxma_role` (`role_id`, `role_name`, `role_description`, `status`, `created_by`, `creation_date`, `updated_by`, `update_date`) VALUES ('1', 'Administrator', 'Administrator', '1', '1', NOW(), '1', NOW());
INSERT INTO `finx_db`.`qxma_user` (`user_id`, `username`, `password`, `first_name`, `last_name`, `status`, `is_first_login`, `role_id`, `created_by`, `creation_date`, `updated_by`, `update_date`) VALUES ('1', 'qxadmin', 'NTU5', 'Admin', 'Admin', '1', '0', '1', '1', NOW(), '1', NOW());

-- password NTU5 is equivalent to 559