package edu.iastate.cs228;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 *  @author Cade Bradford
 *	Empty tests
 */
public class EmptyTest {
	// Census cell 1,1, check that type in next town cycle is casual.
		@Test
		public void next_EmptyCell_Casual5() throws FileNotFoundException {
			Town town = new Town("/Users/cadebradford/Desktop/cs228/hw1/src/edu/iastate/cs228/ISP4x4.txt");
			town.grid[1][1].census(TownCell.nCensus);
			
			assertEquals(State.CASUAL, town.grid[1][1].next(town).who());
		}
    @Test
    public void Test() {
        Town t = new Town(2,2);
        t.grid[0][0] = new Empty(t,0,0);
        t.grid[0][1] = new Empty(t,0,1);
        t.grid[1][0] = new Casual(t,1,0);
        t.grid[1][1] = new Casual(t,1,1);
        assertEquals(State.RESELLER, t.grid[0][0].next(t).who());
    }
}
