package cs1180;
//VOLUME OF A SPHERE
import java.util.Scanner;
import java.util.Math;
import java.lang.Math;
public class Practice1 {
	 public static void main(String[] args) {
		 Scanner input= new Scanner(System.in);
	        
		 System.out.println("enter radius");
	       
		 	double radius=input.nextDouble();
	        double cubed= Math.pow(radius,3);
	        double pi =3.14;
	        double a = 1.333;
	        double volume = (a*(pi*cubed));
	        
	     System.out.println("the volume of your sphere is "+volume);
	       
	        input.close();
	    }
}
