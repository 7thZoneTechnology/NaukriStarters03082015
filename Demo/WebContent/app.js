(function(){
	var app=angular.module('store',[]);
	
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
	

	
	 app.controller('Java8Controller', function($scope, $http) {
	   	  
    	 var java=this;
    	 $http.get("http://localhost:8083/Demo/rest/hello/java8")
 	    .success(function(response) {
 	    	java.products=response;
 	    	console.log(java.products);
 		});
    	 
	});
	 
	 app.controller('Java7Controller', function($scope, $http) {
	   	  
    	 var java=this;
    	 
    	 $http.get("http://localhost:8083/Demo/rest/hello/java7")
	    .success(function(response) {
	    	java.products=response;
	    	console.log(java.products);
		});
    	 
	});
	
	 app.controller('Java9Controller', function($scope, $http) {
	   	  
    	 var java=this;
    	 
    	 $http.get("http://localhost:8083/Demo/rest/hello/java9")
 	    .success(function(response) {
 	    	java.products=response;
 	    	console.log(java.products);
 		});
    	 
	});
	
      app.controller('StoreController', function($scope, $http) {
    	  
    	 var store=this;
    	 $http.get("http://localhost:8083/Demo/rest/hello")
	    .success(function(response) {
	    	store.products=response;
	    	console.log(store.products);
		});
    	 
	});
			

  
		

	
})();

