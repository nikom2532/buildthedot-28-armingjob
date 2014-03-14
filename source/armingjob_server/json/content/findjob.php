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
	
	$response = array();
	
	$sql_user = "
		SELECT * 
		FROM  `buildthedot_armingjob_job` ;
	";
	$result_user = @mysql_query($sql_user);
	
	// check for empty result
	if (mysql_num_rows($result) > 0) {
	    $response["data"] = array();
	
		while($row = @mysql_fetch_array($result_user)) {
			
	        // temp user array
	        $data = array();
	        $data["id"] = $row["id"];
	        $data["company_id"] = $row["company_id"];
	
	        // push single product into final response array
	        array_push($response["data"], $data);
	    }
	    // success
	    //$response["success"] = 1;
	
	    // echoing JSON response
	    echo json_encode($response);
	} else {
	    // no data found
	    //$response["success"] = 0;
	    //$response["message"] = "No data found";
	
	    // echo no users JSON
	    echo json_encode($response);
	}
?>