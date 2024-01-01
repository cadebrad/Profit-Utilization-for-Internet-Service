package edu.iastate.cs228;
/**
 *  @author Cade Bradford
 *	Represents a reseller for a towncell
 */
public class Reseller extends TownCell {
	
	public Reseller(Town p, int r, int c) {
		super(p, r, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public State who() {
		// TODO Auto-generated method stub
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew) {
		int nCensus[] = new int[NUM_CELL_TYPE]; 
		census(nCensus);
		nCensus[RESELLER]--;

		if (nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3)
		{
			return new Empty(tNew, row, col);
		}
		
		else
		{
			return new Reseller(tNew, row, col);
		}
	}
}
