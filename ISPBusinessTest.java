package edu.iastate.cs228;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 *  @author Cade Bradford
 *ISPBusiness test
 */
public class ISPBusinessTest {
	
		
		@Test
		public void testCensus() 
		{
			Town t = new Town(2,2);
	        t.grid[0][0] = new Empty(t,0,0);
	        t.grid[0][1] = new Streamer(t,0,1);
	        t.grid[1][0] = new Outage(t,1,0);
	        t.grid[1][1] = new Casual(t,1,1);
			assertEquals(1, ISPBusiness.getProfit(t));
			// After 11 iterations, profit is 12.
		}
			@Test
			public void profitAfterIteration() throws FileNotFoundException {
				Town town = new Town("/Users/cadebradford/Desktop/cs228/hw1/src/edu/iastate/cs228/ISP4x4.txt");
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				town = ISPBusiness.updatePlain(town);
				assertEquals(12, ISPBusiness.getProfit(town));
			}
		
}
