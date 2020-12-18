<?php
    include_once 'api.php';
    $api = new api();
    header('Content-type: application/json');
    //http://localhost/QuizApp/login.php?username=Alpii22&password=testtest11AAA
    echo $api->login($_GET["username"], $_GET["password"]);

?>