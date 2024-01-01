package edu.iastate.cs228;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 *  @author Cade Bradford
 *	Casual Tests
 */
public class CasualTest {
	// Check that grid of cell 1,2 is town.
		@Test
		public void current_CasualCellTown_Town() throws FileNotFoundException {
			Town town = new Town("/Users/cadebradford/Desktop/cs228/hw1/src/edu/iastate/cs228/ISP4x4.txt");
			
			assertEquals(town, town.grid[1][2].plain);
		}
		// Census cell 1,2, check that type in next town cycle is outage.
		@Test
		public void next_CasualCell_Outage1a() throws FileNotFoundException {
			Town town = new Town("/Users/cadebradford/Desktop/cs228/hw1/src/edu/iastate/cs228/ISP4x4.txt");
			town.grid[1][2].census(TownCell.nCensus);
			
			assertEquals(State.OUTAGE, town.grid[1][2].next(town).who());
		}
}
