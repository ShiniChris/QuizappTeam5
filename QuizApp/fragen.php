<?php
    include_once 'api.php';
    $api = new api();
    header('Content-type: application/json');
    //http://localhost/QuizApp/register.php?frage=2
    echo $api->getQuestion($_GET["frage"]);
    //print_r($api->getQuestion($_GET["frage"]));

?>