package java_c;

/**
 *  this is a wall class, it sets and block exits
 *
 */

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Wall;

public class Walls {
	
	/**
	   *  creates room without exits
	   *
	   */
	public Walls(City building, int street, int avenue){
    Direction[] direction = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    for (int i =0; i<4; i++){
      new Wall(building, street, avenue, direction[i]);
    }
    
  }
  
	/**
	   *  creates room with one exit
	   *
	   */
 public Walls(City building, int street, int avenue, Direction door){
	  
	 // super(building, avenue, avenue, door);
    Direction[] direction = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    for (int i =0; i<4; i++)
    {
      if (direction[i]!=door){
         new Wall(building, street, avenue, direction[i]);
      }
      
    }
  }
 
 /**
  *  creates room with two exits
  *
  */
 public Walls(City building, int street, int avenue, Direction door,Direction door2){
	  
	 // super(building, avenue, avenue, door);
    Direction[] direction = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    for (int i =0; i<4; i++)
    {
      if (direction[i]!=door && direction[i] !=door2){
         new Wall(building, street, avenue, direction[i]);
      }
      
    }
  }



}
