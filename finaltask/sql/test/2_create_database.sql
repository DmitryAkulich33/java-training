CREATE DATABASE IF NOT EXISTS `test_bakery_db` DEFAULT CHARACTER SET utf8;

CREATE USER IF NOT EXISTS 'test_bakery_app'@'localhost' IDENTIFIED BY 'test_bakery_password';

GRANT SELECT, INSERT, UPDATE, DELETE
ON test_bakery_db.*
TO 'test_bakery_app'@'localhost';
