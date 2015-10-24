package java_c;
/**
 * this is an items class, it creates the movable,unmovable and block exits items
 *
 */
import java.awt.Color;

import becker.robots.*;


public class Items {
	
	private City aCity;
	
	
	/**
	   *  get the city name for which the items should be constructed on.
	   *
	   */
	public Items(City aCity)
	
	{
		
		this.aCity = aCity;
	}
	
	/**
	   *  make item unmovable
	   *
	   */
	public void unMovableItems(int street,int avenue)
	{
		Thing h = new Thing(aCity, street, avenue);
	    h.setCanBeCarried(false);
	    h.setColor(Color.RED);
	   
	    
	}
     
	/**
	   *  make item movable
	   *
	   */
	public void movableItems(int street,int avenue)
	{
		Thing h = new Thing(aCity, street, avenue);
	    h.setCanBeCarried(true);
	    
	}

	
	/**
	   *  lets item block exit
	   *
	   */
	public void blockExits(int street,int avenue)
	{
		Thing h = new Thing(aCity, street, avenue);
	    h.setCanBeCarried(true);
	    h.setColor(Color.CYAN);
	    h.setBlocksExit(Direction.WEST, true);
	    h.setBlocksExit(Direction.NORTH, true);
	}

	
	

}
