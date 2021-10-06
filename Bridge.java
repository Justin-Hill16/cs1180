package cs1180;

import java.util.Scanner;

public class Bridge {
	public static void main(String[] args) {
		Scanner jk=new Scanner(System.in);
		
		System.out.println("how many people playing bridge?");
		
		double pepe=jk.nextDouble();
		double games=Math.floor(pepe/4);
		
		System.out.println("you can play "+games+" games of bridge!");
		
		
		
		jk.close();
	}
}
