// Jordan Wang
// WalkRunner
// Spec: I'm a genius

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
		for(int i = 0; i < 50; i++)
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
/*ACSL given test cases
4F9D39, DEB456, 3DA8B9, A57CA7, 26A84A, 2FCFA3, 3AAB09, 89CBF5
	1, 2, L, 2				2, 4
	5, 3, A, 4				6, 4
	3, 5, B, 2				4, 6
	6, 7, R, 5				8, 7
	4, 7, L, 6				3, 7
*/

/*These coordinates are all in the dumb format they use, where (1, 1) is the bottom left corner.
eli's all 4 board
924924, 924924, 924924, 924924, 924924, 924924, 924924, 924924
	8, 8, L, 5				8, 5
	8, 8, B, 5				5, 8
	1, 8, A, 5				4, 8
	1, 8, L, 5				1, 5
	8, 1, B, 5				5, 1
	8, 1, R, 5				8, 4
	1, 1, A, 5				4, 1
	1, 1, R, 5				1, 4
*/

/*eli's all 5 board
B6DB6D, B6DB6D, B6DB6D, B6DB6D, B6DB6D, B6DB6D, B6DB6D, B6DB6D
8, 8, L, 5				6, 6
*/

/*some random board i came up with
3CA372, 8A6DBC, 4B979B, D975EB, A9A4EA, EA76B1, D2A2AB, F3C30F
Entering from Above
	1, 8, A, 5				4, 6
	1, 1, A, 5				2, 6
	8, 1, A, 1				1, 8
	2, 6, A, 6				5, 4
	1, 7, A, 3				3, 6
	7, 3, A, 4				6, 4
	6, 5, A, 6				3, 2
	3, 8, A, 8				4, 4
	4, 3, A, 7				6, 8
	3, 2, A, 6				2, 4
Entering from Below
	8, 8, B, 5				4, 1
	1, 1, B, 1				8, 8
	8, 1, B, 5				7, 5
	5, 5, B, 4				5, 2
	2, 5, B, 4				8, 6
	8, 6, B, 7				2, 7
	4, 1, B, 9				1, 3
	3, 4, B, 8				4, 8
	5, 1, B, 6				2, 3
	6, 2, B, 5				6, 2
Entering from Left
	8, 8, L, 5				5, 7
	1, 8, L, 5				6, 8
	2, 3, L, 9				6, 4
	5, 2, L, 7				5, 3
	3, 5, L, 6				3, 4
	6, 7, L, 5				6, 4
	8, 5, L, 6				8, 8
	1, 6, L, 5				3, 8
	8, 4, L, 6				7, 1
	3, 8, L, 4				5, 2
Entering from Right
	8, 1, R, 5				6, 3
	1, 1, R, 5				4, 4
	4, 6, R, 6				4, 5
	3, 2, R, 7				3, 5
	5, 3, R, 5				6, 3
	6, 1, R, 4				6, 2
	8, 7, R, 6				8, 6
	3, 5, R, 3				3, 4
	2, 8, R, 6				6, 8
	7, 3, R, 6				8, 8
*/