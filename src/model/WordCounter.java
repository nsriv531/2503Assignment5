package model;

public class WordCounter implements HashInterface<HashElement>{
	
	private int size;
	private HashElement[] hashtable;
	
	
	public WordCounter(int size) {
		this.size = size;
		hashtable = new HashElement[size];
		reset();
		
	}

	@Override
	public int gethashCode(HashElement key) {
		int sum = 0;
		
		String word = key.getWord();
		
		for (int i =0; i < key.getCount(); i++) {
			if (word.charAt(i) != ' ') {
			sum += word.charAt(i);
			
			}
		}
		
		return sum%size;
	}

	@Override
	public void put(HashElement key) {

		int i = gethashCode(key);
		putQuadratic(i, key);
		
		
	}

	
	public int probeQuadratic(int index) {
		
		for (int j =0; j < size; j++) {
			index = (index + j*j) % size;
			
			if (hashtable[index].getWord().equals("-1")) {
				
				return index;
			}
			
		}
		return -1;
	}
	
	public void putQuadratic(int i, HashElement word) {
		
		
		 if (hashtable[i].getWord().equals("-1")) 
	            // the space is empty
	            hashtable[i] = word;
	        else 
	        {
	            int j = probeQuadratic(i);
	            if (j == -1) 
	                System.out.println("Error! Table Full!");
	        }
		
	}

	
	@Override
	public HashElement remove(HashElement key) {

		HashElement wordToRemove = null;
		
		for (HashElement i: hashtable) {
			
			if (i.equals(key)) {
				
				wordToRemove = i;
				i.setWord("-1");
				
			}
			
		}
	
		return wordToRemove;
		
	}
	
	@Override
	public void reset() {

		for (HashElement i: hashtable) {
			i.setWord("-1");
		}
		
	}

	@Override
	public void printTable() {
		// TODO Auto-generated method stub
		
	}

}
