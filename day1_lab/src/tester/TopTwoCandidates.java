package tester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CandidateDaoImpl;
import pojos.CandidatePojo;

public class TopTwoCandidates {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("hi");
		CandidateDaoImpl demo = new CandidateDaoImpl();
		System.out.println("this");
		ArrayList<CandidatePojo> c = demo.showTopCand();
		System.out.println("is");
		c.forEach(x->System.out.println(x));
	}

	
	
}
