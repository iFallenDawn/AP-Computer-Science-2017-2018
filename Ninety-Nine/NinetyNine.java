//Jordan Wang

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class NinetyNine
{
	private int total;
	private String input;
	private String[] nums;
	private ArrayList<Integer> faceDown;
	private ArrayList<Integer> P1Cards;
	private ArrayList<Integer> P2Cards;
	public NinetyNine()
	{
		total = 0;
		input = "";
		nums = new String[10];
		faceDown = new ArrayList<Integer>();
		P1Cards = new ArrayList<Integer>();
		P2Cards = new ArrayList<Integer>();
	}

	public NinetyNine(String input)
	{
		faceDown = new ArrayList<Integer>();
		P1Cards = new ArrayList<Integer>();
		P2Cards = new ArrayList<Integer>();
		nums = assignNums(input);
		/*for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");*/
	}

	//Sets the initial hands of each player
	public void setInitial(String input)
	{
		String[] tempNums = new String[10];
		tempNums = assignNums(input);
		for(int i = 0; i < tempNums.length; i++)
		{
			if(i < 5)
				P1Cards.add(Integer.parseInt(tempNums[i]));
			else
				P2Cards.add(Integer.parseInt(tempNums[i]));
		}
	}

	//Replaces all the face cards and ten with number values
	public String[] assignNums(String input)
	{
		int size = 0;
		String[] temp = input.split(", ");
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i].equals("T"))
				temp[i] = "10";
			else if(temp[i].equals("J"))
				temp[i] = "11";
			else if(temp[i].equals("Q"))
				temp[i] = "12";
			else if(temp[i].equals("K"))
				temp[i] = "13";
			else if(temp[i].equals("A"))
				temp[i] = "14";
		}
		if(temp.length == 11)
			size = 11;
		else if(temp.length == 10)
			size = 10;
		String[] result = new String[size];
		for(int i = 0; i < temp.length; i++)
		{
			result[i] = temp[i];
		}
		return result;
	}

	//Calculates the total and covers 3/4 of the conditions
	public int calculateTotal(int initialT, int card)
	{
		//33:34
		if(initialT <= 33 && initialT + card >= 34)
		{
			return initialT + card + 5;
		}
		else if(initialT >= 34 && initialT + card <= 33)
		{
			return initialT + card + 5;
		}
		//55:56
		else if(initialT <= 55 && initialT + card >= 56)
		{
			return initialT + card + 5;
		}
		else if(initialT >= 56 && initialT + card <= 55)
		{
			return initialT + card + 5;
		}
		//77:78
		else if(initialT <= 77 && initialT + card >= 78)
		{
			return initialT + card + 5;
		}
		else if(initialT >= 78 && initialT + card <= 77)
		{
			return initialT + card + 5;
		}
		else
		{
			return initialT + card;
		}
	}


	public String toString()
	{
		String result = "";
		String winner = "";
		boolean P1Turn = true;
		boolean gameOver = false;
		int p1Play = 0;
		int p2Play = 0;
		for(int i = 0; i < nums.length; i++)
		{
			faceDown.add(Integer.parseInt(nums[i]));
		}
		Collections.sort(P1Cards);
		Collections.sort(P2Cards);
		if(faceDown.isEmpty() == false)
		{
			total = faceDown.get(0);
			faceDown.remove(0);
		}
		/*Code used to see what's in each arraylist, and the total
		result+= "Player 1 Cards: " + P1Cards + "\n";
		/result+= "Player 2 Cards: " + P2Cards + "\n";
		result+= "Face Down Cards: " + faceDown + "\n";
		result+= "Total: " + total + "\n";*/
		//All the logic
		while(total < 100)
		{
			//Player 1's Turn
			while(P1Turn == true && gameOver == false)
			{
				p1Play = P1Cards.get(2);
				if(p1Play == 9)
				{
					P1Turn = false;
				}
				else if(p1Play == 10)
				{
					total = calculateTotal(total, -10);
				}
				else if(p1Play == 7)
				{
					if(total + 7 < 100)
					{
						total = calculateTotal(total, 7);
					}
					else
					{
						total = calculateTotal(total, 1);
					}
				}
				else
				{
					total = calculateTotal(total, p1Play);
				}
				//System.out.println("Player 1 Cards Before: " + P1Cards);
				P1Cards.remove(2);
				//System.out.println("Player 1 played a " + p1Play);
				//System.out.println("Face down before: " + faceDown);
				if(faceDown.isEmpty() == false)
				{
					P1Cards.add(2, faceDown.get(0));
					faceDown.remove(0);
				}
				//System.out.println("Face down after: " + faceDown);
				Collections.sort(P1Cards);
				//System.out.println("Player 1 Cards After: " + P1Cards);
				//System.out.println("Total: " + total + "\n");
				P1Turn = false;
				if(total > 99)
				{
					winner = "Player #2\n";
					gameOver = true;
				}
			}
			//Player 2's Turn
			while(P1Turn == false && gameOver == false)
			{
				p2Play = P2Cards.get(2);
				if(p2Play == 9)
				{
					P1Turn = true;
				}
				else if(p2Play == 10)
				{
					total = calculateTotal(total, -10);
				}
				else if(p2Play == 7)
				{
					if(total + 7 < 100)
					{
						total = calculateTotal(total, 7);
					}
					else
					{
						total = calculateTotal(total, 1);
					}
				}
				else
				{
					total = calculateTotal(total, p2Play);
				}
				//System.out.println("Player 2 Cards Before: " + P2Cards);
				P2Cards.remove(2);
				//System.out.println("Player 2 played a " + p2Play);
				//System.out.println("Face down before: " + faceDown);
				if(faceDown.isEmpty() == false)
				{
					P2Cards.add(2, faceDown.get(0));
					faceDown.remove(0);
				}
				//System.out.println("Face down after: " + faceDown);
				Collections.sort(P2Cards);
				//System.out.println("Player 2 Cards After: " + P2Cards);
				//System.out.println("Total: " + total  + "\n");
				P1Turn = true;
				if(total > 99)
				{
					winner = "Player #1\n";
					gameOver = true;
				}
			}
		}
		result+= total + ", " + winner;
		return result;
	}
}