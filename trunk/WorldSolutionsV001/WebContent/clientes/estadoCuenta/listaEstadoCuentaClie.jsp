
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('venta.do?metodo=mantenimientoVenta&mode=IE',520,450)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button"onclick="popup('venta.do?metodo=mantenimientoVenta&mode=F',585,480)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <td><button class="button" onclick="fn_exportarExcel('estadoCuentaCliente.do?metodo=exportarExcel&plantilla=cliente-estado-cuenta')">
                <span class="excel">Exportar</span>
            </button>
        </td>
    </tr>
</table ><table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Estado Cuenta Cliente</caption>
        <!-- tr>
            <th width="5%" >Nombre EstadoCuentaCliente:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
          <th colspan="4"width="5%" >Operaciones</th>
          <th align="left">Cliente</th>
          <th align="left">Tipo Documento</th>
	      <th align="left">Nro. Documento</th>
	      <th align="left">Forma pago</th>
	      <th align="left">Fecha Emisi&oacute;n</th>
	      <th align="right">Monto Total</th>
	      <th align="right">Pago Total</th>
	      <th align="right">Saldo Total</th>
	      <th align="left">Estado Documento</th>
           
    </tr>
    </thead>
    <tbody>
	 <logic:empty name="estadoCuentaClienteForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del estado Cuenta del Cliente</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="estadoCuentaClienteForm" property="lista">
	     	<logic:iterate name="estadoCuentaClienteForm" property="lista" id="x">	
			<tr>
				 
				<logic:equal name="x" property="venta.vPrincipal" value="1">
		            <td align="center"><img title="Ver Documento" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('venta.do?metodo=mantenimientoVenta&mode=U&id=<bean:write name="x" property="venta.iVentaId" />&idTipoDocumento=<bean:write name="x" property="venta.tipoDocumento.iTipoDocumentoGestionId" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',1320,620)" /></td>
		          </logic:equal>
		        <logic:equal name="x" property="venta.vPrincipal" value="0">  
				<td align="center"><img title="Ver Documento" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('venta.do?metodo=mantenimientoVenta&mode=UE&id=<bean:write name="x" property="venta.iVentaId" />&idTipoDocumento=<bean:write name="x" property="venta.tipoDocumento.iTipoDocumentoGestionId" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',520,430)" /></td>
		        </logic:equal>
		        <logic:notEqual name="x" property="saldoTotal" value="0.00">
			        <td align="center"><img title="Agregar Pago" src="${pageContext.request.contextPath}/media/imagenes/new.png"
			                     onclick="popup('estadoCuentaCliente.do?metodo=mantenimientoEstadoCuentaCliente&mode=I&iVentaId=<bean:write name="x" property="venta.iVentaId" />&iClienteId=<bean:write name="x" property="venta.cliente.iClienteId" />&montoTotal=<bean:write name="x" property="venta.fVentaTotal" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',350,220)" />
			         </td>
		          </logic:notEqual>
		          <logic:equal name="x" property="saldoTotal" value="0.00">
		              <td align="center"> </td>
		          </logic:equal>
		         <logic:equal name="x" property="venta.vPrincipal" value="0">
		             <logic:equal name="x" property="pagoTotal" value="0">
			               <td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
			                     onclick="eliminar('tabla','<bean:write name="x" property="venta.iVentaId" />','venta.do?metodo=iduVenta&mode=D')"/>
			               </td>
		             </logic:equal>
		              <logic:notEqual name="x" property="pagoTotal" value="0">
			               <td align="center"></td>
		             </logic:notEqual>
		          </logic:equal>
		          <logic:equal name="x" property="venta.vPrincipal" value="1">
		              <td align="center"> </td>
		          </logic:equal>
		           
		         <logic:notEmpty name="x" property="venta.estadocuentaclientes">
		         <td id="img_<bean:write name="x" property="venta.iVentaId" />">
		               <img title="Visualizar Detalle" src="${pageContext.request.contextPath}/media/imagenes/mas.png"
                        onclick="fn_pagosMas('<bean:write name="x" property="venta.iVentaId" />')" />
                 </td> 
                 </logic:notEmpty>                 
                 <logic:empty name="x" property="venta.estadocuentaclientes"> 
	                 <td id="img_<bean:write name="x" property="venta.iVentaId" />">	                     
	                 </td> 
                 </logic:empty>  
                 <td><bean:write name="x" property="venta.cliente.vClienteRazonSocial" /></td>
           		 <td><bean:write name="x" property="venta.tipoDocumento.vTipoDocumentoDescripcion" /></td>
				 <td><bean:write name="x" property="venta.nVentaNumero" /></td>
				 <td><bean:write name="x" property="venta.formaPago.vFormaPagoDescripcion" /></td>
				 <td><bean:write name="x" property="venta.dVentaFecha" format="dd/MM/yyyy"/></td>
				 <td align="right"><bean:write name="x" property="venta.fVentaTotal" format="#,##0.00" locale="Localidad"/></td>
				 <td align="right"><bean:write name="x" property="pagoTotal" format="#,##0.00" locale="Localidad" /></td>
				 <td align="right"><bean:write name="x" property="saldoTotal" format="#,##0.00" locale="Localidad" /></td>
				 <td><bean:write name="x" property="venta.vEstadoDocumento" /></td>
				 
			</tr>
			<logic:notEmpty name="x" property="venta.estadocuentaclientes">
			<tr class="textInvisible" id="tr_<bean:write name="x" property="venta.iVentaId" />" >
   				 <td colspan="11"  align="right">
   				 
   				 <table class="tabladetalle" width="71%" border="0">
					<caption>Lista de Detalle de Pagos</caption>
					<thead>
						<tr>
						<th colspan="2" width="5%" >Operaciones</th>
						
						<th  align="center">Fecha Pago</th>
						<th align="right">Monto Pago</th>
						</tr>
					</thead>
					<tbody>
					  <logic:iterate name="x" property="venta.estadocuentaclientes" id="z">
					  <logic:equal name="z" property="cEstadoCodigo" value="AC">
					  <tr>
					        <td align="center"><img title="Editar Pago" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
			                     onclick="popupModal('estadoCuentaCliente.do?metodo=mantenimientoEstadoCuentaCliente&mode=U&id=<bean:write name="z" property="iEstadoCuentaCliente" />&montoTotal=<bean:write name="x" property="venta.fVentaTotal" />&pagoTotal=<bean:write name="x" property="pagoTotal" />',350,200)" />
			                </td>
					        <td align="center"><img title="Eliminar Pago" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="z" property="iEstadoCuentaCliente" />','estadoCuentaCliente.do?metodo=iduEstadoCuentaCliente&mode=D')"/>
		                    </td>
					      
						   <td align="center"><bean:write name="z" property="dFechaPago" format="dd/MM/yyyy" /></td>
						   <td align="right"><bean:write name="z" property="fMontoPago" format="#,##0.00" locale="Localidad" /></td>
						</tr> 
						</logic:equal>  
			           </logic:iterate>	
					</tbody>
					</table>
   				 </td>
   				 <td colspan="2">
   				 </td>
			</tr>
			</logic:notEmpty>
			<logic:notEqual name="x" property="montosTotales" value="">
				 <tr>
					 <td colspan="8"></td>
					 <td align="right"><strong>Monto Totales:</strong></td>
					  <td align="right"><bean:write name="x" property="montosTotales" format="#,##0.00" locale="Localidad" /></td>
					 <td align="right"><bean:write name="x" property="pagosTotales" format="#,##0.00" locale="Localidad"/></td>
					 <td align="right"><bean:write name="x" property="saldosTotales" format="#,##0.00" locale="Localidad"/></td>
					 <td align="right"></td>
					
				</tr>
			</logic:notEqual>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="estadoCuentaClienteForm" property="paginas">	
    <bean:size id="listSizes" name="estadoCuentaClienteForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="estadoCuentaClienteForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp; </div>	
	<div id="pag">	
		<logic:iterate name="estadoCuentaClienteForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;  </div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#cliente,#cuentaCliente").addClass("active");
 $(".inputDisabled").attr("disabled",true);
 $("#dVentaFecha,#dVentaFechaFin").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            maxDate: '+0d'
	    })
 function fn_pagosMas(valor){
     $("#tr_"+valor).show();
     var tag = "<img title='Ocultar Detalle'src='${pageContext.request.contextPath}/media/imagenes/menos.png' onclick=\"fn_pagosMenos('"+valor+"')\" />";
     $("#img_"+valor).html(tag);
   
    }
   function fn_pagosMenos(valor){
     $("#tr_"+valor).hide();
     var tag = "<img title='Visualizar Detalle' src='${pageContext.request.contextPath}/media/imagenes/mas.png' onclick=\"fn_pagosMas('"+valor+"')\" />";
     $("#img_"+valor).html(tag);
   }
 </script> 