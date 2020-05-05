<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include   page="../public/header.jsp" />
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">

    <div id="wrapper">
        <!--左侧导航开始-->
        <jsp:include   page="../public/left_nav.jsp" />
        
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <jsp:include   page="../public/right_nav.jsp" />
        <!--右侧边栏结束-->
        <!--mini聊天窗口开始-->
        <%-- <jsp:include   page="../public/chat.jsp" /> --%>
    </div>
    <script src="<%=request.getContextPath() %>/static/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/bootstrap.min.js?v=3.3.5"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/plugins/layer/layer.min.js"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/hplus.min.js?v=4.0.0"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/admin/js/contabs.min.js"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/plugins/pace/pace.min.js"></script>
</body>

</html>