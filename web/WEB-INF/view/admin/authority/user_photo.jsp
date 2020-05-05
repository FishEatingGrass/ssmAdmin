<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include   page="../public/header.jsp" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/admin/plugins/imgCut/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/admin/plugins/imgCut/css/default.css">
  	<link href="<%=request.getContextPath() %>/static/admin/plugins/imgCut/dist/cropper.css" rel="stylesheet">
  	<link href="<%=request.getContextPath() %>/static/admin/plugins/imgCut/css/main.css" rel="stylesheet">
<body class="gray-bg">
    <div class="wrapper wrapper-content">

        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <body>
	<div class="htmleaf-container">
		
  <div class="container">
    <div class="row">
      <div class="col-md-9">
        <!-- <h3 class="page-header">Demo:</h3> -->
        <div class="img-container">
          <img src="<%=request.getContextPath() %>/static/admin/plugins/imgCut/picture.png" alt="Picture">
        </div>
      </div>
      <div class="col-md-3">
        <!-- <h3 class="page-header">Preview:</h3> -->
        <div class="docs-preview clearfix">
          <div class="img-preview preview-lg"></div>
          <div class="img-preview preview-md"></div>
          <div class="img-preview preview-sm"></div>
          <div class="img-preview preview-xs"></div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-md-9 docs-buttons">
        <!-- <h3 class="page-header">Toolbar:</h3> -->
        <div class="btn-group">
          <button class="btn btn-primary" data-method="setDragMode" data-option="move" type="button" title="Move">
            <span class="docs-tooltip" >
              <span class="icon icon-move"></span>
            </span>
          </button>
          <button class="btn btn-primary" data-method="setDragMode" data-option="crop" type="button" title="Crop">
            <span class="docs-tooltip" >
              <span class="icon icon-crop"></span>
            </span>
          </button>
          <button class="btn btn-primary" data-method="zoom" data-option="0.1" type="button" title="Zoom In">
            <span class="docs-tooltip" >
              <span class="icon icon-zoom-in"></span>
            </span>
          </button>
          <button class="btn btn-primary" data-method="zoom" data-option="-0.1" type="button" title="Zoom Out">
            <span class="docs-tooltip" >
              <span class="icon icon-zoom-out"></span>
            </span>
          </button>
          <button class="btn btn-primary" data-method="rotate" data-option="-45" type="button" title="Rotate Left">
            <span class="docs-tooltip" >
              <span class="icon icon-rotate-left"></span>
            </span>
          </button>
          <button class="btn btn-primary" data-method="rotate" data-option="45" type="button" title="Rotate Right">
            <span class="docs-tooltip" >
              <span class="icon icon-rotate-right"></span>
            </span>
          </button>
        </div>

        <div class="btn-group">
          <button class="btn btn-primary" data-method="disable" type="button" title="Disable">
            <span class="docs-tooltip" >
              <span class="icon icon-lock"></span>
            </span>
          </button>
          <button class="btn btn-primary" data-method="enable" type="button" title="Enable">
            <span class="docs-tooltip" >
              <span class="icon icon-unlock"></span>
            </span>
          </button>
          <button class="btn btn-primary" data-method="clear" type="button" title="Clear">
            <span class="docs-tooltip" >
              <span class="icon icon-remove"></span>
            </span>
          </button>
          <button class="btn btn-primary" data-method="reset" type="button" title="Reset">
            <span class="docs-tooltip" >
              <span class="icon icon-refresh"></span>
            </span>
          </button>
          <label class="btn btn-primary btn-upload" for="inputImage" title="Upload image file">
            <input class="sr-only" id="inputImage" name="file" type="file" accept="image/*">
            <span class="docs-tooltip" >
              <span class="icon icon-upload"></span>
            </span>
          </label>
          <button class="btn btn-primary" data-method="destroy" type="button" title="Destroy">
            <span class="docs-tooltip" >
              <span class="icon icon-off"></span>
            </span>
          </button>
        </div>

        <div class="btn-group btn-group-crop">
          <button class="btn btn-primary" id="getCroppedCanvas" type="button">
            <span class="docs-tooltip">
            	 上传头像
            </span>
          </button>
        </div>
      </div><!-- /.docs-buttons -->
    </div>
  </div>
  <!-- Alert -->
                    
                </div>
            </div>
        </div>
        
    </div>
    <jsp:include page="../public/footer.jsp" />
	<script type="text/javascript">
	$(function () {

		  'use strict';

		  var console = window.console || { log: function () {} },
		      $alert = $('.docs-alert'),
		      $message = $alert.find('.message'),
		      showMessage = function (message, type) {
		        $message.text(message);

		        if (type) {
		          $message.addClass(type);
		        }

		        $alert.fadeIn();

		        setTimeout(function () {
		          $alert.fadeOut();
		        }, 3000);
		      };

		  // Demo
		  // -------------------------------------------------------------------------

		  (function () {
		    var $image = $('.img-container > img'),
		        $dataX = $('#dataX'),
		        $dataY = $('#dataY'),
		        $dataHeight = $('#dataHeight'),
		        $dataWidth = $('#dataWidth'),
		        $dataRotate = $('#dataRotate'),
		        options = {
		          // strict: false,
		          // responsive: false,
		          // checkImageOrigin: false

		          // modal: false,
		          // guides: false,
		          // highlight: false,
		          // background: false,

		          // autoCrop: false,
		          // autoCropArea: 0.5,
		          // dragCrop: false,
		          // movable: false,
		          // resizable: false,
		          // rotatable: false,
		          // zoomable: false,
		          // touchDragZoom: false,
		          // mouseWheelZoom: false,

		          // minCanvasWidth: 320,
		          // minCanvasHeight: 180,
		          // minCropBoxWidth: 160,
		          // minCropBoxHeight: 90,
		          // minContainerWidth: 320,
		          // minContainerHeight: 180,

		          // build: null,
		          // built: null,
		          // dragstart: null,
		          // dragmove: null,
		          // dragend: null,
		          // zoomin: null,
		          // zoomout: null,

		          aspectRatio: 1 / 1,
		          
		          preview: '.img-preview',
		          crop: function (data) {
		            $dataX.val(Math.round(data.x));
		            $dataY.val(Math.round(data.y));
		            $dataHeight.val(Math.round(data.height));
		            $dataWidth.val(Math.round(data.width));
		            $dataRotate.val(Math.round(data.rotate));
		        	  
		          }
		        };

		    $image.on({
		      'build.cropper': function (e) {
		        console.log(e.type);
		      },
		      'built.cropper': function (e) {
		        console.log(e.type);
		      },
		      'dragstart.cropper': function (e) {
		        console.log(e.type, e.dragType);
		      },
		      'dragmove.cropper': function (e) {
		        console.log(e.type, e.dragType);
		      },
		      'dragend.cropper': function (e) {
		        console.log(e.type, e.dragType);
		      },
		      'zoomin.cropper': function (e) {
		        console.log(e.type);
		      },
		      'zoomout.cropper': function (e) {
		        console.log(e.type);
		      }
		    }).cropper(options);
		    
		    /**
		     * 头像上传
		     */
		    $(document.body).on('click',"#getCroppedCanvas",function(){
		    	layer.confirm('上传裁剪的图片作为头像吗？', {
		    		  btn: ['确定','取消'] //按钮
		    	}, function(){
		    		  var imgData = $image.cropper("getCroppedCanvas").toDataURL();
						$.ajax({
							method:"post",
							url: "<%=request.getContextPath() %>/admin/user/photoHandle",//用于文件上传的服务器端请求地址
							data: {imgData:imgData},
							dataType : "json",
							success:function(result){
								if(result.code == "200"){
									layer.msg('成功', {icon: 1});
									top.location.href = "<%=request.getContextPath() %>/admin/index/index";
								}else{
									layer.msg('失败', {icon: 2});
								}
							}
						});
		    	});
		    })
		    
		    // Methods
		    $(document.body).on('click', '[data-method]', function () {
		      var data = $(this).data(),
		          $target,
		          result;

		      if (data.method) {
		        data = $.extend({}, data); // Clone a new one

		        if (typeof data.target !== 'undefined') {
		          $target = $(data.target);

		          if (typeof data.option === 'undefined') {
		            try {
		              data.option = JSON.parse($target.val());
		            } catch (e) {
		              console.log(e.message);
		            }
		          }
		        }

		        result = $image.cropper(data.method, data.option);

		        if (data.method === 'getCroppedCanvas') {
		          $('#getCroppedCanvasModal').modal().find('.modal-body').html(result);
		        }

		        if ($.isPlainObject(result) && $target) {
		          try {
		            $target.val(JSON.stringify(result));
		          } catch (e) {
		            console.log(e.message);
		          }
		        }

		      }
		    }).on('keydown', function (e) {

		      switch (e.which) {
		        case 37:
		          e.preventDefault();
		          $image.cropper('move', -1, 0);
		          break;

		        case 38:
		          e.preventDefault();
		          $image.cropper('move', 0, -1);
		          break;

		        case 39:
		          e.preventDefault();
		          $image.cropper('move', 1, 0);
		          break;

		        case 40:
		          e.preventDefault();
		          $image.cropper('move', 0, 1);
		          break;
		      }

		    });


		    // Import image
		    var $inputImage = $('#inputImage'),
		        URL = window.URL || window.webkitURL,
		        blobURL;

		    if (URL) {
		      $inputImage.change(function () {
		        var files = this.files,
		            file;

		        if (files && files.length) {
		          file = files[0];

		          if (/^image\/\w+$/.test(file.type)) {
		            blobURL = URL.createObjectURL(file);
		            $image.one('built.cropper', function () {
		              URL.revokeObjectURL(blobURL); // Revoke when load complete
		            }).cropper('reset', true).cropper('replace', blobURL);
		            $inputImage.val('');
		          } else {
		            showMessage('Please choose an image file.');
		          }
		        }
		      });
		    } else {
		      $inputImage.parent().remove();
		    }


		    // Options
		    $('.docs-options :checkbox').on('change', function () {
		      var $this = $(this);

		      options[$this.val()] = $this.prop('checked');
		      $image.cropper('destroy').cropper(options);
		    });


		    // Tooltips
		    $('[data-toggle="tooltip"]').tooltip();

		  }());
		  
		});

	</script>	


</body>

</html>