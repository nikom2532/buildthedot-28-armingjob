<?php
	// $host="localhost";
	// $username="imingcom_arming";
	// $password="cominter";
	// $database="imingcom_DB";
	// $db=new DB($host,$username,$password,$database);

	$cn = @mysql_connect("localhost","imingcom_arming","cominter");
	mysql_select_db("imingcom_DB",$cn);
?>
