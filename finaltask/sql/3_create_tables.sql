USE `bakery_db`;

# Roles:
# 1 - administrator
# 2 - courier
# 3 - client

CREATE TABLE `users` (
	`PersonID` int NOT NULL AUTO_INCREMENT,
	`Login` varchar(20) NOT NULL UNIQUE,
	`Password` char(32),
	`role` tinyint NOT NULL CHECK (`role` IN (1, 2, 3)),
	
	CONSTRAINT pk_users PRIMARY KEY (`PersonID`)
);

CREATE TABLE `clients` (
	`PersonID` int NOT NULL AUTO_INCREMENT,
	`Surname` varchar(60) NOT NULL,
	`Name` varchar(60) NOT NULL,
	`Patronymic` varchar(60) NOT NULL,
	`Address` varchar(100) NOT NULL,
	`Phone` varchar(30) NOT NULL,
	`Note` varchar(255),
	
	CONSTRAINT pk_clients PRIMARY KEY (`PersonID`)
);

CREATE TABLE `pies` (
	`PieID` int NOT NULL AUTO_INCREMENT,
	`Name` varchar(50) NOT NULL,
	`Weight` int NOT NULL,
	`Price` double NOT NULL,
	`Discription` varchar(255) NOT NULL,

	CONSTRAINT pk_pies PRIMARY KEY (`PieID`)
);

CREATE TABLE `orders` (
	`OrderID` int NOT NULL AUTO_INCREMENT,
	`ClientsID` int NOT NULL,
	`PieID` int NOT NULL,
	`ProductionDate` datetime,
	`DeliveryDate` datetime,
	`StatusID` int,
	
	CONSTRAINT pk_orders PRIMARY KEY (`OrderID`),
	CONSTRAINT fk_orders_client FOREIGN KEY (`ClientsID`)
	REFERENCES `clients`(`PersonID`),
	CONSTRAINT fk_orders_pie FOREIGN KEY (`PieID`)
	REFERENCES `pies`(`PieID`),
	CONSTRAINT fk_orders_status FOREIGN KEY (`StatusID`)
	REFERENCES `status`(`StatusID`)
);


CREATE TABLE `status` (
	`StatusID` int NOT NULL AUTO_INCREMENT,
	`Name` varchar(25) NOT NULL,

	CONSTRAINT pk_status PRIMARY KEY (`StatusID`)
);

CREATE TABLE `black_list` (
	`ID` int NOT NULL AUTO_INCREMENT,
	`ClientsID` int NOT NULL,
	
	CONSTRAINT pk_black_list PRIMARY KEY (`ID`)
);

