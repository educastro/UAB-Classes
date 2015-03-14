
public class Leetspeak {
	
	public String encode(String source){
		// Sets an empty variable that will be returned with the encoded elements
		String encodedString = "";
		char a = 'b';
		String b = "oi";
		b.
		
		// If the source is a null element then returns an empty string
		if(source == null)
			return "";
		
		// Transforms all the elements from source to lower case
		source.toLowerCase();
		
		// Iterates through all the elements from the source word
		for(int iterator = 0; iterator < source.length(); iterator++){
			// Checks it letter and concatenates the encodedString variable with the encode correspondent
			if(source.charAt(iterator) == 'a')
				encodedString += "4";
			else if(source.charAt(iterator) == 'b')
				encodedString += "|3";
			else if(source.charAt(iterator) == 'c')
				encodedString += "<";
			else if(source.charAt(iterator) == 'd')
				encodedString += "[)";
			else if(source.charAt(iterator) == 'e')
				encodedString += "3";
			else if(source.charAt(iterator) == 'f')
				encodedString += "|=";
			else if(source.charAt(iterator) == 'g')
				encodedString += "6";
			else if(source.charAt(iterator) == 'h')
				encodedString += "#";
			else if(source.charAt(iterator) == 'i')
				encodedString += "!";
			else if(source.charAt(iterator) == 'j')
				encodedString += ";";
			else if(source.charAt(iterator) == 'k')
				encodedString += "X";
			else if(source.charAt(iterator) == 'l')
				encodedString += "1";
			else if(source.charAt(iterator) == 'm')
				encodedString += "/^^\\";
			else if(source.charAt(iterator) == 'n')
				encodedString += "/V";
			else if(source.charAt(iterator) == 'o')
				encodedString += "0";
			else if(source.charAt(iterator) == 'p')
				encodedString += "|o";
			else if(source.charAt(iterator) == 'q')
				encodedString += "0.";
			else if(source.charAt(iterator) == 'r')
				encodedString += "/2";
			else if(source.charAt(iterator) == 's')
				encodedString += "5";
			else if(source.charAt(iterator) == 't')
				encodedString += "7";
			else if(source.charAt(iterator) == 'u')
				encodedString += "(_)";
			else if(source.charAt(iterator) == 'v')
				encodedString += "\\/";
			else if(source.charAt(iterator) == 'w')
				encodedString += "\\X/";
			else if(source.charAt(iterator) == 'x')
				encodedString += "><";
			else if(source.charAt(iterator) == 'y')
				encodedString += "'/";
			else if(source.charAt(iterator) == 'z')
				encodedString += ">_";
			else
				encodedString += source.charAt(iterator);
		}
		
		// Returns the encoded string
		return encodedString;
	}
}

