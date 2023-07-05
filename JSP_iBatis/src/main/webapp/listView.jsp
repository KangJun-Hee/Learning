<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 대입문, 제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 서식 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 함수 -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 보기</title>
</head>
<body>
	<!--  jstl에서 사용하는 한글깨짐 방지  -->
	<fmt:requestEncoding value="utf-8" />

	<c:set var="view" value="${guestbookList.list}"></c:set>
	<table width="1000" align="center" border="1" cellpadding="5"
		cellspacing="0">
		<tr>
			<th>방명록 보기</th>
		</tr>
		<tr>
			<td align="right">
				${guestbookList.totalCount}개(${guestbookList.currentPage} /
				${guestbookList.totalPage})</td>
		</tr>
		<tr>
			<td>
				<!-- 테이블에 저장된 글이 없으면 없다고 출력한다. --> <c:if test="${view.size() == 0}">
					<marquee>테이블에 저장된 글이 없습니다.</marquee>
				</c:if> <!-- 테이블에 저장된 글이 있으면 글 목록을 출력한다. --> <c:if
					test="${view.size() != 0}">
					<!-- useBean으로 컴퓨터 시스템의 날짜와 시간을 얻어온다. -->
					<jsp:useBean id="date" class="java.util.Date" />
					<%-- ${date} --%>

					<c:forEach var="vo" items="${view}">
						<table class="table" width="99%" align="center" border="1"
							cellpadding="5" cellspacing="0">
							<tr>
								<td>${vo.idx}. <!-- 이름에 태그가 먹지않도록 replace 함수를 적용한다. --> <c:set
										var="name" value="${fn:replace(vo.name, '<', '&lt;')}" /> <c:set
										var="name" value="${fn:replace(name, '>', '&gt;')}" /> <!-- 이름에 포함된 검색어를 강조해서 표시한다. -->
									<c:if test="${category == null || category == '내용'}">
										${name}
									</c:if> <c:if test="${category == '이름' || category == '내용+이름'}">
										<c:set var="search" value="<span>${item}</span>" />
										<!-- name에 저장된 모든 검색어를 search로 치환해서 출력한다. -->
										${fn:replace(name, item, search)}
									</c:if> (${vo.ip})님이 <!-- 날짜에 서식을 적용한다. --> <fmt:formatDate
										value="${vo.writeDate}" pattern="yyyy.MM.dd(E)" /> 에 남긴글 <!-- 수정 삭제 버튼 추가 -->
									<input class="button button1" type="button" value="수정"
									onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${guestbookList.currentPage}&job=update'" />
									<input class="button button1" type="button" value="삭제"
									onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${guestbookList.currentPage}&job=delete'" />

									<br /> <!-- 메모에 태그가 먹지않도록 replace 함수를 적용한다. --> <c:set
										var="memo" value="${fn:replace(vo.memo, '<', '&lt;')}" /> <c:set
										var="memo" value="${fn:replace(memo, '>', '&gt;')}" /> <c:set
										var="memo" value="${fn:replace(memo, enter, '<br/>')}" /> <!-- 내용에 포함된 검색어를 강조해서 표시한다. -->
									<c:if test="${category == null || category == '이름'}">
										${memo}
									</c:if> <c:if test="${category == '내용' || category == '내용+이름'}">
										<c:set var="search" value="<span>${item}</span>" />
										${fn:replace(memo, item, search)}
									</c:if>


								</td>
							</tr>
						</table>
					</c:forEach>

				</c:if>

			</td>
		</tr>

		<!-- 페이지 이동 버튼 -->
		<tr>
			<td align="center">
				<!-- 처음으로 --> <c:if test="${guestbookList.currentPage > 1}">
					<button class="button button1" type="button" title="첫 페이지로 이동합니다."
						onclick="location.href='?currentPage=1'">처음</button>
				</c:if> <c:if test="${guestbookList.currentPage <= 1}">
					<button class="button button2" type="button" disabled="disabled"
						title="이미 첫 페이지 입니다.">처음</button>
				</c:if> <!-- 10페이지 앞으로 --> <c:if test="${guestbookList.startPage > 1}">
					<button class="button button1" type="button"
						title="이전 10페이지로 이동합니다."
						onclick="location.href='?currentPage=${guestbookList.startPage - 1}'">이전</button>
				</c:if> <c:if test="${guestbookList.startPage <= 1}">
					<button class="button button2" type="button" disabled="disabled"
						title="이미 첫 10페이지 입니다.">이전</button>
				</c:if> <!-- 페이지 이동 버튼 --> <c:forEach var="i"
					begin="${guestbookList.startPage}" end="${guestbookList.endPage}"
					step="1">

					<c:if test="${guestbookList.currentPage == i}">
						<button class="button button2" type="button" disabled="disabled">${i}</button>
					</c:if>

					<c:if test="${guestbookList.currentPage != i}">
						<button class="button button1" type="button"
							onclick="location.href='?currentPage=${i}'">${i}</button>

					</c:if>

				</c:forEach> <!-- 10페이지 뒤로 --> <c:if
					test="${guestbookList.endPage < guestbookList.totalPage}">
					<button class="button button1" type="button"
						title="다음 10페이지로 이동합니다."
						onclick="location.href='?currentPage=${guestbookList.endPage + 1}'">다음</button>

				</c:if> <c:if test="${guestbookList.endPage >= guestbookList.totalPage}">
					<button class="button button2" type="button" disabled="disabled"
						title="이미 마지막 10페이지 입니다.">다음</button>
				</c:if> <!-- 마지막으로 --> <c:if
					test="${guestbookList.currentPage < guestbookList.totalPage}">
					<button class="button button1" type="button"
						title="마지막 페이지로 이동합니다."
						onclick="location.href='?currentPage=${guestbookList.totalPage}'">마지막</button>
				</c:if> <c:if
					test="${guestbookList.currentPage >= guestbookList.totalPage}">
					<button class="button button2" type="button" disabled="disabled"
						title="이미 마지막 페이지 입니다.">마지막</button>
				</c:if>

			</td>
		</tr>

		<!-- 카테고리별 검색어를 입력받는다. -->
		<tr>
			<td align="center">
				<form action="list.jsp" method="post">
					<select name="category" style="width: 100px; height: 30px;">
						<option>내용</option>
						<option>이름</option>
						<option>내용+이름</option>
					</select> <input type="text" name="item" value="${item}"
						style="width: 200px; height: 25px; padding-left: 10px;" /> <input
						type="submit" value="검색" style="width: 100px; height: 30px;" />
				</form>
			</td>
		</tr>

		<!-- 글쓰기 버튼 -->
		<tr>
			<td align="right"><input class="button button1" type="button"
				value="글쓰기" onclick="location.href='insert.jsp'" /></td>
		</tr>
	</table>







</body>
</html>




