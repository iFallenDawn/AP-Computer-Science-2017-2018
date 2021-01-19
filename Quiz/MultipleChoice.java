//Jordan Wang
//Question Interface
//Spec:

public class MultipleChoice implements Question
{
	private String question, choiceA, choiceB, choiceC, choiceD, choiceE, answer;
	public MultipleChoice()
	{
		question = "";
		answer = "";
		choiceA = "";
		choiceB = "";
		choiceC = "";
		choiceD = "";
		choiceE = "";
	}
	public MultipleChoice(String question, String a, String b, String c, String d, String e, String answer)
	{
		this.question = question;
		this.answer = answer;
		choiceA = a;
		choiceB = b;
		choiceC = c;
		choiceD = d;
		choiceE = e;
	}
	public String getQuestion()
	{
		return question;
	}
	public String getAnswer()
	{
		return answer;
	}
	public String toString()
	{
		String result = "";
		result += getQuestion() + "\n";
		result += "\ta)\t " + choiceA + "\n";
		result += "\tb)\t " + choiceB + "\n";
		result += "\tc)\t " + choiceC + "\n";
		result += "\td)\t " + choiceD + "\n";
		result += "\te)\t " + choiceE + "\n";
		return result;
	}
}
