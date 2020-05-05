<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../public/header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body class="gray-bg">
<div class="ibox-content">
	<form method="post" class="form-horizontal" action="">
		<div class="ibox-title" style="margin: 0 auto;width: 120px;">
            <h5>${role.name}</h5>
       </div>
       <div class="hr-line-dashed"></div>
		<c:forEach items="${groups}" var="v">
			<div class="form-group">
                <label class="col-sm-2 control-label">${v.name}</label>

                <div class="col-sm-10">
                <c:forEach items="${v.rules}" var="vo">
                    <label class="checkbox-inline i-checks">
                        <input type="checkbox" name="ruleId" value="${vo.id}" id="inlineCheckbox1">${vo.name}</label>
                 </c:forEach>
                </div>
            </div>
            <div class="hr-line-dashed"></div>
		</c:forEach>
		
		<div class="form-group">
            <div class="col-sm-4 col-sm-offset-2">
                <button class="btn btn-primary" type="submit">保存内容</button>
            </div>
        </div>
	</form>
</div>
    <jsp:include page="../public/footer.jsp"></jsp:include>
    <script type="text/javascript">
    var roles = '${role.rules}';
    var roleArr = roles.split(",");
    $.each(roleArr,function(i,e){
    	$("input[name=ruleId]").each(function(){
    		var id = $(this).val();
    		if(e==id){
    			$(this).attr("checked",true);
    		}
    	})
    })
    </script>
</body>

</html>