create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("naveen", "testing@123"); 

create table features(
Name varchar(50) not null,
Slug varchar(50) not null,
Parent_Feature varchar(20) not null,
Description varchar(50));


insert into Features values("New Launches123","launch11","best","New Launches of vilas, apartments, flats"); 
insert into Features values("Testing141","Test141","design","New Launches of vilas, apartments, flats"); 
