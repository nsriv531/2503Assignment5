package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.HashElement;
import model.WordCounter;

public class WordCounterApp {
	
	public static void main(String[] args) throws FileNotFoundException {
		int numberOfWordsInFile = 0;
		Scanner input = new Scanner(System.in);
		
		File fileToRead;
		WordCounter instanceCounter;
		
		System.out.print("Enter the name of the text file: ");
		
		String fileName = input.nextLine();
		
		fileToRead = new File(fileName);
		
		System.out.print("Enter the size of the hashtable: ");
		int sizeOfTable = input.nextInt();
		instanceCounter = new WordCounter(sizeOfTable);
		
		input.close();
		
		try(Scanner fileReader = new Scanner(fileToRead)){
			
			String currentLine;
			String [] splittedLine;
			
			
			while(fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine().toLowerCase();
				
				splittedLine = currentLine.split(" ");
				
				numberOfWordsInFile += splittedLine.length;
				
				for (int i = 0; i < splittedLine.length; i++) {
					
					instanceCounter.put(new HashElement(splittedLine[i]));
					
				}
				
			}
			
			fileReader.close();
		}
		
		instanceCounter.printTable();
		
		System.out.println("Number of Distinct Words: " + instanceCounter.getNumberOfDistinctWords());
		System.out.println("Most common word is: " + instanceCounter.getMostCommonWord().toString());
		System.out.println("Total number of words in file: "  + numberOfWordsInFile);
		
	}

}
