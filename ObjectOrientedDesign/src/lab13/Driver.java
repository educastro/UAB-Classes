package lab13;

public class Driver {

	public static void main(String[] args) throws InterruptedException {
		BankAccount bankAccount = new BankAccount();
		//BankAccount bankAccount = new SynchronizedBankAccount();
		// making initial deposit of $100.
		bankAccount.deposit(100.0);
		System.out.println("Executing threads.....");
		DepositRunnable depositRunnable = new DepositRunnable(bankAccount, 10);
		WithdrawRunnable withdrawRunnable = new WithdrawRunnable(bankAccount, 20);

		Thread depositThread1 = new Thread(depositRunnable);
		Thread withdrawThread1 = new Thread(withdrawRunnable);

		depositThread1.start();
		withdrawThread1.start();
	}
}
