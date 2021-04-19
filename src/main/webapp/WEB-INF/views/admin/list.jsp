<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
    <c:url var = "bookAPI" value = "/api/book"/>
    <c:url var = "bookURL" value = "/quan-tri/sach/danh-sach"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách</title>
</head>
<body>

	<div class="container-fluid">
	
	<!-- message -->
	<c:if test="${not empty message }">
		<div class="alert alert-${message.alert }">
  			<strong>${message.message }</strong>
		</div>
	</c:if>
		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Quản lý</a></li>
			<li class="breadcrumb-item active">Tất cả sách</li>
			
		</ol>


		<!-- DataTables Example -->
		<div class="card mb-3">
			<form action="<c:url value='/quan-tri/sach/danh-sach'/>"
				id="formSubmit" method="get">
				<div class="card-header">
					<i class="fas fa-table"></i> Danh sách sách
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>ID</th>
									<th>Tên sách</th>
									<th>Thể loại</th>
									<th>Ngày sửa</th>
									<th>Thao tác | <a class="  fas fa-plus-circle" data-toggle="tooltip" title="Thêm sách mới" style = "margin: 0"
					href='<c:url value = "/quan-tri/sach/chinh-sua?id="/>'></a> | </th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>ID</th>
									<th>Tên sách</th>
									<th>Thể loại</th>
									<th>Ngày sửa</th>
									<th>Thao tác</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="item" items="${model.listResult}">
									<tr>
										<td>${item.id}</td>
										<td>${item.name}</td>
										<td>${item.categoryId}</td>
										<td>${item.modifiedDate}</td>
										<td><a class="btn btn-sm btn-primary btn-edit fas fa-edit"
												data-toggle="tooltip" title="Cập nhật bài viết"
												href='<c:url value = "/quan-tri/sach/chinh-sua?id=${item.id}"/>'></a> 
											<button class="btn btn-sm btn-primary btn-delete fas fa-trash-alt" type="button"
												id="btnDel" data-toggle="tooltip" title="xóa vài viết"  onclick ="warningBeforeDelete(${item.id})">
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</form>
		</div>
	</div>


	<!-- /.container-fluid -->


	<!-- /.content-wrapper -->
	<script>
	function warningBeforeDelete(id){
		swal({
			  title: "Xác nhận xóa",
			  text: "Bạn có chắc chắn muốn xóa hay không",
			  type: "warning",
			  showCancelButton: true,
			  confirmButtonClass: "btn-danger",
			  confirmButtonText: "Xác nhận",
			  cancelButtonText: "Hủy bỏ",
			}).then(function(isConfirm) {
			  if (isConfirm.value) {
					/* var ids = $('tbody input[type=checkbox]:checked').map(function () {
			            return $(this).val();
			        }).get(); */
					deleteNew(id);
			  }else{
				  window.location.href = "${newURL}";
			  }
			});
	}
	
		function deleteNew(id) {
			$.ajax({
	            url: '${bookAPI}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(id),
	            success: function (result) {
	            	window.location.href = "${bookURL}?message=delete_success";
	            },
	            error: function (error) {
	            	window.location.href = "${bookURL}?message=system_error";
	            }
	        });
		}
	</script>
</body>
</html>