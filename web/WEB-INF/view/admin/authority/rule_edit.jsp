<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../public/header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body class="gray-bg">
<div class="ibox-content">
	<form method="post" class="form-horizontal" action="">
		<div class="form-group">
               <label class="col-sm-2 control-label">分组</label>

               <div class="col-sm-10">
                   <select class="form-control m-b" name="groupId" required="required">
                   	    <c:forEach items = "${groups}" var="group">
						 	<option value="${group.id}" <c:if test="${group.id == rule.groupId}">selected </c:if>  >${group.name}</option>
						</c:forEach>
                  </select>
               </div>
           </div>
           <div class="hr-line-dashed"></div>
		<div class="form-group">
			<label class="col-sm-2 control-label">规则</label>
			<div class="col-sm-10">
			    <input type="text" class="form-control" name="url" required="required" value="${rule.url}">
			</div>
		</div>
		<div class="hr-line-dashed"></div>
		<div class="form-group">
			<label class="col-sm-2 control-label">名称</label>
			<div class="col-sm-10">
			    <input type="text" class="form-control" name="name" required="required" value="${rule.name}">
			</div>
		</div>
		<div class="hr-line-dashed"></div>
		<div class="form-group">
			<label class="col-sm-2 control-label">备注</label>
			<div class="col-sm-10">
			    <input type="text" class="form-control" name="remark" required="required" value="${rule.remark}">
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