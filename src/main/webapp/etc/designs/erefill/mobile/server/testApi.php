<?php
	$data = json_decode(file_get_contents("php://input"));
	header("Content-type:application/json;");	
	//sleep(200000);	
	echo '
			{
		        "Success": true,
		        "ErrorMessage": "Invalid Phone Number and Pin.",
		        "SuccessMessage": "Welcome to Loblaws AngularJs E refill project."
		    }';	
?>