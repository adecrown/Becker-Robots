package java_c;

/**
 *  this is a building class, it create a city by extending the city class
 *
 */
import becker.robots.*;


public class Building extends City{
	
	/**
	   *  it construct some wall from a file
	   *
	   */
	
  public Building()
  {
    super("src/java_c/Wall.txt");
    
    showThingCounts(true);
    getIntersection(0, 6);
    
  }
  
  
}