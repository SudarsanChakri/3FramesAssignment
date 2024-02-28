package com.threeframes.assignment.filesandversioncontrol;

import java.io.*;
import java.util.*;
public class FilesAndVersionControlSystem {

	public static void main(String[] args) {
		//Loop continuous for infinite times 
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Choose Activity");
			System.out.println("1.Add File 2. Update existing file 3. Generate version");
			System.out.println("Press enter to exit");
			String choose = scan.nextLine();
			if(choose.equals("")) {
				//breaking the loop when user presses exit
				break;
			}
			//Performing add file activity
			if(choose.equals("1")) {
				//collecting values and passing
				System.out.println("Enter file path");
				String fileName = scan.nextLine();
				System.out.println("Enter file content");
				String content = scan.nextLine();
				addFile(fileName, content);
			}
			else if(choose.equals("2")) {
				//updating the existing file
				System.out.println("Enter file path where update is required");
				String fileName = scan.nextLine();
				System.out.println("Enter updated file content");
				String updatedontent = scan.nextLine();
				makeDelta(fileName, updatedontent);
			}

			else if(choose.equals("3")) {
				//Generating the required version based on version  number
				System.out.println("Enter version number from 0 to n");
				String generatedContent = generateVersion(scan.nextInt());
				System.out.println("Generated Version Content: " + generatedContent);
			}
			else {
				//if choose is wrong then control comes here
				System.out.println("Invalid choose");
			}
		}
	}
	//to store initial version
	static Map<String, String> baseVersion = new HashMap<>();
	//storing updated versions
	static List<Map<String, String>> deltas = new ArrayList<>();

	//adding the base file into map baseVersion
	public static void addFile(String filename, String content) {
		baseVersion.put(filename, content);
	}
	//updating the base file into map deltas
	public static void makeDelta(String filename, String updatedContent) {
		Map<String, String> delta = new HashMap<>();
		delta.put(filename, updatedContent);
		deltas.add(delta);
	}

	//generating required version
	public static String generateVersion(int targetVersion) {
		Map<String, String> currentVersion = new HashMap<>(baseVersion);
		//to iterate over a list of deltas and update the entries in another map
		for (int i = 0; i < Math.min(targetVersion, deltas.size()); i++) {
			Map<String, String> delta = deltas.get(i);
			for (Map.Entry<String, String> entry : delta.entrySet()) {
				currentVersion.put(entry.getKey(), entry.getValue());
			}
		}
		return currentVersion.toString();
	}
}
