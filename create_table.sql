CREATE TABLE admins(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
login_id VARCHAR(20),
login_pass VARCHAR(60)
);

CREATE TABLE lives(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
live_name VARCHAR(60) NOT NULL,
event_date DATETIME NOT NULL,
capacity INT NOT NULL,
place VARCHAR(45) NOT NULL,
address varchar(255),
created datetime
);

create table reserves(
id int primary key not null auto_increment,
name varchar(45) not null,
email varchar (60) not null,
phone varchar(20) not null,
reserve_created datetime
);

create table news(
id int primary key not null auto_increment,
news_name varchar(60) not null,
article text not null,
photo varchar(100),
post_date datetime not null
);