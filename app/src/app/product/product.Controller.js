/**
 * Created by panit on 5/17/2016.
 */
(function () {
  'use strict';

  angular
    .module('app')
    .controller('listProductController', listProductController)
    .controller('addProductController', addProductController)
  ;


  /** @ngInject */
  function listProductController($route,productService) {
    var vm = this;
    productService.query(function (data) {
      vm.products = data;
    })

    vm.deleteProduct = function (id) {
      var answer = confirm("Do you want to delete the product?");
      if (answer) {
        productService.delete({id: id}, function () {
          $route.reload();
        })
      }
    }
  }
  /** @ngInject */
  function addProductController(productService,$location) {
    var vm = this;
    vm.addProduct = function (flowFiles) {
      productService.save(vm.product, function (data) {
        // after adding the object, add a new picture
        // get the product id which the image will be addded
        var productid = data.id;
        // set location
        flowFiles.opts.target = 'http://localhost:8080/productImage/add';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query = {productid: productid};
        flowFiles.upload();

        $location.path("listProduct");
      });
    }
  }
})();
