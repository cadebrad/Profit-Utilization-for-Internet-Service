package edu.iastate.cs228;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 *  @author Cade Bradford
 *	Town Tests
 */
class TownTest {
	Town t;

    
    @Test
    public void testLength()
    {
    	t = new Town(3, 3);
		t.randomInit(5);
    	assertEquals(3, t.getLength());
    }
    
    @Test
    public void testWidth()
    {
    	t = new Town(3, 3);
		t.randomInit(5);
    	assertEquals(3, t.getWidth());
    }
	}

