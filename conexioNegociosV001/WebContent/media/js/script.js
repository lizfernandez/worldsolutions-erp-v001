function include(url){
  document.write('<script src="'+url+'"></script>');
  return false ;
}

/* cookie.JS
========================================================*/
/*include('media/js/jquery.cookie.js');*/


/* DEVICE.JS
========================================================*/
include('media/js/device.min.js');

/* Stick up menu
========================================================*/
include('media/js/tmstickup.js');
$(window).load(function() { 
  if ($('html').hasClass('desktop')) {
      $('#stuck_container').TMStickUp({
      })
  }  
});

/* Easing library
========================================================*/
include('media/js/jquery.easing.1.3.js');


/* ToTop
========================================================*/
include('media/js/jquery.ui.totop.js');
$(function () {   
  $().UItoTop({ easingType: 'easeOutQuart' });
});

/* DEVICE.JS AND SMOOTH SCROLLIG
========================================================*/
include('media/js/jquery.mousewheel.min.js');
include('media/js/jquery.simplr.smoothscroll.min.js');

var platform = window.navigator.platform;
$(function () { 
  if ($('html').hasClass('desktop') && !(platform === 'MacIntel' || platform === 'MacPPC')) {
      $.srSmoothscroll({
        step:150,
        speed:800
      });
  }   
});

/* Stellar.js
========================================================*/
/*include('media/js/stellar/jquery.stellar.js');
$(document).ready(function() { 
  if ($('html').hasClass('desktop')) {
      $.stellar({
        horizontalScrolling: false,
        verticalOffset: 20
      });
  }
});

*/
/* Copyright Year
========================================================*/
/*var currentYear = (new Date).getFullYear();
$(document).ready(function() {
  $("#copyright-year").text( (new Date).getFullYear() );
});
*/

/* Superfish menu
========================================================*/
include('media/js/superfish.js');
include('media/js/jquery.mobilemenu.js');


/* Orientation tablet fix
========================================================*/
$(function(){
// IPad/IPhone
	var viewportmeta = document.querySelector && document.querySelector('meta[name="viewport"]'),
	ua = navigator.userAgent,

	gestureStart = function () {viewportmeta.content = "width=device-width, minimum-scale=0.25, maximum-scale=1.6, initial-scale=1.0";},

	scaleFix = function () {
		if (viewportmeta && /iPhone|iPad/.test(ua) && !/Opera Mini/.test(ua)) {
			viewportmeta.content = "width=device-width, minimum-scale=1.0, maximum-scale=1.0";
			document.addEventListener("gesturestart", gestureStart, false);
		}
	};
	
	scaleFix();
	// Menu Android
	if(window.orientation!=undefined){
  var regM = /ipod|ipad|iphone/gi,
   result = ua.match(regM)
  if(!result) {
   $('.sf-menu li').each(function(){
    if($(">ul", this)[0]){
     $(">a", this).toggle(
      function(){
       return false;
      },
      function(){
       window.location.href = $(this).attr("href");
      }
     );
    } 
   })
  }
 }
});
var ua=navigator.userAgent.toLocaleLowerCase(),
 regV = /ipod|ipad|iphone/gi,
 result = ua.match(regV),
 userScale="";
if(!result){
 userScale=",user-scalable=0"
}
document.write('<meta name="viewport" content="width=device-width,initial-scale=1.0'+userScale+'">')