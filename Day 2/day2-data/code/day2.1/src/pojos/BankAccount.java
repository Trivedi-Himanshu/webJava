package pojos;

public class BankAccount {
	//id | name | type | bal
	private int acctId;
	private String customerName;
	private String acType;
	private double balance;
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int acctId, String customerName, String acType, double balance) {
		super();
		this.acctId = acctId;
		this.customerName = customerName;
		this.acType = acType;
		this.balance = balance;
	}
	public int getAcctId() {
		return acctId;
	}
	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAcType() {
		return acType;
	}
	public void setAcType(String acType) {
		this.acType = acType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [acctId=" + acctId + ", customerName=" + customerName + ", acType=" + acType + ", balance="
				+ balance + "]";
	}
	

}
