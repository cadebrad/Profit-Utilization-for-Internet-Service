package edu.iastate.cs228;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
/**
 *  @author Cade Bradford
 *	Town Cell Test
 */
class TownCellTest {
	 Town t;
		
	 @Test
		public void towncellTest1() throws FileNotFoundException {
			Town town = new Town("/Users/cadebradford/Desktop/cs228/hw1/src/edu/iastate/cs228/ISP4x4.txt");
			TownCell townCell = town.grid[3][0];
			assertEquals(town, townCell.plain);
		}
		
		// Check if the column of cell 3,0 is 0.
		@Test
		public void towncellTest2() throws FileNotFoundException {
			Town town = new Town("/Users/cadebradford/Desktop/cs228/hw1/src/edu/iastate/cs228/ISP4x4.txt");
			TownCell townCell = town.grid[3][0];
			assertEquals(0, townCell.col);
		}
}
