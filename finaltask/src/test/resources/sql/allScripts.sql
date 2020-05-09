DROP DATABASE IF EXISTS `test_bakery_db`;

CREATE DATABASE IF NOT EXISTS `test_bakery_db` DEFAULT CHARACTER SET utf8;

CREATE USER IF NOT EXISTS 'test_bakery_app'@'localhost' IDENTIFIED BY 'test_bakery_password';

GRANT SELECT, INSERT, UPDATE, DELETE
    ON test_bakery_db.*
    TO 'test_bakery_app'@'localhost';
USE `test_bakery_db`;

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
                       `name_pie` VARCHAR(30) NOT NULL,
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

CREATE TABLE `basket` (
                          `id_basket` INTEGER NOT NULL AUTO_INCREMENT,
                          `user_login` VARCHAR(50) NOT NULL,
                          `total` DOUBLE NOT NULL,

                          CONSTRAINT pk_basket PRIMARY KEY (`id_basket`),
                          CONSTRAINT fk_basket_user FOREIGN KEY (`user_login`)
                              REFERENCES `user`(`login`) ON DELETE CASCADE ON UPDATE CASCADE
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
                                 `order_amount` INTEGER NOT NULL,
                                 `order_cost` DOUBLE NOT NULL,

                                 CONSTRAINT pk_order_product PRIMARY KEY (`id_order_product`),
                                 CONSTRAINT fk_order_product_order FOREIGN KEY (`order_id`)
                                     REFERENCES `order`(`id_order`) ON DELETE CASCADE ON UPDATE CASCADE,
                                 CONSTRAINT fk_order_product_pie FOREIGN KEY (`pie_id`)
                                     REFERENCES `pie`(`id_pie`) ON DELETE CASCADE ON UPDATE CASCADE

);

CREATE TABLE `basket_product` (
                                  `id_basket_product` INTEGER NOT NULL AUTO_INCREMENT,
                                  `basket_id` INTEGER NOT NULL,
                                  `pie_id` INTEGER NOT NULL,
                                  `basket_amount` INTEGER NOT NULL,
                                  `basket_cost` DOUBLE NOT NULL,

                                  CONSTRAINT pk_basket_product PRIMARY KEY (`id_basket_product`),
                                  CONSTRAINT fk_basket_product_basket FOREIGN KEY (`basket_id`)
                                      REFERENCES `basket`(`id_basket`) ON DELETE CASCADE ON UPDATE CASCADE,
                                  CONSTRAINT fk_basket_product_order FOREIGN KEY (`pie_id`)
                                      REFERENCES `pie`(`id_pie`) ON DELETE CASCADE ON UPDATE CASCADE
);
USE `test_bakery_db`;
INSERT INTO `user`
(`login`, `password`, `role`, `surname`, `name_user`, `patronymic`, `address`, `phone`, `note`)
VALUES
("admin", "admin", 1, "Akulich", "Dmitry", "Viktorovich", "Apt 229, 33 Lubimova St, Minsk", "8-044-564-61-30", "admin");

USE `test_bakery_db`;

INSERT INTO `user`
(`login`, `password`, `role`, `surname`, `name_user`, `patronymic`, `address`, `phone`, `note`)
VALUES ("courier1", "courier1", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
        "8-029-165-61-30", "courier"),
       ("user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
        "In the yard problems with parking spaces"),
       ("user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
        "There are enough parking spaces in the yard");

INSERT INTO `pie`
(`name_pie`, `weight`, `price`, `description`, `picture`)
VALUES ("Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"),
       ("Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"),
       ("Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"),
       ("French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png");

INSERT INTO `feedback`
(`user_id`, `feedback_date`, `review`)
VALUES
(3, "2020-04-05T10:00:00", "It was bad!"),
(3, "2020-04-08T11:00:00",  "It was good!"),
(4, "2020-04-09T12:00:00", "It was delicious!");

INSERT INTO `order`
(`user_id`, `total`, `productionDate`, `deliveryDate`, `status`)
VALUES
(3, 48.00, "2020-04-02T09:00:00", "2020-04-02T15:00:00", "delivered"),
(4, 46.00, "2020-04-03T09:00:00", "2020-04-03T18:00:00", "delivered"),
(4, 75.00, "2020-04-04T09:00:00", "2020-04-04T17:30:00", "delivered");

INSERT INTO `order_product`
(`order_id`, `pie_id`, `order_amount`, `order_cost`)
VALUES
(1, 1, 2, 48.00),
(2, 1, 1, 24.00),
(2, 2, 1, 22.00),
(3, 3, 1, 26.00),
(3, 4, 1, 25.00),
(3, 1, 1, 24.00);

INSERT INTO `basket`
(`user_login`, `total`)
VALUES
("user1", 0.0),
("user2", 0.0);