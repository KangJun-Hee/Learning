package Cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Beve_Order {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			String quary = "INSERT INTO TEST VALUES(?,?,?)";

			con = DBcon.getConnection();
			pstm = con.prepareStatement(quary);

			pstm.setString(1, "name");
			pstm.setString(2, "price");
			pstm.setString(3, "btype");

			int success = pstm.executeUpdate();

			if (success > 0)
				System.out.println("데이터 입력 성공~~~");
			else
				System.out.println("looose~ 데이터 입력 실패~");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		Scanner
	}

}
