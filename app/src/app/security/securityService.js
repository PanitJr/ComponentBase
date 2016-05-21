/**
 * Created by waiti on 4/22/2016.
 */
(function () {
  'use strict'
  angular.module('app').factory('UserService',UserService)
  /**ngInject*/
  function UserService($resource){
    return $resource('/auth/:action',{},
      {authenticate:
      {
        method:'POST',
        params:{'action':'authenticate'},
        header: {'Content-Type' : 'application/x-www-form-urlencoded'}
      }
      })
  }
})();
