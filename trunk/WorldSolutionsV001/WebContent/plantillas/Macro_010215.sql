-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 01-02-2015 a las 00:14:04
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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  PRIMARY KEY (`iAreaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `area`
--

INSERT INTO `area` (`iAreaId`, `cAreaCodigo`, `vAreaDescripcion`, `iUsuarioInsertaId`, `iUsuarioModificaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(1, 'ARE02', 'AREA DE SISTEMAS', 1, 1, '2011-04-24', '2011-04-24', 'AC'),
(3, 'ARE03', 'AREA DE ADMINISTRACION', 1, NULL, '2011-04-24', NULL, 'AC'),
(4, 'AR00004', 'NBN', 0, 0, '2015-01-01', NULL, 'IN');

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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vConceptoGeneral` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iCajaChicaId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=68 ;

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iClasificacionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iCategoriaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcar la base de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`iCategoriaId`, `cCategoriaCodigo`, `vCategoriaDescripcion`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `iClasificacionId`) VALUES
(1, 'CA01', 'CEMENTO', 2, NULL, '2011-04-24', NULL, 'AC', 1),
(2, 'CA02', 'THINNER', 2, NULL, '2011-04-24', NULL, 'AC', 1),
(3, 'CA03', 'SELLADORA', 2, NULL, '2011-04-24', NULL, 'AC', 1),
(4, 'CA04', 'PINTURAS', 0, 0, '2013-03-14', NULL, 'AC', 1),
(5, 'CA00005', 'BROCHA', 0, 0, NULL, '2014-12-30', 'AC', 1),
(6, 'CA00006', 'BASE', 0, 0, NULL, '2014-12-26', 'IN', 1),
(7, 'CA00007', 'LADRILLO', 0, 0, '2014-12-26', NULL, 'AC', 2),
(8, 'CA00008', 'TEJAS', 0, 0, '2014-12-31', NULL, 'AC', 2),
(9, 'CA0009', 'BOMBA PRESION', 0, 0, '2014-12-31', NULL, 'AC', 3),
(10, 'CA00010', 'TANQUE DE COMBUSTIBLE', 0, 0, '2014-12-31', NULL, 'AC', 3),
(11, 'CA00011', 'ADHESIVO', 0, 0, NULL, '2014-12-31', 'AC', 4),
(12, 'CA00012', 'BARRIL', 0, 0, '2014-12-31', NULL, 'AC', 4);

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `clasificacioncategoria`
--

INSERT INTO `clasificacioncategoria` (`iClasificacionId`, `cClasificacionCodigo`, `vClasificacionDescripcion`, `cEstadoCodigo`) VALUES
(1, 'S001', 'PRODUCTOS', 'AC'),
(2, 'S002', 'MATERIA PRIMA', 'AC'),
(3, 'S003', 'SUMINISTROS Y REPUESTOS', 'AC'),
(4, 'S004', 'ENVASES Y EMBALAJES', 'AC');

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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  PRIMARY KEY (`iClienteId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`iClienteId`, `vClienteCodigo`, `vNombreCliente`, `vClienteRazonSocial`, `nClienteNumeroDocumento`, `nClienteTelefono`, `vRubro`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(1, 'CLI01', NULL, 'ANTONIO GOMEZ CELESTINO', '10092222212', '0', NULL, 2, '2011-04-24', 2, '2011-04-24', 'AC'),
(2, 'CL00002', NULL, 'NS', '64454', '6', NULL, 0, '2015-01-14', 0, NULL, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

DROP TABLE IF EXISTS `configuracion`;
CREATE TABLE IF NOT EXISTS `configuracion` (
  `iConfiguracionId` int(11) NOT NULL AUTO_INCREMENT,
  `vConcepto` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vValor` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dFechaInserta` date DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iConfiguracionId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=12 ;

--
-- Volcar la base de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`iConfiguracionId`, `vConcepto`, `vValor`, `dFechaInserta`, `cEstadoCodigo`) VALUES
(1, 'TIPO MONEDA', 'SOLES', '2014-12-30', 'AC'),
(2, 'TIPO CAMBIO', '2.75', NULL, 'AC'),
(3, 'NRO FACTURA VENTA', '0001-000001', '2015-01-08', 'AC'),
(4, 'NRO BOLETA VENTA', '000B1-000001', '2015-01-09', 'AC'),
(5, 'NRO GUIA REMISION VENTA', '000G1-000001', '2015-01-09', 'AC'),
(6, 'DESC. SNP %', '13', '2015-01-27', 'AC'),
(7, 'DESC. AFP %', '10', '2015-01-29', 'AC'),
(8, 'DESC. P.S %', '1.35', '2015-01-27', 'AC'),
(9, 'DESC. C.V %', '2', '2015-01-27', 'AC'),
(10, 'APORT. ESSALUD %', '9', '2015-01-27', 'AC'),
(11, 'APORT. I.E.S %', '2', '2015-01-27', 'AC');

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=341 ;

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
  `dFechaInserta` date NOT NULL,
  `dFechaActualiza` date DEFAULT NULL,
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
  `vDireccion` varchar(45) DEFAULT NULL,
  `vReferencia` varchar(45) DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `vPrincipal` char(2) DEFAULT NULL,
  PRIMARY KEY (`idireccionClienteId`),
  UNIQUE KEY `idireccionClienteId` (`idireccionClienteId`),
  KEY `fk_direccionCliente_cliente1` (`iClienteId`),
  KEY `fk_direccionCliente` (`iClienteId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=77 ;

--
-- Volcar la base de datos para la tabla `direccioncliente`
--

INSERT INTO `direccioncliente` (`idireccionClienteId`, `iClienteId`, `iPoblacionId`, `vDireccion`, `vReferencia`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `vPrincipal`) VALUES
(1, 1, '140540', 'CARRETERA CENTRAL KM. 23.50', NULL, 2, '2011-04-24', 2, '2011-04-24', 'AC', '1'),
(2, 1, '140540', 'CALLE 1 MZ L LT 6 ASOC. LA GRAMA', NULL, 2, '2011-04-24', NULL, NULL, 'AC', '1'),
(76, 2, '140501', '6', NULL, 2, '2015-01-14', 0, NULL, NULL, '1');

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cCodigoEstado` char(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iEjercicioFiscalId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `ejerciciofiscal`
--

INSERT INTO `ejerciciofiscal` (`iEjercicioFiscalId`, `vCodigoEjercicio`, `vNombreEjercicio`, `dFechaInicio`, `dFechaFin`, `iUsuarioInserta`, `iUsuarioActualiza`, `dFechaInserta`, `dFechaActualiza`, `cCodigoEstado`) VALUES
(6, '01', 'EJERCICIO 2015', '2015-01-01', '2015-12-31', 0, 0, '2015-01-01', NULL, 'ABIERTO');

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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=11 ;

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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  PRIMARY KEY (`iEstadoCuentaCliente`),
  KEY `fk_estadoCuentaCliente_cliente1` (`iClienteId`),
  KEY `fk_estadoCuentaCliente_venta1` (`iVentaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `estadocuentacliente`
--

INSERT INTO `estadocuentacliente` (`iEstadoCuentaCliente`, `iClienteId`, `fMontoPago`, `iVentaId`, `dFechaPago`, `dFechaInserta`, `iUsuarioInsertaId`, `cEstadoCodigo`) VALUES
(1, 1, 8000, 14, '2015-01-24', '2015-01-24', 2, 'AC'),
(2, 1, 40000, 15, '2015-01-31', '2015-01-31', 2, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadocuentaproveedor`
--

DROP TABLE IF EXISTS `estadocuentaproveedor`;
CREATE TABLE IF NOT EXISTS `estadocuentaproveedor` (
  `iEstadoCuentaProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `fMontoPago` float NOT NULL,
  `dFechaPago` date DEFAULT NULL,
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iProveedorId` int(11) NOT NULL,
  `iIngresoProductoId` int(11) NOT NULL,
  `sVendedor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iEstadoCuentaProveedor`),
  KEY `fk_estadoCuentaProveedor_proveedor1` (`iProveedorId`),
  KEY `fk_estadoCuentaProveedor_ingresoProducto1` (`iIngresoProductoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `estadocuentaproveedor`
--

INSERT INTO `estadocuentaproveedor` (`iEstadoCuentaProveedor`, `fMontoPago`, `dFechaPago`, `dFechaInserta`, `iUsuarioInsertaId`, `cEstadoCodigo`, `iProveedorId`, `iIngresoProductoId`, `sVendedor`) VALUES
(1, 8000, '2015-01-24', '2015-01-24', 2, 'AC', 1, 22, NULL),
(2, 8000, '2015-01-31', '2015-01-31', 2, 'AC', 1, 23, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formapago`
--

DROP TABLE IF EXISTS `formapago`;
CREATE TABLE IF NOT EXISTS `formapago` (
  `iFormaPago` int(11) NOT NULL AUTO_INCREMENT,
  `vFormaPagoDescripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iFormaPago`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

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
  `dFechaInserta` date DEFAULT NULL,
  `cCodigoEstado` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iImpuestosId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='os' AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `impuestos`
--

INSERT INTO `impuestos` (`iImpuestosId`, `vNombreImpuesto`, `vAplicacionImpuesto`, `vPorcentaje`, `iUsuarioInserta`, `dFechaInserta`, `cCodigoEstado`) VALUES
(1, 'IGV 18% COMPRA', 'COMPRAS', '15', 0, '2015-01-02', 'AC'),
(2, 'IGV 18% VENTA', 'VENTAS', '18', 0, '2014-05-08', 'AC'),
(3, 'PERCEPCION IGV 2%', 'COMPRAS', '2', 0, '2014-05-08', 'AC');

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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
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
  PRIMARY KEY (`iIngresoProductoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Volcar la base de datos para la tabla `ingresoproducto`
--

INSERT INTO `ingresoproducto` (`iIngresoProductoId`, `nIngresoProductoNumero`, `dIngresoProductoFecha`, `fIngresoProductoTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iProveedorId`, `iTipoDocumentoId`, `iFormaPagoId`, `vPrincipal`, `fIngresoProductoSubTotal`, `fIngresoProductoIGV`, `vEstadoDocumento`, `vIngresoProductoPuntoLlegada`, `dFechaProximoPago`, `fDescuento`, `fIngresoProductoTotalReal`, `fMontoAdelantado`, `fPercepcion`, `iNumeroDias`, `iNumeroLetras`, `iPeriodoId`, `iSucursalId`) VALUES
(22, '00001-0001', '2015-01-24', 8000, 2, '2015-01-24', 0, NULL, 'AC', 1, 2, 1, '1', 6956.52, 1043.48, 'CANCELADO', 'AV CONQUISTADORES 304 ', '2015-01-24', 0, 8000, 0, 0, 0, 1, 7, NULL),
(23, '00001-0001', '2015-01-31', 8000, 2, '2015-01-31', 0, NULL, 'AC', 1, 2, 1, '1', 6956.52, 1043.48, 'CANCELADO', 'AV CONQUISTADORES 304 ', '2015-01-31', 0, 8000, 0, 0, 0, 1, 7, NULL);

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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) NOT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iIngresoProductoId` int(11) NOT NULL,
  `iProductoId` int(11) NOT NULL,
  `fDescuento` float DEFAULT NULL,
  PRIMARY KEY (`iIngresoProductoDetalleId`),
  KEY `fk_ingresoProductoDetalle_ingresoProducto1` (`iIngresoProductoId`),
  KEY `fk_ingresoProductoDetalle_producto1` (`iProductoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Volcar la base de datos para la tabla `ingresoproductodetalle`
--

INSERT INTO `ingresoproductodetalle` (`iIngresoProductoDetalleId`, `fIngresoProductoDetallePrecio`, `iIngresoProductoDetalleCantidad`, `fIngresoProductoDetalleTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iIngresoProductoId`, `iProductoId`, `fDescuento`) VALUES
(19, 80, 100, 8000, 0, '2015-01-24', 0, NULL, 'AC', 22, 8, 0),
(20, 80, 100, 8000, 0, '2015-01-31', 0, NULL, 'AC', 23, 8, 0);

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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `vEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iIngresoProductoDevolucionId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcar la base de datos para la tabla `ingresoproductodevolucion`
--


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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  PRIMARY KEY (`iIngresoProductoDevolucionDetalleId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcar la base de datos para la tabla `ingresoproductodevoluciondetalle`
--


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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  `iVentaDevolucionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iKardexId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=219 ;

--
-- Volcar la base de datos para la tabla `kardex`
--

INSERT INTO `kardex` (`iKardexId`, `iProductoId`, `iIngresoProductoId`, `iVentaId`, `dFecha`, `vConcepto`, `iCantIngresoProducto`, `fPuIngresoProducto`, `fTotalngresoProducto`, `iCantVenta`, `fPuVenta`, `fTotalVenta`, `iCantExistencia`, `fPuExistencia`, `fTotalExistencia`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iPeriodoId`, `iVentaDevolucionId`) VALUES
(174, 2, 5, NULL, '2015-01-01', 'COMPRA SEGÃšN BOLETA NÂ° 0001', 200, 5.45, 1090, 0, 0, 0, 200, 5.45, 1090, 2, '2015-01-01', 0, NULL, 'IN', 6, NULL),
(175, 2, NULL, 4, '2015-01-08', 'VENTA SEGÃšN FACTURA NÂ° 001-0011', 0, 0, 0, 1, 5.45, 5.45, 200, 5.45, 1090, 2, '2015-01-08', 0, NULL, 'IN', 7, NULL),
(176, 2, NULL, 4, '2015-01-08', 'XSaldo 0', 0, 0, 0, 0, 0, 0, 200, 5.45, 1090, 0, '2015-01-08', 0, NULL, 'IN', 7, NULL),
(177, 2, NULL, 4, '2015-01-08', 'VENTA SEGÃšN FACTURA NÂ° 001-0011', 0, 0, 0, 1, 5.45, 5.45, 0, 5.45, 0, 2, '2015-01-08', 0, NULL, 'IN', 7, NULL),
(178, 2, NULL, 4, '2015-01-08', 'VENTA SEGÃšN FACTURA NÂ° 001-0011', 0, 0, 0, 1, 5.45, 5.45, 0, 5.45, 0, 2, '2015-01-08', 0, NULL, 'IN', 7, NULL),
(179, 2, NULL, 5, '2015-01-10', 'VENTA SEGÃšN NOTA NÂ° 000N1-0001', 0, 0, 0, 1, 5.45, 5.45, 199, 5.45, 1084.55, 2, '2015-01-10', 0, NULL, 'IN', 7, NULL),
(180, 2, NULL, 5, '2015-01-10', 'VENTA SEGÃšN NOTA NÂ° 000N1-0001', 0, 0, 0, 0, 0, 0, 0, 5.45, 0, 0, '2015-01-10', 0, NULL, 'IN', 7, NULL),
(181, 2, NULL, 5, '2015-01-10', 'VENTA SEGÃšN NOTA NÂ° 000N1-0001', 0, 0, 0, 0, 0, 0, 0, 5.45, 0, 0, '2015-01-10', 0, NULL, 'IN', 7, NULL),
(182, 8, 6, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 0002', 10, 80, 800, 0, 0, 0, 10, 80, 800, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(183, 2, 8, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 12', 1, 5.45, 5.45, 0, 0, 0, 200, 5.45, 1090, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(184, 7, 9, NULL, '2015-01-15', 'COMPRA SEGÃšN NOTA NÂ° 2121', 1, 13, 13, 0, 0, 0, 1, 13, 13, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(185, 2, 10, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 545', 1, 5.45, 5.45, 0, 0, 0, 1, 5.45, 5.45, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(186, 9, 12, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 656', 1, 600, 600, 0, 0, 0, 1, 600, 600, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(187, 9, 13, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 656', 1, 600, 600, 0, 0, 0, 2, 600, 1200, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(188, 9, 15, NULL, '2015-01-15', 'COMPRA SEGÃšN FACTURA NÂ° 156563', 100, 600, 60000, 0, 0, 0, 102, 600, 61200, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(189, 7, 16, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 5454', 100, 13, 1300, 0, 0, 0, 101, 13, 1313, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(190, 8, 17, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 00001-0001', 100, 80, 8000, 0, 0, 0, 110, 80, 8800, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(191, 8, 18, NULL, '2015-01-15', 'COMPRA SEGÃšN FACTURA NÂ° 00001-0001', 100, 80, 8000, 0, 0, 0, 210, 80, 16800, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(192, 8, 19, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 0002', 100, 80, 8000, 0, 0, 0, 310, 80, 24800, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(193, 8, 20, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 00001-0001', 100, 80, 8000, 0, 0, 0, 410, 80, 32800, 2, '2015-01-15', 0, NULL, 'IN', 7, NULL),
(194, 8, 21, NULL, '2015-01-15', 'COMPRA SEGÃšN BOLETA NÂ° 00001-0001', 100, 80, 8000, 0, 0, 0, 100, 80, 8000, 2, '2015-01-15', 2, '2015-01-18', 'IN', 7, NULL),
(195, 2, NULL, 6, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0012', 0, 0, 0, 0, 0, 0, 0, 5.45, 0, 0, '2015-01-20', 0, NULL, 'IN', 7, NULL),
(196, 2, NULL, 6, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0012', 0, 0, 0, 0, 0, 0, 0, 5.45, 0, 0, '2015-01-20', 0, NULL, 'IN', 7, NULL),
(197, 2, NULL, 6, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0012', 0, 0, 0, 10, 5.45, 54.5, 191, 5.45, 1040.95, 2, '2015-01-20', 0, NULL, 'IN', 7, NULL),
(198, 7, NULL, 7, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0013', 0, 0, 0, 10, 13, 130, 91, 13, 1183, 2, '2015-01-20', 0, NULL, 'AC', 7, NULL),
(199, 8, NULL, 8, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0014', 0, 0, 0, 140, 80, 11200, 400, 80, 32000, 2, '2015-01-20', 0, NULL, 'IN', 7, NULL),
(200, 9, NULL, 9, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0015', 0, 0, 0, 100, 600, 60000, 2, 600, 1200, 2, '2015-01-20', 0, NULL, 'AC', 7, NULL),
(201, 2, NULL, 10, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0016', 0, 0, 0, 0, 0, 0, 0, 5.45, 0, 0, '2015-01-20', 0, NULL, 'IN', 7, NULL),
(202, 2, NULL, 10, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0016', 0, 0, 0, 0, 0, 0, 0, 5.45, 0, 0, '2015-01-20', 0, NULL, 'IN', 7, NULL),
(203, 2, NULL, 10, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0016', 0, 0, 0, 100, 5.45, 545, 91, 5.45, 495.95, 2, '2015-01-20', 0, NULL, 'IN', 7, NULL),
(204, 8, NULL, 11, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0017', 0, 0, 0, 100, 80, 8000, 300, 80, 24000, 2, '2015-01-20', 0, NULL, 'IN', 7, NULL),
(205, 8, NULL, 12, '2015-01-20', 'VENTA SEGÃšN FACTURA NÂ° 001-0018', 0, 0, 0, 100, 80, 8000, 200, 80, 16000, 2, '2015-01-20', 0, NULL, 'IN', 7, NULL),
(206, 8, NULL, 13, '2015-01-21', 'VENTA SEGÃšN FACTURA NÂ° 001-0019', 0, 0, 0, 1, 80, 80, 199, 80, 15920, 2, '2015-01-21', 0, NULL, 'IN', 7, NULL),
(207, 8, NULL, NULL, '2015-01-23', 'DEV. VENTA SEGÃšN FACTURA NÂ° 001-0019', 1, 80, 80, 0, 0, 0, 200, 80, 15920, 2, '2015-01-23', 0, NULL, 'IN', 0, 4),
(208, 8, NULL, NULL, '2015-01-23', 'DEV. VENTA SEGÃšN FACTURA NÂ° 001-0014', 100, 80, 8000, 0, 0, 0, 500, 80, 32000, 2, '2015-01-23', 0, NULL, 'IN', 0, 5),
(209, 2, NULL, NULL, '2015-01-23', 'DEV. VENTA SEGÃšN FACTURA NÂ° 001-0012', 0, 0, 0, 0, 0, 0, 0, 5.45, 0, 2, '2015-01-23', 0, NULL, 'AC', 0, 6),
(210, 2, NULL, NULL, '2015-01-23', 'XSaldo 2', 5, 5.45, 27.25, 0, 0, 0, 196, 5.45, 1040.95, 2, '2015-01-23', 0, NULL, 'AC', 0, 6),
(211, 2, NULL, NULL, '2015-01-23', 'XSaldo 1', 0, 0, 0, 0, 0, 0, 0, 5.45, 0, 2, '2015-01-23', 0, NULL, 'AC', 0, 6),
(212, 8, 19, NULL, '2015-01-23', 'DEV. COMPRA SEGÃšN BOLETA NÂ° 0002', 100, 80, 8000, 0, 0, 0, 100, 80, 8000, 2, '2015-01-23', 0, NULL, NULL, 7, NULL),
(213, 8, 21, NULL, '2015-01-23', 'DEV. COMPRA SEGÃšN BOLETA NÂ° 00001-0001', 80, 80, 6400, 0, 0, 0, 80, 80, 6400, 2, '2015-01-23', 0, NULL, NULL, 7, NULL),
(214, 8, 22, NULL, '2015-01-24', 'COMPRA SEGÚN BOLETA N° 00001-0001', 100, 80, 8000, 0, 0, 0, 600, 80, 48000, 2, '2015-01-24', 0, NULL, 'IN', 7, NULL),
(215, 8, NULL, 14, '2015-01-24', 'VENTA SEGÚN FACTURA N° 0001-000001', 0, 0, 0, 100, 80, 8000, 320, 80, 25600, 2, '2015-01-24', 0, NULL, 'IN', 7, NULL),
(216, 8, 23, NULL, '2015-01-31', 'COMPRA SEGÚN BOLETA N° 00001-0001', 100, 80, 8000, 0, 0, 0, 420, 80, 33600, 2, '2015-01-31', 0, NULL, 'IN', 7, NULL),
(217, 8, NULL, 15, '2015-01-31', 'VENTA SEGÚN FACTURA N° 0001-02', 0, 0, 0, 400, 80, 32000, 20, 80, 1600, 2, '2015-01-31', 0, NULL, 'IN', 7, NULL),
(218, 8, NULL, 16, '2015-01-31', 'VENTA SEGÚN FACTURA N° 0001-03', 0, 0, 0, 10, 80, 800, 10, 80, 800, 2, '2015-01-31', 0, NULL, 'AC', 7, NULL);

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `vEstadoLetra` varchar(50) DEFAULT NULL,
  `cEstadoCodigo` char(5) DEFAULT NULL,
  `dFechaPago` date DEFAULT NULL,
  `fImporteIntereses` float DEFAULT NULL,
  `nPlazoLetra` int(11) DEFAULT NULL,
  `iVentaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iLetraClienteId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `letracliente`
--


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
  `dfechaInserta` date DEFAULT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `vEstadoLetra` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cEstadoCodigo` char(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dFechaPago` date DEFAULT NULL,
  `fImporteIntereses` float DEFAULT NULL,
  `nPlazoLetra` int(11) DEFAULT NULL,
  `iIngresoProductoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iletraProveedorId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `letraproveedor`
--


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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` varchar(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vConceptoGeneral` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iKardexId` int(11) DEFAULT NULL,
  `iIngresoProductoId` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iVentaId` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vNumeroAsiento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cCajaBanco` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iLibroDiarioId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=30 ;

--
-- Volcar la base de datos para la tabla `librodiario`
--

INSERT INTO `librodiario` (`iLibroDiarioId`, `iCuentasId`, `fMonto`, `vTipoConcepto`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `vConceptoGeneral`, `iKardexId`, `iIngresoProductoId`, `iVentaId`, `vNumeroAsiento`, `cCajaBanco`, `iPeriodoId`) VALUES
(1, 220, 6956.52, 'D', 2, '2015-01-24', NULL, NULL, 'AC', 'COMPRA/ Mercaderia / NRO de BOLETA: 00001-0001', NULL, '22', NULL, 'ASIENTO N1', '0', 7),
(2, 168, 1043.48, 'D', 2, '2015-01-24', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de BOLETA: 00001-0001', NULL, '22', NULL, 'ASIENTO N1', '0', 7),
(3, 199, 8000, 'H', 2, '2015-01-24', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar', NULL, '22', NULL, 'ASIENTO N1', '0', 7),
(4, 57, 6956.52, 'D', 2, '2015-01-24', NULL, NULL, 'AC', 'MERCADERIA / Almacen / NRO deBOLETA: 00001-0001', NULL, '22', NULL, 'ASIENTO N2', '0', 7),
(5, 225, 6956.52, 'H', 2, '2015-01-24', NULL, NULL, 'AC', 'VARIACION DE EXISTENCIAS / Mercaderia / NRO deBOLETA: 00001-0001', NULL, '22', NULL, 'ASIENTO N2', '0', 7),
(6, 199, 8000, 'D', 2, '2015-01-24', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ', NULL, '22', NULL, 'ASIENTO 3', '0', 7),
(7, 2, 8000, 'H', 2, '2015-01-24', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-01-24 00:05:37 Por el pago realizado de la compra de la mercaderia de la BOLETA NÃ‚Â°: 00001-0001', NULL, '22', NULL, 'ASIENTO N3', '1', 7),
(8, 311, 6779.66, 'H', 2, '2015-01-24', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-000001', NULL, NULL, '14', 'ASIENTO N1', '0', 7),
(9, 168, 1220.34, 'H', 2, '2015-01-24', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-000001', NULL, NULL, '14', 'ASIENTO N1', '0', 7),
(10, 8, 8000, 'D', 2, '2015-01-24', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '14', 'ASIENTO N1', '0', 7),
(11, 8, 8000, 'H', 2, '2015-01-24', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '14', 'ASIENTO N1', '0', 7),
(12, 2, 8000, 'D', 2, '2015-01-24', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-01-24 00:07:58 Por el pago realizado de la compra de la mercaderia de la FACTURA NÃ‚Â°: 0001-000001', NULL, NULL, '14', 'ASIENTO N3', '1', 7),
(13, 220, 6956.52, 'D', 2, '2015-01-31', NULL, NULL, 'AC', 'COMPRA/ Mercaderia / NRO de BOLETA: 00001-0001', NULL, '23', NULL, 'ASIENTO N1', '0', 7),
(14, 168, 1043.48, 'D', 2, '2015-01-31', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de BOLETA: 00001-0001', NULL, '23', NULL, 'ASIENTO N1', '0', 7),
(15, 199, 8000, 'H', 2, '2015-01-31', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar', NULL, '23', NULL, 'ASIENTO N1', '0', 7),
(16, 57, 6956.52, 'D', 2, '2015-01-31', NULL, NULL, 'AC', 'MERCADERIA / Almacen / NRO deBOLETA: 00001-0001', NULL, '23', NULL, 'ASIENTO N2', '0', 7),
(17, 225, 6956.52, 'H', 2, '2015-01-31', NULL, NULL, 'AC', 'VARIACION DE EXISTENCIAS / Mercaderia / NRO deBOLETA: 00001-0001', NULL, '23', NULL, 'ASIENTO N2', '0', 7),
(18, 199, 8000, 'D', 2, '2015-01-31', NULL, NULL, 'AC', 'PROVEEDORES / Facturas, boletas y otros comprobantes por pagar ', NULL, '23', NULL, 'ASIENTO 3', '0', 7),
(19, 2, 8000, 'H', 2, '2015-01-31', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-01-31 13:56:47 Por el pago realizado de la compra de la mercaderia de la BOLETA NÃ‚Â°: 00001-0001', NULL, '23', NULL, 'ASIENTO N3', '1', 7),
(20, 311, 33898.3, 'H', 2, '2015-01-31', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-02', NULL, NULL, '15', 'ASIENTO N1', '0', 7),
(21, 168, 6101.69, 'H', 2, '2015-01-31', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-02', NULL, NULL, '15', 'ASIENTO N1', '0', 7),
(22, 8, 40000, 'D', 2, '2015-01-31', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '15', 'ASIENTO N1', '0', 7),
(23, 8, 40000, 'H', 2, '2015-01-31', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '15', 'ASIENTO N1', '0', 7),
(24, 2, 40000, 'D', 2, '2015-01-31', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-01-31 13:57:18 Por la venta de la mercaderia de la FACTURA N°: 0001-02', NULL, NULL, '15', 'ASIENTO N3', '1', 7),
(25, 311, 677.97, 'H', 2, '2015-01-31', NULL, NULL, 'AC', 'VENTA/ Mercaderia / NRO de FACTURA: 0001-03', NULL, NULL, '16', 'ASIENTO N1', '0', 7),
(26, 168, 122.03, 'H', 2, '2015-01-31', NULL, NULL, 'AC', 'TRIBUTOS POR PAGAR / Gobierno central / IGV / NRO de FACTURA: 0001-03', NULL, NULL, '16', 'ASIENTO N1', '0', 7),
(27, 8, 800, 'D', 2, '2015-01-31', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '16', 'ASIENTO N1', '0', 7),
(28, 8, 800, 'H', 2, '2015-01-31', NULL, NULL, 'AC', 'Clientes / Facturas, boletas y otros comprobantes por pagar', NULL, NULL, '16', 'ASIENTO N1', '0', 7),
(29, 2, 800, 'D', 2, '2015-01-31', NULL, NULL, 'AC', 'CAJA Y BANCOS / Caja / 2015-02-15 Por el pago de la venta de mercaderia de la FACTURA NÃ‚Â°: 0001-03', NULL, NULL, '16', 'ASIENTO N3', '1', 18);

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  PRIMARY KEY (`idMenu`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcar la base de datos para la tabla `menu`
--

INSERT INTO `menu` (`idMenu`, `vMenu`, `vCodigo`) VALUES
(1, 'Inventario', '10'),
(2, 'Cliente', '20'),
(3, 'Proveedor', '30'),
(4, 'Compra', '40'),
(5, 'Venta', '50'),
(6, 'Contabilidad', '60'),
(7, 'Estadisticas', '70'),
(8, 'Admin', '80');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menuopciones`
--

DROP TABLE IF EXISTS `menuopciones`;
CREATE TABLE IF NOT EXISTS `menuopciones` (
  `idmenuOpciones` int(11) NOT NULL AUTO_INCREMENT,
  `idMenutitulo` int(11) DEFAULT NULL,
  `vOpciones` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `vCodigo` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idmenuOpciones`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=42 ;

--
-- Volcar la base de datos para la tabla `menuopciones`
--

INSERT INTO `menuopciones` (`idmenuOpciones`, `idMenutitulo`, `vOpciones`, `vCodigo`) VALUES
(1, 1, 'Categoria', '111'),
(2, 1, 'Mecaderia', '112'),
(3, 1, 'Materia Prima', '113'),
(4, 1, 'Suministro y Repuestos', '114'),
(5, 1, 'Envases y Embalajes', '115'),
(6, 1, 'Gestion de Produccion', '116'),
(7, 2, 'Cliente', '211'),
(8, 2, 'Estado Cuenta Cliente', '212'),
(9, 2, 'Estado Cuenta de Letras', '213'),
(10, 3, 'Proveedor', '311'),
(11, 3, 'Estado Cuenta Proveedor', '312'),
(12, 3, 'Estado Cuenta de Letras', '313'),
(13, 4, 'Compras', '411'),
(14, 4, 'Devolucion de Compras', '412'),
(15, 5, 'Ventas', '511'),
(16, 5, 'Devolucion Ventas', '512'),
(17, 6, 'Ventas', '611'),
(18, 6, 'Devolucion de Ventas', '612'),
(19, 6, 'Estado Cuenta Cliente', '613'),
(20, 7, 'Compras', '621'),
(21, 7, 'Devolucion de Compras', '622'),
(22, 7, 'Estado Cuenta Proveedor', '623'),
(23, 8, 'Productos', '631'),
(24, 8, 'Materias Primas', '632'),
(25, 8, 'Suministro y Repuestos', '633'),
(26, 8, 'Embases y Embalajes', '634'),
(27, 9, 'Caja chica', '641'),
(28, 10, 'Libro diario', '651'),
(29, 10, 'Plan Contable', '652'),
(30, 10, 'Balance General', '653'),
(31, 11, 'Grafico General', '711'),
(32, 11, 'Compras', '712'),
(33, 11, 'Ventas', '713'),
(34, 11, 'Clientes', '714'),
(35, 11, 'Proveedores', '715'),
(36, 12, 'Gestion de Perfil', '811'),
(37, 12, 'Gestion de ÃƒÂrea', '812'),
(38, 12, 'Gestion de Personal', '813'),
(39, 12, 'Gestion de Usuario', '814'),
(40, 12, 'Gestion de Permisos', '815'),
(41, 12, 'Gestion de ParÃƒÂ¡metros', '816');

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
  PRIMARY KEY (`idmenuTitulo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcar la base de datos para la tabla `menutitulo`
--

INSERT INTO `menutitulo` (`idmenuTitulo`, `idMenu`, `vMenuTitulo`, `vCodigo`) VALUES
(1, 1, 'OPCIONES', '11'),
(2, 2, 'OPCIONES', '21'),
(3, 3, 'OPCIONES', '31'),
(4, 4, 'OPCIONES', '41'),
(5, 5, 'OPCIONES', '51'),
(6, 6, 'CLIENTES', '61'),
(7, 6, 'PROVEEDORES', '62'),
(8, 6, 'EXISTENCIAS', '63'),
(9, 6, 'TESORERIA', '64'),
(10, 6, 'PLAN CONTABLE', '65'),
(11, 7, 'OPCIONES', '71'),
(12, 8, 'OPCIONES', '81');

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
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
(2, 'PER02', 'SISTEMAS', 12, 18, '2013-02-02', '2013-02-15', 'AC', '1', '1', '1', '1', '1', '1', '1'),
(3, 'PER03', 'ADMINISTRADOR', 0, NULL, NULL, '2013-02-15', 'AC', '1', '1', '1', '1', '0', '0', '1'),
(4, 'PER04', 'CONTADORES', 0, NULL, NULL, '2013-02-14', 'AC', '0', '1', '1', '0', '1', '0', '1'),
(5, 'PER05', 'CLIENTE EXTERNO', 0, NULL, NULL, '2013-01-04', 'AC', '0', '0', '1', '0', '0', '0', '1'),
(6, 'PE00006', 'LO', 0, 0, '2015-01-01', NULL, 'IN', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cCodigoEstado` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `iEjercicioFiscalId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iPeriodoId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=19 ;

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
  `vCodigoMenu` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cEstado` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idpermisos`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=279 ;

--
-- Volcar la base de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`idpermisos`, `iUsuarioId`, `vCodigoMenu`, `cEstado`) VALUES
(230, 23, '213', 'AC'),
(229, 23, '212', 'AC'),
(228, 23, '211', 'AC'),
(227, 23, '21', 'AC'),
(226, 23, '20', 'AC'),
(225, 23, '116', 'AC'),
(224, 23, '115', 'AC'),
(223, 23, '114', 'AC'),
(222, 23, '113', 'AC'),
(221, 23, '112', 'AC'),
(198, 10, '213', 'AC'),
(188, 2, '815', 'AC'),
(187, 2, '814', 'AC'),
(186, 2, '813', 'AC'),
(185, 2, '812', 'AC'),
(184, 2, '811', 'AC'),
(183, 2, '81', 'AC'),
(182, 2, '80', 'AC'),
(181, 2, '715', 'AC'),
(180, 2, '714', 'AC'),
(179, 2, '713', 'AC'),
(178, 2, '712', 'AC'),
(177, 2, '711', 'AC'),
(176, 2, '71', 'AC'),
(175, 2, '70', 'AC'),
(174, 2, '653', 'AC'),
(173, 2, '652', 'AC'),
(172, 2, '651', 'AC'),
(171, 2, '65', 'AC'),
(170, 2, '641', 'AC'),
(169, 2, '64', 'AC'),
(168, 2, '634', 'AC'),
(167, 2, '633', 'AC'),
(166, 2, '632', 'AC'),
(165, 2, '631', 'AC'),
(164, 2, '63', 'AC'),
(163, 2, '623', 'AC'),
(162, 2, '622', 'AC'),
(161, 2, '621', 'AC'),
(160, 2, '62', 'AC'),
(159, 2, '613', 'AC'),
(158, 2, '612', 'AC'),
(157, 2, '611', 'AC'),
(156, 2, '61', 'AC'),
(155, 2, '60', 'AC'),
(154, 2, '512', 'AC'),
(153, 2, '511', 'AC'),
(152, 2, '51', 'AC'),
(151, 2, '50', 'AC'),
(150, 2, '412', 'AC'),
(149, 2, '411', 'AC'),
(148, 2, '41', 'AC'),
(147, 2, '40', 'AC'),
(146, 2, '313', 'AC'),
(145, 2, '312', 'AC'),
(144, 2, '311', 'AC'),
(143, 2, '31', 'AC'),
(142, 2, '30', 'AC'),
(141, 2, '213', 'AC'),
(140, 2, '212', 'AC'),
(139, 2, '211', 'AC'),
(138, 2, '21', 'AC'),
(137, 2, '20', 'AC'),
(136, 2, '116', 'AC'),
(135, 2, '115', 'AC'),
(134, 2, '114', 'AC'),
(133, 2, '113', 'AC'),
(132, 2, '112', 'AC'),
(131, 2, '111', 'AC'),
(130, 2, '11', 'AC'),
(129, 2, '10', 'AC'),
(197, 10, '212', 'AC'),
(196, 10, '211', 'AC'),
(195, 10, '21', 'AC'),
(194, 10, '20', 'AC'),
(208, 12, '213', 'AC'),
(207, 12, '212', 'AC'),
(206, 12, '211', 'AC'),
(205, 12, '21', 'AC'),
(204, 12, '20', 'AC'),
(220, 23, '111', 'AC'),
(219, 23, '11', 'AC'),
(218, 23, '10', 'AC'),
(231, 23, '30', 'AC'),
(232, 23, '31', 'AC'),
(233, 23, '311', 'AC'),
(234, 23, '312', 'AC'),
(235, 23, '313', 'AC'),
(236, 23, '40', 'AC'),
(237, 23, '41', 'AC'),
(238, 23, '411', 'AC'),
(239, 23, '412', 'AC'),
(240, 23, '50', 'AC'),
(241, 23, '51', 'AC'),
(242, 23, '511', 'AC'),
(243, 23, '512', 'AC'),
(244, 23, '60', 'AC'),
(245, 23, '61', 'AC'),
(246, 23, '611', 'AC'),
(247, 23, '612', 'AC'),
(248, 23, '613', 'AC'),
(249, 23, '62', 'AC'),
(250, 23, '621', 'AC'),
(251, 23, '622', 'AC'),
(252, 23, '623', 'AC'),
(253, 23, '63', 'AC'),
(254, 23, '631', 'AC'),
(255, 23, '632', 'AC'),
(256, 23, '633', 'AC'),
(257, 23, '634', 'AC'),
(258, 23, '64', 'AC'),
(259, 23, '641', 'AC'),
(260, 23, '65', 'AC'),
(261, 23, '651', 'AC'),
(262, 23, '652', 'AC'),
(263, 23, '653', 'AC'),
(264, 23, '70', 'AC'),
(265, 23, '71', 'AC'),
(266, 23, '711', 'AC'),
(267, 23, '712', 'AC'),
(268, 23, '713', 'AC'),
(269, 23, '714', 'AC'),
(270, 23, '715', 'AC'),
(271, 23, '80', 'AC'),
(272, 23, '81', 'AC'),
(273, 23, '811', 'AC'),
(274, 23, '812', 'AC'),
(275, 23, '813', 'AC'),
(276, 23, '814', 'AC'),
(277, 23, '815', 'AC'),
(278, 23, '816', 'AC');

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaAcualiza` date DEFAULT NULL,
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Volcar la base de datos para la tabla `personal`
--

INSERT INTO `personal` (`iPersonalId`, `cPersonalCodigo`, `vPersonalNombres`, `vPersonalApellidoPaterno`, `vPersonalApellidoMaterno`, `nPersonalNumeroDocumento`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaAcualiza`, `cEstadoCodigo`, `iSexoId`, `iTipoDocumentoId`, `iAreaId`, `iOcupacionId`, `fSueldo`) VALUES
(2, 'PER02', 'LIZ ', 'FERANADEZ', 'MELGAREJO', '12345678', 0, NULL, NULL, '2013-02-04', 'AC', 1, 1, 1, 1, NULL),
(13, 'P003', 'DANIEL', 'CARPIO', 'NARVARTE', '25948454', 0, 0, NULL, '2014-03-13', 'AC', 2, 1, 3, 1, NULL),
(14, 'SF001', 'SARITA', 'FERNANDEZ', 'MELGAREJO', '574456454', 0, 0, '2014-02-15', NULL, 'AC', 1, 1, 3, 1, NULL),
(15, 'PE00015', 'DIEGO', 'GONZALES', 'VALDEZ', '46521231', 0, 0, '2015-01-01', NULL, 'AC', 2, 1, 3, 1, NULL),
(16, 'PE00016', 'CAMILA', 'GONZALES', 'FERNANDEZ', '154515', 0, 0, '2015-01-27', NULL, 'AC', 1, 1, 1, 1, 5500);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `planilla`
--

INSERT INTO `planilla` (`iPlanillaId`, `iPersonalId`, `fSueldo`, `fAsignacionFamiliar`, `fTotalRemuneracion`, `fDesSNP`, `fPorDesSNP`, `fDesAFP`, `fPorDesAFP`, `fDesPS`, `fPorDesPS`, `fDesCV`, `fPorDesCV`, `fTotalDescuento`, `fApoESSALUD`, `fPorApoESSALUD`, `fPorApoIES`, `fApoIES`, `fTotalAportes`, `fNetoPago`, `dFechaInserta`, `dFechaActualiza`, `iUsuarioInserta`, `iUsuarioActualiza`, `cEstadoCodigo`, `iPeriodoId`) VALUES
(1, 16, 5500, 75, 5575, 724.75, 0, 0, 0, 0, 0, 0, 0, 724.75, 501.75, 0, 0, 0, 501.75, 4850.25, '2015-01-29 23:58:03', NULL, 2, 0, 'AC', 7),
(2, 14, 1500, 75, 1575, 204.75, 0, 0, 0, 21.26, 0, 0, 0, 226.01, 141.75, 0, 0, 31.5, 173.25, 1348.99, NULL, '2015-01-31 16:39:40', 0, 2, 'AC', 0),
(3, 2, 20000, 75, 20075, 2609.75, 0, 0, 0, 0, 0, 0, 0, 2609.75, 1806.75, 0, 0, 401.5, 2208.25, 17465.3, '2015-01-31 16:47:36', '2015-01-31 16:47:45', 2, 2, 'AC', 7);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=435 ;

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
(80, '140501', 'LIMA'),
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
(81, '140533', 'PACHACAMA'),
(82, '140534', 'LURIN'),
(88, '140536', 'PUNTA HERMOSA'),
(87, '140535', 'CALLAO'),
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
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=45 ;

--
-- Volcar la base de datos para la tabla `preciosproducto`
--

INSERT INTO `preciosproducto` (`iPreciosProductoId`, `iProductoId`, `iCantidadStock`, `fPrecioCompra`, `fGanancia`, `fPrecioVenta`, `fDescuento`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(39, 2, 196, 5.45, 10, 6, 0, 0, 0, '2015-01-01 12:15:31', NULL, 'AC'),
(40, 2, 196, 5.45, 10, 6, 0, 0, 0, '2015-01-01 12:16:09', NULL, 'AC'),
(41, 2, 196, 5.45, 10, 6, 0, 0, 0, '2015-01-01 12:17:11', NULL, 'AC'),
(42, 8, 10, 80, 0, 80, 0, 0, 0, '2015-01-15 00:19:19', NULL, 'AC'),
(43, 7, 91, 13, 20, 15.6, 0, 0, 0, '2015-01-15 00:37:10', NULL, 'AC'),
(44, 9, 1, 600, 25, 750, 0, 0, 0, '2015-01-15 22:32:03', NULL, 'AC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `produccion`
--

DROP TABLE IF EXISTS `produccion`;
CREATE TABLE IF NOT EXISTS `produccion` (
  `iProduccionId` int(11) NOT NULL AUTO_INCREMENT,
  `iCantidad` int(11) NOT NULL,
  `fTotal` float NOT NULL,
  `fManoObra` float NOT NULL,
  `fTransporte` float NOT NULL,
  `fOtros` float NOT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`iProduccionId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=12 ;

--
-- Volcar la base de datos para la tabla `produccion`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producciondetalle`
--

DROP TABLE IF EXISTS `producciondetalle`;
CREATE TABLE IF NOT EXISTS `producciondetalle` (
  `iProduccionDetalleId` int(11) NOT NULL AUTO_INCREMENT,
  `iProductoId` int(11) NOT NULL,
  `iCantidad` int(11) NOT NULL,
  `fTotal` float NOT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish2_ci NOT NULL,
  `iProduccionId` int(11) NOT NULL,
  PRIMARY KEY (`iProduccionDetalleId`),
  KEY `fk_produccion_iProduccionId` (`iProduccionId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=24 ;

--
-- Volcar la base de datos para la tabla `producciondetalle`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `iProductoId` int(11) NOT NULL AUTO_INCREMENT,
  `cProductoCodigo` char(7) NOT NULL,
  `vProductoNombre` varchar(45) NOT NULL,
  `vProductoCapacidad` varchar(11) NOT NULL,
  `iProductoStockCantidad` int(11) NOT NULL,
  `iProductoStockMaximo` int(11) NOT NULL,
  `iProductoStockMinimo` int(11) NOT NULL,
  `fProductoPrecioVenta` float NOT NULL,
  `fProductoGanancia` float NOT NULL,
  `fProductoPrecioCompra` float NOT NULL,
  `iUsuarioInsertaId` int(11) DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iUnidadMedidadId` int(11) DEFAULT NULL,
  `iCategoriaId` int(11) DEFAULT NULL,
  `iProduccionId` int(11) DEFAULT NULL,
  `iUnidadMedidadIdC` int(11) DEFAULT NULL,
  `iMonedaId` int(11) DEFAULT NULL,
  `vUnidadMedidaDescripcionC` varchar(45) DEFAULT NULL,
  `iSubCategoriaId` int(11) DEFAULT NULL,
  `vfoto` varchar(45) DEFAULT NULL,
  `FPRODUCTODESCUENTO` float DEFAULT NULL,
  PRIMARY KEY (`iProductoId`),
  KEY `fk_producto_unidadMedida1` (`iUnidadMedidadId`),
  KEY `fk_producto_unidadMedidaC` (`iUnidadMedidadIdC`),
  KEY `fk_producto_moneda` (`iMonedaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcar la base de datos para la tabla `producto`
--

INSERT INTO `producto` (`iProductoId`, `cProductoCodigo`, `vProductoNombre`, `vProductoCapacidad`, `iProductoStockCantidad`, `iProductoStockMaximo`, `iProductoStockMinimo`, `fProductoPrecioVenta`, `fProductoGanancia`, `fProductoPrecioCompra`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `iUnidadMedidadId`, `iCategoriaId`, `iProduccionId`, `iUnidadMedidadIdC`, `iMonedaId`, `vUnidadMedidaDescripcionC`, `iSubCategoriaId`, `vfoto`, `FPRODUCTODESCUENTO`) VALUES
(1, 'PR01', 'DURACEL BLIZ', '1', 50, 60, 5, 12, 20, 10, 8, 2, NULL, '2013-02-07', 'IN', 8, 2, 0, 2, 1, 'LITROS', NULL, NULL, NULL),
(2, 'PR02', 'DURACEL GALON', '1', 2320, 20, 15, 6, 10, 5.45, 8, 2, NULL, '2013-05-23', 'AC', 3, 4, 0, 2, 1, 'CAJAS', NULL, 'PR02-duracel.jpg', NULL),
(3, 'PR03', 'ACRILITO GALON', '1', -70, 15, 2, 18, 50, 12, 8, 2, NULL, '2013-02-21', 'IN', 3, 2, 0, 2, 1, NULL, NULL, NULL, NULL),
(4, 'PR04', 'PEGAMENTO SECO', '1', 2, 5, 30, 3.5, 0, 0, 8, 2, '2010-12-16', '2011-04-24', 'IN', 5, 1, 0, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'PR05', 'PEGAMENTO MAYOLICA', '1', 0, 10, 20, 7.5, 0, 0, 8, NULL, '2010-12-16', NULL, 'IN', 5, 14, 0, NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'PR00006', 'JUEGO 3 BROCHAS', '3', 100091, 0, 0, 15.6, 20, 13, 2, 2, '2014-12-26', '2015-01-01', 'AC', 1, 5, 0, 9, 1, 'UNIDAD', 13, 'PR00006-3-brochas.jpg', 0),
(8, 'PR00008', 'BOLSA TRES PLIEGOS', '42.5', 49780, 0, 0, 80, 0, 80, 2, 2, '2014-12-27', '2015-01-01', 'AC', 10, 1, 0, 1, 1, 'KILOGRAMO', 1, 'PR00008-cemento sol-42.jpg', 0),
(9, 'PR0009', 'IMPULSO MANUAL', '1', 502, 0, 0, 750, 25, 600, 2, 0, '2015-01-01', NULL, 'AC', 10, 3, 0, 9, 1, 'UNIDAD', 15, 'PR0009-Selladora impulso manual SPFS.jpg', 0),
(10, 'PR00010', 'RESISTIM', '1', 400000, 1000, 12, 0, 0, 10, 2, 2, '2015-01-01', '2015-01-01', 'AC', 10, 8, 0, 9, 1, NULL, NULL, NULL, 0),
(11, 'PR00011', 'CONCRETUM', '1', 60000, 100000, 10000, 0, 0, 8, 2, 2, '2015-01-01', '2015-01-01', 'AC', 10, 7, 0, 9, 1, NULL, NULL, NULL, 0),
(12, 'PR00012', 'BEPO', '10', 999900, 20, 1, 0, 0, 400, 2, 2, '2015-01-01', '2015-01-01', 'AC', 8, 10, 0, 6, 1, NULL, NULL, NULL, 0),
(13, 'PR00013', 'FLUID H2O', '5', 80000, 0, 0, 0, 0, 650, 2, 2, '2015-01-01', '2015-01-01', 'AC', 10, 9, 0, 6, 1, NULL, NULL, NULL, 0),
(14, 'PR00014', 'GALONERA EL REY', '30', 50000, 0, 0, 0, 0, 20, 2, 2, '2015-01-01', '2015-01-01', 'AC', 10, 12, 0, 6, 1, NULL, NULL, NULL, 0),
(15, 'PR00015', 'VINIFAN', '100', 70000, 0, 0, 0, 0, 40, 2, 2, '2015-01-01', '2015-01-01', 'AC', 8, 11, 0, 10, 1, NULL, NULL, NULL, 0);

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iPoblacionId` varchar(6) NOT NULL,
  PRIMARY KEY (`iProveedorId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`iProveedorId`, `cProveedorCodigo`, `vProveedorRazonSocial`, `vProveedorDireccion`, `vProveedorTelefono`, `nProveedorNumeroDocumento`, `iUsuarioInsertaId`, `iUsuarioModificaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `iPoblacionId`) VALUES
(1, 'PRO01', 'PRODUCTOS QUIMICOS SA', 'AV CONQUISTADORES 304 ', '12345678', '1457859632', 8, 8, '2010-12-17', '2011-04-22', 'AC', '82'),
(2, 'PR00002', '15MN', '5', '55', '1254546', 0, 0, NULL, '2015-01-14', 'AC', '140504');

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`iSubCategoriaId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=12 ;

--
-- Volcar la base de datos para la tabla `subcategoria`
--

INSERT INTO `subcategoria` (`iSubCategoriaId`, `iCategoriaId`, `cSubCategoriaCodigo`, `vSubCategoriaDescripcion`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`) VALUES
(1, 1, 'SU00001', 'SOL', 0, 0, '2014-03-25', NULL, 'AC');

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
  `dFechaInserta` date NOT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `cSucursalCodigo` char(7) DEFAULT NULL,
  PRIMARY KEY (`iSucursalId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`iSucursalId`, `vSucursalNombre`, `vSucursalDireccion`, `vSucursalTelefono`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `cSucursalCodigo`) VALUES
(2, 'Macroquimica del Peru', 'Av. pachacutec', '5485540', 1, NULL, '2010-12-18', NULL, 'Ac', NULL),
(3, 'LOCAL AVIACION', 'av.klskld', '55544', 0, 0, '2015-01-26', '2015-01-31', 'AC', 'SU00003'),
(4, 'LOCAL SURCO', 'surco viejo', '54852', 0, 0, '2015-01-31', NULL, 'AC', 'SU00004');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`iTipoDocumentoId`, `cTipoDocumentoCodigo`, `vTipoDocuumentoDescripcion`, `vGestion`, `cEstadoCodigo`) VALUES
(1, 'DC', 'D.N.I', NULL, 'AC'),
(2, 'LM', 'LIBRETA MILITAR', NULL, 'AC'),
(3, 'DP', 'DOCUMENTO DE PASAPORTE', NULL, 'AC'),
(4, 'LE', 'LIBRETA ELECTORAL', NULL, 'AC'),
(5, 'RC', 'RUC', NULL, 'AC'),
(6, 'PN', 'PARTIDA NACIMIENTO', NULL, 'AC');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `tipodocumentogestion`
--

INSERT INTO `tipodocumentogestion` (`iTipoDocumentoGestionId`, `cTipoDocumentoGestionCodigo`, `vTipoDocumentoDescripcion`) VALUES
(1, 'FA', 'FACTURA'),
(2, 'BO', 'BOLETA'),
(3, 'NO', 'NOTA'),
(4, 'GR', 'GUIA DE REMISION');

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) DEFAULT NULL,
  `iPerfilId` int(11) NOT NULL,
  `iPersonalId` int(11) NOT NULL,
  `iSucursalId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iUsuarioId`),
  KEY `fk_usuario_perfil1` (`iPerfilId`),
  KEY `fk_usuario_personal1` (`iPersonalId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=24 ;

--
-- Volcar la base de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`iUsuarioId`, `cUsuarioCodigo`, `vUsuarioLogin`, `vUsuarioPassword`, `iUsuarioInsertaId`, `iUsuarioActualizaId`, `dFechaInserta`, `dFechaActualiza`, `cEstadoCodigo`, `iPerfilId`, `iPersonalId`, `iSucursalId`) VALUES
(2, NULL, 'LFERNANDEZ', '123456', 0, NULL, NULL, '2015-01-31', 'AC', 3, 2, 3),
(10, NULL, 'SARITAFERNANDEZ', 'sarita2014', 0, 0, NULL, '2015-01-31', 'AC', 4, 14, 3),
(12, NULL, 'DANIELCARPIO', 'daniel2014', 0, 0, '2014-03-13', '2015-01-31', 'AC', 5, 13, 4),
(23, NULL, 'DGONZALES', '123456', 0, 0, '2015-01-31', NULL, 'AC', 3, 15, 4);

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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
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
  PRIMARY KEY (`iVentaId`),
  KEY `fk_venta_usuario1` (`iUsuarioId`),
  KEY `fk_venta_cliente1` (`iClienteId`),
  KEY `fk_venta_tipoDocumento1` (`iTipoDocumentoId`),
  KEY `fk_venta_formaPago1` (`iFormaPago`),
  KEY `fk_venta_direccion1` (`idireccionClienteId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Volcar la base de datos para la tabla `venta`
--

INSERT INTO `venta` (`iVentaId`, `nVentaNumero`, `dVentaFecha`, `fVentaTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iUsuarioId`, `iClienteId`, `idireccionClienteId`, `iTipoDocumentoId`, `iFormaPago`, `cVentaOrdenCompra`, `nVentaRuc`, `vVentaPuntoLlegada`, `vPrincipal`, `fVentaGanancia`, `vEstadoVenta`, `fVentaSubTotal`, `fVentaIGV`, `vEstadoDocumento`, `dFechaTraslado`, `dFechaProximoPago`, `fDescuento`, `fMontoAdelantado`, `fVentaTotalReal`, `iNumeroDias`, `iNumeroLetras`, `IperiodoId`, `iSucursalId`) VALUES
(14, '0001-000001', '2015-01-24', 8000, 0, '2015-01-24', 0, NULL, 'AC', 2, 1, 1, 1, 1, '', NULL, 'CARRETERA CENTRAL KM. 23.50CALLE 1 MZ L LT 6 ASOC. LA GRAMA', '1', '0.00', 'CANCELADO', 6779.66, 1220.34, 'CANCELADO', NULL, '2015-01-24', 0, 0, 8000, 0, '1', '7', NULL),
(15, '0001-02', '2015-01-31', 40000, 0, '2015-01-31', 0, NULL, 'AC', 2, 1, 1, 1, 1, '', NULL, 'CARRETERA CENTRAL KM. 23.50CALLE 1 MZ L LT 6 ASOC. LA GRAMA', '1', '0.00', 'CANCELADO', 33898.3, 6101.69, 'CANCELADO', NULL, '2015-01-31', 0, 0, 40000, 0, '1', '7', NULL),
(16, '0001-03', '2015-01-31', 800, 0, '2015-01-31', 0, NULL, 'AC', 2, 1, 1, 1, 2, '', NULL, 'CARRETERA CENTRAL KM. 23.50CALLE 1 MZ L LT 6 ASOC. LA GRAMA', '1', '0.00', 'DEUDA', 677.97, 122.03, 'DEUDA', NULL, '2015-02-15', 0, 0, 800, 15, '1', '7', NULL);

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
  `dFechaInserta` date NOT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) NOT NULL,
  `iProductoId` int(11) NOT NULL,
  `iVentaId` int(11) NOT NULL,
  `fDescuento` float DEFAULT NULL,
  PRIMARY KEY (`iVentaDetalleId`),
  KEY `fk_ventaDetalle_producto1` (`iProductoId`),
  KEY `fk_ventaDetalle_venta1` (`iVentaId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcar la base de datos para la tabla `ventadetalle`
--

INSERT INTO `ventadetalle` (`iVentaDetalleId`, `fVentaDetallePrecio`, `iVentaDetalleCantidad`, `fVentaDetalleTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `iProductoId`, `iVentaId`, `fDescuento`) VALUES
(13, 80, 100, 8000, 2, '2015-01-24', 0, NULL, 'AC', 8, 14, 0),
(14, 100, 400, 40000, 2, '2015-01-31', 0, NULL, 'AC', 8, 15, 0),
(15, 80, 10, 800, 2, '2015-01-31', 0, NULL, 'AC', 8, 16, 0);

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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  `iPeriodoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`iVentaDevolucionId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `ventadevolucion`
--

INSERT INTO `ventadevolucion` (`iVentaDevolucionId`, `iVentaId`, `dVentaDevFecha`, `fVentaDevTotal`, `fVentaDevSubTotal`, `fVentaDevIGV`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `fDescuento`, `iPeriodoId`) VALUES
(4, 13, '2015-01-23', 100, 84.75, 15.25, 2, '2015-01-23', 0, NULL, 'AC', 0, 0),
(5, 8, '2015-01-23', 10000, 8474.58, 1525.42, 2, '2015-01-23', 0, NULL, 'AC', 0, 0),
(6, 6, '2015-01-23', 30, 25.42, 4.58, 2, '2015-01-23', 0, NULL, 'AC', 0, 0);

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
  `dFechaInserta` date DEFAULT NULL,
  `iUsuarioActualizaId` int(11) DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  `cEstadoCodigo` char(2) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fDescuento` float DEFAULT NULL,
  PRIMARY KEY (`iVentaDevolucionDetalleId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `ventadevoluciondetalle`
--

INSERT INTO `ventadevoluciondetalle` (`iVentaDevolucionDetalleId`, `iVentaDevolucionId`, `iProductoId`, `fVentaDevDetallePrecio`, `iVentaDevDetalleCantidad`, `fVentaDevDetalleTotal`, `iUsuarioInsertaId`, `dFechaInserta`, `iUsuarioActualizaId`, `dFechaActualiza`, `cEstadoCodigo`, `fDescuento`) VALUES
(4, 4, 8, 100, 1, 100, 0, '2015-01-23', 0, NULL, 'AC', 0),
(5, 5, 8, 100, 100, 10000, 0, '2015-01-23', 0, NULL, 'AC', 0),
(6, 6, 2, 6, 5, 30, 0, '2015-01-23', 0, NULL, 'AC', 0);

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
  `dFechaInserta` date DEFAULT NULL,
  `dFechaActualiza` date DEFAULT NULL,
  PRIMARY KEY (`iVisitaClienteId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

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
	       
	        /**para cuando el aÃ±o es bisiesto*/
	        if ((anio % 4 = 0) && ((anio % 100 != 0) || (anio % 400 = 0)))then /*si el aÃ±o es bisiesto es divisible entre 4 y 100 o 400*/
	             set  m=29;            
	       else
	          set  m=28 ;/*queda pendiente para aÃ±o bisiesto*/	     
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
       /**ASIENTO NÃ‚Â°1 **/
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
         /**ASIENTO NÃ‚Â°2 **/
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
           /**ASIENTO NÃ‚Â°3 **/
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la compra de la mercaderia de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura)
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
                 VALUES(2,(total-xfMontoAdelantado),'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la compra al vencimiento de la',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago del anticipo en la compra de mercaderÃƒÂ­a de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
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
                 VALUES(201,importeLetra,'H',xiUsuarioId, NOW(), 'AC',CONCAT('PROVEEDORES/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
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
       /**ASIENTO NÃ‚Â°1 **/
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
         /**ASIENTO NÃ‚Â°2 **/
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
           /**ASIENTO NÃ‚Â°3 **/
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la compra de la mercaderia de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura)
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
                 VALUES(2,(total-xfMontoAdelantado),'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la compra al vencimiento de la',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago del anticipo en la compra de mercaderÃƒÂ­a de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
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
                 VALUES(201,importeLetra,'H',xiUsuarioId, NOW(), 'AC',CONCAT('PROVEEDORES/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
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
     SET x = numeroLetra;
     SET fechaVencimiento = xfechaProximoPago;
   

   
       
       SELECT nIngresoProductoDevolucionNumero INTO numeroFactura FROM IngresoProductoDevolucion WHERE iIngresoProductoDevolucionId = xId  ;
       SELECT fIngresoProductoDevolucionSubTotal INTO subTotal FROM IngresoProductoDevolucion  WHERE iIngresoProductoDevolucionId = xId ;
       SELECT fIngresoProductoDevolucionIGV  INTO igv FROM IngresoProductoDevolucion  WHERE iIngresoProductoDevolucionId = xId ;
       SELECT fIngresoProductoDevolucionTotal INTO total FROM IngresoProductoDevolucion  WHERE iIngresoProductoDevolucionId = xId ;
       SELECT vTipoDocumentoDescripcion INTO tipoDocumento FROM tipodocumentogestion 
                    WHERE iTipoDocumentoGestionId = (SELECT iTipoDocumentoId FROM  IngresoProductoDevolucion 
                                                     WHERE iIngresoProductoDevolucionId = xId)  ; 
     /*  SELECT iFormaPagoId INTO xiFormaPagoId FROM IngresoProductoDevolucion  WHERE iIngresoProductoDevolucionId = xId ; */
       SELECT iProveedorId INTO xiProveedorId FROM IngresoProductoDevolucion WHERE iIngresoProductoDevolucionId  = xId ;
       
       
       IF(xMode='I') THEN
       /****************/
       /**ASIENTO NÃ‚Â°1 **/
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
         VALUES(220,subTotal,'H',xiUsuarioId, NOW(), 'AC',CONCAT('POR LA DEVOLUCION/ Mercaderia / NRO de ',tipoDocumento,': ',numeroFactura),xId,'ASIENTO N1','0',xiPeriodoId);
				
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
         /**ASIENTO NÃ‚Â°2 **/
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
           /**ASIENTO NÃ‚Â°3 **/
           /*****************/           
                  
             /**Pago al contado**/
             IF xiFormaPagoId=1 THEN 
              
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la compra de la mercaderia de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura)
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
                 iIngresoProductoDevolucionId, vNumeroAsiento,cCajaBanco, iPeriodoId) 
                 VALUES(2,(total-xfMontoAdelantado),'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la compra al vencimiento de la',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago del anticipo en la compra de mercaderÃƒÂ­a de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
               /**Cambiamos el estado del documento**/
                 UPDATE IngresoProductoDevolucion set vEstadoDocumento='DEUDA' where iIngresoProductoDevolucionId = xId;
               
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
                 VALUES(201,importeLetra,'H',xiUsuarioId, NOW(), 'AC',CONCAT('PROVEEDORES/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
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
       /**ASIENTO NÃ‚Â°1 **/
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
         /**ASIENTO NÃ‚Â°2 **/
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
           /**ASIENTO NÃ‚Â°3 **/
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la compra de la mercaderia de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura)
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
                 VALUES(2,(total-xfMontoAdelantado),'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la compra al vencimiento de la',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago del anticipo en la compra de mercaderÃƒÂ­a de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
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
                 VALUES(201,importeLetra,'H',xiUsuarioId, NOW(), 'AC',CONCAT('PROVEEDORES/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
                SET  x = x + 1; 
                set fechaVencimiento=ADDDATE(fechaVencimiento,  xnumeroDias );
                END WHILE;
            END IF;
            
        
         
         END IF;
         
          Select * from IngresoProductoDevolucion where iIngresoProductoDevolucionId = xId;
                 
    END$$

DROP PROCEDURE IF EXISTS `SP_IDU_PERFIL_PERMISOS`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_IDU_PERFIL_PERMISOS`(
    IN  xiUsuarioId int,
		IN  xvCodigoPermiso VARCHAR(500), 
    IN  xCantidad int)
BEGIN
    DECLARE x INT;    
    DECLARE permisos VARCHAR(45);
    SET x = 1;
    DELETE FROM PERMISOS WHERE iUsuarioId = xiUsuarioId;
     WHILE x  <= xCantidad DO
       SELECT SPLIT_STR(xvCodigoPermiso, '-', x) into permisos;         
        INSERT INTO PERMISOS(iUsuarioId,vCodigoMenu,cEstado) VALUES(xiUsuarioId,permisos,'AC');        
      SET  x = x + 1; 
     END WHILE;
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
       /**ASIENTO NÃ‚Â°1 **/
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
           /**ASIENTO NÃ‚Â°3 **/
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
                 VALUES(2,total,'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por la venta de la mercaderia de la ',tipoDocumento,' N°: ', numeroFactura)
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
                 VALUES(2,(total-xfMontoAdelantado),'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el anticipio de la venta la',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
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
                 VALUES(10,importeLetra,'D',xiUsuarioId, NOW(), 'AC',CONCAT('Clientes/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' N°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
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
       /**ASIENTO NÃ‚Â°1 **/
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
           /**ASIENTO NÃ‚Â°3 **/
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
                 VALUES(2,total,'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la venta de la mercaderia de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura)
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
                 VALUES(2,(total-xfMontoAdelantado),'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la venta  al vencimiento de la',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
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
                 VALUES(2,total,'D',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago de la venta de mercaderia de la ',tipoDocumento,' NÂ°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
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
                 VALUES(10,importeLetra,'D',xiUsuarioId, NOW(), 'AC',CONCAT('ClienteS/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
                SET  x = x + 1; 
                set fechaVencimiento=ADDDATE(fechaVencimiento,  xnumeroDias );
                END WHILE;
            END IF;
            
        
         
         END IF;
         
          Select * from Venta where iVentaId = xId;
                 
    END$$

DROP PROCEDURE IF EXISTS `SP_NRO_DOCUMENTO`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_NRO_DOCUMENTO`(
IN xitipoDocumentoId INT)
BEGIN
  DECLARE xNumeroCorrelativo INT;
  DECLARE xNuevoNumero VARCHAR(20);
  DECLARE xNuevoObtenido2 VARCHAR(20);
  DECLARE xNuevoObtenido1 VARCHAR(20);
  SET xNumeroCorrelativo=0;
  
  
  
  SELECT MAX(SPLIT_STR(nVentaNumero, '-', 1)) INTO xNuevoObtenido1  FROM VENTA WHERE iTipoDocumentoId=xitipoDocumentoId;   
  SELECT MAX(SPLIT_STR(nVentaNumero, '-', 2)) INTO xNuevoObtenido2  FROM VENTA WHERE iTipoDocumentoId=xitipoDocumentoId;
  SELECT COALESCE(CAST(MAX(SPLIT_STR(nVentaNumero, '-', 2)) AS SIGNED INTEGER),0) INTO xNumeroCorrelativo FROM VENTA  WHERE iTipoDocumentoId=xitipoDocumentoId;
  
 
  IF (xNumeroCorrelativo=0) THEN 
  
        IF(xitipoDocumentoId=1) THEN
             SELECT vValor INTO xNuevoNumero FROM CONFIGURACION WHERE vConcepto LIKE '%FACTURA%';
        END IF;
        IF(xitipoDocumentoId=2) THEN
             SELECT vValor INTO xNuevoNumero FROM CONFIGURACION WHERE vConcepto LIKE '%BOLETA%';
        END IF;
        IF(xitipoDocumentoId=3) THEN
             SELECT vValor INTO xNuevoNumero FROM CONFIGURACION WHERE vConcepto LIKE '%NOTA%';
            
        END IF;
        IF(xitipoDocumentoId=4) THEN
             SELECT vValor INTO xNuevoNumero FROM CONFIGURACION WHERE vConcepto LIKE '%GUIA%';
             
        END IF;
   ELSE
          SET xNumeroCorrelativo= xNumeroCorrelativo+1;  
         SET xNuevoNumero=concat(xNuevoObtenido1,'-',UPPER(substring(xNuevoObtenido2, 1,LENGTH(xNumeroCorrelativo))),xNumeroCorrelativo); 
        -- SELECT xNuevoNumero, xNumeroCorrelativo,xitipoDocumentoId ;  
   END IF;
  
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
