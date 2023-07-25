<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<script src="jquery-1.11.0.min.js"></script>
<script src="jquery.form.min.js"></script> 
<script src="singleupload.js"></script>

<form id="upForm1" action="singleUploadPro.jsp" 
          method="post" enctype="multipart/form-data">
<div id="form">
<ul>
  <li>
    <label for="title">제목</label>
    <input type="text" id="title" name="title" size="20" 
           maxlength="50" placeholder="제목입력" autofocus>
  <li>
    <label for="file1">파일선택</label>
    <input type="file" id="file1" name="file1">
  <li>    
    <input type="submit" id="upPro1" value="단일 파일 업로드">
</ul>
</div>
</form>
<div id="upResult"></div>