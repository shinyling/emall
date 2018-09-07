DROP TABLE IF EXISTS `uc_user_role` ;
DROP TABLE IF EXISTS `uc_role_menu` ;

CREATE TABLE `uc_user_role` (
  user_id VARCHAR(36) NOT NULL ,
  role_id VARCHAR(36) NOT NULL ,
  PRIMARY KEY (user_id,role_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `uc_role_menu` (
  role_id VARCHAR(36) NOT NULL ,
  menu_id VARCHAR(36) NOT NULL ,
  PRIMARY KEY (role_id,menu_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
