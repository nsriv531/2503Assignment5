package model;

public class HashElement {

	private String word; //key for the hash table
	private int count;


	public HashElement(String word) {
	
		this.word = word;
		count = 1;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}


	public int getCount() {
		return count;
	}
	
	public void increaseCount() {
		count++;
	}


	public String toString() {
	
		return word + " " + getCount();
		
	}

}
