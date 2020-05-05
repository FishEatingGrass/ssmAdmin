<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../public/header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body class="gray-bg">
<div class="ibox-content">
	<form method="post" class="form-horizontal" action="">
		<div class="form-group">
               <label class="col-sm-2 control-label">角色</label>
				<div class="col-sm-10">
                   <select class="form-control m-b" name="roleId" required="required">
                   	   <c:forEach items = "${roles}" var="role">
						 	<option value="${role.id}" <c:if test="${role.id == user.roleId}">selected</c:if> >${role.name}</option>
						</c:forEach>
                   </select>
               </div>
           </div>
           <div class="hr-line-dashed"></div>
		<div class="form-group">
			<label class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-10">
			    <input type="text" class="form-control" readonly="readonly" value="${user.userName}">
			</div>
		</div>
		<div class="hr-line-dashed"></div>
		<div class="form-group">
			<label class="col-sm-2 control-label">密码</label>
			<div class="col-sm-10">
			    <input type="password" class="form-control" name="password" value="">
			</div>
		</div>
		<div class="hr-line-dashed"></div>
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
			    <input type="text" class="form-control" name="phone" required="required" value="${user.phone}">
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