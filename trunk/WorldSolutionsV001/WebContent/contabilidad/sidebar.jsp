<div id ="cont2" class="cont">
    <ul id="clientes">
        <div onclick="submenu('clientes')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/cli.png" width="20" height="20" />
	        <strong >CLIENTES</strong> <br>
	     </div>
         <li id="ventas"><a href="contabilidad.do?metodo=listaVenta"> <!--href="venta.do?metodo=listaVenta&mode=LContabilidad"-->
            <span class="gestion">Ventas</span></a>
        </li>
         <li id="ventasDevolucion"><a href="contabilidad.do?metodo=listaVentaDevolucion">
            <span class="gestion">Devoluci&oacute;n de Ventas </span></a>
        </li>
         <li id="estadoCuentaCliente"><a href="contabilidad.do?metodo=listaEstadoCuentaCliente">
            <span class="gestion">Estado Cuenta Cliente</span></a>
        </li>              
    </ul>
    <ul id="proveedores">
        <div onclick="submenu('proveedores')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
	        <strong >PROVEEDORES</strong> <br>
	     </div>        
         <li id="compras"><a href="contabilidad.do?metodo=listaIngresoproducto">
            <span class="gestion">Compras</span></a>
        </li>
         <li id="comprasDevolucion"><a href="contabilidad.do?metodo=listaIngresoproductoDevolucion">
            <span class="gestion">Devoluci&oacute;n de Compras </span></a>
        </li>
         <li id="estadoProveedor"><a href="contabilidad.do?metodo=listaEstadoCuentaProveedor">
            <span class="gestion">Estado Cuenta Proveedor</span></a>
        </li>       
     </ul>
     <ul id="existencias">
        <div onclick="submenu('existencias')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/oca.png" width="20" height="20" />
	        <strong >EXISTENCIAS</strong> <br>
	     </div> 
       
       <li id="productos"><a href="contabilidad.do?metodo=listaProducto&iclasificacionId=1">
            <span class="gestion">Mercaderias</span></a>
        </li>
        <li id="materiaPrima"><a href="contabilidad.do?metodo=listaProducto&iclasificacionId=2">
            <span class="gestion">Materia primas</span></a>
        </li>
        <li id="suministros"><a href="contabilidad.do?metodo=listaProducto&iclasificacionId=3">
            <span class="gestion">Suministros y Repuestos</span></a>
        </li>
        <li id="embases"><a href="contabilidad.do?metodo=listaProducto&iclasificacionId=4">
            <span class="gestion">Embases y Embalajes</span></a>
        </li>
     </ul> 
     <ul id="tesoreria">
          <div onclick="submenu('tesoreria')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/pro.png" width="20" height="20" />
	        <strong >TESORERIA</strong> <br>
	     </div>
        <li id="cuentas"><a href="contabilidad.do?metodo=listaCuentas">
            <span class="gestion">Ingreso de Cuentas</span></a>
        </li>
        <li id="cajaBancos"><a href="contabilidad.do?metodo=listaCajaBanco">
            <span class="gestion">Caja y bancos</span></a>
        </li>       
     </ul>
      <ul id="planillas">
          <div onclick="submenu('planillas')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/sub.png" width="20" height="20" />
	        <strong >PLANILLA</strong> <br>
	     </div>
	   <li id="parametros"><a href="configuracion.do?metodo=listaConfiguracion">
            <span class="gestion">Parametros de planilla</span></a>
        </li>
        <li id="planilla"><a href="contabilidad.do?metodo=listaPlanilla">
            <span class="gestion">registro de planilla</span></a>
        </li>
           
     </ul>
     <ul id="plancontable">
        <div onclick="submenu('plancontable')">
	        <img src="${pageContext.request.contextPath}/media/imagenes/tra.png" width="20" height="20" />
	        <strong >PLAN CONTABLE</strong> <br>
	     </div>
        <li id="diario"><a href="contabilidad.do?metodo=listaLibroDiario">
            <span class="gestion">Libro Diario</span></a>
        </li>
        <!-- li id="mayor"><a href="contabilidad.do?metodo=listaLibroMayor">
            <span class="gestion">Libro Mayor</span></a>
        </li>
        <li id="balance"><a href="contabilidad.do?metodo=listaBalanceGeneral">
            <span class="gestion">Balance General</span></a>
        </li>
        <li id="estadoFinanciero"><a href="contabilidad.do?metodo=listaEstadoFinanciero">
            <span class="gestion">Estados Financieros</span></a>
        </li-->
      </ul>   
</div>

             