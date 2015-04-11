package lab13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread-Unsafe BankAccount implementation.
 * 
 * @author spoudel
 * 
 */
public class BankAccount {

	private double balance;
	private Lock bankLock = new ReentrantLock();
	private Condition sufficientFunds = bankLock.newCondition();


	/**
	 * Construct BankAccount with balance 0
	 */
	public BankAccount() {
		balance = 0;
	}

	/**
	 * Get the balance.
	 * 
	 * @return the current balance of the account
	 */
	public double getBalance() {
		bankLock.lock();
		try{
			return this.balance;
		} finally {
			bankLock.unlock();
		}
	}

	/**
	 * Deposit the amount to this account
	 * 
	 * @param amount
	 *            - amount to be deposited
	 * @throws InterruptedException 
	 */
	public void deposit(double amount) {
		bankLock.lock();
		try{
			double temp = this.balance + amount;
			System.out.println("Depositing amount: " + amount + ", Previous Balance " + this.balance + ", New Balance : " + temp);
			this.balance = temp;
			sufficientFunds.signalAll();
		} finally {
			bankLock.unlock();
		}
	}

	/**
	 * Withdraw the amount to this account
	 * 
	 * @param amount
	 *            - amount to be withdrawn
	 * @throws InterruptedException 
	 */
	public void withdraw(double amount) throws InterruptedException {
		bankLock.lock();
		try{
			while (balance < amount) {
				sufficientFunds.await();
			}
		//System.out.println("Withdrawing amount: " + amount);
		double temp = this.balance - amount;
		System.out.println("Withdrawing amount: " + amount + ", Previous Balance " + this.balance + ", New Balance : " + temp);
		this.balance = temp;
		} finally {
			bankLock.unlock();
		}
	}

}
