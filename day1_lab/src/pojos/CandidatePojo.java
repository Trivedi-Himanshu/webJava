package pojos;

public class CandidatePojo {
//	 id | name    | party    | votes
	private int id;
	private String name;
	private String party;
	private int votes;
	
	public CandidatePojo() {
		//not required but required in hebernet
	}
	
	public CandidatePojo(int id, String name, String party, int votes) {
		this.id = id;
		this.name = name;
		this.party = party;
		this.votes = votes;
	}
	
//	overloaded constructor 
	public CandidatePojo(String name, String party) {
		this.name = name;
		this.party = party;
	}

//	getters and setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	
//	toString
	@Override
	public String toString() {
		return "candidatePojo [id=" + id + ", name=" + name + ", party=" + party + ", votes=" + votes + "]";
	}
}
