package edu.iastate.cs228;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
/**
 *  @author Cade Bradford
 *	Streamer Test
 */
class StreamerTest {


    

    Town t = new Town(4,4);
    Reseller r = new Reseller(t, 1, 2);

    //just test if who returns the right state
    @Test
    void test() {
        assertEquals(r.who(), State.RESELLER);
    }
 // Checks that next cycle the streamer is correct
 	@Test
 	public void next_StreamerCellRow_2() throws FileNotFoundException {
 		Town town = new Town("/Users/cadebradford/Desktop/cs228/hw1/src/edu/iastate/cs228/ISP4x4.txt");
 		
 		assertEquals(2, town.grid[2][1].next(town).row);
 	}
    }
