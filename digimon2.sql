-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 25-03-2022 a las 10:13:20
-- Versión del servidor: 10.3.34-MariaDB-0ubuntu0.20.04.1
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `digimon2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `digimon`
--

CREATE TABLE `digimon` (
  `nombreDig` varchar(30) NOT NULL,
  `nombreevolucionDig` varchar(30) NOT NULL,
  `nivelDig` int(1) NOT NULL,
  `defensaDig` int(11) NOT NULL,
  `ataqueDig` int(11) NOT NULL,
  `tipoDig` enum('acuático','arma','baba','diablillo','parásito') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiene`
--

CREATE TABLE `tiene` (
  `codigoUsu` int(11) NOT NULL,
  `nombreDig` varchar(30) NOT NULL,
  `equipo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `codigoUsu` int(11) NOT NULL,
  `nombreUsu` varchar(30) NOT NULL,
  `contraseñaUsu` varchar(30) NOT NULL,
  `partidasUsu` int(11) NOT NULL DEFAULT 0,
  `partidasganaUsu` int(11) NOT NULL DEFAULT 0,
  `evolucionesUsu` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `digimon`
--
ALTER TABLE `digimon`
  ADD PRIMARY KEY (`nombreDig`,`nombreevolucionDig`),
  ADD KEY `fk_digimon` (`nombreevolucionDig`);

--
-- Indices de la tabla `tiene`
--
ALTER TABLE `tiene`
  ADD PRIMARY KEY (`codigoUsu`,`nombreDig`),
  ADD KEY `fk_tiene_nombre` (`nombreDig`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigoUsu`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigoUsu` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tiene`
--
ALTER TABLE `tiene`
  ADD CONSTRAINT `fk_tiene_nombre` FOREIGN KEY (`nombreDig`) REFERENCES `digimon` (`nombreDig`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_tiene_usuario` FOREIGN KEY (`codigoUsu`) REFERENCES `usuario` (`codigoUsu`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
