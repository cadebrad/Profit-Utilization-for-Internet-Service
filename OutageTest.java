package edu.iastate.cs228;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 *  @author Cade Bradford
 *	outage tests
 */
public class OutageTest {

    @Test
    public void test() {
        Town t = new Town(2,2);
        t.grid[0][0] = new Outage(t,0,0);
        t.grid[0][1] = new Reseller(t,0,1);
        t.grid[1][0] = new Empty(t,1,0);
        t.grid[1][1] = new Empty(t,1,1);
        assertEquals(State.EMPTY, t.grid[0][0].next(t).who());
    }

}
