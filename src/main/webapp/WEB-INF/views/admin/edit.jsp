<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="bookAPI" value="/api/book" />
<c:url var="bookURL" value="/quan-tri/sach/danh-sach" />
<c:url var="editBookURL" value="/quan-tri/sach/chinh-sua" />
<html>
<head>
<title>Sách</title>
</head>
<body>
	<div class="main-content" style="width: 100%">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="/quan-tri/trang-chu">Trang chủ</a></li>
					<c:if test="${empty model.id}">
						<li class="active">> Thêm Sách</li>
					</c:if>
					<c:if test="${not empty model.id}">
						<li class="active">> Chỉnh sửa Sách</li>
					</c:if>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row" style="margin-left: 15px; width: 100%">
					<div class="col-xs-12" style="width: 100%">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<form:form class="form-horizontal" role="form" id="formSubmit"
							enctype="multipart/form-data" modelAttribute="model">
							<table style="width: 100%">
								<tr>
									<td><form:label path="name">Tên sách</form:label></td>
									<td><form:input path="name" value="${model.name}"
											style="width: 70%" /></td>
								</tr>

								<tr>
									<td><form:label path="avatar">Hình đại diện</form:label></td>
									<td><form:input path="avatar" type="file" id="avatar"
											value="${model.avatar}" /></td>
								</tr>


								<tr>
									<td><form:label path="categoryId">Thể loại</form:label></td>
									<td><form:select path="categoryId">
											<form:option value="-1" label=" ---Chọn thể loại--- " />

											<c:forEach var="item" items="${categories}">
												<form:option value="${item.id}" label="${item.name}" />
											</c:forEach>
										</form:select></td>
								</tr>

								<tr>
									<td><form:label path="cover">Ảnh bìa</form:label></td>
									<td><form:input path="cover" type="file" id='cover'
											value="${model.cover}" /></td>
								</tr>

								<tr>
									<td><form:label path="publishYear">Năm xuất bản</form:label></td>
									<td><form:input path="publishYear"
											value="${model.publishYear}" style="width: 70%" /></td>
								</tr>

								<tr>
									<td><form:label path="author">Tác giả</form:label></td>
									<td><form:input path="author" value="${model.author}"
											style="width: 70%" /></td>
								</tr>

								<tr>
									<td><form:label path="content">Nội dung</form:label></td>
									<td><form:textarea path="content" id='CKcontent'
											style="width: 70%" /></td>
								</tr>


							</table>

							<br>
							<br>
							<form:hidden path="id" id="bookId" />
							<!-- button -->
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9" style="text-align: center">
									<c:if test="${not empty model.id}">
										<button class="btn btn-info" type="submit"
											id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật
											Sách
										</button>
									</c:if>
									<c:if test="${empty model.id}">
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm Sách
										</button>
									</c:if>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset" style="margin-left: 40px">
										<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
									</button>
									<br> <br>

								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		var editor = '';
		$(document).ready(function() {
			editor = CKEDITOR.replace('CKcontent');
		});

		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			data["content"] = editor.getData();
			var id = $('#bookId').val();
			
			addData("avatar",data);
			var cover = {};
			var coverFile = $("#cover")[0].files[0];
			if (coverFile != undefined) {
				var reader = new FileReader();
				reader.onload = function(e) {
					cover["base64"] = e.target.result;
					cover["name"] = coverFile.name;
					data["cover"] = cover;
					if (id == "") {
						addNew(data);
					} else {
						updateNew(data);
					}
				};
				reader.readAsDataURL(coverFile);
			}		
			
		});

		function addData(name, data) {
			var picture = {};
			var file = $("#avatar")[0].files[0];
			if (file != undefined) {
				var reader = new FileReader();
				reader.onload = function(e) {
					var base64 = e.target.result;
					picture["base64"] = base64;
					picture["name"] = file.name;
					data["" + name] = picture;
				};
				reader.readAsDataURL(file);
			}
		} 

		function addNew(data) {
			$.ajax({
				url : '${bookAPI}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${bookURL}?message=add_success";
				},
				error : function(error) {
					window.location.href = "${bookURL}?message=system_error";
				}
			});
		}

		function updateNew(data) {
			$.ajax({
				url : '${bookAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${bookURL}?message=update_success";
				},
				error : function(error) {
					window.location.href = "${bookURL}?message=system_error";
				}
			});
		}
	</script>
</body>
</html>
