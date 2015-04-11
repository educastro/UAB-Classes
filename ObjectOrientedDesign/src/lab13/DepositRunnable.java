package lab13;

/**
 * Runnable class for making deposit to bank account.
 * 
 * @author spoudel
 * 
 */
public class DepositRunnable implements Runnable {

	private BankAccount bankAccount;

	private double amount;

	/**
	 * Construct DepositRunnable with bank account and the amount to be
	 * deposited
	 * 
	 * @param bankAccount
	 *            bank account where deposit is made
	 * @param amount
	 *            amount to be deposited
	 */
	public DepositRunnable(BankAccount bankAccount, double amount) {
		this.bankAccount = bankAccount;
		this.amount = amount;
	}


	public void run() {
		//Execute repetitively with some pause to see some inconsistency.
		try {
			for (int i = 0; i < 10; i++) {
				this.bankAccount.deposit(this.amount);
				Thread.sleep(10);
			}
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}

}
