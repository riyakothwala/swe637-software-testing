package edu.gmu.swe645.assignment2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ReservationService RS = new ReservationService();
		
		RS.reserve("Person1");
		RS.reserve("Person2");
		RS.reserve("Person3");
		
		System.out.println("1 - " + RS.getCustomer(0).getName());
		System.out.println("2 - " + RS.getCustomer(1).getName());
		System.out.println("3 - " + RS.getCustomer(2).getName());
    }
}
