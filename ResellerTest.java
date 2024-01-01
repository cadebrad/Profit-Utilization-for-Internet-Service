package edu.iastate.cs228;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 *  @author Cade Bradford
 *	Reseller Tests
 */
public class ResellerTest {

    @Test
    //tests that reseller will leave
    public void test() {
        Town t = new Town(2,2);
        t.grid[0][0] = new Reseller(t,0,0);
        t.grid[0][1] = new Casual(t,0,1);
        t.grid[1][0] = new Casual(t,1,0);
        t.grid[1][1] = new Casual(t,1,1);
        assertEquals(State.EMPTY, t.grid[0][0].next(t).who());
    }

}
