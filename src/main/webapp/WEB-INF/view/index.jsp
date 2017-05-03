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

#main {
	margin-left: 50px;
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
				<a class="navbar-brand" href="javascript:void(0)">于无声中</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="javascript:void(0)">Home</a></li>
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
		<span><button type="button" class="btn btn-sm btn-info"
				onclick="window.location.href='/album/upload';">上传照片</button> </span> <span
			style="margin-left:20px"><a href="javascript:void(0);"
			onclick="createAlbum()">创建相册 </a> </span> <span style="margin-left:20px"><a
			href="javascript:void(0);" onclick="alert('敬请期待~');return false;">导出相册 </a> </span>
	</div>
	<div id="picture"></div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title" id="myModalLabel"
						style="color:black !important">创建相册</h3>
				</div>
				<div class="modal-body" id="alertInfo">
					<form class="form-horizontal" id="myForm" role="form" method="post">
						<div class="form-group">
							<label for="name" class="col-sm-4 control-label">相册名称</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="name" name="name"
									placeholder="请输入相册名称">
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="col-sm-4 control-label"
								style="color:black;font-size:800;">相册描述</label>
							<div class="col-sm-5">
								<textarea rows="4" cols="20" class="form-control"
									id="description" name="description" placeholder="请描述一下相册吧~"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-2"
								style="margin-left:200px !important">
								<button type="button" class="btn btn-info" onclick="saveAlbum()">确定</button>

							</div>
							<lable id="info"></lable>
						</div>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- Bootstrap && AngularJs core JavaScript  -->
<script src="/album/jquery/jquery-1.11.1.js"></script>
<script src="/album/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "/album/plist",
        async: true,
        dataType: "json",
        success: function(data) {
            $("#picture").empty();
            for (var i = 0; i < data.photo.length; i++) {
                //alert(data.photo[i].type);
                $("#picture").append("<div align='center'><div><img height='300' width='300' src='" + 
                "/album/" + data.photo[i].url + "' onclick='gotoUrl(this)'></img></div><div><lable>相册分类:" + 
                data.photo[i].type + "</lable></div><div><lable>上传时间:" + 
                transTime(new Date(data.photo[i].create_time)) + "</lable></div></div>");
                $("#picture").css({
                    "color": "#800080",
                    "font-size": "20px",
                    "font-weight": "700"
                });
            }
        },
        error: function() {
            
        }
    });
});
function createAlbum() {
    $('#myModal').modal();
}

function saveAlbum() {

    $.ajax({
        type: "POST",
        url: "/album/user/photo_album",
        data: $("#myForm").serialize(),
        dataType: "json",
        //async : false,
        success: function(data) {
            alert("创建成功");
            $("#name").val("");
            $("#description").val("");
        },
        error: function(data) {
            alert("服务器异常");
        }
    });
}
function transTime(myTime) {
    var text = myTime.getFullYear() + "-" + (myTime.getMonth() + 1) + "-" + myTime.getDate() + " " + myTime.getHours() + ":" + myTime.getMinutes() + ":" + myTime.getSeconds();
    return text;
}
function gotoUrl(obj) {
    window.location.href = obj.src;
}		
</script>
</body>
</html>
