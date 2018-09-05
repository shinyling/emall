DROP TABLE IF EXISTS `user` ;

CREATE TABLE `user` (
  id VARCHAR(36) NOT NULL ,
  name VARCHAR(20) NOT NULL ,
  phone VARCHAR(15) NOT NULL ,
  password VARCHAR(50) NOT NULL ,
  salt VARCHAR(60),
  status INT DEFAULT 1,
  deleted INT DEFAULT 0,
  createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  createBy VARCHAR(36),
  updateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  updateBy VARCHAR(36),
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8