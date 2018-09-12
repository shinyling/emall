-- used in tests that use HSQL
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication BLOB,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication BLOB
);

create table oauth_code (
  code VARCHAR(256), authentication VARCHAR(512)
);

create table oauth_approvals (
  userId VARCHAR(256),
  clientId VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresAt TIMESTAMP,
  lastModifiedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- customized oauth_client_details table
create table ClientDetails (
  appId VARCHAR(256) PRIMARY KEY,
  resourceIds VARCHAR(256),
  appSecret VARCHAR(256),
  scope VARCHAR(256),
  grantTypes VARCHAR(256),
  redirectUrl VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(256)
);

INSERT INTO `oauth_client_details` VALUES ('acme', 'oauth2-resource', 'acmesecret', 'app', 'authorization_code', '', null, null, null, null, 'app'), ('client', 'oauth2-resource', 'secret', 'app', 'authorization_code', '', null, null, null, null, null), ('my-trusted-client', 'oauth2-resource', null, 'read', 'authorization_code', null, null, null, null, null, '');
INSERT INTO uc_user(id, avatar, username, phone, name, password, salt, birthday, sex, email, status, deleted, create_time, create_by, update_time, update_by)
VALUES (1,NULL ,'shiny','13786132605','ling','123456','','2000-10-20','1','shiny123400@163.com',1,0,now(),'shiny',now(),'shiny');
INSERT INTO uc_role(id, name, value, create_by, update_by) VALUES
  (1,'USER','USER','shiny','shiny'),
  (2,'ADMIN','ADMIN','shiny','shiny');
INSERT INTO uc_user_role (user_id, role_id) VALUES (1,1);
INSERT INTO uc_menu(id, code, p_code, p_id, name, url, level, sort, icon) VALUES
  (1,'home',null,0,'首页','/home',0,0,'home');
INSERT INTO uc_role_menu(role_id, menu_id) VALUES (1,1),(2,1);