import java.util.Arrays;
import java.util.Scanner;

/**
* The PlanetEnumeration program implements an application that allows you to
* input any planet in the solar system and outputs the rest in order from closest to farthest.
*
* @author  Bradley Wills
* @version 1.0
* @since   2020-03-12
*/

public class PlanetEnumeration {
  // Create variables 
  static double userPlanetDistance;
  static double planetDistance;

  
  enum Planets {
    MERCURY(0.390), VENUS(0.723), EARTH(1.000), MARS(1.524), JUPITER(5.203),
    SATURN(9.539), URANUS(19.180), NEPTUNE(30.060);
    private final double distance;
    Planets(double distance) {
      this.distance = distance;
    }
    
    double getDistance() {
      return this.distance;
    }
  }
  
  
  /**
   * Plays the body of the program.
   */
  public static void main(String[] args) {
    double[] distances = new double[8];
    int count = 0;
    Scanner userInput = new Scanner(System.in);
    // Asks for input.
    System.out.println("Input Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, or Neptune.");
    try {
      String userChoice = userInput.nextLine().toUpperCase();
      Planets userPlanet = Planets.valueOf(userChoice);
      userPlanetDistance = userPlanet.getDistance();
      // Calculates and appends distances.
      for (Planets planetName : Planets.values()) {
        planetDistance = Math.abs(userPlanetDistance - planetName.getDistance());
        distances[count] = planetDistance;
        count++;
      }
      // Sorts from smallest to largest.
      Arrays.sort(distances);
      String properUserChoice = userChoice.substring(0, 1) 
          + userChoice.substring(1).toLowerCase();
      System.out.println("In order of closest to farthest from " + properUserChoice + ".");
      
      // Outputs all the other planets and the distances
      for (int j = 1; j < distances.length; j++) {
        for (Planets name : Planets.values()) {
          String properName = String.valueOf(name).substring(0, 1) 
              + String.valueOf(name).substring(1).toLowerCase();
          if (Math.abs(userPlanetDistance - name.getDistance()) == distances[j]) {
            System.out.println(properName + " is " + distances[j] + "AU away from "
                + properUserChoice + ".");
          }
        }
      }
      // Informs the user of the units
      System.out.println("1 AU is equal to the distance from the Sun to Earth.");
    } catch (Exception e) {
      System.out.println("Invalid Input.");
    }
  }
}