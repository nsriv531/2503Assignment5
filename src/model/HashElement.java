package model;

public class HashElement {

private String word; //key for the hash table
private int count;



	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}


	public int getCount() {
		return word.length();
	}




public String toString() {
	
	
	return word+"  "+getCount();
}



	
}
