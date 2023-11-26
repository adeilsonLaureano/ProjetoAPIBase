create database banco_de_usuarios;
use banco_de_usuarios;
create table usuario(
	id integer auto_increment primary key,
    nome_completo varchar(45) not null,
    username varchar(45) not null unique,
    email varchar(45) not null unique,
    senha text not null,
    telefone varchar(45) not null
);
