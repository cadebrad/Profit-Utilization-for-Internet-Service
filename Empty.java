package edu.iastate.cs228;
/**
 *  @author Cade Bradford
 *	Empty test
 */
public class Empty extends TownCell{

	public Empty(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		// TODO Auto-generated method stub
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town townNew) {
		int nCensus[] = new int[NUM_CELL_TYPE]; 
		census(nCensus);
		nCensus[EMPTY]--;
		if (nCensus[EMPTY] + nCensus[OUTAGE] <= 1) {
				return new Reseller(townNew, row, col);
		}
		else
		{
			return new Casual(townNew, row, col);
		}
	}

}
