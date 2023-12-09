package tester;
import pojos.*;

import java.sql.SQLException;
import java.util.Scanner;

import dao.CandidateDaoImpl;

public class IncCandVote {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			CandidateDaoImpl c = new CandidateDaoImpl();
			
			System.out.print("Enter the voters ID: ");
			System.out.println(c.incCandVote(sc.nextInt()));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
