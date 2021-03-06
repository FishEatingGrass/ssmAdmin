<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="<%=request.getContextPath() %>/static/admin/favicon.ico"> <link href="<%=request.getContextPath() %>/static/admin/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/admin/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/admin/css/animate.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/admin/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">R</h1>

            </div>
            <h3>欢迎使用</h3>

            <form class="m-t" action="<%=request.getContextPath()%>/admin/login/login" method="post" target="_self">
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="密码" required="">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="验证码" name="code" required="" style="width: 200px;float: left;">
                    <img src="<%=request.getContextPath()%>/admin/login/verifica" onclick="this.src='<%=request.getContextPath()%>/admin/login/verifica?'+Math.random();"/>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>

            </form>
        </div>
    </div>
    <script src="<%=request.getContextPath() %>/static/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/bootstrap.min.js?v=3.3.5"></script>
    
</body>

</html>