package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.HashElement;
import model.WordCounter;

public class WordCounterApp {
	
	public static String removeNonletters(String string) {
		
		string = string.replaceAll("[^a-z]", "");
		
		return string;
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		int numberOfWordsInFile = 0;
		Scanner input = new Scanner(System.in);
		
		File fileToRead;
		WordCounter instanceCounter;
		String fileName;
		
		while (true) {
			
			System.out.print("Enter the name of the text file: ");
			
			fileName = input.nextLine();
			fileName = "res/" + fileName + ".txt"; //Adding root key words in order to find the file on directory//
			
			fileToRead = new File(fileName);
			
			if (fileToRead.exists()) {
				break;
			} else System.out.println("File name does not exist. Please try again");
			
		}
		
		System.out.print("Enter the size of the hashtable: ");
		int sizeOfTable = input.nextInt();
		instanceCounter = new WordCounter(sizeOfTable);
		
		input.close();
		
		
		try(Scanner fileReader = new Scanner(fileToRead)){
			
			String currentLine;
			String [] splittedLine;
			
			try {
			
				while(fileReader.hasNextLine()) {
					
					currentLine = fileReader.nextLine().toLowerCase();
					
					if (currentLine.equals("")) {
						continue;
					}
					
					splittedLine = currentLine.split(" ");
					
					numberOfWordsInFile += splittedLine.length;
					
					for (int i = 0; i < splittedLine.length; i++) {
						
						splittedLine[i].trim(); // Eliminates spaces//
						instanceCounter.put(new HashElement(removeNonletters(splittedLine[i]))); //Places a word with non unique characters and numbers//
					}
				}
				
				fileReader.close();
						
				instanceCounter.printTable();
						
				System.out.println("Number of Distinct Words: " + instanceCounter.getNumberOfDistinctWords());
				System.out.println("Most common word is: " + instanceCounter.getMostCommonWord().toString());
				System.out.println("Total number of words in file: "  + numberOfWordsInFile);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
				
			fileReader.close();
			
		} 
		
	}

}
