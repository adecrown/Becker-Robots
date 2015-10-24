package java_c;




import java.util.ArrayList;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import becker.robots.Direction;
import becker.robots.Wall;




public class Game {
	
	
	private Parser parser;
	private Player player;
	private Building building ;
	private Items item;
	private long startTime = System.currentTimeMillis();
	//
	ArrayList<String> moves = new ArrayList<String>();
	//
	
	
	public Game() 
    {
		building = new Building();
		player = new Player(building, 0, 0,Direction.EAST);	
		//
		moves.add(Integer.toString(0)+Integer.toString(0)+Integer.toString(2));
		//
        parser = new Parser();
        item = new Items(building);
        createGame();
        play(player);
       
    }
	
	public void createGame()
	{
		Room rooms = new Room(building);
		rooms.room1();
		rooms.room2();
		rooms.room3();
		rooms.safeRoom();
		
		item.movableItems(1, 0);
		item.movableItems(2, 4);
		item.movableItems(2, 2);
		item.movableItems(6, 0);
		item.movableItems(5, 2);
		item.movableItems(6, 6);
        
		item.unMovableItems(3, 4);
		item.unMovableItems(6, 1);
        
		item.blockExits(5, 4);
		item.blockExits(3, 1);
    
	}
	
	public void play(Player player) 
    {   
		welcome();
		new Wall(building, 0,3, Direction.NORTH);
		/*TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                //your task
            	gh.cyanItems(1, 2);
            	
            }
        };
        new Timer().scheduleAtFixedRate(timerTask, 0, 60*100);*/
		
        
		boolean finished = false;
		while(false||(System.currentTimeMillis()-startTime)<1200000 && ! finished)
		{
		Command command = parser.getCommand();
        finished = processCommand(command,player);
			
		}
		 new Wall(building, 0,6, Direction.SOUTH);
		 
		 
		
    }
	
	
	private boolean processCommand(Command command, Player player) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case MOVE:
            	 move();
                break;
            case BACK:
                back(player);
                break;
                
            case TURN:
                turn(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
            case BACKPACK:
            	printItems();
            	break;
            case PICK:
            	pickItem(command);
            	break;
            case PUT:
            	putItem(command);
            	break;
            	
            
        }
        return wantToQuit;
    }
	
private void printItems() {
		
    	
		if(player.backPack() == 0)
		{
			System.out.println("You currently do not have anything in your backpack");
		}
		else
		{
			System.out.println("You are carrying "+player.backPack()+" item(s):");
			
		}
		
	}

	private void pickItem(Command command) {
    	
    	
    	player.carryThings();
    	
    	
    	
	}
	
	
	private void putItem(Command command) {
 
    	
    	player.placeThing();
    	
    	
   
	}
	
	private void move() 
    {	
		//
			String move = player.walk();
			moves.add(move);
		//	
			
			
			System.out.println(moves);
    }
	
	
	
	private void turn(Command command)
    {
         if(!command.hasSecondWord()) 
         {
            // if there is no second word, we don't know which way to turn...
            System.out.println("turn which way?");
            return;
         }

        String direction = command.getSecondWord();
        if(direction.equals("left")) 
        { player.turnLeft();}
        else if(direction.equals("right")) 
        { player.turnRght();}
        else if(direction.equals("around")) 
        { player.turnaround();}
        else 
        { System.out.println("You can not turn that way");}
        //System.out.println("You are currently facing " + thePlayer.getDirection());
    }
	
	
	private void welcome()
	{
		System.out.println("Welcome to get the items");
		System.out.println("Collect and deliver the yellow dot from each room/building to the safe room, which is located by thr top right corner");
		System.out.println("The red dots cannot be picked");
		System.out.println("The Cyan dots blocks the north and west exits and also cannot be picked");
	}
	
	private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
	
	private boolean quit(Command command) 
    {
        if(command.hasSecondWord())
        {
            System.out.println("Quit what?");
            return false;
        }
        else 
        {
            return true;  // signal that we want to quit
        }
    }
	
	
	private void back(Player player)
    {
		
		//
           player.getBack(moves,player);
		//
    }

}
