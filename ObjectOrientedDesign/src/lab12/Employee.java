package lab12;

import java.io.*;
import java.util.ArrayList;

/**
 * A class for modeling Employees that have buddy field.
 */
public class Employee implements Cloneable, Serializable {
	/**
	 * Constructs an Employee object.
	 * 
	 * @param aName
	 *            the employee's name
	 */
	public Employee(String aName) {
		name = aName;
	}

	/**
	 * Returns a deep copy of the Employee.
	 * 
	 * @return a copy of this Employee
	 */
	public Object clone() {

		//create an employee variable with a null value
		Employee employee = null;
		
		//create a File object given a file name
		try {
			File fileObject = File.createTempFile("fileObject", "clone");
			
		//create a FileOutputStream object from the File object
			FileOutputStream fileOutputStream = new FileOutputStream(fileObject);
			
		//create a ObjectOutputStream object from the FileOutputStream
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
		//write this object to the ObjectOutputStream
			objectOutputStream.writeObject(this);

		//create a FileInputStream from the file object
			FileInputStream fileInputStream = new FileInputStream(fileObject);
			
		//create a ObjectInputStream object from the FileInputStream
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
		//read the object from the ObjectInputStream object into your employee variable
			employee = (Employee) objectInputStream.readObject();

		//close the ObjectOutputStream object
			objectOutputStream.close();
			
		//close the ObjectInputStream object
			objectInputStream.close();

		//use the file object to delete the file
			fileObject.delete();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//return the employee variable
		return employee;
	}

	/**
	 * Returns a String representing the Employee.
	 * 
	 * @return the Employee as a String
	 */
	public String toString() {
		return toStringHelper(new ArrayList<Employee>());
	}

	/**
	 * Recursive helper that uses a list of already visited Employees to know
	 * when to end the recursion. Must be overridden.
	 * 
	 * @param visited
	 *            the Employee visited so far
	 * @return the Employee as a String
	 */
	protected String toStringHelper(ArrayList<Employee> visited) {
		String buddyString = "";
		if (visited.contains(this)) {
			buddyString = "...";
		} else {
			visited.add(this);
			if (buddy != null) {
				buddyString = buddy.toStringHelper(visited);
			}
		}

		return getClass().getName() + "[name=" + name + ",salary=" + salary
				+ ",buddy=" + buddyString + "]";
	}

	/**
	 * Returns whether this Employee is identical to another.
	 * 
	 * @return whether this Employee is identical to another
	 * @param otherObject
	 *            the other Employee
	 */
	public boolean equals(Employee otherObject) {
		return equalsHelper(otherObject, new ArrayList<Pair>());
	}

	/**
	 * Checks if two Employees have equal fields and recursively checks if the
	 * buddies are equal and not yet compared.
	 * 
	 * @param otherObject
	 *            - the object to compare to
	 * @param visited
	 *            - the buddies visited so far
	 * @return returns if this employee equals the other object
	 */
	protected boolean equalsHelper(Employee otherObject, ArrayList<Pair> visited) {
		if (this == otherObject) {
			return true;
		}
		if (null == otherObject) {
			return false;
		}
		if (getClass() != otherObject.getClass()) {
			return false;
		}
		Employee otherEmployee = otherObject;
		if (!name.equals(otherEmployee.name) || salary != otherEmployee.salary) {
			return false;
		}
		if (this.buddy == null || otherEmployee.buddy == null) {
			return this.buddy == otherEmployee.buddy;
		}
		if (visited.contains(new Pair(this, otherEmployee))) {
			return true;
		}
		visited.add(new Pair(this, otherEmployee));

		return this.buddy.equalsHelper(otherEmployee.buddy, visited);
	}

	/**
	 * Returns the hash code of this Employee.
	 * 
	 * @return the hash code of this Employee
	 */
	public int hashCode() {
		return hashCodeHelper(0, new ArrayList<Employee>());
	}

	/**
	 * Recursive helper function for finding hash code.
	 * 
	 * @param code
	 *            - hash code of the Employees visited so far
	 * @param visited
	 *            - Employees visited so far.
	 * @return finding hash code for visited employees include this
	 */

	protected int hashCodeHelper(int code, ArrayList<Employee> visited) {
		if (visited.contains(this)) {
			return code;
		}
		code = 31 * code
				+ (11 * name.hashCode() + 15 * new Double(salary).hashCode());

		visited.add(this);
		return hashCodeHelper(code, visited);
	}

	/**
	 * Sets the buddy.
	 * 
	 * @param the
	 *            new buddy
	 */
	public void setBuddy(Employee aBuddy) {
		buddy = aBuddy;
	}

	/**
	 * Returns the employee's buddy.
	 * 
	 * @return the buddy
	 */
	public Employee getBuddy() throws CloneNotSupportedException {
		return (Employee) buddy.clone();
	}

	/**
	 * Sets the salary.
	 * 
	 * @param the
	 *            new salary
	 */
	public void setSalary(double aSalary) {
		salary = aSalary;
	}

	/**
	 * Returns the employee's name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the employee's salary.
	 * 
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * A class that allows us to maintain a list of pairs of Employees that have
	 * already been compared for equality.
	 */
	protected class Pair {

		/**
		 * Make pairs of two employees.
		 * 
		 * @param emp1
		 *            first employee
		 * @param emp2
		 *            second employee
		 */
		Pair(Employee emp1, Employee emp2) {
			this.e1 = emp1;
			this.e2 = emp2;
		}

		/**
		 * Checks if this pair equals the other.
		 * 
		 * @param other
		 *            the other Pair object to check against
		 * @return true if this equal other
		 * 
		 * @precondition this.class == other.class
		 */
		public boolean equals(Object other) {
			if (other == null) {
				return false;
			}
			assert this.getClass() == other.getClass();

			Pair p = (Pair) other;
			return this.e1 == p.e1 && this.e2 == p.e2;
		}

		/**
		 * Returns the hash code of this pair.
		 * 
		 * @return the hash code of this pair.
		 */
		public int hashCode() {
			return this.e1.hashCode() ^ this.e2.hashCode();
		}

		/**
		 * First employee element of the pair.
		 */
		private Employee e1;

		/**
		 * Second employee element of the pair.
		 */
		private Employee e2;
	}

	/**
	 * Name of this Employee.
	 */
	private String name;

	/**
	 * Salary of this Employee.
	 */
	private double salary;

	/**
	 * Buddy of this Employee.
	 */
	private Employee buddy;
}