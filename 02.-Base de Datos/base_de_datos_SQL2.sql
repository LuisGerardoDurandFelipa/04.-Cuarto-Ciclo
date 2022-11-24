CREATE DATABASE PROYECTOWEB2
GO
USE PROYECTOWEB2
GO


create table promociones
(
	id_Promocion INT PRIMARY KEY IDENTITY (1, 1)NOT NULL,
	nombre_promocion varchar(100)DEFAULT NULL,
	descripcion_promocion varchar(100)DEFAULT NULL,
	fecha_promo_inicio  varchar(100)DEFAULT NULL,
	fecha_promo_final varchar(100)DEFAULT NULL
	
)          
go


create table academia
(
	id_Registro INT PRIMARY KEY IDENTITY (1, 1)NOT NULL,
	nombre_tutor varchar(100)DEFAULT NULL,
	apellido_tutor varchar(100)DEFAULT NULL,
	dni_tutor  varchar(100)DEFAULT NULL,
	telefono_tutor varchar(100)DEFAULT NULL,
	email_tutor varchar(100) DEFAULT NULL,
	fechanac_estudiante varchar(100) DEFAULT NULL,
	nombre_estudiante varchar(100) DEFAULT NULL,
	apellido_estudiante varchar(100) DEFAULT NULL,
	dni_estudiante varchar(100) DEFAULT NULL,
	deporte varchar(100) DEFAULT NULL,
)          
go



create table cliente
(
	id_Cliente INT PRIMARY KEY IDENTITY (1, 1)NOT NULL,
	nombre varchar(45)DEFAULT NULL,
	apellido varchar(45)DEFAULT NULL,
	dni  varchar(8)DEFAULT NULL,
	telefono varchar(9)DEFAULT NULL,
	correo	varchar(40)DEFAULT NULL
)          
go

insert into cliente values('Luis Gerardo','Durand Felipa','70312562','985745280','ldurand@globokas.com')


create table campo
(
	id_Campo INT PRIMARY KEY IDENTITY (1, 1)NOT NULL,
	codigoCampo varchar(45)DEFAULT NULL,
	nombreCampo varchar(45)DEFAULT NULL,
	estado  varchar(50)DEFAULT NULL,
	tipoCampo varchar(50)DEFAULT NULL
	
)          
go

insert into campo values('C0001','los verdes 2','operativo','grazz')

create table reserva
(
	id_Reserva INT PRIMARY KEY IDENTITY (1, 1)NOT NULL,
	fecha  char(20) DEFAULT NULL,
	hora  char(20)DEFAULT NULL,
	horasReservadas    char(20)DEFAULT NULL,
	estado_Reserva	char(20)DEFAULT NULL,
	cliente int NOT NULL,
	campo	int NOT NULL

		constraint fk_reserva_cliente 
				  foreign key(cliente) 
				  references cliente(id_Cliente),
		constraint fk_reserva_campo
				  foreign key(campo) 
				  references campo(id_Campo) 				   
) 
go

insert into reserva values('20/15/2022','16:80','2','e',2,1)

select * from cliente;
select * from campo;
select * from reserva;

select cli.nombre , re.estadoReserva
from reserva re  join cliente cli 
on re.cliente=cli.id_Cliente;


drop table cliente;
drop table campo;
drop table reserva;


COMMIT;