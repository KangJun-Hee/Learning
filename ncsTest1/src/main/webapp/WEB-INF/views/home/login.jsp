<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath }" />


<section id="container">
	<h1>login</h1>
	<div>
		<form id="devFrm" name="devFrm" method="post">
			<div>
				<div>
					<input type="text" class="form-control" id="id" name="id"
						value="id">
				</div>
			</div>

			<div>
				<div>
					<input type="text" class="form-control" id="name" name="name"
						value="pw">
				</div>
			</div>

			<div class="list-group">
				<button type="button" onclick="demo('joinMember.do');"
					class="list-group-item list-group-item-action">login</button>
			</div>
	</div>
</section>

<script>
	function demo(url) {
		$("#devFrm").attr("action", "${path}/member/" + url);
		$("#devFrm").submit();
	}
</script>
