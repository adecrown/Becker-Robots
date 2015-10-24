package java_c;

/**
 *  A class to represent an adventurer playing the exciting
 *  game of "Soc World". A player has a location (of class Room)
 * and is facing a particular direction.
 * 
 * @author up720163
 * @version 4
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

import becker.robots.*;

public class Player extends RobotSE{
	private long startTime = System.currentTimeMillis();
	
	 /**
	   *  Construct a player in a city using the street and avenue
	   *  get direction
	   */
	
	public Player(City aCity,int aStreet, int anAvenue, Direction aDirection) 
	{
		super(aCity, aStreet,anAvenue,aDirection);
		// TODO Auto-generated constructor stub
		
	}
	
	 /**
	   *  make player move if there is no door
	   *
	   */
	
	public String walk()
	{
		if(this.frontIsClear())
		{
	      this.move();
		}
		else
		{
			System.out.println("There is no door");
		}
		//
		int avenue = getAvenue();
		int street = getStreet();
		int direction = direction(getDirection());
		String move = Integer.toString(avenue)+Integer.toString(street)+Integer.toString(direction);
		return move;
		//
	}
	//
	/**
	   *  get player direction
	   *
	   */
	private int direction(Direction direction){
		int direct = 0;
		switch(direction){
		case NORTH:
			direct = 1;
			break;
		case EAST:
			direct = 2;
			break;
		case SOUTH:
			direct = 3;
			break;
		case WEST:
			direct = 4;
			break;
		}
		return direct;
	}
	
	private Direction getDirection(int direction){
		Direction direct = Direction.EAST;
		switch(direction){
		case 1:
			direct = Direction.NORTH;
			break;
		case 2:
			direct = Direction.EAST;
			break;
		case 3:
			direct = Direction.SOUTH;
			break;
		case 4:
			direct = Direction.WEST;
			break;
		}
		return direct;
	}
	//
	
	/**
	   *  make player turn right
	   *
	   */
	public void turnRght()
	{
		this.turnLeft();
		this.turnLeft();
		this.turnLeft();
	}
	
	
	/**
	   *  make player turn around
	   *
	   */
	public void turnaround()
	{
		this.turnAround();
	}
	
	/**
	   *  checks the player backpack weight
	   *
	   */
	
	public void size()
	{
		if(this.countThingsInBackpack()<=3)
		{
			this.pickThing();
		}
		else
		{
			System.out.println("Your Backpack is full.");
		}
	}
	
	
	/**
	   *  make player pick thing
	   *
	   */
	public void carryThings()
	{
		if (this.isBesideThing(IPredicate.anyThing)) 
		{
			if(this.canPickThing())
			{
			this.size();
			}
			else
			{
				System.out.println("Item is unmoveable.");
			}
		}
		else
		{
			System.out.println("You can't pick an item where there is no item.");
		}
		
	}
	
	/**
	   *  make player put thing
	   *
	   */
	public void placeThing()
	{
		
		if(this.countThingsInBackpack()==0)
		{
			System.out.println("Your backpack is empty");
		}
		else
		{
			while (this.getIntersection().countThings()>7)
		    {
				
			
				System.out.println("You win");
				System.out.println("It took you "+(new SimpleDateFormat("mm:ss")).format(new Date(System.currentTimeMillis()-startTime))+" to complete the game.");
				System.exit(0);
				break;
		    }
		   this.putThing();
		}
		

		
	}
	
	
	/**
	   *  make player go back
	   *
	   */
	public Player getback(ArrayList<String> moves, Building building, Player player)
	{
		//
		player.setIcon(null);
		
		int lastmove = moves.size()-1;
		String move = moves.get(lastmove);
		
		int avenue = Integer.parseInt(move.substring(0, 0));
		int street = Integer.parseInt(move.substring(1, 1));
		Direction direction = getDirection(Integer.parseInt(move.substring(2,2)));
		
		Player newPlayer = new Player(building,avenue,street,direction);
		return newPlayer;
		//
		//this.turnAround();
		//this.move();
	}
	
	//
	public void getBack(ArrayList<String> moves, Player player){
		String initialMove = moves.get(moves.size()-2);
		String finalMove = moves.get(moves.size()-1);
		
		int iniAve = Integer.parseInt(initialMove.substring(0,1));
		int iniStreet = Integer.parseInt(initialMove.substring(1,2));
		int iniDirect = Integer.parseInt(initialMove.substring(2,3));
		//System.out.print(iniAve);
		//System.out.print(iniStreet);
		//System.out.print(iniDirect);
		int finalAve = Integer.parseInt(finalMove.substring(0,1));
		int finalStreet = Integer.parseInt(finalMove.substring(1,2));
		int finalDirect = Integer.parseInt(finalMove.substring(2,3));
		//System.out.print(finalAve);
		//System.out.print(finalStreet);
		//System.out.print(finalDirect);
		int b = 1;
		
		if (iniAve>finalAve && iniStreet==finalStreet){
			while(finalDirect!=2){
				player.turnLeft();
				finalDirect++;
				if (finalDirect==5){
					finalDirect = 1;
				}
			}
			
		}else if (iniAve<finalAve && iniStreet==finalStreet){
			System.out.println("this works");
			System.out.println(finalDirect);
			while(finalDirect!=4)
			{
				player.turnLeft();
				finalDirect++;
				if (finalDirect==5){
					finalDirect = 1;
				}
			}
		}else if (iniStreet>finalStreet && iniAve==finalAve){
			while(finalDirect!=3){
				player.turnLeft();
				finalDirect++;
				if (finalDirect==5){
					finalDirect = 1;
				}
			}
		}else if (iniStreet<finalStreet && iniAve==finalAve){
			while(finalDirect!=1){
				player.turnLeft();
				finalDirect++;
				if (finalDirect==5){
					finalDirect = 1;
				}
			}
		}
		player.move();
		//player.walk();
		
		while(finalDirect!=iniDirect){
			turnLeft();
			finalDirect++;
			if (finalDirect==5){
				finalDirect = 1;
			}
		}
		moves.remove(moves.size()-1);
		
		
		
	}
	//
	
	
	/**
	   *  checks how many things are in player bacback
	   *
	   */
	
	public int backPack()
	{
		return this.countThingsInBackpack();
	}
}
