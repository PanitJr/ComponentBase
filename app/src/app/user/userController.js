/**
 * Created by panit on 5/4/2016.
 */
(function () {
  'use strict';

  angular
    .module('app')
    .controller('listUserController', listUserController)
    .controller('registerUserController', registerUserController);

  /** @ngInject */
  function listUserController(userService, userSearchService) {
    var vm = this;
    //$http.get("/product/").success(function (data) {
    vm.queryPromise = userService.query(function (data) {
      // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
      vm.users = data;
    }).$promise;

    vm.search = function (name) {
      userSearchService.query({name:name}, function (data) {
        vm.users = data;
        vm.reload();
      });
    }

  }
  /**@ngInject*/
  function registerUserController(userService,$location) {
    var vm = this;
    vm.confirmPasswordCheck = function () {
      
    }
    vm.addUser = function () {
      userService.save(vm.user);
      $location.path("users");
    }
  }
})();
