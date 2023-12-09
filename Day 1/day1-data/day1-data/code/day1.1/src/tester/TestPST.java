package tester;

import java.sql.*;
import java.util.Scanner;

import static utils.DBUtils.openConnection;

public class TestPST {

	public static void main(String[] args) {
		String sql = "select id,first_name,last_name,dob from users where role=?";
		try (Scanner sc = new Scanner(System.in);
				// cn
				Connection cn = openConnection();
				// pst
				PreparedStatement pst = cn.prepareStatement(sql);

		) {
			System.out.println("Enter role");
			// set IN param
			pst.setString(1, sc.next());
			// exec query
			try (ResultSet rst = pst.executeQuery()) {
				// rst cursor : Before the 1st row
				while (rst.next())
					System.out.println("ID " + rst.getInt(1) 
					+ " Name " + rst.getString(2) 
					+ " " + rst.getString(3)
							+ " DoB " + rst.getDate(4));
			} //rst.close()

		} //pst.close , cn.close , sc.close
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
