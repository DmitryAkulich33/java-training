CREATE DATABASE `bakery_db` DEFAULT CHARACTER SET utf8;

GRANT SELECT,INSERT,UPDATE,DELETE
ON `bakery_db`.*
TO bakery_user@localhost
IDENTIFIED BY 'bakery_password';

GRANT SELECT,INSERT,UPDATE,DELETE
ON `bakery_db`.*
TO library_user@'%'
IDENTIFIED BY 'bakery_password';