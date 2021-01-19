// Jordan Wang
// Walk Object
// Spec: A ton of brute force logic for this acsl program

public class Walk
{
	private int locRow;
	private int locColumn;
	private int[][] board;
	private String[] input;
	public Walk()
	{
		board = new int[8][8];
		input = null;
		locRow = 0;
		locColumn = 0;
	}
	public Walk(String input)
	{
		this.input = input.split(", ");
		board = new int[8][8];
		locRow = 0;
		locColumn = 0;
	}
	public void setBoard(String input)
	{
		String []temp = input.split(", ");
		String octal = "";
		int row = 7;
		for(int i = 0; i < temp.length; i++)
		{
			octal = Integer.toOctalString(Integer.parseInt(temp[i], 16));
			for(int c = 0; c < octal.length(); c++)
			{
				//System.out.println(octal.substring(c, c+1));
				int num = Integer.parseInt(octal.substring(c, c+1));
				board[row][c] = num;
			}
			row--;
		}
	}
	public void topboundRow()
	{
		if(locRow - 1 < 0)
			locRow = 7;
		else
			locRow = locRow - 1;
	}
	public void botboundRow()
	{
		if(locRow + 1 > 7)
			locRow = 0;
		else
			locRow += 1;
	}
	public void rightboundCol()
	{
		if(locColumn + 1 > 7)
			locColumn = 0;
		else
			locColumn = locColumn + 1;
	}
	public void leftboundCol()
	{
		if(locColumn - 1 < 0)
			locColumn = 7;
		else
			locColumn = locColumn - 1;
	}
	public String toString()
	{
		int degrees = 0;
		locRow = 8 - Integer.parseInt(input[0]);
		locColumn = Integer.parseInt(input[1]) - 1;
		String testing = "" + locRow + locColumn;
		String direction = input[2];
		//an error i realized AFTER doing all the logic
		if(direction.equalsIgnoreCase("A"))
			direction = "T";
		int numTurns = Integer.parseInt(input[3]);
		//System.out.println("Initial Coordinates: " + locRow + ", " + locColumn);
		String result = "";

		/*for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board.length; c++)
			{
				result+=board[r][c] + "\t";
			}
			result+="\n";
		}*/

		while(numTurns > 0)
		{
			degrees = board[locRow][locColumn] * 45;
			//System.out.println("Moving from " + locRow + ", " + locColumn);
			//direction is where it's entering the cell from
			//From the left
			if(direction.equalsIgnoreCase("L"))
			{
				if(degrees == 45)
				{
					//Going up and to the left
					direction = "BR";
					topboundRow();
					leftboundCol();
				}
				else if(degrees == 90)
				{
					//Going up
					direction = "B";
					topboundRow();
				}
				else if(degrees == 135)
				{
					//Going up and to the right
					direction = "BL";
					topboundRow();
					rightboundCol();
				}
				else if(degrees == 180)
				{
					//Going right
					direction = "L";
					rightboundCol();
				}
				else if(degrees == 225)
				{
					//Going down and to the right
					direction = "TL";
					rightboundCol();
					botboundRow();
				}
				else if(degrees == 270)
				{
					//Going down
					direction = "T";
					botboundRow();
				}
				else if(degrees == 315)
				{
					//Going down and to the left
					direction = "TR";
					botboundRow();
					leftboundCol();
				}
			}
			//Entering from the right
			else if(direction.equalsIgnoreCase("R"))
			{
				if(degrees == 45)
				{
					//Going down and to the right
					direction = "TL";
					botboundRow();
					rightboundCol();
				}
				else if(degrees == 90)
				{
					//Going down
					direction = "T";
					botboundRow();
				}
				else if(degrees == 135)
				{
					//Going down and to the left
					direction = "TR";
					botboundRow();
					leftboundCol();
				}
				else if(degrees == 180)
				{
					//Going Left
					direction = "R";
					leftboundCol();
				}
				else if(degrees == 225)
				{
					//Going up and to the left
					direction = "BR";
					leftboundCol();
					topboundRow();
				}
				else if(degrees == 270)
				{
					//Going up
					direction = "B";
					topboundRow();
				}
				else if(degrees == 315)
				{
					//Going up and to the right
					direction = "BL";
					topboundRow();
					rightboundCol();
				}
			}
			//Entering from top
			else if(direction.equalsIgnoreCase("T"))
			{
				if(degrees == 45)
				{
					//Going up and to the right
					direction = "BL";
					topboundRow();
					rightboundCol();
				}
				else if(degrees == 90)
				{
					//Going right
					direction = "L";
					rightboundCol();
				}
				else if(degrees == 135)
				{
					//Going down and to the right
					direction = "TL";
					botboundRow();
					rightboundCol();
				}
				else if(degrees == 180)
				{
					//Going down
					direction = "T";
					botboundRow();
				}
				else if(degrees == 225)
				{
					//Going down and to the left
					direction = "TR";
					leftboundCol();
					botboundRow();
				}
				else if(degrees == 270)
				{
					//Going left
					direction = "R";
					leftboundCol();
				}
				else if(degrees == 315)
				{
					//Going up and to the left
					direction = "BR";
					topboundRow();
					leftboundCol();
				}
			}
			//entering from the bottom
			else if(direction.equalsIgnoreCase("B"))
			{
				if(degrees == 45)
				{
					//Going down and to the left
					direction = "TR";
					botboundRow();
					leftboundCol();
				}
				else if(degrees == 90)
				{
					//Going left
					direction = "R";
					leftboundCol();
				}
				else if(degrees == 135)
				{
					//Going up and to the left
					direction = "BR";
					topboundRow();
					leftboundCol();
				}
				else if(degrees == 180)
				{
					//Going up
					direction = "B";
					topboundRow();
				}
				else if(degrees == 225)
				{
					//Going up and to the right
					direction = "BL";
					rightboundCol();
					topboundRow();
				}
				else if(degrees == 270)
				{
					//Going right
					direction = "L";
					rightboundCol();
				}
				else if(degrees == 315)
				{
					//Going down and to the right
					direction = "TL";
					botboundRow();
					rightboundCol();
				}
			}
			//entering from the bottom left
			else if(direction.equalsIgnoreCase("BL"))
			{
				if(degrees == 45)
				{
					//Going left
					direction = "R";
					leftboundCol();
				}
				else if(degrees == 90)
				{
					//Going up and to the left
					direction = "BR";
					leftboundCol();
					topboundRow();
				}
				else if(degrees == 135)
				{
					//Going up
					direction = "B";
					topboundRow();
				}
				else if(degrees == 180)
				{
					//Going up and to the right
					direction = "BL";
					topboundRow();
					rightboundCol();
				}
				else if(degrees == 225)
				{
					//Going to the right
					direction = "L";
					rightboundCol();
				}
				else if(degrees == 270)
				{
					//Going down and to the right
					direction = "TL";
					rightboundCol();
					botboundRow();
				}
				else if(degrees == 315)
				{
					//Going down
					direction = "T";
					botboundRow();
				}
			}
			//entering from the bottom right
			else if(direction.equalsIgnoreCase("BR"))
			{
				if(degrees == 45)
				{
					//Going down
					direction = "T";
					botboundRow();
				}
				else if(degrees == 90)
				{
					//Going down and to the left
					direction = "TR";
					leftboundCol();
					botboundRow();
				}
				else if(degrees == 135)
				{
					//Going left
					direction = "R";
					leftboundCol();
				}
				else if(degrees == 180)
				{
					//Going up and to the left
					direction = "BR";
					topboundRow();
					leftboundCol();
				}
				else if(degrees == 225)
				{
					//Going up
					direction = "B";
					topboundRow();
				}
				else if(degrees == 270)
				{
					//Going up and to the right
					direction = "BL";
					rightboundCol();
					topboundRow();
				}
				else if(degrees == 315)
				{
					//Going right
					direction = "L";
					rightboundCol();
				}
			}
			//entering from the top right
			else if(direction.equalsIgnoreCase("TR"))
			{
				if(degrees == 45)
				{
					//Going right
					direction = "L";
					rightboundCol();
				}
				else if(degrees == 90)
				{
					//Going down and to the right
					direction = "TL";
					rightboundCol();
					botboundRow();
				}
				else if(degrees == 135)
				{
					//Going down
					direction = "T";
					botboundRow();
				}
				else if(degrees == 180)
				{
					//Going down and to the left
					direction = "TR";
					botboundRow();
					leftboundCol();
				}
				else if(degrees == 225)
				{
					//Going left
					direction = "R";
					leftboundCol();
				}
				else if(degrees == 270)
				{
					//Going up and to the left
					direction = "BR";
					topboundRow();
					leftboundCol();
				}
				else if(degrees == 315)
				{
					//Going up
					direction = "B";
					topboundRow();
				}
			}
			//entering from top left
			else if(direction.equalsIgnoreCase("TL"))
			{
				if(degrees == 45)
				{
					//Going up
					direction = "B";
					topboundRow();
				}
				else if(degrees == 90)
				{
					//Going up and to the right
					direction = "BL";
					rightboundCol();
					topboundRow();
				}
				else if(degrees == 135)
				{
					//Going right
					direction = "L";
					rightboundCol();
				}
				else if(degrees == 180)
				{
					//Going down and to the right
					direction = "TL";
					botboundRow();
					rightboundCol();
				}
				else if(degrees == 225)
				{
					//Going down
					direction = "T";
					botboundRow();
				}
				else if(degrees == 270)
				{
					//Going down and to the left
					direction = "TR";
					leftboundCol();
					botboundRow();
				}
				else if(degrees == 315)
				{
					//Going left
					direction = "R";
					leftboundCol();
				}
			}
			numTurns--;
			//System.out.println("Degrees: " + degrees);
			//System.out.println("Direction entered from: " + direction);
			//System.out.println("New coordinates: " + locRow + ", " + locColumn+ "\n");
			//System.out.println("Turns left: " + numTurns + "");
		}
		result += (8 - locRow) + ", " + (locColumn + 1) + "\n";
		return result;
	}
}