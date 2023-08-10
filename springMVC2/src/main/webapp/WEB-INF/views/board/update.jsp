<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 수정" name="title"/>
</jsp:include>

<style>
	div#board-write-container{width:600px;margin:0 auto;text-align:center;}
	div#board-write-container h2{margin:10px 0;}
	table#tbl-board{width:500px; margin:0 auto; border:1px solid black;border-collapse:collapse;}
	table#tbl-board th{width:125px;border:1px solid;padding:5px 0;text-align:center;}
	table#tbl-board td{	border:1px solid; padding:5px 0 5px 10px; text-align:left;}
</style>


<section id="content">
	<h2 align="center">게시글 수정</h2>
	<div id='board-write-container'>
		<form action="${path}/board/update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="no" value="${board.no}" />
			<input type="hidden" name="originalFileName" value="${board.originalFileName}" />
			<input type="hidden" name="renamedFileName" value="${board.renamedFileName}" />

			<table id="tbl-board">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${board.title}"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writerId" value="${board.writerId}" readonly></td>
				</tr>
				<tr>
					<th>첨부파일1</th>
					<td>
						<input type="file" name="reloadFile">
						<c:if test="${!empty board.originalFileName}"><br>
							현재 업로드 파일 :
							<a>
								${board.originalFileName}
							</a>
						</c:if>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" cols="50" rows="15">${board.content}</textarea></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="수정">
						<input type="button" onclick="location.replace('${path}/board/list')" value="목록으로">
					</th>
				</tr>
			</table>
		</form>
	</div>
</section>
	
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>






