package lab07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SortAirport {

	public void sortAirportList(String[] listOfAirports){
		int sizeOfTheList = listOfAirports.length; 
		for(int iterator = 0; iterator < sizeOfTheList; iterator++){
			for(int iterator2 = iterator; (iterator2 > 0 && (listOfAirports[iterator2].compareTo(listOfAirports[iterator2 - 1]) <= 0)); iterator2--){
				swap(listOfAirports, iterator2, iterator2 - 1);	
			}
		}
	}

	public void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
