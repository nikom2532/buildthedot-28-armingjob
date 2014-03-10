<?php
	@session_start(); 		
	include ($rootpath . "config/lib/db.php");
	include ($rootpath . "config/lib/conn.inc.php");
	// include ($rootpath . "config/lib/func_date.php");
	if (!$db -> open()) {
		die($db -> error());
	}
?>