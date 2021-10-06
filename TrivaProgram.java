package cs1180;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TrivaProgram {
	public static void main(String[]args) {
		//declaring and setting up scanner
		Scanner input=new Scanner(System.in);
		
		//declaring variables to easily print whether the user was correct or not later in code
		String r1="correct";
		String r2="false";
		
		//this will be the counter for questions correct
		double correct=0;
		
		//asking for user input then storing input in a1
		System.out.println("whats 9+10?");
		int a1= input.nextInt();
		
		//if statement comparing user input to correct value if correct it prints out "correct" and increments by 1 if a1 is not matching correct value then prints out "false" 
		//this is how every question will work below
			if(a1==19) {
					System.out.println(r1);
					correct++;
				} else {
					System.out.println(r2);
				}
		
		System.out.println("what color is the sky?");
		//.toLowerCase is to make it so the users input does not need to be case sensitive to be correct
		String a2=input.next().toLowerCase();
		
			if(a2.equals("blue")) {
					System.out.println(r1);
					correct++;
				} else {
					System.out.println(r2);
				}
		
		System.out.println("what year did Advengers: 'Endgame' come out in theaters?  (must be +- 2years to get credit)");
		int a3=input.nextInt();
		
		//covers all possible values 2yrs +- of correct anwser
			if(a3==2017||a3==2018||a3==2019||a3==2020||a3==2021) {
					System.out.println(r1);
					correct++;
				} else {
					System.out.println(r2);
				}
		
		System.out.println("what animal goes (meow)");
		String a4=input.next().toLowerCase();
		
			if(a4.equals("cat")) {
					System.out.println(r1);
					correct++;
				} else {
					System.out.println(r2);
				}
			
		System.out.println("what is 6/2");
		int a5=input.nextInt();
		
			if(a5==3) {
					System.out.println(r1);
					correct++;
				} else {
					System.out.println(r2);
				}
		
		//divides correct by 5 then multiplies by 100 to bring it from .20 to 20.0
		double score=(correct/5)*100;
		//setting up decimal format to get rid of hanging zero
		DecimalFormat format= new DecimalFormat("0.#");
		System.out.println("You got "+format.format(correct)+" out of 5 right, for a score of "+format.format(score)+"%!");
		
		//closing the scanner
		input.close();
	}
}
