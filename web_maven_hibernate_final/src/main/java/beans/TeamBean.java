package beans;

import java.util.List;

import dao.TeamDaoImpl;

public class TeamBean {
	//dep : team dao
	private TeamDaoImpl teamDao;
	public TeamBean() {
		// create dao instance
		teamDao=new TeamDaoImpl();
		System.out.println("team bean n dao created !");
	}
	//B.L method to send all abbrs to the JSP 
	public List<String> getAbbreviations() {
		return teamDao.getAllAbbreviations();
	}

}
