<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<!-- head -->
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<link rel="stylesheet" href="/album/bootstrap/css/bootstrap.css">
<title>云相册</title>
<!-- 用户CSS样式 -->
<style type="text/css">
#mid {
	margin-left: 5%;
	margin-top: 6%;
	color: #F80762;
}

#title {
	color: #3400FF;
	font-size: 26px;
}
</style>
</head>
<!-- body -->
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/album/toIndex">于无声中</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/album/toIndex">Home</a></li>
					<li><a href="http://www.ayyll.com/">About</a></li>
					
					<li style="margin-left:850px"><a href="/album/index.jsp">退出</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div id="mid">

		<h3>欢迎&nbsp;&nbsp;${sessionScope.username }</h3>

	</div>
	<hr>
	<div id="main">
		<div id="title" align="center">上传图片</div>
		<div id="content" style="margin-left:43%;margin-top:40px;">

			<form id="myForm" class="form" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label style="font-size:15px">请选择相册分类:</label> <select id="type"
						name="type">
					</select>
				</div>
				<!--div class="form-group">
					<input type="text" id="xx" name="xx">
				</div -->
				<div class="form-group">
					<input type="file" id="inputfile" name="imgfile">
				</div>
				<button type="button" class="btn btn-sm btn-primary"
					onclick="save()">上传</button>
			</form>
		</div>
	</div>

	<!-- Bootstrap && AngularJs core JavaScript  -->
	<script src="/album/jquery/jquery-1.11.1.js"></script>
	<script src="/album/jquery/jquery.form.js"></script>
	<script src="/album/bootstrap/js/bootstrap.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready(function(){
			$.ajax({
				type : "GET",
				url : "/album/photoAlbumList",
				dataType : "json",
				async : true,
				success : function(data) {
					//console.log(data.list.length);
					$("#type").empty();
					for(var i = 0; i < data.list.length; i++) {
						//alert(data.list[i]);
						$("#type").append("<option value=" + data.list[i] + ">" + data.list[i] + "</option>");
					}
				},
				error : function(data) {
					alert("服务器异常");
				}
			});
		});
		function save() {
			
			var value = $("#inputfile").val();
			if($("#type").val() == null) {
				alert("请先选择分类");
				return false;
			}
            if ($.trim(value) == "") {
                alert("请先选择文件");
                return false;
            }
            if (!value.match(/.jpg|.jpeg|.gif|.png|.bmp/i)) {
                alert("文件格式错误");
                return false;
            }
			var option = {
                url : "/album/photo",
                type : "POST",
                async: true,
                dataType : "json",
                //headers : {"ClientCallMode" : "ajax"}, //添加请求头部
                success : function(data) {
                    //alert(data.msg);
                    alert("ok");
                    //$("#img1").attr('src',data.msg); 
                    //$("#img1").src=data.msg;
                    //alert("heh");
                },
                error: function(data) {
                    alert("上传失败,请刷新后重试");
                }
             };
			 //alert($("#type").val());
             $("#myForm").ajaxSubmit(option);
             //最好返回false，因为如果按钮类型是submit,则表单自己又会提交一次;返回false阻止表单再次提交
             //return false; 
		}
	</script>
</body>
</html>
