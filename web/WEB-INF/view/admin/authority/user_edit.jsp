<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../public/header.jsp"></jsp:include>

<body class="gray-bg">
<div class="ibox-content">
	<form method="post" class="form-horizontal" action="">
		<div class="form-group">
			<label class="col-sm-2 control-label">真实姓名</label>
			<div class="col-sm-10">
			    <input type="text" class="form-control" name="trueName" required="required" value="${user.trueName}">
			</div>
		</div>
		<div class="hr-line-dashed"></div>
		<div class="form-group">
			<label class="col-sm-2 control-label">手机号</label>
			<div class="col-sm-10">
			    <input type="text" class="form-control" name="phone" required="required" value="${user.phone }">
			</div>
		</div>
		<div class="hr-line-dashed"></div>
		<div class="form-group">
			<label class="col-sm-2 control-label">密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="password1">
				<span class="help-block m-b-none">不修改留空</span>
			</div>
		</div>
		<div class="hr-line-dashed"></div>
		<div class="form-group">
			<label class="col-sm-2 control-label">确认密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="password2">
				<span class="help-block m-b-none">不修改留空</span>
			</div>
		</div>
		<div class="hr-line-dashed"></div>
		<div class="form-group">
            <div class="col-sm-4 col-sm-offset-2">
                <button class="btn btn-primary" type="submit">保存内容</button>
            </div>
        </div>
	</form>
</div>
    <jsp:include page="../public/footer.jsp"></jsp:include>
</body>

</html>