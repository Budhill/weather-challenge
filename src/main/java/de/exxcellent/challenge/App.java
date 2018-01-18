package de.exxcellent.challenge;

import java.util.List;

/**
 * This class 
 * - specifies the path of the CSV files
 * - initializes two 2-dimensional ArrayLists for the weather and football data using the method CSVFileToArray in class DataFile
 * - initializes two Strings with the results of the weather and football challenge using the method FindSmallestSpread in class DataFile
 * - prints the results
 * 
 * @author tobiasvienenkotter
 */
public final class App {

    public static void main(String... args) {

		// location of resources
		String filePath = "src/main/resources/de/exxcellent/challenge/";
		
		// name of CSV Files
		String weatherFile = "weather.csv"; //ToDo: use real file path
		String footballFile = "football.csv"; //ToDo: use real file path
		
		// store data of CSV file into array
		List<List<String>> weatherData = DataFile.CSVFileToArray(filePath + weatherFile);
		List<List<String>> footballData = DataFile.CSVFileToArray(filePath + footballFile);
		
        // data analysis function call
        String dayWithSmallestTempSpread = DataFile.FindSmallestSpread(weatherData,"MxT","MnT");
        String teamWithSmallesGoalSpread = DataFile.FindSmallestSpread(footballData,"Goals","Goals Allowed");

        // print result of data analysis 
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
