package lab10;

public class HashMap {
	private final static int TABLE_SIZE = 100;

	HashEntry[] table;
	int numberOfElements;
	int probingCounter = 1;

	HashMap() {
		table = new HashEntry[TABLE_SIZE];
		numberOfElements = 0;
	}

	public String getValuePosition(int position){
		return table[position].getValue();
	}

	public String get(int key) {
		int position = key % TABLE_SIZE;

		if(table[position] == null)
			return "key not found";
		else if(table[position].getKey() == key)
			return table[key % TABLE_SIZE].getValue();
		else {
			while(table[position].getKey() != key) {
				position = ((7 * position) + 1) % TABLE_SIZE;
				if(position >= 99)
					return "key not found";
			}
			return table[position].getValue();
		}
	}

	public void put(int key, String value) {
		int position = key % TABLE_SIZE;

		if(numberOfElements == 100){
			table[position] = new HashEntry(key, value);
			return;
		}

		while(table[position] != null){
			position = ((7 * position) + 1) % TABLE_SIZE;
		}

		table[position] = new HashEntry(key, value);
		numberOfElements++;
	}

	public void linearProbe(int key, String value){
		probingCounter = 1;

		int position = key % TABLE_SIZE;

		if(numberOfElements == 100){
			table[position] = new HashEntry(key, value);
			return;
		}

		while(table[position] != null){
			position = ((position * 7) + probingCounter) % TABLE_SIZE;
			probingCounter++;
			if(position > 99)
				position = 0;
		}

		table[position] = new HashEntry(key, value);
		numberOfElements++;
	}

	public void quadraticProbe(int key, String value){
		probingCounter = 0;

		int position = (key % TABLE_SIZE);

		if(numberOfElements == 100){
			table[position] = new HashEntry(key, value);
			return;
		}

		while(table[position] != null){
			position = ((position * 7) + probingCounter * probingCounter) % TABLE_SIZE;
			probingCounter++;
			if(position > 99)
				position = 0;
		}

		table[position] = new HashEntry(key, value);
		numberOfElements++;
	}

}