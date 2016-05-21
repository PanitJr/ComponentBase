(function() {
  'use strict';

  angular
    .module('app')
    .config(routeConfig);

  function routeConfig($routeProvider) {
    $routeProvider.
      when('/users', {
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
    when('/editUser',{
    templateUrl: 'app/user/edit.html',
    controller: 'editUserController',
    controllerAs: 'vm'
}).
    when('/listUser',{
      templateUrl: 'app/user/list.html',
      controller: 'listUserController',
      controllerAs: 'vm'
    }).
    when('/addProduct',{
      templateUrl: 'app/product/editProduct.html',
      controller: 'addProductController',
      controllerAs: 'vm'
    }).
    when('/editProduct/:id',{
      templateUrl: 'app/product/editProduct.html',
      controller: 'editProductController',
      controllerAs: 'vm'
    }).
    when('/listProduct',{
      templateUrl: 'app/product/productList.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/shoppingCart/:id',{
      templateUrl: 'app/shoppingcart/shoppingCart.html',
      controller: 'shoppingCartController',
      controllerAs: 'vm'
    }).
    otherwise({redirectTo: '/index.html'});

  }

})();
