<?php
	include 'Database.php';
	
	class api{
	

	function register($username, $passwort, $email){

		if (!filter_var($email, FILTER_VALIDATE_EMAIL))
		{
			return $this->standardJsonReply(false,4,"Bitte geben sie eine Gültige E-Mail an");
		} 
		if(isset($username) && isset($email) && isset($passwort)){
			//regex um nach zahl zu prüfen
			if(strlen($passwort) >=6 && preg_match("/\d/",$passwort)){
				$hashedpw = password_hash($passwort, PASSWORD_DEFAULT);
                $stmt = "INSERT INTO quizapp_player (USERNAME, PASSWORDHASH, EMAIL, VERIFIED) VALUES('$username','$hashedpw','$email',1)";
				error_reporting(E_ERROR | E_PARSE);
				$ret = $this->executeStmt($stmt);
				$this->sendMail($email);
				return $this->standardJsonReply(true ,0 ,"$username");
				
			}
			$this->sendRegisterMail($email);
		}
               
	}  
	function login($username, $passwort)
	{
		if(isset($username) && isset($passwort)){
		$stmt = "SELECT USERNAME, PASSWORDHASH, VERIFIED from quizapp_player where USERNAME='$username'";
		$sql = $this->executeStmt($stmt);
		$row = oci_fetch_assoc($sql);
		if(password_verify($passwort, $row['PASSWORDHASH']) && $row['VERIFIED'] == 1)
		{
			return $this->standardJsonReply(true,0,"$username");
		}
		else
		{
			return $this->standardJsonReply(false,3,"unverified");
		}
	}
		else
		{
		return $this->standardJsonReply(false,2,"Username or Password is wrong");
		}
	}
	function executeStmt($stmt){
		$db = new Database();
		$conn = $db->getConnection();
		$sql = oci_parse($conn, $stmt);
		oci_execute($sql);

		//omits warnings
		error_reporting(E_ERROR | E_PARSE);

		if(oci_error($sql)["code"] == 1){
			echo "fehler";
			oci_close($conn);
			return oci_error($sql);
			
		}
		oci_close($conn);
		return $sql;
	}
	function standardJsonReply($success, $code, $msg){
		$ret["success"] = $success;
		$ret["code"] = $code;
		$ret["msg"] = $msg;
		return json_encode($ret);
		
	}
	function sendMail($email){
		$msg = "
                Wie wurden erfolgreich Registriert.
            ";
            mail($email, "Quizapp Registrierung", $msg);
	}
	




	}
    
?>
