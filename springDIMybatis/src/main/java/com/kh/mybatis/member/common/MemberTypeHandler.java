package com.kh.mybatis.member.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/*mybatis에서 컬럼의 옵션형태로 값이 들어가기 때문에
 * 이러한 type을 지원키 위해 Hepler
 * 취미->축구,야구
 * 
 * DB에 insert할 경우 String[]->String 전환
 * DB에서 java로 추출할 땐 String->String[] 전환하는 역할 필요하다~
 * 
 * TypeHandler interface~ 
 * */
public class MemberTypeHandler implements TypeHandler<String[]>{

	//java -> DB
	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
		//문자열 join
		//parameter가 null일 수 있음
		if(parameter != null) {
			ps.setString(i, String.join(",", parameter));
		} else {
			ps.setString(i, "");
		}
	}

	//DB -> java
	@Override
	public String[] getResult(ResultSet rs, String columnName) throws SQLException {
		
		return rs.getString(columnName).split(",");
	}

	
	@Override
	public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {

		return rs.getString(columnIndex).split(",");
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
		
		return null;
	}
	
}