<?php
include_once('../../../class/conexion.class.php');
include_once('../../../include/function/funcionphp.php');
$objBusqueda = new BDManager();
    $result= $objBusqueda->spConsultaProcedure('spEstadistica_Gestor');
    while ($obj = mssql_fetch_object($result)) { 
      $arr[] = $obj; 
   }
  echo ''.json_encode($arr).'';
 // echo $arr;

?>