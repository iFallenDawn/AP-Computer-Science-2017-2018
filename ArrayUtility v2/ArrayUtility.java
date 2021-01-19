//Jordan Wang
//Array Utility
//Spec: Utility File to practice working with arrays

public class ArrayUtility
{
	/** Calculates and returns the sum of the nums array
	*   @param nums the int array to be added
	*   @return the sum of the nums array */
	//  Note: We have two versions of getSum - this is an example of Method Overloading
	// 			They have different signatures - the type and / or sequence of parameters
	public static int getSum(int[] nums)
	{
		int sum = 0;
		for(int i = 0; i < nums.length; i++)
		{
			sum+=nums[i];
		}
		return sum;
	}

	/** Calculates and returns the sum of the nums array
	*   @param nums the double array to be added
	*	@return the sum of the nums array*/
	public static double getSum(double[] nums)
	{
		double sum = 0;
		for(int i = 0; i < nums.length; i++)
		{
			sum+= nums[i];
		}
		return sum;
	}

	/** Calculates and returns the product of the nums array
	*   @param nums the int array to create a product from
	*	@return the product of each element in the nums array */
	public static long getProduct(int[] nums)
	{
		long product = 1;
		for(int i = 0; i < nums.length; i++)
		{
			product*= nums[i];
		}
		return product;
	}

	/** Builds and returns a reverse order version of the nums array
	*   @param nums the int array to be added
	*	@return a reverse order version of the nums array */
	public static int[] reverseArray(int[] nums)
	{
		int[] reverse = new int[nums.length];
		int position = 0;
		for(int i = nums.length - 1 ; i > -1; i--)
		{
			reverse[position] = nums[i];
			position++;
		}
		return reverse;
	}

	/** Searches the nums array for the maximum value
	*   @param nums the array to be searched
	*	@return the maximum value in the array */
	public static int findMax(int[] nums)
	{
		int max = nums[0];
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] > max)
				max = nums[i];
		}
		return max;
	}

	/** Searches the nums array for the minimum value
	*   @param nums the array to be searched
	*	@return the minimum value in the array */
	public static int findMin(int[] nums)
	{
		int min = nums[0];
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] < min)
				min = nums[i];
		}
		return min;
	}

	/** Searches the String word for an occurence of the target char
	*   @param word the String to be searched
	*	@param target the char to search for
	*	@return true if the target char is found, false otherwise */
	public static boolean contains(String word, char target)
	{
		boolean contains = false;
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) == target)
			{
				contains = true;
				i = word.length();
			}
		}
		return contains;
	}

	/** Searches the nums array for an occurence of the int target
	*   @param nums the array to be searched
	*	@param target the int to search for
	*	@return true if the target int is found, false otherwise */
	public static boolean contains(int[] nums, int target)
	{
		boolean contains = false;
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] == target)
			{
				contains = true;
				i = nums.length;
			}
		}
		return contains;
	}

	/** "poor-mans Encryption"... add 44 to the ascii value of each char in a String
	*   @param word the String to be encrypted
	*	@return an 'encrypted' version of the original String */
	public static String pmEncrypt(String word)
	{
		String result = "";
		int ascii;
		for(int i = 0; i < word.length(); i++)
		{
			ascii = (int) word.charAt(i);
			result+= (char)(ascii + 44);
		}
		return result;
	}

	/** Reverses the pmEncrypt process... builds a new String by subtacting 44 from each char value in an encrypted String
	*   @param word a pmEncrypted String
	*	@return a 'decrypted' version of the pmEncrypted String */
	public static String pmDecrypt(String word)
	{
		String result = "";
		int ascii;
		for(int i = 0; i < word.length(); i++)
		{
			ascii = (int) word.charAt(i);
			result+= (char)(ascii - 44);
		}
		return result;
	}

	/**	@return whether there are two integers in the list that add up to 0.
	*	For example, you would return true if both -14435 and 14435 are in the list,
	*	because -14435 + 14435 = 0. Also return true if 0 appears in the list.
	*/
	public static boolean hasZeroSumInSet(int[] nums)
	{
		boolean hasZero = false;
		for(int i = 0; i < nums.length; i++)
		{
			for(int j = i+1; j < nums.length -1; j++)
			{
				if((nums[i]) + (nums[j]) == 0 || nums[i] == 0)
				{
					hasZero = true;
					i = nums.length;
				}
			}
		}
		return hasZero;
	}

	/** Formats an array of Strings for console output with tabs (\t) in-between each value*/
	// Note: Arrays have a built-in 'toString() method that does a decent job of this already
	public static String arrayToString(int[] nums)
	{
		String result = "";
		for(int i = 0; i < nums.length; i++)
		{
			result+= nums[i] + "\t";
		}
		return result;
	}

	/** Formats an array of Strings for console output with tabs (\t) in-between each value*/
	// Note: Arrays have a built-in 'toString() method that does a decent job of this already
	//		 but we are not looking to use it here.
	public static String arrayToString(double[] nums)
	{
		String result = "";
		for(int i = 0; i < nums.length; i++)
		{
			result+= nums[i] + "\t";
		}
		return result;
	}
}