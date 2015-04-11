package lab13;

/**
 * Runnable class for withdrawing from a bank account
 * 
 * @author spoudel
 * 
 */
public class WithdrawRunnable implements Runnable {

	private BankAccount bankAccount;

	private double amount;

	/**
	 * Construct WithdrawRunnable with bank account and the amount to be
	 * withdrawn
	 * 
	 * @param bankAccount
	 *            bank account where withdraw is made
	 * @param amount
	 *            amount to be withdrawn
	 */
	public WithdrawRunnable(BankAccount bankAccount, double amount) {
		this.bankAccount = bankAccount;
		this.amount = amount;
	}

	public void run() {
		try {
			//Execute repetitively with some pause to see some inconsistency.
			for (int i = 0; i < 10; i++) {
				this.bankAccount.withdraw(this.amount);
				Thread.sleep(10);
			}
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}

}
