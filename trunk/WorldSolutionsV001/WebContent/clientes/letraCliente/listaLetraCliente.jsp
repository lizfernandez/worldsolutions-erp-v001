
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('estadoCuentaCliente.do?metodo=mantenimientoLetraCliente&mode=I',530,530)">
                <span class="new">Nuevo</span>
            </button>
        </td>
   
        <td><button  class="button" onclick="popup('estadoCuentaCliente.do?metodo=mantenimientoLetraCliente&mode=F',530,530)">
                <span class="find">Buscar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('cliente.do?metodo=mantenimientoCliente&mode=F',350,350)">
                <span class="pdf"> PDF</span>
            </button>
        </td>  
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista Letra Cliente</caption>
        <!-- tr>
            <th width="5%" >Nombre EstadoCuentaCliente:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
          <th width="5%" colspan="3" >Operaciones</th>
          <th align="left">Fecha Giro</th>
          <th align="left">Fecha Vencimiento</th>
          <th align="left">Fecha Pago</th>
          <th align="left">Nro Factura</th>	
          <th align="left">Nro Letra</th>
          <th align="left">Cliente</th>      
	      <th align="left">Plazo</th>
	      <th align="left">Importe</th>	    
	      <th align="left">Estado Letra</th>
           
    </tr>
    </thead>
    <tbody>
	 <logic:empty name="estadoCuentaClienteForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del estado Cuenta Cliente</td>
				</tr>
	 </logic:empty>
	    <logic:notEmpty name="estadoCuentaClienteForm" property="lista">
	     	<logic:iterate name="estadoCuentaClienteForm" property="lista" id="x">	
			<tr>
		          
		          
		          
		         <td align="center"><img title="Ver Compra" src="${pageContext.request.contextPath}/media/imagenes/search.png"
		                     onclick="popupModal('venta.do?metodo=mantenimientoVenta&mode=U&id=<bean:write name="x" property="venta.iVentaId" />&idTipoDocumento=<bean:write name="x" property="venta.tipoDocumento.iTipoDocumentoGestionId" />',900,700)" />
		         </td>
		         <td align="center"><img title="Editar Letra" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popupModal('estadoCuentaCliente.do?metodo=mantenimientoLetraCliente&mode=U&id=<bean:write name="x" property="iLetraClienteId" />',530,530)" />
		         </td>
		           <td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iLetraClienteId" />','estadoCuentaCliente.do?metodo=iduLetraCliente&mode=D')" /></td>	
					         
		         <td><bean:write name="x" property="dFechaGiro"  format="dd/MM/yyyy"/></td>
		         <td><bean:write name="x" property="dFechaVencimiento"  format="dd/MM/yyyy"/></td>
		         <td><bean:write name="x" property="dFechaPago"  format="dd/MM/yyyy"/></td>
		         <td><bean:write name="x" property="venta.nVentaNumero" /></td>
		         <td><bean:write name="x" property="nNumeroLetra" /></td>
                 <td><bean:write name="x" property="cliente.vClienteRazonSocial" /></td>  
           		 <td><bean:write name="x" property="nPlazoLetra" /></td>
				 <td align="right"><bean:write name="x" property="nImporte"  format="#,##0.00" locale="Localidad" /></td>
				 <td><bean:write name="x" property="vEstadoLetra" /></td>
				 
			</tr>
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
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="estadoCuentaClienteForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#cliente,#cuentaLetra").addClass("active");
 $(".inputDisabled").attr("disabled",true);

 $("#dIngresoProductoFecha,#dIngresoProductoFechaFin").datepicker(
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
 