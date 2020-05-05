<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../public/header.jsp"></jsp:include>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    
                    <div class="ibox-content">
						<a href='<%=request.getContextPath()%>/admin/rule/add' class='btn btn-primary mb-10'><i class='fa fa-plus'></i> 添加规则</a>
                        <table class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                                <tr>
                                    <th width="20%">id</th>
                                    <th width="20%">分组</th>
                                    <th width="20%">规则</th>
                                    <th width="20%">名称</th>
                                    <th width="20%">操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                            </tbody>
                            
                        </table>

                    </div>
                </div>
            </div>
        </div>
  
    </div>
    <jsp:include page="../public/footer.jsp"></jsp:include>
    <script>
    
        $(document).ready(function(){
        	$('.dataTables-example').dataTable({
        		 "bPaginate": true,
        		 "processing": true,
   		    	 "serverSide": true,
   		    	 "ajax": "<%=request.getContextPath()%>/admin/rule/page",
        		 "pagingType": "full_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
        		 "columns": [
        	            { "data": "id" },
        	            { "data": "group.name" },
        	            { "data": "url" },
        	            { "data": "name" },
        	            { "data": null },
        	      ],
        	      "order":[[0,"desc"]],
        	      "columnDefs":[{
						   "targets" : 4,//操作按钮目标列
						   "orderable":false,
						   "render" : function(data, type,row) {
							var id = '"' + row.id + '"';
							var html = "<a href='<%=request.getContextPath()%>/admin/rule/edit?id="+row.id+"' class='btn btn-info btn-xs mr-5'><i class='fa fa-edit'></i> 编辑</a>";
		        	    	html += "<a href='javascript:void(0);' onclick='deleteThisRowPapser("+ id + ")'  class='down btn btn-danger btn-xs'><i class='fa fa-times'></i> 删除</a>";
	        	    		return html;
        	    	   }
        	    }],
        	});
        })
        
        function deleteThisRowPapser(id){
        	layer.confirm('确定要删除这一条吗？', {
	    		  btn: ['确定','取消'] //按钮
	    	}, function(){
	    		window.location.href = "<%=request.getContextPath()%>/admin/rule/del?id="+id;
	    	})
        }
    </script>
   

</body>

</html>