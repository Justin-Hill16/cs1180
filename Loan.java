package cs1180;

import java.util.Scanner;

public class Loan {
	public static void main(String[] args) {
		Scanner jk=new Scanner(System.in);
		System.out.println("What is the loan amount?");
		double loan=jk.nextDouble();
		System.out.println("What is the down payment?");
		double down=jk.nextDouble();
		System.out.println("Have you held this job for at least a year?");
		String job=jk.next();
		System.out.println("What is your anual salery?");
		Double salary=jk.nextDouble();
		
			if((down/loan)>=.2||job.contains("yes")&&(salary/loan)>=.5) {
			System.out.println("you were approved for the loan");
	
			}else {
				System.out.println("you were not approved for the loan");
			}
		
		
		jk.close();
	}
}
