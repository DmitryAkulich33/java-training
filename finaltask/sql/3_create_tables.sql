USE `bakery_db`;

-- Roles:
-- 1 - administrator
-- 2 - courier
-- 3 - client

CREATE TABLE `user` (
	`id_user` INTEGER NOT NULL AUTO_INCREMENT,
	`login` VARCHAR(50) NOT NULL UNIQUE,
	`password` VARCHAR(50) NOT NULL,
	`role` TINYINT NOT NULL CHECK (`role` IN (1, 2, 3)),
    `surname` VARCHAR(100) NOT NULL,
    `name_user` VARCHAR(100) NOT NULL,
    `patronymic` VARCHAR(100) NOT NULL,
    `address` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(40) NOT NULL,
    `note` VARCHAR(255),
	
	CONSTRAINT pk_user PRIMARY KEY (`id_user`)
);

CREATE TABLE `pie` (
	`id_pie` INTEGER NOT NULL AUTO_INCREMENT,
	`name_pie` VARCHAR(60) NOT NULL,
	`weight` INTEGER NOT NULL,
	`price` DOUBLE NOT NULL,
	`description` VARCHAR(2000) NOT NULL,
	`picture` VARCHAR(255) NOT NULL,

	CONSTRAINT pk_pie PRIMARY KEY (`id_pie`)
);

CREATE TABLE `order` (
	`id_order` INTEGER NOT NULL AUTO_INCREMENT,
	`user_id` INTEGER NOT NULL,
    `total` DOUBLE NOT NULL,
	`productionDate` DATETIME,
	`deliveryDate` DATETIME,
	`status` VARCHAR(50),
	
	CONSTRAINT pk_order PRIMARY KEY (`id_order`),
	CONSTRAINT fk_order_user FOREIGN KEY (`user_id`)
	REFERENCES `user`(`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `black_list` (
	`id_list` INTEGER NOT NULL AUTO_INCREMENT,
	`user_id` INTEGER NOT NULL,
	
	CONSTRAINT pk_black_list PRIMARY KEY (`id_list`),
    CONSTRAINT fk_black_list_user FOREIGN KEY (`user_id`)
	REFERENCES `user`(`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `feedback` (
    `id_feedback` INTEGER NOT NULL AUTO_INCREMENT,
    `user_id` INTEGER NOT NULL,
    `feedback_date` DATETIME,
    `review` VARCHAR(2000) NOT NULL,

    CONSTRAINT pk_feedback PRIMARY KEY (`id_feedback`),
    CONSTRAINT fk_feedback_user FOREIGN KEY (`user_id`)
    REFERENCES `user`(`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `order_product` (
    `id_order_product` INTEGER NOT NULL AUTO_INCREMENT,
    `order_id` INTEGER NOT NULL,
    `pie_id` INTEGER NOT NULL,

    CONSTRAINT pk_order_product PRIMARY KEY (`id_order_product`),
    CONSTRAINT order_product_pie FOREIGN KEY (`pie_id`)
    REFERENCES `pie`(`id_pie`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT order_product_order FOREIGN KEY (`order_id`)
    REFERENCES `order`(`id_order`) ON DELETE CASCADE ON UPDATE CASCADE
);

