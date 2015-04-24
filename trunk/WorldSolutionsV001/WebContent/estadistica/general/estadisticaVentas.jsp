
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page import="com.entities.Permiso"%>
<%@ page language="java"%>
<%@ page import="java.util.List" session="true"%>
<% 
List<String> listapermiso = (List<String>)session.getAttribute("listaMisPermisoUsuario");
//if(listapermiso!=null){	
%>
</head>
<body id="ext-gen3" class=" ext-gecko ext-gecko3" onload="fn_graficas()">
<html:form action="estadistica" styleId="formProductos">
    <fieldset class="fieldset">
       
        <table border="0" class="tabla" width="50%">
            <tr>
              <td width="12%">&emsp;Diario:<html:radio property="condicion" styleId="diario" styleClass="text"  value="diario" onclick="fn_cambiar(true)" /> </td>
              <td width="14%">&emsp;Mensual:<html:radio property="condicion" styleId="mensual" styleClass="text"  value="mensual" onclick="fn_cambiar(false)"/>  </td>
              <td width="14%">&emsp;A&ntilde;o
              <html:select  property="anio" styleId="anio" styleClass="combo">       
     			  <html:options collection="listaAnio" property="anio" labelProperty="anio"/>
     			</html:select> 
                </td>
              <td>&emsp;Fecha Inicio:<html:text property="fechaInicio" styleId="fechaInicio" styleClass="text"/> </td>
              <td>&emsp;Fecha Fin:<html:text property="fechaFin" styleId="fechaFin" styleClass="text"/> </td>  
                <td>
                <% 
			   for (String per: listapermiso) {
			   if(per!=null){
			   if(per.equals("7131")){%>
                <button onclick="fn_graficas()"><span class='grafica'>Graficar</span></button>
                 <% break;}}}%>
                 </td>
            </tr>            
        </table>
     </fieldset>
<%-- hidden field que contiene el mode --%>
<html:hidden property="mode" styleId="mode" />
<html:hidden property="condicion" styleId="condicion" />
<%-- set the parameter for the dispatch action --%>
<html:hidden property="metodo" value="estadisticaGeneral" styleId="metodo"/>
</html:form>
  <div id="Barras" style="margin-left: 2em; margin-top: 0.8em;"></div>
  <div id="torta" style="margin-left: 28em; margin-top: -21.5em;"></div>
  <div id="Lineal" style="margin-left: 54em; margin-top: -21.5em;"></div>
 <script type="text/javascript">
 var mode = document.getElementById('mode').value;	
 var condicion=$("#condicion").val();
 
 
 $("#fechaInicio,#fechaFin").datepicker(
	        {
	            changeMonth: true,
	            changeYear: true,
	            dateFormat: 'dd/mm/yy',
	            defaultDate: -1,
	            maxDate: '+0d'
	    })
 if(condicion=='diario') {	
	 fn_cambiar(true);
	 
 }
 if(condicion=='mensual') {
//	 $("#mensual").attr("checked", true);
	 fn_cambiar(false);
	 
 }
 function fn_cambiar(action){
	 $("#anio").attr("disabled", action);
 }
 
 var param="";

 Ext.chart.Chart.CHART_URL = "${pageContext.request.contextPath}/media/Plugin-estadisticas/resources/charts.swf";

 function fn_graficas(){
	 
	 var condicion="";
 	if($("#diario").is(":checked")){  		
 		condicion=$("#diario").val();
 	}
     
 	if($("#mensual").is(":checked")){
 		condicion=$("#mensual").val();
 	} 
    
     var anio=$("#anio").val();
     var fechaInicio=$("#fechaInicio").val();
     var fechaFin=$("#fechaFin").val();
     var parametro ="&condicion="+condicion+"&anio="+anio+"&fechaInicio="+fechaInicio+"&fechaFin="+fechaFin;
      
  
 Ext.onReady(function(){

  var store = new Ext.data.JsonStore({
     url: "estadistica.do?metodo=jsonEstadisticaCompra"+parametro,
     baseParams: {
       symbol: ''
     },
     autoLoad: true,
     root: '',
     fields: ['dia', 'cantidad']
   });

 var store1 = new Ext.data.JsonStore({
     //url: "<?php  echo $this->baseUrl($this->currentController. '/jsonventas/parametro/')?>"+parametros,
    url: "estadistica.do?metodo=jsonEstadisticaVenta"+parametro,
    baseParams: {
       symbol: ''
     },
     autoLoad: true,
     root: '',
     fields: ['dia', 'cantidad']
   });


 var store2 = new Ext.data.JsonStore({
   //  url: "<?php  echo $this->baseUrl($this->currentController. '/jsonutilidades/parametro/')?>"+parametros,
     url: "estadistica.do?metodo=jsonEstadisticaUtilidades"+parametro,
     baseParams: {
       symbol: ''
     },
     autoLoad: true,
     root: '',
     fields: ['dia', 'cantidad']
   });

     new Ext.Panel({
         width: 350,
         height: 300,
        	renderTo:'Barras', //window.opener.document.getElementById('contenido_estadistica'),
         title: 'Estadistica Barras Compras',
         /*tbar: [{
             text: 'Load new data set',
             handler: function(){
                 //store.loadData(generateData());
             }
         }],*/
         items: {
             xtype: 'columnchart',
             store: store,
             yField: 'cantidad',
             xField: 'dia',
             xAxis: new Ext.chart.CategoryAxis({
                 title: 'Productos'
             }),
             yAxis: new Ext.chart.NumericAxis({
                 title: 'Cantidad'
             }),
             extraStyle: {
                xAxis: {
                     labelRotation:-90
                 }

             }

         }
     	}).show();//barrras
 	/*****************/
 	/*GRAFICAS DE PIE*/
 	/*****************/
 	 new Ext.Panel({
         width: 350,
         height: 300,
         title: 'Estaditicas Pie Ventas',
         renderTo: 'torta',
         items: {
             store: store1,
             xtype: 'piechart',
             dataField: 'cantidad',
             categoryField: 'dia',
             //extra styles get applied to the chart defaults
             extraStyle:
             {
                 legend:
                 {
                     display: 'right',
                     padding: 4,
                     font:
                     {
                         family: 'Tahoma',
                         size: 9
                     }
                 }
             }
         }
     });//pie
 	 /*****************/
 	 /*GRAFICAS LINEAL*/
 	 /*****************/
 	 new Ext.Panel({
         title: 'Estadistica Lineal Utilidades',
         renderTo: 'Lineal',
         width:350,
         height:300,
         layout:'fit',
         items: {
             xtype: 'linechart',
             store: store2,
             xField: 'dia',
             yField: 'cantidad',
             extraStyle:
             {
                /* legend:
                 { display: 'right'

                 },*/xAxis: {
                     labelRotation:-90
                 }
             }
         }

     });//LINEAL
 	 /*********************/
 	 /*LINEA HORIZONTAL   */
 	 /*********************/

   });
 }
 			 

 
 
 </script>
</body>