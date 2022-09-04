
public class DeadLockSolveAccount {
	
	private int balance=1000;
	
	public void deposit(int amount) {
		balance+=amount;
	}
	
	public void withdraw(int amount) {
		balance-=amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public static void transfer(DeadLockSolveAccount acc1,DeadLockSolveAccount acc2,int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
}
