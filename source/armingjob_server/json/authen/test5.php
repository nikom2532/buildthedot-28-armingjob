<?php
	// Prevent caching.
	header('Cache-Control: no-cache, must-revalidate');
	header('Expires: Mon, 01 Jan 1996 00:00:00 GMT');
	
	// The JSON standard MIME header.
	header('Content-type: application/json');
	
	// This ID parameter is sent by our javascript client.
	$email = $_POST['email'];
	$password = $_POST['password'];
	
	// Here's some data that we want to send via JSON.
	// We'll include the $id parameter so that we
	// can show that it has been passed in correctly.
	// You can send whatever data you like.

	

	$data = array(
		"email" => "-".$email."-" ,
		"password" => "Thailand" 
	);
	
	// Send the data.
	echo json_encode($data);
	//print_r($data);

	$file = 'test.txt';
	// Open the file to get existing content
	$current = file_get_contents($file);
	// Append a new person to the file
	$current .= print_r($_POST);
	// Write the contents back to the file
	file_put_contents($file, $current);
?>
