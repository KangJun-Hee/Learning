package com.example2.openAPI2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;



public class ApiExamSearchNaverAPI {

	public static void main(String[] args) {

		String clientId = "lXF9D0J81ibDjCsxzkKE"; // 애플리케이션 클라이언트 아이디
		String clientSecret = "rodfxhs30y"; // 애플리케이션 클라이언트 시크릿

		// 쇼핑 JSON 결과
		String apiURL = "https://openapi.naver.com/v1/search/shop.json";
		String query = "캠핑의자"; // 검색어

		String display = "12"; // 보여질 페이지 개수 ,최대 100개
		String start = "1"; // 페이지 시작 위치

		try {
			query = URLEncoder.encode(query, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		// url 조합
		StringBuilder url = new StringBuilder();

	    url.append(apiURL);
        url.append("?query="+query);
        url.append("&display="+display);
        url.append("&start="+start);
        

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(url.toString(), requestHeaders);
		System.out.println(responseBody);
		
		// 실제 파싱하는 클래스를 이용해서 데이터를 가져오기!
		// 가져와서 리스트에 저장하기 
		
		try {
			List<Product> list = NaverApiParser.parseShop(responseBody);
			
			for(Product item : list) {
				System.out.println(item.toString());
			}
			
			
		}catch(ParseException e) {
			e.printStackTrace();
		}		

	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);
		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();
			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}
			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}

}
