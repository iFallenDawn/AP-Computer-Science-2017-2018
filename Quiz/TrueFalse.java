//Jordan Wang
//Question Interface
//Spec:

public class TrueFalse implements Question
{
	private String question, answer;
	public TrueFalse()
	{
		question = "";
		answer = "";
	}
	public TrueFalse(String question, String answer)
	{
		this.question = question;
		this.answer = answer;
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
		result+= getQuestion() + "\nT/F: ";
		return result;
	}
}
