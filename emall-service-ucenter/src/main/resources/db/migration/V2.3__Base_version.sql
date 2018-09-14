DROP TABLE IF EXISTS `uc_user` ;

CREATE TABLE `uc_user` (
  id VARCHAR(36) NOT NULL ,
  username VARCHAR(20) NOT NULL ,
  phone VARCHAR(15) NOT NULL ,
  password VARCHAR(128) NOT NULL ,
  salt VARCHAR(60),
  open_id VARCHAR(50) COMMENT '微信id',
  status INT NOT NULL DEFAULT 1,
  deleted INT NOT NULL DEFAULT 0,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  create_by VARCHAR(36),
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  update_by VARCHAR(36),
  PRIMARY KEY (id)
);
CREATE TABLE t_company(
  id VARCHAR(36),
  parent_id VARCHAR(36),
  company_name VARCHAR(200),
  company_code VARCHAR(200),
  create_time TIMESTAMP,
  zip_code VARCHAR(12),
  address VARCHAR(200),
  email VARCHAR(50),
  web_site VARCHAR(200),
  fax VARCHAR(50),
  tel VARCHAR(50),
  bank VARCHAR(100),
  bank_account VARCHAR(50) COMMENT '银行账户',
  legal_name VARCHAR(20) COMMENT '法人名称',
  legal_tel VARCHAR(20) COMMENT '法人电话',
  PRIMARY KEY (id)
);
CREATE TABLE t_dept(
  id VARCHAR(36),
  parent_id VARCHAR(36),
  company_id VARCHAR(36),
  dept_name VARCHAR(200),
  create_time TIMESTAMP,
  dept_code VARCHAR(50),
  tel VARCHAR(50),
  fax VARCHAR(50),
  zip_code VARCHAR(20),
  address VARCHAR(200),
  PRIMARY KEY (id)
);
CREATE TABLE t_employee(
  id VARCHAR(36),
  user_id VARCHAR(36),
  company_id VARCHAR(36),
  dept_id VARCHAR(36),
  create_time TIMESTAMP,
  employee_code VARCHAR(10),
  employee_position VARCHAR(50) COMMENT '职位',
  entry_time TIMESTAMP COMMENT '入职时间',
  PRIMARY KEY (id)
);
CREATE TABLE t_user(
  id VARCHAR(36),
  avatar VARCHAR(50) COMMENT '头像',
  user_id VARCHAR(36) COMMENT 'Uc_user中的id',
  user_name VARCHAR(20),
  create_time TIMESTAMP,
  sex INT,
  birthday TIMESTAMP,
  email VARCHAR(50),
  idcard VARCHAR(50) COMMENT '身份证号',
  PRIMARY KEY (id)
);
CREATE TABLE t_dictionary(
  id VARCHAR(36),
  dic_code VARCHAR(50) COMMENT '字典编码',
  parent_code VARCHAR(50) COMMENT '父编码',
  dic_name VARCHAR(100),
  dic_desc VARCHAR(200),
  PRIMARY KEY (id)
);
CREATE TABLE t_attachment(
  id VARCHAR(36),
  group_id VARCHAR(50),
  file_path VARCHAR(200),
  file_name VARCHAR(200),
  file_size INT,
  create_time TIMESTAMP,
  create_by VARCHAR(36),
  record_table VARCHAR(100) COMMENT '主记录所属表',
  PRIMARY KEY (id)
);
CREATE TABLE uc_app(
  id VARCHAR(36),
  app_name VARCHAR(200) COMMENT '业务系统名称',
  secret_key VARCHAR(200) COMMENT '接入密钥',
  app_logo VARCHAR(200),
  index_url VARCHAR(200),
  user_notify_url VARCHAR(200) COMMENT '用户信息变更通知',
  dept_notify_url VARCHAR(200) COMMENT '组织信息变更通知',
  logout_notify_url VARCHAR(200) COMMENT '单点退出通知',
  PRIMARY KEY (id)
);
CREATE TABLE uc_button(
  id VARCHAR(36),
  app_id VARCHAR(36),
  button_code VARCHAR(100) COMMENT '资源编码',
  button_name VARCHAR(50) COMMENT '资源名称',
  button_class VARCHAR(200) COMMENT '资源分类',
  order_num INT,
  PRIMARY KEY (id)
);
CREATE TABLE uc_data(
  id VARCHAR(36),
  app_id VARCHAR(36),
  data_code VARCHAR(100) COMMENT '数据编码',
  data_name VARCHAR(200) COMMENT '数据名称',
  data_class VARCHAR(200) COMMENT '数据分类',
  data_expression VARCHAR(2000) COMMENT '数据sql',
  order_num INT,
  PRIMARY KEY (id)
);
DROP TABLE IF EXISTS uc_menu;
CREATE TABLE `uc_menu` (
  id VARCHAR(36) NOT NULL ,
  app_id VARCHAR(36),
  code VARCHAR(20) NOT NULL ,
  p_code VARCHAR(20),
  p_id VARCHAR(20),
  name VARCHAR(30) NOT NULL ,
  url VARCHAR(50) ,
  level INT NOT NULL ,
  sort int NOT NULL ,
  status INT NOT NULL DEFAULT 1,
  icon VARCHAR(20),
  PRIMARY KEY (id)
);
DROP TABLE IF EXISTS uc_role;
CREATE TABLE `uc_role` (
  id VARCHAR(36) NOT NULL ,
  app_id VARCHAR(36),
  company_id VARCHAR(36),
  name VARCHAR(20) NOT NULL ,
  value VARCHAR(15) NOT NULL ,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  create_by VARCHAR(36),
  update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  update_by VARCHAR(36),
  status INT NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);
CREATE TABLE uc_role_company(
  role_id VARCHAR(36),
  company_id VARCHAR(36),
  PRIMARY KEY (role_id,company_id)
);
CREATE TABLE uc_role_button(
  role_id VARCHAR(36),
  button_id VARCHAR(36),
  PRIMARY KEY (role_id,button_id)
);
CREATE TABLE uc_role_data(
  data_id VARCHAR(36),
  role_id VARCHAR(36),
  PRIMARY KEY (role_id,data_id)
);
create TABLE uc_role_employee(
  role_id VARCHAR(36),
  employee_id VARCHAR(36),
  PRIMARY KEY (role_id,employee_id)
)