package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.WordCounter;

public class WordCounterApp {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String fileName = input.nextLine();
		File fileToRead = new File(fileName);
		WordCounter instanceCounter;
		
		System.out.printf("Enter the name of the text file: ");
		System.out.printf("Enter the size of the hashtable: ");
		int sizeOfTable = input.nextInt();
		instanceCounter = new WordCounter(sizeOfTable);
		
		
		try(Scanner fileReader = new Scanner(fileToRead)){
			
			String currentLine;
			String [] splittedLine;
			char asciiValue;
			
			while(fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine().toLowerCase();
				instanceCounter.put(null);
				
				splittedLine = currentLine.split(" ");
				
			}
			
			
			fileReader.close();
		}
		
		
		
		
		
		
	}

}
