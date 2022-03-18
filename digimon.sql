-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 18-03-2022 a las 13:24:03
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
-- Base de datos: `digimon`
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
  `tipoDig` varchar(15) NOT NULL,
  `fotoDig` varchar(100) NOT NULL,
  `fotovicDig` varchar(100) NOT NULL,
  `fotoderDig` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `digimon`
--

INSERT INTO `digimon` (`nombreDig`, `nombreevolucionDig`, `nivelDig`, `defensaDig`, `ataqueDig`, `tipoDig`, `fotoDig`, `fotovicDig`, `fotoderDig`) VALUES
('Agumon', 'Agumon', 1, 120, 200, 'arma', 'hola', 'hola', 'hola'),
('Gabumon', 'Garurumon', 1, 60, 100, 'acuatico', 'hola', 'hola', 'hola'),
('Gagamon', 'Gagamon', 3, 4344, 231, 'diablillo', 'hola', 'hola', 'hola'),
('Megagreymon', 'Agumon', 2, 444, 312, 'baba', 'hola', 'hola', 'hola');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `digimon`
--
ALTER TABLE `digimon`
  ADD PRIMARY KEY (`nombreDig`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
