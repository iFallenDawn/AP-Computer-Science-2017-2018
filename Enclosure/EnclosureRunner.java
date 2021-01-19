//Jordan Wang

import java.util.Scanner;

public class EnclosureRunner
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Enclosure e;
		String input;

		for(int i = 0; i < 5; i++)
		{
			input = sc.nextLine();
			e = new Enclosure(input);
			System.out.print(e);
		}
	}
}
//	{[(2+3)*6/10}
//	{[7*25/5+14)*51]+6}
//	{60+[15*(520-505)]/5-23
//	{32*510+(8/4)*2+43]/24}
//	{[(24+900/300*64]}

/*Only parantheses (all good)
3+3)+2
2+(3+3
(3+30+2
30+3)+2
300+3)+2
2+300+3) */

/*Parantheses and bracket (these are the INDEXES you can place them at, not the same as the indexes + 1 like the test cases are)
[(3+3)+2			6, 8
2+(3+3)]			0, 2
[(3+30+2]			2, 8
[30+3)+2]			1
[(300+3)+2			8, 10
[2+300]*3+3)		8
3+3)*[2+300]
(3+3*[2+300]
*/