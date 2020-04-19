USE `bakery_db`;

INSERT INTO `user`
(`login`, `password`, `role`, `surname`, `name_user`, `patronymic`, `address`, `phone`, `note`)
VALUES ("courier1", "courier1", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
        "+375 29 1656130", "courier"),
       ("courier2", "courier2", 2, "Mamonov", "Denis", "Andreevich", "Apt 11, 33 Lubimova St, Minsk",
        "+375 29 5736130", "courier"),
       ("user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "+375 29 7434546",
        "In the yard problems with parking spaces"),
       ("user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "+375 44 5737640",
        "There are enough parking spaces in the yard"),
       ("user3", "user3", 3, "Sidorov", "Sidr", "Sidorovich", "Apt 95, 27 Lubimova St, Minsk", "+375 44 5982331",
        "Near the house there are construction work"),
       ("user4", "user4", 3, "Andreev", "Andrey", "Andreevich", "Apt 54, 24 Alibegova St, Minsk", "+375 29 9653132",
        "There are enough parking spaces in the yard"),
       ("user5", "user5", 3, "Sergeev", "Sergey", "Sergeevich", "Apt 15, 5 Asanalieva St, Minsk", "+375 29 5056150",
        "In the yard problems with parking spaces"),
       ("user6", "user6", 3, "Gagarin", "Dmitry", "Fedorovich", "Apt 12, 15 Kazinca St, Minsk", "+375 33 6050120",
        "There are enough parking spaces in the yard"),
       ("user7", "user7", 3, "Petrov", "Andrey", "Borisovich", "Apt 122, 45 Alibegova St, Minsk", "+375 44 5759128",
        "Near the house there are construction work");

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
        "image/Irla.png"),
       ("American", 1050, 20.00, "Signature dough, juicy green apple with cinnamon",
        "image/Americ.png"),
       ("Poland", 950, 19.00, "Signature dough, green apple, fresh pear, vitamin cranberries",
        "image/Pol.png"),
       ("Finnish", 1000, 22.00, "Signature dough, ripe blueberries with black currants",
        "image/Finl.png"),
       ("Norwegian", 1050, 35.00, "Signature dough, tender salmon with spinach and soft cheese",
        "image/Norveg.png"),
       ("Mexican", 1000, 29.00, "Signature dough, chicken fillet with tomatoes, red beans, corn, jalapenos",
        "image/Mexic.png"),
       ("Russian", 1000, 27.00, "Signature dough, tender, golden cabbage with fried mushrooms",
        "image/Russia.png"),
       ("Serbian", 1050, 28.00, "Signature dough, soft cheese, thyme stewed pepper, feta cheese",
        "image/Serb.png"),
       ("Japanese", 1000, 31.00, "Signature dough, young cod fillet, Chuka salad, Nori seaweed rice, sesame, soy sauce",
        "image/Japan.png");

INSERT INTO `feedback`
    (`user_id`, `feedback_date`, `review`)
VALUES
       (4, "2020-04-02T09:00:00", "I ordered two pies - Belorussian and Greek. They were delivered on time. I was surprised because it was very fast. The administrator is polite and attentive. I think that team of 'TastyPie' is professional. I will order their pies in future and will recommend this company to all of my friends."),
       (5, "2020-04-05T10:00:00", "I ordered Italian pie. It was not expensive. I think that pie costs its money, because it was delicious. All my family liked this pie and we  want to order more and more. I think we need to try every pie of this company."),
       (6, "2020-04-08T11:00:00", "I wanted to order pies to the office for my birthday party. I did it in the morning and I got my pies at lunchtime. They were hot and looked tasty. I liked Irish pie most of all, but my collegues liked Belgian and French. Irish pie was good for me, because I am a vegetarian and I like pumpkin very much. There was a lot of filling im the pies. My birhday party was excelent. 'TastyPie', thank you very much for your work. You are the best!"),
       (7, "2020-04-09T12:00:00", "It was delicious!"),
       (8, "2020-04-10T13:00:00", "I ordered sweet pies for my children several times – French, Deutsch, Greek. What they like most of all, is that there are a lot of berries inside. Their favorite is Deutsch pie with strawberries and ricotta."),
       (9, "2020-04-11T14:00:00", "If I do not have time to cook at home in advance, I order meals to the office. In TastyPie I prefer Belorussian one – it is with potatoes and mushrooms and can easily replace dinner. The delivery service works quickly – in an hour you will get a hot meal."),
       (10, "2020-04-12T15:00:00", "I was in the country with my family and did not want to spend the weekend near the cooker. In TastyPie it is possible to get several pies, even if you are far from Minsk. Prices for delivery are not so high."),
       (4, "2020-04-13T16:00:00", "It is often a problem to order dishes for holidays. That is why it is convenient to make pre-orders. You just choose menu and time of delivery and do not worry about queues. This way I ordered pies for March, 8 in the end of February."),
       (5, "2020-04-14T17:00:00", "It is excellent that you can pick up pies yourself. The office is near my house, so I do not want to pay for delivery. No matter one or five pies you order you can come and get them yourself and save money."),
       (6, "2020-04-15T18:00:00", "French pie is very tasty. It is with spicy cherry and hints of clove. I have never eaten a similar one in other places and advice everyone to try it!"),
       (7, "2020-04-16T19:00:00", "I ordered 3 pies for my Birthday and got not only delivery, but a discount as well. It is great when companies have loyalty policy for regular clients."),
       (8, "2020-04-17T20:00:00", "All the pies in the menu are always available to order. I do not like the situations when there are no necessary products on the kitchen at all and my plans are ruined. With TastyPie I have never had this problem.");

