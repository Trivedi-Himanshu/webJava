package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.CandidatePojo;

public interface CandidateDao {
	
	ArrayList<CandidatePojo> getCandidate() throws SQLException ;
	String incCandVote(int id) throws SQLException;
	List<CandidatePojo> showTopCand() throws SQLException;
		
}
