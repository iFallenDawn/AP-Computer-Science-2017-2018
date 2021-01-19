// Jordan Wang
// Calculator Object
// Spec: Uses PEMDAS to calculate the result of an equation given user input.

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Calculator
{
	private ArrayList<String> equation;
	private ArrayList<String> operators;
	private ArrayList<Double> nums;
	private String input;
	private String[] eq;
	public Calculator()
	{
		equation = new ArrayList<String>();
		operators = new ArrayList<String>();
		nums = new ArrayList<Double>();
		eq = new String[10];
		input = "";
	}

	public Calculator(String in)
	{
		equation = new ArrayList<String>();
		operators = new ArrayList<String>();
		nums = new ArrayList<Double>();
		input = in;
		eq = input.split(" ");
	}

	//Gets the inverse
	public String getInverse(String in)
	{
		double inverse = 1.0/(Double.parseDouble(in));
		return "" + String.format("%.2f",inverse);
	}

	//Gets the number squared
	public String getSquared(String in)
	{
		double squared = Math.pow(Double.parseDouble(in), 2);
		return "" + String.format("%.2f",squared);
	}

	//Gets the square root of the number
	public String getSqrt(String in)
	{
		double root = Math.sqrt(Double.parseDouble(in));
		return "" + String.format("%.2f",root);
	}

	//Raises the base of a number to a specified power
	public String toPowerOf(String in)
	{
		int index = in.indexOf("^");
		double base = Double.parseDouble(in.substring(0, index));
		double exponent = Double.parseDouble(in.substring(index+1));
		return "" + String.format("%.2f", Math.pow(base, exponent));
	}

	public double getResult()
	{
		double result;
		//Adds each part of array eq to the equation arraylist
		for(int i = 0; i < eq.length; i++)
		{
			equation.add(eq[i]);
		}
		//Adds the numbers and operators into separate arraylists
		for(int i = 0; i < eq.length; i++)
		{
			if(i%2 == 0)
			{
				nums.add(Double.parseDouble(eq[i]));
			}
			else
			{
				operators.add(eq[i]);
			}
		}
		//Multiplication and division logic, checks for either one of these symbols, does the calculations, then removes the part of the equation used.
		for(int i = 0; i < equation.size(); i++)
		{
			if(equation.size() > 1)
			{
				if(equation.get(i).equals("*"))
				{
					equation.set(i-1, "" + (Double.parseDouble(equation.get(i-1)) * (Double.parseDouble(equation.get(i+1)))));
					equation.remove(i);
					equation.remove(i);
					//System.out.print("*: " + equation + "\n");
					i = 0;
				}
				if(equation.get(i).equals("/"))
				{
					equation.set(i-1, "" + (Double.parseDouble(equation.get(i-1)) / (Double.parseDouble(equation.get(i+1)))));
					equation.remove(i);
					equation.remove(i);
					//System.out.print("/: " + equation + "\n");
					i = 0;
				}
			}
		}
		//Addition and subtraction logic, checks for either one of these symbols, does the calculations, then removes the part of the equation used.
		for(int i = 0; i < equation.size(); i++)
		{
			if(equation.size() > 1)
			{
				if(equation.get(i).equals("+"))
				{
					equation.set(i-1, "" + (Double.parseDouble(equation.get(i-1)) + (Double.parseDouble(equation.get(i+1)))));
					equation.remove(i);
					equation.remove(i);
					//System.out.print("+: " + equation + "\n");
					i = 0;
				}
				if(equation.get(i).equals("-"))
				{
					equation.set(i-1, "" + (Double.parseDouble(equation.get(i-1)) - (Double.parseDouble(equation.get(i+1)))));
					equation.remove(i);
					equation.remove(i);
					//System.out.print("-: " + equation + "\n");
					i = 0;
				}
			}
		}
		result = Double.parseDouble(equation.get(0));
		return result;
	}



	public String toString()
	{
		double number = getResult();
		String result = "";
		//result+= "Equation : " + input + "\n";
		//result+= "Numbers : " + nums + "\n";
		//result+= "Operators : " + operators + "\n";
		result+= String.format("%.2f",number);
		return result;
	}
}