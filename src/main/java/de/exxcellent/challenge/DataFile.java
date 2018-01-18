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
	public static List<List<String>> CSVFileToArray (String fileLocation) {
		
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
	
	/**
	 * This method finds the line in which the smallest spread between given maximum and minimum value is located in.
	 * It iterates through the 2-dimensional ArrayList and compares the corresponding spread values. The method 
	 * returns the first item of the line which contains the smallest spread value, where the identifying label for 
	 * each line is located.
	 * 
	 * @param dataList				-	2-dim. ArrayList with data from CSV file
	 * @param maxValue				-	String that specifies the column of the maximum values
	 * @param minValue				-	String that specifies the column of the minimum values
	 * @return smallestSpreadLabel	-	String located in the line corresponding to the smallest spread value
	 */
	public static String FindSmallestSpread (List<List<String>> dataList, String maxValue, String minValue) {
		
		// get column index of maximum value
		int maxValueIndex = GetColumnIndexOfString(dataList, maxValue);
		// get column index of minimum value
		int minValueIndex = GetColumnIndexOfString(dataList, minValue);
		
		// in case searchString for maximum value was not found
		if(maxValueIndex < 0) { 
			String error= "ERROR: '" + maxValue + "' was not found.";
			return error;
		// in case searchString for minimum value was not found
		} else if(minValueIndex < 0){
			String error= "ERROR: '" + minValue + "' was not found.";
			return error;
		}else {
			// set item in the line with index 1 to result
			double smallestSpread = MaxMinDiff(dataList.get(1).get(maxValueIndex),dataList.get(1).get(minValueIndex));
			int smallestSpreadIndex = 1;
			
			// iteration through the rest of the 2-dim. ArrayList, line by line
			for(int i = 2; i < dataList.size(); i++) {
				// get difference between max and min value of current line with index i
				double tmp = MaxMinDiff(dataList.get(i).get(maxValueIndex),dataList.get(i).get(minValueIndex));
				// compare current spread value with smallest spread value and store smaller value
				if(tmp < smallestSpread && tmp >= 0){
					smallestSpread = tmp;
					smallestSpreadIndex = i;
				}
			}
			// return value in winner line and column 0 as String
			String smallestSpreadLabel = dataList.get(smallestSpreadIndex).get(0);
			return smallestSpreadLabel;
		}
	}
	
	/**
	 * Calculates the difference between a given maximum and minimum value. The maximum and minimum
	 * values are given as strings and casted to double, whereas the result of the calculation is
	 * returned as double.
	 * 
	 * @param max	-	maximum value
	 * @param min	-	minimum value
	 * @param diff	-	difference between maximum and minimum value
	 */
	private static double MaxMinDiff (String max, String min) {
		// cast String to double and calculate difference between max and min value
		double diff = Double.parseDouble(max) - Double.parseDouble(min);
		return diff;
	}
	
	/**
	 * Returns the column index of a given string in the first line of a 2-dim. ArrayList. 
	 * The column index is set to -1 and only if given string could be found altered to 
	 * corresponding column index.
	 * 
	 * @param dataList		-	2-dim. ArrayList with data from CSV file 
	 * @param searchStr		-	string that is to be searched for
	 * @return columnIndex	-	corresponding column index of searchStr
	 */
	private static int GetColumnIndexOfString (List<List<String>> dataList, String searchStr) {
		
		int columnIndex = -1;
		if(dataList.get(0).contains(searchStr)) {
			columnIndex = dataList.get(0).indexOf(searchStr);
		}
		return columnIndex;
	}
}
