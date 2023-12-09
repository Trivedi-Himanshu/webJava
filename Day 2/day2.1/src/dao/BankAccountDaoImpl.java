package dao;

import java.sql.*;
import static utils.DBUtils.*;

public class BankAccountDaoImpl implements BankAccountDao {
	private Connection connection;
	private CallableStatement cst1;

	// def ctor
	public BankAccountDaoImpl() throws SQLException {
		// open cn
		connection = openConnection();
		cst1 = connection.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		//register OUT params
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("acct dao created..");
	}

	@Override
	public String transferFunds(int srcAcNo, int destAcNo, double amount) throws SQLException {
		// set IN params
		cst1.setInt(1, srcAcNo);
		cst1.setInt(2, destAcNo);
		cst1.setDouble(3, amount);
		//exec proc
		cst1.execute();
		return "Updated src bal "+cst1.getDouble(4)+" dest bal "+cst1.getDouble(5);
	}
	public void cleanUp() throws SQLException{
		if(cst1 != null)
			cst1.close();
		closeConnection();
			
	}

}
