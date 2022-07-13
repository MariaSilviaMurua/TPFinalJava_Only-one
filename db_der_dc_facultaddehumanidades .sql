-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-07-2022 a las 03:11:36
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_der_dc_facultaddehumanidades`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id_alumno` int(5) NOT NULL,
  `Nombres` varchar(25) DEFAULT NULL,
  `Apellidos` varchar(25) DEFAULT NULL,
  `Fecha_de_nacimiento` varchar(10) DEFAULT NULL,
  `DNI` int(8) DEFAULT NULL,
  `LU` int(6) DEFAULT NULL,
  `Barrio` varchar(20) DEFAULT NULL,
  `Calle` varchar(20) DEFAULT NULL,
  `Numero_de_calle` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id_alumno`, `Nombres`, `Apellidos`, `Fecha_de_nacimiento`, `DNI`, `LU`, `Barrio`, `Calle`, `Numero_de_calle`) VALUES
(1, 'mario', 'Castro', '20/12/2003', 55758462, 247974, 'Cachi', '25 de mayo', 1300),
(2, 'pablo', 'Castillo', '15/03/2001', 55758946, 559974, 'Chacabuco', '20 de febrero', 2000),
(3, 'jose', NULL, '13/07/2002', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `id_carrera` int(4) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Año_del_plan_de_estudio` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`id_carrera`, `Nombre`, `Año_del_plan_de_estudio`) VALUES
(1, 'Filosofia', 1996),
(2, 'Profesorado en letras', 1992),
(3, 'Licenciatura en Psicologia', 1999);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examen`
--

CREATE TABLE `examen` (
  `id_exame` int(4) NOT NULL,
  `id_ carrera1` int(4) NOT NULL,
  `id_materia1` int(4) NOT NULL,
  `Fecha` varchar(10) NOT NULL,
  `Hora` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcioncarrera`
--

CREATE TABLE `inscripcioncarrera` (
  `id` int(4) NOT NULL,
  `id_alumno` int(5) NOT NULL,
  `id_carrera` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `id_materia` int(4) NOT NULL,
  `Nombre_de_la_materia` varchar(30) DEFAULT NULL,
  `Profesor_adjunto` varchar(25) DEFAULT NULL,
  `Jefe_de_trabajo_practico` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`id_materia`, `Nombre_de_la_materia`, `Profesor_adjunto`, `Jefe_de_trabajo_practico`) VALUES
(1, 'Antropologia', 'Pablo Cruz', 'Sergio Sosa'),
(2, 'Psicologia', 'Alexa Alvarez', 'Sofia Lopez'),
(3, 'Filosofia', 'Maria Castro', 'Sofia Chavez');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id_alumno`);

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`id_carrera`);

--
-- Indices de la tabla `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`id_exame`),
  ADD KEY `fk_carrera1` (`id_ carrera1`),
  ADD KEY `fk_materia1` (`id_materia1`);

--
-- Indices de la tabla `inscripcioncarrera`
--
ALTER TABLE `inscripcioncarrera`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_alumno` (`id_alumno`),
  ADD KEY `fk_carrera` (`id_carrera`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id_materia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id_alumno` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `carrera`
--
ALTER TABLE `carrera`
  MODIFY `id_carrera` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `examen`
--
ALTER TABLE `examen`
  MODIFY `id_exame` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inscripcioncarrera`
--
ALTER TABLE `inscripcioncarrera`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `examen`
--
ALTER TABLE `examen`
  ADD CONSTRAINT `fk_carrera1` FOREIGN KEY (`id_ carrera1`) REFERENCES `carrera` (`id_carrera`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_materia1` FOREIGN KEY (`id_materia1`) REFERENCES `materia` (`id_materia`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `inscripcioncarrera`
--
ALTER TABLE `inscripcioncarrera`
  ADD CONSTRAINT `fk_alumno` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_carrera` FOREIGN KEY (`id_carrera`) REFERENCES `carrera` (`id_carrera`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
