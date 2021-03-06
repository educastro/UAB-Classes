package lab10;


import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.reflect.*;

/**
 * Class that takes in input as the class name followed by its constructor
 * parameters.
 * 
 */
public class ReflectionLab {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Scanner scanner = new Scanner(System.in);
		@SuppressWarnings("rawtypes")
		Class newClass = null;
		Object newInstance = null;

		// get the input from the user as space separated values
		String constructorInput = scanner.nextLine();

		// split from ' '
		// String[] splitsInput = constructorInput.split(" ");
		// Commented the previous lines and replaced it for a StringTokenizer instance because
		// it is much easier.
		StringTokenizer constructorInputTokenized = new StringTokenizer(constructorInput);

		//		for(String split: splitsInput){
		//			System.out.println(split);
		//		}

		//TODO work with splitsInput and then use Reflection API to
		//create an object of that type using that particular constructor
		
		newClass = Class.forName(constructorInputTokenized.nextToken());
		System.out.println("Class: " + newClass.toString());
		
		for(int iterator = 0; iterator <= constructorInputTokenized.countTokens() + 2; iterator++) {
			System.out.println("Parameter #" + (iterator + 1) + ": " + constructorInputTokenized.nextToken());
		}
		
		newInstance = createNewInstance(newClass, constructorInputTokenized);
		
		System.out.println(newInstance.getClass().toString());
		
		
		int numberOfSides = 0;
		int[] lengthOfSide = new int[numberOfSides];


		scanner.close();
	}
	
	private static Object createNewInstance(Class newClass, StringTokenizer constructorInputTokenized) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor[] constructorList = newClass.getConstructors();
		
		for(@SuppressWarnings("rawtypes") Constructor constructor : constructorList) {
			if(constructor.getParameterTypes().length == constructorInputTokenized.countTokens()) {
				Class[] parametersClassesTypesList = constructor.getParameterTypes();
				Object[] parametersObjectTypesList = null;
				for(int iterator = 0; iterator < parametersClassesTypesList.length; iterator++){
					parametersObjectTypesList[iterator] = getObject(newClass, constructorInputTokenized.nextToken());
				}
				return constructor.newInstance(parametersObjectTypesList);
			}
		}
		
		return null;
	}
	
	/**
	 * Get the object of the class type out of the string token.
	 * 
	 * @param type
	 *            - type representing the class type of the string token
	 * @param value
	 *            - the string token to parse into the appropriate type
	 * @return the object representing the string token
	 * 
	 * @precondition value!=null and type!=null and type is one of integer,
	 *               float, double, boolean, character or string itself
	 */
	@SuppressWarnings("rawtypes")
	public static Object getObject(Class type, String value) {
		if (Integer.class.equals(type) || int.class == type) {
			return Integer.parseInt(value);
		} else if (Float.class.equals(type) || float.class == type) {
			return Float.parseFloat(value);
		} else if (Long.class.equals(type) || long.class == type) {
			return Long.parseLong(value);
		} else if (Double.class.equals(type) || double.class == type) {
			return Double.parseDouble(value);
		} else if (Boolean.class.equals(type) || boolean.class == type) {
			return Boolean.parseBoolean(value);
		} else if (Character.class.equals(type) || char.class == type) {
			return value.charAt(0);
		} else {
			return value; // at the end we assume its just a plain simple String
		}
	}
}
