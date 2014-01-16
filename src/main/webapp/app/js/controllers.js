var todoControllers = angular.module('TodoControllers', ['TodoServices']);

todoControllers.controller('TodoController', ['$scope', 'Todo', function($scope, Todo) {
        $scope.todos = Todo.query();
        
        $scope.addTodo = function($newTodo) {
            var newTodo = new Todo({'text':$newTodo});
            newTodo.$save();
            $scope.todos.push(newTodo);
            $scope.newTodo = "";
        };
        
        $scope.removeTodo = function($removeTodo) {
            $removeTodo.$remove();
            $scope.todos = Todo.query();
        };
    }]);