CREATE DATABASE clientes;

USE DATABASE clientes;

CREATE TABLE clientes (
    id int primary key auto_increment,
    nombre varchar(150),
    apellido varchar(150),
    fecha_nac date

)