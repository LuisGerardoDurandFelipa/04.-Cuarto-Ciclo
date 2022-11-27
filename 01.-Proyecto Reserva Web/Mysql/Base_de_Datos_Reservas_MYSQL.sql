CREATE DATABASE proyectoreservaweb;
USE proyectoreservaweb;


DROP TABLE IF EXISTS `proyectoreservaweb`.`cliente` ;

CREATE TABLE IF NOT EXISTS `proyectoreservaweb`.`cliente`(
  `id_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `proyectoreservaweb`.`cliente`(`id_Cliente`,`nombre`,`apellido`,`dni`,`telefono`,`correo`)VALUES(2,"Luis Gerarod","Durand Felipa","70312562","993686916","durand_feli");


DROP TABLE IF EXISTS `proyectoreservaweb`.`campo` ;

CREATE TABLE IF NOT EXISTS `proyectoreservaweb`.`campo`(
  `id_Campo` int(11) NOT NULL AUTO_INCREMENT,
  `codigoCampo` varchar(20) DEFAULT NULL,
  `nombreCampo` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `tipoCampo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_Campo`)
  
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `proyectoreservaweb`.`campo`(`id_Campo`,`codigoCampo`,`nombreCampo`,`estado`,`tipoCampo`)VALUES(1,"C001","ÑARÑA","disponible","Grazz");

DROP TABLE IF EXISTS `reserva`;

CREATE TABLE `proyectoreservaweb`.`reserva` (
  `id_Reserva` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(20) DEFAULT NULL,
  `hora` varchar(15) DEFAULT NULL,
  `horasReservadas` varchar(15) DEFAULT NULL,
  `estado_Reserva` varchar(45) DEFAULT NULL,
  `cliente` INT NOT NULL,
  `campo` INT NOT NULL,
  PRIMARY KEY (`id_Reserva`),
  KEY `fk_Reserva_Cliente` USING HASH (`cliente`),
  KEY `fk_Reserva_Campo` USING HASH (`campo`),
  
  CONSTRAINT `fk_Reserva_Cliente`
    FOREIGN KEY (`cliente`)
    REFERENCES `proyectoreservaweb`.`cliente` (`id_Cliente`)
    ON UPDATE CASCADE,
  
  CONSTRAINT `fk_Reserva_Campo`
    FOREIGN KEY (`campo`)
    REFERENCES `proyectoreservaweb`.`campo` (`id_Campo`)
    ON UPDATE CASCADE
  
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
INSERT INTO `proyectoreservaweb`.`reserva`(`id_Reserva`,`fecha`,`hora`,`horasReservadas`,`estado_Reserva`,`cliente`,`campo`)VALUES(2,"27/11/2022","02:04 pm","2","por pagar",1,1);

CREATE TABLE `promociones` (
  `id_promocion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_promocion` varchar(100) DEFAULT NULL,
  `descripcion_promocion` varchar(100) DEFAULT NULL,
  `fecha_promo_inicio` varchar(100) DEFAULT NULL,
  `fecha_promo_final` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_promocion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `academia` (
  `id_registro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tutor` varchar(100) DEFAULT NULL,
  `apellido_tutor` varchar(100) DEFAULT NULL,
  `dni_tutor` varchar(100) DEFAULT NULL,
  `telefono_tutor` varchar(100) DEFAULT NULL,
   `email_tutor` varchar(100) DEFAULT NULL,
    `fechanac_estudiante` varchar(100) DEFAULT NULL,
     `nombre_estudiante` varchar(100) DEFAULT NULL,
	`apellido_estudiante` varchar(100) DEFAULT NULL,
	`dni_estudiante` varchar(100) DEFAULT NULL,
`deporte` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_registro`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
