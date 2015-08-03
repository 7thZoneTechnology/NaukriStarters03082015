(function(){
	var app=angular.module('store',['app1']);
	
	app.controller('ReviewController',function($scope,$http){
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
	});
	

	
      app.controller('StoreController', function($scope, $http) {
    	  
    	 var store=this;
    	 $http.get("http://localhost:8083/Demo/rest/hello")
	    .success(function(response) {
	    	store.products=response;
	    	console.log(store.products);
		});
    	 
    	 app.filter('newlines', function () {
    		    return function(text) {
    		        return text.replace(/\n/g, '<br/>');
    		    }
    		});
    	 
	});
      
      var app1 = angular.module("app1", ['ngRoute'])
      app1.config(['$routeProvider',
                  function($routeProvider) {
                    $routeProvider.
                      when('/hibernate', {
                        templateUrl: 'templates/collections.html',
                        controller: 'CollectionsController'
                      }).
                      when('/exception', {
                          templateUrl: 'templates/exception.html',
                          controller: 'ExceptionController'
                        }).
                      when('/multithreading', {
                        templateUrl: 'templates/multithreading.html',
                        controller: 'MultithreadingController'
                      }).
                      when('/firstpage', {
                        templateUrl: 'templates/firstpage.html',
                        controller: 'ShowOrdersController'
                      }).
                      when('/java9', {
                        templateUrl: 'templates/java9.html',
                        controller: 'Java9Controller'
                      }).
                      when('/java8', {
                        templateUrl: 'templates/java8.html',
                        controller: 'Java8Controller'
                      }).
                      when('/java7', {
                        templateUrl: 'templates/java7.html',
                        controller: 'Java7Controller'
                      }).
                      otherwise({
                          redirectTo: '/firstpage'
                        });

                    
                  }]);

      app1.controller('CollectionsController', function($scope,$http) 
   {
	   	  
     	 $http.get("http://localhost:8083/Demo/rest/hello/interviewCollections")
  	    .success(function(response) {
  	    	$scope.products=response;
  	    	console.log($scope.products);
  		});
     	 $scope.toggle = function() {
             $scope.myVar = !$scope.myVar;
         };
     	 
 	});
      
      app1.controller('MultithreadingController', function($scope,$http) 
    		   {
    			   	  
    		     	 $http.get("http://localhost:8083/Demo/rest/hello/interviewmultithreading")
    		  	    .success(function(response) {
    		  	    	$scope.products=response;
    		  	    	console.log($scope.products);
    		  		});
    		     	 $scope.toggle = function() {
    		             $scope.myVar = !$scope.myVar;
    		         };
    		     	 
    		 	});
      
      app1.controller('ExceptionController', function($scope,$http) 
    		   {
    			   	  
    		     	 $http.get("http://localhost:8083/Demo/rest/hello/interviewException")
    		  	    .success(function(response) {
    		  	    	$scope.products=response;
    		  	    	console.log($scope.products);
    		  		});
    		     	 $scope.toggle = function() {
    		             $scope.myVar = !$scope.myVar;
    		         };
    		     	 
    		 	});


      app1.controller('ShowOrdersController', function($scope) {

      $scope.message = 'This is Show orders screen';

      });
      
      app1.controller('Java8Controller', function($scope, $http) {
	   	  
     	 $http.get("http://localhost:8083/Demo/rest/hello/java8")
  	    .success(function(response) {
  	    	$scope.products=response;
  	    	console.log($scope.products);
  		});
     	 $scope.toggle = function() {
             $scope.myVar = !$scope.myVar;
         };
     	 
 	});
 	 
 	 app1.controller('Java7Controller', function($scope, $http) {
 	   	  
     	 
     	 $http.get("http://localhost:8083/Demo/rest/hello/java7")
 	    .success(function(response) {
 	    	$scope.products=response;
 	    	console.log($scope.products);
 		});
     	 $scope.toggle = function() {
             $scope.myVar = !$scope.myVar;
         };
     	 
 	});
 	
 	 app1.controller('Java9Controller', function($scope, $http) {
 	   	  
     	 
     	 $http.get("http://localhost:8083/Demo/rest/hello/java9")
  	    .success(function(response) {
  	    	$scope.products=response;
  	    	console.log($scope.products);
  		});
     	 $scope.toggle = function() {
             $scope.myVar = !$scope.myVar;
         };
 	});

				
})();