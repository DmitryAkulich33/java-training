INSERT INTO `user` (
	`id`,
	`login`,
	`password`,
	`role`
) VALUES (
	2,
	"courier",
	"ef0124d4ac0fe5819bd78493786bf98a", /* MD5 хэш пароля "courier" */
	2
), (
	3,
	"user1",
	"24c9e15e52afc47c225b757e7bee1f9d", /* MD5 хэш пароля "user1" */
	3
), (
	4,
	"user2",
	"7e58d63b60197ceb55a1c487989a3720", /* MD5 хэш пароля "user2" */
	4
);

INSERT INTO `client` 
	(`id`, `surname`, `name`, `patronymic`, `address`, `phone`, `note`)
VALUES
	(1,	"Ivanov",	"Ivan",	"Ivanovich",	"Apt 18, 44 Rafieva St, Minsk",		"+375 29 7434546",	"In the yard problems with parking spaces"),
	(2,	"Petrov",	"Petr",	"Petrovich",	"Apt 45, 17 Kazinca St, Minsk",		"+375 44 5737640",	"There are enough parking spaces in the yard"),
	(3,	"Sidorov",	"Sidr",	"Sidorovich",	"Apt 95, 27 Lubimova St, Minsk",	"+375 44 5982331",	"Near the house there are construction work");

INSERT INTO `status`
	(`id`, `name`)
VALUES
	(1,	"Ready"),
	(2,	"Delivered"),
	(3,	"Undelivered");

INSERT INTO `pie`
	(`id`, `name`, `weight`, `price`, `discription`)
VALUES
	(1,	"Belorussian",	1000,	24.00,	"Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander"),
	(2,	"Italian",		950,	22.00,	"Signature dough, sunny lemon with vitamin zest and peppermint"),
	(3,	"Deutsch",		1050,	26.00,	"Signature dough, juicy flavored strawberries with ricotta"),
	(4,	"French",		1000,	25.00,	"Signature dough, ripe spicy cherry with hints of clove"),
	(5,	"Belgian",		900,	20.00,	"Signature dough with delicate, fragrant raspberries"),
	(6,	"Dutch",		1000,	27.00,	"Signature Dough, Flavored Hazelnut Poppy"),
	(7,	"Greek",		1100,	28.00,	"Signature dough, flavored blackberries in cream cheese"),
	(8,	"Irish",		1000,	25.00,	"Signature dough, stewed carrots with pumpkin in soft cheese, with onions and celery");