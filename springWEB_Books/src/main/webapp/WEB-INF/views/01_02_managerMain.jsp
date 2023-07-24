
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cp"  value="${pageContext.request.contextPath}"  /> 
<script src="${cp}/resources/jq/jquery-1.11.0.min.js"></script> 
<script src="${cp}/resources/js/01_02_managermain.js"></script>

<style> 
	td , h3{
		text-align: center;
		margin-top: 20;
	}
		
</style>

<div align="center">
<c:if test="${empty sessionScope.id}">
  <h3 >로그인 하세요. </h3>
</c:if>
<c:if test="${!empty sessionScope.id}">
	<table border="1">
		<tr>
			<td>
				<h3>상품관련 작업</h3>
			</td>
		</tr>
		<tr>
			<td><button id="registProduct">상품등록</button>
			</td>
		</tr>
		<tr>
			<td><button id="updateProduct">상품수정/삭제</button>
			</td>
		</tr>
		
		<tr>
			<td>
				<h3>구매된 상품관련 작업</h3>
			
			</td>
		</tr>
		<tr>
			<td><button id="orderedProduct">전체구매목록 확인</button>
			</td>						
		</tr>
		
		<tr>
			<td>
				<h3>상품 QnA 작업</h3>
			
			</td>
		</tr>
		<tr>
			<td>
			<button id="qna" >상품 QnA답변</button>
			</td>
		</tr>	
	</table>

  
</c:if>   
</div> 