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
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/head.jsp"%>
	<div class="snbVisual">
		<div class="bgLeft"></div>
		<div class="bgRight"></div>
		<div class="textArea">
			<div class="visualText">
				<h1>일자리 매칭</h1>
				<p>
					좋은 일자리에 대한 채용 정보와 채용 기회를 제공하고, <br> 청년과 함께하는 스타트업을 지원합니다.
				</p>
			</div>
		</div>
	</div>
	<div id="bottomWrap">
		<div class="menu">
			<div class="iconHome" href="#"></div>
			<a>HOME</a>><a>청년 열린채용</a>><a>청년 열린채용공고</a>
		</div>
		<div class="bottomTitle">
			<h1>청년 열린채용 공고</h1>
			<div class="ib"
				style="text-align: right; float: right; clear: both; line-height: 43px;">
				<span class="icon"
					style="background-position: -113px -231px; width: 35px; height: 8px; vertical-align: middle;"></span>
				<span class="icon"
					style="background-position: -459px -467px; width: 27px; height: 26px; vertical-align: middle;"></span>
				<span class="icon"
					style="background-position: -535px 0px; width: 27px; height: 26px; vertical-align: middle;"></span>
				<span class="icon"
					style="background-position: -496px -467px; width: 27px; height: 26px; vertical-align: middle;"></span>
				<span class="icon"
					style="background-position: -535px -36px; width: 27px; height: 26px; vertical-align: middle;"></span>
				<span class="icon"
					style="background-position: -422px -467px; width: 27px; height: 26px; vertical-align: middle;"></span>
			</div>
		</div>
		<div class="imgBottom">
			<h1
				style="color: #09098f; text-shadow: 2px 1px 2px #fff; font-size: 40px; margin: 40px 5px 5px; text-align: center;">
				<b>청년 열린채용은</b>
			</h1>
			<b>채용을 원하는 기업과 취업을 희망하는 청년구직자를</b> <br> <b>매칭해주는 취업지원
				프로그램입니다.</b> <br>
			<p>
				☞ 직무중심의 역량 있는 인재를 위하여 지원하고자 하는 직무의 필수 자격요건에<br> 해당하는 모든 청년지원자에게
				1차 전원 면접 기회를 제공합니다. <br> <br> ☞ 1차 대면 면접에 참여한
				청년구직자(만34세이하) 모두에게 면접비를 지원합니다.
			</p>
		</div>

		<div class="listSearchBox">
			<label for="queryStr2">SEARCH</label> <select class="select">
				<option>제목</option>
				<option>내용</option>
			</select> <input id="queryStr2" type="text" title="제목 또는 내용 검색어를 입력하세요."
				placeholder="검색어를 입력하세요."> <span class="icon"
				style="background-position: -392px -250px; width: 31px; height: 31px;"></span>
		</div>

		<div class="listSearchBox">
			<label>채용별 검색</label> <input id="cd1" type="radio" name="s_text"
				checked="checked"><label class="cd" for="cd1">전체</label> <input
				id="cd2" type="radio" name="s_text"><label class="cd"
				for="cd2">청년열린채용</label> <input id="cd3" type="radio" name="s_text"><label
				class="cd" for="cd3">온리원</label> <input id="cd4" type="radio"
				name="s_text"><label class="cd" for="cd4">청년루키</label> <span
				class="icon"
				style="background-position: -392px -250px; width: 31px; height: 31px;"></span>
		</div>

		<div id="boardMenu">
			<p>
				총 게시물 <span id="totalCount"></span>건
			</p>
			<p>
				페이지 <span id="pageNum"></span>/<span id="totalPage"></span>건
			</p>
			<a id="pg3" class="row" name="3"> 
				<img src="<%=request.getContextPath()%>/img/icon_3page.png" alt="이미지없음">
			</a> 
			<a id="pg4" class="row" name="4"> 
				<img src="<%=request.getContextPath()%>/img/icon_4page.png" alt="이미지없음">
			</a> 
			<a id="pg5" class="row" name="5"> 
				<img src="<%=request.getContextPath()%>/img/icon_5page.png" alt="이미지없음">
			</a>
			<button type="button" id="bdwrite" style="margin-left : 93px;">글쓰기</button>
			<button type="button" id="dbdelete">삭제</button>
		</div>
		
		<input type="hidden" id="rowNum" name="3">
		
<!-- 		게시판 여기에 로드 -->
		<div id="board">
			
		</div>

		<!-- 		wrap의 끝 -->
	</div>

</body>

<script type="text/javascript">

$(document).ready(function(){
	
	$('#board').load(
		'<%=request.getContextPath()%>/hire/notify/loadList?pageNumber=1&rowNum=3'
	);
	
	$('#bdwrite').click(function() {
		
		location.href = '<%=request.getContextPath()%>/hire/notify/write';
		
	});
	
	
	
});
</script>

</html>
