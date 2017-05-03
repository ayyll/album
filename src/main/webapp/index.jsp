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
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/cover.css" rel="stylesheet">
<title>云相册</title>
<!-- 用户CSS样式 -->
<style type="text/css">
</style>

</head>
<!-- body -->
<body>

	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">图片上传</h3>
						<nav>
							<ul class="nav masthead-nav">
								<li class="active"><a href="javascript：void(0);" onclick="login(); return false;">Login</a></li>
							</ul>
						</nav>
					</div>
				</div>

				<div class="inner cover">
					<h1 class="cover-heading">Free Cloud Album</h1>
					<p class="lead">Then the wandering soul wild crane stands still the memory river Listen to whistle play tightly ring slowly,Water rises a ship to go medium long things of the past.</p>
					<p class="lead">
						<a href="/album/register" class="btn btn-lg btn-default">没有账号？点我注册</a>
					</p>
				</div>

				<div class="mastfoot">
					<div class="inner">
						<p>
							Power by <a href="http://getbootstrap.com">Bootstrap</a>, author
							<a href="https://www.ayyll.com">@ayyll</a>.
						</p>
					</div>
				</div>

			</div>

		</div>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h3 class="modal-title" id="myModalLabel" style="color:black !important">登陆</h3>
					</div>
					<div class="modal-body" id="alertInfo">
						<form class="form-horizontal" id="myForm" role="form" method="post">
							<div class="form-group">
								<label for="username" class="col-sm-4 control-label">昵称</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="username" name="username"
										placeholder="请输入用户名">
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-4 control-label" style="color:black;font-size:800;">密码</label>
								<div class="col-sm-5">
									<input type="password" class="form-control" id="password" name="password"
										placeholder="请输入密码">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-6">
									<button type="button" class="btn btn-info" onclick="save()">登录</button>
									
								</div><lable id="info"></lable>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
	</div>
	<!-- Bootstrap && AngularJs core JavaScript  -->
	<script src="jquery/jquery-1.11.1.js"></script>
	<script src="jquery/jquery.form.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		function login() {
			$('#myModal').modal().css({
				//width : "500px",
				// 居中
				//align:'center'
			});
		}
		function save() {
			
			$.ajax({
				type : "POST",
				url : "/album/login",
				data : $("#myForm").serialize(),
				dataType : "json",
				success : function(data) {
					//登陆成功
					if(data.msg == "ok") {
						$("#info").html("");
						window.location.href = "/album/user/" + data.user_id;
					} else {
						$("#info").html("<strong>用户名或密码错误</strong>").css("color","red");
					}
					
				},
				error : function(data) {
					alert("服务器异常");
				}
			
			});
		}
	</script>
</body>
</html>