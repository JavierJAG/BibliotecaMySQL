drop database if exists biblioteca;
create database biblioteca;

use biblioteca;

create table socio(
DNI char(9),
nombre varchar(100) NOT NULL,
apellidos varchar(100) NOT NULL,
primary key (DNI)
);

create table libro(
codigo int,
titulo varchar(100) NOT NULL,
autor varchar(100) NOT NULL,
primary key(codigo)
);

create table alquiler(
codigoLibro int,
DNI char(9),
fechaprestamo date,
fechadevolucion date,
primary key(codigoLibro, DNI, fechaprestamo),
foreign key (codigoLibro) references libro(codigo),
foreign key (DNI) references socio(DNI)
);

insert into socio (DNI, nombre, apellidos) values ('36241598C' , 'Francisco', 'González Villar');
insert into socio (DNI, nombre, apellidos) values ('24165328B' , 'Ana', 'Álvarez Fernández');
insert into socio (DNI, nombre, apellidos) values ('86942715K' , 'Miguel', 'Pérez Domínguez');
insert into socio (DNI, nombre, apellidos) values ('42156875N' , 'Juan', 'García García');
insert into socio (DNI, nombre, apellidos) values ('64287654S' , 'Helena', 'Rodríguez Rial');

insert into libro (codigo, titulo, autor) values (1,'Don Quijote de la Mancha','Miguel de Cervantes');
insert into libro (codigo, titulo, autor) values (2,'El señor de los anillos','J.R.R. Tolkien');
insert into libro (codigo, titulo, autor) values (3,'El código Da Vinci','Dan Brown');
insert into libro (codigo, titulo, autor) values (4,'20.000 leguas de viaje submarino','Julio Verne');
insert into libro (codigo, titulo, autor) values (5,'Ilíada','Homero');

insert into alquiler (codigoLibro, DNI, fechaprestamo,fechadevolucion) values (1,'24165328B','2022-08-14','2022-10-25');
insert into alquiler (codigoLibro, DNI, fechaprestamo,fechadevolucion) values (2,'86942715K','2022-09-12','2022-10-25');
insert into alquiler (codigoLibro, DNI, fechaprestamo,fechadevolucion) values (4,'42156875N','2022-11-11','2022-12-14');
insert into alquiler (codigoLibro, DNI, fechaprestamo,fechadevolucion) values (1,'64287654S','2022-12-28','2023-02-25');
insert into alquiler (codigoLibro, DNI, fechaprestamo,fechadevolucion) values (3,'24165328B','2023-02-04','2023-04-25');
insert into alquiler (codigoLibro, DNI, fechaprestamo,fechadevolucion) values (5,'86942715K','2023-03-21','2023-04-25');
insert into alquiler (codigoLibro, DNI, fechaprestamo,fechadevolucion) values (2,'36241598C','2023-03-04','2023-07-25');
insert into alquiler (codigoLibro, DNI, fechaprestamo) values (4,'86942715K','2023-04-18');
insert into alquiler (codigoLibro, DNI, fechaprestamo) values (5,'42156875N','2023-05-16');
insert into alquiler (codigoLibro, DNI, fechaprestamo) values (2,'24165328B','2023-08-27');