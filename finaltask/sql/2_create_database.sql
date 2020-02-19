CREATE DATABASE `bakery_db` DEFAULT CHARACTER SET utf8;

CREATE USER `bakery_app` IDENTIFIED BY 'bakery_password';

GRANT SELECT, INSERT, UPDATE, DELETE
ON `bakery_db`.*
TO bakery_app@localhost;
