package cs1180;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class DungeonEscape {

	//method to check if player can move if they can then moves player 
	static void move(Character obj,String dir,int size) {
		//grabs the x and y postion of the character and stores locally
		int x= obj.getRow();
		int y= obj.getCol();
		//confirming you are alive before running
		//dont know if i still need that it fixed a issue in a pinch bu larger issue has since been fixed just doen have enough time to test if this is still nessacry
		boolean run= obj.alive();
		if(run=true) {
			//checks to see what direction matches user input 
			//check to see if they are on a border or not
			//if they spell it wrong or give wrong awnser or input a direction that they cant move gives them error messsage and they reinput their move
			//if they can move in correct direction then adjust current postion +or- 1 then uses setter to set postion in private class
			//also decreases health by two for each directional movement
			if(dir.equalsIgnoreCase("north")) {
					if(y<=0) {
						System.out.println("You cant move that way");
					}else {
						y=y-1;
						obj.setCol(y);
						obj.setHealth(obj.getHealth()-2);
					}
			}
			
			else if(dir.equalsIgnoreCase("south")) {
					if(y>=size) {
						System.out.println("you cant move that way");
					}else {
						y=y+1;
						obj.setCol(y);
						obj.setHealth(obj.getHealth()-2);
					}
			}
			
			else if(dir.equalsIgnoreCase("east")) {
					if(x>=size) {
						System.out.println("you cant move that way");
					}else {
						x=x+1;
						obj.setRow(x);
						obj.setHealth(obj.getHealth()-2);
					}
			}
			
			else if(dir.equalsIgnoreCase("west")) {
					if(x<=0) {
						System.out.println("you cant move that way");
					}else {
						x=x-1;
						obj.setRow(x);
						obj.setHealth(obj.getHealth()-2);
					}
			}
			
			else {
				System.out.println("you cant move that way");
			}
			
			
		//in the case they die by moving it gives them message
		}
		else {
		System.out.println("Sorry you died :(");
		System.exit(0);
		}
	}
	
	
	//method that makes mosters
	static LinkedList<Character> monsterMaker(int size) {
		
		//creates a random and local int that sees how many monsters there needs to be based off of size
		Random r= new Random();
		int moncont = (size*size)/6;
		
		//creates linked list of objects then adds them to list with for loop intializing their postions randomly
		LinkedList<Character> monsters= new LinkedList<Character>();
		for(int i=0; i<moncont; i++) {
			monsters.add(new Character(String.format("Monster %d", i+1),25,r.nextInt(size-0)+0,r.nextInt(size-0)+0,5));
			//test print
			//System.out.println(monsters.get(i));
			
		}
		return monsters;
	}
	
	//check to see what monsters are above below or to the sides
	static void sur(LinkedList<Character>monsters, Character obj) {
		//gets user x and y postion and stores in locals as well as sets up counter
		int x= obj.getRow();
		int y= obj.getCol()	;
		int count=0;
			
			//for loop to loop through the monster list
			for (int i = 0; i < monsters.size(); i++) {
					 //gets x and y postion of current monster object
					 int a =monsters.get(i).getRow();
					 int b =monsters.get(i).getCol();
					 //sees if the monster has the same postion as the player if player were to +- 1 postion in all direction then adds to counter
					 if(a==x-1) {
						 count ++;
					 }
					 else if(a==x+1) {
						 count++;
					 }
					 else if(b==y-1) {
						 count++;
					 }
					 else if(b==y+1) {
						 count++;
					 }
				 
			 } 
		 System.out.println("you smell "+count+" monsters near you");
	}
	
	//method to deteck monster and fight
	static void hit(LinkedList<Character>monsters, Character obj) {
		//checks if player is alive
		boolean run = obj.alive();
		if(run=true) {
			//gets user x and y postion sets to locals
			int x= obj.getRow();
			int y= obj.getCol()	;
			//gets iterations monsters postion
			for (int i = 0; i < monsters.size(); i++) {
				 int a =monsters.get(i).getRow();
				 int b =monsters.get(i).getCol();
				//confirms monster and character postion match
				if(a==x&&b==y) {
					//prints interation of meeting monster
					//calls class hit method to decreas health 
					//goes till you die or monster dies
					System.out.println(obj.toString()+" " +String.format("%s at %d, %d with %d health", monsters.get(i).getName(),monsters.get(i).getRow(),monsters.get(i).getCol(),monsters.get(i).getHealth()));
						while(obj.getHealth()>0 && monsters.get(i).getHealth()>0) {
							System.out.print("you ");
							obj.hit(monsters.get(i));
							System.out.print("you get ");
							monsters.get(i).hit(obj);
							
						}
						//message for if you die and removes monster from list if you kill him
						if(obj.getHealth()==0) {
							System.out.println("you died :(");
						}else {
							monsters.remove(monsters.get(i));
						}
				 }
			}
		}else {
			System.out.println("sorry you died");
			System.exit(0);
		}
	}
	
	
		
	public static void main(String[]args) {
		Scanner jk= new Scanner(System.in);
		
		//user input on name and initializing it in new character object as well as health postion and max damage
		System.out.println("Enter your name");
		String name= jk.nextLine();
		Character obj = new Character(name,100,0,0,10);
		
		//declaring linked list here for method monster makers above as wellas an int size for later use
		LinkedList<Character> monsters= new LinkedList<Character>();
		int size;
		
			//while statement to confirm user makes valid choice on dungeon size
			//ask for user input and stores in size and checks to see if its in range
			while(true) {
				System.out.println("enter how big you want the dungeon to be (5-10):");
				size = jk.nextInt();
				jk.nextLine();
				if(size>= 5&& size<=10) {
					break;
				}
					else {
						System.out.println("that is not a valid size");
						continue;
					}
			}
			
			//stores return value from monsterMaker method and passes size to method
			monsters=monsterMaker(size);
			//boolean variabvle to be changed when player dies or wins
			//size had to be subtracted by one for correct dungion size purposes
			boolean run=true;
			size= size-1;
			
			while(run==true) {
				//prints character values per instructions
				//then calls sur method and passes character obj and local monsters
				//sur checks surronding area for monsters
				System.out.println(obj.toString());
				sur(monsters, obj);
				
				//asks for user input stores then passes local object dungeon size and direction to move method
				System.out.println("what way do you want to go (north, south, east, west)?");
				String dir= jk.nextLine();
				move(obj,dir,size);
				
				//after moving hit method checks for monsters in the spot you in and fights them if they are there
				hit(monsters,obj);
				//checks to see if player is still alive or out of the arena by calling alive and out from class
				//if false kicks out of main while loop
				if(obj.alive()==false) {
					run=false;
				}else if(obj.out(size)==false){
					run=false;
				}else {
					continue;
				}
				
			}
			
			//checks to see if player died or made it out and gives proper response
			if(obj.alive()==false) {
			System.out.println("sorry you died");
			System.exit(0);
			}else if(obj.out(size)==false) {
				System.out.println("you made it out!! nice!");
				System.exit(0);
			}
			
			
			
			
			
		
		//jk.close();
	}
}
