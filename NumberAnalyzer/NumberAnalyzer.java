// Name:
// Prog:
// Spec:

import java.util.ArrayList;
import java.util.Scanner;

public class NumberAnalyzer
{
	private ArrayList<Number> list;

	public NumberAnalyzer()
	{
		list = new ArrayList<Number>();
	}

	public NumberAnalyzer(String numbers)
	{
		setList(numbers);
	}

	public void setList(String numbers)
	{
		String[]nums = numbers.split(" ");
		for(int i = 0; i < nums.length; i++)
		{
			list.add(new Number(Integer.parseInt(nums[i])));
		}
	}

	public int countOdds()
	{
      	int oddCount=0;
		for(int i = 0; i < list.size; i++)
		{
			if(list.get[i].isOdd() == true)
			{
				oddCount++;
			}
		{
      	return oddCount;
	}

	public int countEvens()
	{
      	int evenCount=0;
		for(int i = 0; i < list.size; i++)
		{
			if(list.get[i].isOdd() == false)
			{
				evenCount++;
			}
		{
      	return evenCount;
	}

	public int countPerfects()
	{
		int perfectCount=0;



      	return perfectCount;
	}

	public int countPrimes()
	{
		return 6;
	}

	public String toString()
	{
		return "";
	}
}