CREATE DATABASE proyecto;
USE proyecto;


DROP TABLE IF EXISTS `reserva`;

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `fecha` varchar(20) DEFAULT NULL,
  `horas_reservadas` varchar(3) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `hora` varchar(15) DEFAULT NULL,
  `tipo_cancha` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_reserva`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


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





