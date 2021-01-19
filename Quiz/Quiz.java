//Jordan Wang
//Question Interface
//Spec:

import java.util.*;

public class Quiz
{
	private ArrayList <Question> questions;

	/** Instantiates the questions ArrayList*/
	public Quiz()
	{
		questions = new ArrayList<Question>();
	}

	/** adds Question q to the questions ArrayList*/
	public void addQuestion(Question q)
	{
		questions.add(q);
	}

	/** @return the next question and removes it from the questions ArrayList */
	public Question getNextQuestion()
	{
		return questions.remove(0);
	}

	/** @return true if there are no more questions, false otherwise */
	public boolean isDone()
	{
		return questions.isEmpty();
	}

	/** @return a String with the quiz questions numbered from 1 to question.size()*/
	public String toString()
	{
		String result = "";
		for(int i = 0; i < questions.size(); i++)
		{
			result += (i+1) + "" + getNextQuestion() + "\n";
		}
		return result;
	}
}