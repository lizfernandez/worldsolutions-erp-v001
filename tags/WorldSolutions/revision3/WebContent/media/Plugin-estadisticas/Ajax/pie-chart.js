/*Ext.chart.Chart.CHART_URL = '/macro-1.1/public/media/Plugin-estadisticas/resources/charts.swf';

Ext.onReady(function(){
    var store = new Ext.data.JsonStore({
        fields: ['season', 'total'],
        data: [{
            season: 'Liz',
            total: 150
        },{
            season: 'Sara',
            total: 245
        },{
            season: 'Lucila',
            total: 117
        },{
            season: 'Rossana',
            total: 184
        }]
    });
    
    new Ext.Panel({
        width: 350,
        height: 300,
        title: 'Empleados',
        renderTo: 'torta',
        items: {
            store: store,
            xtype: 'piechart',
            dataField: 'total',
            categoryField: 'season',
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
    });
    new Ext.Panel({
        width: 350,
        height: 300,
	renderTo:'Barras', //window.opener.document.getElementById('contenido_estadistica'),
        title: 'Estadistica  Empleados',
       
        items: {
            xtype: 'columnchart',
            store: store,
            yField: 'total',
            xField: 'season',
            xAxis: new Ext.chart.CategoryAxis({
                title: 'Enfermedad'
            }),
            yAxis: new Ext.chart.NumericAxis({
                title: 'Pacientes'
            }),
            extraStyle: {
               xAxis: {
                    labelRotation: -90
                }
            }
        }
    	}).show();//barrras
    /*****************/
    /*GRAFICAS LINEAL*/
    /*****************/
	/* new Ext.Panel({
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
});*/

//Ext.chart.Chart.CHART_URL = '../../../include/extjs/resources/charts.swf';
/**/
//function graf(){
Ext.chart.Chart.CHART_URL = '/macro-1.2/public/media/Plugin-estadisticas/resources/charts.swf';

Ext.onReady(function(){

	/*   var store = new Ext.data.JsonStore({
        fields: ['Gestores', 'Cantidad'],
        data:[{"Gestores":"LECHE GLORIA","Cantidad":10},
              {"Gestores":"LECHE LAIVE","Cantidad":15},
              {"Gestores":"LECHE NESTLE","Cantidad":2},
              {"Gestores":"LECHE PURA VIDA","Cantidad":8},
              {"Gestores":"LECHE ANCHOR","Cantidad":5},
              {"Gestores":"DETERGENTE ARIEL","Cantidad":18},
              {"Gestores":"DETERGENTE BOLIVAR","Cantidad":20},
              {"Gestores":"DETERGENTE SAPOLIO","Cantidad":30}]
           });
	 /**/


  /*var store = new Ext.data.JsonStore({
     fields: ['Gestores','Cantidad'],
	 url: '../Datos/Estadistica_Expediente.php',
     root: ''

});*/

 var store = new Ext.data.JsonStore({
   // url: '../Datos/Estadistica_Expediente.php',/*apps/Estadisticas/Datos/Estadistica_Expediente.php',
    url: 'json/parametro/diario',
    baseParams: {
      symbol: ''
    },
    autoLoad: true,
    root: '',
    fields: ['Gestores', 'Cantidad']
  });/**/

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
            yField: 'Cantidad',
            xField: 'Gestores',
            xAxis: new Ext.chart.CategoryAxis({
                title: 'Prodcutos'
            }),
            yAxis: new Ext.chart.NumericAxis({
                title: 'Stock'
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
            store: store,
            xtype: 'piechart',
            dataField: 'Cantidad',
            categoryField: 'Gestores',
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
            store: store,
            xField: 'Gestores',
            yField: 'Cantidad',
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
//}
			 