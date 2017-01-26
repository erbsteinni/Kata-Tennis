var myApp = angular.module('tennisApp1', []);

myApp.controller('TennisController', ['$scope', '$http', function($scope, $http) {

	$scope.start=false;
	$scope.nameP1 = null;
	$scope.nameP2 = null;
	$scope.resume = "";
	$scope.tour = 1;
	
	$scope. tours = [];
	
	$scope.reset= function(){
		$scope.start = false;
		$scope.resume = "";
		$scope.tour = 1;
	}
	$scope.nextStep = function(){
		$scope.start = true;
		if($scope.nameP1 == null){
			$scope.nameP1 = 'Player1';
		}
		
		if($scope.nameP2 == null){
			$scope.nameP2 = 'Player2';
		}
		
		$scope.sendName($scope.nameP1, $scope.nameP2);
	}
    
    /*$http({
        method : "GET",
        url : "http://localhost:8080/Tennis-KataProject/rest/player/get"
    }).then(function mySucces(response) {
        $scope.players = response.data;
        console.log($scope.players);
        $scope.p1 = $scope.players[0];
        $scope.p2 = $scope.players[1];
    }, function myError(response) {
        $scope.myWelcome = response.statusText;
    });*/
    
    
    $scope.sendName = function(name1, name2){
    	
    	var sentData = [name1, name2];
    	
        var response=$http.post('http://localhost:8080/Tennis-KataProject/rest/player/init',
        		angular.toJson(sentData, false));
               response.success(function(data, status) {
            	   $scope.duel = data;
            	   $scope.p1 = data.player1;
            	   $scope.p2 = data.player2;
               });
               
        
    }
    
    $scope.winPoint1 = function(){
    	
        var response=$http.post('http://localhost:8080/Tennis-KataProject/rest/player/game/1',
        		angular.toJson($scope.duel, false));
               response.success(function(data, status) {
            	   $scope.duel = data;
            	   $scope.p1 = data.player1;
            	   $scope.p2 = data.player2;
            	   
            	   if($scope.duel.tieBreak){
                	   $scope.tours.push({
                		   tour: $scope.tour,
                		   game1: $scope.p1.game,
                		   game2: $scope.p2.game,
                		   point1: $scope.p1.tieBreak,
                		   point2: $scope.p2.tieBreak,
                		   class1: 'lineBold',
                		   class2: 'simpleLine'
                	   })
            	   }
            	   else{
                	   $scope.tours.push({
                		   tour: $scope.tour,
                		   game1: $scope.p1.game,
                		   game2: $scope.p2.game,
                		   point1: $scope.convertPoint($scope.p1.points),
                		   point2: $scope.convertPoint($scope.p2.points),
                		   class1: 'lineBold',
                		   class2: 'simpleLine'
                	   })
            	   }

            	   $scope.tour++;
               });
               
        
    }
    
    $scope.winPoint2 = function(){
    	
        var response=$http.post('http://localhost:8080/Tennis-KataProject/rest/player/game/2',
        		angular.toJson($scope.duel, false));
               response.success(function(data, status) {
            	   $scope.duel = data;
            	   $scope.p1 = data.player1;
            	   $scope.p2 = data.player2;
            	  
            	   
            	   if($scope.duel.tieBreak){
                	   $scope.tours.push({
                		   tour: $scope.tour,
                		   game1: $scope.p1.game,
                		   game2: $scope.p2.game,
                		   point1: $scope.p1.tieBreak,
                		   point2: $scope.p2.tieBreak,
                		   class1: 'simpleLine',
                		   class2: 'lineBold'
                	   })
            	   }
            	   else{
                	   $scope.tours.push({
                		   tour: $scope.tour,
                		   game1: $scope.p1.game,
                		   game2: $scope.p2.game,
                		   point1: $scope.convertPoint($scope.p1.points),
                		   point2: $scope.convertPoint($scope.p2.points),
                		   class1: 'simpleLine',
                		   class2: 'lineBold'
                	   })
            	   }
            	   $scope.tour++;
               });
               
        
    }
    
    
    
    
    $scope.convertPoint = function(object){
    	switch(object){
    	case("ZERO"):
    		return "00";
    	case("QUINZE"):
    		return "15";
    	case("TRENTE"):
    		return "30";
    	case("QUARANTE"):
    		return "40";
    	case("DEUCE"):
    		return "AA";
    	default:
    		return null;
    	}
    	
    }
}]);

myApp.filter('reverse', function() {
	  return function(items) {
	    return items.slice().reverse();
	  };
	});