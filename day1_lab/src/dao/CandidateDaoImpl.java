package dao;
import pojos.CandidatePojo;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.DBUtils.*;

public class CandidateDaoImpl implements CandidateDao{
	
	private Connection cn;
	private PreparedStatement pst,pst1,pst2;
	
	public CandidateDaoImpl() throws SQLException {
		
		cn = openConnection();
		pst = cn.prepareStatement("select * from candidates");
		pst1 = cn.prepareStatement("UPDATE candidates SET votes = votes + 1 WHERE id = ?");
//		Display details of top 2 candidates , having max votes
		pst2 = cn.prepareStatement("SELECT party, votes\r\n"
				+ "FROM candidates\r\n"
				+ "ORDER BY votes DESC\r\n"
				+ "LIMIT 2;");

	}
	@Override
	public ArrayList<CandidatePojo> getCandidate() throws SQLException {
		
		ArrayList<CandidatePojo> candidateList = new ArrayList<>();
		
		try(ResultSet rst = pst.executeQuery()){
			while(rst.next()) {
				candidateList.add(new CandidatePojo(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		}
		return candidateList;
	}
	
	

	// Increment candidate's votes
	@Override
	public String incCandVote(int id) throws SQLException {
		
		pst1.setInt(1, id);
		
		int rst = pst1.executeUpdate();
		if(rst == 1) 
			return "Voted to candidate with id: "+id;
		
		return "Status updation failed!!!!!";	
			
	}
	
	
	// display top 2 candidates
	public ArrayList<CandidatePojo> showTopCand() throws SQLException {
		System.out.println("my");
		ArrayList<CandidatePojo> candidate = new ArrayList<>();
		System.out.println("my2");
		ResultSet rst = pst2.executeQuery();
		System.out.println(rst.getString(2));
		while(rst != null) {
			System.out.println("my3");
			candidate.add(new CandidatePojo(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		
		System.out.println("this is line 70");
		return candidate;
	}
	
	//clean up method
	public void cleanUp() throws SQLException{
		if(pst != null) {
			pst.close();
			closeConnection();
		}
	}
	
}
