<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="db.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	color: black;
	text-decoration: none;
}

a:hover {
	color: red;
	text-decoration: none;
}

span {
	color: white;
	background-color: red;
}
</style>

</head>
<body>
	<!-- 입력 화면 시작 -->
	<form action="memoInsert.jsp" method="post">
		<table width="1000" align="center" border="1" cellpadding="5"
			cellspacing="0">
			<tr>
				<th colspan="3">아주 아주 많이 출첵 게시판 Ver 0.01</th>
			</tr>
			<tr>
				<th width="100">이름</th>
				<th width="100">비밀번호</th>
				<th width="800">메모</th>
			</tr>
			<tr>
				<td align="center"><input type="text" name="name"
					style="width: 90%; height: 25px;" /></td>
				<td align="center"><input type="password" name="password"
					style="width: 90%; height: 25px;" /></td>
				<td align="center"><input type="text" name="memo"
					style="width: 92%; height: 25px;" /> <input type="submit"
					value="저장" /></td>
			</tr>
		</table>
	</form>
	<%
	//1.페이징 작업에 필요한 변수를 선언한다.
	int pageSize = 10;//1페이지에 10개의 글 표시
	int totalCount = 0;//테이블에 저장된 전체글의 개수
	int totalPage = 0;//전체페이지
	int currentPage = 1;//현재웹페이지에 표시되는 페이지번호
	int startNo = 0;//현재 브라우저에 표시되는 글의 시작 인덱스번호->mysql은 0부터
	int endNo = 0;//현재 브라우저에 표시되는 글의 마지막 인덱스번호
	int startPage = 0;//페이지이동 하이퍼링크 또는 버튼에 표시될 시작 페이지 번호
	int endPage = 0;//페이지이동 하이퍼링크 또는 버튼에 표시될 마지막 페이지 번호

	//2.연결
	Connection conn = DBUtil.getMysqlConnection();

	//totalCount변수에 테이블에 저장된 전체글의 개수를 얻어와 저장한다
	String sql = "select count(*) from memolist1";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();

	//테이블에 저장된 글이 있으면 글의 개수를 얻어와 ResultSet에 저장
	//데이터 있으면 글 개수 가지고 온다, 없으면 0을 resultset객체에 저장한다.
	//현재 사용하는 테이블 4명 기본적용. 데이터 있냐 물어볼 필요 없음. 걍 꺼내면 된다
	rs.next();
	totalCount = rs.getInt(1);
	//out.println("테이블 저장된 전체글의 개수 : "+totalCount+<br/>");

	//totalPage변수에 전체페이지 개수를 계산해 저장한다.
	totalPage = (totalCount - 1) / pageSize + 1;
	//out.println("전체 페이지 쪽수 : "+totalPage+<br/>");

	//3.이전 페이지에서 넘어 온 브라우저에 표시할 페이지 번호를 받는다.
	//	이전 페이지에서 currentPage가 안 넘어오면 넘오는 값 없으니까 null이다.
	//	null이 오면 정수 저장하는 변수는 예외가 발생하니 예외처리해야 함 NumberFormatException
	//	정상적으로 넘어올 땐 문자로 넘어오는 값을 정수형태로 변환해 currentPage변수에 저장하고
	//	아니면, 초기값으로 지정한 1이 유지되게 한다

	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//현재 화면에 표시할 페이지번호는 전체페이지 쪽수보다 클 수 없으니 
		//화면에 표시할 페이지번호가 전체보다 큰 게 왔다면
		//화면에 표시할 페이지번호를 전체페이지 쪽수로 수정한다.
		currentPage = currentPage > totalPage ? totalPage : currentPage;
	} catch (NumberFormatException e) {
	}
	//out.println("현재 화면에 표시되는 페이지 번호 : "+currentPage+"페이지"<br/>");

	//4. startNo 변수에 현재화면에 표시할 글 목록의 인덱스번호를 계산한다~
	//	 mysql은 select했을 때 맨첨 나오는 글의 번호가 0, 오라클은 1부터 시작
	startNo = (currentPage - 1) * pageSize; //오라클은 안해도 된다

	//mysql limit, oracle은 없어서 마지막번호 계산해야 함
	endNo = startNo + pageSize - 1;

	endNo = endNo > totalCount ? totalCount : endNo;

	//mysql에서 limit사용해 뽑아오기
	sql = "select * from memolist1 order by idx desc limit ? , ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, startNo);
	pstmt.setInt(2, pageSize);
	rs = pstmt.executeQuery();
	%>

	<table width="1000" align="center" border="1" cellpadding="5"
		cellspacing="0">
		<tr>
			<th width="80">글번호</th>
			<th width="80">이름</th>
			<th width="800">메모</th>
			<th width="80">ip</th>
		</tr>
		<%
		if (rs.next()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");

			do {
		%>
			<tr>
				<td align="center"><%=rs.getInt("idx")%></td>
				<td align="center"><%=rs.getString("name")%></td>
				<td><%=rs.getString("memo")%></td>
				<td><%=rs.getString("ip")%></td>
			</tr>
		<%
			} while (rs.next());
		} else {
		%>
		<tr colspan="5">
			<!-- marquee : 움직이게 함 -->
			<marquee>테이블에 저장된 글이 없습니다</marquee>
		</tr>
		<%
		}
		%>
		<!-- 첫 페이지부터 마지막 페이지까지 이동할 수 있는 하이퍼링크 또는 버튼을 만든다. -->
		<%
			for(int i=1; i<=totalPage; i++){
				//혹시 1페이지면 버튼을 활성화 안함
				if(currentPage == i){
		%>
		<button type="button" disabled="disabled"><%=i%></button>
		<%
				}else{
		%>
	</table>
</body>
</html>