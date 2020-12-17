<?php
class Database
{
	function getConnection()
	{
		try {
			$conn = oci_connect("quizzteam5", "QuizzApp1645", "quizzapp_high");
	
	
			if (!$conn) {
				echo "<br>Function 'oci_connect' found and working but cannot connect to Oracle: <br>";
				$m = oci_error();
				echo $m['message'], "\n";
				exit;
			}
		} catch (Exception $e) {
			echo $e->getMessage();
		}
	
		
		return $conn;
	}
	
}

    
?>