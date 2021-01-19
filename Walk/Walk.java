
public class Walk
{
	private int[][] board;
	private String[] input;
	public Walk()
	{
		board = new int[8][8];
		input = null;
	}
	public Walk(String input)
	{
		this.input = input.split(", ");
		board = new int[8][8];
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
	public boolean checkBounds(int row, int column)
	{
		return false;
	}
	public String toString()
	{
		int degrees = 0;
		int locRow = 8 - Integer.parseInt(input[0]);
		int locColumn = Integer.parseInt(input[1]) - 1;
		String testing = "" + locRow + locColumn;
		String direction = input[2];
		int numTurns = Integer.parseInt(input[3]);
		System.out.println("" + locRow + locColumn);
		String result = "";

		/*for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board.length; c++)
			{
				result+=board[r][c] + "\t";
			}
			result+="\n";
		}*/
		while(numTurns != 0)
		{
			degrees = board[locRow][locColumn] * 45;
			if(direction.equalsIgnoreCase("L"))
			{
				if(degrees == 45)
				{

				}
				else if(degrees == 90)
				{

				}
				else if(degrees == 135)
				{

				}
				else if(degrees == 180)
				{

				}
				else if(degrees == 225)
				{

				}
				else if(degrees == 270)
				{

				}
				else if(degrees == 315)
				{

				}
			}
			numTurns--;
		}
		return result;
	}
}