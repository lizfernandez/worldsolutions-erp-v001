
function newImage(nImage, arg, tip ) {
    if (document.images) {
        switch(nImage){
            case "view":
                document.getElementById('ykFoot').imgview.src = arg;
                break;
            case "save":
                document.getElementById('ykFoot').imgsave.src = arg;
                break;
            case "nuevo":
                document.getElementById('ykFoot').imgnuevo.src = arg;
		break;
            case "update":
                document.getElementById('ykFoot').imgupdate.src = arg;
		break;
            case "printer":
                document.getElementById('ykFoot').imgprinter.src = arg;
                break;
            case "delete":
                document.getElementById('ykFoot').imgdelete.src = arg;
                break;
            case "ok":
                document.getElementById('ykFoot').imgok.src = arg;
                break;
            case "refresh":
                document.getElementById('ykFoot').imgrefresh.src = arg;
                break;
            case "exit":
                document.getElementById('ykFoot').imgexit.src = arg;
                break;
            case "left":
                document.getElementById('ykFoot').imgleft.src = arg;
                break;
            case "right":
                document.getElementById('ykFoot').imgright.src = arg;
                break;
            case "bien":
                document.getElementById('ykFoot').imgbien.src = arg;
                break;
            case "parametro":
                document.getElementById('ykFoot').imgparametro.src = arg;
                break;
            case "usuario":
                document.getElementById('ykFoot').imgusuario.src = arg;
            case "salir":
                document.getElementById('ykFoot').imgsalir.src = arg;

            break;
	}
	return true;
    }
}