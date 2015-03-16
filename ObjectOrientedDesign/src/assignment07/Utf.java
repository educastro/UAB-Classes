package assignment07;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that simulates a unit testing framework of a provided class
 * 
 */

public class Utf {

	@SuppressWarnings("rawtypes")
	public Utf(Class testClass) throws Exception {
		/** 
		 * Variable that will receive the class parameter to be used locally 
		 */
		Class theClass = null;

		/**
		 * If the parameter class is null so throw exception
		 */
		if(testClass == null)
			throw new Exception("null class provided as parameter");

		/**
		 * Make a copy from the parameter class
		 */
		theClass = testClass;

		/**
		 * Get an array will all the public methods from the class. Protected or private will not be stored
		 */
		Method[] methodList = theClass.getMethods();

		/**
		 * Loop between all the elements of the methodList array(aka loop between all the methods from the class)
		 */
		for(Method method : methodList) {
			
			/**
			 * Only pass if the return type is void
			 */
			if(checkIfItIsAValidReturnType(method)){
				/**
				 * Only pass if the method name starts with 'test'
				 */
				if(checkIfItIsAValidTestMethod(method)) {
					/**
					 * Only pass if the method has no parameters
					 */
					if(checkIfTheMethodHasNoParameters(method)) {
						/**
						 * Runs the test method, if an exception is catched then prints this exception
						 */
						try{	
							method.invoke(theClass.newInstance());
						} catch (Exception e) {
							System.out.println(method.getName() + " " + e.getCause());
						}
					} else {
						//throw new Exception("test method has parameters");
						//break;
					}
				} else {
					//throw new Exception("invalid test method name");
					//break;
				}
			} else {
				//throw new Exception("invalid return type");
				//break;
			}	
		}
	}

	/**
	 * Method that checks the name of the method and validates it
	 * @param method
	 * @return true if the test name starts with 'test'
	 * @return false if the test name is other/invalid
	 */
	private boolean checkIfItIsAValidTestMethod(Method method) {
		String methodName = method.getName();
		Pattern pattern = Pattern.compile("^(test)");
		Matcher matcher = pattern.matcher(methodName);

		if (matcher.find())
			return true;
		else
			return false;
	}

	/**
	 * Method that checks the return type of the method
	 * @param method
	 * @return true if the class return type is void
	 * @return false if the class return type is not void
	 */
	private boolean checkIfItIsAValidReturnType(Method method){
		if (method.getReturnType() == void.class)
			return true;
		else
			return false;
	}

	/**
	 * Method that checks the parameters of the method
	 * @param method
	 * @return true if the method has no parameters
	 * @return false if the method has one or more parameters
	 */
	private boolean checkIfTheMethodHasNoParameters(Method method) {
		if (method.getParameterCount() == 0)
			return true;
		else
			return false;
	}
}
