 
//Ext.chart.Chart.CHART_URL = '../../../include/extjs/resources/charts.swf';
/**/
function graf(){
	
Ext.onReady(function(){

	  /*var store = new Ext.data.JsonStore({
        fields: ['Gestores', 'Cantidad'],
        data:[
			  {"Gestores":"Alejandro","Cantidad":3},
			  {"Gestores":"Danes","Cantidad":11},
			  {"Gestores":"Liz Gaby","Cantidad":27},
			  {"Gestores":"Rosa","Cantidad":39}
			  ]
           });
	  */
	 

  /*var store = new Ext.data.JsonStore({  
     fields: ['Gestores','Cantidad'],
	 url: '../Datos/Estadistica_Expediente.php',  
     root: ''  
   
});*/ 

 var store = new Ext.data.JsonStore({
   // url: '../Datos/Estadistica_Expediente.php',
    url: 'apps/Estadisticas/Datos/Estadistica_Expediente.php',
    baseParams: {
      symbol: ''
    },
    autoLoad: true,
    root: '',
    fields: ['Gestores', 'Cantidad']
  });

/*/* var store = new Ext.data.Store({ 
    reader: new Ext.data.JsonStore({ 
       		 fields: ['Gestores', 'Cantidad'], 
      	     root: 'rows' ,
  	           }), 
			 proxy: new Ext.data.HttpProxy({ 
					url: '../Datos/Estadistica_Expediente.php?' 
					   }),  		
	       
		   });
 /*store.load();
	   
	  /**/
/*function generateData(){
    var data = [];
    for(var i = 0; i < 3; ++i){
        data.push([Date.monthNames[i], (Math.floor(Math.random() *  5) + 1) * 100]);
    }
    return data;
}

Ext.onReady(function(){
    var store = new Ext.data.ArrayStore({
        fields: ['Gestores', 'Cantidad'],
        data: generateData()
    });
    */
	  //  store.load();
	//$.getJSON("../Datos/Estadistica_Expediente.php",function resultado(store){
    new Ext.Panel({
        width: 600,
        height: 400,		
//        renderTo: document.body,
		renderTo:'Barras', //window.opener.document.getElementById('contenido_estadistica'),
        title: 'Estadistica  Gestores- Cantidad',
        /*tbar: [{
            text: 'Load new data set',
            handler: function(){
                //store.loadData(generateData());
            }
        }],*/
        items: {
            xtype: 'columnchart',
            store: store,
            yField: 'Cantidad',
            xField: 'Gestores',
            xAxis: new Ext.chart.CategoryAxis({
                title: 'Gestores'
            }),
            yAxis: new Ext.chart.NumericAxis({
                title: 'Cantidad'
            }),
            extraStyle: {
               xAxis: {
                    labelRotation: -90
                }
            }
        }
    	}).show();//barrras
	/*****************/
	/*GRAFICAS DE PIE*/
	/*****************/
	 new Ext.Panel({
        width: 600,
        height: 400,
        title: 'Pie Chart Gestores- Cantidad',
        renderTo: 'Pie',
        items: {
            store: store,
            xtype: 'piechart',
            dataField: 'Cantidad',
            categoryField: 'Gestores',
            //extra styles get applied to the chart defaults
            extraStyle:
            {
                legend:
                {
                    display: 'bottom',
                    padding: 5,
                    font:
                    {
                        family: 'Tahoma',
                        size: 13
                    }
                }
            }
        }
    });//pie
	 /*****************/
	 /*GRAFICAS LINEAL*/
	 /*****************/
	 new Ext.Panel({
        title: 'Estadistica Lineal Gestores- Cantidad',
        renderTo: 'Lineal',
        width:600,
        height:400,
        layout:'fit',

        items: {
            xtype: 'linechart',
            store: store,
            xField: 'Gestores',
            yField: 'Cantidad',
			listeners: {
				itemclick: function(o){
					var rec = store.getAt(o.index);
					Ext.example.msg('Item Selected', 'You chose {0}.', rec.get('Gestores'));
				}
			}
        }
    });//LINEAL
	 /*********************/
	 /*LINEA HORIZONTAL   */
	 /*********************/
	 
  });
}
			 