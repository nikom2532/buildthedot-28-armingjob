<?php
	// Prevent caching.
	header('Cache-Control: no-cache, must-revalidate');
	header('Expires: Mon, 01 Jan 1996 00:00:00 GMT');
	
	// The JSON standard MIME header.
	header('Content-type: application/json');
	
	// $rootpath="../../";
	// include($rootpath."config/header.php");
	
	//############ Local
	// $cn = @mysql_connect("localhost","iming","iming");
	// @mysql_select_db("buildthedot_28armingjob",$cn);
	
	//############ Global
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
	if (@mysql_num_rows($result_user) > 0) {
	    $response["data"] = array();
	
		while($row = @mysql_fetch_array($result_user)) {
			
	        // temp user array
	        $data = array();
	        $data["jobID"] = $row["id"];
			
			
			$sql_company = "
				SELECT * 
				FROM  `buildthedot_armingjob_company` 
				WHERE `id` = {$row["company_id"]}
			";
			$result_company = @mysql_query($sql_company);
			if($rs_company = @mysql_fetch_array($result_company)){
		        $data["CompanyName"] = $rs_company["company_name"];
				$data["CompanyAddress"] = $rs_company["short_address"];
			}
			
			$data["position_thai"] = $row["position_thai"];
			$data["position_eng"] = $row["position_eng"];
			$data["salary"] = $row["salary"];
			$data["job_description"] = $row["job_description"];
			$data["job_type"] = $row["job_type"];
			
			
			
			$data["date_start"] = strtotime($row["date_start"]);
			$data["date_end"] = strtotime($row["date_end"]);
			
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