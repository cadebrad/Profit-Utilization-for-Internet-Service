package edu.iastate.cs228;
/**
 *  @author Cade Bradford
 *	Represents casual TownCell
 */
public class Casual extends TownCell {
	public Casual(Town p, int r, int c) {
		super(p, r, c);
	}

	@Override
	public State who() {
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town townNew) {
		int nCensus[] = new int[NUM_CELL_TYPE]; 
		census(nCensus);
		nCensus[CASUAL]--;
		if (nCensus[EMPTY] + nCensus[OUTAGE] <= 1) {
			return new Reseller(townNew, row, col);
		}
		else if (nCensus[RESELLER] > 0)
		{
			return new Outage(townNew, row, col);
		}
		
		else if (nCensus[STREAMER] > 0)
		{
			return new Streamer(townNew, row, col);
		}
		else if (nCensus[CASUAL] >= 5) {
			return new Streamer(townNew, row, col);
		}
		else
		{
			return new Casual(townNew, row, col);
		}
	}
}
