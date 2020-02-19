USE `bakery_db`;

-- Roles:
-- 1 - administrator
-- 2 - courier
-- 3 - client

CREATE TABLE `user` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`login` VARCHAR(40) NOT NULL UNIQUE,
	`password` CHAR(40),
	`role` TINYINT NOT NULL CHECK (`role` IN (1, 2, 3)),
	
	CONSTRAINT pk_user PRIMARY KEY (`id`)
);

CREATE TABLE `client` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`surname` VARCHAR(100) NOT NULL,
	`name` VARCHAR(100) NOT NULL,
	`patronymic` VARCHAR(100) NOT NULL,
	`address` VARCHAR(100) NOT NULL,
	`phone` VARCHAR(40) NOT NULL,
	`note` VARCHAR(255),
	
	CONSTRAINT pk_client PRIMARY KEY (`id`)
);

CREATE TABLE `pie` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(60) NOT NULL,
	`weight` INTEGER NOT NULL,
	`price` DOUBLE NOT NULL,
	`description` VARCHAR(255) NOT NULL,

	CONSTRAINT pk_pie PRIMARY KEY (`id`)
);

CREATE TABLE `status` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL,

	CONSTRAINT pk_status PRIMARY KEY (`id`)
);

CREATE TABLE `order` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`client_id` INTEGER NOT NULL,
	`pie_id` INTEGER NOT NULL,
	`productionDate` DATETIME,
	`deliveryDate` DATETIME,
	`status_id` INTEGER,
	
	CONSTRAINT pk_order PRIMARY KEY (`id`),
	CONSTRAINT fk_order_client FOREIGN KEY (`client_id`)
	REFERENCES `client`(`id`),
	CONSTRAINT fk_order_pie FOREIGN KEY (`pie_id`)
	REFERENCES `pie`(`id`),
	CONSTRAINT fk_orders_status FOREIGN KEY (`status_id`)
	REFERENCES `status`(`id`)
);

CREATE TABLE `black_list` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`client_id` INTEGER NOT NULL,
	
	CONSTRAINT pk_black_list PRIMARY KEY (`id`),
    CONSTRAINT fk_black_list_client FOREIGN KEY (`client_id`)
	REFERENCES `client`(`id`)
);

