package tester;

import java.sql.*;
import java.util.ArrayList;

import pojos.*;
import dao.*;

class GetAllCandidates{
	
	public static void main(String[] args) throws SQLException {
		
		CandidateDaoImpl c = new CandidateDaoImpl();
		
		ArrayList<CandidatePojo> candidates = c.getCandidate();
		
		candidates.forEach(d -> System.out.println(d));
	}
}