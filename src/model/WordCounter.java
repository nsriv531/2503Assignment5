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
		
		
		for (int i =0; i < key.getWord().length(); i++) {
			
			sum += key.getWord().charAt(i);
			
		}
		
		return sum%size;
	}

	@Override
	public void put(HashElement key) {

		if (checkIfRepeated(key.getWord()) == false) {
			int i = gethashCode(key);
			putQuadratic(i, key);
		}
		
	}

	
	private boolean checkIfRepeated(String word) {
		
		boolean repeatedWord = false;
		
		for (HashElement e : hashtable) {
			
			if (e != null) {
				if (e.getWord().equals(word)) {
					e.increaseCount();
					repeatedWord = true;
				}
			}
			
		}
		
		return repeatedWord;
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
	
		if (hashtable[i] == null) {
			
			hashtable[i] = word;
			numberOfDistinctWords++;
			
		} else {
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
			
			if (hashtable[i] == null || hashtable[i - 1] == null) {
				continue;
			}
			
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
		
		for (int i = 0; i < hashtable.length; i++) {
			
			if (hashtable[i] != null) {
				
				System.out.println(hashtable[i].toString());
				
			}
			
		}
		
	}

}
