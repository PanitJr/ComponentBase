(function() {
  'use strict';

  angular
    .module('app')
    .config(routeConfig);

  function routeConfig($routeProvider) {
    $routeProvider
      .when('/users', {
        templateUrl: 'app/user/list.html',
        controller: 'listUserController',
        controllerAs: 'vm'
      }).when('/register',{
        templateUrl: 'app/user/register.html',
        controller: 'registerUserController',
        controllerAs: 'vm'
    }).when('/forgotpassword',{
      templateUrl: 'app/security/forgotPassword.html',
      controller: 'ForgotPasswordController',
      controllerAs: 'vm'
    }).when('/notification',{
      templateUrl: 'app/user/notification.html',
      controller: 'notificationUserController',
      controllerAs: 'vm'
    }).
    when('/addProduct',{
      templateUrl: 'app/product/editProduct.html',
      controller: 'addProductController',
      controllerAs: 'addProductController'
    }).
    when('/editProduct/:id',{
      templateUrl: 'app/product/editProduct.html',
      controller: 'editProductController',
      controllerAs: 'editProductController'
    }).
    when('/listProduct',{
      templateUrl: 'app/product/productList.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    })
      .otherwise({
        redirectTo: '/users'
      });
  }

})();
