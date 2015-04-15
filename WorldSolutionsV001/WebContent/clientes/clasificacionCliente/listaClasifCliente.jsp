
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('cliente.do?metodo=mantenimientoClasifCliente&mode=I',350,220)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button" onclick="eliminar('tabla','','cliente.do?metodo=iduClasificacionCliente&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('cliente.do?metodo=mantenimientoClasifCliente&mode=F',350,220)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de Area</caption>
        <!-- tr>
            <th width="5%" >Nombre Area:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        <th colspan="3"width="5%" >Operaciones</th>
        <th width="10%" align="left">Nombre</th>
        <th width="15%" align="left">% Descuento</th>
        <th width="8%" align="left">Estado</th>
       
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="clienteForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del clasificacion de cliente</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="clienteForm" property="lista">
	     	<logic:iterate name="clienteForm" property="lista" id="x">	
			<tr>
				<td align="center"><input type="checkbox" id="<bean:write name="x" property="iClasificacionClienteId" />"/></td> 
				<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('cliente.do?metodo=mantenimientoClasifCliente&mode=U&id=<bean:write name="x" property="iClasificacionClienteId" />',350,220)" /></td>
		 	    <td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iClasificacionClienteId" />','cliente.do?metodo=iduClasifCliente&mode=D')" /></td>	
				<td><bean:write name="x" property="vNombre" /></td>
				<td><bean:write name="x" property="fDescuento" /></td>
				<td><bean:write name="x" property="cEstadoCodigo" /></td>
		 
				
		
			</tr>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="clienteForm" property="paginas">	
    <bean:size id="listSizes" name="clienteForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="clienteForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="clienteForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#admin,#clasifCliente").addClass("active");
</script> 

 