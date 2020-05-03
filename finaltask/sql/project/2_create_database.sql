CREATE DATABASE IF NOT EXISTS `bakery_db` DEFAULT CHARACTER SET utf8;

CREATE USER IF NOT EXISTS 'bakery_app'@'localhost' IDENTIFIED BY 'bakery_password';

GRANT SELECT, INSERT, UPDATE, DELETE
ON bakery_db.*
TO 'bakery_app'@'localhost';
