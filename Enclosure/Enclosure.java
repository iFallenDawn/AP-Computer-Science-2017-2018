//Jordan Wang

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Enclosure implements Enclosable
{
	private String equation;
	private ArrayList<Integer> correctLocations;
	public Enclosure()
	{
		equation = "";
		correctLocations = new ArrayList<Integer>();
	}

	public Enclosure(String input)
	{
		equation = input;
		correctLocations = new ArrayList<Integer>();
	}

	public void getLocations(String eq)
	{
		boolean valid = false;
		String symbol = "";
		String storage = eq;
		String expression = eq;
		//Finds which symbol is missing
		if(hasParen() && hasPairOfParens() == false)
		{
			if(expression.contains(")"))
				symbol = "(";
			else
				symbol = ")";
		}
		if(hasBracket() && hasPairOfBrackets() == false)
		{
			if(expression.contains("]"))
				symbol = "[";
			else
				symbol = "]";
		}
		if(hasBrace() && hasPairOfBraces() == false)
		{
			if(expression.contains("}"))
				symbol = "{";
			else
				symbol = "}";
		}
		for(int i = 0; i < expression.length(); i++)
		{
			if(i == 0)
			{
				expression = symbol + storage.substring(0);
			}
			else
			{
				expression = storage.substring(0, i) + symbol + storage.substring(i);
			}
			//System.out.println("Placed a symbol at " + i);
			valid = checkValidity(expression, symbol);
			if(valid)
			{
				correctLocations.add(i);
				//System.out.println("NICE!");
			}
		}
	}

	public boolean checkValidity(String newExpression, String symb)
	{
		String expressionBound = "";
		String original = newExpression;
		int leftBound = 0;
		int rightBound = 0;
		if(symb.equals("(") || symb.equals(")"))
		{
			leftBound = newExpression.indexOf("(");
			rightBound = newExpression.indexOf(")");
		}
		if(symb.equals("[") || symb.equals("]"))
		{
			leftBound = newExpression.indexOf("[");
			rightBound = newExpression.indexOf("]");
		}
		if(symb.equals("{") || symb.equals("}"))
		{
			leftBound = newExpression.indexOf("{");
			rightBound = newExpression.indexOf("}");
		}

		if(leftBound < rightBound)
		{
			expressionBound = newExpression.substring(leftBound, rightBound+1);
			//System.out.println("Expression w/ Symbol: " + newExpression);
			//System.out.println("Expression Bound: " + expressionBound);
			//System.out.println("Left Bound: " + leftBound);
			//System.out.println("Right Bound: " + rightBound);

			/*Ahead is a huge monstrosity of copy and paste. Be advised (at least it works for all 5 test cases).*/

			//If there are ONLY parantheses in the expression
			if((symb.equals("(") || symb.equals(")")) && (hasBracket() == false && hasBrace() == false))
			{
				if(expressionBound.contains("*") || expressionBound.contains("+") || expressionBound.contains("/") || expressionBound.contains("-"))
				{
					if(!expressionBound.substring(1,2).equals("*") || !expressionBound.substring(1,2).equals("/") || !expressionBound.substring(1,2).equals("+") ||
					!expressionBound.substring(1,2).equals("-"))
					{
						if(expressionBound.substring(1,2).equals("*") || expressionBound.substring(1,2).equals("/") || expressionBound.substring(1,2).equals("+") ||
						expressionBound.substring(1,2).equals("-"))
						{
							return false;
						}
						else
						{
							int boundLength = expressionBound.length();
							if(expressionBound.substring(boundLength-2,boundLength-1).equals("*") || expressionBound.substring(boundLength-2,boundLength-1).equals("/")
							|| expressionBound.substring(boundLength-2,boundLength-1).equals("+") || expressionBound.substring(boundLength-2,boundLength-1).equals("-"))
							{
								return false;
							}
							else
							{
								if(symb.equals("("))
								{
									if(original.indexOf("(") > 0)
									{
										int lIndex = original.indexOf(symb);
										if(original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
										original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-"))
										{
											return true;
										}
										else
										{
											return false;
										}
									}
									else
									{
										return true;
									}
								}
								if(symb.equals(")"))
								{
									if(original.indexOf(")") < original.length() - 1)
									{
										int rIndex = original.indexOf(symb);
										if(original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
										original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-"))
										{
											return true;
										}
										else
										{
											return false;
										}
									}
									else
									{
										return true;
									}
								}
							}
						}
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			//marker
			/*If it has parantheses and brackets but is missing a paranthese
			*/
			if((symb.equals("(") || symb.equals(")") || symb.equals ("[") || symb.equals ("]")) && (hasBracket() == true && hasBrace() == false))
			{
				if(expressionBound.contains("*") || expressionBound.contains("+") || expressionBound.contains("/") || expressionBound.contains("-"))
				{
					if(!expressionBound.substring(1,2).equals("*") || !expressionBound.substring(1,2).equals("/") || !expressionBound.substring(1,2).equals("+") ||
					!expressionBound.substring(1,2).equals("-"))
					{
						if(expressionBound.substring(1,2).equals("*") || expressionBound.substring(1,2).equals("/") || expressionBound.substring(1,2).equals("+") ||
						expressionBound.substring(1,2).equals("-"))
						{
							return false;
						}
						else
						{
							int boundLength = expressionBound.length();
							if(expressionBound.substring(boundLength-2,boundLength-1).equals("*") || expressionBound.substring(boundLength-2,boundLength-1).equals("/")
							|| expressionBound.substring(boundLength-2,boundLength-1).equals("+") || expressionBound.substring(boundLength-2,boundLength-1).equals("-"))
							{
								return false;
							}
							else
							{
								if(symb.equals("("))
								{
									if(expressionBound.contains("[") || expressionBound.contains("]"))
									{
										return false;
									}
									else
									{
										if(original.indexOf("(") > 0)
										{
											int lIndex = original.indexOf(symb);
											if(original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
											original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-") ||
											original.substring(lIndex - 1, lIndex).equals("["))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
										else
										{
											return true;
										}
									}
								}
								if(symb.equals(")"))
								{
									if(expressionBound.contains("[") || expressionBound.contains("]"))
									{
										return false;
									}
									else
									{
										if(original.indexOf(")") < original.length() - 1)
										{
											int rIndex = original.indexOf(symb);
											if(original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
											original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-") ||
											original.substring(rIndex+1, rIndex+2).equals("]"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
										else
										{
											return true;
										}
									}
								}
								if(symb.equals("["))
								{
									if(original.indexOf("[") > 0)
									{
										int lIndex = original.indexOf(symb);
										if(expressionBound.contains(")"))
										{
											if((original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
											original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-")
											|| original.substring(lIndex - 1, lIndex).equals("(")) && expressionBound.contains("("))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
										else
										{
											if(original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
											original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-")
											|| original.substring(lIndex - 1, lIndex).equals("("))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
									}
									else
									{
										return true;
									}
								}
								if(symb.equals("]"))
								{
									if(original.indexOf("]") < original.length() - 1)
									{
										int rIndex = original.indexOf(symb);
										if(expressionBound.contains("("))
										{
											if((original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
											original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-")
											|| original.substring(rIndex+1, rIndex+2).equals(")")) && expressionBound.contains(")"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
										else
										{
											if(original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
											original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-")
											|| original.substring(rIndex+1, rIndex+2).equals(")"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
									}
									else
									{
										return true;
									}
								}
							}
						}
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			//If it has all three symbols
			if(hasBracket() == true && hasBrace() == true && hasParen() == true)
			{
				if(expressionBound.contains("*") || expressionBound.contains("+") || expressionBound.contains("/") || expressionBound.contains("-"))
				{
					if(!expressionBound.substring(1,2).equals("*") || !expressionBound.substring(1,2).equals("/") || !expressionBound.substring(1,2).equals("+") ||
					!expressionBound.substring(1,2).equals("-"))
					{
						if(expressionBound.substring(1,2).equals("*") || expressionBound.substring(1,2).equals("/") || expressionBound.substring(1,2).equals("+") ||
						expressionBound.substring(1,2).equals("-"))
						{
							return false;
						}
						else
						{
							int boundLength = expressionBound.length();
							if(expressionBound.substring(boundLength-2,boundLength-1).equals("*") || expressionBound.substring(boundLength-2,boundLength-1).equals("/")
							|| expressionBound.substring(boundLength-2,boundLength-1).equals("+") || expressionBound.substring(boundLength-2,boundLength-1).equals("-"))
							{
								return false;
							}
							else
							{
								if(symb.equals("("))
								{
									if(expressionBound.contains("[") || expressionBound.contains("]") || expressionBound.contains("{") || expressionBound.contains("}"))
									{
										return false;
									}
									else
									{
										if(original.indexOf("(") > 0)
										{
											int lIndex = original.indexOf(symb);
											if(original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
											original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-") ||
											original.substring(lIndex - 1, lIndex).equals("[") || original.substring(lIndex - 1, lIndex).equals("{"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
										else
										{
											return true;
										}
									}
								}
								if(symb.equals(")"))
								{
									if(expressionBound.contains("[") || expressionBound.contains("]") || expressionBound.contains("{") || expressionBound.contains("}"))
									{
										return false;
									}
									else
									{
										if(original.indexOf(")") < original.length() - 1)
										{
											int rIndex = original.indexOf(symb);
											if(original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
											original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-") ||
											original.substring(rIndex+1, rIndex+2).equals("]") || original.substring(rIndex+1, rIndex+2).equals("}"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
										else
										{
											return true;
										}
									}
								}
								if(symb.equals("["))
								{
									if(expressionBound.contains("}") || expressionBound.contains("{"))
									{
										return false;
									}
									if(original.indexOf("[") > 0)
									{
										int lIndex = original.indexOf(symb);
										if(expressionBound.contains(")"))
										{
											if((original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
											original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-")
											|| original.substring(lIndex - 1, lIndex).equals("(") || original.substring(lIndex - 1, lIndex).equals("{")) && expressionBound.contains("("))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
										else
										{
											if(original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
											original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-")
											|| original.substring(lIndex - 1, lIndex).equals("(")  || original.substring(lIndex - 1, lIndex).equals("{"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
									}
									else
									{
										return true;
									}
								}
								if(symb.equals("]"))
								{
									if(expressionBound.contains("}") || expressionBound.contains("{"))
									{
										return false;
									}
									if(original.indexOf("]") < original.length() - 1)
									{
										int rIndex = original.indexOf(symb);
										if(expressionBound.contains("("))
										{
											if((original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
											original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-")
											|| original.substring(rIndex+1, rIndex+2).equals(")") || original.substring(rIndex+1, rIndex+2).equals("}")) && expressionBound.contains(")"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
										else
										{
											if(original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
											original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-")
											|| original.substring(rIndex+1, rIndex+2).equals(")") || original.substring(rIndex+1, rIndex+2).equals("}"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
									}
									else
									{
										return true;
									}
								}
								if(symb.equals("{"))
								{
									if(original.indexOf("{") > 0)
									{
										int lIndex = original.indexOf(symb);
										if(expressionBound.contains(")"))
										{
											if((original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
											original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-"))
											&& expressionBound.contains("("))
											{
												if(expressionBound.contains("]"))
												{
													if((original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
													original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-"))
													&& expressionBound.contains("["))
													{
														return true;
													}
													else
													{
														return false;
													}
												}
												else
												{
													return true;
												}
											}
											else
											{
												return false;
											}
										}
										else
										{
											if(expressionBound.contains("[") ^ expressionBound.contains("]"))
												return false;
											if(original.substring(lIndex - 1, lIndex).equals("*") || original.substring(lIndex - 1, lIndex).equals("/") ||
											original.substring(lIndex - 1, lIndex).equals("+") || original.substring(lIndex - 1, lIndex).equals("-"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
									}
									else
									{
										return true;
									}
								}
								if(symb.equals("}"))
								{
									if(original.indexOf("}") < original.length() - 1)
									{
										int rIndex = original.indexOf(symb);
										if(expressionBound.contains("("))
										{
											if((original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
											original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-"))
											&& expressionBound.contains(")"))
											{
												if(expressionBound.contains("["))
												{
													if((original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
													original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-"))
													&& expressionBound.contains("]"))
													{
														return true;
													}
													else
													{
														return false;
													}
												}
												else
												{
													return true;
												}
											}
											else
											{
												return false;
											}
										}
										else
										{
											if(expressionBound.contains("[") ^ expressionBound.contains("]"))
												return false;
											if(original.substring(rIndex+1, rIndex+2).equals("*") || original.substring(rIndex+1, rIndex+2).equals("/") ||
											original.substring(rIndex+1, rIndex+2).equals("+") || original.substring(rIndex+1, rIndex+2).equals("-"))
											{
												return true;
											}
											else
											{
												return false;
											}
										}
									}
									else
									{
										return true;
									}
								}
							}
						}
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
		return false;
	}

	//Checks if there is a pair of brackets
	public boolean hasPairOfBrackets()
	{
		return equation.contains("[") && equation.contains("]");
	}

	//Checks if there is a pair of curly braces
	public boolean hasPairOfBraces()
	{
		return equation.contains("{") && equation.contains("}");
	}

	//Checks if there is a pair of curly braces
	public boolean hasPairOfParens()
	{
		return equation.contains("(") && equation.contains(")");
	}

	//Checks if there is a bracket
	public boolean hasBracket()
	{
		return equation.contains("[") || equation.contains("]");
	}

	//Checks if there is a curly brace
	public boolean hasBrace()
	{
		return equation.contains("{") || equation.contains("}");
	}

	//Checks if there is a paranthese
	public boolean hasParen()
	{
		return equation.contains("(") || equation.contains(")");
	}

	public String toString()
	{
		getLocations(equation);
		for(int i = 0; i < correctLocations.size(); i++)
		{
			correctLocations.set(i, correctLocations.get(i) + 1);
		}
		return "" + correctLocations + "\n\n";
	}
}