INSERT INTO `order`
    (`user_id`, `total`, `productionDate`, `deliveryDate`, `status`)
VALUES
    (4, 62.00, "2020-04-02T09:00:00", "2020-04-02T15:00:00", "delivered"),
    (5, 46.00, "2020-04-03T09:00:00", "2020-04-03T18:00:00", "delivered"),
    (6, 71.00, "2020-04-04T09:00:00", "2020-04-04T17:30:00", "delivered"),
    (7, 80.00, "2020-04-05T09:30:00", "2020-04-05T18:30:00", "delivered"),
    (8, 40.00, "2020-04-05T10:30:00", "2020-04-05T19:30:00", "delivered"),
    (9, 38.00, "2020-04-05T09:30:00", "2020-04-05T19:30:00", "not delivered"),
    (10, 113.00, "2020-04-06T10:30:00", "2020-04-06T19:30:00", "delivered"),
    (3, 56.00, "2020-04-06T10:30:00", "2020-04-06T19:30:00", "delivered"),
    (4, 40.00, "2020-04-07T10:30:00", "2020-04-07T20:30:00", "delivered"),
    (4, 60.00, "2020-04-08T10:00:00", "2020-04-08T20:00:00", "not delivered"),
    (6, 57.00, "2020-04-08T10:00:00", "2020-04-08T20:35:00", "delivered"),
    (4, 75.00, "2020-04-09T10:00:00", "2020-04-09T20:35:00", "delivered"),
    (4, 56.00, "2020-04-10T10:00:00", "2020-04-10T18:00:00", "delivered"),
    (8, 59.00, "2020-04-10T10:00:00", "2020-04-10T19:00:00", "delivered"),
    (7, 50.00, "2020-04-10T10:00:00", "2020-04-10T20:00:00", "delivered"),
    (7, 50.00, "2020-04-11T10:00:00", "2020-04-11T19:00:00", "delivered"),
    (6, 60.00, "2020-04-12T10:00:00", "2020-04-12T19:00:00", "delivered"),
    (6, 45.00, "2020-04-13T10:00:00", "2020-04-13T19:00:00", "delivered"),
    (8, 44.00, "2020-04-13T10:00:00", "2020-04-13T19:30:00", "delivered"),
    (4, 40.00, "2020-04-13T10:00:00", "2020-04-13T20:00:00", "delivered");

INSERT INTO `order_product`
    (`order_id`, `pie_id`, `order_amount`, `order_cost`)
VALUES
    (1, 16, 2, 62.00),
    (2, 1, 1, 24.00),
    (2, 2, 1, 22.00),
    (3, 3, 1, 26.00),
    (3, 4, 1, 25.00),
    (3, 5, 1, 20.00),
    (4, 6, 1, 27.00),
    (4, 7, 1, 28.00),
    (4, 8, 1, 25.00),
    (5, 9, 2, 40.00),
    (6, 10, 2, 38.00),
    (7, 11, 1, 22.00),
    (7, 12, 1, 35.00),
    (7, 13, 1, 29.00),
    (7, 14, 1, 27.00),
    (8, 15, 2, 56.00),
    (9, 5, 1, 20.00),
    (9, 9, 1, 20.00),
    (10, 8, 1, 25.00),
    (10, 12, 1, 35.00),
    (11, 2, 1, 22.00),
    (11, 12, 1, 35.00),
    (12, 2, 1, 22.00),
    (12, 3, 1, 26.00),
    (12, 6, 1, 27.00),
    (13, 15, 2, 56.00),
    (14, 15, 1, 28.00),
    (14, 16, 1, 31.00),
    (15, 8, 2, 50.00),
    (16, 8, 2, 50.00),
    (17, 8, 1, 25.00),
    (17, 12, 1, 35.00),
    (18, 8, 1, 25.00),
    (18, 9, 1, 20.00),
    (19, 2, 2, 44.00),
    (20, 5, 2, 40.00);


INSERT INTO `basket`
    (`user_login`, `total`)
VALUES
    ("user1", 0.0),
    ("user2", 0.0),
    ("user3", 0.0),
    ("user4", 0.0),
    ("user5", 0.0),
    ("user6", 0.0),
    ("user7", 0.0);
