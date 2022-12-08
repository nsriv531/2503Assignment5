package model;

public class WordCounter implements HashInterface<HashElement>{
	
	private int size;

	public WordCounter(int size) {
		this.size = size;
		HashElement[] hashtable = new HashElement[size];
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

		
	}

	
	public String probeQuadratic(String word) {
		
	}
	
	public void putQuadratic(int i, String word) {
		
		
	}

	
	@Override
	public HashElement remove(HashElement key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printTable() {
		// TODO Auto-generated method stub
		
	}

}
