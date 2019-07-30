angular.module('loblaws.erefill').controller('RefillController', ['$scope', '$http', 
    function ($scope, $http) {
        'use strict';
        var data = {username: 'zorankroll', password: 'ABcd1234'};
        var api = "http://localhost:8080/lcl-erefill-services/en_CA/user/login";
        $http({
            url: api,
            dataType: "json",
            method: "POST",
            headers: {
            	"Accept": "application/json",
            	'Content-Type': 'application/x-www-form-urlencoded'
            },
            data: $.param(data),
        }).success(function(response){      	
        	$scope.message = "success.";
        	alert("testing");
        }).error(function(error){
        	$scope.message = "Something went wrong.";
        });        
    }]);