<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<div align="center">
		<table border="1">
			<tr>
				<td>
					<c:if test="${type == 0}">
      					 <jsp:include page="01_01_managerLogin.jsp"/>
    				</c:if>
					    <c:if test="${type == 1}">
     				<%-- 	 <jsp:include page="03_02_login.jsp"/>  --%>
    				</c:if>
				</td>
			</tr>
			<tr>
				<td>				
		 			<c:if test="${not empty cont }" >
  				 	  <jsp:include page="${cont}"/>   
  				 	  </c:if> 
				</td>
			</tr>
		</table>	
	</div>
 
</body>
</html>
