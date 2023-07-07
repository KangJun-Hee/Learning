<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<form class="m-3" action="insertOK.jsp" method="post">
		<table class="table" style="width: 700px; margin-left: auto; margin-right: auto;">
			<tr class="table-primary">
				<th colspan="3" style="font-size: 30px; text-align: center;">게시판 글쓰기</th>
			</tr>
			<tr>
				<th class="align-middle table-dark" width="100">
					<label for="name">이름</label>
				</th>
				<td width="500">
					<input id="name" class="form-control form-control-sm" type="text" name="name" style="width: 200px;"/>
				</td>
				<th class="align-middle" width="100">
					공지글 <input class="form-check-input" type="checkbox" name="notice" value="yes"/>
				</th>
			</tr>
			<tr>
				<th class="align-middle table-dark">
					<label for="password">비밀번호</label>
				</th>
				<td colspan="2">
					<input id="password" class="form-control form-control-sm" type="password" name="password" 
					style="width: 200px;"/>
				</td>
			</tr>
			<tr>
				<th class="align-middle table-dark">
					<label for="subject">제목</label>
				</th>
				<td colspan="2">
					<input id="subject" class="form-control form-control-sm" type="text" name="subject"/>
				</td>
			</tr>
			<tr>
				<th class="align-middle table-dark">
					<label for="content">내용</label>
				</th>
				<td colspan="2">
					<textarea id="content" class="form-control form-control-sm" rows="10" name="content" 
					style="resize: none;"></textarea>
				</td>
			</tr>
			<tr class="table-secondary" >
				<td colspan="3" align="center">
					<input class="btn btn-outline-primary btn-sm" type="submit" value="저장하기"
					style="font-size: 13px;"/>
					<input class="btn btn-outline-danger btn-sm" type="reset" value="다시쓰기" 
					style="font-size: 13px;"/>
					<input class="btn btn-outline-warning btn-sm" type="button" value="돌아가기" 
					style="font-size: 13px;" onclick="history.back()"/>
				</td>
			</tr>
		</table>
		<!-- 접속자 ip 주소는 hidden으로 insertOK.jsp로 넘긴다. -->
		<%-- ${pageContext.request.remoteAddr} => EL을 사용해서 접속자 ip 주소를 받는다. --%>
		<input type="hidden" name="ip" value="${pageContext.request.remoteAddr}"/>
	</form>

</body>
</html>