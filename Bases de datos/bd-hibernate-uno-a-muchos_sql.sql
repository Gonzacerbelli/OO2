-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-04-2018 a las 02:35:05
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
-- Base de datos: `bd-hibernate-uno-a-muchos_sql`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `dni` bigint(8) NOT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  `baja` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `apellido`, `nombre`, `dni`, `fechaDeNacimiento`, `baja`) VALUES
(1, 'Cerbelli', 'Gonzalo', 39281276, '2018-04-04', b'0'),
(2, 'Cerbelli', 'Gonzalo', 555555555, '2018-04-04', b'0'),
(3, 'Cerbelli', 'Gonzalo', 3333333, '2018-04-04', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuota`
--

CREATE TABLE `cuota` (
  `idCuota` int(11) NOT NULL,
  `nroCuota` int(11) NOT NULL,
  `fechaVencimiento` date NOT NULL,
  `saldoPendiente` double NOT NULL,
  `amortizacion` double NOT NULL,
  `interesCuota` double NOT NULL,
  `cuota` double NOT NULL,
  `deuda` double NOT NULL,
  `cancelada` tinyint(1) NOT NULL,
  `fechaDePago` date NOT NULL,
  `punitorios` double NOT NULL,
  `idPrestamo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuota`
--

INSERT INTO `cuota` (`idCuota`, `nroCuota`, `fechaVencimiento`, `saldoPendiente`, `amortizacion`, `interesCuota`, `cuota`, `deuda`, `cancelada`, `fechaDePago`, `punitorios`, `idPrestamo`) VALUES
(1, 1, '2018-04-28', 15000, 0, 0, 1500, 15000, 0, '0000-00-00', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `idPrestamo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `monto` float NOT NULL,
  `interes` float NOT NULL,
  `cantCuotas` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`idPrestamo`, `fecha`, `monto`, `interes`, `cantCuotas`, `idCliente`) VALUES
(1, '2018-04-25', 15000, 42.25, 24, 1),
(2, '2018-04-24', 26000, 37.36, 12, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Indices de la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD PRIMARY KEY (`idCuota`),
  ADD KEY `fk_prestamo` (`idPrestamo`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `fk_cliente_idx` (`idCliente`),
  ADD KEY `idCliente` (`idCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cuota`
--
ALTER TABLE `cuota`
  MODIFY `idCuota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD CONSTRAINT `fk_prestamo` FOREIGN KEY (`idPrestamo`) REFERENCES `prestamo` (`idPrestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
