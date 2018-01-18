package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

    		// location of resources
		String filePath = "src/main/resources/de/exxcellent/challenge/";
		
		// name of CSV Files
		String weatherFile = "weather.csv"; //ToDo: use real file path
		String footballFile = "football.csv"; //ToDo: use real file path

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
