/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var todoServices = angular.module('TodoServices',['ngResource']);

todoServices.service('Todo', ['$resource', function($resource) {
    return $resource('../api/todo/:id', {id:'@id'});
}]);

