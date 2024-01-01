package edu.iastate.cs228;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;



/**
 *  @author Cade Bradford
 *	Town represents the area in which the TownCells are inside they are inside of a 2d grid
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];
	}
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		File f = new File(inputFileName);
        Scanner input = new Scanner(f); 
        this.length = input.nextInt();
        this.width = input.nextInt();
        grid = new TownCell[length][width];
        input.nextLine();
     //nested for loop to iterate through file
        for (int i = 0; i < length; i++) {
            String[] arr = input.nextLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                switch (arr[j]) {
                case "R":
                    grid[i][j] = new Reseller(this,i,j);
                    break;
                case "E":
                    grid[i][j] = new Empty(this,i,j);
                    break;
                case "C":
                    grid[i][j] = new Casual(this,i,j);
                    break;
                case "O":
                    grid[i][j] = new Outage(this,i,j);
                    break;
                case "S":
                    grid[i][j] = new Streamer(this,i,j);
                    break;
                case "R\t":
                    grid[i][j] = new Reseller(this,i,j);
                    break;
                case "E\t":
                    grid[i][j] = new Empty(this,i,j);
                    break;
                case "C\t":
                    grid[i][j] = new Casual(this,i,j);
                    break;
                case "O\t":
                    grid[i][j] = new Outage(this,i,j);
                    break;
                case "S\t":
                    grid[i][j] = new Streamer(this,i,j);
                    break;
                default:
                    break;
                }
            }
        }
        input.close();
	}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		
		return width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		//nested for loop to randomize each cell one by one
		for(int j = 0; j<length; j++) {
			for(int i = 0; i <width; i++) {
				int randNum = rand.nextInt(5);
				TownCell cell = null;
				switch(randNum) {
				case 0:
					cell = new Casual(this,j,i);
					break;
				case 1:
					cell = new Empty(this,j,i);
					break;
				case 2:
					cell = new Outage(this,j,i);
					break;
				case 3: 
					cell = new Reseller(this,j,i);
					break;
				case 4:
					cell = new Streamer(this,j,i);
					break;
				}
				grid[j][i]=cell;
		}
		}
	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		//nested for loop
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < length; y++)
			{
				s += grid[x][y].who().toString().charAt(0) + " ";
			}
			s += "\n";

		}
		return s;
	}
}
