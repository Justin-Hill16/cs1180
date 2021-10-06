package cs1180;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		//setting up scanner
		Scanner jk=new Scanner(System.in);
		//asking for user input
		System.out.println("What is the value of n? ");
		
		//declaring variables
		int n = jk.nextInt();
		int ahh=0;
		int prime =0;
		
		//loop to check if user input is negative number if less than zero ask them to re enter and store value in n again 
		while(n<=0) {
			System.out.println("Error: n can not be negative enter a postive number");
			n=jk.nextInt();
		}
		
		
		//starts loop at first prime(2), Loops until user number is satisified or untill the maxinum amount of numbers in a double is met
		for(int i=2;i <Double.MAX_VALUE && prime<n;i++) {
			//keeps track of number of factors that i has 
			ahh=0;
			//nested loop to calculate factors for i 
			for(int j=1; j<=i;j++) {
				//will increment ahh when factor is found
				if(i%j==0) {
					ahh++;
				}
				//checks to see if factor is not prime then breaks out of loop if it is not prime 
				if(ahh>2||i<j) {
					break;
				}
			}
			//if there are two factos(aka prime number) then increment prime then print out i
			if(ahh==2) {
				prime++;
				System.out.println(i);
			}
		}
		
		
		
		
		
		jk.close();
	}
}
