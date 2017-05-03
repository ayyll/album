<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" ng-app>
<head>
<meta charset="utf-8">
<title>用户注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="/album/css/main.css" type="text/css">
<link rel="stylesheet" href="/album/bootstrap/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/album/bootstrap/css/bootstrap-responsive.min.css" type="text/css"> 

<style type="text/css">
   body {
        padding-top: 40px;
        padding-bottom: 40px;
		background:#83AF9B !important;
    }
	
	#in{
		opacity: 0.7 !important;/*透明度*/
	}
</style>
</head>
<body>
<div class="container" id="in">
    <form name="myForm" class="form-signin" ng-submit="save()" ng-controller="loginController">
        <h1 class="form-signin-heading">注册</h1>
        <input type="text" class="input-block-level" placeholder="用户名" ng-model="userName" required name="userName">
        <input type="password" class="input-block-level" placeholder="密码" ng-model="passWord" required name="passWord" ng-pattern="/^\S{6,20}$/" ng-change="checkPassword()">
        <p class="error-block" ng-show="myForm.passWord.$error.pattern" style="">请输入6-20位英文字母、数字或符号</p>
        <input type="password" class="input-block-level" placeholder="重复密码" ng-model="repassWord" required name="repassWord" ng-pattern="/^\S{6,20}$/" ng-change="checkPassword()">
        <p class="error-block" ng-show="myForm.repassWord.$error.pattern" style="">请输入6-20位英文字母、数字或符号</p>    
        <p class="error-block" ng-show="myForm.repassWord.$error.dontMatch" style="">两次密码输入不一致</p>
       
        <button class="btn btn-large btn-primary" type="submit" ng-disabled="!!myForm.$error.pattern || !!myForm.$error.required || hasNotAgreed()">提交</button>
    </form>
</div>
</body>
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script src="/album/jquery/jquery-1.11.1.js"></script>
<script src="/album/bootstrap/js/bootstrap.min.js"></script>
<script src="/album/angular/angular.min.js"></script>
<script>
angular.element(document).ready(function() {
    angular.module("loginController",[]);
});
function loginController ($scope) {
    
    // 前后密码校验
    $scope.checkPassword = function() {
        $scope.myForm.repassWord.$error.dontMatch = ($scope.passWord !== $scope.repassWord);
    };
    $scope.save = function() {
       
        var user = {"username":$scope.userName,"password":$scope.passWord};
        $.ajax({
        	type:"POST",
        	url:"/album/register.do",
        	async:true,
        	dataType: "json",
        	data:user,
        	 error:function(data){  
                 alert("服务器繁忙");
             },  
             success:function(data){  
            	 if(data.msg == "ok") {
            		 alert("注册成功"); 
                     window.location.href = "/album/index.jsp"; 
            	 }
            	 else {
            		 alert("用户名已存在!");
            	 }
             }  		
        });
    };
}
</script>
</html>