<?php
	// Prevent caching.
	header('Cache-Control: no-cache, must-revalidate');
	header('Expires: Mon, 01 Jan 1996 00:00:00 GMT');
	
	// The JSON standard MIME header.
	header('Content-type: application/json');
	
	// $rootpath="../../";
	// include($rootpath."config/header.php");
	$cn = @mysql_connect("localhost","imingcom_arming","cominter");
	@mysql_select_db("imingcom_DB",$cn);
	
	//##############################################################################
	
	// This ID parameter is sent by our javascript client.
	$email = $_POST['email'];
	$password = $_POST['password'];
	$EncryptPassword = md5(sha1($password)).sha1(md5($password));
	
	$message = "notAuthened";
	$sql_user = "
		SELECT *
		FROM `buildthedot_armingjob_user_account`
		WHERE `email` = '{$email}';
	";
	$result_user = @mysql_query($sql_user);
	if($rs_user = @mysql_fetch_array($result_user)) {
		if($EncryptPassword == $rs_user["password"]){
			$message = "Authened";
		}
		elseif($EncryptPassword != $rs_user["password"]){
			$message = "wrongPassword";
		}
	}
	else{
		$message = "wrongUser";
	}
	
	
	// Here's some data that we want to send via JSON.
	// We'll include the $id parameter so that we
	// can show that it has been passed in correctly.
	// You can send whatever data you like.

	

	$data = array(
		"email" => $email ,
		"message" => $message 
	);
	
	// Send the data.
	echo json_encode($data);
	//print_r($data);
?>