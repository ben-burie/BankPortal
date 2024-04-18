package Project.Backend;
import java.util.Random;

public class Account {

	Random rand = new Random();
	
	protected String accType;
	protected int accNum;
	protected double accBalance;
	
	public Account(String accType, int accNum, double accBalance) {
		this.accType = accType;
		this.accNum = accNum;
		this.accBalance = accBalance;
	}
	
	public Account () {
		accType = null;
		accNum = rand.nextInt(11111111, 99999999);
		accBalance = 0.00;
	}
	
	public String getAccType() {
		return accType;
	}
	
	public int getAccNum() {
		return accNum;
	}
	
	public double checkBalance() {
		return this.accBalance;
	}
	
	public void withdraw(double amount) {
		this.accBalance -= amount;
	}
	
	public void deposit(double amount) {
		this.accBalance += amount;
	}
	
}
