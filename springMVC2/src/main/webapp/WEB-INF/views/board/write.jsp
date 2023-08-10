<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 작성" name="title"/>
</jsp:include>

<style>
	div#board-write-container{width:600px;margin:0 auto;text-align:center;}
	div#board-write-container h2{margin:10px 0;}
	table#tbl-board{width:500px; margin:0 auto; border:1px solid black;border-collapse:collapse;}
	table#tbl-board th{width:125px;border:1px solid;padding:5px 0;text-align:center;}
	table#tbl-board td{	border:1px solid; padding:5px 0 5px 10px; text-align:left;}
</style>


<section id="content">
	<h2 align="center">게시글 작성</h2>
	<div id='board-write-container'>
		<form action="${path}/board/write" method="post" enctype="multipart/form-data">
			<table id="tbl-board">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writerId" value="${loginMember.id}" readonly></td>
				</tr>
				<tr>
					<th>첨부파일1</th>
					<td><input type="file" name="upfile"></td>
				</tr>
<!-- 				<tr> -->
<!-- 					<th>첨부파일2</th> -->
<!-- 					<td><input type="file" name="upfile2"></td> -->
<!-- 				</tr> -->
				<tr>
					<th>내용</th>
					<td><textarea name="content" cols="50" rows="15"></textarea></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소">
					</th>
				</tr>
			</table>
		</form>
	</div>
</section>
	
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>






