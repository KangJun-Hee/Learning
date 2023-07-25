<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<%request.setCharacterEncoding("utf-8");%>
<%
String result = "----------------------<br>";//결과문자열
String realFolder = "";//웹 어플리케이션상의 절대 경로 저장

String saveFolder = ""; //파일 업로드 폴더 지정
String encType = "utf-8"; //인코딩타입
int maxSize = 5*1024*1024;  //최대 업로될 파일크기 5Mb

//현재 jsp페이지의 웹 어플리케이션상의 절대 경로를 구함
ServletContext context = getServletContext();
realFolder = context.getRealPath(saveFolder);  

try{
	MultipartRequest upload = null;
	   
	//파일 업로드를 수행하는 MultipartRequest 객체 생성 
	upload = new MultipartRequest(request,realFolder,maxSize,
			            encType,new DefaultFileRenamePolicy());
	   
	//<input type="file">이 아닌 모든 파라미터를 얻어냄
	Enumeration<?> params = upload.getParameterNames();
	  
	//파일 아닌 파라미터들의 값을 반복해서 얻어냄
	while(params.hasMoreElements()){
		String name = (String)params.nextElement(); //파라미터명
	    String value = upload.getParameter(name); //파라미터값  
	    result += name + " : " + value +"<br>";//결과문자열 누적
	}

	//<input type="file">인 모든 파라미터를 얻어냄
	Enumeration<?> files = upload.getFileNames();
	   
	//업로드된 모든 파일의 정보를 반복해서 얻어냄
	while(files.hasMoreElements()){
	    String name = (String)files.nextElement();//파라미터이름
	    //서버에 업로드된 파일명
	    String filename = upload.getFilesystemName(name);
	    //원래 파일명
	    String original = upload.getOriginalFileName(name);
	    //업로드된 파일의 타입 - 파일 종류
	    String type = upload.getContentType(name);
	    
	    //결과문자열 누적
	    result += "파라메터 이름 : " + name +"<br>";
	    result += "실제 파일 이름 : " + original +"<br>";
	    result += "저장된 파일 이름 : " + filename +"<br>";
	    result += "파일 타입 : " + type +"<br>";
	    
	    //업로드된 파일의 정보를 얻어내기 위해 File객체로 생성
	    File file = upload.getFile(name);
		if(file != null)
			result += "크기 : " + file.length() + " bytes <br>";//파일크기		
    }
	result += "----------------------<br>";
	out.println(result);//처리결과를 반환
}catch(Exception e){
	e.printStackTrace();
}
%>