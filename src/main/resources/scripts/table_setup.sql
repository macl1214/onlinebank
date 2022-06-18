-- Creating database
DROP DATABASE IF EXISTS `banking_system`;
CREATE DATABASE `banking_system`;

USE `banking_system`;

-- Creating USER table
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id`			INT(11) NOT NULL AUTO_INCREMENT,
    `first_name`	VARCHAR(50) NOT NULL,
    `last_name`		VARCHAR(50) NOT NULL,
    `username` 		VARCHAR(50) UNIQUE NOT NULL,
    `email`			VARCHAR(50) UNIQUE NOT NULL,
    `password`		CHAR(68) NOT NULL,
    `active`		BIT(1) NOT NULL,
    
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Creating role table
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
	`id`			INT(11) NOT NULL AUTO_INCREMENT,
    `name`			VARCHAR(50) NOT NULL,
    
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Creating users_roles table
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
	`user_id`		INT(11) NOT NULL,
    `role_id`		INT(11) NOT NULL,
    
    PRIMARY KEY(`user_id`, `role_id`),
    
    FOREIGN KEY(`user_id`) REFERENCES `user`(`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    FOREIGN KEY(`role_id`) REFERENCES `role`(`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Specifies whether or not to check foreign key 
-- constraints for InnoDB tables
-- 
-- '1' is the default value
-- Setting it to '0' is useful when you need to re-create
-- the tables and load data in any parent-child order
SET FOREIGN_KEY_CHECKS=1;

-- Inserting into `user` table
INSERT INTO `user`(`first_name`, `last_name`, `username`, `email`, `password`, `active`) VALUES 
('Miguel', 'Cubas', 'mcubas', 'mcubas1214@gmail.com', '$2a$10$iX43FdYgH5LqbQrwM3/YkO0gCKPWzwzcN7vQTWcs5h0TG9hq5EtCC', 1),
('Oso', 'Cubas', 'ocubas', 'ocubas@gmail.com', '$2a$12$LcCX0wzr5IGDsVAubcDFCOVekNLHeo2WsXRayYjFBUWPR6ElJXhAa', 1);

INSERT INTO `role`(`name`) VALUES
('customer'),
('admin');

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

