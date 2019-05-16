<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, 
  maximum-scale=1.0, minimum-scale=1.0">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/img/favicon_yhf.ico">
<title>청년 재단</title>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main2.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/head2.jsp"%>

	<div id="writeWrap">
		<div style="padding-top: 40px; padding-bottom: 22px; font-size: 22px; font-weight: bold; text-align: center;">게시글 작성</div>
		<form id="frm" method="post" enctype="multipart/form-data" >
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
						<td class="td2"><input type="date" id="date" name="date"></input></td>
					</tr>
				</tbody>
			</table>
			<input type="file" name="file"> <br/> <br/>
			<div style="float: right">
				<button type="submit" id="write">작성하기</button>
				<button type="button" id="back">목록으로</button>
			</div>
		</form>
	</div>

</body>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#write').click(function() {
		alert('df')
		var params = jQuery("#frm").serialize(); // serialize() : 입력된 모든Element(을)를 문자열의 데이터에 serialize 한다.
	    alert(params)
		jQuery.ajax({
	        url: '<%=request.getContextPath()%>/hire/notify2/write2',
	        type: 'POST',
	        data:params,
	        contentType: false, 
	        dataType: 'html',
	        success: function (result) {
	            if (result){
	            	location.href = '<%=request.getContextPath()%>/hire/notify2';
	            }
	        }
	    });
		
	});
	
	
	$('#back').click(function() {
		
		 $.mobile.changePage( "<%=request.getContextPath()%>/hire/notify2", { transition: "slide", changeHash: false })

<%-- 		location.href = '<%=request.getContextPath()%>/hire/notify2'; --%>
		
	});
	
});
	
</script>

</html>
