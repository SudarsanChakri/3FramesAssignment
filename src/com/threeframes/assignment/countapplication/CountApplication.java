package com.threeframes.assignment.countapplication;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class CountApplication {

	public static void main(String[] args) {
		//Taking the input file
		String inputFile = "\\Users\\user\\OneDrive\\Desktop\\demo.txt";
		Map<String, Integer> wordsAndCount = new TreeMap<String, Integer>();
		try {
			//reading the file using buffer reader
			BufferedReader bfr = new BufferedReader(new FileReader(inputFile));
			//Method to read each line from the file
			String line = bfr.readLine();
			//checks whether text is present in the line that is copied
			while(line != null) {
				//splits the text into words
				String[] wordsArray = line.toLowerCase().split(" ");
				//Transversing through all the words in array
				for(String word : wordsArray) {
					//Checks whether word already exists in the map
					if(wordsAndCount.containsKey(word)) {
						//Here it increments the value of particular word by 1 to increase occurance
						int incrementedValue = (wordsAndCount.get(word)+1);
						wordsAndCount.put(word,incrementedValue);
					}
					else {
						//Adds a new word with occurance 1 
						wordsAndCount.put(word,1);
					}
				}
				//Here we are reading the next line and storing into the line
				line = bfr.readLine();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Displaying the each word and its count
		for(Entry<String, Integer> entry : wordsAndCount.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());

		}
	}
}
