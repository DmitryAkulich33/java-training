USE `bakery_db`;

INSERT INTO `user`
(`login`, `password`, `role`, `surname`, `name_user`, `patronymic`, `address`, `phone`, `note`)
VALUES ("courier", "courier", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
        "+375 29 1656130", "courier"),
       ("user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "+375 29 7434546",
        "In the yard problems with parking spaces"),
       ("user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "+375 44 5737640",
        "There are enough parking spaces in the yard"),
       ("user3", "user3", 3, "Sidorov", "Sidr", "Sidorovich", "Apt 95, 27 Lubimova St, Minsk", "+375 44 5982331",
        "Near the house there are construction work"),
       ("user4", "user4", 3, "Andreev", "Andrey", "Andreevich", "Apt 54, 24 Alibegova St, Minsk", "+375 29 9653132",
        "There are enough parking spaces in the yard"),
       ("user5", "user5", 3, "Sergeev", "Sergey", "Sergeevich", "Apt 15, 5 Asanalieva St, Minsk", "+375 29 5056150",
        "In the yard problems with parking spaces");

INSERT INTO `pie`
    (`name_pie`, `weight`, `price`, `description`, `picture`)
VALUES ("Belorussian", 1000, 24.00,
        "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander",
        "image/Belarus.png"),
       ("Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"),
       ("Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"),
       ("French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"),
       ("Belgian", 900, 20.00, "Signature dough with delicate, fragrant raspberries", "image/Belg.png"),
       ("Dutch", 1000, 27.00, "Signature Dough, Flavored Hazelnut Poppy", "image/Goland.png"),
       ("Greek", 1100, 28.00, "Signature dough, flavored blackberries in cream cheese", "image/grec2.png"),
       ("Irish", 1000, 25.00, "Signature dough, stewed carrots with pumpkin in soft cheese, with onions and celery",
        "image/Irla.png");

INSERT INTO `feedback`
    (`user_id`, `feedback_date`, `review`)
VALUES
       (3, "2020-02-02T09:00:00", "I ordered two pies - Belorussian and Greek. They were delivered on time. I was surprised because it was very fast. The administrator is polite and attentive. I think that team of 'TastyPie' is professional. I will order their pies in future and will recommend this company to all of my friends."),
       (4, "2020-02-05T10:00:00", "I ordered Italian pie. It was not expensive. I think that pie costs its money, because it was delicious. All my family liked this pie and we  want to order more and more. I think we need to try every pie of this company."),
       (5, "2020-02-08T11:00:00", "I wanted to order pies to the office for my birthday party. I did it in the morning and I got my pies at lunchtime. They were hot and looked tasty. I liked Irish pie most of all, but my collegues liked Belgian and French. Irish pie was good for me, because I am a vegetarian and I like pumpkin very much. There was a lot of filling im the pies. My birhday party was excelent. 'TastyPie', thank you very much for your work. You are the best!"),
       (3, "2020-02-08T12:00:00", "It was delicious!"),
       (4, "2020-02-08T13:00:00", "It was delicious!"),
       (3, "2020-02-08T14:00:00", "It was delicious!"),
       (5, "2020-02-08T15:00:00", "It was delicious!"),
       (4, "2020-02-08T16:00:00", "It was delicious!"),
       (5, "2020-02-08T17:00:00", "It was delicious!"),
       (5, "2020-02-08T18:00:00", "It was delicious!"),
       (3, "2020-02-08T19:00:00", "It was delicious!"),
       (3, "2020-02-08T20:00:00", "It was delicious!COOL");
