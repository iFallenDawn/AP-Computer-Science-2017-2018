//Jordan Wang

import java.util.Scanner;

public class NinetyNineRunner
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		NinetyNine n = new NinetyNine();
		String input = "";
		String initial = "";
		boolean firstLine = true;
		for(int i = 0; i < 6; i++)
		{
			if(firstLine == true)
			{
				initial = sc.nextLine();
				n.setInitial(initial);
				firstLine = false;
			}
			else
			{
				input = sc.nextLine();
				n = new NinetyNine(input);
				n.setInitial(initial);
				System.out.println(n);
			}
		}
	}
}
//8, 9, Q, 6, 7, K, A, 5, 9, 8
//75, J, 7, Q, T, A, 6, 2, 3, 4, 5
//50, 7, K, T, 8, 3, Q, 9, 7, 2, 3
//63, 3, 6, 8, T, 7, 7, T, 3, 5, 8
//79, A, 9, 7, T, A, 9, T, A, 6, 4
