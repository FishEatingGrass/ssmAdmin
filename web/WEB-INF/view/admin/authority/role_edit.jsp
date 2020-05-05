<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../public/header.jsp"></jsp:include>

<body class="gray-bg">
<div class="ibox-content">
	<form method="post" class="form-horizontal" action="">
		<div class="form-group">
			<label class="col-sm-2 control-label">角色名称</label>
			<div class="col-sm-10">
			    <input type="text" class="form-control" name="name" required="required" value="${role.name}">
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