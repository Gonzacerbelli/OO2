-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-07-2018 a las 20:41:56
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd-hibernate-herencia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nroCliente` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nroCliente`) VALUES
(1, '11111111'),
(2, '22222222');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personafisica`
--

CREATE TABLE `personafisica` (
  `idPersonaFisica` int(11) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personafisica`
--

INSERT INTO `personafisica` (`idPersonaFisica`, `apellido`, `nombre`, `dni`) VALUES
(1, 'Lopez', 'Juan', 1111111);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajuridica`
--

CREATE TABLE `personajuridica` (
  `idPersonaJuridica` int(11) NOT NULL,
  `razonSocial` varchar(25) NOT NULL,
  `cuit` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personajuridica`
--

INSERT INTO `personajuridica` (`idPersonaJuridica`, `razonSocial`, `cuit`) VALUES
(2, 'UNLa', '300000001');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `personafisica`
--
ALTER TABLE `personafisica`
  ADD PRIMARY KEY (`idPersonaFisica`);

--
-- Indices de la tabla `personajuridica`
--
ALTER TABLE `personajuridica`
  ADD PRIMARY KEY (`idPersonaJuridica`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `personafisica`
--
ALTER TABLE `personafisica`
  ADD CONSTRAINT `fk_personafisica_1` FOREIGN KEY (`idPersonaFisica`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `personajuridica`
--
ALTER TABLE `personajuridica`
  ADD CONSTRAINT `fk_personajuridica_1` FOREIGN KEY (`idPersonaJuridica`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
