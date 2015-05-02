$(document).ready(		
    function()
    {
            	    	
       $('#dock2').Fisheye(
        {
            maxWidth: 30,
            items: 'a',
            itemsText: 'span',
            container: '.dock-container2',
            itemWidth: 50,
            proximity: 90,
            alignment : 'left',
            valign: 'bottom',
            halign : 'left'
        }
        );
    }
    );