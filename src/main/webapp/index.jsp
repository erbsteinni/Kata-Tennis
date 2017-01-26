<!DOCTYPE html>
<html>
<head>
  <title>Project Tennis</title>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular.min.js"></script>
  <script src="app/TennisCtlr.js"></script>
  <link rel="stylesheet" type="text/css" href="views/tennis.css"></link>
  
  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

</head>

<body ng-app="tennisApp1">
<div ng-controller="TennisController">
	
	<div ng-hide="start">
<div class="add-box">
  <div>
    <div class="input-group">
      <span class="input-group-addon">
        Player 1
      </span>
      <input type="text" class="form-control" ng-model="nameP1" aria-label="...">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  <div>
    <div class="input-group">
      <span class="input-group-addon">
        Player 2
      </span>
      <input type="text" class="form-control" ng-model="nameP2" aria-label="...">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
  <button ng-click="nextStep()">GO</button>
	</div>
</div><!-- /.row -->


<div ng-show="start && !duel.tieBreak" class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Livescore</h3>
  </div>
  <div class="panel-body">
<table class="result-table">
  <tr>
    <td class="name-case">{{p1.name}}</td>
    <td class="game-case">
    	<span>{{p1.game}}</span>
    	<span class="points-case">{{convertPoint(p1.points)}}</span>
    	 </td> 
    <td class="enter-case">-</td>
        <td class="game-case">
		    <span>{{p2.game}}</span>
    		<span class="points-case">{{convertPoint(p2.points)}}</span>
		</td>
    <td class="name-case">{{p2.name}}</td> 
  </tr>
</table>
  </div>
  
  <div ng-hide="duel.finish">
  	<a class="glyphicon glyphicon-plus" aria-hidden="true" ng-click="winPoint1()"></a>
  	<a class="glyphicon glyphicon-plus" aria-hidden="true" ng-click="winPoint2()"></a>
  </div>
</div>

<div ng-show="start && duel.tieBreak" class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Livescore - Tie Break</h3>
  </div>
  <div class="panel-body">
<table class="result-table">
  <tr>
    <td class="name-case">{{p1.name}}</td>
    <td class="game-case">
    	<span>{{p1.game}}</span>
    	<span class="points-case">{{p1.tieBreak}}</span>
    	 </td> 
    <td class="enter-case">-</td>
        <td class="game-case">
		    <span>{{p2.game}}</span>
    		<span class="points-case">{{p2.tieBreak}}</span>
		</td>
    <td class="name-case">{{p2.name}}</td> 
  </tr>
</table>
  </div>
  
    <div ng-hide="duel.finish">
  	<a class="glyphicon glyphicon-plus" aria-hidden="true" ng-click="winPoint1()"></a>
  	<a class="glyphicon glyphicon-plus" aria-hidden="true" ng-click="winPoint2()"></a>
  </div>
</div>

<div ng-show="start && duel.finish">
	{{duel.winner.name}} emporte le set !
	
	<button ng-click="reset()">Recommencer</button>
</div>


<table ng-show="start" class="historique">
  <tr>
    <th>Tour</th>
    <th></th> 
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
  </tr>
  <tr ng-repeat="time in tours | reverse">
    <td>{{time.tour}}</td>
    <td>{{p1.name}}</td> 
    <td ng-class="time.class1">{{time.game1}}</td>
    <td ng-class="time.class1">{{time.point1}}</td>
    <td> - </td>
    <td ng-class="time.class2">{{time.point2}}</td>
    <td ng-class="time.class2">{{time.game2}}</td>
    <td>{{p2.name}}</td> 
  </tr>
</table>

</div>
</body>
</html>