<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<table border="0">
    <tr>
        <td><button  class="button" onclick="popup('categoria.do?metodo=mantenimientoSubCategoria&mode=I',350,235)">
                <span class="new">Nuevo</span>
            </button>
        </td>
        <td><button  class="button" onclick="eliminar('tabla','','categoria.do?metodo=iduSubCategoria&mode=D')">
                <span class="delete">Eliminar</span>
            </button>
        </td>
        <td><button  class="button" onclick="popup('categoria.do?metodo=mantenimientoSubCategoria&mode=F',350,220)">
                <span class="find">Buscar</span>
            </button>
        </td>
    </tr>
</table >
<table class="tabla" border="0" width="100%" id="tabla">
    <caption>Lista de SubCategoria</caption>
        <!-- tr>
            <th width="5%" >Nombre Categoria:</th>
            <td colspan="13"><input type="text" id="txtnombre" value="<?php echo $this->descripcion?>"/><button onclick="busqueda('<?php echo $this->baseUrl($this->currentController.'/index/descripcion/')?>')" class="button">
                    <span class="find">Buscar</span></button></td>

        </tr>
         -->

    <thead>
    <tr>
        <th colspan="3"width="5%" >Operaciones</th>
        
        <th width="10%" align="left">C&oacute;digo</th>
        <th width="15%" align="left">SubCategoria  </th>
        <th width="10%" align="left">Categoria</th>
        <th width="8%" align="left">Estado</th>
       
    </tr>
    </thead>
    <tbody>
	    <logic:empty name="categoriaForm" property="lista">
				<tr>
					<td colspan="8">No hay informaci&oacute;n del Subcategoria</td>
				</tr>
	    </logic:empty>
	    <logic:notEmpty name="categoriaForm" property="lista">
	     	<logic:iterate name="categoriaForm" property="lista" id="x">	
			<tr>
				<td align="center"><input type="checkbox" id="<bean:write name="x" property="iSubCategoriaId" />"/></td> 
				<td align="center"><img title="Editar" src="${pageContext.request.contextPath}/media/imagenes/edit.png"
		                     onclick="popup('categoria.do?metodo=mantenimientoSubCategoria&mode=U&id=<bean:write name="x" property="iSubCategoriaId" />',350,251)" /></td>
		 	    <td align="center"><img title="Eliminar" src="${pageContext.request.contextPath}/media/imagenes/delete.png"
		                     onclick="eliminar('tabla','<bean:write name="x" property="iSubCategoriaId" />','categoria.do?metodo=iduSubCategoria&mode=D')" /></td>	
                <td><bean:write name="x" property="cSubCategoriaCodigo" /></td>
				<td><bean:write name="x" property="vSubCategoriaDescripcion" /></td>
				<td><bean:write name="x" property="categoria.vCategoriaDescripcion" /></td>
				<td><bean:write name="x" property="cEstadoCodigo" /></td>
		 
				
		
			</tr>
		  </logic:iterate>
	   </logic:notEmpty>
    </tbody>
</table>
<div id="paginacion">
<logic:notEmpty name="categoriaForm" property="paginas">	
    <bean:size id="listSizes" name="categoriaForm" property="paginas"/>	
    <input type="hidden" id="size" value="<bean:write name="listSizes" />"/>
	<input type="hidden" id="pagInicio" value="<bean:write name="categoriaForm" property="pagInicio"/>"/>
	<div class="btnPagInactivo" id="principio">&emsp;</div>
	<div class="btnPagInactivo" id="back">&emsp;</div>	
	<div id="pag">	
		<logic:iterate name="categoriaForm" property="paginas" id="p">				
			        <div class="btnPagInactivo" id="pg_<bean:write name="p" />" onclick="paginator('<bean:write name="p" />')" ><bean:write name="p" /></div>
		</logic:iterate>
	</div>
	<div class="btnPagInactivo" id="Next" >&emsp;</div>
	<div class="btnPagInactivo" id="Final" >&emsp; </div>
</logic:notEmpty>	  
</div> 
<script>   
paginacion();
$("#inventario, #subcategoria").addClass("active");
</script> 

 