
$(document).ready(function(){
	//$('.sf-menu').mobileMenu();
	$('#menu').append('<div id="icon-menu"/>');
	$('#menu').append('<div id="navigation"/>');	
	$('#menu .sf-menu').clone().appendTo('#navigation');
	$("#navigation ul.sf-menu").removeClass('sf-menu').addClass('tree');
	$("#navigation ul li").removeClass('current').addClass('head1');
	$('#icon-menu').click(function() { 
	     	var stylo=$("#navigation").css("display");
	        if(stylo=="none"){
	        	$('#navigation').show();           
	        }
	        else{
	            $("#navigation").hide();
	          
	        }
	    });
	
});