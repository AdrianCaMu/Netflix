create database if not exists Netflix;
use Netflix;

create table Series(
	id varchar(30) primary key,
	type long,
	title long,
	director long,
	cast long,
	country long,
	date_added long,
	release_year long,
	rating long,
	duration long,
	listed_in long,
	description long
);

drop table Usuarios;

create table Usuarios(
	id int primary key auto_increment,
    correo long not null,
    password long not null,
    codigo int,
    activado boolean not null default 0
);

select * from Usuarios;

#limpiar tabla series
SET SQL_SAFE_UPDATES = 0;
DELETE FROM Series;