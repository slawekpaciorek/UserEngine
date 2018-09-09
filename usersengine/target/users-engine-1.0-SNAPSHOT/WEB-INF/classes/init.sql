CREATE SCHEMA IF NOT EXISTS usersengine;
USE usersengine;

DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(30) not null,
  surname varchar(30) not null,
  login varchar(30) not null,
  password varchar(16) not null,
  age INT not null,
  gender varchar(2),
  status varchar(1) not null default 'W'

);

