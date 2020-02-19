USE `bakery_db`;
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"courier",
	"ef0124d4ac0fe5819bd78493786bf98a", /* MD5 хэш пароля "courier" */
	2
), (
	"user1",
	"24c9e15e52afc47c225b757e7bee1f9d", /* MD5 хэш пароля "user1" */
	3
), (
	"user2",
	"7e58d63b60197ceb55a1c487989a3720", /* MD5 хэш пароля "user2" */
	3
);

INSERT INTO `client` 
	(`surname`, `name`, `patronymic`, `address`, `phone`, `note`)
VALUES
	("Ivanov",	"Ivan",	"Ivanovich",	"Apt 18, 44 Rafieva St, Minsk",		"+375 29 7434546",	"In the yard problems with parking spaces"),
	("Petrov",	"Petr",	"Petrovich",	"Apt 45, 17 Kazinca St, Minsk",		"+375 44 5737640",	"There are enough parking spaces in the yard"),
	("Sidorov",	"Sidr",	"Sidorovich",	"Apt 95, 27 Lubimova St, Minsk",	"+375 44 5982331",	"Near the house there are construction work");

INSERT INTO `status`
	(`name`)
VALUES
	("Ready"),
	("Delivered"),
	("Undelivered");

INSERT INTO `pie`
	(`name`, `weight`, `price`, `description`)
VALUES
	("Belorussian",	1000,	24.00,	"Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander"),
	("Italian",		950,	22.00,	"Signature dough, sunny lemon with vitamin zest and peppermint"),
	("Deutsch",		1050,	26.00,	"Signature dough, juicy flavored strawberries with ricotta"),
	("French",		1000,	25.00,	"Signature dough, ripe spicy cherry with hints of clove"),
	("Belgian",		900,	20.00,	"Signature dough with delicate, fragrant raspberries"),
	("Dutch",		1000,	27.00,	"Signature Dough, Flavored Hazelnut Poppy"),
	("Greek",		1100,	28.00,	"Signature dough, flavored blackberries in cream cheese"),
	("Irish",		1000,	25.00,	"Signature dough, stewed carrots with pumpkin in soft cheese, with onions and celery");