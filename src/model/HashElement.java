package model;

/**
 * This is the hashelement class that is definied so the nature of our hashelements can properly be definied with the context
 * of the word counter and the hash table.
 * @author Emilio G, Nik S.
 *
 */
public class HashElement {

	
	private String word; //key for the hash table
	private int count; //the count, acting as a counter for the word


	/**
	 * This is the hashlement constructor, 
	 * @param word
	 */
	public HashElement(String word) {
	
		this.word = word;
		count = 1;
	}

	/**
	 * Getter that retrieves the word that is needed.
	 * @return word- word that is returned that is 'got'.
	 */
	public String getWord() {
		return word;
	}

	/**
	 * 
	 * @param word is set, and then 'this.word' equals word so it is then set.
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * gets the count
	 * @return count for the counter
	 */
	public int getCount() {
		return count;
	}
	
	
	/**
	 * increases the count of the words
	 */
	public void increaseCount() {
		count++;
	}

	/**
	 * method that prints out the word with the count needed.
	 */
	public String toString() {
	
		return word + " " + getCount();
		
	}

}
