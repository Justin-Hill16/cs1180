package cs1180;

import java.util.LinkedList;

public class Character {
	
	
	///creating character contructors
	private String name;
	private int health;
	private int row;
	private int col;
	private int max;
	
	public Character(String name, int health, int row, int col, int max) {
	
		setName(name);
		setHealth(health);
		setRow(row);
		setCol(col);
		setMax(max);
	}
	
	public String getName() {return name;}
	public void setName(String name) {
		this.name= name;
	}
	
	public int getHealth() {return health;}
	public void setHealth(int health) {
		this.health= health;
	}
	
	public int getRow() {return row;}
	public void setRow(int row) {
		this.row=row;
	}
	
	public int getCol() {return col;}
	public void setCol(int col) {
		this.col=col;
	}
	
	public int getMax() {return max;}
	public void setMax(int max) {
		this.max=max;
	}
	//end of character creation
	
	//formats data to print to main when called
	public String toString() {
		return getName()+	" at "	+getRow()+	","	+getCol()+	" with " +getHealth()+	" health"; 
	}
	
	//stores random int between 1 and max damage and sets health of player minus rnadom int
	//print statment to help with wierd formating
	public void hit(Character other) {
		int x= ((int)(Math.random()*max)+1);
		other.setHealth(other.getHealth()-x);
		System.out.println("hit for "+x);
	}

	//checks if player still has health
	boolean alive() {
		if(health>0) {
			return true;
		}
		return false;
	}
	
	//checks to see if player has made it to value of [size][size]
	boolean out(int size) {
		if(row==size&&col==size) {
			return false;
		}return true;
	}
}
