package lab12;

import java.util.ArrayList;

;

/**
 * A class for modeling Employees who are Managers. Each Employee has a buddy.
 */
public class Manager extends Employee {
	/**
	 * Constructs a Manager object.
	 * 
	 * @param aName
	 *            the employee's name
	 */
	public Manager(String aName) {
		super(aName);
		bonus = 0;
	}

	/**
	 * @see Employee#toStringHelper(java.util.ArrayList)
	 */
	protected String toStringHelper(ArrayList<Employee> visited) {
		return super.toStringHelper(visited) + "[bonus=" + bonus + "]";
	}

	/**
	 * @see Employee#equals(Employee)
	 */
	public boolean equals(Employee otherObject) {
		return super.equals(otherObject);
	}

	/**
	 * @see Employee#equalsHelper(Employee, java.util.ArrayList)
	 */
	protected boolean equalsHelper(Employee otherEmployee,
			ArrayList<Employee.Pair> visited) {
		if (otherEmployee == this) {
			return true;
		}
		if (otherEmployee == null) {
			return false;
		}
		if (getClass() != otherEmployee.getClass()) {
			return false;
		}
		Manager otherManager = (Manager) otherEmployee;
		if (bonus != otherManager.bonus) {
			return false;
		}
		return super.equalsHelper(otherManager, visited);
	}

	/**
	 * @see Employee#hashCodeHelper(int, java.util.ArrayList)
	 */
	protected int hashCodeHelper(int code, ArrayList<Employee> visited) {
		return 17 * super.hashCodeHelper(code, visited) + 19
				* new Double(bonus).hashCode();
	}

	/**
	 * Sets the bonus.
	 * 
	 * @param the
	 *            new bonus
	 */
	public void setBonus(double aBonus) {
		bonus = aBonus;
	}

	/**
	 * Returns the manager's salary.
	 * 
	 * @return the salary
	 */
	public double getSalary() {
		return super.getSalary() + bonus;
	}

	/**
	 * Stores bonus of the manager.
	 */
	private double bonus;
}