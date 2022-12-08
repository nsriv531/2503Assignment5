package model;

public class WordCounter implements HashInterface<HashElement>{
	
	private int size;
	private HashElement[] hashtable;
	private int numberOfDistinctWords = 0;
	
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

		for (HashElement e : hashtable) {
			
			if (e.getWord().equals(key.getWord())) {
				e.increaseCount();
			} else {
				int i = gethashCode(key);
				putQuadratic(i, key);
				numberOfDistinctWords++;
			}
			
		}
		
	}

	
	public int probeQuadratic(int index) {
		
		for (int j =0; j < size; j++) {
			index = (index + j*j) % size;
			
			if (hashtable[index] == null) {
				
				return index;
			}
			
		}
		return -1;
	}
	
	public void putQuadratic(int i, HashElement word) {
	
		
		if (hashtable[i] == null) 
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

		HashElement elementToRemove = null;
		
		for (HashElement e: hashtable) {
			
			if (e.equals(key)) {
				
				elementToRemove = e;
				e = null;
				
			}
			
		}
	
		return elementToRemove;
		
	}
	
	@Override
	public void reset() {

		for (int i = 0; i < hashtable.length; i++) hashtable[i] = null;
		
	}
	
	public HashElement getMostCommonWord() {
		
		HashElement mostCommonWord = null;
		
		for (int i = 1; i < hashtable.length; i++) {
			
			if (hashtable[i - 1].getCount() > hashtable[i].getCount()) {
				mostCommonWord = hashtable[i - 1];
			} else {
				mostCommonWord = hashtable[i];
			}
			
		}
		
		return mostCommonWord;
	}
	
	public int getNumberOfDistinctWords() {
		return numberOfDistinctWords;
	}

	@Override
	public void printTable() {
		// TODO Auto-generated method stub
		
		System.out.println();
		for (int i = 0; i < hashtable.length; i++)  System.out.println(hashtable[i].toString());
		
	}

}
