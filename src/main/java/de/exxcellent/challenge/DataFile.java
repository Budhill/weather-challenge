package de.exxcellent.challenge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataFile {
	
	/**
	 * This method returns the data of CSV file at a given file path as a 2-dimensional ArrayList.
	 * The CSV file is parsed using split() with standard comma separator. If no file at given 
	 * file path exists an exception is thrown.
	 * 
	 * @param fileLocation	-	path at which file is located
	 * @return dataList		-	2-dim. ArrayList with data from CSV file
	 */
	public static List<List<String>> csvFileToArray (String fileLocation) {
		
		// 2-dimensional ArrayList of strings for data
		List<List<String>> dataList = new ArrayList<>();
		// scanner for data in file
		Scanner scanner = null;
		
		try {
			// file with the data
			File file = new File(fileLocation);
			// scanner with data
			scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
				// store weather data into array of strings, line by line
				String dataLine = scanner.nextLine();
				String[] dataArray = dataLine.split(",");
				// add the currently parsed line to the 2-dimensional string array
				dataList.add(Arrays.asList(dataArray));			
			} 		
		}catch(IOException e) {
			e.printStackTrace();	
		}finally {
			if (scanner != null) {
				scanner.close();
			}
		}		
		return dataList;
	}

}
