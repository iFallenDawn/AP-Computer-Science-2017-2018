// Jordan Wang
// Calculator Runner
// Spec: Runs calculator object

public class CalculatorRunner
{
	public static void main(String args[])
	{
		Calculator c = new Calculator();
		c = new Calculator("12 + 5 - 6 / 2 * 4 + 3");
		System.out.print(c + "\n\n");
		c = new Calculator("21 / 5 + 2 - 8 * 3 + 2.2");
		System.out.print(c + "\n\n");
		c = new Calculator("5 / 2 * 25 - 10 / 2 * 3.33");
		System.out.print(c + "\n\n");
		c = new Calculator("8.2 - 3.2 * 4 + 7 - 1 * 9 / 3 + 8 - .4");
		System.out.print(c + "\n\n");
	}
}
/*
Equation : 12 + 5 - 6 / 2 * 4 + 3
Numbers : [12.0, 5.0, 6.0, 2.0, 4.0, 3.0]
Operators : [+, -, /, *, +]
Result: 8.00

Equation : 21 / 5 + 2 - 8 * 3 + 2.2
Numbers : [21.0, 5.0, 2.0, 8.0, 3.0, 2.2]
Operators : [/, +, -, *, +]
Result: -15.60

Equation : 5 / 2 * 25 - 10 / 2 * 3.33
Numbers : [5.0, 2.0, 25.0, 10.0, 2.0, 3.33]
Operators : [/, *, -, /, *]
Result: 45.85

Equation : 8.2 - 3.2 * 4 + 7 - 1 * 9 / 3 + 8 - .4
Numbers : [8.2, 3.2, 4.0, 7.0, 1.0, 9.0, 3.0, 8.0, 0.4]
Operators : [-, *, +, -, *, /, +, -]
Result: 7.00

Press any key to continue . . .
*/