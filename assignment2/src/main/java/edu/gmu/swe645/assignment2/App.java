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
		
		RS.reserve("Person1", 3);
		RS.reserve("Person2", 2);
		RS.reserve("Person3", 1);
		
		System.out.println(RS.getCustomer(0).getName()+ " Rank - " + RS.getCustomer(0).getRank());
		System.out.println(RS.getCustomer(1).getName()+ " Rank - " + RS.getCustomer(1).getRank());
		System.out.println(RS.getCustomer(2).getName()+ " Rank - " + RS.getCustomer(2).getRank());
		
		RS.sortAssendingRank();
		
		System.out.println();
		
		System.out.println(RS.getCustomer(0).getName()+ " Rank - " + RS.getCustomer(0).getRank());
		System.out.println(RS.getCustomer(1).getName()+ " Rank - " + RS.getCustomer(1).getRank());
		System.out.println(RS.getCustomer(2).getName()+ " Rank - " + RS.getCustomer(2).getRank());
    }
}
