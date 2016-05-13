<?php
include_once 'session.php';
if(isset($_POST['inputName']) && isset($_POST['inputDescription']) && isset($_POST['inputStartDate']) && isset($_POST['inputEndDate'])) {

  if('user' == $user_type){
    $productId = ProductController::addProduct(new Product("", $logInAccount->getAccountId(), $_POST['inputName'], $_POST['inputDescription'],"", 1));
  }

  if('admin' == $user_type){
    $productId = ProductController::addProduct(new Product("", $_POST['selectedShopId'], $_POST['inputName'], $_POST['inputDescription'],"", 1));
  }
  $_SESSION['manageProductStatus']= "true";
  $_SESSION['manageProductAction'] = "add";
  header('Location: '.Config::PATH.'/products');
  exit;
}
?>

<!DOCTYPE html>
<html>
<head>
  <title>WAP / Add Product</title>
  <?php

  $assetPath = Config::PATH.'';

  include_once '../assets.php';
  ?>
  <!--    <script src="../lightbox.js"></script>-->
</head>
<body>
<div style="margin: 80px;" class="container-fluid">
  <div class="row">
    <form id="addProductForm" action="" method="post" enctype="multipart/form-data">

      <div class="col-md-12">
        <label class="titleFontSize">New product</label>
      </div>
      <div class="col-md-6">
        <div class="form-group productName">
          <label class="control-label" for="inputName">Product name</label>
          <input id="productName" type="text" class="form-control" name="inputName" placeholder="Rice" required>
        </div>
      </div>
      <?php
      if('admin'== $user_type) {
        echo'
                    <div class="col-md-6">
                        <div class="form-group selectShop">
                            <label class="control-label" for="inputEmail">Select shop</label>
                            <div class="form-group">
                                <button id="clickSelectShop" type="button" class="btn btn-default" data-toggle="modal" data-target=".bs-example-modal-lg">Select Shop</button>
                                <label class="control-label" id="show"></label>
                                <input type="hidden" id="selectedShopId" name="selectedShopId">
                            </div>
                        </div>
                    </div>';
      }
      ?>
      
      <div id="selectImageDiv" class="col-md-6">
        <div class="form-group">
          <label for="files">Select image(s)</label>
          <input class="form-control" id="files" name="files[]" type="file" multiple/>
        </div>
      </div>
      <div class="col-md-12" id="result"></div>
      <div class="col-md-12">
        <div class="form-group description">
          <label class="control-label">Description</label>
          <textarea id="description" class="form-control" name="inputDescription" rows="3" required placeholder="Something describe about your product"></textarea>
        </div>
      </div>
      <div class="col-md-12">
        <div class="form-group description">
          <label class="control-label">Price</label>
          <textarea id="price" class="form-control" name="inputPrice" rows="4" required placeholder="250"></textarea>
        </div>
      </div>
      <div class="col-md-12">
        <a class="btn btn-default" href="account_ledt.php" role="button">Back</a>
        <button type="submit" id="clickSubmit" name="add" class="btn btn-default">Submit</button>
      </div>
    </form>
    <!-- /row -->
  </div>
</div>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
            aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel">Shop list</h4>
      </div>
      <div class="modal-body">
        <table class="table table-hover table-condensed">
          <tr>
            <th>Product name</th>
            <th>Description</th>
            <th>Action</th>
          </tr>
          <?php
          $shopImageController = new ShopImageController();
          $shopList = ShopInformationController::getAllShopInformation();
          foreach ($shopList as $shop) {

            $shopImage = $shopImageController->getImageByAccountId($shop->getAccountId())[0];
            $imagePath = '';
            if($shopImage != null){
              $imagePath = Config::PATH."/".$shopImage->getImagePath();
            } else {
              $imagePath = Config::PATH."/img/noimage.png";
            }
            echo('
                <tr>
                    <td>' . $shop->getName() . '</td>
                    <td>' . $shop->getDescription() . '</td>
                    <td id="wth"><input type="hidden" id="' . $shop->getAccountId() . '" value="' . $shop->getName() . '"><button id="' . $shop->getAccountId() . '" data-dismiss="modal" class="btn btn-default">Select</button></td>
                </tr>');
          }
          ?>
        </table>
      </div>
    </div>
  </div>
</div>
<script src="<?php echo $assetPath; ?>/jquery.js"></script>
<script src="<?php echo $assetPath; ?>/bootstrap/js/bootstrap.min.js"></script>
<script src="productvalidation.js"></script>
<script type="text/javascript">

  window.onload = function(){
    //Check File API support
    if(window.File && window.FileList && window.FileReader)
    {
      var filesInput = document.getElementById("files");
      filesInput.addEventListener("change", function(event){
        var files = event.target.files; //FileList object
        var output = document.getElementById("result");
        for(var i = 0; i< files.length; i++)
        {
          var file = files[i];
          //Only pics
          if(!file.type.match('image'))
            continue;
          var picReader = new FileReader();
          picReader.addEventListener("load",function(event){
            var picFile = event.target;
            var div = document.createElement("div");
            div.innerHTML = "<img class='img-rounded img-thumbnail col-sm-3' src='" + picFile.result + "'" +"title='" + picFile.name + "'/>";
            output.insertBefore(div,null);
          });
          //Read the image
          picReader.readAsDataURL(file);
        }
      });
    }
    else
    {
//            console.log(“Your browser does not support File API”);
    }
  }
</script>
</body>
</html>
