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
    })
      .otherwise({
        redirectTo: '/users'
      });
  }

})();
