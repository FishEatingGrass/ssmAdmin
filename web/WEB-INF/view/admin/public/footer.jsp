<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<script src="<%=request.getContextPath() %>/static/admin/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/bootstrap.min.js?v=3.3.5"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/content.min.js?v=1.0.0"></script>
	<script src="<%=request.getContextPath() %>/static/admin/plugins/imgCut/dist/cropper.js"></script>
	<script src="<%=request.getContextPath() %>/static/admin/plugins/layer/layer.js"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/plugins/dataTables/jquery.dataTables.js" charset="utf-8"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/plugins/jeditable/jquery.jeditable.js"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/plugins/dataTables/dataTables.bootstrap.js" charset="utf-8"></script>
    <script src="<%=request.getContextPath() %>/static/admin/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>