SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
DROP SCHEMA IF EXISTS `macrostruts` ;
CREATE SCHEMA IF NOT EXISTS `macrostruts` DEFAULT CHARACTER SET latin1 ;

-- -----------------------------------------------------
-- Table `macrostruts`.`area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`area` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`area` (
  `iAreaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cAreaCodigo` CHAR(7) NOT NULL ,
  `vAreaDescripcion` VARCHAR(45) NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `iUsuarioModificaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  PRIMARY KEY (`iAreaId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`cajachica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`cajachica` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`cajachica` (
  `iCajaChicaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iCuentasId` INT(11) NULL DEFAULT NULL ,
  `fMonto` FLOAT NULL DEFAULT NULL ,
  `vTipoConcepto` VARCHAR(1) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vConceptoGeneral` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iCajaChicaId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 68
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`categoria` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`categoria` (
  `iCategoriaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cCategoriaCodigo` CHAR(7) NOT NULL ,
  `vCategoriaDescripcion` VARCHAR(45) NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `iClasificacionId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iCategoriaId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`clasificacioncategoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`clasificacioncategoria` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`clasificacioncategoria` (
  `iClasificacionId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cClasificacionCodigo` CHAR(7) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vClasificacionDescripcion` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iClasificacionId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`clasificacioncliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`clasificacioncliente` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`clasificacioncliente` (
  `iClasificacionClienteId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vNombre` VARCHAR(45) NULL DEFAULT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  PRIMARY KEY (`iClasificacionClienteId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`cliente` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`cliente` (
  `iClienteId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vClienteCodigo` CHAR(7) NOT NULL ,
  `vNombreCliente` VARCHAR(50) NULL DEFAULT NULL ,
  `vClienteRazonSocial` VARCHAR(100) NOT NULL ,
  `nClienteNumeroDocumento` DECIMAL(11,0) NULL DEFAULT NULL ,
  `nClienteTelefono` VARCHAR(50) NULL DEFAULT NULL ,
  `vRubro` VARCHAR(45) NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  `iClasificacionClienteId` INT(11) NULL DEFAULT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`iClienteId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`configuracion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`configuracion` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`configuracion` (
  `iConfiguracionId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vConcepto` VARCHAR(200) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vValor` VARCHAR(15) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iConfiguracionId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`cuentas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`cuentas` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`cuentas` (
  `iCuentasId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iElementoCuentasId` INT(11) NULL DEFAULT NULL ,
  `vCodigo` VARCHAR(10) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vDescripcion` VARCHAR(60) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iCuentasId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 341
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`venta` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`venta` (
  `iVentaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `nVentaNumero` VARCHAR(50) NOT NULL ,
  `dVentaFecha` DATE NOT NULL ,
  `fVentaTotal` FLOAT NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `iUsuarioId` INT(11) NOT NULL ,
  `iClienteId` INT(11) NOT NULL ,
  `idireccionClienteId` INT(11) NOT NULL ,
  `iTipoDocumentoId` INT(11) NOT NULL ,
  `iFormaPago` INT(11) NOT NULL ,
  `cVentaOrdenCompra` CHAR(10) NULL DEFAULT NULL ,
  `nVentaRuc` CHAR(11) NULL DEFAULT NULL ,
  `vVentaPuntoLlegada` VARCHAR(120) NULL DEFAULT NULL ,
  `vPrincipal` VARCHAR(1) NULL DEFAULT NULL ,
  `fVentaGanancia` DECIMAL(5,2) NOT NULL ,
  `vEstadoVenta` VARCHAR(50) NOT NULL ,
  `fVentaSubTotal` FLOAT NOT NULL ,
  `fVentaIGV` FLOAT NOT NULL ,
  `vEstadoDocumento` VARCHAR(45) NULL DEFAULT NULL ,
  `dFechaTraslado` DATE NULL DEFAULT NULL ,
  `dFechaProximoPago` DATE NULL DEFAULT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `fMontoAdelantado` FLOAT NULL DEFAULT NULL ,
  `fVentaTotalReal` FLOAT NULL DEFAULT NULL ,
  `iNumeroDias` INT(11) NULL DEFAULT NULL ,
  `iNumeroLetras` VARCHAR(45) NULL DEFAULT NULL ,
  `IperiodoId` VARCHAR(45) NULL DEFAULT NULL ,
  `iSucursalId` INT(11) NULL DEFAULT NULL ,
  `fTipoCambio` FLOAT NULL DEFAULT NULL ,
  `iMonedaId` INT(11) NULL DEFAULT NULL ,
  `fMontoPago` FLOAT NULL DEFAULT NULL ,
  `fMontoVuelto` FLOAT NULL DEFAULT NULL ,
  `vTipoPago` VARCHAR(5) NULL DEFAULT NULL ,
  `fDescClienteVenta` FLOAT NULL DEFAULT NULL ,
  `vIncluyeIGV` VARCHAR(5) NULL DEFAULT NULL ,
  `vTipoVenta` VARCHAR(5) NULL DEFAULT NULL ,
  `vPorcentajeIGV` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`iVentaId`) ,
  INDEX `fk_venta_usuario1` (`iUsuarioId` ASC) ,
  INDEX `fk_venta_cliente1` (`iClienteId` ASC) ,
  INDEX `fk_venta_tipoDocumento1` (`iTipoDocumentoId` ASC) ,
  INDEX `fk_venta_formaPago1` (`iFormaPago` ASC) ,
  INDEX `fk_venta_direccion1` (`idireccionClienteId` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 35
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`cuota`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`cuota` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`cuota` (
  `iCuotaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iCuotaNumero` INT(11) NOT NULL ,
  `fCuotaInteres` FLOAT NOT NULL ,
  `fCuotaMonto` FLOAT NOT NULL ,
  `dCuotaFecha` DATE NOT NULL ,
  `vCuotaDescripcion` VARCHAR(45) NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NOT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `iVentaId` INT(11) NOT NULL ,
  PRIMARY KEY (`iCuotaId`) ,
  INDEX `fk_cuota_venta1` (`iVentaId` ASC) ,
  CONSTRAINT `fk_cuota_venta1`
    FOREIGN KEY (`iVentaId` )
    REFERENCES `macrostruts`.`venta` (`iVentaId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`direccioncliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`direccioncliente` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`direccioncliente` (
  `idireccionClienteId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iClienteId` INT(11) NOT NULL ,
  `iPoblacionId` VARCHAR(6) NOT NULL ,
  `vDireccion` VARCHAR(45) NULL DEFAULT NULL ,
  `vReferencia` VARCHAR(45) NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  `vPrincipal` CHAR(2) NULL DEFAULT NULL ,
  PRIMARY KEY (`idireccionClienteId`) ,
  UNIQUE INDEX `idireccionClienteId` (`idireccionClienteId` ASC) ,
  INDEX `fk_direccionCliente_cliente1` (`iClienteId` ASC) ,
  INDEX `fk_direccionCliente` (`iClienteId` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 81
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`ejerciciofiscal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`ejerciciofiscal` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`ejerciciofiscal` (
  `iEjercicioFiscalId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vCodigoEjercicio` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vNombreEjercicio` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `dFechaInicio` DATE NULL DEFAULT NULL ,
  `dFechaFin` DATE NULL DEFAULT NULL ,
  `iUsuarioInserta` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualiza` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cCodigoEstado` CHAR(10) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iEjercicioFiscalId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`elementocuentas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`elementocuentas` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`elementocuentas` (
  `iElementoCuentasId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vElemento` VARCHAR(15) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vDescripcion` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iElementoCuentasId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`empresa` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`empresa` (
  `iEmpresaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cEmpresaCodigo` VARCHAR(45) NULL DEFAULT NULL ,
  `vEmpresaNombre` VARCHAR(45) NULL DEFAULT NULL ,
  `vEmpresaRuc` VARCHAR(10) NULL DEFAULT NULL ,
  `vEmpresaDireccion` VARCHAR(70) NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  PRIMARY KEY (`iEmpresaId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`estado` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`estado` (
  `iEstadoId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `vEstadoDescripcion` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`iEstadoId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`estadocuentacliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`estadocuentacliente` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`estadocuentacliente` (
  `iEstadoCuentaCliente` INT(11) NOT NULL AUTO_INCREMENT ,
  `iClienteId` INT(11) NOT NULL ,
  `fMontoPago` FLOAT NOT NULL ,
  `iVentaId` INT(11) NOT NULL ,
  `dFechaPago` DATE NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  PRIMARY KEY (`iEstadoCuentaCliente`) ,
  INDEX `fk_estadoCuentaCliente_cliente1` (`iClienteId` ASC) ,
  INDEX `fk_estadoCuentaCliente_venta1` (`iVentaId` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`estadocuentaproveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`estadocuentaproveedor` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`estadocuentaproveedor` (
  `iEstadoCuentaProveedor` INT(11) NOT NULL AUTO_INCREMENT ,
  `fMontoPago` FLOAT NOT NULL ,
  `dFechaPago` DATE NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  `iProveedorId` INT(11) NOT NULL ,
  `iIngresoProductoId` INT(11) NOT NULL ,
  `sVendedor` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`iEstadoCuentaProveedor`) ,
  INDEX `fk_estadoCuentaProveedor_proveedor1` (`iProveedorId` ASC) ,
  INDEX `fk_estadoCuentaProveedor_ingresoProducto1` (`iIngresoProductoId` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`formapago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`formapago` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`formapago` (
  `iFormaPago` INT(11) NOT NULL AUTO_INCREMENT ,
  `vFormaPagoDescripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`iFormaPago`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`impuestos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`impuestos` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`impuestos` (
  `iImpuestosId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vNombreImpuesto` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vAplicacionImpuesto` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vPorcentaje` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iUsuarioInserta` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `cCodigoEstado` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iImpuestosId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci
COMMENT = '\'o';


-- -----------------------------------------------------
-- Table `macrostruts`.`ingresoproducto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`ingresoproducto` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`ingresoproducto` (
  `iIngresoProductoId` INT(11) NOT NULL AUTO_INCREMENT ,
  `nIngresoProductoNumero` VARCHAR(25) NOT NULL ,
  `dIngresoProductoFecha` DATE NOT NULL ,
  `fIngresoProductoTotal` FLOAT NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `dFechaInserta` DATE NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATE NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `iProveedorId` INT(11) NOT NULL ,
  `iTipoDocumentoId` INT(11) NOT NULL ,
  `iFormaPagoId` INT(11) NULL DEFAULT NULL ,
  `vPrincipal` VARCHAR(1) NULL DEFAULT NULL ,
  `fIngresoProductoSubTotal` FLOAT NULL DEFAULT NULL ,
  `fIngresoProductoIGV` FLOAT NULL DEFAULT NULL ,
  `vEstadoDocumento` VARCHAR(45) NULL DEFAULT NULL ,
  `vIngresoProductoPuntoLlegada` VARCHAR(45) NULL DEFAULT NULL ,
  `dFechaProximoPago` DATE NULL DEFAULT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `fIngresoProductoTotalReal` FLOAT NULL DEFAULT NULL ,
  `fMontoAdelantado` FLOAT NULL DEFAULT NULL ,
  `fPercepcion` FLOAT NULL DEFAULT NULL ,
  `iNumeroDias` INT(11) NULL DEFAULT NULL ,
  `iNumeroLetras` INT(11) NULL DEFAULT NULL ,
  `iPeriodoId` INT(11) NULL DEFAULT NULL ,
  `iSucursalId` INT(11) NULL DEFAULT NULL ,
  `fTipoCambio` FLOAT NULL DEFAULT NULL ,
  `iMonedaId` INT(11) NULL DEFAULT NULL ,
  `fMontoPago` FLOAT NULL DEFAULT NULL ,
  `fMontoVuelto` FLOAT NULL DEFAULT NULL ,
  `vTipoPago` VARCHAR(5) NULL DEFAULT NULL ,
  `fDescProveedorCompra` FLOAT NULL DEFAULT NULL ,
  `vIncluyeIGV` VARCHAR(5) NULL DEFAULT NULL ,
  `vTipoCompra` VARCHAR(5) NULL DEFAULT NULL COMMENT '\'es el tipo compra en simbolo de moned' ,
  `vPorcentajeIGV` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`iIngresoProductoId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`moneda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`moneda` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`moneda` (
  `iMonedaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cModenaCodigo` VARCHAR(3) NOT NULL ,
  `vMonedaDescripcion` VARCHAR(45) NOT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  PRIMARY KEY (`iMonedaId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`unidadmedida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`unidadmedida` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`unidadmedida` (
  `iUnidadMedidaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cUnidadMedidaCodigo` VARCHAR(5) NOT NULL ,
  `vUnidadMedidaDescripcion` VARCHAR(45) NOT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  PRIMARY KEY (`iUnidadMedidaId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`producto` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`producto` (
  `iProductoId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cProductoCodigo` CHAR(7) NOT NULL ,
  `vProductoNombre` VARCHAR(45) NOT NULL ,
  `vProductoCapacidad` VARCHAR(11) NULL DEFAULT NULL ,
  `iProductoStockCantidad` INT(11) NULL DEFAULT NULL ,
  `iProductoStockMaximo` INT(11) NULL DEFAULT NULL ,
  `iProductoStockMinimo` INT(11) NULL DEFAULT NULL ,
  `fProductoPrecioVenta` FLOAT NOT NULL ,
  `fProductoGanancia` FLOAT NULL DEFAULT NULL ,
  `fProductoPrecioCompra` FLOAT NOT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  `iUnidadMedidadId` INT(11) NULL DEFAULT NULL ,
  `iCategoriaId` INT(11) NULL DEFAULT NULL ,
  `iProduccionId` INT(11) NULL DEFAULT NULL ,
  `iUnidadMedidadIdC` INT(11) NULL DEFAULT NULL ,
  `iMonedaId` INT(11) NULL DEFAULT NULL ,
  `vUnidadMedidaDescripcionC` VARCHAR(45) NULL DEFAULT NULL ,
  `iSubCategoriaId` INT(11) NULL DEFAULT NULL ,
  `vfoto` VARCHAR(45) NULL DEFAULT NULL ,
  `fProductoDescuento` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`iProductoId`) ,
  INDEX `fk_producto_unidadMedida1` (`iUnidadMedidadId` ASC) ,
  INDEX `fk_producto_unidadMedidaC` (`iUnidadMedidadIdC` ASC) ,
  INDEX `fk_producto_moneda` (`iMonedaId` ASC) ,
  CONSTRAINT `fk_producto_moneda`
    FOREIGN KEY (`iMonedaId` )
    REFERENCES `macrostruts`.`moneda` (`iMonedaId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_unidadMedida1`
    FOREIGN KEY (`iUnidadMedidadId` )
    REFERENCES `macrostruts`.`unidadmedida` (`iUnidadMedidaId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`ingresoproductodetalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`ingresoproductodetalle` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`ingresoproductodetalle` (
  `iIngresoProductoDetalleId` INT(11) NOT NULL AUTO_INCREMENT ,
  `fIngresoProductoDetallePrecio` FLOAT NOT NULL ,
  `iIngresoProductoDetalleCantidad` INT(11) NOT NULL ,
  `fIngresoProductoDetalleTotal` FLOAT NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NOT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `iIngresoProductoId` INT(11) NOT NULL ,
  `iProductoId` INT(11) NOT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `iSubCta` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iIngresoProductoDetalleId`) ,
  INDEX `fk_ingresoProductoDetalle_ingresoProducto1` (`iIngresoProductoId` ASC) ,
  INDEX `fk_ingresoProductoDetalle_producto1` (`iProductoId` ASC) ,
  CONSTRAINT `fk_ingresoProductoDetalle_ingresoProducto1`
    FOREIGN KEY (`iIngresoProductoId` )
    REFERENCES `macrostruts`.`ingresoproducto` (`iIngresoProductoId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingresoProductoDetalle_producto1`
    FOREIGN KEY (`iProductoId` )
    REFERENCES `macrostruts`.`producto` (`iProductoId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`ingresoproductodevolucion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`ingresoproductodevolucion` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`ingresoproductodevolucion` (
  `iIngresoProductoDevolucionId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iIngresoProductoId` INT(11) NULL DEFAULT NULL ,
  `dIngresoProductoDevFecha` DATE NULL DEFAULT NULL ,
  `fIngresoProductoDev` FLOAT NULL DEFAULT NULL ,
  `fIngresoProductoDevSubTotal` FLOAT NULL DEFAULT NULL ,
  `fIngresoProductoDevIGV` FLOAT NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `vEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `iPeriodoId` INT(11) NULL DEFAULT NULL ,
  `nNroNotaDebito` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iTipoDocumentoId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iIngresoProductoDevolucionId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`ingresoproductodevoluciondetalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`ingresoproductodevoluciondetalle` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`ingresoproductodevoluciondetalle` (
  `iIngresoProductoDevolucionDetalleId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iIngresoProductoDevolucionId` INT(11) NULL DEFAULT NULL ,
  `iProductoId` INT(11) NULL DEFAULT NULL ,
  `fIngresoProductoDevDetallePrecio` FLOAT NULL DEFAULT NULL ,
  `iIngresoProductoDevDetalleCantidad` INT(11) NULL DEFAULT NULL ,
  `fIngresoProductoDevDetalleTotal` FLOAT NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `iSubCta` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iIngresoProductoDevolucionDetalleId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`kardex`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`kardex` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`kardex` (
  `iKardexId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iProductoId` INT(11) NULL DEFAULT NULL ,
  `iIngresoProductoId` INT(11) NULL DEFAULT NULL ,
  `iVentaId` INT(11) NULL DEFAULT NULL ,
  `dFecha` DATE NULL DEFAULT NULL ,
  `vConcepto` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iCantIngresoProducto` INT(11) NULL DEFAULT NULL ,
  `fPuIngresoProducto` FLOAT NULL DEFAULT NULL ,
  `fTotalngresoProducto` FLOAT NULL DEFAULT NULL ,
  `iCantVenta` INT(11) NULL DEFAULT NULL ,
  `fPuVenta` FLOAT NULL DEFAULT NULL ,
  `fTotalVenta` FLOAT NULL DEFAULT NULL ,
  `iCantExistencia` INT(11) NULL DEFAULT NULL ,
  `fPuExistencia` FLOAT NULL DEFAULT NULL ,
  `fTotalExistencia` FLOAT NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iPeriodoId` INT(11) NULL DEFAULT NULL ,
  `iVentaDevolucionId` INT(11) NULL DEFAULT NULL ,
  `iProduccionId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iKardexId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 273
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`letracliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`letracliente` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`letracliente` (
  `iLetraClienteId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iClienteId` INT(11) NULL DEFAULT NULL ,
  `nNumeroLetra` INT(11) NULL DEFAULT NULL ,
  `nNumeroUnico` VARCHAR(50) NULL DEFAULT NULL ,
  `nRefGirador` VARCHAR(45) NULL DEFAULT NULL ,
  `vLugarGiro` VARCHAR(50) NULL DEFAULT NULL ,
  `dFechaGiro` DATE NULL DEFAULT NULL ,
  `dFechaVencimiento` DATE NULL DEFAULT NULL ,
  `dFechaProrroga` DATE NULL DEFAULT NULL ,
  `nImporte` DECIMAL(10,2) NULL DEFAULT NULL ,
  `vImporteLetras` VARCHAR(45) NULL DEFAULT NULL ,
  `iEmpresaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `vEstadoLetra` VARCHAR(50) NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(5) NULL DEFAULT NULL ,
  `dFechaPago` DATE NULL DEFAULT NULL ,
  `fImporteIntereses` FLOAT NULL DEFAULT NULL ,
  `nPlazoLetra` INT(11) NULL DEFAULT NULL ,
  `iVentaId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iLetraClienteId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`letraproveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`letraproveedor` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`letraproveedor` (
  `iletraProveedorId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iProveedorId` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `nNumeroLetra` INT(11) NULL DEFAULT NULL ,
  `nNumeroUnico` INT(11) NULL DEFAULT NULL ,
  `dFechaGiro` DATE NULL DEFAULT NULL ,
  `dFechaVencimiento` DATE NULL DEFAULT NULL ,
  `dFechaProrroga` DATE NULL DEFAULT NULL ,
  `nImporte` FLOAT NULL DEFAULT NULL ,
  `dfechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `vEstadoLetra` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(5) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `dFechaPago` DATE NULL DEFAULT NULL ,
  `fImporteIntereses` FLOAT NULL DEFAULT NULL ,
  `nPlazoLetra` INT(11) NULL DEFAULT NULL ,
  `iIngresoProductoId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iletraProveedorId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`librodiario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`librodiario` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`librodiario` (
  `iLibroDiarioId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iCuentasId` INT(11) NULL DEFAULT NULL ,
  `fMonto` FLOAT NULL DEFAULT NULL ,
  `vTipoConcepto` VARCHAR(1) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` VARCHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vConceptoGeneral` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iKardexId` INT(11) NULL DEFAULT NULL ,
  `iIngresoProductoId` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iVentaId` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vNumeroAsiento` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `cCajaBanco` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iPeriodoId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iLibroDiarioId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 189
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`libromayor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`libromayor` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`libromayor` (
  `iLibroMayorId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iCuentasId` INT(11) NULL DEFAULT NULL ,
  `fMontoDebe` FLOAT NULL DEFAULT NULL ,
  `fMontoHaber` FLOAT NULL DEFAULT NULL ,
  `iPeriodoId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iLibroMayorId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`menu` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`menu` (
  `idMenu` INT(11) NOT NULL AUTO_INCREMENT ,
  `vMenu` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vCodigo` VARCHAR(3) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`idMenu`) )
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`menuaccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`menuaccion` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`menuaccion` (
  `iMenuAccionId` INT(11) NOT NULL AUTO_INCREMENT ,
  `idmenuOpciones` INT(11) NULL DEFAULT NULL ,
  `vAccion` VARCHAR(45) NULL DEFAULT NULL ,
  `vCodigo` VARCHAR(4) NULL DEFAULT NULL ,
  PRIMARY KEY (`iMenuAccionId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 258
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`menuopciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`menuopciones` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`menuopciones` (
  `idmenuOpciones` INT(11) NOT NULL AUTO_INCREMENT ,
  `idMenutitulo` INT(11) NULL DEFAULT NULL ,
  `vOpciones` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vCodigo` VARCHAR(4) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`idmenuOpciones`) )
ENGINE = InnoDB
AUTO_INCREMENT = 56
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`menutitulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`menutitulo` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`menutitulo` (
  `idmenuTitulo` INT(11) NOT NULL ,
  `idMenu` INT(11) NULL DEFAULT NULL ,
  `vMenuTitulo` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vCodigo` VARCHAR(3) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`idmenuTitulo`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`mes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`mes` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`mes` (
  `iMesId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vMesDescripcion` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`iMesId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`ocupacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`ocupacion` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`ocupacion` (
  `iOcupacionId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cOcupacionCodigo` CHAR(7) NULL DEFAULT NULL ,
  `vOcupacionDescripcion` VARCHAR(45) NULL DEFAULT NULL ,
  `iUsuarioInserta` INT(11) NULL DEFAULT NULL ,
  `iUsuarioModifica` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  PRIMARY KEY (`iOcupacionId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`perfil` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`perfil` (
  `iPerfilId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cPerfilCodigo` CHAR(7) NOT NULL ,
  `vPerfilDescripcion` VARCHAR(45) NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `cInventario` CHAR(1) NULL DEFAULT NULL ,
  `cProveedor` CHAR(1) NULL DEFAULT NULL ,
  `cClientes` CHAR(1) NULL DEFAULT NULL ,
  `cCompras` CHAR(1) NULL DEFAULT NULL ,
  `cVentas` CHAR(1) NULL DEFAULT NULL ,
  `cEstadisticas` CHAR(1) NULL DEFAULT NULL ,
  `cMantenimiento` CHAR(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`iPerfilId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`periodo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`periodo` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`periodo` (
  `iPeriodoId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vCodigoPeriodo` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vNombrePeriodo` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `dFechaInicio` DATE NULL DEFAULT NULL ,
  `dFechaFin` DATE NULL DEFAULT NULL ,
  `iUsuarioInserta` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualiza` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cCodigoEstado` VARCHAR(10) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iEjercicioFiscalId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iPeriodoId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`permisos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`permisos` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`permisos` (
  `idpermisos` INT(11) NOT NULL AUTO_INCREMENT ,
  `iUsuarioId` INT(11) NULL DEFAULT NULL ,
  `vCodigoMenu` VARCHAR(5) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `cEstado` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`idpermisos`) )
ENGINE = InnoDB
AUTO_INCREMENT = 1314
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`personal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`personal` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`personal` (
  `iPersonalId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cPersonalCodigo` CHAR(7) NOT NULL ,
  `vPersonalNombres` VARCHAR(45) NOT NULL ,
  `vPersonalApellidoPaterno` VARCHAR(45) NOT NULL ,
  `vPersonalApellidoMaterno` VARCHAR(45) NOT NULL ,
  `nPersonalNumeroDocumento` DECIMAL(10,0) NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaAcualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  `iSexoId` INT(11) NOT NULL ,
  `iTipoDocumentoId` INT(11) NOT NULL ,
  `iAreaId` INT(11) NOT NULL ,
  `iOcupacionId` INT(11) NULL DEFAULT NULL ,
  `fSueldo` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`iPersonalId`) ,
  INDEX `fk_personal_sexo1` (`iSexoId` ASC) ,
  INDEX `fk_personal_tipoDocumento1` (`iTipoDocumentoId` ASC) ,
  INDEX `fk_personal_area1` (`iAreaId` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`planilla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`planilla` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`planilla` (
  `iPlanillaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iPersonalId` INT(11) NULL DEFAULT NULL ,
  `fSueldo` FLOAT NULL DEFAULT NULL ,
  `fAsignacionFamiliar` FLOAT NULL DEFAULT NULL ,
  `fTotalRemuneracion` FLOAT NULL DEFAULT NULL ,
  `fDesSNP` FLOAT NULL DEFAULT NULL ,
  `fPorDesSNP` FLOAT NULL DEFAULT NULL ,
  `fDesAFP` FLOAT NULL DEFAULT NULL ,
  `fPorDesAFP` FLOAT NULL DEFAULT NULL ,
  `fDesPS` FLOAT NULL DEFAULT NULL ,
  `fPorDesPS` FLOAT NULL DEFAULT NULL ,
  `fDesCV` FLOAT NULL DEFAULT NULL ,
  `fPorDesCV` FLOAT NULL DEFAULT NULL ,
  `fTotalDescuento` FLOAT NULL DEFAULT NULL ,
  `fApoESSALUD` FLOAT NULL DEFAULT NULL ,
  `fPorApoESSALUD` FLOAT NULL DEFAULT NULL ,
  `fPorApoIES` FLOAT NULL DEFAULT NULL ,
  `fApoIES` FLOAT NULL DEFAULT NULL ,
  `fTotalAportes` FLOAT NULL DEFAULT NULL ,
  `fNetoPago` FLOAT NULL DEFAULT NULL ,
  `dFechaInserta` TIMESTAMP NULL DEFAULT NULL ,
  `dFechaActualiza` TIMESTAMP NULL DEFAULT NULL ,
  `iUsuarioInserta` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualiza` INT(11) NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  `iPeriodoId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iPlanillaId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`poblacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`poblacion` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`poblacion` (
  `iPoblacionId` INT(10) NOT NULL AUTO_INCREMENT ,
  `cCodigo` CHAR(6) NOT NULL ,
  `vDescripcion` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`iPoblacionId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 435
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`preciosproducto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`preciosproducto` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`preciosproducto` (
  `iPreciosProductoId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iProductoId` INT(11) NULL DEFAULT NULL ,
  `iCantidadStock` INT(11) NULL DEFAULT NULL ,
  `fPrecioCompra` FLOAT NULL DEFAULT NULL ,
  `fGanancia` FLOAT NULL DEFAULT NULL ,
  `fPrecioVenta` FLOAT NULL DEFAULT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iPreciosProductoId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 75
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`produccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`produccion` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`produccion` (
  `iProduccionId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iCantidad` INT(11) NULL DEFAULT NULL ,
  `fCostoUni` FLOAT NULL DEFAULT NULL ,
  `fCostoTotal` FLOAT NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish2_ci' NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualiza` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `fOtrosCostos` FLOAT NULL DEFAULT NULL ,
  `vDescripcion` VARCHAR(150) CHARACTER SET 'utf8' COLLATE 'utf8_spanish2_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iProduccionId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`producciondetalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`producciondetalle` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`producciondetalle` (
  `iProduccionDetalleId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iProductoId` INT(11) NULL DEFAULT NULL ,
  `iCantidad` INT(11) NULL DEFAULT NULL ,
  `vDescripcion` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish2_ci' NULL DEFAULT NULL ,
  `fCostoUni` FLOAT NULL DEFAULT NULL ,
  `fTotal` FLOAT NULL DEFAULT NULL ,
  `iPersonalId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish2_ci' NULL DEFAULT NULL ,
  `iProduccionId` INT(11) NOT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`iProduccionDetalleId`) ,
  INDEX `fk_produccion_iProduccionId` (`iProduccionId` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 43
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`proveedor` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`proveedor` (
  `iProveedorId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cProveedorCodigo` CHAR(7) NOT NULL ,
  `vProveedorRazonSocial` VARCHAR(100) NULL DEFAULT NULL ,
  `vProveedorDireccion` VARCHAR(45) NOT NULL ,
  `vProveedorTelefono` VARCHAR(15) NULL DEFAULT NULL ,
  `nProveedorNumeroDocumento` DECIMAL(11,0) NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `iUsuarioModificaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `iPoblacionId` VARCHAR(6) NOT NULL ,
  PRIMARY KEY (`iProveedorId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`salidaproducto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`salidaproducto` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`salidaproducto` (
  `iSalidaProductoId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vSalidaProductoMotivo` VARCHAR(45) NOT NULL ,
  `dSalidaProductoFecha` DATE NOT NULL ,
  `iCantidad` INT(11) NOT NULL ,
  `cSalidaProductoAutorizado` CHAR(1) NOT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  `iProveedorId` INT(11) NOT NULL ,
  `iProductoId` INT(11) NOT NULL ,
  PRIMARY KEY (`iSalidaProductoId`) ,
  INDEX `fk_salidaProducto_proveedor1` (`iProveedorId` ASC) ,
  INDEX `fk_salidaProducto_producto1` (`iProductoId` ASC) ,
  CONSTRAINT `fk_salidaProducto_producto1`
    FOREIGN KEY (`iProductoId` )
    REFERENCES `macrostruts`.`producto` (`iProductoId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_salidaProducto_proveedor1`
    FOREIGN KEY (`iProveedorId` )
    REFERENCES `macrostruts`.`proveedor` (`iProveedorId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`usuario` (
  `iUsuarioId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cUsuarioCodigo` CHAR(7) NULL DEFAULT NULL ,
  `vUsuarioLogin` VARCHAR(20) NOT NULL ,
  `vUsuarioPassword` VARCHAR(10) NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NULL DEFAULT NULL ,
  `iPerfilId` INT(11) NOT NULL ,
  `iPersonalId` INT(11) NOT NULL ,
  `iSucursalId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iUsuarioId`) ,
  INDEX `fk_usuario_perfil1` (`iPerfilId` ASC) ,
  INDEX `fk_usuario_personal1` (`iPersonalId` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `macrostruts`.`session`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`session` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`session` (
  `iSessionId` INT(11) NOT NULL AUTO_INCREMENT ,
  `dSessionFechaInicio` DATE NOT NULL ,
  `dSessionFechaFinal` DATE NOT NULL ,
  `vSessionIp` VARCHAR(45) NOT NULL ,
  `iUsuarioId` INT(11) NOT NULL ,
  PRIMARY KEY (`iSessionId`) ,
  INDEX `fk_session_usuario1` (`iUsuarioId` ASC) ,
  CONSTRAINT `fk_session_usuario1`
    FOREIGN KEY (`iUsuarioId` )
    REFERENCES `macrostruts`.`usuario` (`iUsuarioId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`sexo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`sexo` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`sexo` (
  `iSexoId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cSexoCodigo` CHAR(1) NOT NULL ,
  `vSexoDescripcion` VARCHAR(9) NOT NULL ,
  `cEstadoCodigo` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`iSexoId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`subcategoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`subcategoria` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`subcategoria` (
  `iSubCategoriaId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iCategoriaId` INT(11) NULL DEFAULT NULL ,
  `cSubCategoriaCodigo` CHAR(7) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vSubCategoriaDescripcion` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  PRIMARY KEY (`iSubCategoriaId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`sucursal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`sucursal` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`sucursal` (
  `iSucursalId` INT(11) NOT NULL AUTO_INCREMENT ,
  `vSucursalNombre` VARCHAR(45) NOT NULL ,
  `vSucursalDireccion` VARCHAR(45) NOT NULL ,
  `vSucursalTelefono` VARCHAR(45) NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NOT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `cSucursalCodigo` CHAR(7) NULL DEFAULT NULL ,
  `iEmpresaId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iSucursalId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`tipodocumento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`tipodocumento` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`tipodocumento` (
  `iTipoDocumentoId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cTipoDocumentoCodigo` CHAR(2) NOT NULL ,
  `vTipoDocuumentoDescripcion` VARCHAR(45) NOT NULL ,
  `vGestion` CHAR(1) NULL DEFAULT NULL ,
  `cEstadoCodigo` VARCHAR(2) NULL DEFAULT NULL ,
  PRIMARY KEY (`iTipoDocumentoId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`tipodocumentogestion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`tipodocumentogestion` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`tipodocumentogestion` (
  `iTipoDocumentoGestionId` INT(11) NOT NULL AUTO_INCREMENT ,
  `cTipoDocumentoGestionCodigo` CHAR(2) NOT NULL ,
  `vTipoDocumentoDescripcion` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`iTipoDocumentoGestionId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`ventadetalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`ventadetalle` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`ventadetalle` (
  `iVentaDetalleId` INT(11) NOT NULL AUTO_INCREMENT ,
  `fVentaDetallePrecio` FLOAT NOT NULL ,
  `iVentaDetalleCantidad` INT(11) NOT NULL ,
  `fVentaDetalleTotal` FLOAT NOT NULL ,
  `iUsuarioInsertaId` INT(11) NOT NULL ,
  `dFechaInserta` DATETIME NOT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) NOT NULL ,
  `iProductoId` INT(11) NOT NULL ,
  `iVentaId` INT(11) NOT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `iPersonalId` INT(11) NULL DEFAULT NULL ,
  `iSubCta` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iVentaDetalleId`) ,
  INDEX `fk_ventaDetalle_producto1` (`iProductoId` ASC) ,
  INDEX `fk_ventaDetalle_venta1` (`iVentaId` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 35
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`ventadevolucion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`ventadevolucion` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`ventadevolucion` (
  `iVentaDevolucionId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iVentaId` INT(11) NULL DEFAULT NULL ,
  `dVentaDevFecha` DATE NULL DEFAULT NULL ,
  `fVentaDevTotal` FLOAT NULL DEFAULT NULL ,
  `fVentaDevSubTotal` FLOAT NULL DEFAULT NULL ,
  `fVentaDevIGV` FLOAT NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `iPeriodoId` INT(11) NULL DEFAULT NULL ,
  `nNroNotaCredito` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iTipoDocumentoId` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iVentaDevolucionId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`ventadevoluciondetalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`ventadevoluciondetalle` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`ventadevoluciondetalle` (
  `iVentaDevolucionDetalleId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iVentaDevolucionId` INT(11) NULL DEFAULT NULL ,
  `iProductoId` INT(11) NULL DEFAULT NULL ,
  `fVentaDevDetallePrecio` FLOAT NULL DEFAULT NULL ,
  `iVentaDevDetalleCantidad` INT(11) NULL DEFAULT NULL ,
  `fVentaDevDetalleTotal` FLOAT NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  `cEstadoCodigo` CHAR(2) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `fDescuento` FLOAT NULL DEFAULT NULL ,
  `iSubCta` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iVentaDevolucionDetalleId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `macrostruts`.`via`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`via` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`via` (
  `iViaId` INT(11) NOT NULL ,
  `vAbreviatura` VARCHAR(5) NULL DEFAULT NULL ,
  `vDescripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`iViaId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `macrostruts`.`visitacliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `macrostruts`.`visitacliente` ;

CREATE  TABLE IF NOT EXISTS `macrostruts`.`visitacliente` (
  `iVisitaClienteId` INT(11) NOT NULL AUTO_INCREMENT ,
  `iClienteId` INT(11) NULL DEFAULT NULL ,
  `dFechaVisista` DATE NOT NULL ,
  `dFecaProxVisita` DATE NULL DEFAULT NULL ,
  `dHoraVisita` TIME NULL DEFAULT NULL ,
  `vMotivoVisita` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `vProductoOfrecido` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `fPrecioPactado` FLOAT NOT NULL ,
  `vObservacion` VARCHAR(500) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL ,
  `iUsuarioInsertaId` INT(11) NULL DEFAULT NULL ,
  `iUsuarioActualizaId` INT(11) NULL DEFAULT NULL ,
  `dFechaInserta` DATETIME NULL DEFAULT NULL ,
  `dFechaActualiza` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`iVisitaClienteId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- function SPLIT_STR
-- -----------------------------------------------------

DELIMITER $$
DROP function IF EXISTS `macrostruts`.`SPLIT_STR` $$
CREATE DEFINER=`root`@`localhost` FUNCTION `SPLIT_STR`(
  x VARCHAR(255),
  delim VARCHAR(12),
  pos INT
) RETURNS varchar(255) CHARSET latin1
RETURN REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos),
       LENGTH(SUBSTRING_INDEX(x, delim, pos -1)) + 1),
       delim, '')$$

-- -----------------------------------------------------
-- procedure SP_CALCULO_CODIGO
-- -----------------------------------------------------
DROP procedure IF EXISTS `macrostruts`.`SP_CALCULO_CODIGO` $$
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

-- -----------------------------------------------------
-- procedure SP_IDU_COMPRA_CONTABILIDAD
-- -----------------------------------------------------
DROP procedure IF EXISTS `macrostruts`.`SP_IDU_COMPRA_CONTABILIDAD` $$
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

-- -----------------------------------------------------
-- procedure SP_IDU_DEVCOMPRA_CONTABILIDAD
-- -----------------------------------------------------
DROP procedure IF EXISTS `macrostruts`.`SP_IDU_DEVCOMPRA_CONTABILIDAD` $$
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
         VALUES(220,subTotal,'H',xiUsuarioId, NOW(), 'AC',CONCAT('POR LA DEVOLUCION/ Mercaderia / NRO de ',tipoDocumento,': ',numeroFactura,' NRO de Nota Debito:', xNroNotaCredito ),xId,'ASIENTO N1','0',xiPeriodoId);
				
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',NOW(),' Por el pago realizado de la compra de la mercaderia de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura)
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
                 VALUES(2,(total-xfMontoAdelantado),'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago realizado de la compra al vencimiento de la',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
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
                 VALUES(2,total,'H',xiUsuarioId, NOW(), 'AC',CONCAT('CAJA Y BANCOS / Caja / ',xfechaProximoPago,' Por el pago del anticipo en la compra de mercaderÃƒÂ­a de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','1',xProximoiPeriodoId);
               
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
                 VALUES(201,importeLetra,'H',xiUsuarioId, NOW(), 'AC',CONCAT('PROVEEDORES/ letras por pagar / ',fechaVencimiento,' por el canje de la ',tipoDocumento,' NÃ‚Â°: ', numeroFactura),xId,'ASIENTO N3','0',xProximoiPeriodoId);
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

-- -----------------------------------------------------
-- procedure SP_IDU_DEVVENTA_CONTABILIDAD
-- -----------------------------------------------------
DROP procedure IF EXISTS `macrostruts`.`SP_IDU_DEVVENTA_CONTABILIDAD` $$
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
     DECLARE importeLetra float;
     DECLARE xProximoiPeriodoId int;
     SET x = numeroLetra;
     SET fechaVencimiento = xfechaProximoPago;
   

   
       
       SELECT nVentaDevolucionNumero INTO numeroFactura FROM VentaDevolucion WHERE iVentaDevolucionId = xId  ;
       SELECT fVentaDevolucionSubTotal INTO subTotal FROM VentaDevolucion  WHERE iVentaDevolucionId = xId ;
       SELECT fVentaDevolucionIGV  INTO igv FROM VentaDevolucion  WHERE iVentaDevolucionId = xId ;
       SELECT fVentaDevolucionTotal INTO total FROM VentaDevolucion  WHERE iVentaDevolucionId = xId ;
       SELECT vTipoDocumentoDescripcion INTO tipoDocumento FROM tipodocumentogestion 
                    WHERE iTipoDocumentoGestionId = (SELECT iTipoDocumentoId FROM  VentaDevolucion 
                                                     WHERE iVentaDevolucionId = xId)  ; 
     /*  SELECT iFormaPagoId INTO xiFormaPagoId FROM VentaDevolucion  WHERE iVentaDevolucionId = xId ; */
       SELECT iClienteId INTO xiClienteId FROM VentaDevolucion WHERE iVentaDevolucionId  = xId ;
       
       
       IF(xMode='I') THEN
       /****************/
       /**ASIENTO NÃ‚Â°1 **/
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

-- -----------------------------------------------------
-- procedure SP_IDU_PERFIL_PERMISOS
-- -----------------------------------------------------
DROP procedure IF EXISTS `macrostruts`.`SP_IDU_PERFIL_PERMISOS` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_IDU_PERFIL_PERMISOS`(
    IN  xiUsuarioId int,
		IN  xvCodigoPermiso text, 
    IN  xCantidad int)
BEGIN
    DECLARE x INT;    
    DECLARE permisos VARCHAR(45);
    SET x = 1;
    DELETE FROM PERMISOS WHERE iUsuarioId = xiUsuarioId;
     WHILE x  <= xCantidad DO
       SELECT SPLIT_STR(xvCodigoPermiso, '-', x) into permisos; 
       
       if(permisos!='')then
        INSERT INTO PERMISOS(iUsuarioId,vCodigoMenu,cEstado) VALUES(xiUsuarioId,permisos,'AC');    
        end if;
      SET  x = x + 1; 
     END WHILE;
END$$

-- -----------------------------------------------------
-- procedure SP_IDU_VENTA_CONTABILIDAD
-- -----------------------------------------------------
DROP procedure IF EXISTS `macrostruts`.`SP_IDU_VENTA_CONTABILIDAD` $$
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

-- -----------------------------------------------------
-- procedure SP_NRO_DOCUMENTO
-- -----------------------------------------------------
DROP procedure IF EXISTS `macrostruts`.`SP_NRO_DOCUMENTO` $$
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

-- -----------------------------------------------------
-- procedure SP_PERIODO_ACTUAL
-- -----------------------------------------------------
DROP procedure IF EXISTS `macrostruts`.`SP_PERIODO_ACTUAL` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_PERIODO_ACTUAL`()
BEGIN
    
       SELECT iPeriodoId from periodo where year(dFechaInicio)=year(now()) and MONTHNAME(dFechaInicio)=MONTHNAME(now())  AND cCodigoEstado='ABIERTO';         
      
END$$

-- -----------------------------------------------------
-- procedure diasMes
-- -----------------------------------------------------
DROP procedure IF EXISTS `macrostruts`.`diasMes` $$
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

DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
