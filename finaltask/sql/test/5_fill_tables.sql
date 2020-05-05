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
