create database userappdb;
use userappdb;

create table Book
(
  id INT PRIMARY KEY NOT NULL,
  ISBN INT NOT NULL,
  title VARCHAR(50) NOT NULL,
  Author VARCHAR(50),
  pub_year INT,
  
);