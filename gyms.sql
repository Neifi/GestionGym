/*CREACION Y CONEXIÓN DE LA BD*/
CREATE DATABASE gestiongym;
\c gestiongym

/*EXTENSION pgcrypto */
CREATE EXTENSION pgcrypto
/*TABLA GYMS*/
create table gyms (
	id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	direccion VARCHAR(50),
	codigo_postal VARCHAR(50),
	pais VARCHAR(50),
	ciudad VARCHAR(50)
);
insert into gyms (direccion, codigo_postal, pais, ciudad) values ( 
 'C/Mayor 5', '64851', 'España', 'Barcelona');

/*TABLA CLIENTES*/
create table clientes (
	id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	id_gym INT REFERENCES gyms(id),
	dni VARCHAR(8) UNIQUE,
	password VARCHAR(60),
	nombre VARCHAR(50),
	apellidos VARCHAR(50),
	pagado BOOLEAN,
	dentro BOOLEAN,
	fecha_inscripcion VARCHAR(10),
	fecha_nacimiento VARCHAR(10),
	es_admin BOOLEAN
);
insert into clientes ( id_gym, dni, password, nombre, apellidos, pagado, 
dentro, fecha_inscripcion, fecha_nacimiento,es_admin) values ( 1, '1871854D',
 crypt('alene',gen_salt('bf')), 'Alene', 'Roussell', false, true, '04/05/2019', '20/03/1996',false);
insert into clientes ( id_gym, dni, password, nombre, apellidos, pagado, 
dentro, fecha_inscripcion, fecha_nacimiento,es_admin) values ( 1, '3981749L',
 crypt('marc',gen_salt('bf')), 'Marc', 'Roussell', false, true, '04/05/2019', '02/05/1992',true);

/*TABLA CHECK_HORAS*/
create table check_horas (
	id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	dni_cliente VARCHAR(8) UNIQUE references clientes(dni),
	id_gym INT references gyms(id),
	horas INT,
	fecha VARCHAR(10)
);
insert into check_horas ( dni_cliente, id_gym, horas, fecha) values ('1871854D', 1, 0, '12/9/2019');

