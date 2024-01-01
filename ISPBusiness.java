package edu.iastate.cs228;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author <<Cade Bradford>>
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town townOld) {
		Town townNew = new Town(townOld.getLength(), townOld.getWidth());
		// goes through old plain
		for (int i = 0; i <= townOld.getWidth() - 1; i++) 
		{
			for (int j = 0; j <= townOld.getWidth() - 1; j++)
			{
				 townNew.grid[i][j] = townOld.grid[i][j].next(townNew); 
				// creates the new plain 
			}
		}
		return townNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) {
		int profit = 0;
		//nested for loop to iterate through grid and find any casual users
		for (int i = 0; i <= town.getLength() - 1; i++) 
		{
		
			for (int j = 0; j <= town.getWidth() - 1; j++) 
			{
				if(town.grid[i][j].who().equals(State.CASUAL)) {
					profit++;
				}
			}
		}
		return profit;
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) {
		 
	        System.out.println("Enter 1 to input a file");
	        System.out.println("Enter 2 to Randomly generate a grid");
	        Scanner s = new Scanner(System.in);
	        int option = s.nextInt();
	        Town town;
	        if (option == 1) {
	            Scanner t2 = new Scanner(System.in);
	            System.out.println("Enter filename");
	            String filename = t2.nextLine();
	            // To catch incorrect inputs
	            try {
	                town = new Town(filename);
	                t2.close();
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	                s.close();
	                t2.close();
	                return;
	            }
	       

	        }
	        else if(option == 2) {
	            Scanner t = new Scanner(System.in);
	            System.out.println("Provide rows, cols and seed integer separated by space: ");
	            int length = t.nextInt();
	            int width = t.nextInt();
	            int seed = t.nextInt();
	            town = new Town(length, width);
	            town.randomInit(seed);
	            t.close();
	            s.close();
	            
	        }
	        else {
	            System.out.println("Invalid option selected. Exiting now");
	            s.close();
	            return;
	        }
	       
	}
}
