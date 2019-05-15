<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/img/favicon_yhf.ico">
<title>청년 재단</title>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/head.jsp"%>

	<div id="writeWrap">
		<div style="padding-top: 40px; padding-bottom: 22px; font-size: 22px; font-weight: bold; text-align: center;">게시글 작성</div>
		<form method="post" id="frm" enctype="multipart/form-data" >
			<table class="board_view">
				<tbody>
					<tr>
						<th class="td1">회사명</th>
						<td class="td2"><input type="text" id="title" name="title"></input></td>
					</tr>
					<tr>
						<th class="td1">내용</th>
						<td class="td2"><input type="text" id="content"
							name="content"></input></td>
					</tr>
					<tr>
						<th class="td1">1차면접</th>
						<td class="td2"><input type="text" id="date" name="date"></input></td>
					</tr>
				</tbody>
			</table>
			<input type="file" name="file"> <br /> <br />
			<div style="float: right">
				<button type="button" id="write">작성하기</button>
				<button type="button" id="back">목록으로</button>
			</div>

		</form>


		<!-- 		wrap의 끝 -->
	</div>

</body>

<script type="text/javascript">

$(document).ready(function(){
	
	
	$('#write').click(function() {
		
		$('#frm').submit();
		
	});
	
	
	$('#back').click(function() {
		
		location.href = '<%=request.getContextPath()%>/hire/notify';
		
	});
	
});
	
</script>

</html>
