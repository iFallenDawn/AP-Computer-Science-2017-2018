// Name: Jordan Wang
// Prog: Number Object
// Spec: Determines if a number is odd, not odd, or perfect

public class Number
{
	private Integer number;

	public Number()
	{
		number = 0;
	}

	public Number(int num)
	{
		number = num;
	}

	public void setNumber(int num)
	{
		number = num;
	}

	public int getNumber()
	{
		return number;
	}

	public boolean isOdd()
	{
		if(number%2!=0)
			return false;
		else
			return true;
	}

	public boolean isPerfect()
	{
		int total=0;
		for(int i = 0; i < number; i++)
		{
			if(number%i == 0)
				total+=i;
		}
		return (number==total);
	}

	public boolean isPrime()
	{
		for(int i = 2; i < number; i++)
		{
			if(number%i==0)
			{
				return false;
			}
		}
		return true;
	}

	public String toString()
	{
		return "" + getNumber();
	}
}