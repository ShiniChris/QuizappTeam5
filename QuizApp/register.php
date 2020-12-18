<?php
    include_once 'api.php';
    $api = new api();
    header('Content-type: application/json');
    //http://localhost/QuizApp/register.php?username=Alp122&password=testtest11AAA&email=alpi@bib.de
    echo $api->register($_GET["username"], $_GET["password"], $_GET["email"]);

?>