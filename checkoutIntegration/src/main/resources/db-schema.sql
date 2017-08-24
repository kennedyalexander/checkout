CREATE TABLE USERS (
    u_username VARCHAR(25) NOT NULL,
    u_password VARCHAR(50) NOT NULL,
    u_active INT NOT NULL,
    PRIMARY KEY (u_username));


CREATE TABLE USER_ROLES (
    r_id int(11) auto_increment primary key,
    r_username varchar(45) NOT NULL,
    r_role varchar(45) NOT NULL,
    UNIQUE KEY uis_username_role (r_role,r_username),
    FOREIGN KEY (r_username) REFERENCES USERS(u_username));
  
CREATE TABLE USER_INFORMATION (
    ui_username VARCHAR(25) NOT NULL,
    ui_firstname VARCHAR(25) NOT NULL,
    ui_lastname VARCHAR(25) NOT NULL,
    ui_email VARCHAR(100) NOT NULL,
    ui_dob DATE NOT NULL,
    ui_location VARCHAR(25) NOT NULL,
    PRIMARY KEY (ui_username),
    FOREIGN KEY (ui_username) REFERENCES USERS(u_username));
    

  