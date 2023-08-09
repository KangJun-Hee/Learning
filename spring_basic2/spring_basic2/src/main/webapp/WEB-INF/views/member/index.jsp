<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="title" name="demoTest"/>
</jsp:include>


<c:if test="${not empty msg}">
<script>
	alert('${msg}');
</script>
</c:if>


<section id="container">
	<h2 style="text-align: center;">회원가입</h2>
	<div id="demo-container">
		<form id="devFrm" name="devFrm" method="post">
			<div class="form-group row">
				<label for="devName" class="col-sm-2 col-form-label align-self-center text-center">아이디</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" name="id" value="test">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="devName" class="col-sm-2 col-form-label align-self-center text-center">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" value="홍길동">
				</div>
			</div>
			
			
			<div class="form-group row">
				<label for="devAge" class="col-sm-2 col-form-label align-self-center text-center">나이</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="age" name="age"  value="21">
				</div>
			</div>
			
			<div class="form-group row">
				<label class="col-sm-2 col-form-label align-self-center text-center">성별</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender" checked="checked"
							id="gender" value="M"> <label 
							class="form-check-label" for="devGender0">남</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="gender"
							id="gender" value="F"> <label
							class="form-check-label" for="devGender1">여</label>
					</div>
				</div>
			</div>
			
				<div class="form-group row">
				<label class="col-sm-2 col-form-label">좋아하는 언어</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
					<input class="form-check-input" checked="checked" type="checkbox" name="devLang" id="devLang0" value="Java">
					<label class="form-check-label" for="devLang0">Java</label>
					</div>
					<div class="form-check form-check-inline">
					<input class="form-check-input"  type="checkbox" name="devLang" id="devLang1" value="C">
					<label class="form-check-label" for="devLang1">C</label>
					</div>
					<div class="form-check form-check-inline">
					<input class="form-check-input" checked="checked" type="checkbox" name="devLang" id="devLang2" value="Javascript">
					<label class="form-check-label"  for="devLang2">JavaScript</label>
					</div>
				</div>
			</div>
		</form>
		
		<div class="list-group">
			<button type="button" onclick="demo('memberServlet.do');"
				class="list-group-item list-group-item-action">
				Servlet HttpRequest로 파라메터 처리
			</button>
		</div>
		<div class="list-group">
			<button type="button" onclick="demo('memberParams.do');"
					class="list-group-item list-group-item-action">
				@RequestParam 어노테이션 활용 파라메터 처리
				</button>
		</div>
		<div class="list-group">
			<button type="button" onclick="demo('memberCommand.do');"
				class="list-group-item list-group-item-action">
				Command(객체,VO)를 통한 파라메터 처리</button>
		</div>
		<div class="list-group">
			<button type="button" onclick="demo('memberMap.do');"
				class="list-group-item list-group-item-action">
				컬랙션 Map을 통한 파라메터 처리
				</button>
		</div>
		<div class="list-group">
			<button type="button" onclick="demo('memberAddInfo.do');"
				class="list-group-item list-group-item-action">
				추가데이터 가져오기(header,cookie)
			</button>
		</div>
		<div class="list-group">
			<button type="button" onclick="demo('joinMember.do');"
				class="list-group-item list-group-item-action"> 
				회원 가입하기 (데이터 저장)
			</button>
		</div>
	</div>
</section>

<script>
	function demo(url) {
		$("#devFrm").attr("action", "${path}/member/" + url);
		$("#devFrm").submit();
	}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>