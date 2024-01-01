package edu.iastate.cs228;
/**
 *  @author Cade Bradford
 *State streamer with properties of streamer
 */

public class Streamer extends TownCell {

	public Streamer(Town p, int r, int c) {
		super(p, r, c);
		
	}

	@Override
	public State who() {
		
		return State.STREAMER;
	}

	@Override
	public TownCell next(Town tNew) {
		 int[] nCensus = new int[5];

	        census(nCensus);

	        if(nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3)
	        {
	            return new Empty(tNew,row,col);
	        }
	        if(nCensus[CASUAL] >= 5)
	        {
	            return new Streamer(tNew,row,col);
	        }
	        else {

	            return new Reseller(tNew,row,col);
	        }
	}

}
