package model;

/**
 * This class is the wordcounter class that implements the interface with the hashtables needed.
 * @author Emilio G, Nik S.
 *
 */
public class WordCounter implements HashInterface<HashElement>{
	
	private int size;
	private HashElement[] hashtable;
	private int numberOfDistinctWords = 0;
	
	/**
	 * This is wordocunter constructor, that takes in the size parameter, and then assigns the variables size and hastable
	 * the size that is needed.
	 * it is then reset.
	 * @param size
	 */
	public WordCounter(int size) {
		this.size = size;
		hashtable = new HashElement[size];
		reset();
		
	}

	/**
	 * This implements the hashcode function that is the ascii sum divided by the sum.
	 * @param HashElement key - is the key that is passed into the hashcode method to calculate the sum modulus size.
	 * @return sum%size - is the actual hashcode. 
	 */
	@Override
	public int gethashCode(HashElement key) {
		int sum = 0;
		
		
		for (int i =0; i < key.getWord().length(); i++) {
			
			sum += key.getWord().charAt(i);
			
		}
		
		return sum%size;
	}

	/**
	 * @param HashElemet key - is the key that is passed into the put method to know where the key should be placed.
	 * If the key is false, then an integer is assigned with the hashcode of key, with putquadratic then being called.
	 */
	
	@Override
	public void put(HashElement key) throws Exception {

		if (checkIfRepeated(key.getWord()) == false) {
			int i = gethashCode(key);
			putQuadratic(i, key);
		}
		
	}

	/**
	 * Checking the hash table to see if the word is repeated in the hashtable.
	 * @param word that is passed to see if it is repeated into the hashtable.
	 * @return the word that is repeated
	 */
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
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public int probeQuadratic(int index) {
		
		for (int j =0; j < size ; j++) {
			index = (index + (j*j)) % size;
			
			if (hashtable[index] == null) {
				
				return index;
			}
			
		}
		return -1;
	}
	
	/**
	 * 
	 * @param i
	 * @param word
	 * @throws Exception
	 */
	public void putQuadratic(int i, HashElement word) throws Exception {
	
		if (hashtable[i] == null) {
			
			hashtable[i] = word;
			numberOfDistinctWords++;
			
		} else {
			int j = probeQuadratic(i);
	        if (j == -1) {
	        	throw new Exception("Error! Table size is not big enough! Exiting Program..."); //Throws Exception if the table is full//
	        } else {
	        	hashtable[j] = word;
	        	numberOfDistinctWords++;
	        }
	        
		}
		
	}

	/**
	 * Method to remove the hashtable.
	 * @param hashelement key - key that is passed into the method to know what to remove from the hashtable
	 * @return elementToRemove  - element to be removed.- 
	 */
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
	
	/**
	 * resets the hashtbale.
	 */
	@Override
	public void reset() {

		for (int i = 0; i < hashtable.length; i++) hashtable[i] = null;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public HashElement getMostCommonWord() {
		
		HashElement mostCommonWord = new HashElement("Temporary word to compare");
		
		for (int i = 0; i < hashtable.length; i++) {
			
			if (hashtable[i] != null) {
				
				if (hashtable[i].getCount() >= mostCommonWord.getCount()) {
					mostCommonWord = hashtable[i];
				}
				
			} else {
				continue;
			}
			
		}
		
		return mostCommonWord;
	}
	
	/**
	 * Returns the number of distinct words in the application.
	 * @return
	 */
	public int getNumberOfDistinctWords() {
		return numberOfDistinctWords;
	}

	/**
	 * Prints the actual hashtable.
	 */
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
