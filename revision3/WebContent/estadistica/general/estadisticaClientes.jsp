
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
        <caption>Estadistica de las compras de los 10 mejores Clientes</caption>
            <tr>
              <!-- td width="12%">&emsp;Diario:<html:radio property="condicion" styleId="diario" styleClass="text"  value="diario" onclick="fn_cambiar(true)" /> </td>
              <td width="14%">&emsp;Mensual:<html:radio property="condicion" styleId="mensual" styleClass="text"  value="mensual" onclick="fn_cambiar(false)"/>  </td>
               -->
               <td width="14%">&emsp;A&ntilde;o
              <html:select  property="anio" styleId="anio" styleClass="combo">       
     			  <html:options collection="listaAnio" property="anio" labelProperty="anio"/>
     			</html:select> 
                </td>
              <!-- td>&emsp;Fecha Inicio:<html:text property="fechaInicio" styleId="fechaInicio" styleClass="text"/> </td>
              <td>&emsp;Fecha Fin:<html:text property="fechaFin" styleId="fechaFin" styleClass="text"/> </td>  
                 -->
              <td>
              <% 
			   for (String per: listapermiso) {
			   if(per!=null){
			   if(per.equals("7141")){%>
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
  <div id="BarrasSemanal" style="margin-left: 2em; margin-top: 0.8em;"></div>
  <div id="BarrasMensual" style="margin-left: 43em; margin-top: -21.5em;"></div>
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

 var param="";

 Ext.chart.Chart.CHART_URL = "${pageContext.request.contextPath}/media/Plugin-estadisticas/resources/charts.swf";

 function fn_graficas(){
	 
  
     var anio=$("#anio").val();     
     var parametro ="&anio="+anio;
      
  
 Ext.onReady(function(){

  var store = new Ext.data.JsonStore({
     url: "estadistica.do?metodo=jsonEstadisticaMejoresClientes&condicion=diario"+parametro,
     baseParams: {
       symbol: ''
     },
     autoLoad: true,
     root: '',
     fields: ['nombre', 'dia','cantidad']
   });

   var store1 = new Ext.data.JsonStore({
	     url: "estadistica.do?metodo=jsonEstadisticaMejoresClientes&condicion=mensual"+parametro,
	     baseParams: {
	       symbol: ''
	     },
	     autoLoad: true,
	     root: '',
	     fields: ['nombre', 'dia','cantidad']
	   });


   /****************************/
   /*LINEA HORIZONTAL SEMANAL  */
   /****************************/

   var chart = new Ext.chart.ColumnChart({  
       store: store,  
       xField: 'dia', 
     //yField: 'comedy'      //Step 1  
       xAxis: new Ext.chart.CategoryAxis({  
        labelRenderer:  this.customFormat  
        }),
       series:[  
           {yField:'Nombre',displayName:'Cliente'},  
           {yField:'cantidad',displayName:'Total' } 
          
       ],  
       extraStyle:{            //Step 1  
           legend:{        //Step 2  
               display: 'bottom'//Step 3  
           }  
       }  
       });  
   new Ext.Panel({
       width: 500,
       height: 300,
       title: 'Estadistica 10 Mejores Clientes',       
	    renderTo: 'BarrasSemanal',
	    layout:'fit',  
	    items: chart  
	});  	  
	
   
   /****************************/
   /*LINEA HORIZONTAL SEMANAL  */
   /****************************/

   var chart = new Ext.chart.ColumnChart({  
       store: store1,  
       xField: 'dia', 
     //yField: 'comedy'      //Step 1  
       xAxis: new Ext.chart.CategoryAxis({  
        labelRenderer:  this.customFormat  
        }),
       series:[  
           {yField:'nombre',displayName:'nombre'},  
           {yField:'cantidad',displayName:'Total' } 
          
       ],  
       extraStyle:{            //Step 1  
           legend:{        //Step 2  
               display: 'right'//'bottom'//Step 3  
           }  
       }  
       });  
   new Ext.Panel({
       width: 500,
       height: 300,
       title: 'Estadistica 10 Mejores Clientes',       
	    renderTo: 'BarrasMensual',
	    layout:'fit',  
	    items: chart  
	});
   

     new Ext.Panel({
         width: 350,
         height: 300,
         renderTo:'Barra', //window.opener.document.getElementById('contenido_estadistica'),
         title: '10 Mejores Clientes - Grafico Semanal',//'Ventas por Cliente - Semanal',
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
             xField: 'nombre',
             xAxis: new Ext.chart.CategoryAxis({
                 title: 'Clientes'
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
 	
 	
 	 /*********************/
 	 /*LINEA HORIZONTAL   */
 	 /*********************/
    var storePrueba = new Ext.data.JsonStore({
        fields: ['year', 'comedy', 'action', 'drama', 'thriller'],
        data: [
                {year: 2005, comedy: 34000000, action: 23890000, drama: 18450000, thriller: 20060000},
                {year: 2006, comedy: 56703000, action: 38900000, drama: 12650000, thriller: 21000000},
                {year: 2007, comedy: 42100000, action: 50410000, drama: 25780000, thriller: 23040000},
                {year: 2008, comedy: 38910000, action: 56070000, drama: 24810000, thriller: 26940000}
              ]
    });
  // more complex with a custom look
  /*  new Ext.Panel({
       width: 600,
       height: 400,
       renderTo: 'Lineal',
       title: 'Stacked Bar Chart - Movie Takings by Genre',
       items: {
           xtype://'stackedbarchart',//columnchart
           store: storePrueba,
           yField: 'year',
           xAxis: new Ext.chart.NumericAxis({
               stackingEnabled: true,
               labelRenderer: Ext.util.Format.usMoney
           }),
           series: [{xField: 'comedy',displayName: 'Comedy'},
                    {xField: 'action',displayName: 'Action'},
                    {xField: 'drama',displayName: 'Drama'},
                    {xField: 'thriller',displayName: 'Thriller'
           }]
       }
   }); */
   
   
	
   
   });
 }
 </script>
</body>