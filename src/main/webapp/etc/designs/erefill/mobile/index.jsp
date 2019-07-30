<!DOCTYPE html>
<!--[if lt IE 7]>
<html role="main" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>
<html role="main" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9"> <![endif]-->
<!--[if IE 9]>
<html class="no-js lt-ie10"><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>Loblaws-E refill</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" href="styles/bootstrap.css"/>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body ng-app="loblaws.erefill">
<!-- views will be injected here -->
<div class="container page-content">
    <div class="row">
        <div class="center-block">
            <div ng-view></div>                                
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="./lib/angular.js"></script>
<script src="./lib/angular-route.js"></script>
<script src="./scripts/app.js"></script>
<script src="./scripts/routes.js"></script>
<script src="./scripts/controller.js"></script>

</body>
</html>