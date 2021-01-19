//Jordan Wang

import java.util.Scanner;

public class WalkRunner
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Walk w = new Walk();
		String input = "";
		String initial = "";
		boolean firstLine = true;
		for(int i = 0; i < 6; i++)
		{
			if(firstLine == true)
			{
				initial = sc.nextLine();
				w.setBoard(initial);
				firstLine = false;
			}
			else
			{
				input = sc.nextLine();
				w = new Walk(input);
				w.setBoard(initial);
				System.out.println(w);
			}
		}
	}
}
// 4F9D39, DEB456, 3DA8B9, A57CA7, 26A84A, 2FCFA3, 3AAB09, 89CBF5
// 1, 2, L, 2				2, 4
// 5, 3, A, 4				6, 4
// 3, 5, B, 2				4, 6
// 6, 7, R, 5				8, 7
// 4, 7, L, 6				3, 7