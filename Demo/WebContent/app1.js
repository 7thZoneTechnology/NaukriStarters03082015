angular.module('app', [])
.config(['$routeProvider',
         function($routeProvider) {
	$routeProvider.
	when('/Collections', {
		templateUrl: 'templates/add_order.html',
		controller: 'AddOrderController'
	}).
	when('/Multithreading', {
		templateUrl: 'templates/show_orders.html',
		controller: 'ShowOrdersController'
	}).
	when('/Java9', {
		templateUrl: 'templates/java9.html',
		controller: 'Java9Controller'
	}).
	when('/Java8', {
		templateUrl: 'templates/java8.html',
		controller: 'Java8Controller'
	}).
	when('/Java7', {
		templateUrl: 'templates/java7.html',
		controller: 'Java7Controller'
	});

}])
.controller('StoreController', function($scope, $http) {

	var store=this;
	$http.get("http://localhost:8083/Demo/rest/hello")
	.success(function(response) {
		store.products=response;
		console.log(store.products);
	});

})
.controller('Java9Controller', function($scope, $http) {

	var java=this;

	$http.get("http://localhost:8083/Demo/rest/hello/java9")
	.success(function(response) {
		$scope.products=response;
		console.log($scope.products);
	});

})
.controller('Java8Controller', function($scope, $http) {

	var java=this;
	$http.get("http://localhost:8083/Demo/rest/hello/java8")
	.success(function(response) {
		$scope.products=response;
		console.log($scope.products);
	});

})
.controller('AddOrderController', function($scope) {

	$scope.message = 'This is Add new order screen';

})
.controller('ShowOrdersController', function($scope) {

	$scope.message = 'This is Show orders screen';

})	
.controller('ReviewController',function($scope,$http){
	this.review={};
	this.addReview = function(product){	
		
		// Writing it to the server
		//		
		console.log(product);
		product.reviews.push(this.review);
		this.review={};
		var dataObj =this.review;
		console.log(dataObj);
		
		var res = $http.post('http://localhost:8083/Demo/rest/hello/post', dataObj);
		res.success(function(data, status, headers, config) {
			this.message = data;
			console.log(this.message);
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});		
		// Making the fields empty
		//
		$scope.body='';
		$scope.author='';
		$scope.name='';
	};
	})
.controller('Java7Controller', function($scope, $http) {

	var java=this;

	$http.get("http://localhost:8083/Demo/rest/hello/java7")
	.success(function(response) {
		$scope.products=response;
		console.log($scope.products);
	});

});