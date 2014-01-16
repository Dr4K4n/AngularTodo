angular.module('twimbeeTodo', [
  'ngRoute',
  'ui.bootstrap',
  'TodoControllers',
  'TodoServices'  
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/todo', {templateUrl: 'partials/todo.html', controller: 'TodoController'});
  $routeProvider.otherwise({redirectTo: '/todo'});
}]);