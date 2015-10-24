package java_c;

/**
 *  this is a room class, is creates multiple rooms in the city
 *
 */

import com.sun.prism.paint.Color;

import becker.robots.*;

 public class Room{
	 
	 
	 
	    private City building;
	    
	    /**
		   *  get the city name for which the rooms should be constructed on.
		   *
		   */
	    public Room(City building)
	    {
	    	this.building = building;
	    	
	    }
	    
	    /**
		   *  builds the first room by calling the wall class
		   *
		   */
	    public void room1()
	    {

	    new Walls(building, 1,0, Direction.EAST);
	    new Walls(building,2,0);
	    new Walls(building,1,2);
	    new Walls(building,2,2,Direction.WEST);
	    
	 
	    }
	    /**
		   *  builds the second room by calling the wall class
		   *
		   */
	   	public void room2()
		{

		    new Walls(building, 2,3, Direction.NORTH,Direction.SOUTH);
		    new Walls(building,3,3,Direction.NORTH,Direction.EAST);
		    new Walls(building,3,4,Direction.WEST,Direction.NORTH);
		   new Walls(building,2,4,Direction.SOUTH);
		 
		 }
	   	
	   	/**
		   *  builds the third room by calling the wall class
		   *
		   */
	   	public void room3()
		{

		    new Walls(building, 5,0, Direction.NORTH,Direction.SOUTH);
		    new Walls(building,6,0,Direction.NORTH,Direction.EAST);
		    
		    new Walls(building,6,1,Direction.WEST,Direction.NORTH);
		    new Walls(building,5,1,Direction.EAST,Direction.SOUTH);
		    
		    new Walls(building,5,2,Direction.WEST,Direction.EAST);
		    new Walls(building,5,3,Direction.WEST,Direction.EAST);
		    
		    new Walls(building,5,4,Direction.WEST,Direction.SOUTH);
		    new Walls(building,6,4,Direction.NORTH,Direction.EAST);
		    
		    new Walls(building,6,5,Direction.WEST,Direction.EAST);
		    
		    
		    new Walls(building, 5,6, Direction.NORTH,Direction.SOUTH);
		    new Walls(building,6,6,Direction.WEST,Direction.NORTH);
		 
		 }
	   	
	   	
	   	
	   	public void safeRoom()
	   	{
	   		
	   		new Walls(building, 0,6, Direction.SOUTH);
	   		
	   	}
  
}