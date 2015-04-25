-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-04-2015 a las 07:54:10
-- Versión del servidor: 5.1.41
-- Versión de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `macrostruts`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

DROP TABLE IF EXISTS `area`;
CREATE TABLE IF NOT EXISTS `area` (
  `iAreaId` int(11) NOT NULL AUTO_INCREMENT,
  `cAreaCodigo` char(7) NOT NULL,
  `vAreaDescripcion` varchar(45) NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `iUsuarioModificaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  PRIMARY KEY (`iAreaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `area`
--

INSERT INTO `area` (`iAreaId`, `cAreaCodigo`, `vAreaDescripcion`, `iUsuarioInsertaId`, `iUsuarioModificaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(1, 'ARE02', 'AREA DE SISTEMAS', 1, 1, '2011-04-24 00:00:00', '2011-04-24 00:00:00', 'AC'),
(3, 'ARE03', 'AREA DE ADMINISTRACION', 1, NULL, '2011-04-24 00:00:00', NULL, 'AC'),
(4, 'AR00004', 'NBN', 0, 0, '2015-01-01 00:00:00', NULL, 'IN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajachica`
--

DROP TABLE IF EXISTS `cajachica`;
CREATE TABLE IF NOT EXISTS `cajachica` (
  `iCajaChicaId` int(11) NOT NULL AUTO_INCREMENT,
  `iCuentasId` int(11) DEFAULT NULL,
  `fMonto` float DEFAULT NULL,
  `vTipoConcepto` varchar(1) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vConceptoGeneral` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iCajaChicaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `cajachica`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `iCategoriaId` int(11) NOT NULL AUTO_INCREMENT,
  `cCategoriaCodigo` char(7) NOT NULL,
  `vCategoriaDescripcion` varchar(45) NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iClasificacionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iCategoriaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Volcar la base de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`iCategoriaId`, `cCategoriaCodigo`, `vCategoriaDescripcion`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `iClasificacionId`) VALUES
(15, 'CA00001', 'DILSOLVENTE', 0, 0, '2015-02-15 00:00:00', NULL, 'AC', 1),
(16, 'CA00016', 'SERVICIOS', 2, 2, '2015-04-21 23:39:54', '2015-04-21 23:40:09', 'AC', 5),
(17, 'CA00017', 'MATARIA PRIMA', 2, 0, '2015-04-24 23:37:55', NULL, 'AC', 2),
(18, 'CA00018', 'DILSOLVENTE', 2, 0, '2015-04-24 23:38:07', NULL, 'AC', 4),
(19, 'CA00019', 'SUMINISTRO', 2, 0, '2015-04-24 23:39:11', NULL, 'AC', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacioncategoria`
--

DROP TABLE IF EXISTS `clasificacioncategoria`;
CREATE TABLE IF NOT EXISTS `clasificacioncategoria` (
  `iClasificacionId` int(11) NOT NULL AUTO_INCREMENT,
  `cClasificacionCodigo` char(7) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vClasificacionDescripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iClasificacionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `clasificacioncategoria`
--

INSERT INTO `clasificacioncategoria` (`iClasificacionId`, `cClasificacionCodigo`, `vClasificacionDescripcion`, `cEstadoCodigo`) VALUES
(1, 'S001', 'PRODUCTOS', 'AC'),
(2, 'S002', 'MATERIA PRIMA', 'AC'),
(3, 'S003', 'SUMINISTROS Y REPUESTOS', 'AC'),
(4, 'S004', 'ENVASES Y EMBALAJES', 'AC'),
(5, 'S005', 'SERVICIOS', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacioncliente`
--

DROP TABLE IF EXISTS `clasificacioncliente`;
CREATE TABLE IF NOT EXISTS `clasificacioncliente` (
  `iClasificacionClienteId` int(11) NOT NULL AUTO_INCREMENT,
  `vNombre` varchar(45) DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  PRIMARY KEY (`iClasificacionClienteId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `clasificacioncliente`
--

INSERT INTO `clasificacioncliente` (`iClasificacionClienteId`, `vNombre`, `fDescuento`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(1, 'TIPO A ', 15, 0, 0, NULL, '2015-04-03 14:58:18', 'AC'),
(2, 'TIPO B ', 5, 0, 0, NULL, '2015-04-03 14:58:32', 'AC'),
(3, 'WR', 51, 0, 0, '2015-04-25 00:40:52', NULL, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `iClienteId` int(11) NOT NULL AUTO_INCREMENT,
  `vClienteCodigo` char(7) NOT NULL,
  `vNombreCliente` varchar(50) DEFAULT NULL,
  `vClienteRazonSocial` varchar(100) NOT NULL,
  `nClienteNumeroDocumento` decimal(11,0) DEFAULT NULL,
  `nClienteTelefono` varchar(50) DEFAULT NULL,
  `vRubro` varchar(45) DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iClasificacionClienteId` int(11) DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  PRIMARY KEY (`iClienteId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcar la base de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`iClienteId`, `vClienteCodigo`, `vNombreCliente`, `vClienteRazonSocial`, `nClienteNumeroDocumento`, `nClienteTelefono`, `vRubro`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iClasificacionClienteId`, `fDescuento`) VALUES
(6, 'CL00001', NULL, 'LIZ', '5485540', '989522545', NULL, 2, '2015-04-06 21:31:54', 0, NULL, 'AC', 1, 15),
(7, 'CL00007', NULL, 'WEWRW', '545451521', '5RWREW', NULL, 2, '2015-04-25 00:41:32', 0, NULL, 'AC', 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

DROP TABLE IF EXISTS `configuracion`;
CREATE TABLE IF NOT EXISTS `configuracion` (
  `iConfiguracionId` int(11) NOT NULL AUTO_INCREMENT,
  `vConcepto` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vValor` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iConfiguracionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=13 ;

--
-- Volcar la base de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`iConfiguracionId`, `vConcepto`, `vValor`, `dFechaInserta`, `cEstadoCodigo`) VALUES
(1, 'TIPO MONEDA', 'DOLARES', '2015-04-10 02:39:19', 'AC'),
(2, 'TIPO CAMBIO', '3.14', '2015-04-24 00:22:13', 'AC'),
(3, 'NRO FACTURA VENTA', '0001-000001', '2015-01-08 00:00:00', 'AC'),
(4, 'NRO BOLETA VENTA', '000B1-000001', '2015-01-09 00:00:00', 'AC'),
(5, 'NRO GUIA REMISION VENTA', '000G1-000001', '2015-01-09 00:00:00', 'AC'),
(6, 'DESC. SNP %', '13', '2015-01-27 00:00:00', 'AC'),
(7, 'DESC. AFP %', '10', '2015-01-29 00:00:00', 'AC'),
(8, 'DESC. P.S %', '1.35', '2015-01-27 00:00:00', 'AC'),
(9, 'DESC. C.V %', '2', '2015-01-27 00:00:00', 'AC'),
(10, 'APORT. ESSALUD %', '9', '2015-01-27 00:00:00', 'AC'),
(11, 'APORT. I.E.S %', '2', '2015-01-27 00:00:00', 'AC'),
(12, 'NRO NOTA CREDITO', 'N0001-00001', '2015-04-11 07:11:23', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
CREATE TABLE IF NOT EXISTS `cuentas` (
  `iCuentasId` int(11) NOT NULL AUTO_INCREMENT,
  `iElementoCuentasId` int(11) DEFAULT NULL,
  `vCodigo` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vDescripcion` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iCuentasId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=341 ;

--
-- Volcar la base de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`iCuentasId`, `iElementoCuentasId`, `vCodigo`, `vDescripcion`) VALUES
(1, 1, '10', 'CAJA Y BANCOS'),
(2, 1, '101', 'Caja'),
(3, 1, '102', 'Fondos fijos'),
(4, 1, '103', 'Efectivo en transito'),
(5, 1, '104', 'Cuentas corrientes'),
(6, 1, '1041', 'Bancos'),
(7, 1, '12', 'CLIENTES'),
(8, 1, '121', 'Facturas, boletas y otros comprobantes por cobrar'),
(9, 1, '122', 'Anticipos de clientes'),
(10, 1, '123', 'Letras por cobrar'),
(11, 1, '128', 'Anticipos de Clientes'),
(12, 1, '129', 'Cobranza Dudosa'),
(13, 1, '14', 'CTAS POR COBRAR AL PERS., A LOS ACC. (SOC), DIRE. Y GER.'),
(14, 1, '141', 'Personal'),
(15, 1, '1411', 'Prestamos'),
(16, 1, '1412', 'Adelanto de remuneraciones'),
(17, 1, '1419', 'Otras cuentas por cobrar al personal'),
(18, 1, '142', 'Accionistas (o socios)'),
(19, 1, '1421', 'Suscripciones por cobrar a socios o accionistas'),
(20, 1, '1422', 'Prestamos'),
(21, 1, '143', 'Directores'),
(22, 1, '1431', 'Prestamos'),
(23, 1, '1433', 'Entregas a rendir cuenta'),
(24, 1, '144', 'Gerentes'),
(25, 1, '1441', 'Prestamos'),
(26, 1, '1442', 'Adelanto de remuneraciones'),
(27, 1, '1443', 'Entregas a rendir cuenta'),
(28, 1, '148', 'Diversas'),
(29, 1, '16', 'CUENTAS POR COBRAR DIVERSAS - TERCEROS'),
(30, 1, '161', 'Prestamos a terceros'),
(31, 1, '162', 'Reclamaciones a terceros'),
(32, 1, '163', 'Intereses por cobrar'),
(33, 1, '168', 'Otras Cuentas por Cobrar'),
(34, 1, '169', 'Cobranza dudosa'),
(35, 1, '18', 'SERVICIOS Y OTROS CONTRATADOS POR ANTICIPADO'),
(36, 1, '181', 'Costos financieros'),
(37, 1, '182', 'Seguros'),
(38, 1, '183', 'Alquileres'),
(39, 1, '184', 'Primas pagadas por opciones'),
(40, 1, '185', 'Mantenimiento de activos inmovilizados'),
(41, 1, '189', 'Otros gastos contratados por anticipado'),
(42, 1, '19', 'PROVISION PARA CUENTAS DE COBRANZA DUDOSA'),
(43, 1, '191', 'Cuentas por cobrar comerciales o Terceros'),
(44, 1, '1911', 'Facturas, boletas y otros comprobantes por cobrar'),
(45, 1, '1912', 'Letras por cobrar'),
(46, 1, '192', 'Cuentas por cobrar comerciales, Relacionadas'),
(47, 1, '1921', 'Facturas, boletas y otros comprobantes por cobrar'),
(48, 1, '1922', 'Letras por cobrar'),
(49, 1, '193', 'Cuentas por cobrar al personal, a los accionistas (socios), '),
(50, 1, '1931', 'Personal'),
(51, 1, '1932', 'Accionistas (o socios)'),
(52, 1, '1933', 'Directores'),
(53, 1, '1934', 'Gerentes'),
(54, 1, '1938', 'Diversas'),
(55, 1, '196', 'Cuentas por Cobrar Diversas'),
(56, 2, '20', 'MERCADERIAS'),
(57, 2, '201', 'Almacen'),
(58, 2, '207', 'Mercaderias Manufacturadas'),
(59, 2, '208', 'Otras mercaderias'),
(60, 2, '21', 'PRODUCTOS TERMINADOS'),
(61, 2, '211', 'Productos manufacturados'),
(62, 2, '24', 'MATERIAS PRIMAS'),
(63, 2, '241', 'Materias primas para productos manufacturados'),
(64, 2, '244', 'Materias primas para productos inmuebles'),
(65, 2, '25', 'MATERIALES AUXILIARES, SUMINISTROS Y REPUESTOS'),
(66, 2, '251', 'Materiales auxiliares'),
(67, 2, '252', 'Suministros'),
(68, 2, '2521', 'Combustibles'),
(69, 2, '2522', 'Lubricantes'),
(70, 2, '2524', 'Otros suministros'),
(71, 2, '253', 'Repuestos'),
(72, 2, '26', 'ENVASES Y EMBALAJES'),
(73, 2, '261', 'Envases'),
(74, 2, '262', 'Embalajes'),
(75, 2, '27', 'ACTIVOS NO CORRIENTES MANTENIDOS PARA LA VENTA'),
(76, 2, '271', 'Inversiones inmobiliarias'),
(77, 2, '2711', 'Terrenos'),
(78, 2, '27111', 'Valor razonable'),
(79, 2, '27112', 'Costo'),
(80, 2, '2712', 'Edificaciones'),
(81, 2, '272', 'Inmuebles, maquinaria y equipo'),
(82, 2, '2721', 'Terrenos'),
(83, 2, '2722', 'Edificaciones'),
(84, 2, '2725', 'Muebles y enseres'),
(85, 2, '2726', 'Equipos diversos'),
(86, 2, '2727', 'Herramientas y unidades de reemplazo'),
(87, 2, '273', 'Intangibles'),
(88, 2, '2731', 'Concesiones, licencias y derechos'),
(89, 2, '2732', 'Patentes y propiedad industrial'),
(90, 2, '2733', 'Programas de computadora (software)'),
(91, 2, '28', 'EXISTENCIAS POR RECIBIR'),
(92, 2, '281', 'Mercaderias'),
(93, 2, '284', 'Materias primas'),
(94, 2, '285', 'Materiales auxiliares, suministros y repuestos'),
(95, 2, '286', 'Envases y embalajes'),
(96, 2, '29', 'DESVALORIZACION DE EXISTENCIAS'),
(97, 2, '291', 'Mercaderias'),
(98, 2, '2911', 'Mercaderias manufacturadas'),
(99, 2, '2912', 'Mercaderis de extraccion'),
(100, 2, '2914', 'Mercaderias inmuebles'),
(101, 2, '2918', 'Otras mercaderias'),
(102, 2, '292', 'Productos terminados'),
(103, 2, '2921', 'Productos manufacturados'),
(104, 2, '2924', 'Productos inmuebles'),
(105, 2, '2925', 'Existencias de servicios terminados'),
(106, 2, '2927', 'Otros productos terminados'),
(107, 2, '293', 'Subproductos, desechos y desperdicios'),
(108, 2, '2931', 'Subproductos'),
(109, 2, '2932', 'Desechos y desperdicios'),
(110, 2, '294', 'Productos en proceso'),
(111, 2, '2941', 'Productos en proceso de manufactura'),
(112, 2, '2947', 'Otros productos en proceso'),
(113, 2, '295', 'Materias primas'),
(114, 2, '2951', 'Materias primas para productos manufacturados'),
(115, 2, '2954', 'Materias primas para productos inmuebles'),
(116, 2, '296', 'Materiales auxiliares, suministros y repuestos'),
(117, 2, '2961', 'Materiales auxiliares'),
(118, 2, '2962', 'Suministros'),
(119, 2, '2963', 'Repuestos'),
(120, 2, '297', 'Envases y embalajes'),
(121, 2, '2971', 'Envases'),
(122, 2, '2972', 'Embalajes'),
(123, 2, '298', 'Existencias por recibir'),
(124, 2, '2981', 'Mercaderias'),
(125, 2, '2982', 'Materias primas'),
(126, 2, '2983', 'Materiales auxiliares, suministros y repuestos'),
(127, 2, '2984', 'Envases y embalajes'),
(128, 3, '31', 'INVERSIONES INMOBILIARIAS'),
(129, 3, '311', 'Terrenos'),
(130, 3, '3111', 'Urbanos'),
(131, 3, '3112', 'Rurales'),
(132, 3, '312', 'Edificaciones'),
(133, 3, '32', 'ACTIVOS ADQUIRIDOS EN ARRENDAMIENTO FINANCIERO'),
(134, 3, '321', 'Inversiones inmobiliarias'),
(135, 3, '3211', 'Terrenos'),
(136, 3, '3212', 'Edificaciones'),
(137, 3, '322', 'Inmuebles, maquinaria y equipo'),
(138, 3, '3221', 'Terrenos'),
(139, 3, '3222', 'Edificaciones'),
(140, 3, '3223', 'Maquinarias y equipos de explotacion'),
(141, 3, '3224', 'Equipo de transporte'),
(142, 3, '3225', 'Muebles y enseres'),
(143, 3, '3226', 'Equipos diversos'),
(144, 3, '3227', 'Herramientas y unidades de reemplazo'),
(145, 3, '33', 'INMUEBLES, MAQUINARIA Y EQUIPO'),
(146, 3, '331', 'Terrenos'),
(147, 3, '332', 'Edificaciones'),
(148, 3, '333', 'Maquinarias y equipos de explotacion'),
(149, 3, '334', 'Equipo de transporte'),
(150, 3, '335', 'Muebles y enseres'),
(151, 3, '336', 'Equipos diversos'),
(152, 3, '337', 'Herramientas y unidades de reemplazo'),
(153, 3, '338', 'Unidades por recibir'),
(154, 3, '339', 'Construcciones y obras en curso'),
(155, 3, '38', 'CARGAS DIFERIDAS'),
(156, 3, '381', 'Intereses por Devengar'),
(157, 3, '382', 'Seguros Pagados por Adelanto'),
(158, 3, '383', 'Alquileres Pagados por Adelanto'),
(159, 3, '385', 'Adelanto de Remuneraciones'),
(160, 3, '388', 'Gastos Anticipados'),
(161, 3, '389', 'Otras Cargas Diferidas'),
(162, 3, '39', 'DEPRECIACION Y AMORTIZACION ACUMULADOS'),
(163, 3, '393', 'Depreciacion de Inmueble, Maquina y Equipo'),
(164, 3, '394', 'Amortizacion Intangibles'),
(165, 3, '398', 'Depreciacion de Amortizacion Acumulada '),
(166, 4, '40', 'TRIBUTOS POR PAGAR'),
(167, 4, '401', 'Gobierno central'),
(168, 4, '4011', 'IGV'),
(169, 4, '4012', 'Impuesto Extraordinario de Solidaridad 2%'),
(170, 4, '4013', 'Impuesto a las Remuneraciones'),
(171, 4, '4017', 'Impuesto a la renta'),
(172, 4, '40171', 'Renta de tercera categoria'),
(173, 4, '40172', 'Renta de cuarta categoria'),
(174, 4, '40173', 'Renta de quinta categoria'),
(175, 4, '40174', 'Renta de no domiciliados'),
(176, 4, '40175', 'Otras retenciones'),
(177, 4, '4019', 'Otros impuestos y Tributos'),
(178, 4, '402', 'Certificados tributarios'),
(179, 4, '403', ' Contribuciones a Instituciones Publicas'),
(180, 4, '4031', 'ESSALUD 9%'),
(181, 4, '4032', 'ONP'),
(182, 4, '4033', 'IES 2%'),
(183, 4, '404', 'Contribuciones a Instituciones Privadas (AFP)'),
(184, 4, '4041', 'Fondo de Pensiones 8%'),
(185, 4, '4042', 'Prima de Seguro 1.35%'),
(186, 4, '4043', 'Comision Variable 2.10%'),
(187, 4, '405', 'Gobiernos Locales'),
(188, 4, '4051', 'Municipalidazd Provincial'),
(189, 4, '41', 'REMUNERACIONES Y PARTICIPACIONES POR PAGAR'),
(190, 4, '411', 'Remuneraciones por pagar'),
(191, 4, '4111', 'Sueldos y salarios por pagar'),
(192, 4, '4112', 'Comisiones por pagar'),
(193, 4, '4114', 'Gratificaciones por pagar'),
(194, 4, '412', 'Vacaciones por pagar'),
(195, 4, '413', 'Participacion de los trabajadores por pagar'),
(196, 4, '415', 'Beneficios sociales de los trabajadores por pagar'),
(197, 4, '419', 'Otras remuneraciones y participaciones por pagar'),
(198, 4, '42', 'PROVEEDORES'),
(199, 4, '421', 'Facturas, boletas y otros comprobantes por pagar'),
(200, 4, '422', 'Anticipos a proveedores'),
(201, 4, '423', 'Letras por pagar'),
(202, 4, '424', 'Honorarios por pagar'),
(203, 4, '428', 'Anticipos a Proveedores'),
(204, 4, '46', 'CUENTAS POR PAGAR DIVERSAS TERCEROS'),
(205, 4, '461', 'Prestamos de terceros'),
(206, 4, '466', 'Intereses por Pagar'),
(207, 4, '469', 'Otras cuentas por pagar'),
(208, 4, '47', 'BENEFICIOS SOCIALES DE LOS TRABAJADORES'),
(209, 4, '471', 'Compensacion por Tiempo de Servicio'),
(210, 4, '472', 'Adelanto de Compensacion por Tiempo  de Servicios'),
(211, 4, '473', 'Jubilacion'),
(212, 5, '50', 'CAPITAL'),
(213, 5, '501', 'Capital social'),
(214, 5, '502', 'Capital Personal'),
(215, 5, '509', 'Cuenta Personal de Propietario'),
(216, 5, '59', 'RESULTADOS ACUMULADOS'),
(217, 5, '591', 'Utilidades no distribuidas'),
(218, 5, '592', 'Perdidas acumuladas'),
(219, 6, '60', 'COMPRAS'),
(220, 6, '601', 'Mercaderias'),
(221, 6, '602', 'Materias primas'),
(222, 6, '604', 'Envases y embalajes'),
(223, 6, '609', 'Costos vinculados con las compras'),
(224, 6, '61', 'VARIACION DE EXISTENCIAS'),
(225, 6, '611', 'Mercaderias'),
(226, 6, '612', 'Materias primas'),
(227, 6, '613', 'Materiales auxiliares, suministros y repuestos'),
(228, 6, '614', 'Envases y embalajes'),
(229, 6, '62', 'GASTOS DE PERSONAL, DIRECTORES Y GERENTES'),
(230, 6, '621', 'Remuneraciones'),
(231, 6, '622', 'Sueldos y salarios'),
(232, 6, '623', 'Comisiones'),
(233, 6, '625', 'Otras Remuneraciones'),
(234, 6, '6251', 'Horas Extras'),
(235, 6, '6252', 'Bonificaciones'),
(236, 6, '6253', 'Asignacion Familiar'),
(237, 6, '6254', 'Gratificacion'),
(238, 6, '626', 'Vacaciones'),
(239, 6, '627', 'Seguridad y Provision Social'),
(240, 6, '6271', 'Seguro Social de Salud (Essalud)'),
(241, 6, '6272', 'Regimen de Pensiones'),
(242, 6, '6273', 'Seguro Complementario de Trabajo de Riesgo'),
(243, 6, '6274', 'Seguro de Vida'),
(244, 6, '629', 'Otras Cargas de Personal'),
(245, 6, '63', 'GASTOS DE SERVICIOS PRESTADOS POR TERCEROS'),
(246, 6, '631', 'Transporte, correos y gastos de viaje'),
(247, 6, '6311', 'Transporte'),
(248, 6, '63111', 'De carga'),
(249, 6, '63112', 'De pasajeros'),
(250, 6, '6312', 'Correos'),
(251, 6, '6313', 'Alojamiento'),
(252, 6, '6314', 'Alimentacion'),
(253, 6, '6315', 'Otros gastos de viaje'),
(254, 6, '632', 'Asesoria y consultoria'),
(255, 6, '6321', 'Administrativa'),
(256, 6, '6322', 'Legal y tributaria'),
(257, 6, '6323', 'Auditoria y contable'),
(258, 6, '6324', 'Mercadotecnia'),
(259, 6, '6329', 'Otros'),
(260, 6, '634', 'Mantenimiento y reparaciones'),
(261, 6, '635', 'Alquileres'),
(262, 6, '6351', 'Terrenos'),
(263, 6, '6352', 'Edificaciones'),
(264, 6, '6353', 'Maquinarias y equipos de explotacion'),
(265, 6, '6354', 'Equipo de transporte'),
(266, 6, '6356', 'Equipos diversos'),
(267, 6, '636', 'Servicios basicos'),
(268, 6, '6361', 'Energia electrica'),
(269, 6, '6362', 'Gas'),
(270, 6, '6363', 'Agua'),
(271, 6, '6364', 'Telefono'),
(272, 6, '6365', 'Internet'),
(273, 6, '6367', 'Cable'),
(274, 6, '637', 'Publicidad, publicaciones,Rel. Publicas'),
(275, 6, '638', 'Servicios de contratistas'),
(276, 6, '639', 'Otros servicios prestados por terceros'),
(277, 6, '64', 'GASTOS POR TRIBUTOS'),
(278, 6, '641', 'Impuesto a las ventas'),
(279, 6, '642', 'Impuesto a las Remuneraciones'),
(280, 6, '642', 'Gobierno regional'),
(281, 6, '643', 'Gobierno local'),
(282, 6, '6431', 'Impuesto predial'),
(283, 6, '6432', 'Arbitrios municipales y seguridad ciudadana'),
(284, 6, '6433', 'Impuesto al patrimonio vehicular'),
(285, 6, '6434', 'Licencia de funcionamiento'),
(286, 6, '6439', 'Otros'),
(287, 6, '644', 'Otros gastos por tributos'),
(288, 6, '65', 'OTROS GASTOS DE GESTION'),
(289, 6, '651', 'Seguros'),
(290, 6, '652', 'Regalias'),
(291, 6, '653', 'Suscripciones y Cotizaciones'),
(292, 6, '654', 'Donaciones'),
(293, 6, '655', 'Otras Cargas Diversas de GestiÃƒÂ³n'),
(294, 6, '67', 'GASTOS FINANCIEROS'),
(295, 6, '671', 'Intereses y Gastos de Prestamos'),
(296, 6, '674', 'Intereses y Gastos de Doc. Descontados'),
(297, 6, '675', 'Descuentos concedidos por pronto pago'),
(298, 6, '679', 'Otros Gastos Financieros'),
(299, 6, '68', 'PROVISIONES DEL EJERCICIO'),
(300, 6, '681', 'Depreciacion de Inmueble, Maquinaria y Equipo'),
(301, 6, '682', 'Amortizacion de intangibles'),
(302, 6, '685', 'Deterioro del valor de los activos'),
(303, 6, '686', 'CTS'),
(304, 6, '69', 'COSTO DE VENTAS'),
(305, 6, '691', 'Mercaderias'),
(306, 6, '692', 'Productos terminados'),
(307, 6, '694', 'Servicios'),
(308, 6, '695', 'Gastos por desvalorizacion de existencias'),
(309, 6, '698', 'Costo de Ventas'),
(310, 7, '70', 'VENTAS'),
(311, 7, '701', 'Mercaderias'),
(312, 7, '702', 'Productos terminados'),
(313, 7, '703', 'Subproductos, desechos y desperdicios'),
(314, 7, '704', 'Prestacion de servicios'),
(315, 7, '708', 'Ventas'),
(316, 7, '709', 'Devoluciones sobre ventas'),
(317, 7, '73', 'DESCUENTOS, REBAJAS Y BONIFICACIONES OBTENIDOS'),
(318, 7, '74', 'DESCUENTOS, REBAJAS Y BONIFICACIONES CONCEDIDOS'),
(319, 7, '75', 'OTROS INGRESOS DE GESTION'),
(320, 7, '77', 'INGRESOS FINANCIEROS'),
(321, 7, '771', 'Intereses Sobre Prestamos Otorgados'),
(322, 7, '772', 'Intereses Sobre Cuentas por Cobrar Mercantiles'),
(323, 7, '78', 'CARGAS CUBIERTAS POR PROVISIONES'),
(324, 7, '79', 'CARGAS IMPUTABLES A CUENTAS DE COSTOS Y GASTOS'),
(325, 7, '791', 'Cargas imputables a cuentas de costos y gastos'),
(326, 7, '792', 'Gastos financieros imputables a cuentas de existencias'),
(327, 8, '80', 'MARGEN COMERCIAL'),
(328, 8, '81', 'PRODUCCION DEL EJERCICIO'),
(329, 8, '82', 'VALOR AGREGADO'),
(330, 8, '83', 'EXCEDENTE (INSUFICIENCIA BRUTA) DE EXPLOTACION'),
(331, 8, '84', 'RESULTADO DE EXPLOTACION'),
(332, 8, '85', 'RESULTADO ANTES DE PARTICIPACIONES E IMPUESTOS'),
(333, 8, '87', 'PARTICIPACIONES DE LOS TRABAJADORES'),
(334, 8, '88', 'IMPUESTO A LA RENTA'),
(335, 8, '89', 'DETERMINACION DEL RESULTADO DEL EJERCICIO'),
(336, 8, '891', 'Utilidad'),
(337, 8, '892', 'Perdida'),
(338, 9, '94', 'GASTOS ADMINISTRATIVOS'),
(339, 9, '95', 'GASTOS DE VENTAS'),
(340, 9, '97', 'GASTOS FINANCIEROS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuota`
--

DROP TABLE IF EXISTS `cuota`;
CREATE TABLE IF NOT EXISTS `cuota` (
  `iCuotaId` int(11) NOT NULL AUTO_INCREMENT,
  `iCuotaNumero` int(11) NOT NULL,
  `fCuotaInteres` float NOT NULL,
  `fCuotaMonto` float NOT NULL,
  `dCuotaFecha` date NOT NULL,
  `vCuotaDescripcion` varchar(45) NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime NOT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iVentaId` int(11) NOT NULL,
  PRIMARY KEY (`iCuotaId`),
  KEY `fk_cuota_venta1` (`iVentaId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `cuota`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccioncliente`
--

DROP TABLE IF EXISTS `direccioncliente`;
CREATE TABLE IF NOT EXISTS `direccioncliente` (
  `idireccionClienteId` int(11) NOT NULL AUTO_INCREMENT,
  `iClienteId` int(11) NOT NULL,
  `iPoblacionId` varchar(6) NOT NULL,
  `vDireccion` varchar(70) DEFAULT NULL,
  `vReferencia` varchar(45) DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `vPrincipal` char(2) DEFAULT NULL,
  PRIMARY KEY (`idireccionClienteId`),
  UNIQUE KEY `idireccionClienteId` (`idireccionClienteId`),
  KEY `fk_direccionCliente_cliente1` (`iClienteId`),
  KEY `fk_direccionCliente` (`iClienteId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=82 ;

--
-- Volcar la base de datos para la tabla `direccioncliente`
--

INSERT INTO `direccioncliente` (`idireccionClienteId`, `iClienteId`, `iPoblacionId`, `vDireccion`, `vReferencia`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `vPrincipal`) VALUES
(80, 6, '140501', 'AV.PUENTE', NULL, 2, '2015-04-06 21:31:54', 0, NULL, 'AC', '1'),
(81, 7, '140501', 'FEEEV54/', NULL, 2, '2015-04-25 00:41:32', 0, NULL, 'AC', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejerciciofiscal`
--

DROP TABLE IF EXISTS `ejerciciofiscal`;
CREATE TABLE IF NOT EXISTS `ejerciciofiscal` (
  `iEjercicioFiscalId` int(11) NOT NULL AUTO_INCREMENT,
  `vCodigoEjercicio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vNombreEjercicio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dFechaInicio` date DEFAULT NULL,
  `dFechaFin` date DEFAULT NULL,
  `iUsuarioInserta` int(11) DEFAULT NULL,
  `iUsuarioActualiza` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cCodigoEstado` char(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iEjercicioFiscalId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `ejerciciofiscal`
--

INSERT INTO `ejerciciofiscal` (`iEjercicioFiscalId`, `vCodigoEjercicio`, `vNombreEjercicio`, `dFechaInicio`, `dFechaFin`, `iUsuarioInserta`, `iUsuarioActualiza`, `dFechaInserta`, `dFechaActualiza`, `cCodigoEstado`) VALUES
(6, '01', 'EJERCICIO 2015', '2015-01-01', '2015-12-31', 0, 0, '2015-01-01 00:00:00', NULL, 'ABIERTO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `elementocuentas`
--

DROP TABLE IF EXISTS `elementocuentas`;
CREATE TABLE IF NOT EXISTS `elementocuentas` (
  `iElementoCuentasId` int(11) NOT NULL AUTO_INCREMENT,
  `vElemento` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vDescripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iElementoCuentasId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=11 ;

--
-- Volcar la base de datos para la tabla `elementocuentas`
--

INSERT INTO `elementocuentas` (`iElementoCuentasId`, `vElemento`, `vDescripcion`) VALUES
(1, 'Elemento 1', 'Activo disponible y exigible'),
(2, 'Elemento 2', 'Activo realizable'),
(3, 'Elemento 3', 'Activo inmovilizado'),
(4, 'Elemento 4', 'Pasivo'),
(5, 'Elemento 5', 'Patrimonio neto'),
(6, 'Elemento 6', 'Gastos por naturaleza'),
(7, 'Elemento 7', 'Ingresos'),
(8, 'Elemento 8', 'Saldos intermediarios de gestion y determinac'),
(9, 'Elemento 9', 'Costos de produccion y gastos por funcion'),
(10, 'Elemento 0', 'cuentas de orden');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE IF NOT EXISTS `empresa` (
  `iEmpresaId` int(11) NOT NULL AUTO_INCREMENT,
  `cEmpresaCodigo` varchar(45) DEFAULT NULL,
  `vEmpresaNombre` varchar(45) DEFAULT NULL,
  `vEmpresaRuc` varchar(10) DEFAULT NULL,
  `vEmpresaDireccion` varchar(70) DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  PRIMARY KEY (`iEmpresaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`iEmpresaId`, `cEmpresaCodigo`, `vEmpresaNombre`, `vEmpresaRuc`, `vEmpresaDireccion`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(2, 'EM00001', 'CASTUA', '1021021', 'AV.PUEN', 2, 0, '2015-04-17 00:02:33', NULL, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE IF NOT EXISTS `estado` (
  `iEstadoId` int(11) NOT NULL AUTO_INCREMENT,
  `cEstadoCodigo` char(2) NOT NULL,
  `vEstadoDescripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`iEstadoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `estado`
--

INSERT INTO `estado` (`iEstadoId`, `cEstadoCodigo`, `vEstadoDescripcion`) VALUES
(1, 'AC', 'ACTIVO'),
(2, 'IN', 'INACTIVO'),
(3, 'EL', 'ELIMINADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadocuentacliente`
--

DROP TABLE IF EXISTS `estadocuentacliente`;
CREATE TABLE IF NOT EXISTS `estadocuentacliente` (
  `iEstadoCuentaCliente` int(11) NOT NULL AUTO_INCREMENT,
  `iClienteId` int(11) NOT NULL,
  `fMontoPago` float NOT NULL,
  `iVentaId` int(11) NOT NULL,
  `dFechaPago` date DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  PRIMARY KEY (`iEstadoCuentaCliente`),
  KEY `fk_estadoCuentaCliente_cliente1` (`iClienteId`),
  KEY `fk_estadoCuentaCliente_venta1` (`iVentaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Volcar la base de datos para la tabla `estadocuentacliente`
--

INSERT INTO `estadocuentacliente` (`iEstadoCuentaCliente`, `iClienteId`, `fMontoPago`, `iVentaId`, `dFechaPago`, `dFechaInserta`, `iUsuarioInsertaId`, `cEstadoCodigo`) VALUES
(7, 6, 4.8875, 35, '2015-04-16', '2015-04-16 23:36:34', 2, 'AC'),
(8, 6, 4.8875, 35, '2015-04-25', '2015-04-25 01:36:46', 2, 'AC'),
(9, 6, 4.8875, 35, '2015-04-25', '2015-04-25 01:36:55', 2, 'AC'),
(10, 6, 4.8875, 35, '2015-04-25', '2015-04-25 01:38:14', 2, 'AC'),
(11, 6, 4.8875, 35, '2015-04-25', '2015-04-25 01:52:29', 2, 'AC'),
(12, 6, 4.8875, 35, '2015-04-25', '2015-04-25 01:55:51', 2, 'AC'),
(13, 6, 4.8875, 35, '2015-04-25', '2015-04-25 02:01:57', 2, 'AC'),
(14, 6, 4.8875, 35, '2015-04-25', '2015-04-25 02:24:39', 2, 'AC'),
(15, 6, 4.8875, 35, '2015-04-25', '2015-04-25 02:34:06', 2, 'AC'),
(16, 6, 4.8875, 35, '2015-04-25', '2015-04-25 02:37:59', 2, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadocuentaproveedor`
--

DROP TABLE IF EXISTS `estadocuentaproveedor`;
CREATE TABLE IF NOT EXISTS `estadocuentaproveedor` (
  `iEstadoCuentaProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `fMontoPago` float NOT NULL,
  `dFechaPago` date DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iProveedorId` int(11) NOT NULL,
  `iIngresoProductoId` int(11) NOT NULL,
  `sVendedor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iEstadoCuentaProveedor`),
  KEY `fk_estadoCuentaProveedor_proveedor1` (`iProveedorId`),
  KEY `fk_estadoCuentaProveedor_ingresoProducto1` (`iIngresoProductoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `estadocuentaproveedor`
--

INSERT INTO `estadocuentaproveedor` (`iEstadoCuentaProveedor`, `fMontoPago`, `dFechaPago`, `dFechaInserta`, `iUsuarioInsertaId`, `cEstadoCodigo`, `iProveedorId`, `iIngresoProductoId`, `sVendedor`) VALUES
(1, 5000, '2015-04-25', '2015-04-25 04:50:48', 2, 'AC', 1, 4, NULL),
(2, 5000, '2015-04-25', '2015-04-25 04:51:50', 2, 'AC', 1, 4, NULL),
(3, 5000, '2015-04-25', '2015-04-25 05:07:09', 2, 'AC', 1, 4, NULL),
(4, 5000, '2015-04-25', '2015-04-25 05:22:55', 2, 'AC', 1, 4, NULL),
(5, 320100, '2015-04-25', '2015-04-25 05:34:13', 2, 'AC', 1, 5, NULL),
(6, 350, '2015-04-25', '2015-04-25 05:49:46', 2, 'AC', 1, 6, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formapago`
--

DROP TABLE IF EXISTS `formapago`;
CREATE TABLE IF NOT EXISTS `formapago` (
  `iFormaPago` int(11) NOT NULL AUTO_INCREMENT,
  `vFormaPagoDescripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iFormaPago`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `formapago`
--

INSERT INTO `formapago` (`iFormaPago`, `vFormaPagoDescripcion`) VALUES
(1, 'CONTADO'),
(2, 'CREDITO '),
(3, 'CREDITO 15 DIAS '),
(4, 'CREDITO 30 DIAS'),
(5, 'LETRA 15 DIAS'),
(6, 'LETRA 30 DIAS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impuestos`
--

DROP TABLE IF EXISTS `impuestos`;
CREATE TABLE IF NOT EXISTS `impuestos` (
  `iImpuestosId` int(11) NOT NULL AUTO_INCREMENT,
  `vNombreImpuesto` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vAplicacionImpuesto` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vPorcentaje` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iUsuarioInserta` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `cCodigoEstado` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iImpuestosId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='''o' AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `impuestos`
--

INSERT INTO `impuestos` (`iImpuestosId`, `vNombreImpuesto`, `vAplicacionImpuesto`, `vPorcentaje`, `iUsuarioInserta`, `dFechaInserta`, `cCodigoEstado`) VALUES
(1, 'IGV 18% COMPRA', 'COMPRAS', '15', 0, '2015-01-02 00:00:00', 'AC'),
(2, 'IGV 18% VENTA', 'VENTAS', '18', 0, '2014-05-08 00:00:00', 'AC'),
(3, 'PERCEPCION IGV 2%', 'COMPRAS', '2', 0, '2014-05-08 00:00:00', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresoproducto`
--

DROP TABLE IF EXISTS `ingresoproducto`;
CREATE TABLE IF NOT EXISTS `ingresoproducto` (
  `iIngresoProductoId` int(11) NOT NULL AUTO_INCREMENT,
  `nIngresoProductoNumero` varchar(25) NOT NULL,
  `dIngresoProductoFecha` date NOT NULL,
  `fIngresoProductoTotal` float NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iProveedorId` int(11) NOT NULL,
  `iTipoDocumentoId` int(11) NOT NULL,
  `iFormaPagoId` int(11) DEFAULT NULL,
  `vPrincipal` varchar(1) DEFAULT NULL,
  `fIngresoProductoSubTotal` float DEFAULT NULL,
  `fIngresoProductoIGV` float DEFAULT NULL,
  `vEstadoDocumento` varchar(45) DEFAULT NULL,
  `vIngresoProductoPuntoLlegada` varchar(45) DEFAULT NULL,
  `dFechaProximoPago` date DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `fIngresoProductoTotalReal` float DEFAULT NULL,
  `fMontoAdelantado` float DEFAULT NULL,
  `fPercepcion` float DEFAULT NULL,
  `iNumeroDias` int(11) DEFAULT NULL,
  `iNumeroLetras` int(11) DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  `iSucursalId` int(11) DEFAULT NULL,
  `fTipoCambio` float DEFAULT NULL,
  `iMonedaId` int(11) DEFAULT NULL,
  `fMontoPago` float DEFAULT NULL,
  `fMontoVuelto` float DEFAULT NULL,
  `vTipoPago` varchar(5) DEFAULT NULL,
  `fDescProveedorCompra` float DEFAULT NULL,
  `vIncluyeIGV` varchar(5) DEFAULT NULL,
  `vTipoCompra` varchar(5) DEFAULT NULL COMMENT '''es el tipo compra en simbolo de moned',
  `vPorcentajeIGV` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iIngresoProductoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `ingresoproducto`
--

INSERT INTO `ingresoproducto` (`iIngresoProductoId`, `nIngresoProductoNumero`, `dIngresoProductoFecha`, `fIngresoProductoTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iProveedorId`, `iTipoDocumentoId`, `iFormaPagoId`, `vPrincipal`, `fIngresoProductoSubTotal`, `fIngresoProductoIGV`, `vEstadoDocumento`, `vIngresoProductoPuntoLlegada`, `dFechaProximoPago`, `fDescuento`, `fIngresoProductoTotalReal`, `fMontoAdelantado`, `fPercepcion`, `iNumeroDias`, `iNumeroLetras`, `iPeriodoId`, `iSucursalId`, `fTipoCambio`, `iMonedaId`, `fMontoPago`, `fMontoVuelto`, `vTipoPago`, `fDescProveedorCompra`, `vIncluyeIGV`, `vTipoCompra`, `vPorcentajeIGV`) VALUES
(1, '65564', '2015-04-25', 0, 2, '2015-04-25 00:00:00', 0, NULL, 'AC', 1, 1, 1, '0', 0, 0, NULL, '4545', NULL, 0, 0, 0, 0, 0, 0, 11, 3, 0, NULL, 0, 0, NULL, 0, NULL, NULL, '15'),
(2, '3123', '2015-04-25', 2300, 2, '2015-04-25 00:00:00', 0, NULL, 'AC', 1, 1, 1, '0', 0, 0, NULL, '4545', NULL, 0, 0, 0, 0, 0, 0, 11, 3, 0, NULL, 0, 0, NULL, 0, NULL, NULL, '15'),
(3, '00001-0001', '2015-04-25', 800, 2, '2015-04-25 00:00:00', 0, NULL, 'AC', 1, 3, 2, '0', 0, 0, NULL, '4545', NULL, 0, 0, 0, 0, 0, 0, 11, 3, 0, NULL, 0, 0, NULL, 0, NULL, NULL, '15'),
(4, '41211', '2015-04-25', 5000, 2, '2015-04-25 00:00:00', 0, NULL, 'AC', 1, 1, 1, '1', 4347.83, 652.17, 'CANCELADO', '4545', '2015-04-25', 0, 5000, 0, 0, 0, 1, 11, 3, 3.14, NULL, 0, 0, '$', 0, '', '$', '15'),
(5, '3126', '2015-04-25', 320100, 2, '2015-04-25 00:00:00', 0, NULL, 'AC', 1, 1, 1, '1', 278348, 41752.2, 'DEVOLUCION PARCIAL', '4545', '2015-04-25', 0, 320100, 0, 0, 0, 1, 11, 3, 3.14, NULL, 0, 0, '$', 0, '', '$', '15'),
(6, '00012', '2015-04-25', 350, 2, '2015-04-25 05:49:46', 0, NULL, 'AC', 1, 1, 1, '1', 304.35, 45.65, 'ANULADO', '4545', '2015-04-25', 0, 350, 0, 0, 0, 1, 11, 3, 3.14, NULL, 0, 0, '$', 0, '', '$', '15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresoproductodetalle`
--

DROP TABLE IF EXISTS `ingresoproductodetalle`;
CREATE TABLE IF NOT EXISTS `ingresoproductodetalle` (
  `iIngresoProductoDetalleId` int(11) NOT NULL AUTO_INCREMENT,
  `fIngresoProductoDetallePrecio` float NOT NULL,
  `iIngresoProductoDetalleCantidad` int(11) NOT NULL,
  `fIngresoProductoDetalleTotal` float NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) NOT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iIngresoProductoId` int(11) NOT NULL,
  `iProductoId` int(11) NOT NULL,
  `fDescuento` float DEFAULT NULL,
  `iSubCta` int(11) DEFAULT NULL,
  PRIMARY KEY (`iIngresoProductoDetalleId`),
  KEY `fk_ingresoProductoDetalle_ingresoProducto1` (`iIngresoProductoId`),
  KEY `fk_ingresoProductoDetalle_producto1` (`iProductoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `ingresoproductodetalle`
--

INSERT INTO `ingresoproductodetalle` (`iIngresoProductoDetalleId`, `fIngresoProductoDetallePrecio`, `iIngresoProductoDetalleCantidad`, `fIngresoProductoDetalleTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iIngresoProductoId`, `iProductoId`, `fDescuento`, `iSubCta`) VALUES
(1, 5, 1000, 5000, 2, '2015-04-25 04:50:48', 0, NULL, 'AC', 4, 42, 0, 0),
(2, 20, 1000, 20000, 2, '2015-04-25 05:34:13', 0, NULL, 'AC', 5, 51, 0, 0),
(3, 1, 100, 100, 2, '2015-04-25 05:34:13', 0, NULL, 'AC', 5, 49, 0, 0),
(4, 250, 1200, 300000, 2, '2015-04-25 05:34:13', 0, NULL, 'AC', 5, 50, 0, 0),
(5, 250, 1, 250, 2, '2015-04-25 05:49:46', 0, NULL, 'AC', 6, 50, 0, 0),
(6, 1, 100, 100, 2, '2015-04-25 05:49:46', 0, NULL, 'AC', 6, 49, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresoproductodevolucion`
--

DROP TABLE IF EXISTS `ingresoproductodevolucion`;
CREATE TABLE IF NOT EXISTS `ingresoproductodevolucion` (
  `iIngresoProductoDevolucionId` int(11) NOT NULL AUTO_INCREMENT,
  `iIngresoProductoId` int(11) DEFAULT NULL,
  `dIngresoProductoDevFecha` date DEFAULT NULL,
  `fIngresoProductoDev` float DEFAULT NULL,
  `fIngresoProductoDevSubTotal` float DEFAULT NULL,
  `fIngresoProductoDevIGV` float DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `vEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  `nNroNotaDebito` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iTipoDocumentoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iIngresoProductoDevolucionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `ingresoproductodevolucion`
--

INSERT INTO `ingresoproductodevolucion` (`iIngresoProductoDevolucionId`, `iIngresoProductoId`, `dIngresoProductoDevFecha`, `fIngresoProductoDev`, `fIngresoProductoDevSubTotal`, `fIngresoProductoDevIGV`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `vEstadoCodigo`, `fDescuento`, `iPeriodoId`, `nNroNotaDebito`, `iTipoDocumentoId`) VALUES
(1, 5, '2015-04-25', 10000, 8695.65, 1304.35, 2, '2015-04-25 05:37:53', 0, NULL, 'AC', 0, 11, 'ND-00111', 8),
(2, 6, '2015-04-25', 100, 86.96, 13.04, 2, '2015-04-25 05:50:14', 0, NULL, 'AC', 0, 11, 'ND-00112', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingresoproductodevoluciondetalle`
--

DROP TABLE IF EXISTS `ingresoproductodevoluciondetalle`;
CREATE TABLE IF NOT EXISTS `ingresoproductodevoluciondetalle` (
  `iIngresoProductoDevolucionDetalleId` int(11) NOT NULL AUTO_INCREMENT,
  `iIngresoProductoDevolucionId` int(11) DEFAULT NULL,
  `iProductoId` int(11) DEFAULT NULL,
  `fIngresoProductoDevDetallePrecio` float DEFAULT NULL,
  `iIngresoProductoDevDetalleCantidad` int(11) DEFAULT NULL,
  `fIngresoProductoDevDetalleTotal` float DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `iSubCta` int(11) DEFAULT NULL,
  PRIMARY KEY (`iIngresoProductoDevolucionDetalleId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `ingresoproductodevoluciondetalle`
--

INSERT INTO `ingresoproductodevoluciondetalle` (`iIngresoProductoDevolucionDetalleId`, `iIngresoProductoDevolucionId`, `iProductoId`, `fIngresoProductoDevDetallePrecio`, `iIngresoProductoDevDetalleCantidad`, `fIngresoProductoDevDetalleTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `fDescuento`, `iSubCta`) VALUES
(1, 1, 51, 20, 500, 10000, 0, '2015-04-25 05:37:53', 0, NULL, 'AC', 0, 0),
(2, 2, 49, 1, 100, 100, 0, '2015-04-25 05:50:14', 0, NULL, 'AC', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `kardex`
--

DROP TABLE IF EXISTS `kardex`;
CREATE TABLE IF NOT EXISTS `kardex` (
  `iKardexId` int(11) NOT NULL AUTO_INCREMENT,
  `iProductoId` int(11) DEFAULT NULL,
  `iIngresoProductoId` int(11) DEFAULT NULL,
  `iVentaId` int(11) DEFAULT NULL,
  `dFecha` date DEFAULT NULL,
  `vConcepto` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iCantIngresoProducto` int(11) DEFAULT NULL,
  `fPuIngresoProducto` float DEFAULT NULL,
  `fTotalngresoProducto` float DEFAULT NULL,
  `iCantVenta` int(11) DEFAULT NULL,
  `fPuVenta` float DEFAULT NULL,
  `fTotalVenta` float DEFAULT NULL,
  `iCantExistencia` int(11) DEFAULT NULL,
  `fPuExistencia` float DEFAULT NULL,
  `fTotalExistencia` float DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  `iVentaDevolucionId` int(11) DEFAULT NULL,
  `iProduccionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iKardexId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=295 ;

--
-- Volcar la base de datos para la tabla `kardex`
--

INSERT INTO `kardex` (`iKardexId`, `iProductoId`, `iIngresoProductoId`, `iVentaId`, `dFecha`, `vConcepto`, `iCantIngresoProducto`, `fPuIngresoProducto`, `fTotalngresoProducto`, `iCantVenta`, `fPuVenta`, `fTotalVenta`, `iCantExistencia`, `fPuExistencia`, `fTotalExistencia`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iPeriodoId`, `iVentaDevolucionId`, `iProduccionId`) VALUES
(273, 42, NULL, NULL, '2015-04-16', 'Existencia Inicial ', 0, 0, 0, 0, 0, 0, 5, 5, 25, 2, '2015-04-16 23:36:20', 0, NULL, 'IN', 11, NULL, NULL),
(274, 42, NULL, 35, '2015-04-16', 'VENTA SEGÚN FACTURA N° 0001-000001', 0, 0, 0, 1, 5, 5, 4, 5, 20, 2, '2015-04-16 23:36:33', 0, NULL, 'IN', 11, NULL, NULL),
(275, 43, NULL, NULL, '2015-04-21', 'Existencia Inicial ', 0, 0, 0, 0, 0, 0, 0, 120, 0, 2, '2015-04-21 23:40:27', 0, NULL, 'AC', 11, NULL, NULL),
(276, 42, NULL, 36, '2015-04-22', 'VENTA SEGÚN FACTURA N° 0001-000002', 0, 0, 0, 3, 5, 15, 1, 5, 5, 2, '2015-04-22 00:06:32', 0, NULL, 'IN', 11, NULL, NULL),
(277, 42, NULL, 37, '2015-04-22', 'VENTA SEGÚN FACTURA N° 0001-000003', 0, 0, 0, 1, 5, 5, 0, 5, 0, 2, '2015-04-22 00:07:07', 0, NULL, 'IN', 11, NULL, NULL),
(278, 44, NULL, NULL, '2015-04-24', 'Existencia Inicial ', 0, 0, 0, 0, 0, 0, 50, 250, 12500, 2, '2015-04-24 23:41:56', 2, '2015-04-24 23:42:30', 'AC', 11, NULL, NULL),
(279, 45, NULL, NULL, '2015-04-25', 'Existencia Inicial ', 0, 0, 0, 0, 0, 0, 20, 20, 400, 2, '2015-04-25 00:15:57', 0, NULL, 'AC', 11, NULL, NULL),
(280, 46, NULL, NULL, '2015-04-25', 'Existencia Inicial ', 0, 0, 0, 0, 0, 0, 20, 20, 400, 2, '2015-04-25 00:17:47', 0, NULL, 'AC', 11, NULL, NULL),
(281, 47, NULL, NULL, '2015-04-25', 'Existencia Inicial ', 0, 0, 0, 0, 0, 0, 0, 200, 0, 2, '2015-04-25 00:29:15', 0, NULL, 'AC', 11, NULL, NULL),
(282, 48, NULL, NULL, '2015-04-25', 'Existencia Inicial ', 0, 0, 0, 0, 0, 0, 0, 21, 0, 2, '2015-04-25 00:30:42', 0, NULL, 'AC', 11, NULL, NULL),
(283, 49, NULL, NULL, '2015-04-25', 'CONCEPTOS PRODUCCION', 0, 0, 0, 0, 0, 0, 2221, 1, 2221, 2, '2015-04-25 00:35:50', 0, NULL, 'IN', 11, NULL, NULL),
(284, 42, 4, NULL, '2015-04-25', 'COMPRA SEGÚN FACTURA N° 41211', 1000, 5, 5000, 0, 0, 0, 1000, 5, 5000, 2, '2015-04-25 04:50:48', 0, NULL, 'AC', 11, NULL, NULL),
(285, 50, NULL, NULL, '2015-04-25', 'Existencia Inicial ', 0, 0, 0, 0, 0, 0, 200, 250, 50000, 2, '2015-04-25 05:30:36', 0, NULL, 'IN', 11, NULL, NULL),
(286, 51, NULL, NULL, '2015-04-25', 'Existencia Inicial ', 0, 0, 0, 0, 0, 0, 20, 20, 400, 2, '2015-04-25 05:32:47', 0, NULL, 'IN', 11, NULL, NULL),
(287, 51, 5, NULL, '2015-04-25', 'COMPRA SEGÚN FACTURA N° 3126', 1000, 20, 20000, 0, 0, 0, 1020, 20, 20400, 2, '2015-04-25 05:34:13', 0, NULL, 'AC', 11, NULL, NULL),
(288, 49, 5, NULL, '2015-04-25', 'COMPRA SEGÚN FACTURA N° 3126', 100, 1, 100, 0, 0, 0, 2321, 1, 2321, 2, '2015-04-25 05:34:13', 0, NULL, 'IN', 11, NULL, NULL),
(289, 50, 5, NULL, '2015-04-25', 'COMPRA SEGÚN FACTURA N° 3126', 1200, 250, 300000, 0, 0, 0, 1400, 250, 350000, 2, '2015-04-25 05:34:13', 0, NULL, 'IN', 11, NULL, NULL),
(290, 51, 5, NULL, '2015-04-25', 'DEV. COMPRA SEGÚN FACTURA N° 3126', 500, 20, 10000, 0, 0, 0, 500, 20, 10000, 2, '2015-04-25 05:37:53', 0, NULL, NULL, 11, NULL, NULL),
(291, 50, 6, NULL, '2015-04-25', 'COMPRA SEGÚN FACTURA N° 00012', 1, 250, 250, 0, 0, 0, 1401, 250, 350250, 2, '2015-04-25 05:49:46', 0, NULL, 'AC', 11, NULL, NULL),
(292, 49, 6, NULL, '2015-04-25', 'COMPRA SEGÚN FACTURA N° 00012', 100, 1, 100, 0, 0, 0, 2421, 1, 2421, 2, '2015-04-25 05:49:46', 0, NULL, 'AC', 11, NULL, NULL),
(293, 49, 6, NULL, '2015-04-25', 'DEV. COMPRA SEGÚN FACTURA N° 00012', 100, 1, 100, 0, 0, 0, 100, 1, 100, 2, '2015-04-25 05:50:14', 0, NULL, NULL, 11, NULL, NULL),
(294, 42, NULL, NULL, '2015-04-25', 'DEV. VENTA SEGÚN FACTURA N° 0001-000002', 3, 5, 15, 0, 0, 0, 4, 5, 5, 2, '2015-04-25 06:08:02', 0, NULL, 'AC', 0, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `letracliente`
--

DROP TABLE IF EXISTS `letracliente`;
CREATE TABLE IF NOT EXISTS `letracliente` (
  `iLetraClienteId` int(11) NOT NULL AUTO_INCREMENT,
  `iClienteId` int(11) DEFAULT NULL,
  `nNumeroLetra` int(11) DEFAULT NULL,
  `nNumeroUnico` varchar(50) DEFAULT NULL,
  `nRefGirador` varchar(45) DEFAULT NULL,
  `vLugarGiro` varchar(50) DEFAULT NULL,
  `dFechaGiro` date DEFAULT NULL,
  `dFechaVencimiento` date DEFAULT NULL,
  `dFechaProrroga` date DEFAULT NULL,
  `nImporte` decimal(10,2) DEFAULT NULL,
  `vImporteLetras` varchar(45) DEFAULT NULL,
  `iEmpresaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `vEstadoLetra` varchar(50) DEFAULT NULL,
  `cEstadoCodigo` char(5) DEFAULT NULL,
  `dFechaPago` date DEFAULT NULL,
  `fImporteIntereses` float DEFAULT NULL,
  `nPlazoLetra` int(11) DEFAULT NULL,
  `iVentaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iLetraClienteId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `letracliente`
--

INSERT INTO `letracliente` (`iLetraClienteId`, `iClienteId`, `nNumeroLetra`, `nNumeroUnico`, `nRefGirador`, `vLugarGiro`, `dFechaGiro`, `dFechaVencimiento`, `dFechaProrroga`, `nImporte`, `vImporteLetras`, `iEmpresaId`, `dFechaInserta`, `dFechaActualiza`, `iUsuarioInsertaId`, `vEstadoLetra`, `cEstadoCodigo`, `dFechaPago`, `fImporteIntereses`, `nPlazoLetra`, `iVentaId`) VALUES
(1, 6, 1, '', NULL, NULL, '2015-04-22', '2015-05-22', NULL, '4.89', NULL, NULL, '2015-04-22 00:07:07', NULL, 2, 'CANCELADO', 'AC', '2015-04-25', NULL, NULL, 37),
(2, 6, 511545, NULL, NULL, NULL, '2015-04-25', '2015-04-30', NULL, '19.00', NULL, 0, NULL, NULL, 0, 'CANCELADO', 'AC', '2015-04-25', 18, 15, 35),
(3, 6, 15, '', NULL, NULL, '2015-04-25', '2015-04-30', NULL, '0.33', NULL, NULL, '2015-04-25 02:47:32', NULL, 2, 'CANCELADO', 'AC', '2015-04-25', NULL, NULL, 35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `letraproveedor`
--

DROP TABLE IF EXISTS `letraproveedor`;
CREATE TABLE IF NOT EXISTS `letraproveedor` (
  `iletraProveedorId` int(11) NOT NULL AUTO_INCREMENT,
  `iProveedorId` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nNumeroLetra` int(11) DEFAULT NULL,
  `nNumeroUnico` int(11) DEFAULT NULL,
  `dFechaGiro` date DEFAULT NULL,
  `dFechaVencimiento` date DEFAULT NULL,
  `dFechaProrroga` date DEFAULT NULL,
  `nImporte` float DEFAULT NULL,
  `dfechaInserta` datetime DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `vEstadoLetra` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cEstadoCodigo` char(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dFechaPago` date DEFAULT NULL,
  `fImporteIntereses` float DEFAULT NULL,
  `nPlazoLetra` int(11) DEFAULT NULL,
  `iIngresoProductoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iletraProveedorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `letraproveedor`
--

INSERT INTO `letraproveedor` (`iletraProveedorId`, `iProveedorId`, `nNumeroLetra`, `nNumeroUnico`, `dFechaGiro`, `dFechaVencimiento`, `dFechaProrroga`, `nImporte`, `dfechaInserta`, `iUsuarioInsertaId`, `dFechaActualiza`, `iUsuarioActualizaId`, `vEstadoLetra`, `cEstadoCodigo`, `dFechaPago`, `fImporteIntereses`, `nPlazoLetra`, `iIngresoProductoId`) VALUES
(1, '1', 12, 0, '2015-04-25', '2015-04-25', NULL, 2755, '2015-04-25 05:07:08', 2, NULL, 0, NULL, 'AC', NULL, 255, 15, 4),
(2, '1', 0, 0, '2015-04-15', '2015-04-30', NULL, 250, '2015-04-25 05:22:55', 2, NULL, 0, 'DEUDA', 'AC', NULL, 0, 20, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `librodiario`
--

DROP TABLE IF EXISTS `librodiario`;
CREATE TABLE IF NOT EXISTS `librodiario` (
  `iLibroDiarioId` int(11) NOT NULL AUTO_INCREMENT,
  `iCuentasId` int(11) DEFAULT NULL,
  `fMonto` float DEFAULT NULL,
  `vTipoConcepto` varchar(1) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vConceptoGeneral` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iKardexId` int(11) DEFAULT NULL,
  `iIngresoProductoId` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iVentaId` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vNumeroAsiento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cCajaBanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  `iIngresoProductoDevolucionId` int(11) DEFAULT NULL,
  `iVentaDevolucionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iLibroDiarioId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=334 ;

--
-- Volcar la base de datos para la tabla `librodiario`
--

INSERT INTO `librodiario` (`iLibroDiarioId`, `iCuentasId`, `fMonto`, `vTipoConcepto`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `vConceptoGeneral`, `iKardexId`, `iIngresoProductoId`, `iVentaId`, `vNumeroAsiento`, `cCajaBanco`, `iPeriodoId`, `iIngresoProductoDevolucionId`, `iVentaDevolucionId`) VALUES
(189, 57, 25, 'D', 2, '2015-04-16 23:36:20', 0, NULL, 'AC', 'MERCADERIA / Almacen ', 273, '0', NULL, NULL, NULL, 11, NULL, NULL),
(190, 212, 25, 'H', 2, '2015-04-16 23:36:20', 0, NULL, 'AC', 'CAPITAL ', 273, '0', NULL, NULL, NULL, 11, NULL, NULL),
(191, 311, 4.14, 'H', 2, '2015-04-16 23:36:34', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(192, 168, 0.75, 'H', 2, '2015-04-16 23:36:34', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(193, 8, 4.8875, 'D', 2, '2015-04-16 23:36:34', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(194, 8, 4.8875, 'H', 2, '2015-04-16 23:36:34', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(195, 2, 4.8875, 'D', 2, '2015-04-16 23:36:34', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-16 23:36:34 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(196, 212, 0, 'H', 2, '2015-04-21 23:40:27', 0, NULL, 'AC', 'CAPITAL ', 275, '0', NULL, NULL, NULL, 11, NULL, NULL),
(197, 57, 0, 'D', 2, '2015-04-21 23:40:27', 0, NULL, 'AC', 'MERCADERIA / Almacen ', 275, '0', NULL, NULL, NULL, 11, NULL, NULL),
(198, 311, 12.43, 'H', 2, '2015-04-22 00:06:32', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000002', NULL, NULL, '36', 'ASIENTO N1', '0', 11, NULL, NULL),
(199, 168, 2.24, 'H', 2, '2015-04-22 00:06:32', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000002', NULL, NULL, '36', 'ASIENTO N1', '0', 11, NULL, NULL),
(200, 8, 14.6625, 'D', 2, '2015-04-22 00:06:32', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '36', 'ASIENTO N1', '0', 11, NULL, NULL),
(201, 8, 14.6625, 'H', 2, '2015-04-22 00:06:32', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '36', 'ASIENTO N1', '0', 11, NULL, NULL),
(202, 2, 14.6625, 'D', 2, '2015-04-22 00:06:32', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-05-22 Por el pago de la venta de mercaderia de la FACTURA NÃƒâ€šÃ‚Â°: 0001-000002', NULL, NULL, '36', 'ASIENTO N3', '1', 16, NULL, NULL),
(203, 311, 4.14, 'H', 2, '2015-04-22 00:07:07', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000003', NULL, NULL, '37', 'ASIENTO N1', '0', 11, NULL, NULL),
(204, 168, 0.75, 'H', 2, '2015-04-22 00:07:07', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000003', NULL, NULL, '37', 'ASIENTO N1', '0', 11, NULL, NULL),
(205, 8, 4.8875, 'D', 2, '2015-04-22 00:07:07', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '37', 'ASIENTO N1', '0', 11, NULL, NULL),
(206, 8, 4.8875, 'H', 2, '2015-04-22 00:07:07', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '37', 'ASIENTO N1', '0', 11, NULL, NULL),
(207, 10, 4.8875, 'D', 2, '2015-04-22 00:07:07', NULL, NULL, 'AC', 'Clientes/ letras por pagar / 2015-06-21 por el canje de la FACTURA NÂ°: 0001-000003', NULL, NULL, '37', 'ASIENTO N3', '0', 16, NULL, NULL),
(208, 212, 12500, 'H', 2, '2015-04-24 23:41:56', 2, '2015-04-24 23:42:30', 'AC', 'CAPITAL ', 278, '0', NULL, NULL, NULL, 11, NULL, NULL),
(209, 57, 12500, 'D', 2, '2015-04-24 23:41:56', 2, '2015-04-24 23:42:30', 'AC', 'MERCADERIA / Almacen ', 278, '0', NULL, NULL, NULL, 11, NULL, NULL),
(210, 57, 400, 'D', 2, '2015-04-25 00:15:57', 0, NULL, 'AC', 'MERCADERIA / Almacen ', 279, '0', NULL, NULL, NULL, 11, NULL, NULL),
(211, 212, 400, 'H', 2, '2015-04-25 00:15:57', 0, NULL, 'AC', 'CAPITAL ', 279, '0', NULL, NULL, NULL, 11, NULL, NULL),
(212, 212, 400, 'H', 2, '2015-04-25 00:17:47', 0, NULL, 'AC', 'CAPITAL ', 280, '0', NULL, NULL, NULL, 11, NULL, NULL),
(213, 57, 400, 'D', 2, '2015-04-25 00:17:47', 0, NULL, 'AC', 'MERCADERIA / Almacen ', 280, '0', NULL, NULL, NULL, 11, NULL, NULL),
(214, 57, 0, 'D', 2, '2015-04-25 00:29:15', 0, NULL, 'AC', 'MERCADERIA / Almacen ', 281, '0', NULL, NULL, NULL, 11, NULL, NULL),
(215, 212, 0, 'H', 2, '2015-04-25 00:29:15', 0, NULL, 'AC', 'CAPITAL ', 281, '0', NULL, NULL, NULL, 11, NULL, NULL),
(216, 57, 0, 'D', 2, '2015-04-25 00:30:42', 0, NULL, 'AC', 'MERCADERIA / Almacen ', 282, '0', NULL, NULL, NULL, 11, NULL, NULL),
(217, 212, 0, 'H', 2, '2015-04-25 00:30:42', 0, NULL, 'AC', 'CAPITAL ', 282, '0', NULL, NULL, NULL, 11, NULL, NULL),
(218, 57, 2221, 'D', 2, '2015-04-25 00:35:50', 0, NULL, 'AC', 'MERCADERIA / ALmacen ', 283, '0', NULL, NULL, NULL, 11, NULL, NULL),
(219, 311, 4.14, 'H', 2, '2015-04-25 01:36:46', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(220, 168, 0.75, 'H', 2, '2015-04-25 01:36:46', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(221, 8, 4.8875, 'D', 2, '2015-04-25 01:36:46', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(222, 8, 4.8875, 'H', 2, '2015-04-25 01:36:46', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(223, 2, 4.8875, 'D', 2, '2015-04-25 01:36:46', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 01:36:46 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(224, 311, 4.14, 'H', 2, '2015-04-25 01:36:55', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(225, 168, 0.75, 'H', 2, '2015-04-25 01:36:55', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(226, 8, 4.8875, 'D', 2, '2015-04-25 01:36:55', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(227, 8, 4.8875, 'H', 2, '2015-04-25 01:36:55', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(228, 2, 4.8875, 'D', 2, '2015-04-25 01:36:55', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 01:36:55 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(229, 311, 4.14, 'H', 2, '2015-04-25 01:38:14', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(230, 168, 0.75, 'H', 2, '2015-04-25 01:38:14', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(231, 8, 4.8875, 'D', 2, '2015-04-25 01:38:14', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(232, 8, 4.8875, 'H', 2, '2015-04-25 01:38:14', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(233, 2, 4.8875, 'D', 2, '2015-04-25 01:38:14', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 01:38:14 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(234, 311, 4.14, 'H', 2, '2015-04-25 01:52:29', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(235, 168, 0.75, 'H', 2, '2015-04-25 01:52:29', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(236, 8, 4.8875, 'D', 2, '2015-04-25 01:52:29', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(237, 8, 4.8875, 'H', 2, '2015-04-25 01:52:29', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(238, 2, 4.8875, 'D', 2, '2015-04-25 01:52:29', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 01:52:29 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(239, 311, 4.14, 'H', 2, '2015-04-25 01:55:51', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(240, 168, 0.75, 'H', 2, '2015-04-25 01:55:51', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(241, 8, 4.8875, 'D', 2, '2015-04-25 01:55:51', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(242, 8, 4.8875, 'H', 2, '2015-04-25 01:55:51', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(243, 2, 4.8875, 'D', 2, '2015-04-25 01:55:51', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 01:55:51 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(244, 311, 4.14, 'H', 2, '2015-04-25 02:01:57', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(245, 168, 0.75, 'H', 2, '2015-04-25 02:01:57', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(246, 8, 4.8875, 'D', 2, '2015-04-25 02:01:57', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(247, 8, 4.8875, 'H', 2, '2015-04-25 02:01:57', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(248, 2, 4.8875, 'D', 2, '2015-04-25 02:01:57', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 02:01:57 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(249, 311, 12.43, 'H', 2, '2015-04-25 02:02:50', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000002', NULL, NULL, '36', 'ASIENTO N1', '0', 11, NULL, NULL),
(250, 168, 2.24, 'H', 2, '2015-04-25 02:02:50', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000002', NULL, NULL, '36', 'ASIENTO N1', '0', 11, NULL, NULL),
(251, 8, 14.6625, 'D', 2, '2015-04-25 02:02:50', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '36', 'ASIENTO N1', '0', 11, NULL, NULL),
(252, 8, 14.6625, 'H', 2, '2015-04-25 02:02:50', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '36', 'ASIENTO N1', '0', 11, NULL, NULL),
(253, 2, 14.6625, 'D', 2, '2015-04-25 02:02:50', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-30 Por el pago de la venta de mercaderia de la FACTURA NÃƒâ€šÃ‚Â°: 0001-000002', NULL, NULL, '36', 'ASIENTO N3', '1', 11, NULL, NULL),
(254, 311, 4.14, 'H', 2, '2015-04-25 02:08:56', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000003', NULL, NULL, '37', 'ASIENTO N1', '0', 11, NULL, NULL),
(255, 168, 0.75, 'H', 2, '2015-04-25 02:08:56', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000003', NULL, NULL, '37', 'ASIENTO N1', '0', 11, NULL, NULL),
(256, 8, 4.8875, 'D', 2, '2015-04-25 02:08:56', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '37', 'ASIENTO N1', '0', 11, NULL, NULL),
(257, 8, 4.8875, 'H', 2, '2015-04-25 02:08:56', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '37', 'ASIENTO N1', '0', 11, NULL, NULL),
(258, 311, 4.14, 'H', 2, '2015-04-25 02:24:39', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(259, 168, 0.75, 'H', 2, '2015-04-25 02:24:39', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(260, 8, 4.8875, 'D', 2, '2015-04-25 02:24:39', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(261, 8, 4.8875, 'H', 2, '2015-04-25 02:24:39', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(262, 2, 4.8875, 'D', 2, '2015-04-25 02:24:39', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 02:24:39 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(263, 311, 4.14, 'H', 2, '2015-04-25 02:34:06', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(264, 168, 0.75, 'H', 2, '2015-04-25 02:34:06', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(265, 8, 4.8875, 'D', 2, '2015-04-25 02:34:06', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(266, 8, 4.8875, 'H', 2, '2015-04-25 02:34:06', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(267, 2, 4.8875, 'D', 2, '2015-04-25 02:34:06', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 02:34:06 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(268, 311, 4.14, 'H', 2, '2015-04-25 02:37:59', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(269, 168, 0.75, 'H', 2, '2015-04-25 02:37:59', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(270, 8, 4.8875, 'D', 2, '2015-04-25 02:37:59', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(271, 8, 4.8875, 'H', 2, '2015-04-25 02:37:59', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(272, 2, 4.8875, 'D', 2, '2015-04-25 02:37:59', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 02:37:59 Por la venta de la mercaderia de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '1', 11, NULL, NULL),
(273, 311, 4.14, 'H', 2, '2015-04-25 02:47:32', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(274, 168, 0.75, 'H', 2, '2015-04-25 02:47:32', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(275, 8, 4.8875, 'D', 2, '2015-04-25 02:47:32', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(276, 8, 4.8875, 'H', 2, '2015-04-25 02:47:32', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '35', 'ASIENTO N1', '0', 11, NULL, NULL),
(277, 10, 0.325833, 'D', 2, '2015-04-25 02:47:32', NULL, NULL, 'AC', 'Clientes/ letras por pagar / 2015-04-30 por el canje de la FACTURA NÂ°: 0001-000001', NULL, NULL, '35', 'ASIENTO N3', '0', 11, NULL, NULL),
(278, 220, 4347.83, 'D', 2, '2015-04-25 04:50:48', NULL, NULL, 'AC', 'COMPRA/ Mercaderia / NRO de FACTURA: 41211', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(279, 168, 652.17, 'D', 2, '2015-04-25 04:50:48', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 41211', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(280, 199, 5000, 'H', 2, '2015-04-25 04:50:48', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(281, 57, 4347.83, 'D', 2, '2015-04-25 04:50:48', NULL, NULL, 'AC', 'MERCADERIA / Almacen / NRO deFACTURA: 41211', NULL, '4', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(282, 225, 4347.83, 'H', 2, '2015-04-25 04:50:48', NULL, NULL, 'AC', 'VARIACION DE EXISTENCIAS / Mercaderia / NRO deFACTURA: 41211', NULL, '4', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(283, 199, 5000, 'D', 2, '2015-04-25 04:50:48', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ', NULL, '4', NULL, 'ASIENTO 3', '0', 11, NULL, NULL),
(284, 2, 5000, 'H', 2, '2015-04-25 04:50:48', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 04:50:48 Por el pago realizado de la compra de la mercaderia de la FACTURA NÃƒâ€šÃ‚Â°: 41211', NULL, '4', NULL, 'ASIENTO N3', '1', 11, NULL, NULL),
(285, 220, 4347.83, 'D', 2, '2015-04-25 04:51:50', NULL, NULL, 'AC', 'COMPRA/ Mercaderia / NRO de FACTURA: 41211', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(286, 168, 652.17, 'D', 2, '2015-04-25 04:51:50', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 41211', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(287, 199, 5000, 'H', 2, '2015-04-25 04:51:50', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(288, 57, 4347.83, 'D', 2, '2015-04-25 04:51:50', NULL, NULL, 'AC', 'MERCADERIA / Almacen / NRO deFACTURA: 41211', NULL, '4', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(289, 225, 4347.83, 'H', 2, '2015-04-25 04:51:50', NULL, NULL, 'AC', 'VARIACION DE EXISTENCIAS / Mercaderia / NRO deFACTURA: 41211', NULL, '4', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(290, 199, 5000, 'D', 2, '2015-04-25 04:51:50', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ', NULL, '4', NULL, 'ASIENTO 3', '0', 11, NULL, NULL),
(291, 2, 5000, 'H', 2, '2015-04-25 04:51:50', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 04:51:50 Por el pago realizado de la compra de la mercaderia de la FACTURA NÃƒâ€šÃ‚Â°: 41211', NULL, '4', NULL, 'ASIENTO N3', '1', 11, NULL, NULL),
(292, 220, 4347.83, 'D', 2, '2015-04-25 05:07:09', NULL, NULL, 'AC', 'COMPRA/ Mercaderia / NRO de FACTURA: 41211', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(293, 168, 652.17, 'D', 2, '2015-04-25 05:07:09', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 41211', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(294, 199, 5000, 'H', 2, '2015-04-25 05:07:09', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(295, 57, 4347.83, 'D', 2, '2015-04-25 05:07:09', NULL, NULL, 'AC', 'MERCADERIA / Almacen / NRO deFACTURA: 41211', NULL, '4', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(296, 225, 4347.83, 'H', 2, '2015-04-25 05:07:09', NULL, NULL, 'AC', 'VARIACION DE EXISTENCIAS / Mercaderia / NRO deFACTURA: 41211', NULL, '4', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(297, 199, 5000, 'D', 2, '2015-04-25 05:07:09', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ', NULL, '4', NULL, 'ASIENTO 3', '0', 11, NULL, NULL),
(298, 2, 5000, 'H', 2, '2015-04-25 05:07:09', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 05:07:09 Por el pago realizado de la compra de la mercaderia de la FACTURA NÃƒâ€šÃ‚Â°: 41211', NULL, '4', NULL, 'ASIENTO N3', '1', 11, NULL, NULL),
(299, 220, 4347.83, 'D', 2, '2015-04-25 05:22:55', NULL, NULL, 'AC', 'COMPRA/ Mercaderia / NRO de FACTURA: 41211', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(300, 168, 652.17, 'D', 2, '2015-04-25 05:22:55', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 41211', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(301, 199, 5000, 'H', 2, '2015-04-25 05:22:55', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar', NULL, '4', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(302, 57, 4347.83, 'D', 2, '2015-04-25 05:22:55', NULL, NULL, 'AC', 'MERCADERIA / Almacen / NRO deFACTURA: 41211', NULL, '4', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(303, 225, 4347.83, 'H', 2, '2015-04-25 05:22:55', NULL, NULL, 'AC', 'VARIACION DE EXISTENCIAS / Mercaderia / NRO deFACTURA: 41211', NULL, '4', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(304, 199, 5000, 'D', 2, '2015-04-25 05:22:55', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ', NULL, '4', NULL, 'ASIENTO 3', '0', 11, NULL, NULL),
(305, 2, 5000, 'H', 2, '2015-04-25 05:22:55', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 05:22:55 Por el pago realizado de la compra de la mercaderia de la FACTURA NÃƒâ€šÃ‚Â°: 41211', NULL, '4', NULL, 'ASIENTO N3', '1', 11, NULL, NULL),
(306, 57, 50000, 'D', 2, '2015-04-25 05:30:36', 0, NULL, 'AC', 'MERCADERIA / Almacen ', 285, '0', NULL, NULL, NULL, 11, NULL, NULL),
(307, 212, 50000, 'H', 2, '2015-04-25 05:30:36', 0, NULL, 'AC', 'CAPITAL ', 285, '0', NULL, NULL, NULL, 11, NULL, NULL),
(308, 212, 400, 'H', 2, '2015-04-25 05:32:47', 0, NULL, 'AC', 'CAPITAL ', 286, '0', NULL, NULL, NULL, 11, NULL, NULL),
(309, 57, 400, 'D', 2, '2015-04-25 05:32:47', 0, NULL, 'AC', 'MERCADERIA / Almacen ', 286, '0', NULL, NULL, NULL, 11, NULL, NULL),
(310, 220, 278348, 'D', 2, '2015-04-25 05:34:13', NULL, NULL, 'AC', 'COMPRA/ Mercaderia / NRO de FACTURA: 3126', NULL, '5', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(311, 168, 41752.2, 'D', 2, '2015-04-25 05:34:13', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 3126', NULL, '5', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(312, 199, 320100, 'H', 2, '2015-04-25 05:34:13', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar', NULL, '5', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(313, 57, 278348, 'D', 2, '2015-04-25 05:34:13', NULL, NULL, 'AC', 'MERCADERIA / Almacen / NRO deFACTURA: 3126', NULL, '5', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(314, 225, 278348, 'H', 2, '2015-04-25 05:34:13', NULL, NULL, 'AC', 'VARIACION DE EXISTENCIAS / Mercaderia / NRO deFACTURA: 3126', NULL, '5', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(315, 199, 320100, 'D', 2, '2015-04-25 05:34:13', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ', NULL, '5', NULL, 'ASIENTO 3', '0', 11, NULL, NULL),
(316, 2, 320100, 'H', 2, '2015-04-25 05:34:13', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 05:34:13 Por el pago realizado de la compra de la mercaderia de la FACTURA NÃƒâ€šÃ‚Â°: 3126', NULL, '5', NULL, 'ASIENTO N3', '1', 11, NULL, NULL),
(317, 220, 304.35, 'D', 2, '2015-04-25 05:49:46', NULL, NULL, 'AC', 'COMPRA/ Mercaderia / NRO de FACTURA: 00012', NULL, '6', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(318, 168, 45.65, 'D', 2, '2015-04-25 05:49:46', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 00012', NULL, '6', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(319, 199, 350, 'H', 2, '2015-04-25 05:49:46', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar', NULL, '6', NULL, 'ASIENTO N1', '0', 11, NULL, NULL),
(320, 57, 304.35, 'D', 2, '2015-04-25 05:49:46', NULL, NULL, 'AC', 'MERCADERIA / Almacen / NRO deFACTURA: 00012', NULL, '6', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(321, 225, 304.35, 'H', 2, '2015-04-25 05:49:46', NULL, NULL, 'AC', 'VARIACION DE EXISTENCIAS / Mercaderia / NRO deFACTURA: 00012', NULL, '6', NULL, 'ASIENTO N2', '0', 11, NULL, NULL),
(322, 199, 350, 'D', 2, '2015-04-25 05:49:46', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ', NULL, '6', NULL, 'ASIENTO 3', '0', 11, NULL, NULL),
(323, 2, 350, 'H', 2, '2015-04-25 05:49:46', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-04-25 05:49:46 Por el pago realizado de la compra de la mercaderia de la FACTURA NÃƒâ€šÃ‚Â°: 00012', NULL, '6', NULL, 'ASIENTO N3', '1', 11, NULL, NULL),
(324, 220, 86.96, 'H', 2, '2015-04-25 06:14:03', NULL, NULL, 'AC', 'POR LA DEVOLUCION/ Mercaderia / NRO de NOTA DEBITO: 00012 NRO de Nota Debito:ND-0112', NULL, NULL, NULL, 'ASIENTO N1', '0', 11, 2, NULL),
(325, 168, 13.04, 'H', 2, '2015-04-25 06:14:03', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de NOTA DEBITO: 00012', NULL, NULL, NULL, 'ASIENTO N1', '0', 11, 2, NULL),
(326, 199, 100, 'D', 2, '2015-04-25 06:14:03', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, NULL, 'ASIENTO N1', '0', 11, 2, NULL),
(327, 57, 86.96, 'H', 2, '2015-04-25 06:14:03', NULL, NULL, 'AC', 'MERCADERIA / Almacen / NRO deNOTA DEBITO: 00012', NULL, NULL, NULL, 'ASIENTO N2', '0', 11, 2, NULL),
(328, 225, 86.96, 'D', 2, '2015-04-25 06:14:03', NULL, NULL, 'AC', 'VARIACION DE EXISTENCIAS / Mercaderia / NRO deNOTA DEBITO: 00012', NULL, NULL, NULL, 'ASIENTO N2', '0', 11, 2, NULL),
(329, 316, NULL, 'H', 2, '2015-04-25 06:18:48', NULL, NULL, 'AC', NULL, NULL, NULL, NULL, 'ASIENTO N1', '0', 11, NULL, 2),
(330, 168, NULL, 'H', 2, '2015-04-25 06:18:48', NULL, NULL, 'AC', NULL, NULL, NULL, NULL, 'ASIENTO N1', '0', 11, NULL, 2),
(331, 8, NULL, 'D', 2, '2015-04-25 06:18:48', NULL, NULL, 'AC', 'CLIENTES / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, NULL, 'ASIENTO N1', '0', 11, NULL, 2),
(332, 57, NULL, 'H', 2, '2015-04-25 06:18:48', NULL, NULL, 'AC', NULL, NULL, NULL, NULL, 'ASIENTO N2', '0', 11, NULL, 2),
(333, 305, NULL, 'D', 2, '2015-04-25 06:18:48', NULL, NULL, 'AC', NULL, NULL, NULL, NULL, 'ASIENTO N2', '0', 11, NULL, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libromayor`
--

DROP TABLE IF EXISTS `libromayor`;
CREATE TABLE IF NOT EXISTS `libromayor` (
  `iLibroMayorId` int(11) NOT NULL AUTO_INCREMENT,
  `iCuentasId` int(11) DEFAULT NULL,
  `fMontoDebe` float DEFAULT NULL,
  `fMontoHaber` float DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iLibroMayorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `libromayor`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `idMenu` int(11) NOT NULL AUTO_INCREMENT,
  `vMenu` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vCodigo` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cEstadoCodigo` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idMenu`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcar la base de datos para la tabla `menu`
--

INSERT INTO `menu` (`idMenu`, `vMenu`, `vCodigo`, `cEstadoCodigo`) VALUES
(1, 'Inventario', '10', 'AC'),
(2, 'Cliente', '20', 'AC'),
(3, 'Proveedor', '30', 'AC'),
(4, 'Compra', '40', 'AC'),
(5, 'Venta', '50', 'AC'),
(6, 'Contabilidad', '60', 'AC'),
(7, 'Estadisticas', '70', 'AC'),
(8, 'Admin', '80', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menuaccion`
--

DROP TABLE IF EXISTS `menuaccion`;
CREATE TABLE IF NOT EXISTS `menuaccion` (
  `iMenuAccionId` int(11) NOT NULL AUTO_INCREMENT,
  `idmenuOpciones` int(11) DEFAULT NULL,
  `vAccion` varchar(45) DEFAULT NULL,
  `vCodigo` varchar(4) DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  PRIMARY KEY (`iMenuAccionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=469 ;

--
-- Volcar la base de datos para la tabla `menuaccion`
--

INSERT INTO `menuaccion` (`iMenuAccionId`, `idmenuOpciones`, `vAccion`, `vCodigo`, `cEstadoCodigo`) VALUES
(258, 1, 'Nuevo', '1111', 'AC'),
(259, 1, 'Editar', '1112', 'AC'),
(260, 1, 'Buscar', '1113', 'AC'),
(261, 1, 'Eliminar', '1114', 'AC'),
(262, 1, 'Exportar', '1115', 'AC'),
(263, 2, 'Nuevo', '1121', 'AC'),
(264, 2, 'Editar', '1122', 'AC'),
(265, 2, 'Buscar', '1123', 'AC'),
(266, 2, 'Eliminar', '1124', 'AC'),
(267, 2, 'Exportar', '1125', 'AC'),
(268, 3, 'Nuevo', '1131', 'AC'),
(269, 3, 'Editar', '1132', 'AC'),
(270, 3, 'Buscar', '1133', 'AC'),
(271, 3, 'Eliminar', '1134', 'AC'),
(272, 3, 'Exportar', '1135', 'AC'),
(273, 4, 'Nuevo', '1141', 'AC'),
(274, 4, 'Editar', '1142', 'AC'),
(275, 4, 'Buscar', '1143', 'AC'),
(276, 4, 'Eliminar', '1144', 'AC'),
(277, 4, 'Exportar', '1145', 'AC'),
(278, 5, 'Nuevo', '1151', 'AC'),
(279, 5, 'Editar', '1152', 'AC'),
(280, 5, 'Buscar', '1153', 'AC'),
(281, 5, 'Eliminar', '1154', 'AC'),
(282, 5, 'Exportar', '1155', 'AC'),
(283, 6, 'Nuevo', '1161', 'AC'),
(284, 6, 'Editar', '1162', 'AC'),
(285, 6, 'Buscar', '1163', 'AC'),
(286, 6, 'Eliminar', '1164', 'AC'),
(287, 6, 'Exportar', '1165', 'AC'),
(288, 7, 'Nuevo', '1171', 'AC'),
(289, 7, 'Editar', '1172', 'AC'),
(290, 7, 'Buscar', '1173', 'AC'),
(291, 7, 'Eliminar', '1174', 'AC'),
(292, 7, 'Exportar', '1175', 'AC'),
(293, 8, 'Nuevo', '1181', 'AC'),
(294, 8, 'Editar', '1182', 'AC'),
(295, 8, 'Buscar', '1183', 'AC'),
(296, 8, 'Eliminar', '1184', 'AC'),
(297, 8, 'Exportar', '1185', 'AC'),
(298, 9, 'Nuevo', '2111', 'AC'),
(299, 9, 'Editar', '2112', 'AC'),
(300, 9, 'Buscar', '2113', 'AC'),
(301, 9, 'Eliminar', '2114', 'AC'),
(302, 9, 'Exportar', '2115', 'AC'),
(303, 10, 'Nuevo', '2121', 'AC'),
(304, 10, 'Editar', '2122', 'AC'),
(305, 10, 'Buscar', '2123', 'AC'),
(306, 10, 'Eliminar', '2124', 'AC'),
(307, 10, 'Exportar', '2125', 'AC'),
(308, 11, 'Nuevo', '2131', 'AC'),
(309, 11, 'Editar', '2132', 'AC'),
(310, 11, 'Buscar', '2133', 'AC'),
(311, 11, 'Eliminar', '2134', 'AC'),
(312, 11, 'Exportar', '2135', 'AC'),
(313, 12, 'Nuevo', '2141', 'AC'),
(314, 12, 'Editar', '2142', 'AC'),
(315, 12, 'Buscar', '2143', 'AC'),
(316, 12, 'Eliminar', '2144', 'AC'),
(317, 12, 'Exportar', '2145', 'AC'),
(318, 13, 'Nuevo', '3111', 'AC'),
(319, 13, 'Editar', '3112', 'AC'),
(320, 13, 'Buscar', '3113', 'AC'),
(321, 13, 'Eliminar', '3114', 'AC'),
(322, 13, 'Exportar', '3115', 'AC'),
(323, 14, 'Nuevo', '3121', 'AC'),
(324, 14, 'Editar', '3122', 'AC'),
(325, 14, 'Buscar', '3123', 'AC'),
(326, 14, 'Eliminar', '3124', 'AC'),
(327, 14, 'Exportar', '3125', 'AC'),
(328, 15, 'Nuevo', '3131', 'AC'),
(329, 15, 'Editar', '3132', 'AC'),
(330, 15, 'Buscar', '3133', 'AC'),
(331, 15, 'Eliminar', '3134', 'AC'),
(332, 15, 'Exportar', '3135', 'AC'),
(333, 16, 'Nuevo', '4111', 'AC'),
(334, 16, 'Editar', '4112', 'AC'),
(335, 16, 'Buscar', '4113', 'AC'),
(336, 16, 'Exportar', '4115', 'AC'),
(337, 17, 'Nuevo', '4121', 'AC'),
(338, 17, 'Editar', '4122', 'AC'),
(339, 17, 'Buscar', '4123', 'AC'),
(340, 17, 'Exportar', '4125', 'AC'),
(341, 18, 'Nuevo', '5111', 'AC'),
(342, 18, 'Editar', '5112', 'AC'),
(343, 18, 'Buscar', '5113', 'AC'),
(344, 18, 'Exportar', '5115', 'AC'),
(345, 19, 'Nuevo', '5121', 'AC'),
(346, 19, 'Editar', '5122', 'AC'),
(347, 19, 'Buscar', '5123', 'AC'),
(348, 19, 'Exportar', '5125', 'AC'),
(349, 20, 'Editar', '6112', 'AC'),
(350, 20, 'Buscar', '6113', 'AC'),
(351, 20, 'Exportar', '6115', 'AC'),
(352, 21, 'Editar', '6122', 'AC'),
(353, 21, 'Buscar', '6123', 'AC'),
(354, 21, 'Exportar', '6125', 'AC'),
(355, 22, 'Editar', '6132', 'AC'),
(356, 22, 'Buscar', '6133', 'AC'),
(357, 22, 'Exportar', '6135', 'AC'),
(358, 23, 'Editar', '6142', 'AC'),
(359, 23, 'Buscar', '6143', 'AC'),
(360, 23, 'Exportar', '6145', 'AC'),
(361, 24, 'Editar', '6212', 'AC'),
(362, 24, 'Buscar', '6213', 'AC'),
(363, 24, 'Exportar', '6215', 'AC'),
(364, 25, 'Editar', '6222', 'AC'),
(365, 25, 'Buscar', '6223', 'AC'),
(366, 25, 'Exportar', '6225', 'AC'),
(367, 26, 'Editar', '6232', 'AC'),
(368, 26, 'Buscar', '6233', 'AC'),
(369, 26, 'Exportar', '6235', 'AC'),
(370, 27, 'Editar', '6242', 'AC'),
(371, 27, 'Buscar', '6243', 'AC'),
(372, 27, 'Exportar', '6245', 'AC'),
(373, 28, 'Editar', '6312', 'AC'),
(374, 28, 'Buscar', '6313', 'AC'),
(375, 28, 'Exportar', '6315', 'AC'),
(376, 29, 'Editar', '6322', 'AC'),
(377, 29, 'Buscar', '6323', 'AC'),
(378, 29, 'Exportar', '6325', 'AC'),
(379, 30, 'Editar', '6332', 'AC'),
(380, 30, 'Buscar', '6333', 'AC'),
(381, 30, 'Exportar', '6335', 'AC'),
(382, 31, 'Editar', '6342', 'AC'),
(383, 31, 'Buscar', '6343', 'AC'),
(384, 31, 'Exportar', '6345', 'AC'),
(385, 32, 'Nuevo', '6411', 'AC'),
(386, 32, 'Editar', '6412', 'AC'),
(387, 32, 'Buscar', '6413', 'AC'),
(388, 32, 'Eliminar', '6414', 'AC'),
(389, 32, 'Exportar', '6415', 'AC'),
(390, 33, 'Nuevo', '6421', 'AC'),
(391, 33, 'Editar', '6422', 'AC'),
(392, 33, 'Buscar', '6423', 'AC'),
(393, 33, 'Eliminar', '6424', 'AC'),
(394, 33, 'Exportar', '6425', 'AC'),
(395, 34, 'Nuevo', '6511', 'AC'),
(396, 34, 'Editar', '6512', 'AC'),
(397, 34, 'Buscar', '6513', 'AC'),
(398, 34, 'Eliminar', '6514', 'AC'),
(399, 35, 'Nuevo', '6521', 'AC'),
(400, 35, 'Editar', '6522', 'AC'),
(401, 35, 'Buscar', '6523', 'AC'),
(402, 35, 'Eliminar', '6524', 'AC'),
(403, 35, 'Exportar', '6525', 'AC'),
(404, 36, 'Nuevo', '6611', 'AC'),
(405, 36, 'Editar', '6612', 'AC'),
(406, 36, 'Buscar', '6613', 'AC'),
(407, 36, 'Eliminar', '6614', 'AC'),
(408, 36, 'Exportar', '6615', 'AC'),
(409, 37, 'Nuevo', '6621', 'AC'),
(410, 37, 'Editar', '6622', 'AC'),
(411, 37, 'Buscar', '6623', 'AC'),
(412, 37, 'Eliminar', '6624', 'AC'),
(413, 37, 'Exportar', '6625', 'AC'),
(414, 38, 'Nuevo', '6631', 'AC'),
(415, 38, 'Editar', '6632', 'AC'),
(416, 38, 'Buscar', '6633', 'AC'),
(417, 38, 'Eliminar', '6634', 'AC'),
(418, 38, 'Exportar', '6635', 'AC'),
(419, 39, 'Graficar', '7111', 'AC'),
(420, 40, 'Graficar', '7121', 'AC'),
(421, 41, 'Graficar', '7131', 'AC'),
(422, 42, 'Graficar', '7141', 'AC'),
(423, 43, 'Graficar', '7151', 'AC'),
(424, 44, 'Nuevo', '8111', 'AC'),
(425, 44, 'Editar', '8112', 'AC'),
(426, 44, 'Buscar', '8113', 'AC'),
(427, 44, 'Eliminar', '8114', 'AC'),
(428, 45, 'Nuevo', '8121', 'AC'),
(429, 45, 'Editar', '8122', 'AC'),
(430, 45, 'Buscar', '8123', 'AC'),
(431, 45, 'Eliminar', '8124', 'AC'),
(432, 46, 'Nuevo', '8131', 'AC'),
(433, 46, 'Editar', '8132', 'AC'),
(434, 46, 'Buscar', '8133', 'AC'),
(435, 46, 'Eliminar', '8134', 'AC'),
(436, 47, 'Nuevo', '8211', 'AC'),
(437, 47, 'Editar', '8212', 'AC'),
(438, 47, 'Buscar', '8213', 'AC'),
(439, 47, 'Eliminar', '8214', 'AC'),
(440, 48, 'Nuevo', '8221', 'AC'),
(441, 48, 'Editar', '8222', 'AC'),
(442, 48, 'Buscar', '8223', 'AC'),
(443, 48, 'Eliminar', '8224', 'AC'),
(444, 49, 'Nuevo', '8311', 'AC'),
(445, 49, 'Editar', '8312', 'AC'),
(446, 49, 'Buscar', '8313', 'AC'),
(447, 49, 'Eliminar', '8314', 'AC'),
(448, 52, 'Nuevo', '8511', 'AC'),
(449, 52, 'Editar', '8512', 'AC'),
(450, 52, 'Buscar', '8513', 'AC'),
(451, 52, 'Eliminar', '8514', 'AC'),
(452, 53, 'Nuevo', '8521', 'AC'),
(453, 53, 'Editar', '8522', 'AC'),
(454, 53, 'Buscar', '8523', 'AC'),
(455, 53, 'Eliminar', '8524', 'AC'),
(456, 54, 'Nuevo', '8531', 'AC'),
(457, 54, 'Editar', '8532', 'AC'),
(458, 54, 'Buscar', '8533', 'AC'),
(459, 54, 'Eliminar', '8534', 'AC'),
(460, 55, 'Nuevo', '8541', 'AC'),
(461, 55, 'Editar', '8542', 'AC'),
(462, 55, 'Buscar', '8543', 'AC'),
(463, 55, 'Eliminar', '8544', 'IN'),
(464, 50, 'Nuevo', '8321', 'AC'),
(465, 50, 'Editar', '8322', 'AC'),
(466, 50, 'Buscar', '8323', 'AC'),
(467, 50, 'Eliminar', '8324', 'AC'),
(468, 50, 'Exportar', '8325', 'IN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menuopciones`
--

DROP TABLE IF EXISTS `menuopciones`;
CREATE TABLE IF NOT EXISTS `menuopciones` (
  `idmenuOpciones` int(11) NOT NULL AUTO_INCREMENT,
  `idMenutitulo` int(11) DEFAULT NULL,
  `vOpciones` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vCodigo` varchar(4) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idmenuOpciones`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=56 ;

--
-- Volcar la base de datos para la tabla `menuopciones`
--

INSERT INTO `menuopciones` (`idmenuOpciones`, `idMenutitulo`, `vOpciones`, `vCodigo`, `cEstadoCodigo`) VALUES
(1, 1, 'Categoria', '111', 'AC'),
(2, 1, 'SubCategoria', '112', 'AC'),
(3, 1, 'Producto', '113', 'AC'),
(4, 1, 'Materia Prima', '114', 'AC'),
(5, 1, 'Suministro y Repuestos', '115', 'AC'),
(6, 1, 'Envases y Embalajes', '116', 'AC'),
(7, 1, 'Servicios', '117', 'AC'),
(8, 1, 'Gestion de Produccion', '118', 'AC'),
(9, 2, 'Clasificacion Cliente', '211', 'AC'),
(10, 2, 'Cliente', '212', 'AC'),
(11, 2, 'Estado Cuenta Cliente', '213', 'AC'),
(12, 2, 'Estado Cuenta de Letras', '214', 'AC'),
(13, 3, 'Proveedor', '311', 'AC'),
(14, 3, 'Estado Cuenta Proveedor', '312', 'AC'),
(15, 3, 'Estado Cuenta de Letras', '313', 'AC'),
(16, 4, 'Compras', '411', 'AC'),
(17, 4, 'Devolucion de Compras', '412', 'AC'),
(18, 5, 'Ventas', '511', 'AC'),
(19, 5, 'Devolucion Ventas', '512', 'AC'),
(20, 6, 'Ventas', '611', 'AC'),
(21, 6, 'Devolucion de Ventas', '612', 'AC'),
(22, 6, 'Estado Cuenta Cliente', '613', 'AC'),
(23, 6, 'Estado Cuenta de Letras', '614', 'AC'),
(24, 7, 'Compras', '621', 'AC'),
(25, 7, 'Devolucion de Compras', '622', 'AC'),
(26, 7, 'Estado Cuenta Proveedor', '623', 'AC'),
(27, 7, 'Estado Cuenta de Letras', '624', 'AC'),
(28, 8, 'Productos', '631', 'AC'),
(29, 8, 'Materias Primas', '632', 'AC'),
(30, 8, 'Suministro y Repuestos', '633', 'AC'),
(31, 8, 'Embases y Embalajes', '634', 'AC'),
(32, 9, 'Ingreso Cuentas', '641', 'AC'),
(33, 9, 'Caja y Banco', '642', 'AC'),
(34, 10, 'Parametros Planilla', '651', 'AC'),
(35, 10, 'Registro Planilla', '652', 'AC'),
(36, 11, 'Libro diario', '661', 'AC'),
(37, 11, 'Plan Contable', '662', 'IN'),
(38, 11, 'Balance General', '663', 'IN'),
(39, 12, 'Grafico General', '711', 'AC'),
(40, 12, 'Compras', '712', 'AC'),
(41, 12, 'Ventas', '713', 'AC'),
(42, 12, 'Clientes', '714', 'IN'),
(43, 12, 'Proveedores', '715', 'IN'),
(44, 13, 'Mant. de Empresas', '811', 'AC'),
(45, 13, 'Mant. de Sucursal', '812', 'AC'),
(46, 13, 'Mant. de Area', '813', 'AC'),
(47, 14, 'Mant. de Ocupacion', '821', 'AC'),
(48, 14, 'Mant. de Personal', '822', 'AC'),
(49, 15, 'Mant. de Perfil', '831', 'AC'),
(50, 15, 'Mant. de Usuario', '832', 'AC'),
(51, 16, 'Guardar', '841', 'AC'),
(52, 17, 'Ejercicios fiscales', '851', 'AC'),
(53, 17, 'Periodos', '852', 'AC'),
(54, 17, 'Configurcion General', '853', 'AC'),
(55, 17, 'Impuestos', '854', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menutitulo`
--

DROP TABLE IF EXISTS `menutitulo`;
CREATE TABLE IF NOT EXISTS `menutitulo` (
  `idmenuTitulo` int(11) NOT NULL,
  `idMenu` int(11) DEFAULT NULL,
  `vMenuTitulo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vCodigo` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idmenuTitulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcar la base de datos para la tabla `menutitulo`
--

INSERT INTO `menutitulo` (`idmenuTitulo`, `idMenu`, `vMenuTitulo`, `vCodigo`, `cEstadoCodigo`) VALUES
(1, 1, 'OPCIONES', '11', 'AC'),
(2, 2, 'OPCIONES', '21', 'AC'),
(3, 3, 'OPCIONES', '31', 'AC'),
(4, 4, 'OPCIONES', '41', 'AC'),
(5, 5, 'OPCIONES', '51', 'AC'),
(6, 6, 'CLIENTES', '61', 'AC'),
(7, 6, 'PROVEEDORES', '62', 'AC'),
(8, 6, 'EXISTENCIAS', '63', 'AC'),
(9, 6, 'TESORERIA', '64', 'AC'),
(10, 6, 'PLANILLA', '65', 'AC'),
(11, 6, 'PLAN CONTABLE', '66', 'AC'),
(12, 7, 'OPCIONES', '71', 'AC'),
(13, 8, 'EMPRESA SUCURSAL', '81', 'AC'),
(14, 8, 'PERSONAL', '82', 'AC'),
(15, 8, 'USUARIOS', '83', 'AC'),
(16, 8, 'PERMISOS', '84', 'AC'),
(17, 8, 'CONFIGURACION', '85', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mes`
--

DROP TABLE IF EXISTS `mes`;
CREATE TABLE IF NOT EXISTS `mes` (
  `iMesId` int(11) NOT NULL AUTO_INCREMENT,
  `vMesDescripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`iMesId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `mes`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moneda`
--

DROP TABLE IF EXISTS `moneda`;
CREATE TABLE IF NOT EXISTS `moneda` (
  `iMonedaId` int(11) NOT NULL AUTO_INCREMENT,
  `cModenaCodigo` varchar(3) NOT NULL,
  `vMonedaDescripcion` varchar(45) NOT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  PRIMARY KEY (`iMonedaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `moneda`
--

INSERT INTO `moneda` (`iMonedaId`, `cModenaCodigo`, `vMonedaDescripcion`, `cEstadoCodigo`) VALUES
(1, 'S/.', 'SOLES', 'AC'),
(2, '$', 'DOLARES', 'AC'),
(3, 'E', 'EUROS', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ocupacion`
--

DROP TABLE IF EXISTS `ocupacion`;
CREATE TABLE IF NOT EXISTS `ocupacion` (
  `iOcupacionId` int(11) NOT NULL AUTO_INCREMENT,
  `cOcupacionCodigo` char(7) DEFAULT NULL,
  `vOcupacionDescripcion` varchar(45) DEFAULT NULL,
  `iUsuarioInserta` int(11) DEFAULT NULL,
  `iUsuarioModifica` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  PRIMARY KEY (`iOcupacionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `ocupacion`
--

INSERT INTO `ocupacion` (`iOcupacionId`, `cOcupacionCodigo`, `vOcupacionDescripcion`, `iUsuarioInserta`, `iUsuarioModifica`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(1, 'OC00001', 'ING. DE SISTEMAS', 0, 0, '2015-01-26 22:26:28', NULL, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE IF NOT EXISTS `perfil` (
  `iPerfilId` int(11) NOT NULL AUTO_INCREMENT,
  `cPerfilCodigo` char(7) NOT NULL,
  `vPerfilDescripcion` varchar(45) NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `cInventario` char(1) DEFAULT NULL,
  `cProveedor` char(1) DEFAULT NULL,
  `cClientes` char(1) DEFAULT NULL,
  `cCompras` char(1) DEFAULT NULL,
  `cVentas` char(1) DEFAULT NULL,
  `cEstadisticas` char(1) DEFAULT NULL,
  `cMantenimiento` char(1) DEFAULT NULL,
  PRIMARY KEY (`iPerfilId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`iPerfilId`, `cPerfilCodigo`, `vPerfilDescripcion`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `cInventario`, `cProveedor`, `cClientes`, `cCompras`, `cVentas`, `cEstadisticas`, `cMantenimiento`) VALUES
(2, 'PER02', 'SISTEMAS', 12, 18, '2013-02-02 00:00:00', '2013-02-15 00:00:00', 'AC', '1', '1', '1', '1', '1', '1', '1'),
(3, 'PER03', 'ADMINISTRADOR', 0, NULL, NULL, '2013-02-15 00:00:00', 'AC', '1', '1', '1', '1', '0', '0', '1'),
(4, 'PER04', 'CONTADORES', 0, NULL, NULL, '2013-02-14 00:00:00', 'AC', '0', '1', '1', '0', '1', '0', '1'),
(5, 'PER05', 'CLIENTE EXTERNO', 0, NULL, NULL, '2013-01-04 00:00:00', 'AC', '0', '0', '1', '0', '0', '0', '1'),
(6, 'PE00006', 'LO', 0, 0, '2015-01-01 00:00:00', NULL, 'IN', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

DROP TABLE IF EXISTS `periodo`;
CREATE TABLE IF NOT EXISTS `periodo` (
  `iPeriodoId` int(11) NOT NULL AUTO_INCREMENT,
  `vCodigoPeriodo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vNombrePeriodo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dFechaInicio` date DEFAULT NULL,
  `dFechaFin` date DEFAULT NULL,
  `iUsuarioInserta` int(11) DEFAULT NULL,
  `iUsuarioActualiza` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cCodigoEstado` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iEjercicioFiscalId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iPeriodoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=19 ;

--
-- Volcar la base de datos para la tabla `periodo`
--

INSERT INTO `periodo` (`iPeriodoId`, `vCodigoPeriodo`, `vNombrePeriodo`, `dFechaInicio`, `dFechaFin`, `iUsuarioInserta`, `iUsuarioActualiza`, `dFechaInserta`, `dFechaActualiza`, `cCodigoEstado`, `iEjercicioFiscalId`) VALUES
(7, '1/2015', 'X 1/2015', '2015-01-01', '2015-01-31', 0, 0, NULL, NULL, 'ABIERTO', 6),
(8, '10/2015', 'X 10/2015', '2015-10-01', '2015-10-31', 0, 0, NULL, NULL, 'ABIERTO', 6),
(9, '9/2015', 'X 9/2015', '2015-09-01', '2015-09-30', 0, 0, NULL, NULL, 'ABIERTO', 6),
(10, '11/2015', 'X 11/2015', '2015-11-01', '2015-11-30', 0, 0, NULL, NULL, 'ABIERTO', 6),
(11, '4/2015', 'X 4/2015', '2015-04-01', '2015-04-30', 0, 0, NULL, NULL, 'ABIERTO', 6),
(12, '6/2015', 'X 6/2015', '2015-06-01', '2015-06-30', 0, 0, NULL, NULL, 'ABIERTO', 6),
(13, '3/2015', 'X 3/2015', '2015-03-01', '2015-03-31', 0, 0, NULL, NULL, 'ABIERTO', 6),
(14, '7/2015', 'X 7/2015', '2015-07-01', '2015-07-31', 0, 0, NULL, NULL, 'ABIERTO', 6),
(15, '8/2015', 'X 8/2015', '2015-08-01', '2015-08-31', 0, 0, NULL, NULL, 'ABIERTO', 6),
(16, '5/2015', 'X 5/2015', '2015-05-01', '2015-05-31', 0, 0, NULL, NULL, 'ABIERTO', 6),
(17, '12/2015', 'X 12/2015', '2015-12-01', '2015-12-31', 0, 0, NULL, NULL, 'ABIERTO', 6),
(18, '2/2015', 'X 2/2015', '2015-02-01', '2015-02-28', 0, 0, NULL, NULL, 'ABIERTO', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

DROP TABLE IF EXISTS `permisos`;
CREATE TABLE IF NOT EXISTS `permisos` (
  `idpermisos` int(11) NOT NULL AUTO_INCREMENT,
  `iUsuarioId` int(11) DEFAULT NULL,
  `vCodigoMenu` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cEstado` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idpermisos`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=14024 ;

--
-- Volcar la base de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`idpermisos`, `iUsuarioId`, `vCodigoMenu`, `cEstado`) VALUES
(204, 12, '20', 'AC'),
(205, 12, '21', 'AC'),
(206, 12, '211', 'AC'),
(207, 12, '212', 'AC'),
(208, 12, '213', 'AC'),
(465, 10, '11', 'AC'),
(466, 10, '111', 'AC'),
(467, 10, '111', 'AC'),
(468, 10, '111', 'AC'),
(469, 10, '111', 'AC'),
(470, 10, '112', 'AC'),
(471, 10, '113', 'AC'),
(472, 10, '114', 'AC'),
(473, 10, '115', 'AC'),
(474, 10, '116', 'AC'),
(475, 10, '20', 'AC'),
(476, 10, '21', 'AC'),
(477, 10, '211', 'AC'),
(478, 10, '212', 'AC'),
(479, 10, '213', 'AC'),
(11888, 23, '10', 'AC'),
(11889, 23, '11', 'AC'),
(11890, 23, '111', 'AC'),
(11891, 23, '1111', 'AC'),
(11892, 23, '1112', 'AC'),
(11893, 23, '1113', 'AC'),
(11894, 23, '1114', 'AC'),
(11895, 23, '1115', 'AC'),
(11896, 23, '112', 'AC'),
(11897, 23, '1121', 'AC'),
(11898, 23, '1122', 'AC'),
(11899, 23, '1123', 'AC'),
(11900, 23, '1124', 'AC'),
(11901, 23, '1125', 'AC'),
(11902, 23, '113', 'AC'),
(11903, 23, '1131', 'AC'),
(11904, 23, '1132', 'AC'),
(11905, 23, '1133', 'AC'),
(11906, 23, '1134', 'AC'),
(11907, 23, '1135', 'AC'),
(11908, 23, '114', 'AC'),
(11909, 23, '1141', 'AC'),
(11910, 23, '1142', 'AC'),
(11911, 23, '1143', 'AC'),
(11912, 23, '1144', 'AC'),
(11913, 23, '1145', 'AC'),
(11914, 23, '115', 'AC'),
(11915, 23, '1151', 'AC'),
(11916, 23, '1152', 'AC'),
(11917, 23, '1153', 'AC'),
(11918, 23, '1154', 'AC'),
(11919, 23, '1155', 'AC'),
(11920, 23, '116', 'AC'),
(11921, 23, '1161', 'AC'),
(11922, 23, '1162', 'AC'),
(11923, 23, '1163', 'AC'),
(11924, 23, '1164', 'AC'),
(11925, 23, '1165', 'AC'),
(11926, 23, '117', 'AC'),
(11927, 23, '1171', 'AC'),
(11928, 23, '1172', 'AC'),
(11929, 23, '1173', 'AC'),
(11930, 23, '1174', 'AC'),
(11931, 23, '1175', 'AC'),
(11932, 23, '118', 'AC'),
(11933, 23, '1181', 'AC'),
(11934, 23, '1182', 'AC'),
(11935, 23, '1183', 'AC'),
(11936, 23, '1184', 'AC'),
(11937, 23, '1185', 'AC'),
(11938, 23, '20', 'AC'),
(11939, 23, '21', 'AC'),
(11940, 23, '211', 'AC'),
(11941, 23, '2111', 'AC'),
(11942, 23, '2112', 'AC'),
(11943, 23, '2113', 'AC'),
(11944, 23, '2114', 'AC'),
(11945, 23, '2115', 'AC'),
(11946, 23, '212', 'AC'),
(11947, 23, '2121', 'AC'),
(11948, 23, '2122', 'AC'),
(11949, 23, '2123', 'AC'),
(11950, 23, '2124', 'AC'),
(11951, 23, '2125', 'AC'),
(11952, 23, '213', 'AC'),
(11953, 23, '2131', 'AC'),
(11954, 23, '2132', 'AC'),
(11955, 23, '2133', 'AC'),
(11956, 23, '2134', 'AC'),
(11957, 23, '2135', 'AC'),
(11958, 23, '214', 'AC'),
(11959, 23, '2141', 'AC'),
(11960, 23, '2142', 'AC'),
(11961, 23, '2143', 'AC'),
(11962, 23, '2144', 'AC'),
(11963, 23, '2145', 'AC'),
(11964, 23, '30', 'AC'),
(11965, 23, '31', 'AC'),
(11966, 23, '311', 'AC'),
(11967, 23, '3111', 'AC'),
(11968, 23, '3112', 'AC'),
(11969, 23, '3113', 'AC'),
(11970, 23, '3114', 'AC'),
(11971, 23, '3115', 'AC'),
(11972, 23, '312', 'AC'),
(11973, 23, '3121', 'AC'),
(11974, 23, '3122', 'AC'),
(11975, 23, '3123', 'AC'),
(11976, 23, '3124', 'AC'),
(11977, 23, '3125', 'AC'),
(11978, 23, '313', 'AC'),
(11979, 23, '3131', 'AC'),
(11980, 23, '3132', 'AC'),
(11981, 23, '3133', 'AC'),
(11982, 23, '3134', 'AC'),
(11983, 23, '3135', 'AC'),
(11984, 23, '40', 'AC'),
(11985, 23, '41', 'AC'),
(11986, 23, '411', 'AC'),
(11987, 23, '4111', 'AC'),
(11988, 23, '4112', 'AC'),
(11989, 23, '4113', 'AC'),
(11990, 23, '4114', 'AC'),
(11991, 23, '412', 'AC'),
(11992, 23, '4121', 'AC'),
(11993, 23, '4122', 'AC'),
(11994, 23, '4123', 'AC'),
(11995, 23, '4124', 'AC'),
(11996, 23, '50', 'AC'),
(11997, 23, '51', 'AC'),
(11998, 23, '511', 'AC'),
(11999, 23, '5111', 'AC'),
(12000, 23, '5112', 'AC'),
(12001, 23, '5113', 'AC'),
(12002, 23, '5114', 'AC'),
(12003, 23, '512', 'AC'),
(12004, 23, '5121', 'AC'),
(12005, 23, '5122', 'AC'),
(12006, 23, '5123', 'AC'),
(12007, 23, '5124', 'AC'),
(12008, 23, '60', 'AC'),
(12009, 23, '61', 'AC'),
(12010, 23, '611', 'AC'),
(12011, 23, '6111', 'AC'),
(12012, 23, '6112', 'AC'),
(12013, 23, '6113', 'AC'),
(12014, 23, '612', 'AC'),
(12015, 23, '6121', 'AC'),
(12016, 23, '6122', 'AC'),
(12017, 23, '6123', 'AC'),
(12018, 23, '613', 'AC'),
(12019, 23, '6131', 'AC'),
(12020, 23, '6132', 'AC'),
(12021, 23, '6133', 'AC'),
(12022, 23, '614', 'AC'),
(12023, 23, '6141', 'AC'),
(12024, 23, '6142', 'AC'),
(12025, 23, '6143', 'AC'),
(12026, 23, '62', 'AC'),
(12027, 23, '621', 'AC'),
(12028, 23, '6211', 'AC'),
(12029, 23, '6212', 'AC'),
(12030, 23, '6213', 'AC'),
(12031, 23, '622', 'AC'),
(12032, 23, '6221', 'AC'),
(12033, 23, '6222', 'AC'),
(12034, 23, '6223', 'AC'),
(12035, 23, '623', 'AC'),
(12036, 23, '6231', 'AC'),
(12037, 23, '6232', 'AC'),
(12038, 23, '6233', 'AC'),
(12039, 23, '624', 'AC'),
(12040, 23, '6241', 'AC'),
(12041, 23, '6242', 'AC'),
(12042, 23, '6243', 'AC'),
(12043, 23, '63', 'AC'),
(12044, 23, '631', 'AC'),
(12045, 23, '6311', 'AC'),
(12046, 23, '6312', 'AC'),
(12047, 23, '6313', 'AC'),
(12048, 23, '632', 'AC'),
(12049, 23, '6321', 'AC'),
(12050, 23, '6322', 'AC'),
(12051, 23, '6323', 'AC'),
(12052, 23, '633', 'AC'),
(12053, 23, '6331', 'AC'),
(12054, 23, '6332', 'AC'),
(12055, 23, '6333', 'AC'),
(12056, 23, '634', 'AC'),
(12057, 23, '6341', 'AC'),
(12058, 23, '6342', 'AC'),
(12059, 23, '6343', 'AC'),
(12060, 23, '64', 'AC'),
(12061, 23, '641', 'AC'),
(12062, 23, '6411', 'AC'),
(12063, 23, '6412', 'AC'),
(12064, 23, '6413', 'AC'),
(12065, 23, '6414', 'AC'),
(12066, 23, '6415', 'AC'),
(12067, 23, '642', 'AC'),
(12068, 23, '6421', 'AC'),
(12069, 23, '6422', 'AC'),
(12070, 23, '6423', 'AC'),
(12071, 23, '6424', 'AC'),
(12072, 23, '6425', 'AC'),
(12073, 23, '65', 'AC'),
(12074, 23, '651', 'AC'),
(12075, 23, '6511', 'AC'),
(12076, 23, '6512', 'AC'),
(12077, 23, '6513', 'AC'),
(12078, 23, '6514', 'AC'),
(12079, 23, '652', 'AC'),
(12080, 23, '6521', 'AC'),
(12081, 23, '6522', 'AC'),
(12082, 23, '6523', 'AC'),
(12083, 23, '6524', 'AC'),
(12084, 23, '6525', 'AC'),
(12085, 23, '66', 'AC'),
(12086, 23, '661', 'AC'),
(12087, 23, '6611', 'AC'),
(12088, 23, '6612', 'AC'),
(12089, 23, '6613', 'AC'),
(12090, 23, '6614', 'AC'),
(12091, 23, '6615', 'AC'),
(12092, 23, '662', 'AC'),
(12093, 23, '6621', 'AC'),
(12094, 23, '6622', 'AC'),
(12095, 23, '6623', 'AC'),
(12096, 23, '6624', 'AC'),
(12097, 23, '6625', 'AC'),
(12098, 23, '663', 'AC'),
(12099, 23, '6631', 'AC'),
(12100, 23, '6632', 'AC'),
(12101, 23, '6633', 'AC'),
(12102, 23, '6634', 'AC'),
(12103, 23, '6635', 'AC'),
(12104, 23, '70', 'AC'),
(12105, 23, '71', 'AC'),
(12106, 23, '711', 'AC'),
(12107, 23, '7111', 'AC'),
(12108, 23, '712', 'AC'),
(12109, 23, '7121', 'AC'),
(12110, 23, '713', 'AC'),
(12111, 23, '7131', 'AC'),
(12112, 23, '714', 'AC'),
(12113, 23, '7141', 'AC'),
(12114, 23, '715', 'AC'),
(12115, 23, '7151', 'AC'),
(12116, 23, '80', 'AC'),
(12117, 23, '81', 'AC'),
(12118, 23, '811', 'AC'),
(12119, 23, '8111', 'AC'),
(12120, 23, '8112', 'AC'),
(12121, 23, '8113', 'AC'),
(12122, 23, '8114', 'AC'),
(12123, 23, '812', 'AC'),
(12124, 23, '8121', 'AC'),
(12125, 23, '8122', 'AC'),
(12126, 23, '8123', 'AC'),
(12127, 23, '8124', 'AC'),
(12128, 23, '813', 'AC'),
(12129, 23, '8131', 'AC'),
(12130, 23, '8132', 'AC'),
(12131, 23, '8133', 'AC'),
(12132, 23, '8134', 'AC'),
(12133, 23, '82', 'AC'),
(12134, 23, '821', 'AC'),
(12135, 23, '8211', 'AC'),
(12136, 23, '8212', 'AC'),
(12137, 23, '8213', 'AC'),
(12138, 23, '8214', 'AC'),
(12139, 23, '822', 'AC'),
(12140, 23, '8221', 'AC'),
(12141, 23, '8222', 'AC'),
(12142, 23, '8223', 'AC'),
(12143, 23, '8224', 'AC'),
(12144, 23, '83', 'AC'),
(12145, 23, '831', 'AC'),
(12146, 23, '8311', 'AC'),
(12147, 23, '8312', 'AC'),
(12148, 23, '8313', 'AC'),
(12149, 23, '8314', 'AC'),
(12150, 23, '832', 'AC'),
(12151, 23, '84', 'AC'),
(12152, 23, '841', 'AC'),
(12153, 23, '85', 'AC'),
(12154, 23, '851', 'AC'),
(12155, 23, '8511', 'AC'),
(12156, 23, '8512', 'AC'),
(12157, 23, '8513', 'AC'),
(12158, 23, '8514', 'AC'),
(12159, 23, '852', 'AC'),
(12160, 23, '8521', 'AC'),
(12161, 23, '8522', 'AC'),
(12162, 23, '8523', 'AC'),
(12163, 23, '8524', 'AC'),
(12164, 23, '853', 'AC'),
(12165, 23, '8531', 'AC'),
(12166, 23, '8532', 'AC'),
(12167, 23, '8533', 'AC'),
(12168, 23, '8534', 'AC'),
(13750, 2, 'ckAll', 'AC'),
(13751, 2, '10', 'AC'),
(13752, 2, '11', 'AC'),
(13753, 2, '111', 'AC'),
(13754, 2, '1111', 'AC'),
(13755, 2, '1112', 'AC'),
(13756, 2, '1113', 'AC'),
(13757, 2, '1114', 'AC'),
(13758, 2, '1115', 'AC'),
(13759, 2, '112', 'AC'),
(13760, 2, '1121', 'AC'),
(13761, 2, '1122', 'AC'),
(13762, 2, '1123', 'AC'),
(13763, 2, '1124', 'AC'),
(13764, 2, '1125', 'AC'),
(13765, 2, '113', 'AC'),
(13766, 2, '1131', 'AC'),
(13767, 2, '1132', 'AC'),
(13768, 2, '1133', 'AC'),
(13769, 2, '1134', 'AC'),
(13770, 2, '1135', 'AC'),
(13771, 2, '114', 'AC'),
(13772, 2, '1141', 'AC'),
(13773, 2, '1142', 'AC'),
(13774, 2, '1143', 'AC'),
(13775, 2, '1144', 'AC'),
(13776, 2, '1145', 'AC'),
(13777, 2, '115', 'AC'),
(13778, 2, '1151', 'AC'),
(13779, 2, '1152', 'AC'),
(13780, 2, '1153', 'AC'),
(13781, 2, '1154', 'AC'),
(13782, 2, '1155', 'AC'),
(13783, 2, '116', 'AC'),
(13784, 2, '1161', 'AC'),
(13785, 2, '1162', 'AC'),
(13786, 2, '1163', 'AC'),
(13787, 2, '1164', 'AC'),
(13788, 2, '1165', 'AC'),
(13789, 2, '117', 'AC'),
(13790, 2, '1171', 'AC'),
(13791, 2, '1172', 'AC'),
(13792, 2, '1173', 'AC'),
(13793, 2, '1174', 'AC'),
(13794, 2, '1175', 'AC'),
(13795, 2, '118', 'AC'),
(13796, 2, '1181', 'AC'),
(13797, 2, '1182', 'AC'),
(13798, 2, '1183', 'AC'),
(13799, 2, '1184', 'AC'),
(13800, 2, '1185', 'AC'),
(13801, 2, '20', 'AC'),
(13802, 2, '21', 'AC'),
(13803, 2, '211', 'AC'),
(13804, 2, '2111', 'AC'),
(13805, 2, '2112', 'AC'),
(13806, 2, '2113', 'AC'),
(13807, 2, '2114', 'AC'),
(13808, 2, '2115', 'AC'),
(13809, 2, '212', 'AC'),
(13810, 2, '2121', 'AC'),
(13811, 2, '2122', 'AC'),
(13812, 2, '2123', 'AC'),
(13813, 2, '2124', 'AC'),
(13814, 2, '2125', 'AC'),
(13815, 2, '213', 'AC'),
(13816, 2, '2131', 'AC'),
(13817, 2, '2132', 'AC'),
(13818, 2, '2133', 'AC'),
(13819, 2, '2134', 'AC'),
(13820, 2, '2135', 'AC'),
(13821, 2, '214', 'AC'),
(13822, 2, '2141', 'AC'),
(13823, 2, '2142', 'AC'),
(13824, 2, '2143', 'AC'),
(13825, 2, '2144', 'AC'),
(13826, 2, '2145', 'AC'),
(13827, 2, '30', 'AC'),
(13828, 2, '31', 'AC'),
(13829, 2, '311', 'AC'),
(13830, 2, '3111', 'AC'),
(13831, 2, '3112', 'AC'),
(13832, 2, '3113', 'AC'),
(13833, 2, '3114', 'AC'),
(13834, 2, '3115', 'AC'),
(13835, 2, '312', 'AC'),
(13836, 2, '3121', 'AC'),
(13837, 2, '3122', 'AC'),
(13838, 2, '3123', 'AC'),
(13839, 2, '3124', 'AC'),
(13840, 2, '3125', 'AC'),
(13841, 2, '313', 'AC'),
(13842, 2, '3131', 'AC'),
(13843, 2, '3132', 'AC'),
(13844, 2, '3133', 'AC'),
(13845, 2, '3134', 'AC'),
(13846, 2, '3135', 'AC'),
(13847, 2, '40', 'AC'),
(13848, 2, '41', 'AC'),
(13849, 2, '411', 'AC'),
(13850, 2, '4111', 'AC'),
(13851, 2, '4112', 'AC'),
(13852, 2, '4113', 'AC'),
(13853, 2, '4115', 'AC'),
(13854, 2, '412', 'AC'),
(13855, 2, '4121', 'AC'),
(13856, 2, '4122', 'AC'),
(13857, 2, '4123', 'AC'),
(13858, 2, '4125', 'AC'),
(13859, 2, '50', 'AC'),
(13860, 2, '51', 'AC'),
(13861, 2, '511', 'AC'),
(13862, 2, '5111', 'AC'),
(13863, 2, '5112', 'AC'),
(13864, 2, '5113', 'AC'),
(13865, 2, '5115', 'AC'),
(13866, 2, '512', 'AC'),
(13867, 2, '5121', 'AC'),
(13868, 2, '5122', 'AC'),
(13869, 2, '5123', 'AC'),
(13870, 2, '5125', 'AC'),
(13871, 2, '60', 'AC'),
(13872, 2, '61', 'AC'),
(13873, 2, '611', 'AC'),
(13874, 2, '6112', 'AC'),
(13875, 2, '6113', 'AC'),
(13876, 2, '6115', 'AC'),
(13877, 2, '612', 'AC'),
(13878, 2, '6122', 'AC'),
(13879, 2, '6123', 'AC'),
(13880, 2, '6125', 'AC'),
(13881, 2, '613', 'AC'),
(13882, 2, '6132', 'AC'),
(13883, 2, '6133', 'AC'),
(13884, 2, '6135', 'AC'),
(13885, 2, '614', 'AC'),
(13886, 2, '6142', 'AC'),
(13887, 2, '6143', 'AC'),
(13888, 2, '6145', 'AC'),
(13889, 2, '62', 'AC'),
(13890, 2, '621', 'AC'),
(13891, 2, '6212', 'AC'),
(13892, 2, '6213', 'AC'),
(13893, 2, '6215', 'AC'),
(13894, 2, '622', 'AC'),
(13895, 2, '6222', 'AC'),
(13896, 2, '6223', 'AC'),
(13897, 2, '6225', 'AC'),
(13898, 2, '623', 'AC'),
(13899, 2, '6232', 'AC'),
(13900, 2, '6233', 'AC'),
(13901, 2, '6235', 'AC'),
(13902, 2, '624', 'AC'),
(13903, 2, '6242', 'AC'),
(13904, 2, '6243', 'AC'),
(13905, 2, '6245', 'AC'),
(13906, 2, '63', 'AC'),
(13907, 2, '631', 'AC'),
(13908, 2, '6312', 'AC'),
(13909, 2, '6313', 'AC'),
(13910, 2, '6315', 'AC'),
(13911, 2, '632', 'AC'),
(13912, 2, '6322', 'AC'),
(13913, 2, '6323', 'AC'),
(13914, 2, '6325', 'AC'),
(13915, 2, '633', 'AC'),
(13916, 2, '6332', 'AC'),
(13917, 2, '6333', 'AC'),
(13918, 2, '6335', 'AC'),
(13919, 2, '634', 'AC'),
(13920, 2, '6342', 'AC'),
(13921, 2, '6343', 'AC'),
(13922, 2, '6345', 'AC'),
(13923, 2, '64', 'AC'),
(13924, 2, '641', 'AC'),
(13925, 2, '6411', 'AC'),
(13926, 2, '6412', 'AC'),
(13927, 2, '6413', 'AC'),
(13928, 2, '6414', 'AC'),
(13929, 2, '6415', 'AC'),
(13930, 2, '642', 'AC'),
(13931, 2, '6421', 'AC'),
(13932, 2, '6422', 'AC'),
(13933, 2, '6423', 'AC'),
(13934, 2, '6424', 'AC'),
(13935, 2, '6425', 'AC'),
(13936, 2, '65', 'AC'),
(13937, 2, '651', 'AC'),
(13938, 2, '6511', 'AC'),
(13939, 2, '6512', 'AC'),
(13940, 2, '6513', 'AC'),
(13941, 2, '6514', 'AC'),
(13942, 2, '652', 'AC'),
(13943, 2, '6521', 'AC'),
(13944, 2, '6522', 'AC'),
(13945, 2, '6523', 'AC'),
(13946, 2, '6524', 'AC'),
(13947, 2, '6525', 'AC'),
(13948, 2, '66', 'AC'),
(13949, 2, '661', 'AC'),
(13950, 2, '6611', 'AC'),
(13951, 2, '6612', 'AC'),
(13952, 2, '6613', 'AC'),
(13953, 2, '6614', 'AC'),
(13954, 2, '6615', 'AC'),
(13955, 2, '70', 'AC'),
(13956, 2, '71', 'AC'),
(13957, 2, '711', 'AC'),
(13958, 2, '7111', 'AC'),
(13959, 2, '712', 'AC'),
(13960, 2, '7121', 'AC'),
(13961, 2, '713', 'AC'),
(13962, 2, '7131', 'AC'),
(13963, 2, '80', 'AC'),
(13964, 2, '81', 'AC'),
(13965, 2, '811', 'AC'),
(13966, 2, '8111', 'AC'),
(13967, 2, '8112', 'AC'),
(13968, 2, '8113', 'AC'),
(13969, 2, '8114', 'AC'),
(13970, 2, '812', 'AC'),
(13971, 2, '8121', 'AC'),
(13972, 2, '8122', 'AC'),
(13973, 2, '8123', 'AC'),
(13974, 2, '8124', 'AC'),
(13975, 2, '813', 'AC'),
(13976, 2, '8131', 'AC'),
(13977, 2, '8132', 'AC'),
(13978, 2, '8133', 'AC'),
(13979, 2, '8134', 'AC'),
(13980, 2, '82', 'AC'),
(13981, 2, '821', 'AC'),
(13982, 2, '8211', 'AC'),
(13983, 2, '8212', 'AC'),
(13984, 2, '8213', 'AC'),
(13985, 2, '8214', 'AC'),
(13986, 2, '822', 'AC'),
(13987, 2, '8221', 'AC'),
(13988, 2, '8222', 'AC'),
(13989, 2, '8223', 'AC'),
(13990, 2, '8224', 'AC'),
(13991, 2, '83', 'AC'),
(13992, 2, '831', 'AC'),
(13993, 2, '8311', 'AC'),
(13994, 2, '8312', 'AC'),
(13995, 2, '8313', 'AC'),
(13996, 2, '8314', 'AC'),
(13997, 2, '832', 'AC'),
(13998, 2, '8321', 'AC'),
(13999, 2, '8322', 'AC'),
(14000, 2, '8323', 'AC'),
(14001, 2, '8324', 'AC'),
(14002, 2, '84', 'AC'),
(14003, 2, '841', 'AC'),
(14004, 2, '85', 'AC'),
(14005, 2, '851', 'AC'),
(14006, 2, '8511', 'AC'),
(14007, 2, '8512', 'AC'),
(14008, 2, '8513', 'AC'),
(14009, 2, '8514', 'AC'),
(14010, 2, '852', 'AC'),
(14011, 2, '8521', 'AC'),
(14012, 2, '8522', 'AC'),
(14013, 2, '8523', 'AC'),
(14014, 2, '8524', 'AC'),
(14015, 2, '853', 'AC'),
(14016, 2, '8531', 'AC'),
(14017, 2, '8532', 'AC'),
(14018, 2, '8533', 'AC'),
(14019, 2, '8534', 'AC'),
(14020, 2, '854', 'AC'),
(14021, 2, '8541', 'AC'),
(14022, 2, '8542', 'AC'),
(14023, 2, '8543', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

DROP TABLE IF EXISTS `personal`;
CREATE TABLE IF NOT EXISTS `personal` (
  `iPersonalId` int(11) NOT NULL AUTO_INCREMENT,
  `cPersonalCodigo` char(7) NOT NULL,
  `vPersonalNombres` varchar(45) NOT NULL,
  `vPersonalApellidoPaterno` varchar(45) NOT NULL,
  `vPersonalApellidoMaterno` varchar(45) NOT NULL,
  `nPersonalNumeroDocumento` decimal(10,0) NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaAcualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iSexoId` int(11) NOT NULL,
  `iTipoDocumentoId` int(11) NOT NULL,
  `iAreaId` int(11) NOT NULL,
  `iOcupacionId` int(11) DEFAULT NULL,
  `fSueldo` float DEFAULT NULL,
  PRIMARY KEY (`iPersonalId`),
  KEY `fk_personal_sexo1` (`iSexoId`),
  KEY `fk_personal_tipoDocumento1` (`iTipoDocumentoId`),
  KEY `fk_personal_area1` (`iAreaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Volcar la base de datos para la tabla `personal`
--

INSERT INTO `personal` (`iPersonalId`, `cPersonalCodigo`, `vPersonalNombres`, `vPersonalApellidoPaterno`, `vPersonalApellidoMaterno`, `nPersonalNumeroDocumento`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaAcualiza`, `cEstadoCodigo`, `iSexoId`, `iTipoDocumentoId`, `iAreaId`, `iOcupacionId`, `fSueldo`) VALUES
(2, 'PER02', 'LIZ ', 'FERANADEZ', 'MELGAREJO', '12345678', 0, NULL, NULL, '2013-02-04 00:00:00', 'AC', 1, 1, 1, 1, NULL),
(13, 'P003', 'DANIEL', 'CARPIO', 'NARVARTE', '25948454', 0, 0, NULL, '2014-03-13 00:00:00', 'AC', 2, 1, 3, 1, NULL),
(14, 'SF001', 'SARITA', 'FERNANDEZ', 'MELGAREJO', '574456454', 0, 0, '2014-02-15 00:00:00', NULL, 'AC', 1, 1, 3, 1, NULL),
(15, 'PE00015', 'DIEGO', 'GONZALES', 'VALDEZ', '46521231', 0, 0, '2015-01-01 00:00:00', NULL, 'AC', 2, 1, 3, 1, NULL),
(16, 'PE00016', 'CAMILA', 'GONZALES', 'FERNANDEZ', '154515', 0, 0, '2015-01-27 00:00:00', NULL, 'AC', 1, 1, 1, 1, 5500),
(17, 'PE00017', 'ROSSAN', 'FERNANDEZ', 'MELGAREJPO', '54855410', 2, 0, '2015-04-21 23:20:05', NULL, 'AC', 1, 1, 1, 1, 8000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `planilla`
--

DROP TABLE IF EXISTS `planilla`;
CREATE TABLE IF NOT EXISTS `planilla` (
  `iPlanillaId` int(11) NOT NULL AUTO_INCREMENT,
  `iPersonalId` int(11) DEFAULT NULL,
  `fSueldo` float DEFAULT NULL,
  `fAsignacionFamiliar` float DEFAULT NULL,
  `fTotalRemuneracion` float DEFAULT NULL,
  `fDesSNP` float DEFAULT NULL,
  `fPorDesSNP` float DEFAULT NULL,
  `fDesAFP` float DEFAULT NULL,
  `fPorDesAFP` float DEFAULT NULL,
  `fDesPS` float DEFAULT NULL,
  `fPorDesPS` float DEFAULT NULL,
  `fDesCV` float DEFAULT NULL,
  `fPorDesCV` float DEFAULT NULL,
  `fTotalDescuento` float DEFAULT NULL,
  `fApoESSALUD` float DEFAULT NULL,
  `fPorApoESSALUD` float DEFAULT NULL,
  `fPorApoIES` float DEFAULT NULL,
  `fApoIES` float DEFAULT NULL,
  `fTotalAportes` float DEFAULT NULL,
  `fNetoPago` float DEFAULT NULL,
  `dFechaInserta` timestamp NULL DEFAULT NULL,
  `dFechaActualiza` timestamp NULL DEFAULT NULL,
  `iUsuarioInserta` int(11) DEFAULT NULL,
  `iUsuarioActualiza` int(11) DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iPlanillaId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `planilla`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblacion`
--

DROP TABLE IF EXISTS `poblacion`;
CREATE TABLE IF NOT EXISTS `poblacion` (
  `iPoblacionId` int(10) NOT NULL AUTO_INCREMENT,
  `cCodigo` char(6) NOT NULL,
  `vDescripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`iPoblacionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=435 ;

--
-- Volcar la base de datos para la tabla `poblacion`
--

INSERT INTO `poblacion` (`iPoblacionId`, `cCodigo`, `vDescripcion`) VALUES
(1, '010000', 'AMAZONAS'),
(2, '020000', 'ANCASH'),
(3, '030000', 'APURIMAC'),
(4, '040000', 'AREQUIPA'),
(5, '050000', 'AYACUCHO'),
(6, '060000', 'CAJAMARCA'),
(7, '070000', 'CUSCO'),
(8, '080000', 'HUANCAVELICA'),
(9, '090000', 'HUANUCO'),
(10, '100000', 'ICA'),
(11, '110000', 'JUNIN'),
(12, '120000', 'LA LIBERTAD'),
(13, '130000', 'LAMBAYEQUE'),
(14, '140000', 'LIMA'),
(15, '150000', 'LORETO'),
(16, '160000', 'MADRE DE DIOS'),
(17, '170000', 'MOQUEGUA'),
(18, '180000', 'PASCO'),
(19, '190000', 'PIURA'),
(20, '200000', 'PUNO'),
(21, '210000', 'SAN MARTIN'),
(22, '220000', 'TACNA'),
(23, '230000', 'TUMBES'),
(24, '140100', 'BARRANCA'),
(25, '140200', 'CAJATAMBO'),
(27, '140300', 'CANTA'),
(31, '140400', 'HUAURA'),
(32, '140500', 'LIMA'),
(33, '140600', 'OYON'),
(34, '140700', 'YAUYOS'),
(35, '140800', 'CAÃƒâ€˜ETE'),
(37, '140900', 'HUAROCHIRI'),
(43, '141000', 'HUARAL'),
(49, '140502', 'CERCADO DE LIMA'),
(50, '140503', 'ATE'),
(51, '140504', 'BARRANCI'),
(52, '140505', 'BREÃƒâ€˜A'),
(53, '140506', 'COMAS'),
(54, '140507', 'CHORRILLOS'),
(55, '140508', 'EL AGUSTINO'),
(56, '140509', 'JESUSS MARIA'),
(57, '140510', 'LA MOLINA'),
(58, '140511', 'LA VICTORIA'),
(59, '140512', 'LINCE'),
(60, '140513', 'MAGDALENA DEL MAR'),
(61, '140514', 'MIRAFLORES'),
(62, '140515', 'PUEBLO LIBRE'),
(63, '140516', 'PTE. PIEDRA'),
(64, '140517', 'RIMAC'),
(65, '140518', 'SAN ISIDRO'),
(66, '140519', 'INDEPENDENCIA'),
(67, '140520', 'S.J.M'),
(68, '140521', 'SAN LUIS'),
(69, '140522', 'S.M.P'),
(70, '140523', 'SAN MIGUEL'),
(71, '140524', 'SANTIAGO DE SURCO'),
(72, '140525', 'SURQUILLO'),
(73, '140526', 'VILLA MARIA DEL TRIUNFO'),
(74, '140527', 'S.J.L'),
(75, '140528', 'SANTA ROSA'),
(76, '140529', 'LOS OLIVOS'),
(77, '140530', 'SAN BORJA'),
(78, '140531', 'VILLA EL SAVADOR'),
(79, '140532', 'SANTA ANITA'),
(80, '140501', 'LIMA'),
(81, '140533', 'PACHACAMA'),
(82, '140534', 'LURIN'),
(87, '140535', 'CALLAO'),
(88, '140536', 'PUNTA HERMOSA'),
(89, '140537', 'CHACLACAYO'),
(90, '140538', 'CARABAYLLO'),
(91, '140539', 'VENTANILLA'),
(92, '140540', 'ANCON'),
(93, '010100', 'CHACHAPOYAS'),
(94, '010101', 'CHACHAPOYAS'),
(95, '010102', 'ASUNCION'),
(96, '010103', '	BALSAS	'),
(97, '010104', '	CHETO	'),
(98, '010105', '	CHILIQUIN	'),
(99, '010106', '	CHUQUIBAMBA	'),
(100, '010107', '	GRANADA	'),
(101, '010108', '	HUANCAS	'),
(102, '010109', '	LA JALCA	'),
(103, '010110', '	LEIMEBAMBA	'),
(104, '010111', '	LEVANTO	'),
(105, '010112', '	MAGDALENA	'),
(106, '010113', '	MARISCAL CASTILLA	'),
(107, '010114', '	MOLINOPAMPA	'),
(108, '010115', '	MONTEVIDEO	'),
(109, '010116', '	OLLEROS	'),
(110, '010117', '	QUINJALCA	'),
(111, '010118', '	SAN FRANCISCO DE DAGUAS	'),
(112, '010119', '	SAN ISIDRO DE MAINO	'),
(113, '010120', '	SOLOCO	'),
(114, '010121', '	SONCHE 	'),
(115, '010200', '	BAGUA	'),
(116, '010201', '	LA PECA (Bagua)	'),
(117, '010202', '	ARAMANGO	'),
(118, '010203', '	COPALLIN	'),
(119, '010204', '	EL PARCO	'),
(120, '010205', '	IMAZA (Chiriaco)	'),
(121, '010300', 'BONGARA'),
(122, '010301', 'JUMBILLA'),
(123, '010302', 'CHISQUILLA'),
(124, '010303', 'CHURUJA'),
(125, '010304', 'COROSHA'),
(126, '010305', 'CUISPES'),
(127, '010306', 'FLORIDA'),
(128, '010307', 'JAZAN'),
(129, '010308', 'RECTA'),
(130, '010309', 'SAN CARLOS'),
(131, '010310', 'SHIPASBAMBA'),
(132, '010311', 'VALERA'),
(133, '010312', 'YAMBRASBAMBA'),
(134, '010400', 'CONDORCANQUI'),
(135, '010401', 'NIEVA'),
(136, '010402', 'EL CENEPA'),
(137, '010403', 'RIO SANTIAGO'),
(138, '010500', 'LUYA	'),
(139, '010501', 'LAMUD	'),
(140, '010502', 'CAMPORREDONDO	'),
(141, '010503', 'COCABAMBA	'),
(142, '010504', 'COLCAMAR	'),
(143, '010505', 'CONILA (CohechÃƒÂ¡n)	'),
(144, '010506', 'INGUILPATA	'),
(145, '010507', 'LONGUITA	'),
(146, '010508', 'LONYA CHICO	'),
(147, '010509', 'LUYA	'),
(148, '010510', 'LUYA VIEJO	'),
(149, '010511', 'MARIA	'),
(150, '010512', 'OCALLI	'),
(151, '010513', 'OCUMAL (Collonce)	'),
(152, '010514', 'PISUQUIA (YomblÃƒÂ³n)	'),
(153, '010515', 'PROVIDENCIA	'),
(154, '010516', 'SAN CRISTOBAL (Olto)	'),
(155, '010517', 'SAN FRANCISCO DEL YESO	'),
(156, '010518', 'SAN JERONIMO (Paclas)	'),
(157, '010519', 'SAN JUAN DE LOPECANCHA	'),
(158, '010520', 'SANTA CATALINA	'),
(159, '010521', 'SANTO TOMAS	'),
(160, '010522', 'TINGO	'),
(161, '010523', 'TRITA	'),
(162, '020100', '	HUARAZ	'),
(163, '020101', '	HUARAZ	'),
(164, '020102', '	COCHABAMBA	'),
(165, '020103', '	COLCABAMBA	'),
(166, '020104', '	HUANCHAY	'),
(167, '020105', '	JANGAS	'),
(168, '020106', '	LA LIBERTAD (Cajamarquilla)	'),
(169, '020107', '	OLLEROS	'),
(170, '020108', '	PAMPAS	'),
(171, '020109', '	PARIACOTO	'),
(172, '020110', '	PIRA	'),
(173, '020111', '	TARICA	'),
(174, '020112', '	INDEPENDENCIA (Centenario)	'),
(175, '020200', '	AIJA	'),
(176, '020201', '	AIJA	'),
(177, '020202', '	CORIS	'),
(178, '020203', '	HUACLLAN	'),
(179, '020204', '	LA MERCED	'),
(180, '020205', '	SUCCHA	'),
(181, '020300', '	ANTONIO RAYMONDI	'),
(182, '020301', '	LLAMELLIN	'),
(183, '020302', '	ACZO	'),
(184, '020303', '	CHACCHO	'),
(185, '020304', '	CHINGAS	'),
(186, '020305', '	MIRGAS	'),
(187, '020306', '	SAN JUAN DE RONTOY	'),
(188, '020400', '	ASUNCION	'),
(189, '020401', '	CHACAS	'),
(190, '020402', '	ACOCHACA	'),
(191, '020500', '	BOLOGNESI	'),
(192, '020501', '	CHIQUIAN	'),
(193, '020502', '	ABELARDO PARDO LEZAMETA (Llaclla)	'),
(194, '020503', '	ANTONIO RAYMONDI (Raquia)	'),
(195, '020504', '	AQUIA	'),
(196, '020505', '	CAJACAY	'),
(197, '020506', '	CANIS	'),
(198, '020507', '	COLQUIOC (Chasquitambo)	'),
(199, '020508', '	HUALLANCA	'),
(200, '020509', '	HUASTA	'),
(201, '020510', '	HUAYLLACAYAN	'),
(202, '020511', '	LA PRIMAVERA (Gorgorillo)	'),
(203, '020512', '	MANGAS	'),
(204, '020513', '	PACLLON	'),
(205, '020514', '	S. MGEL DE CORPANQUI	'),
(206, '020515', '	TICLLOS	'),
(207, '020600', '	CARHUAZ	'),
(208, '020601', '	CARHUAZ	'),
(209, '020602', '	ACOPAMPA	'),
(210, '020603', '	AMASHCA	'),
(211, '020604', '	ANTA	'),
(212, '020605', '	ATAQUERO (Carhuac)	'),
(213, '020606', '	MARCARA	'),
(214, '020607', '	PARIAHUANCA	'),
(215, '020608', '	SAN MIGUEL DE ACO (Aco)	'),
(216, '020609', '	SHILLA	'),
(217, '020610', '	TINCO	'),
(218, '020611', '	YUNGAR	'),
(219, '020700', '	CARLOS F. FITZCARRALD	'),
(220, '020701', '	SAN LUIS	'),
(221, '020702', '	SAN NICOLAS	'),
(222, '020703', '	YAUYA	'),
(223, '020800', '	CASMA	'),
(224, '020801', '	CASMA	'),
(225, '020802', '	BUENA VISTA ALTA	'),
(226, '020803', '	COMANDANTE NOEL (Pto. Casma)	'),
(227, '020804', '	YAUTAN	'),
(228, '020900', '	CORONGO	'),
(229, '020901', '	CORONGO	'),
(230, '020902', '	ACO	'),
(231, '020903', '	BAMBAS	'),
(232, '020904', '	CUSCA	'),
(233, '020905', '	LA PAMPA	'),
(234, '020906', '	YANAC	'),
(235, '020907', '	YUPAN	'),
(236, '021000', '	HUARI	'),
(237, '021001', '	HUARI	'),
(238, '021002', '	ANRA	'),
(239, '021003', '	CAJAY	'),
(240, '021004', '	CHAVIN DE HUANTAR	'),
(241, '021005', '	HUACACHI	'),
(242, '021006', '	HUACCHIS	'),
(243, '021007', '	HUACHIS	'),
(244, '021008', '	HUANTAR	'),
(245, '021009', '	MASIN	'),
(246, '021010', '	PAUCAS	'),
(247, '021011', '	PONTO	'),
(248, '021012', '	RAHUAPAMPA	'),
(249, '021013', '	RAPAYAN	'),
(250, '021014', '	SAN MARCOS	'),
(251, '021015', '	SAN PEDRO DE CHANA (Chana)	'),
(252, '021016', '	UCO	'),
(253, '021100', '	HUARMEY	'),
(254, '021101', '	HUARMEY	'),
(255, '021102', '	COCHAPETI	'),
(256, '021103', '	CULEBRAS (La Caleta de Culebras)	'),
(257, '021104', '	HUAYAN	'),
(258, '021105', '	MALVAS	'),
(259, '021200', '	HUAYLAS	'),
(260, '021201', '	CARAZ	'),
(261, '021202', '	HUALLANCA	'),
(262, '021203', '	HUATA	'),
(263, '021204', '	HUAYLAS	'),
(264, '021205', '	MATO	'),
(265, '021206', '	PAMPAROMAS	'),
(266, '021207', '	PUEBLO LIBRE	'),
(267, '021208', '	SANTA CRUZ (Huaripampa)	'),
(268, '021209', '	SANTO TORIBIO	'),
(269, '021210', '	YURACMARCA	'),
(270, '021300', '	MARISCAL LUZURIAGA	'),
(271, '021301', '	PISCOBAMBA	'),
(272, '021302', '	CASCA	'),
(273, '021303', '	ELEAZAR GUZMAN BARRON	'),
(274, '021304', '	FIDEL OLIVAS ESCUDERO (Sanachgan)	'),
(275, '021305', '	LLAMA	'),
(276, '021306', '	LLUMPA	'),
(277, '021307', '	LUCMA	'),
(278, '021308', '	MUSGA	'),
(279, '021400', '	OCROS	'),
(280, '021401', '	OCROS	'),
(281, '021402', '	ACAS	'),
(282, '021403', '	CAJAMARQUILLA	'),
(283, '021404', '	CARHUAPAMPA	'),
(284, '021405', '	COCHAS (Huanchay)	'),
(285, '021406', '	CONGAS	'),
(286, '021407', '	LLIPA	'),
(287, '021408', '	SAN CRISTOBAL DE RAJAN	'),
(288, '021409', '	SAN PEDRO	'),
(289, '021410', '	SANTIAGO DE CHILCAS	'),
(290, '021500', '	PALLASCA	'),
(291, '021501', '	CABANA	'),
(292, '021502', '	BOLOGNESI	'),
(293, '021503', '	CONCHUCOS	'),
(294, '021504', '	HUACASCHUQUE	'),
(295, '021505', '	HUANDOVAL	'),
(296, '021506', '	LACABAMBA	'),
(297, '021507', '	LLAPO	'),
(298, '021508', '	PALLASCA	'),
(299, '021509', '	PAMPAS	'),
(300, '021510', '	SANTA ROSA	'),
(301, '021511', '	TAUCA	'),
(302, '021600', '	POMABAMBA	'),
(303, '021601', '	POMABAMBA	'),
(304, '021602', '	HUAYLLAN	'),
(305, '021603', '	PAROBAMBA	'),
(306, '021604', '	QUINUABAMBA	'),
(307, '021700', '	RECUAY	'),
(308, '021701', '	RECUAY	'),
(309, '021702', '	CATAC	'),
(310, '021703', '	COTAPARACO	'),
(311, '021704', '	HUAYLLAPAMPA	'),
(312, '021705', '	LLACLLIN	'),
(313, '021706', '	MARCA	'),
(314, '021707', '	PAMPAS CHICO	'),
(315, '021708', '	PARARIN	'),
(316, '021709', '	TAPACOCHA	'),
(317, '021710', '	TICAPAMPA	'),
(318, '021800', '	SANTA	'),
(319, '021801', '	CHIMBOTE	'),
(320, '021802', '	CACERES DEL PERU	'),
(321, '021803', '	COISHCO	'),
(322, '021804', '	MACATE	'),
(323, '021805', '	MORO	'),
(324, '021806', '	NEPEÃƒâ€˜A	'),
(325, '021807', '	SAMANCO	'),
(326, '021808', '	SANTA	'),
(327, '021809', '	NUEVO CHIMBOTE (Buenos Aires)	'),
(328, '021900', '	SIHUAS	'),
(329, '021901', '	SIHUAS	'),
(330, '021902', '	ACOBAMBA	'),
(331, '021903', '	ALFONSO UGARTE	'),
(332, '021904', '	CASHAPAMPA	'),
(333, '021905', '	CHINGALPO	'),
(334, '021906', '	HUAYLLABAMBA	'),
(335, '021907', '	QUICHES	'),
(336, '021908', '	RAGASH	'),
(337, '021909', '	SAN JUAN	'),
(338, '021910', '	SICSIBAMBA	'),
(339, '022000', '	YUNGAY	'),
(340, '022001', '	YUNGAY	'),
(341, '022002', '	CASCAPARA	'),
(342, '022003', '	MANCOS	'),
(343, '022004', '	MATACOTO	'),
(344, '022005', '	QUILLO	'),
(345, '022006', '	RANRAHIRCA	'),
(346, '022007', '	SHUPLUY	'),
(347, '022008', '	YANAMA	'),
(348, '030100', '	ABANCAY	'),
(349, '030101', '	ABANCAY	'),
(350, '030102', '	CHACOCHE	'),
(351, '030103', '	CIRCA	'),
(352, '030104', '	CURAHUASI	'),
(353, '030105', '	HUANIPACA	'),
(354, '030106', '	LAMBRAMA	'),
(355, '030107', '	PICHIRHUA	'),
(356, '030108', '	SAN PEDRO DE CACHORA (Cachorro)	'),
(357, '030109', '	TAMBURCO	'),
(358, '030200', '	ANTABAMBA	'),
(359, '030201', '	ANTABAMBA	'),
(360, '030202', '	EL ORO	'),
(361, '030203', '	HUAQUIRCA	'),
(362, '030204', '	JUAN ESPINOZA MEDRANO (Mollebamba)	'),
(363, '030205', '	OROPESA	'),
(364, '030206', '	PACHACONAS	'),
(365, '030207', '	SABAINO	'),
(366, '030300', '	AYMARAES	'),
(367, '030301', '	CHALHUANCA	'),
(368, '030302', '	CAPAYA	'),
(369, '030303', '	CARAYBAMBA	'),
(370, '030304', '	CHAPIMARCA	'),
(371, '030305', '	COLCABAMBA	'),
(372, '030306', '	COTARUSE	'),
(373, '030307', '	HUAYLLO	'),
(374, '030308', '	JUSTO APU SAHUARAURA (Pichihua)	'),
(375, '030309', '	LUCRE	'),
(376, '030310', '	POCOHUANCA	'),
(377, '030311', '	SAN JUAN DE CHACÃƒâ€˜A	'),
(378, '030312', '	SAÃƒâ€˜AYCA	'),
(379, '030313', '	SORAYA	'),
(380, '030314', '	TAPAIRIHUA	'),
(381, '030315', '	TINTAY	'),
(382, '030316', '	TORAYA	'),
(383, '030317', '	YANACA	'),
(384, '030400', '	COTABAMBAS	'),
(385, '030401', '	TAMBOBAMBA	'),
(386, '030402', '	COTABAMBAS	'),
(387, '030403', '	COYLLURQUI	'),
(388, '030404', '	HAQUIRA	'),
(389, '030405', '	MARA	'),
(390, '030406', '	CHALLHUAHUACHO	'),
(391, '030500', '	GRAU	'),
(392, '030501', '	CHUQUIBAMBILLA	'),
(393, '030502', '	CURPAHUASI	'),
(394, '030503', '	GAMARRA (Palpacachi)	'),
(395, '030504', '	HUAYLLATI	'),
(396, '030505', '	MAMARA	'),
(397, '030506', '	MICAELA BASTIDAS (Ayrihuanca)	'),
(398, '030507', '	PATAYPAMPA	'),
(399, '030508', '	PROGRESO	'),
(400, '030509', '	SAN ANTONIO	'),
(401, '030510', '	SANTA ROSA	'),
(402, '030511', '	TURPAY	'),
(403, '030512', '	VILCABAMBA	'),
(404, '030513', '	VIRUNDO (San Juan de Virundo)	'),
(405, '030514', '	CURASCO	'),
(406, '030600', '	CHINCHEROS	'),
(407, '030601', '	CHINCHEROS	'),
(408, '030602', '	ANCO-HUALLO (Uripa)	'),
(409, '030603', '	COCHARCAS	'),
(410, '030604', '	HUACCANA	'),
(411, '030605', '	OCOBAMBA	'),
(412, '030606', '	ONGOY	'),
(413, '030607', '	URANMARCA	'),
(414, '030608', '	RANRACANCHA	'),
(415, '030700', '	ANDAHUAYLAS	'),
(416, '030701', '	ANDAHUAYLAS	'),
(417, '030702', '	ANDARAPA	'),
(418, '030703', '	CHIARA	'),
(419, '030704', '	HUANCARAMA	'),
(420, '030705', '	HUANCARAY	'),
(421, '030706', '	HUAYANA	'),
(422, '030707', '	KISHUARA	'),
(423, '030708', '	PACOBAMBA	'),
(424, '030709', '	PACUCHA	'),
(425, '030710', '	PAMPACHIRI	'),
(426, '030711', '	POMACOCHA	'),
(427, '030712', '	SAN ANTONIO DE CACHI	'),
(428, '030713', '	SAN JERONIMO	'),
(429, '030714', '	SAN MIGUEL DE CHACCRAMPA (Chaccrampa)	'),
(430, '030715', '	SANTA MARIA DE CHICMO	'),
(431, '030716', '	TALAVERA	'),
(432, '030717', '	TUMAY HUARACA (Umamarca)	'),
(433, '030718', '	TURPO	'),
(434, '030719', '	KAQUIABAMBA	');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preciosproducto`
--

DROP TABLE IF EXISTS `preciosproducto`;
CREATE TABLE IF NOT EXISTS `preciosproducto` (
  `iPreciosProductoId` int(11) NOT NULL AUTO_INCREMENT,
  `iProductoId` int(11) DEFAULT NULL,
  `iCantidadStock` int(11) DEFAULT NULL,
  `fPrecioCompra` float DEFAULT NULL,
  `fGanancia` float DEFAULT NULL,
  `fPrecioVenta` float DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iPreciosProductoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=85 ;

--
-- Volcar la base de datos para la tabla `preciosproducto`
--

INSERT INTO `preciosproducto` (`iPreciosProductoId`, `iProductoId`, `iCantidadStock`, `fPrecioCompra`, `fGanancia`, `fPrecioVenta`, `fDescuento`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(75, 42, 4, 5, 15, 5.75, 0, 2, 0, '2015-04-16 23:36:20', NULL, 'AC'),
(76, 43, 0, 120, 20, 144, 10, 2, 0, '2015-04-21 23:40:27', NULL, 'AC'),
(77, 44, 0, 0, 0, 0, 0, 2, 0, '2015-04-24 23:41:56', NULL, 'AC'),
(78, 45, 20, 20, 0, 251, 0, 2, 0, '2015-04-25 00:15:57', NULL, 'AC'),
(79, 46, 20, 20, 0, 252, 0, 2, 0, '2015-04-25 00:17:47', NULL, 'AC'),
(80, 47, 0, 200, 220, 640, 20, 2, 0, '2015-04-25 00:29:15', NULL, 'AC'),
(81, 48, 0, 21, 15242.9, 3222, 222, 2, 0, '2015-04-25 00:30:42', NULL, 'AC'),
(82, 49, 2321, 1, 0, 0, 2, 2, 0, '2015-04-25 00:35:50', NULL, 'AC'),
(83, 50, 1401, 250, 12, 280, 121, 2, 0, '2015-04-25 05:30:36', NULL, 'AC'),
(84, 51, 520, 20, 0, 0, 20, 2, 0, '2015-04-25 05:32:47', NULL, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `produccion`
--

DROP TABLE IF EXISTS `produccion`;
CREATE TABLE IF NOT EXISTS `produccion` (
  `iProduccionId` int(11) NOT NULL AUTO_INCREMENT,
  `iCantidad` int(11) DEFAULT NULL,
  `fCostoUni` float DEFAULT NULL,
  `fCostoTotal` float DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualiza` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `fOtrosCostos` float DEFAULT NULL,
  `vDescripcion` varchar(150) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`iProduccionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `produccion`
--

INSERT INTO `produccion` (`iProduccionId`, `iCantidad`, `fCostoUni`, `fCostoTotal`, `cEstadoCodigo`, `iUsuarioInsertaId`, `iUsuarioActualiza`, `dFechaInserta`, `dFechaActualiza`, `fOtrosCostos`, `vDescripcion`) VALUES
(1, 11, 250, 2750, 'AC', 2, 0, '2015-04-25 00:35:50', NULL, 0, 'DWDW');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producciondetalle`
--

DROP TABLE IF EXISTS `producciondetalle`;
CREATE TABLE IF NOT EXISTS `producciondetalle` (
  `iProduccionDetalleId` int(11) NOT NULL AUTO_INCREMENT,
  `iProductoId` int(11) DEFAULT NULL,
  `iCantidad` int(11) DEFAULT NULL,
  `vDescripcion` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fCostoUni` float DEFAULT NULL,
  `fTotal` float DEFAULT NULL,
  `iPersonalId` int(11) DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `iProduccionId` int(11) NOT NULL,
  `fDescuento` float DEFAULT NULL,
  PRIMARY KEY (`iProduccionDetalleId`),
  KEY `fk_produccion_iProduccionId` (`iProduccionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `producciondetalle`
--

INSERT INTO `producciondetalle` (`iProduccionDetalleId`, `iProductoId`, `iCantidad`, `vDescripcion`, `fCostoUni`, `fTotal`, `iPersonalId`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `iProduccionId`, `fDescuento`) VALUES
(1, 44, 11, 'MATERIA PRIMA', 250, 2750, NULL, 0, 0, NULL, NULL, 'AC', 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `iProductoId` int(11) NOT NULL AUTO_INCREMENT,
  `cProductoCodigo` char(7) NOT NULL,
  `vProductoNombre` varchar(45) NOT NULL,
  `vProductoCapacidad` varchar(11) DEFAULT NULL,
  `iProductoStockCantidad` int(11) DEFAULT NULL,
  `iProductoStockMaximo` int(11) DEFAULT NULL,
  `iProductoStockMinimo` int(11) DEFAULT NULL,
  `fProductoPrecioVenta` float NOT NULL,
  `fProductoGanancia` float DEFAULT NULL,
  `fProductoPrecioCompra` float NOT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iUnidadMedidadId` int(11) DEFAULT NULL,
  `iCategoriaId` int(11) DEFAULT NULL,
  `iProduccionId` int(11) DEFAULT NULL,
  `iUnidadMedidadIdC` int(11) DEFAULT NULL,
  `iMonedaId` int(11) DEFAULT NULL,
  `vUnidadMedidaDescripcionC` varchar(45) DEFAULT NULL,
  `iSubCategoriaId` int(11) DEFAULT NULL,
  `vfoto` varchar(45) DEFAULT NULL,
  `fProductoDescuento` float DEFAULT NULL,
  PRIMARY KEY (`iProductoId`),
  KEY `fk_producto_unidadMedida1` (`iUnidadMedidadId`),
  KEY `fk_producto_unidadMedidaC` (`iUnidadMedidadIdC`),
  KEY `fk_producto_moneda` (`iMonedaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=52 ;

--
-- Volcar la base de datos para la tabla `producto`
--

INSERT INTO `producto` (`iProductoId`, `cProductoCodigo`, `vProductoNombre`, `vProductoCapacidad`, `iProductoStockCantidad`, `iProductoStockMaximo`, `iProductoStockMinimo`, `fProductoPrecioVenta`, `fProductoGanancia`, `fProductoPrecioCompra`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `iUnidadMedidadId`, `iCategoriaId`, `iProduccionId`, `iUnidadMedidadIdC`, `iMonedaId`, `vUnidadMedidaDescripcionC`, `iSubCategoriaId`, `vfoto`, `fProductoDescuento`) VALUES
(42, 'PR00001', 'AA', '515', 1003, 0, 0, 5.75, 15, 5, 2, 0, '2015-04-16 23:36:20', NULL, 'AC', 7, 15, NULL, 0, 1, '', 3, '', 0),
(43, 'PR00043', 'SER', NULL, 0, 0, 0, 144, 20, 120, 2, 0, '2015-04-21 23:40:27', NULL, 'AC', NULL, 16, NULL, 0, 1, '', NULL, '', 10),
(44, 'PR00044', 'MATERIA PRIMA', '25ss', 39, 100, 25, 1200, 0, 250, 2, 2, '2015-04-24 23:41:56', '2015-04-24 23:42:30', 'AC', 7, 17, NULL, 7, 1, NULL, NULL, NULL, 0),
(45, 'PR00045', 'ENVASES', '21s', 20, 0, 0, 251, 0, 20, 2, 0, '2015-04-25 00:15:57', NULL, 'AC', 7, 18, NULL, 0, 1, NULL, NULL, NULL, 0),
(46, 'PR00046', 'DND', '200', 20, 0, 0, 252, 0, 20, 2, 0, '2015-04-25 00:17:47', NULL, 'AC', 7, 19, NULL, 0, 1, NULL, NULL, NULL, 0),
(47, 'PR00047', 'IJI', NULL, 0, 0, 0, 640, 220, 200, 2, 0, '2015-04-25 00:29:15', NULL, 'AC', NULL, 16, NULL, 0, 1, '', NULL, '', 20),
(48, 'PR00048', 'LK', NULL, 0, 0, 0, 3222, 15242.9, 21, 2, 0, '2015-04-25 00:30:42', NULL, 'AC', NULL, 16, NULL, 0, 1, '', NULL, '', 222),
(49, 'PR00049', ' DWWWFW', '12', 2321, 0, 0, 0, 0, 1, 2, 0, '2015-04-25 00:35:50', NULL, 'AC', 7, 15, 1, 0, 1, '', 3, NULL, 2),
(50, 'PR00050', 'PRODUCTO154', '212', 1401, 0, 0, 280, 12, 250, 2, 0, '2015-04-25 05:30:36', NULL, 'AC', 7, 15, NULL, 7, 1, 'CAJA', 3, '', 121),
(51, 'PR00051', 'PRO JBJBJB', '20', 520, 0, 0, 0, 0, 20, 2, 0, '2015-04-25 05:32:47', NULL, 'AC', 7, 15, NULL, 0, 1, '', 3, '', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `iProveedorId` int(11) NOT NULL AUTO_INCREMENT,
  `cProveedorCodigo` char(7) NOT NULL,
  `vProveedorRazonSocial` varchar(100) DEFAULT NULL,
  `vProveedorDireccion` varchar(45) NOT NULL,
  `vProveedorTelefono` varchar(15) DEFAULT NULL,
  `nProveedorNumeroDocumento` decimal(11,0) NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `iUsuarioModificaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iPoblacionId` varchar(6) NOT NULL,
  PRIMARY KEY (`iProveedorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`iProveedorId`, `cProveedorCodigo`, `vProveedorRazonSocial`, `vProveedorDireccion`, `vProveedorTelefono`, `nProveedorNumeroDocumento`, `iUsuarioInsertaId`, `iUsuarioModificaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `iPoblacionId`) VALUES
(1, 'PR00001', 'PROVEEDOR4', '4545', '4545', '45545', 2, 0, '2015-04-25 02:57:18', NULL, 'AC', '140501');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidaproducto`
--

DROP TABLE IF EXISTS `salidaproducto`;
CREATE TABLE IF NOT EXISTS `salidaproducto` (
  `iSalidaProductoId` int(11) NOT NULL AUTO_INCREMENT,
  `vSalidaProductoMotivo` varchar(45) NOT NULL,
  `dSalidaProductoFecha` date NOT NULL,
  `iCantidad` int(11) NOT NULL,
  `cSalidaProductoAutorizado` char(1) NOT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iProveedorId` int(11) NOT NULL,
  `iProductoId` int(11) NOT NULL,
  PRIMARY KEY (`iSalidaProductoId`),
  KEY `fk_salidaProducto_proveedor1` (`iProveedorId`),
  KEY `fk_salidaProducto_producto1` (`iProductoId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `salidaproducto`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `session`
--

DROP TABLE IF EXISTS `session`;
CREATE TABLE IF NOT EXISTS `session` (
  `iSessionId` int(11) NOT NULL AUTO_INCREMENT,
  `dSessionFechaInicio` date NOT NULL,
  `dSessionFechaFinal` date NOT NULL,
  `vSessionIp` varchar(45) NOT NULL,
  `iUsuarioId` int(11) NOT NULL,
  PRIMARY KEY (`iSessionId`),
  KEY `fk_session_usuario1` (`iUsuarioId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `session`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sexo`
--

DROP TABLE IF EXISTS `sexo`;
CREATE TABLE IF NOT EXISTS `sexo` (
  `iSexoId` int(11) NOT NULL AUTO_INCREMENT,
  `cSexoCodigo` char(1) NOT NULL,
  `vSexoDescripcion` varchar(9) NOT NULL,
  `cEstadoCodigo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iSexoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `sexo`
--

INSERT INTO `sexo` (`iSexoId`, `cSexoCodigo`, `vSexoDescripcion`, `cEstadoCodigo`) VALUES
(1, '1', 'FEMENINO', 'AC'),
(2, '2', 'MASCULINO', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategoria`
--

DROP TABLE IF EXISTS `subcategoria`;
CREATE TABLE IF NOT EXISTS `subcategoria` (
  `iSubCategoriaId` int(11) NOT NULL AUTO_INCREMENT,
  `iCategoriaId` int(11) DEFAULT NULL,
  `cSubCategoriaCodigo` char(7) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vSubCategoriaDescripcion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iSubCategoriaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `subcategoria`
--

INSERT INTO `subcategoria` (`iSubCategoriaId`, `iCategoriaId`, `cSubCategoriaCodigo`, `vSubCategoriaDescripcion`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(3, 15, 'SU00001', 'AA', 2, 0, '2015-04-16 23:35:52', NULL, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
CREATE TABLE IF NOT EXISTS `sucursal` (
  `iSucursalId` int(11) NOT NULL AUTO_INCREMENT,
  `vSucursalNombre` varchar(45) NOT NULL,
  `vSucursalDireccion` varchar(45) NOT NULL,
  `vSucursalTelefono` varchar(45) NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime NOT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `cSucursalCodigo` char(7) DEFAULT NULL,
  `iEmpresaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iSucursalId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`iSucursalId`, `vSucursalNombre`, `vSucursalDireccion`, `vSucursalTelefono`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `cSucursalCodigo`, `iEmpresaId`) VALUES
(2, 'Macroquimica del Peru', 'Av. pachacutec', '5485540', 1, NULL, '2010-12-18 00:00:00', NULL, 'Ac', NULL, 2),
(3, 'LOCAL AVIACION', 'av.klskld', '55544', 0, 0, '2015-01-26 00:00:00', '2015-01-31 00:00:00', 'AC', 'SU00003', 2),
(4, 'LOCAL SURCO', 'surco viejo', '54852', 0, 2, '2015-01-31 00:00:00', '2015-04-19 00:00:09', 'AC', 'SU00004', 2),
(6, 'LOZ', 'SS', 'S', 2, 0, '2015-04-17 00:02:45', NULL, 'AC', 'SU00005', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
CREATE TABLE IF NOT EXISTS `tipodocumento` (
  `iTipoDocumentoId` int(11) NOT NULL AUTO_INCREMENT,
  `cTipoDocumentoCodigo` char(2) NOT NULL,
  `vTipoDocuumentoDescripcion` varchar(45) NOT NULL,
  `vGestion` char(1) DEFAULT NULL,
  `cEstadoCodigo` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`iTipoDocumentoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcar la base de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`iTipoDocumentoId`, `cTipoDocumentoCodigo`, `vTipoDocuumentoDescripcion`, `vGestion`, `cEstadoCodigo`) VALUES
(1, 'DC', 'D.N.I', NULL, 'AC'),
(2, 'LM', 'LIBRETA MILITAR', NULL, 'AC'),
(3, 'DP', 'DOCUMENTO DE PASAPORTE', NULL, 'AC'),
(4, 'LE', 'CARNET DE EXTRANJERIA', NULL, 'AC'),
(6, 'RC', 'RUC', NULL, 'AC'),
(7, 'PN', 'PASAPORTE', NULL, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumentogestion`
--

DROP TABLE IF EXISTS `tipodocumentogestion`;
CREATE TABLE IF NOT EXISTS `tipodocumentogestion` (
  `iTipoDocumentoGestionId` int(11) NOT NULL AUTO_INCREMENT,
  `cTipoDocumentoGestionCodigo` char(2) NOT NULL,
  `vTipoDocumentoDescripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`iTipoDocumentoGestionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcar la base de datos para la tabla `tipodocumentogestion`
--

INSERT INTO `tipodocumentogestion` (`iTipoDocumentoGestionId`, `cTipoDocumentoGestionCodigo`, `vTipoDocumentoDescripcion`) VALUES
(1, 'FA', 'FACTURA'),
(3, 'BO', 'BOLETA'),
(7, 'NC', 'NOTA CREDITO'),
(8, 'ND', 'NOTA DEBITO'),
(9, 'GR', 'GUIA DE REMISION');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidadmedida`
--

DROP TABLE IF EXISTS `unidadmedida`;
CREATE TABLE IF NOT EXISTS `unidadmedida` (
  `iUnidadMedidaId` int(11) NOT NULL AUTO_INCREMENT,
  `cUnidadMedidaCodigo` varchar(5) NOT NULL,
  `vUnidadMedidaDescripcion` varchar(45) NOT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  PRIMARY KEY (`iUnidadMedidaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcar la base de datos para la tabla `unidadmedida`
--

INSERT INTO `unidadmedida` (`iUnidadMedidaId`, `cUnidadMedidaCodigo`, `vUnidadMedidaDescripcion`, `cEstadoCodigo`) VALUES
(1, 'kg', 'KILOGRAMO', 'AC'),
(2, 'Lt', 'LITRO', 'AC'),
(3, 'LTS', 'LITROS', 'AC'),
(5, 'Uni', 'GALON', 'AC'),
(6, 'Gr', 'GALONES', 'AC'),
(7, 'CJ', 'CAJA', 'AC'),
(8, 'CJS', 'CAJAS', 'AC'),
(9, 'UN', 'UNIDAD', 'AC'),
(10, 'UNDS', 'UNIDADES', 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `iUsuarioId` int(11) NOT NULL AUTO_INCREMENT,
  `cUsuarioCodigo` char(7) DEFAULT NULL,
  `vUsuarioLogin` varchar(20) NOT NULL,
  `vUsuarioPassword` varchar(10) NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iPerfilId` int(11) NOT NULL,
  `iPersonalId` int(11) NOT NULL,
  `iSucursalId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iUsuarioId`),
  KEY `fk_usuario_perfil1` (`iPerfilId`),
  KEY `fk_usuario_personal1` (`iPersonalId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

--
-- Volcar la base de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`iUsuarioId`, `cUsuarioCodigo`, `vUsuarioLogin`, `vUsuarioPassword`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `iPerfilId`, `iPersonalId`, `iSucursalId`) VALUES
(2, NULL, 'LFERNANDEZ', '123456', 0, NULL, NULL, '2015-01-31 00:00:00', 'AC', 3, 2, 3),
(10, NULL, 'SARITAFERNANDEZ', 'sarita2014', 0, 0, NULL, '2015-01-31 00:00:00', 'AC', 4, 14, 3),
(12, NULL, 'DCARPIO', '123456', 0, 0, '2014-03-13 00:00:00', '2015-02-15 00:00:00', 'AC', 5, 13, 4),
(23, NULL, 'DGONZALES', '123456', 0, 2, '2015-01-31 00:00:00', '2015-04-18 23:59:56', 'AC', 3, 15, 4),
(24, NULL, 'ROSSANA', '123456', 2, 2, '2015-04-21 23:20:33', '2015-04-21 23:20:44', 'AC', 2, 17, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

DROP TABLE IF EXISTS `venta`;
CREATE TABLE IF NOT EXISTS `venta` (
  `iVentaId` int(11) NOT NULL AUTO_INCREMENT,
  `nVentaNumero` varchar(50) NOT NULL,
  `dVentaFecha` date NOT NULL,
  `fVentaTotal` float NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iUsuarioId` int(11) NOT NULL,
  `iClienteId` int(11) NOT NULL,
  `idireccionClienteId` int(11) NOT NULL,
  `iTipoDocumentoId` int(11) NOT NULL,
  `iFormaPago` int(11) NOT NULL,
  `cVentaOrdenCompra` char(10) DEFAULT NULL,
  `nVentaRuc` char(11) DEFAULT NULL,
  `vVentaPuntoLlegada` varchar(120) DEFAULT NULL,
  `vPrincipal` varchar(1) DEFAULT NULL,
  `fVentaGanancia` decimal(5,2) NOT NULL,
  `vEstadoVenta` varchar(50) NOT NULL,
  `fVentaSubTotal` float NOT NULL,
  `fVentaIGV` float NOT NULL,
  `vEstadoDocumento` varchar(45) DEFAULT NULL,
  `dFechaTraslado` date DEFAULT NULL,
  `dFechaProximoPago` date DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `fMontoAdelantado` float DEFAULT NULL,
  `fVentaTotalReal` float DEFAULT NULL,
  `iNumeroDias` int(11) DEFAULT NULL,
  `iNumeroLetras` varchar(45) DEFAULT NULL,
  `IperiodoId` varchar(45) DEFAULT NULL,
  `iSucursalId` int(11) DEFAULT NULL,
  `fTipoCambio` float DEFAULT NULL,
  `iMonedaId` int(11) DEFAULT NULL,
  `fMontoPago` float DEFAULT NULL,
  `fMontoVuelto` float DEFAULT NULL,
  `vTipoPago` varchar(5) DEFAULT NULL,
  `fDescClienteVenta` float DEFAULT NULL,
  `vIncluyeIGV` varchar(5) DEFAULT NULL,
  `vTipoVenta` varchar(5) DEFAULT NULL,
  `vPorcentajeIGV` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iVentaId`),
  KEY `fk_venta_usuario1` (`iUsuarioId`),
  KEY `fk_venta_cliente1` (`iClienteId`),
  KEY `fk_venta_tipoDocumento1` (`iTipoDocumentoId`),
  KEY `fk_venta_formaPago1` (`iFormaPago`),
  KEY `fk_venta_direccion1` (`idireccionClienteId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=40 ;

--
-- Volcar la base de datos para la tabla `venta`
--

INSERT INTO `venta` (`iVentaId`, `nVentaNumero`, `dVentaFecha`, `fVentaTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iUsuarioId`, `iClienteId`, `idireccionClienteId`, `iTipoDocumentoId`, `iFormaPago`, `cVentaOrdenCompra`, `nVentaRuc`, `vVentaPuntoLlegada`, `vPrincipal`, `fVentaGanancia`, `vEstadoVenta`, `fVentaSubTotal`, `fVentaIGV`, `vEstadoDocumento`, `dFechaTraslado`, `dFechaProximoPago`, `fDescuento`, `fMontoAdelantado`, `fVentaTotalReal`, `iNumeroDias`, `iNumeroLetras`, `IperiodoId`, `iSucursalId`, `fTipoCambio`, `iMonedaId`, `fMontoPago`, `fMontoVuelto`, `vTipoPago`, `fDescClienteVenta`, `vIncluyeIGV`, `vTipoVenta`, `vPorcentajeIGV`) VALUES
(35, '0001-000001', '2015-04-16', 4.8875, 0, '2015-04-16 23:36:33', 0, NULL, 'AC', 2, 6, 6, 1, 5, '', NULL, 'AV.PUENTE', '1', '0.00', 'CANCELADO', 4.14, 0.75, 'CANCELADO', NULL, '2015-04-16', 0, 0, 5.75, 0, '1', '11', 3, 2.75, NULL, 0, 0, '$', 0.8625, 'siIgv', '$', '18'),
(36, '0001-000002', '2015-04-22', 14.6625, 0, '2015-04-22 00:06:32', 0, NULL, 'AC', 2, 6, 6, 1, 4, '', NULL, 'AV.PUENTE', '1', '0.00', 'DEUDA', 12.43, 2.24, 'DEVOLUCION TOTAL', NULL, '2015-05-22', 0, 0, 17.25, 30, '1', '11', 3, 2.75, NULL, 0, 0, '$', 2.5875, 'siIgv', '$', '18'),
(37, '0001-000003', '2015-04-22', 4.8875, 0, '2015-04-22 00:07:07', 0, NULL, 'AC', 2, 6, 6, 1, 6, '', NULL, 'AV.PUENTE', '1', '0.00', 'DEUDA', 4.14, 0.75, 'CANCELADO', NULL, '2015-05-22', 0, 0, 5.75, 30, '1', '11', 3, 2.75, NULL, 0, 0, '$', 0.8625, 'siIgv', '$', '18'),
(38, '2154151', '2015-04-25', 15, 0, '2015-04-25 01:16:05', 0, NULL, 'AC', 2, 6, 0, 1, 2, NULL, NULL, 'AV.PUENTE', '0', '0.00', 'CANCELADO', 0, 0, 'CANCELADO', NULL, NULL, 0, 0, 0, 0, '0', '11', 3, 0, NULL, 0, 0, NULL, 0, NULL, NULL, '18'),
(39, '545', '2015-04-25', 25, 0, '2015-04-25 01:18:26', 0, NULL, 'AC', 2, 7, 0, 1, 2, NULL, NULL, 'FEEEV54/', '0', '0.00', 'DEUDA', 0, 0, 'DEUDA', NULL, NULL, 0, 0, 0, 0, '0', '11', 3, 0, NULL, 0, 0, NULL, 0, NULL, NULL, '18');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventadetalle`
--

DROP TABLE IF EXISTS `ventadetalle`;
CREATE TABLE IF NOT EXISTS `ventadetalle` (
  `iVentaDetalleId` int(11) NOT NULL AUTO_INCREMENT,
  `fVentaDetallePrecio` float NOT NULL,
  `iVentaDetalleCantidad` int(11) NOT NULL,
  `fVentaDetalleTotal` float NOT NULL,
  `iUsuarioInsertaId` int(11) NOT NULL,
  `dFechaInserta` datetime NOT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iProductoId` int(11) NOT NULL,
  `iVentaId` int(11) NOT NULL,
  `fDescuento` float DEFAULT NULL,
  `iPersonalId` int(11) DEFAULT NULL,
  `iSubCta` int(11) DEFAULT NULL,
  PRIMARY KEY (`iVentaDetalleId`),
  KEY `fk_ventaDetalle_producto1` (`iProductoId`),
  KEY `fk_ventaDetalle_venta1` (`iVentaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=38 ;

--
-- Volcar la base de datos para la tabla `ventadetalle`
--

INSERT INTO `ventadetalle` (`iVentaDetalleId`, `fVentaDetallePrecio`, `iVentaDetalleCantidad`, `fVentaDetalleTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iProductoId`, `iVentaId`, `fDescuento`, `iPersonalId`, `iSubCta`) VALUES
(35, 5.75, 1, 5.75, 2, '2015-04-16 23:36:33', 0, NULL, 'AC', 42, 35, 0, NULL, 0),
(36, 5.75, 3, 17.25, 2, '2015-04-22 00:06:32', 0, NULL, 'AC', 42, 36, 0, NULL, 0),
(37, 5.75, 1, 5.75, 2, '2015-04-22 00:07:07', 0, NULL, 'AC', 42, 37, 0, NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventadevolucion`
--

DROP TABLE IF EXISTS `ventadevolucion`;
CREATE TABLE IF NOT EXISTS `ventadevolucion` (
  `iVentaDevolucionId` int(11) NOT NULL AUTO_INCREMENT,
  `iVentaId` int(11) DEFAULT NULL,
  `dVentaDevFecha` date DEFAULT NULL,
  `fVentaDevTotal` float DEFAULT NULL,
  `fVentaDevSubTotal` float DEFAULT NULL,
  `fVentaDevIGV` float DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  `nNroNotaCredito` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iTipoDocumentoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iVentaDevolucionId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `ventadevolucion`
--

INSERT INTO `ventadevolucion` (`iVentaDevolucionId`, `iVentaId`, `dVentaDevFecha`, `fVentaDevTotal`, `fVentaDevSubTotal`, `fVentaDevIGV`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `fDescuento`, `iPeriodoId`, `nNroNotaCredito`, `iTipoDocumentoId`) VALUES
(1, 36, '2015-04-25', 14.6625, 14.6625, 2.24, 2, '2015-04-25 06:08:02', 0, NULL, 'AC', 0, 0, 'N0001-00001', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventadevoluciondetalle`
--

DROP TABLE IF EXISTS `ventadevoluciondetalle`;
CREATE TABLE IF NOT EXISTS `ventadevoluciondetalle` (
  `iVentaDevolucionDetalleId` int(11) NOT NULL AUTO_INCREMENT,
  `iVentaDevolucionId` int(11) DEFAULT NULL,
  `iProductoId` int(11) DEFAULT NULL,
  `fVentaDevDetallePrecio` float DEFAULT NULL,
  `iVentaDevDetalleCantidad` int(11) DEFAULT NULL,
  `fVentaDevDetalleTotal` float DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `iSubCta` int(11) DEFAULT NULL,
  PRIMARY KEY (`iVentaDevolucionDetalleId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `ventadevoluciondetalle`
--

INSERT INTO `ventadevoluciondetalle` (`iVentaDevolucionDetalleId`, `iVentaDevolucionId`, `iProductoId`, `fVentaDevDetallePrecio`, `iVentaDevDetalleCantidad`, `fVentaDevDetalleTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `fDescuento`, `iSubCta`) VALUES
(1, 1, 42, 5.75, 3, 17.25, 0, '2015-04-25 06:08:02', 0, NULL, 'AC', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `via`
--

DROP TABLE IF EXISTS `via`;
CREATE TABLE IF NOT EXISTS `via` (
  `iViaId` int(11) NOT NULL,
  `vAbreviatura` varchar(5) DEFAULT NULL,
  `vDescripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iViaId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `via`
--

INSERT INTO `via` (`iViaId`, `vAbreviatura`, `vDescripcion`) VALUES
(1, 'CA.', 'CALLE'),
(2, 'JR.', 'JIRON'),
(3, 'AV.', 'AVENIDA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visitacliente`
--

DROP TABLE IF EXISTS `visitacliente`;
CREATE TABLE IF NOT EXISTS `visitacliente` (
  `iVisitaClienteId` int(11) NOT NULL AUTO_INCREMENT,
  `iClienteId` int(11) DEFAULT NULL,
  `dFechaVisista` date NOT NULL,
  `dFecaProxVisita` date DEFAULT NULL,
  `dHoraVisita` time DEFAULT NULL,
  `vMotivoVisita` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vProductoOfrecido` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fPrecioPactado` float NOT NULL,
  `vObservacion` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` datetime DEFAULT NULL,
  `dFechaActualiza` datetime DEFAULT NULL,
  PRIMARY KEY (`iVisitaClienteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `visitacliente`
--


--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `cuota`
--
ALTER TABLE `cuota`
  ADD CONSTRAINT `fk_cuota_venta1` FOREIGN KEY (`iVentaId`) REFERENCES `venta` (`iVentaId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ingresoproductodetalle`
--
ALTER TABLE `ingresoproductodetalle`
  ADD CONSTRAINT `fk_ingresoProductoDetalle_ingresoProducto1` FOREIGN KEY (`iIngresoProductoId`) REFERENCES `ingresoproducto` (`iIngresoProductoId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ingresoProductoDetalle_producto1` FOREIGN KEY (`iProductoId`) REFERENCES `producto` (`iProductoId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_moneda` FOREIGN KEY (`iMonedaId`) REFERENCES `moneda` (`iMonedaId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_unidadMedida1` FOREIGN KEY (`iUnidadMedidadId`) REFERENCES `unidadmedida` (`iUnidadMedidaId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `salidaproducto`
--
ALTER TABLE `salidaproducto`
  ADD CONSTRAINT `fk_salidaProducto_producto1` FOREIGN KEY (`iProductoId`) REFERENCES `producto` (`iProductoId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_salidaProducto_proveedor1` FOREIGN KEY (`iProveedorId`) REFERENCES `proveedor` (`iProveedorId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `fk_session_usuario1` FOREIGN KEY (`iUsuarioId`) REFERENCES `usuario` (`iUsuarioId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `diasMes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `diasMes`(
mes int, anio int )
BEGIN
DECLARE  m INT;	 
	 if(mes=4|| mes=6||mes=9||mes=11)then
	      set  m=30;
   end if;
   if(mes=2)then
	       
	        /**para cuando el aÃƒÂ±o es bisiesto*/
	        if ((anio % 4 = 0) && ((anio % 100 != 0) || (anio % 400 = 0)))then /*si el aÃƒÂ±o es bisiesto es divisible entre 4 y 100 o 400*/
	             set  m=29;            
	       else
	          set  m=28 ;/*queda pendiente para aÃƒÂ±o bisiesto*/	     
         end if ;
   else /*todos los demas meses*/
	      set  m=31; 
     end if;
	 select  m;
END$$

DROP PROCEDURE IF EXISTS `SP_CALCULO_CODIGO`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_CALCULO_CODIGO`(tabla varchar(45))
BEGIN
     DECLARE codigo varchar(7);
     DECLARE valor  varchar(4);
     DECLARE id int;
     DECLARE iTablaId varchar(45);
     SET @idS = 0;
     SET iTablaId = CONCAT('i',tabla,'Id');
     SET @iTablaId = iTablaId;
     
     
      SET @SQ = CONCAT("SELECT COALESCE(max(",iTablaId,"+1), 1) INTO @id FROM ",tabla);    
      PREPARE stmt FROM @SQ ;
      EXECUTE stmt;
     /* SELECT @SQ;*/
      SET id=@id;
       
     
    IF(id<9)THEN
       SET valor = "0000";
    ELSE IF(id<99) THEN
        SET valor = "000";
       ELSE IF(id<999) THEN
           SET valor = "00";
         ELSE IF(id<999) THEN
              SET valor = "0";
          ELSE
              SET valor = "";
          END IF;
        END IF;
      END IF;
    END IF;
     SET codigo=concat(UPPER(substring(tabla, 1,2)),valor,id); 
     SELECT codigo; 
    END$$

DROP PROCEDURE IF EXISTS `SP_IDU_COMPRA_CONTABILIDAD`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_IDU_COMPRA_CONTABILIDAD`(  
    IN xId int, /**key de las compras**/
    IN xfechaProximoPago date,
    IN xfMontoAdelantado float,
    IN xiUsuarioId        INT,
    IN xnumeroLetras INT,
    IN xnumeroDias INT,
    IN xMode varchar(10),
    IN xiPeriodoId INT,
    IN numeroLetra INT,
    IN xiFormaPagoId int
    )
BEGIN
     DECLARE x INT;
     DECLARE numeroFactura varchar(24);
     DECLARE subTotal  float;
     DECLARE igv  float;
     DECLARE total  float;
       
     DECLARE xiProveedorId int;
     DECLARE tipoDocumento varchar(24);
     DECLARE fechaVencimiento Date;
     DECLARE importeLetra float;
     DECLARE xProximoiPeriodoId int;
     SET x = numeroLetra;
     SET fechaVencimiento = xfechaProximoPago;
   

   
       
       SELECT nIngresoProductoNumero INTO numeroFactura FROM ingresoProducto WHERE iIngresoProductoId = xId  ;
       SELECT fIngresoProductoSubTotal INTO subTotal FROM ingresoProducto  WHERE iIngresoProductoId = xId ;
       SELECT fIngresoProductoIGV  INTO igv FROM ingresoProducto  WHERE iIngresoProductoId = xId ;
       SELECT fIngresoProductoTotal INTO total FROM ingresoProducto  WHERE iIngresoProductoId = xId ;
       SELECT vTipoDocumentoDescripcion INTO tipoDocumento FROM tipodocumentogestion 
                    WHERE iTipoDocumentoGestionId = (SELECT iTipoDocumentoId FROM  ingresoProducto 
                                                     WHERE iIngresoProductoId = xId)  ; 
     /*  SELECT iFormaPagoId INTO xiFormaPagoId FROM ingresoProducto  WHERE iIngresoProductoId = xId ; */
       SELECT iProveedorId INTO xiProveedorId FROM ingresoProducto WHERE iIngresoProductoId  = xId ;
       
       
       IF(xMode='I') THEN
       /****************/
       /**ASIENTO NÃƒâ€šÃ‚Â°1 **/
       /****************/	      	   
				/**Agregamos al Libro Diario las compras realizadas del producto
				 *
				 * 60(Compras) y
				 * 601(Mercaderias)
				 * id=220; COMPRAS / MERCADERIA**/
         INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoId,vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(220,subTotal,'D',xiUsuarioId, NOW(), 'AC',CONCAT('COMPRA/ Mercaderia / NRO de ',tipoDocumento,': ',numeroFactura),xId,'ASIENTO N1','0',xiPeriodoId);
				
				/**Agregamos al Libro Diario el tributo por pagar				 
				 * 40(TRIBUTOS  POR PAGAR) 
				 * 401(Gobierno central)
				 * id=168', '4', '4011', 'IGV-Inpuesto general a la venta'*/
          INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(168,igv,'D',xiUsuarioId, NOW(), 'AC',CONCAT('TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de ',tipoDocumento,': ',numeroFactura),
         xId,'ASIENTO N1','0',xiPeriodoId); 
         /**Agregamos al Libro Diario las facturas de las pagar de las compras realizadas
				 * 42(PROVEEDORES) y
				 * 421(Facturas Por Pagar)
				 * id= '199', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/
				  INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(199,total,'H',xiUsuarioId, NOW(), 'AC','PROVEEDORES / Facturas, boletas y otros comprobantes por pagar',
         xId,'ASIENTO N1','0',xiPeriodoId);
                
                
         /****************/
         /**ASIENTO NÃƒâ€šÃ‚Â°2 **/
         /****************/
				
				/**Insertamos en el libro Diario la cuenta de Mercaderia 
				 * 20(Mercaderia) y
				 * 201(Almacem)
				 * id=57; 201: mercaderia/ Almacen**/    
				INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(57,subTotal,'D',xiUsuarioId, NOW(), 'AC',CONCAT('MERCADERIA / Almacen / NRO de',tipoDocumento,': ',numeroFactura),xId
         ,'ASIENTO N2','0',xiPeriodoId);
				/**Insertamos en el libro Dirio la cuenta de variacion de existencias
				 * 20(Mercaderia) y
				 * 61(VARIACION DE EXISTENCIAS')
				 * 611(Mercaderia)
				 * id='225', '6', '611', 'Mercaderias'**/
         	INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(225,subTotal,'H',xiUsuarioId, NOW(), 'AC',CONCAT('VARIACION DE EXISTENCIAS / Mercaderia / NRO de',tipoDocumento,': ',numeroFactura),xId,
         'ASIENTO N2','0',xiPeriodoId);
			                                
           /****************/
           /**ASIENTO NÃƒâ€šÃ‚Â°3 **/
           /****************/
           
            /**Agregamos al Libro Diario las facturas de las pagar de las compras realizadas
             * 42(PROVEEDORES) y
             * 421(Facturas Por Pagar)
             * id= '199', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/    
              INSERT INTO Librodiario(
             iCuentasId,fMonto,vTipoConcepto,
             iUsuarioInsertaId,dFechaInserta,
             cEstadoCodigo,vConceptoGeneral,
             iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
             VALUES(199,total,'D',xiUsuarioId, NOW(), 'AC','PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ',xId,'ASIENTO 3','0',xiPeriodoId);
              
             /**Pago al contado**/
             IF xiFormaPagoId=1 THEN 
              
                   /**Cambiamos el estado del documento**/
                   UPDATE IngresoProducto set vEstadoDocumento='CANCELADO' where iIngresoProductoId = xId;
                   
                   /**Registro de estado Cuenta proveedor**/             
                   INSERT INTO Estadocuentaproveedor(fMontoPago,
                   dFechaPago,dFechaInserta,
                   iUsuarioInsertaId,cEstadoCodigo,
                   iProveedorId,iIngresoProductoId)
                   VALUES(total,NOW(),NOW(),xiUsuarioId,'AC',xiProveedorId,xId);
                   
                 
                  /**Insertamos en el libro Diario la salidae Caja y Banco para el pago al proveedor**/
                  /**Agregamos al libro dirario la salida de caja 
                         * 10(CAJA Y BANCOS) y
                         * 101(Caja)
                         * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la compra de la mercaderia de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura)
                 ,xId,'ASIENTO N3','1',xiPeriodoId);
                  
             END IF; 
            /**Pago al credito**/ 
            IF xiFormaPagoId=2 ||  xiFormaPagoId=3 ||  xiFormaPagoId=4 THEN 
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(xfechaProximoPago) and MONTHNAME(DFECHAINICIO)=MONTHNAME(xfechaProximoPago) ;
            
               IF(xfMontoAdelantado !=0) THEN 
               
                  /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,(total-xfMontoAdelantado),'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la compra al vencimiento de la',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
                 /**Cambiamos el estado del documento**/
                 /**Registro de estado Cuenta proveedor**/             
               INSERT INTO Estadocuentaproveedor(fMontoPago,dFechaPago,dFechaInserta, iUsuarioInsertaId,cEstadoCodigo,iProveedorId,iIngresoProductoId)
               VALUES(xfMontoAdelantado,NOW(),NOW(),xiUsuarioId,'AC',xiProveedorId,xId);
          
                 /**Cambiamos el estado del documento**/
                 UPDATE IngresoProducto set vEstadoDocumento='DEUDA' where iIngresoProductoId = xId;
               
               
               ELSE 
                 
                /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago del anticipo en la compra de mercaderÃƒÆ’Ã‚Â­a de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
               /**Cambiamos el estado del documento**/
                 UPDATE IngresoProducto set vEstadoDocumento='DEUDA' where iIngresoProductoId = xId;
               
                END IF;
            END IF; 
             /**Pago en letras **/ 
            IF xiFormaPagoId=5 ||  xiFormaPagoId=6 THEN 
              
              SET importeLetra = total/xnumeroLetras;
              
              
              
             /**Insertamos en letrasProveedor **/
             WHILE x  <= xnumeroLetras DO 
             
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(fechaVencimiento) and MONTHNAME(DFECHAINICIO)=MONTHNAME(fechaVencimiento) ;
            
            
                INSERT INTO letraProveedor (iProveedorId,nNumeroLetra,nNumeroUnico, dFechaGiro, dFechaVencimiento, nImporte, dFechaInserta,iUsuarioInsertaId,vEstadoLetra,cEstadoCodigo,iIngresoProductoId) 
                values(xiProveedorId,x,'',NOW(),fechaVencimiento,importeLetra,NOW(),xiUsuarioId,'DEUDA','AC',xId);
                SET fechaVencimiento = ADDDATE(fechaVencimiento,xnumeroDias);
                
                /**Cambiamos el estado del documento**/
                 UPDATE IngresoProducto set vEstadoDocumento='DEUDA' where iIngresoProductoId = xId;
                 
              /**Agregamos al libro dirario la salida de caja 
                 * 42 (PROVEEDORES)
                 * id=201, '4', '423', 'Letras por pagar'*/

                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(201,importeLetra,'H',xiUsuarioId, NOW(), 'AC',CONCAT('PROVEEDORES/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
                SET  x = x + 1; 
                set fechaVencimiento=ADDDATE(fechaVencimiento,  xnumeroDias );
                END WHILE;
            END IF;            
         END IF;
         
         /***************************/
         /* ACTUALIZAR LIBRO DIARIO */
         /*************************/
         
         IF(xMode='U') THEN
       /****************/
       /**ASIENTO NÃƒâ€šÃ‚Â°1 **/
       /****************/	      	   
				/**Agregamos al Libro Diario las compras realizadas del producto
				 *
				 * 60(Compras) y
				 * 601(Mercaderias)
				 * id=220; COMPRAS / MERCADERIA**/
         UPDATE Librodiario SET
         fMonto=subTotal,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('COMPRA/ Mercaderia / NRO de ',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=220 AND iIngresoProductoId= xId AND iPeriodoId=xiPeriodoId;
       	
				/**Agregamos al Libro Diario el tributo por pagar				 
				 * 40(TRIBUTOS  POR PAGAR) 
				 * 401(Gobierno central)
				 * id=168', '4', '4011', 'IGV-Inpuesto general a la venta'*/
         UPDATE Librodiario SET
         fMonto=igv,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de ',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=168 AND iIngresoProductoId= xId AND iPeriodoId=xiPeriodoId;       	
    
         /**Agregamos al Libro Diario las facturas de las pagar de las compras realizadas
				 * 42(PROVEEDORES) y
				 * 421(Facturas Por Pagar)
				 * id= '199', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/
         UPDATE Librodiario SET
         fMonto=total,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral='PROVEEDORES / Facturas, boletas y otros comprobantes por pagar',
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=199 AND iIngresoProductoId= xId AND iPeriodoId=xiPeriodoId;
         
                
         /****************/
         /**ASIENTO NÃƒâ€šÃ‚Â°2 **/
         /****************/
				
				/**Insertamos en el libro Diario la cuenta de Mercaderia 
				 * 20(Mercaderia) y
				 * 201(Almacem)
				 * id=57; 201: mercaderia/ Almacen**/
        UPDATE Librodiario SET
         fMonto=subTotal,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('MERCADERIA / Almacen / NRO de',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=57 AND iIngresoProductoId= xId AND iPeriodoId=xiPeriodoId;
         
				 /**Insertamos en el libro Dirio la cuenta de variacion de existencias
				 * 20(Mercaderia) y
				 * 61(VARIACION DE EXISTENCIAS')
				 * 611(Mercaderia)
				 * id='225', '6', '611', 'Mercaderias'**/
         UPDATE Librodiario SET
         fMonto=subTotal,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('VARIACION DE EXISTENCIAS / Mercaderia / NRO de',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=255 AND iIngresoProductoId= xId AND iPeriodoId=xiPeriodoId;
     
                                        
           /****************/
           /**ASIENTO NÃƒâ€šÃ‚Â°3 **/
           /****************/
           
            /**Agregamos al Libro Diario las facturas de las pagar de las compras realizadas
             * 42(PROVEEDORES) y
             * 421(Facturas Por Pagar)
             * id= '199', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/  
             UPDATE Librodiario SET
             fMonto=total,
             iUsuarioActualizaId=xiUsuarioId,
             dFechaActualiza=NOW(),
             vConceptoGeneral='PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ',
             iPeriodoId=xiPeriodoId
             WHERE iCuentasId=199 AND iIngresoProductoId= xId AND iPeriodoId=xiPeriodoId;
        
             /**Pago al contado**/
             IF xiFormaPagoId=1 THEN 
              
              /************************************************************/
              /** cambiamos de esta a eliminado  QUE SE INSERTO EN ESTADO CUENTA PROVEEDOR**/              
              UPDATE  Estadocuentaproveedor SET cEstadoCodigo='EL' WHERE iIngresoProductoId=xId;
              UPDATE  Librodiario SET cEstadoCodigo='EL' WHERE iIngresoProductoId=xId AND iPeriodoId=xiPeriodoId
                        AND iCuentasId=2 AND vTipoConcepto='H';
              
                   
                   /**Cambiamos el estado del documento**/
                   UPDATE IngresoProducto set vEstadoDocumento='CANCELADO' where iIngresoProductoId = xId;
                   
                   /**Registro de estado Cuenta proveedor**/             
                   INSERT INTO Estadocuentaproveedor(fMontoPago,
                   dFechaPago,dFechaInserta,
                   iUsuarioInsertaId,cEstadoCodigo,
                   iProveedorId,iIngresoProductoId)
                   VALUES(total,NOW(),NOW(),xiUsuarioId,'AC',xiProveedorId,xId);
                   
                 
                  /**Insertamos en el libro Diario la salidae Caja y Banco para el pago al proveedor**/
                  /**Agregamos al libro dirario la salida de caja 
                         * 10(CAJA Y BANCOS) y
                         * 101(Caja)
                         * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la compra de la mercaderia de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura)
                 ,xId,'ASIENTO N3','1',xiPeriodoId);
                  
             END IF; 
            /**Pago al credito**/ 
            IF xiFormaPagoId=2 ||  xiFormaPagoId=3 ||  xiFormaPagoId=4 THEN 
            
              /************************************************************/
              /** cambiamos de esta a eliminado  QUE SE INSERTO EN ESTADO CUENTA PROVEEDOR**/              
              UPDATE  Estadocuentaproveedor SET cEstadoCodigo='EL' WHERE iIngresoProductoId=xId;
              UPDATE  Librodiario SET cEstadoCodigo='EL' WHERE iIngresoProductoId=xId AND iPeriodoId=xiPeriodoId
                        AND iCuentasId=2 AND vTipoConcepto='H';
          
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(xfechaProximoPago) and MONTHNAME(DFECHAINICIO)=MONTHNAME(xfechaProximoPago) ;
            
               IF(xfMontoAdelantado !=0) THEN 
               
                  /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,(total-xfMontoAdelantado),'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la compra al vencimiento de la',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
                 /**Cambiamos el estado del documento**/
                 /**Registro de estado Cuenta proveedor**/             
               INSERT INTO Estadocuentaproveedor(fMontoPago,dFechaPago,dFechaInserta, iUsuarioInsertaId,cEstadoCodigo,iProveedorId,iIngresoProductoId)
               VALUES(xfMontoAdelantado,NOW(),NOW(),xiUsuarioId,'AC',xiProveedorId,xId);
          
                 /**Cambiamos el estado del documento**/
                 UPDATE IngresoProducto set vEstadoDocumento='DEUDA' where iIngresoProductoId = xId;
               
               
               ELSE 
                 
                /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago del anticipo en la compra de mercaderÃƒÆ’Ã‚Â­a de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
               /**Cambiamos el estado del documento**/
                 UPDATE IngresoProducto set vEstadoDocumento='DEUDA' where iIngresoProductoId = xId;
               
                END IF;
            END IF; 
             /**Pago en letras **/ 
            IF xiFormaPagoId=5 ||  xiFormaPagoId=6 THEN 
              
              /************************************************************/
              /** cambiamos de esta a eliminado  QUE SE INSERTO EN ESTADO CUENTA PROVEEDOR**/              
              UPDATE  letraProveedor SET cEstadoCodigo='EL' WHERE iIngresoProductoId=xId;
              UPDATE  Librodiario SET cEstadoCodigo='EL' WHERE iIngresoProductoId=xId AND iPeriodoId=xiPeriodoId
                        AND iCuentasId=201 AND vTipoConcepto='H';
              
              SET importeLetra = total/xnumeroLetras;                          
             /**Insertamos en letrasProveedor **/
             WHILE x  <= xnumeroLetras DO 
             
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(fechaVencimiento) and MONTHNAME(DFECHAINICIO)=MONTHNAME(fechaVencimiento) ;
            
            /**INSERTAMOS LETRAS**/
                INSERT INTO letraProveedor (iProveedorId,nNumeroLetra,nNumeroUnico, dFechaGiro, dFechaVencimiento, nImporte, dFechaInserta,iUsuarioInsertaId,vEstadoLetra,cEstadoCodigo,iIngresoProductoId) 
                values(xiProveedorId,x,'',NOW(),fechaVencimiento,importeLetra,NOW(),xiUsuarioId,'DEUDA','AC',xId);
               
               SET fechaVencimiento = ADDDATE(fechaVencimiento,xnumeroDias);
                
                /**Cambiamos el estado del documento**/
                 UPDATE IngresoProducto set vEstadoDocumento='DEUDA' where iIngresoProductoId = xId;
                 
              /**Agregamos al libro dirario la salida de caja 
                 * 42 (PROVEEDORES)
                 * id=201, '4', '423', 'Letras por pagar'*/

                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(201,importeLetra,'H',xiUsuarioId, NOW(), 'AC',CONCAT('PROVEEDORES/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
                SET  x = x + 1; 
                set fechaVencimiento=ADDDATE(fechaVencimiento,  xnumeroDias );
                END WHILE;
            END IF;
            
        
         
         END IF;
         
          Select * from IngresoProducto where iIngresoProductoId = xId;
                 
    END$$

DROP PROCEDURE IF EXISTS `SP_IDU_DEVCOMPRA_CONTABILIDAD`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_IDU_DEVCOMPRA_CONTABILIDAD`(  
    IN xId int, /**key de las compras**/
    IN xiUsuarioId        INT,  
    IN xMode varchar(10),
    IN xNroNotaDebito varchar(10),
    IN xiPeriodoId INT
    )
BEGIN
     DECLARE x INT;
     DECLARE numeroFactura varchar(24);
     DECLARE subTotal  float;
     DECLARE igv  float;
     DECLARE total  float;
       
     DECLARE xiProveedorId int;
     DECLARE tipoDocumento varchar(24);
     DECLARE fechaVencimiento Date;
     DECLARE importeLetra float;
     DECLARE xProximoiPeriodoId int;
     DECLARE xiIngresoProducto int;
     SET x = 1;
     SET fechaVencimiento = now();
   

       SELECT iIngresoProductoId INTO xiIngresoProducto FROM  IngresoProductoDevolucion WHERE iIngresoProductoDevolucionId = xId  ;
       
       SELECT nIngresoProductoNumero INTO numeroFactura FROM IngresoProducto WHERE iIngresoProductoId =  xiIngresoProducto  ;
       
       
       SELECT fIngresoProductoDevSubTotal INTO subTotal FROM IngresoProductoDevolucion  WHERE iIngresoProductoDevolucionId = xId ;
       SELECT fIngresoProductoDevIGV  INTO igv FROM IngresoProductoDevolucion  WHERE iIngresoProductoDevolucionId = xId ;
       SELECT fIngresoProductoDev INTO total FROM IngresoProductoDevolucion  WHERE iIngresoProductoDevolucionId = xId ;
       SELECT vTipoDocumentoDescripcion INTO tipoDocumento FROM tipodocumentogestion 
                    WHERE iTipoDocumentoGestionId = (SELECT iTipoDocumentoId FROM  IngresoProductoDevolucion 
                                                     WHERE iIngresoProductoDevolucionId = xId)  ; 
     /*  SELECT iFormaPagoId INTO xiFormaPagoId FROM IngresoProductoDevolucion  WHERE iIngresoProductoDevolucionId = xId ; */
     /*  SELECT iProveedorId INTO xiProveedorId FROM IngresoProductoDevolucion WHERE iIngresoProductoDevolucionId  = xId ;*/
       
       
       IF(xMode='I') THEN
       /****************/
       /**ASIENTO NÃƒâ€šÃ‚Â°1 **/
        /****************/	      	   
				/**Agregamos al Libro Diario las compras realizadas del producto
				 *
				 * 60(Compras) y
				 * 601(Mercaderias)
				 * id=220; COMPRAS / MERCADERIA**/
         INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoDevolucionId,vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(220,subTotal,'H',xiUsuarioId, NOW(), 'AC',CONCAT('POR LA DEVOLUCION/ Mercaderia / NRO de ',tipoDocumento,': ',numeroFactura,' NRO de Nota Debito:', xNroNotaDebito ),xId,'ASIENTO N1','0',xiPeriodoId);
				
				/**Agregamos al Libro Diario el tributo por pagar				 
				 * 40(TRIBUTOS  POR PAGAR) 
				 * 401(Gobierno central)
				 * id=168', '4', '4011', 'IGV-Inpuesto general a la venta'*/
          INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(168,igv,'H',xiUsuarioId, NOW(), 'AC',CONCAT('TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de ',tipoDocumento,': ',numeroFactura),
         xId,'ASIENTO N1','0',xiPeriodoId); 
         /**Agregamos al Libro Diario las facturas de las pagar de las compras realizadas
				 * 42(PROVEEDORES) y
				 * 421(Facturas Por Pagar)
				 * id= '199', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/
				  INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(199,total,'D',xiUsuarioId, NOW(), 'AC','PROVEEDORES / Facturas, boletas y otros comprobantes por pagar',
         xId,'ASIENTO N1','0',xiPeriodoId);
                
                
         /****************/
         /**ASIENTO NÃƒâ€šÃ‚Â°2 **/
         /****************/
				
				/**Insertamos en el libro Diario la cuenta de Mercaderia 
				 * 20(Mercaderia) y
				 * 201(Almacem)
				 * id=57; 201: mercaderia/ Almacen**/    
				INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(57,subTotal,'H',xiUsuarioId, NOW(), 'AC',CONCAT('MERCADERIA / Almacen / NRO de',tipoDocumento,': ',numeroFactura),xId
         ,'ASIENTO N2','0',xiPeriodoId);
				/**Insertamos en el libro Dirio la cuenta de variacion de existencias
				 * 20(Mercaderia) y
				 * 61(VARIACION DE EXISTENCIAS')
				 * 611(Mercaderia)
				 * id='225', '6', '611', 'Mercaderias'**/
         	INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(225,subTotal,'D',xiUsuarioId, NOW(), 'AC',CONCAT('VARIACION DE EXISTENCIAS / Mercaderia / NRO de',tipoDocumento,': ',numeroFactura),xId,
         'ASIENTO N2','0',xiPeriodoId);
			                                
           /*****************/
           /**ASIENTO NÃƒâ€šÃ‚Â°3 **/
           /*****************/           
                  
             /**Pago al contado**/
             /*IF xiFormaPagoId=1 THEN 
              
                   /**Cambiamos el estado del documento**/
                 /*  UPDATE IngresoProductoDevolucion set vEstadoDocumento='CANCELADO' where iIngresoProductoDevolucionId = xId;
                   
                   /**Registro de estado Cuenta proveedor**/             
                 /*  INSERT INTO Estadocuentaproveedor(fMontoPago,
                   dFechaPago,dFechaInserta,
                   iUsuarioInsertaId,cEstadoCodigo,
                   iProveedorId,iIngresoProductoDevolucionId)
                   VALUES(total,NOW(),NOW(),xiUsuarioId,'AC',xiProveedorId,xId);
                   
                 
                  /**Insertamos en el libro Diario la salidae Caja y Banco para el pago al proveedor**/
                  /**Agregamos al libro dirario la salida de caja 
                         * 10(CAJA Y BANCOS) y
                         * 101(Caja)
                         * id=2, '1', '101', 'Caja'*/
                /* INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la compra de la mercaderia de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura)
                 ,xId,'ASIENTO N3','1',xiPeriodoId);
                  
             END IF; 
            /**Pago al credito**/ 
           /* IF xiFormaPagoId=2 ||  xiFormaPagoId=3 ||  xiFormaPagoId=4 THEN 
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
              /* SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(xfechaProximoPago) and MONTHNAME(DFECHAINICIO)=MONTHNAME(xfechaProximoPago) ;
            
               IF(xfMontoAdelantado !=0) THEN 
               
                  /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 /*INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,(total-xfMontoAdelantado),'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la compra al vencimiento de la',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
                 /**Cambiamos el estado del documento**/
                 /**Registro de estado Cuenta proveedor**/             
              /* INSERT INTO Estadocuentaproveedor(fMontoPago,dFechaPago,dFechaInserta, iUsuarioInsertaId,cEstadoCodigo,iProveedorId,iIngresoProductoDevolucionId)
               VALUES(xfMontoAdelantado,NOW(),NOW(),xiUsuarioId,'AC',xiProveedorId,xId);
          
                 /**Cambiamos el estado del documento**/
                /* UPDATE IngresoProductoDevolucion set vEstadoDocumento='DEUDA' where iIngresoProductoDevolucionId = xId;
               
               
               ELSE 
                 
                /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 /*INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago del anticipo en la compra de mercaderÃƒÆ’Ã‚Â­a de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
               /**Cambiamos el estado del documento**/
                /* UPDATE IngresoProductoDevolucion set vEstadoDocumento='DEUDA' where iIngresoProductoDevolucionId = xId;
               
                END IF;
            END IF; 
             /**Pago en letras **/ 
          /*  IF xiFormaPagoId=5 ||  xiFormaPagoId=6 THEN 
              
              SET importeLetra = total/xnumeroLetras;
              
              
              
             /**Insertamos en letrasProveedor **/
            /* WHILE x  <= xnumeroLetras DO 
             
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               /*SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(fechaVencimiento) and MONTHNAME(DFECHAINICIO)=MONTHNAME(fechaVencimiento) ;
            
            
                INSERT INTO letraProveedor (iProveedorId,nNumeroLetra,nNumeroUnico, dFechaGiro, dFechaVencimiento, nImporte, dFechaInserta,iUsuarioInsertaId,vEstadoLetra,cEstadoCodigo,iIngresoProductoDevolucionId) 
                values(xiProveedorId,x,'',NOW(),fechaVencimiento,importeLetra,NOW(),xiUsuarioId,'DEUDA','AC',xId);
                SET fechaVencimiento = ADDDATE(fechaVencimiento,xnumeroDias);
                
                /**Cambiamos el estado del documento**/
                 /*UPDATE IngresoProductoDevolucion set vEstadoDocumento='DEUDA' where iIngresoProductoDevolucionId = xId;
                 
              /**Agregamos al libro dirario la salida de caja 
                 * 42 (PROVEEDORES)
                 * id=201, '4', '423', 'Letras por pagar'*/

                 /*INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(201,importeLetra,'H',xiUsuarioId, NOW(), 'AC',CONCAT('PROVEEDORES/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
                SET  x = x + 1; 
                set fechaVencimiento=ADDDATE(fechaVencimiento,  xnumeroDias );
                END WHILE;
            END IF; */           
         END IF;
         
         /***************************/
         /* ACTUALIZAR LIBRO DIARIO */
         /*************************/
         
         IF(xMode='U') THEN
       /****************/
       /**ASIENTO NÃƒâ€šÃ‚Â°1 **/
       /****************/	      	   
				/**Agregamos al Libro Diario las compras realizadas del producto
				 *
				 * 60(Compras) y
				 * 601(Mercaderias)
				 * id=220; COMPRAS / MERCADERIA**/
         UPDATE Librodiario SET
         fMonto=subTotal,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('COMPRA/ Mercaderia / NRO de ',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=220 AND iIngresoProductoDevolucionId= xId AND iPeriodoId=xiPeriodoId;
       	
				/**Agregamos al Libro Diario el tributo por pagar				 
				 * 40(TRIBUTOS  POR PAGAR) 
				 * 401(Gobierno central)
				 * id=168', '4', '4011', 'IGV-Inpuesto general a la venta'*/
         UPDATE Librodiario SET
         fMonto=igv,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de ',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=168 AND iIngresoProductoDevolucionId= xId AND iPeriodoId=xiPeriodoId;       	
    
         /**Agregamos al Libro Diario las facturas de las pagar de las compras realizadas
				 * 42(PROVEEDORES) y
				 * 421(Facturas Por Pagar)
				 * id= '199', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/
         UPDATE Librodiario SET
         fMonto=total,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral='PROVEEDORES / Facturas, boletas y otros comprobantes por pagar',
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=199 AND iIngresoProductoDevolucionId= xId AND iPeriodoId=xiPeriodoId;
         
                
         /****************/
         /**ASIENTO NÃƒâ€šÃ‚Â°2 **/
         /****************/
				
				/**Insertamos en el libro Diario la cuenta de Mercaderia 
				 * 20(Mercaderia) y
				 * 201(Almacem)
				 * id=57; 201: mercaderia/ Almacen**/
        UPDATE Librodiario SET
         fMonto=subTotal,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('MERCADERIA / Almacen / NRO de',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=57 AND iIngresoProductoDevolucionId= xId AND iPeriodoId=xiPeriodoId;
         
				 /**Insertamos en el libro Dirio la cuenta de variacion de existencias
				 * 20(Mercaderia) y
				 * 61(VARIACION DE EXISTENCIAS')
				 * 611(Mercaderia)
				 * id='225', '6', '611', 'Mercaderias'**/
         UPDATE Librodiario SET
         fMonto=subTotal,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('VARIACION DE EXISTENCIAS / Mercaderia / NRO de',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=255 AND iIngresoProductoDevolucionId= xId AND iPeriodoId=xiPeriodoId;
     
                                        
           /****************/
           /**ASIENTO NÃƒâ€šÃ‚Â°3 **/
           /****************/
           
            /**Agregamos al Libro Diario las facturas de las pagar de las compras realizadas
             * 42(PROVEEDORES) y
             * 421(Facturas Por Pagar)
             * id= '199', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/  
             UPDATE Librodiario SET
             fMonto=total,
             iUsuarioActualizaId=xiUsuarioId,
             dFechaActualiza=NOW(),
             vConceptoGeneral='PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ',
             iPeriodoId=xiPeriodoId
             WHERE iCuentasId=199 AND iIngresoProductoDevolucionId= xId AND iPeriodoId=xiPeriodoId;
        
             /**Pago al contado**/
             IF xiFormaPagoId=1 THEN 
              
              /************************************************************/
              /** cambiamos de esta a eliminado  QUE SE INSERTO EN ESTADO CUENTA PROVEEDOR**/              
              UPDATE  Estadocuentaproveedor SET cEstadoCodigo='EL' WHERE iIngresoProductoDevolucionId=xId;
              UPDATE  Librodiario SET cEstadoCodigo='EL' WHERE iIngresoProductoDevolucionId=xId AND iPeriodoId=xiPeriodoId
                        AND iCuentasId=2 AND vTipoConcepto='H';
              
                   
                   /**Cambiamos el estado del documento**/
                   UPDATE IngresoProductoDevolucion set vEstadoDocumento='CANCELADO' where iIngresoProductoDevolucionId = xId;
                   
                   /**Registro de estado Cuenta proveedor**/             
                   INSERT INTO Estadocuentaproveedor(fMontoPago,
                   dFechaPago,dFechaInserta,
                   iUsuarioInsertaId,cEstadoCodigo,
                   iProveedorId,iIngresoProductoDevolucionId)
                   VALUES(total,NOW(),NOW(),xiUsuarioId,'AC',xiProveedorId,xId);
                   
                 
                  /**Insertamos en el libro Diario la salidae Caja y Banco para el pago al proveedor**/
                  /**Agregamos al libro dirario la salida de caja 
                         * 10(CAJA Y BANCOS) y
                         * 101(Caja)
                         * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la compra de la mercaderia de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura)
                 ,xId,'ASIENTO N3','1',xiPeriodoId);
                  
             END IF; 
            /**Pago al credito**/ 
            IF xiFormaPagoId=2 ||  xiFormaPagoId=3 ||  xiFormaPagoId=4 THEN 
            
              /************************************************************/
              /** cambiamos de esta a eliminado  QUE SE INSERTO EN ESTADO CUENTA PROVEEDOR**/              
              UPDATE  Estadocuentaproveedor SET cEstadoCodigo='EL' WHERE iIngresoProductoDevolucionId=xId;
              UPDATE  Librodiario SET cEstadoCodigo='EL' WHERE iIngresoProductoDevolucionId=xId AND iPeriodoId=xiPeriodoId
                        AND iCuentasId=2 AND vTipoConcepto='H';
          
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(xfechaProximoPago) and MONTHNAME(DFECHAINICIO)=MONTHNAME(xfechaProximoPago) ;
            
               IF(xfMontoAdelantado !=0) THEN 
               
                  /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,(total-xfMontoAdelantado),'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la compra al vencimiento de la',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
                 /**Cambiamos el estado del documento**/
                 /**Registro de estado Cuenta proveedor**/             
               INSERT INTO Estadocuentaproveedor(fMontoPago,dFechaPago,dFechaInserta, iUsuarioInsertaId,cEstadoCodigo,iProveedorId,iIngresoProductoDevolucionId)
               VALUES(xfMontoAdelantado,NOW(),NOW(),xiUsuarioId,'AC',xiProveedorId,xId);
          
                 /**Cambiamos el estado del documento**/
                 UPDATE IngresoProductoDevolucion set vEstadoDocumento='DEUDA' where iIngresoProductoDevolucionId = xId;
               
               
               ELSE 
                 
                /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago del anticipo en la compra de mercaderÃƒÆ’Ã‚Â­a de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
               /**Cambiamos el estado del documento**/
                 UPDATE IngresoProductoDevolucion set vEstadoDocumento='DEUDA' where iIngresoProductoDevolucionId = xId;
               
                END IF;
            END IF; 
             /**Pago en letras **/ 
            IF xiFormaPagoId=5 ||  xiFormaPagoId=6 THEN 
              
              /************************************************************/
              /** cambiamos de esta a eliminado  QUE SE INSERTO EN ESTADO CUENTA PROVEEDOR**/              
              UPDATE  letraProveedor SET cEstadoCodigo='EL' WHERE iIngresoProductoDevolucionId=xId;
              UPDATE  Librodiario SET cEstadoCodigo='EL' WHERE iIngresoProductoDevolucionId=xId AND iPeriodoId=xiPeriodoId
                        AND iCuentasId=201 AND vTipoConcepto='H';
              
              SET importeLetra = total/xnumeroLetras;                          
             /**Insertamos en letrasProveedor **/
             WHILE x  <= xnumeroLetras DO 
             
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(fechaVencimiento) and MONTHNAME(DFECHAINICIO)=MONTHNAME(fechaVencimiento) ;
            
            /**INSERTAMOS LETRAS**/
                INSERT INTO letraProveedor (iProveedorId,nNumeroLetra,nNumeroUnico, dFechaGiro, dFechaVencimiento, nImporte, dFechaInserta,iUsuarioInsertaId,vEstadoLetra,cEstadoCodigo,iIngresoProductoDevolucionId) 
                values(xiProveedorId,x,'',NOW(),fechaVencimiento,importeLetra,NOW(),xiUsuarioId,'DEUDA','AC',xId);
               
               SET fechaVencimiento = ADDDATE(fechaVencimiento,xnumeroDias);
                
                /**Cambiamos el estado del documento**/
                 UPDATE IngresoProductoDevolucion set vEstadoDocumento='DEUDA' where iIngresoProductoDevolucionId = xId;
                 
              /**Agregamos al libro dirario la salida de caja 
                 * 42 (PROVEEDORES)
                 * id=201, '4', '423', 'Letras por pagar'*/

                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(201,importeLetra,'H',xiUsuarioId, NOW(), 'AC',CONCAT('PROVEEDORES/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
                SET  x = x + 1; 
                set fechaVencimiento=ADDDATE(fechaVencimiento,  xnumeroDias );
                END WHILE;
            END IF;
            
        
         
         END IF;
         
          Select * from IngresoProductoDevolucion where iIngresoProductoDevolucionId = xId;
                 
    END$$

DROP PROCEDURE IF EXISTS `SP_IDU_DEVVENTA_CONTABILIDAD`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_IDU_DEVVENTA_CONTABILIDAD`(  
    IN xId int, /**key de las compras**/
    IN xiUsuarioId        INT,  
    IN xMode varchar(10),
    IN xNroNotaCredito varchar(10),
    IN xiPeriodoId INT
    )
BEGIN
     DECLARE x INT;
     DECLARE numeroFactura varchar(24);
     DECLARE subTotal  float;
     DECLARE igv  float;
     DECLARE total  float;
       
     DECLARE xiClienteId int;
     DECLARE tipoDocumento varchar(24);
     DECLARE fechaVencimiento Date;
     DECLARE xiVentaId int;
     DECLARE importeLetra float;
     DECLARE xProximoiPeriodoId int;
     SET x = 1;
     SET fechaVencimiento = NOW();
   

   
       
       
         SELECT iVentaId INTO xiVentaId FROM  VentaDevolucion WHERE iVentaId = xId  ;
         
         SELECT nVentaNumero INTO numeroFactura FROM venta WHERE iVentaId = xiVentaId  ;
       
      
       SELECT fVentaDevSubTotal INTO subTotal FROM VentaDevolucion  WHERE iVentaDevolucionId = xId ;
       SELECT fVentaDevIGV  INTO igv FROM VentaDevolucion  WHERE iVentaDevolucionId = xId ;
       SELECT fVentaDevTotal INTO total FROM VentaDevolucion  WHERE iVentaDevolucionId = xId ;
       SELECT vTipoDocumentoDescripcion INTO tipoDocumento FROM tipodocumentogestion 
                    WHERE iTipoDocumentoGestionId = (SELECT iTipoDocumentoId FROM  VentaDevolucion 
                                                     WHERE iVentaDevolucionId = xId)  ; 
     /*  SELECT iFormaPagoId INTO xiFormaPagoId FROM VentaDevolucion  WHERE iVentaDevolucionId = xId ; */
      /* SELECT iClienteId INTO xiClienteId FROM VentaDevolucion WHERE iVentaDevolucionId  = xId ;*/
       
       
       IF(xMode='I') THEN
       /****************/
       /**ASIENTO NÃƒâ€šÃ‚Â°1 **/
        /****************/	      	   
				/**Agregamos al Libro Diario las compras realizadas del producto
				 *
				 * 709(Devolucon de ventas) 				 
				 * id=316; VENTAS DEVOLUCION**/
         INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iVentaDevolucionId,vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(316,subTotal,'H',xiUsuarioId, NOW(), 'AC',CONCAT('POR LA DEVOLUCION DE LA VENTA/ NRO de ',tipoDocumento,': ',numeroFactura,'NRO de NotaCredito:',xNroNotaCredito),xId,'ASIENTO N1','0',xiPeriodoId);
				
				/**Agregamos al Libro Diario el tributo por pagar				 
				 * 40(TRIBUTOS  POR PAGAR) 
				 * 401(Gobierno central)
				 * id=168', '4', '4011', 'IGV-Inpuesto general a la venta'*/
          INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iVentaDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(168,igv,'H',xiUsuarioId, NOW(), 'AC',CONCAT('TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de ',tipoDocumento,': ',numeroFactura),
         xId,'ASIENTO N1','0',xiPeriodoId); 
         /**Agregamos al Libro Diario las facturas de las pagar de las compras realizadas
				 * 12(CLIENTES) y
				 * 121(Facturas Por Pagar)
				 * id= '8', 'Facturas, boletas y otros comprobantes por pagar'**/
				  INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iVentaDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(8,total,'D',xiUsuarioId, NOW(), 'AC','CLIENTES / Facturas, boletas y otros comprobantes por pagar',
         xId,'ASIENTO N1','0',xiPeriodoId);
                
                
         /****************/
         /**ASIENTO NÃƒâ€šÃ‚Â°2 **/
         /****************/
				
				/**Insertamos en el libro Diario la cuenta de Mercaderia 
				 * 20(Mercaderia) y
				 * 201(Almacem)
				 * id=57; 201: mercaderia/ Almacen**/    
				INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iVentaDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(57,subTotal,'H',xiUsuarioId, NOW(), 'AC',CONCAT('DEVOLUCION DE MERCADERIA / Almacen / NRO de',tipoDocumento,': ',numeroFactura),xId
         ,'ASIENTO N2','0',xiPeriodoId);
				/**Insertamos en el libro Dirio la cuenta de variacion de existencias
				 * 69(COSTO DE VENTAS) y				 
				 * 691(Mercaderia)
				 * id='305', , 'Mercaderias'**/
         	INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iVentaDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(305,subTotal,'D',xiUsuarioId, NOW(), 'AC',CONCAT('COSTO DE VENTA / Mercaderia / NRO de',tipoDocumento,': ',numeroFactura),xId,
         'ASIENTO N2','0',xiPeriodoId);
			   
         END IF;
         
          Select * from VentaDevolucion where iVentaDevolucionId = xId;
                 
    END$$

DROP PROCEDURE IF EXISTS `SP_IDU_PERFIL_PERMISOS`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_IDU_PERFIL_PERMISOS`(
    IN  xiUsuarioId int,
		IN  xvCodigoPermiso varchar(52), 
    IN  xCantidad int)
BEGIN
    DECLARE x INT;    
    DECLARE permisos VARCHAR(45);
    SET x = 1;
   /* DELETE FROM PERMISOS WHERE iUsuarioId = xiUsuarioId;
     WHILE x  <= xCantidad DO
       SELECT SPLIT_STR(xvCodigoPermiso, '-', x) into permisos; 
       
       if(permisos!='')then
        INSERT INTO PERMISOS(iUsuarioId,vCodigoMenu,cEstado) VALUES(xiUsuarioId,permisos,'AC');    
        end if;
      SET  x = x + 1; 
     END WHILE;
     */
     INSERT INTO PERMISOS(iUsuarioId,vCodigoMenu,cEstado) VALUES(xiUsuarioId,xvCodigoPermiso,'AC');    
END$$

DROP PROCEDURE IF EXISTS `SP_IDU_VENTA_CONTABILIDAD`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_IDU_VENTA_CONTABILIDAD`(  
    IN xId int, /**key de las Ventas**/
    IN xfechaProximoPago date,
    IN xfMontoAdelantado float,
    IN xiUsuarioId        INT,
    IN xnumeroLetras INT,
    IN xnumeroDias INT,
    IN xMode varchar(10),
    IN xiPeriodoId INT,
    IN numeroLetra INT,
    IN xiFormaPagoId int
    )
BEGIN
     DECLARE x INT;
     DECLARE numeroFactura varchar(24);
     DECLARE subTotal  float;
     DECLARE igv  float;
     DECLARE total  float;
         
     DECLARE xiClienteId int;
     DECLARE tipoDocumento varchar(24);
     DECLARE fechaVencimiento Date;
     DECLARE importeLetra float;
     DECLARE xProximoiPeriodoId int;
     SET x = numeroLetra;
     SET fechaVencimiento = xfechaProximoPago;
   

   
       
       SELECT nVentaNumero INTO numeroFactura FROM Venta WHERE iVentaId = xId  ;
       SELECT fVentaSubTotal INTO subTotal FROM Venta  WHERE iVentaId = xId ;
       SELECT fVentaIGV  INTO igv FROM Venta  WHERE iVentaId = xId ;
       SELECT fVentaTotal INTO total FROM Venta  WHERE iVentaId = xId ;
       SELECT vTipoDocumentoDescripcion INTO tipoDocumento FROM tipodocumentogestion 
                    WHERE iTipoDocumentoGestionId = (SELECT iTipoDocumentoId FROM  Venta 
                                                     WHERE iVentaId = xId)  ; 
     /*  SELECT iFormaPagoId INTO xiFormaPagoId FROM Venta  WHERE iVentaId = xId ; */
       SELECT iClienteId INTO xiClienteId FROM Venta WHERE iVentaId  = xId ;
       
       
       IF(xMode='I') THEN
       /****************/
       /**ASIENTO NÃƒâ€šÃ‚Â°1 **/
       /****************/	      	   
				/**Agregamos al Libro Diario las Ventas realizadas del producto
				 *
				 * 70(Ventas) y
				 * 701(Mercaderias)
				 * id=311; Ventas / MERCADERIA**/
         INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iVentaId,vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(311,subTotal,'H',xiUsuarioId, NOW(), 'AC',CONCAT('VENTA/ Mercaderia / NRO de ',tipoDocumento,': ',numeroFactura),xId,'ASIENTO N1','0',xiPeriodoId);
				
				/**Agregamos al Libro Diario el tributo por pagar				 
				 * 40(TRIBUTOS  POR PAGAR) 
				 * 401(Gobierno central)
				 * id=168', '4', '4011', 'IGV-Inpuesto general a la Venta'*/
          INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(168,igv,'H',xiUsuarioId, NOW(), 'AC',CONCAT('TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de ',tipoDocumento,': ',numeroFactura),
         xId,'ASIENTO N1','0',xiPeriodoId); 
         /**Agregamos al Libro Diario las facturas de las pagar de las Ventas realizadas
				 * 12(Clientes) y
				 * 121(Facturas Por Pagar)
				 * id= '8', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/
				  INSERT INTO Librodiario(
         iCuentasId,fMonto,vTipoConcepto,
         iUsuarioInsertaId,dFechaInserta,
         cEstadoCodigo,vConceptoGeneral,
         iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
         VALUES(8,total,'D',xiUsuarioId, NOW(), 'AC','Clientes / Facturas, boletas y otros comprobantes por pagar',
         xId,'ASIENTO N1','0',xiPeriodoId);
                
          /****************/
           /**ASIENTO NÃƒâ€šÃ‚Â°3 **/
           /****************/
           
           /**Agregamos al Libro Diario las facturas de las pagar de las Ventas realizadas
				 * 12(Clientes) y
				 * 121(Facturas Por Pagar)
				 * id= '8', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/
				  INSERT INTO Librodiario(
          iCuentasId,fMonto,vTipoConcepto,
          iUsuarioInsertaId,dFechaInserta,
          cEstadoCodigo,vConceptoGeneral,
          iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
          VALUES(8,total,'H',xiUsuarioId, NOW(), 'AC','Clientes / Facturas, boletas y otros comprobantes por pagar',
          xId,'ASIENTO N1','0',xiPeriodoId);    
         
         SELECT xiFormaPagoId;
         /**Pago al contado**/
             IF xiFormaPagoId=1 THEN 
              SELECT xiFormaPagoId;
                   /**Cambiamos el estado del documento**/
                   UPDATE Venta set vEstadoDocumento='CANCELADO' where iVentaId = xId;
                   
                   /**Registro de estado Cuenta Cliente**/             
                   INSERT INTO EstadocuentaCliente(fMontoPago,
                   dFechaPago,dFechaInserta,
                   iUsuarioInsertaId,cEstadoCodigo,
                   iClienteId,iVentaId)
                   VALUES(total,NOW(),NOW(),xiUsuarioId,'AC',xiClienteId,xId);
                   
                 
                  /**Insertamos en el libro Diario la salidae Caja y Banco para el pago al Cliente**/
                  /**Agregamos al libro dirario la salida de caja 
                         * 10(CAJA Y BANCOS) y
                         * 101(Caja)
                         * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por la venta de la mercaderia de la ',tipoDocumento,' NÂ°: ', numeroFactura)
                 ,xId,'ASIENTO N3','1',xiPeriodoId);
                  
             END IF; 
            /**Pago al credito**/ 
            IF xiFormaPagoId=2 ||  xiFormaPagoId=3 ||  xiFormaPagoId=4 THEN 
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(xfechaProximoPago) and MONTHNAME(DFECHAINICIO)=MONTHNAME(xfechaProximoPago) ;
            
               IF(xfMontoAdelantado !=0) THEN 
               
                  /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,(total-xfMontoAdelantado),'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el anticipio de la venta la',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
                 /**Cambiamos el estado del documento**/
                 /**Registro de estado Cuenta Cliente**/             
               INSERT INTO EstadocuentaCliente(fMontoPago,dFechaPago,dFechaInserta, iUsuarioInsertaId,cEstadoCodigo,iClienteId,iVentaId)
               VALUES(xfMontoAdelantado,NOW(),NOW(),xiUsuarioId,'AC',xiClienteId,xId);
          
                 /**Cambiamos el estado del documento**/
                 UPDATE Venta set vEstadoDocumento='DEUDA' where iVentaId = xId;
               
               
               ELSE 
                 
                /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago de la venta de mercaderia de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
               /**Cambiamos el estado del documento**/
                 UPDATE Venta set vEstadoDocumento='DEUDA' where iVentaId = xId;
               
                END IF;
            END IF; 
             /**Pago en letras **/ 
            IF xiFormaPagoId=5 ||  xiFormaPagoId=6 THEN 
              
              SET importeLetra = total/xnumeroLetras;
              
              
              
             /**Insertamos en letrasCliente **/
             WHILE x  <= xnumeroLetras DO 
             
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(fechaVencimiento) and MONTHNAME(DFECHAINICIO)=MONTHNAME(fechaVencimiento) ;
            
            
                INSERT INTO letraCliente (iClienteId,nNumeroLetra,nNumeroUnico, dFechaGiro, dFechaVencimiento, nImporte, dFechaInserta,iUsuarioInsertaId,vEstadoLetra,cEstadoCodigo,iVentaId) 
                values(xiClienteId,x,'',NOW(),fechaVencimiento,importeLetra,NOW(),xiUsuarioId,'DEUDA','AC',xId);
                SET fechaVencimiento = ADDDATE(fechaVencimiento,xnumeroDias);
                
                /**Cambiamos el estado del documento**/
                 UPDATE Venta set vEstadoDocumento='DEUDA' where iVentaId = xId;
                 
              /**Agregamos al libro dirario la salida de caja 
                 * 12 (ClienteES)
                 * 123 LETRAS POR COBRAR
                 * id=10, '1', '123', 'Letras por pagar'*/

                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(10,importeLetra,'D',xiUsuarioId, NOW(), 'AC',CONCAT('Clientes/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÂ°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
                SET  x = x + 1; 
                set fechaVencimiento=ADDDATE(fechaVencimiento,  xnumeroDias );
                END WHILE;
            END IF;            
         END IF;
         
         /***************************/
         /* ACTUALIZAR LIBRO DIARIO */
         /*************************/
         
         IF(xMode='U') THEN
       /****************/
       /**ASIENTO NÃƒâ€šÃ‚Â°1 **/
       /****************/	      	   
				/**Agregamos al Libro Diario las Ventas realizadas del producto
				 *
				* 70(Ventas) y
				 * 701(Mercaderias)
				 * id=311; Ventas / MERCADERIA**/
         UPDATE Librodiario SET
         fMonto=subTotal,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('VENTA/ Mercaderia / NRO de ',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=311 AND iVentaId= xId AND iPeriodoId=xiPeriodoId;
       	
				/**Agregamos al Libro Diario el tributo por pagar				 
				 * 40(TRIBUTOS  POR PAGAR) 
				 * 401(Gobierno central)
				 * id=168', '4', '4011', 'IGV-Inpuesto general a la Venta'*/
         UPDATE Librodiario SET
         fMonto=igv,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral=CONCAT('TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de ',tipoDocumento,': ',numeroFactura),
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=168 AND iVentaId= xId AND iPeriodoId=xiPeriodoId;       	
    
          /**Agregamos al Libro Diario las facturas de las pagar de las Ventas realizadas
				 * 12(Clientes) y
				 * 121(Facturas Por Pagar)
				 * id= '8', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/
		     UPDATE Librodiario SET
         fMonto=total,
         iUsuarioActualizaId=xiUsuarioId,
         dFechaActualiza=NOW(),
         vConceptoGeneral='Clientes/ Facturas, boletas y otros comprobantes por pagar',
         iPeriodoId=xiPeriodoId
         WHERE iCuentasId=8 AND iVentaId= xId AND iPeriodoId=xiPeriodoId;
         
                
                                               
           /****************/
           /**ASIENTO NÃƒâ€šÃ‚Â°3 **/
           /****************/
           
           /**Agregamos al Libro Diario las facturas de las pagar de las Ventas realizadas
				 * 12(Clientes) y
				 * 121(Facturas Por Pagar)
				 * id= '8', '4', '421', 'Facturas, boletas y otros comprobantes por pagar'**/
		     UPDATE Librodiario SET
             fMonto=total,
             iUsuarioActualizaId=xiUsuarioId,
             dFechaActualiza=NOW(),
             vConceptoGeneral='Clientes / Facturas, boletas y otros comprobantes por pagar ',
             iPeriodoId=xiPeriodoId
             WHERE iCuentasId=199 AND iVentaId= xId AND iPeriodoId=xiPeriodoId;
        
             /**Pago al contado**/
             IF xiFormaPagoId=1 THEN 
              
              /************************************************************/
              /** cambiamos de esta a eliminado  QUE SE INSERTO EN ESTADO CUENTA Cliente**/              
              UPDATE  EstadocuentaCliente SET cEstadoCodigo='EL' WHERE iVentaId=xId;
              UPDATE  Librodiario SET cEstadoCodigo='EL' WHERE iVentaId=xId AND iPeriodoId=xiPeriodoId
                        AND iCuentasId=2 AND vTipoConcepto='D';
              
                   
                   /**Cambiamos el estado del documento**/
                   UPDATE Venta set vEstadoDocumento='CANCELADO' where iVentaId = xId;
                   
                   /**Registro de estado Cuenta Cliente**/             
                   INSERT INTO EstadocuentaCliente(fMontoPago,
                   dFechaPago,dFechaInserta,
                   iUsuarioInsertaId,cEstadoCodigo,
                   iClienteId,iVentaId)
                   VALUES(total,NOW(),NOW(),xiUsuarioId,'AC',xiClienteId,xId);
                   
                 
                  /**Insertamos en el libro Diario la salidae Caja y Banco para el pago al Cliente**/
                  /**Agregamos al libro dirario la salida de caja 
                         * 10(CAJA Y BANCOS) y
                         * 101(Caja)
                         * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la venta de la mercaderia de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura)
                 ,xId,'ASIENTO N3','1',xiPeriodoId);
                  
             END IF; 
            /**Pago al credito**/ 
            IF xiFormaPagoId=2 ||  xiFormaPagoId=3 ||  xiFormaPagoId=4 THEN 
            
              /************************************************************/
              /** cambiamos de esta a eliminado  QUE SE INSERTO EN ESTADO CUENTA Cliente**/              
              UPDATE  EstadocuentaCliente SET cEstadoCodigo='EL' WHERE iVentaId=xId;
              UPDATE  Librodiario SET cEstadoCodigo='EL' WHERE iVentaId=xId AND iPeriodoId=xiPeriodoId
                        AND iCuentasId=2 AND vTipoConcepto='D';
          
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(xfechaProximoPago) and MONTHNAME(DFECHAINICIO)=MONTHNAME(xfechaProximoPago) ;
            
               IF(xfMontoAdelantado !=0) THEN 
               
                  /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,(total-xfMontoAdelantado),'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la venta  al vencimiento de la',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
                 /**Cambiamos el estado del documento**/
                 /**Registro de estado Cuenta Cliente**/             
               INSERT INTO EstadocuentaCliente(fMontoPago,dFechaPago,dFechaInserta, iUsuarioInsertaId,cEstadoCodigo,iClienteId,iVentaId)
               VALUES(xfMontoAdelantado,NOW(),NOW(),xiUsuarioId,'AC',xiClienteId,xId);
          
                 /**Cambiamos el estado del documento**/
                 UPDATE Venta set vEstadoDocumento='DEUDA' where iVentaId = xId;
               
               
               ELSE 
                 
                /**Agregamos al libro dirario la salida de caja 
                 * 10(CAJA Y BANCOS) y
                 * 101(Caja)
                 * id=2, '1', '101', 'Caja'*/
                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,total,'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago de la venta de mercaderia de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
               /**Cambiamos el estado del documento**/
                 UPDATE Venta set vEstadoDocumento='DEUDA' where iVentaId = xId;
               
                END IF;
            END IF; 
             /**Pago en letras **/ 
            IF xiFormaPagoId=5 ||  xiFormaPagoId=6 THEN 
              
              /************************************************************/
              /** cambiamos de esta a eliminado  QUE SE INSERTO EN ESTADO CUENTA Cliente**/              
              UPDATE  letraCliente SET cEstadoCodigo='EL' WHERE iVentaId=xId;
              UPDATE  Librodiario SET cEstadoCodigo='EL' WHERE iVentaId=xId AND iPeriodoId=xiPeriodoId
                        AND iCuentasId=10 AND vTipoConcepto='D';
              
              SET importeLetra = total/xnumeroLetras;                          
             /**Insertamos en letrasCliente **/
             WHILE x  <= xnumeroLetras DO 
             
              /***
               *Obtenemos el id del proximo periodo segun fecha proximo de pago
               **/
               SELECT iPeriodoId INTO xProximoiPeriodoId FROM periodo WHERE  year(DFECHAINICIO)=year(fechaVencimiento) and MONTHNAME(DFECHAINICIO)=MONTHNAME(fechaVencimiento) ;
            
            /**INSERTAMOS LETRAS**/
                INSERT INTO letraCliente (iClienteId,nNumeroLetra,nNumeroUnico, dFechaGiro, dFechaVencimiento, nImporte, dFechaInserta,iUsuarioInsertaId,vEstadoLetra,cEstadoCodigo,iVentaId) 
                values(xiClienteId,x,'',NOW(),fechaVencimiento,importeLetra,NOW(),xiUsuarioId,'DEUDA','AC',xId);
               
               SET fechaVencimiento = ADDDATE(fechaVencimiento,xnumeroDias);
                
                /**Cambiamos el estado del documento**/
                 UPDATE Venta set vEstadoDocumento='DEUDA' where iVentaId = xId;
                 
              /**Agregamos al libro dirario la salida de caja 
                 * 12 (ClienteES)
                 * 123 LETRAS POR COBRAR
                 * id=10, '1', '123', 'Letras por pagar'*/

                 INSERT INTO Librodiario(
                 iCuentasId,fMonto,vTipoConcepto,
                 iUsuarioInsertaId,dFechaInserta,
                 cEstadoCodigo,vConceptoGeneral,
                 iVentaId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(10,importeLetra,'D',xiUsuarioId, NOW(), 'AC',CONCAT('ClienteS/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃƒâ€šÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
                SET  x = x + 1; 
                set fechaVencimiento=ADDDATE(fechaVencimiento,  xnumeroDias );
                END WHILE;
            END IF;
            
        
         
         END IF;
         
          Select * from Venta where iVentaId = xId;
                 
    END$$

DROP PROCEDURE IF EXISTS `SP_NRO_DOCUMENTO`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_NRO_DOCUMENTO`(
IN xitipoDocumentoId INT,
IN xtabla varchar(100),
IN xCampoNumeroDoc varchar(100))
BEGIN
  DECLARE xNumeroCorrelativo INT;
  DECLARE xNuevoNumero VARCHAR(20);
  DECLARE xNuevoObtenido2 VARCHAR(20);
  DECLARE xNuevoObtenido1 VARCHAR(20);
  SET xNumeroCorrelativo=0;
  
  SET @SQ = CONCAT("SELECT MAX(SPLIT_STR(",xCampoNumeroDoc,", '-', 1)) INTO @xNuevoObtenido1  FROM ",xtabla, " WHERE iTipoDocumentoId= ",xitipoDocumentoId);    
  PREPARE stmt1 FROM @SQ ;
  EXECUTE stmt1;
   SET xNuevoObtenido1=@xNuevoObtenido1;
  
  SET @SQ1 = CONCAT("SELECT MAX(SPLIT_STR(",xCampoNumeroDoc,", '-', 2)) INTO @xNuevoObtenido2  FROM ",xtabla, " WHERE iTipoDocumentoId=",xitipoDocumentoId);    
  PREPARE stmt2 FROM @SQ1 ;
  EXECUTE stmt2;
   SET xNuevoObtenido2=@xNuevoObtenido2;
  
   SET @SQ2 = CONCAT(" SELECT COALESCE(CAST(MAX(SPLIT_STR(",xCampoNumeroDoc,", '-', 2)) AS SIGNED INTEGER),0) INTO @xNumeroCorrelativo FROM ",xtabla, " WHERE iTipoDocumentoId=",xitipoDocumentoId);    
 /* select  @SQ2;*/
  PREPARE stmt3 FROM @SQ2 ;
  EXECUTE stmt3;
  /*select  @SQ2;*/
   SET xNumeroCorrelativo=@xNumeroCorrelativo;
  
  
  /*SELECT MAX(SPLIT_STR(nVentaNumero, '-', 1)) INTO xNuevoObtenido1  FROM xtabla WHERE iTipoDocumentoId=xitipoDocumentoId;   
  SELECT MAX(SPLIT_STR(nVentaNumero, '-', 2)) INTO xNuevoObtenido2  FROM xtabla WHERE iTipoDocumentoId=xitipoDocumentoId;
  SELECT COALESCE(CAST(MAX(SPLIT_STR(nVentaNumero, '-', 2)) AS SIGNED INTEGER),0) INTO xNumeroCorrelativo FROM xtabla  WHERE iTipoDocumentoId=xitipoDocumentoId;
  */
 
  IF (xNumeroCorrelativo=0) THEN 
  
        IF(xitipoDocumentoId=1) THEN
             SELECT vValor INTO xNuevoNumero FROM CONFIGURACION WHERE vConcepto LIKE '%FACTURA%';
        END IF;
        IF(xitipoDocumentoId=3) THEN
             SELECT vValor INTO xNuevoNumero FROM CONFIGURACION WHERE vConcepto LIKE '%BOLETA%';
        END IF;
        IF(xitipoDocumentoId=7) THEN
             SELECT vValor INTO xNuevoNumero FROM CONFIGURACION WHERE vConcepto LIKE '%NOTA CREDITO%';
            
        END IF;
        IF(xitipoDocumentoId=8) THEN
             SELECT vValor INTO xNuevoNumero FROM CONFIGURACION WHERE vConcepto LIKE '%NOTA DEBITO%';
             
        END IF;
        
        IF(xitipoDocumentoId=9) THEN
             SELECT vValor INTO xNuevoNumero FROM CONFIGURACION WHERE vConcepto LIKE '%GUIA%';
             
        END IF;
   ELSE
          SET xNumeroCorrelativo= xNumeroCorrelativo+1;  
         SET xNuevoNumero=concat(xNuevoObtenido1,'-',UPPER(substring(xNuevoObtenido2, 1,LENGTH(xNuevoObtenido2)-LENGTH(xNumeroCorrelativo))),xNumeroCorrelativo); 
       
   END IF;
    /* SELECT xNuevoNumero, xNumeroCorrelativo,xitipoDocumentoId ;  */
     SELECT xNuevoNumero;

END$$

DROP PROCEDURE IF EXISTS `SP_PERIODO_ACTUAL`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_PERIODO_ACTUAL`()
BEGIN
    
       SELECT iPeriodoId from periodo where year(dFechaInicio)=year(now()) and MONTHNAME(dFechaInicio)=MONTHNAME(now())  AND cCodigoEstado='ABIERTO';         
      
END$$

--
-- Funciones
--
DROP FUNCTION IF EXISTS `SPLIT_STR`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `SPLIT_STR`(
  x VARCHAR(255),
  delim VARCHAR(12),
  pos INT
) RETURNS varchar(255) CHARSET latin1
RETURN REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos),
       LENGTH(SUBSTRING_INDEX(x, delim, pos -1)) + 1),
       delim, '')$$

DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
