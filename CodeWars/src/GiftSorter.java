public class GiftSorter {

	public static String sortGiftCode(String code){
		String[] arrayOfLetters = code.split("");
		String returnPhrase = "";
		
		for(int iterator1 = 0; iterator1 < code.length(); iterator1++) {
			for(int iterator2 = 1; iterator2 < code.length(); iterator2++) {
				if (arrayOfLetters[iterator1].compareTo(arrayOfLetters[iterator2]) < 0)
					swap(arrayOfLetters, iterator1, iterator2);
			}
		}
		
		for(int iterator = 0; iterator < arrayOfLetters.length; iterator++){
			returnPhrase += arrayOfLetters[iterator];
		}
		
		return returnPhrase;
	
	}
	
	public static void swap(String[] arrayOfLetters, int position1, int position2){
		String auxiliar = arrayOfLetters[position1];
		arrayOfLetters[position1] = arrayOfLetters[position2];
		arrayOfLetters[position2] = auxiliar;
	}
	
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String test = "oioioi";
//		String[] teste2 = test.split("");
//		String retorno = "";
//		for(int iterator = 0; iterator < teste2.length; iterator++){
//			retorno = retorno + teste2[iterator];
//		}
//		System.out.println(retorno);

		System.out.println(sortGiftCode("abcd"));
	}

}
