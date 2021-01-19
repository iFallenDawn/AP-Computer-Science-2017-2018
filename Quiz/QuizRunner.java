//Jordan Wangget
//Question Interface
//Spec:

import java.util.Scanner;

public class QuizRunner
{
	public static void main(String[] args)
	{
		int right = 0;
		int wrong = 0;
		Quiz quiz = new Quiz();
		Scanner sc = new Scanner(System.in);
		String userAnswer;
		Question currentQuestion;

		// The following are just examples that you can look at and later delete
		// Create your APCS style questions and add them here

		// Question 1
		quiz.addQuestion(new MultipleChoice("Which of the following is the proper way to instantiate an Arraylist?",
								"ArrayList<String> list = new ArrayList();",
								"ArrayList<String> list = new ArrayList<String>();",
								"ArrayList<String> list = ArrayList();",
								"ArrayList<String> list = ArrayList<String>();",
								"ArrayList<String> list = new list <String>();",
								"B"));
		// Question 2
		quiz.addQuestion(new TrueFalse("The operator XOR is part of the AP Java subset", "F"));

		// Question 3
		quiz.addQuestion(new MultipleChoice("Consider the following method.\npublic static void mystery(List<Integer> nums)\n{\n\tfor(int k = 0; k < nums.size(); k++)\n\t{\n\t\tif(nums.get(k).intValue == 0)\n\t\t\tnums.remove(k);\n\t}\n}\nAssume that a list<Integer> values initially contains the following values\n[0, 0, 4, 2, 5, 0, 3, 0]\nWhat will values contain as a result of executing mystery(values)?",
								"[0, 0, 4, 2, 5, 0, 3, 0]",
								"[4, 2, 5, 3]",
								"[0, 0, 0, 0, 4, 2, 5, 3]",
								"[0, 4, 2, 5, 3]",
								"The code throws an ArrayIndexOutOfBoundsException.",
								"D"));

		// Question 4
		quiz.addQuestion(new TrueFalse("The proper way to sort an array of name blah is blah.sort()", "F"));

		// Question 5
		quiz.addQuestion(new TrueFalse("1568%2 + 9 = 11", "T"));

		// Question 6
		quiz.addQuestion(new MultipleChoice("What is printed as a result of the following code segment? \nSystem.out.println(404 / 10 * 10 + 1)",
								"4",
								"5",
								"41",
								"401",
								"405",
								"D"));

		// Question 7
		quiz.addQuestion(new MultipleChoice("What is printed as a result of the following code segment? \nSystem.out.println(404 % 10 * 10 + 8)",
								"4",
								"9",
								"48",
								"408",
								"409",
								"C"));

		// Question 8
		quiz.addQuestion(new TrueFalse("Given String blah = 'blah', blah.indexOf(b) returns 0", "T"));

		// Question 9
		quiz.addQuestion(new TrueFalse("Arrays can be created and initialized in the statement below.\nint x[] = new int[]{10, 20, 30}", "T"));

		// Question 10
		quiz.addQuestion(new MultipleChoice("Assume that x and y are boolean variables and have properly initialized.\n\t(x && y) && !(x || y)\nWhich of the following best describes the result of evaluating the expression above?",
								"true always",
								"false always",
								"true only when x is true and y is true",
								"true only when x and y have the same value",
								"true only when x and y have different values",
								"B"));

		// Add a loop to run a simple quiz here
		while(quiz.isDone() == false)
		{
			currentQuestion = quiz.getNextQuestion();
			System.out.print(currentQuestion);
			System.out.print("Your answer: ");
			userAnswer = sc.next();
			if(currentQuestion.getAnswer().equalsIgnoreCase(userAnswer))
			{
				right++;
				System.out.println("Correct!\n");
			}
			else
			{
				wrong++;
				System.out.println("Incorrect! The answer was " + currentQuestion.getAnswer() + "\n");
			}
		}
		System.out.println("\nYou got " + right + " questions right!");
		System.out.println("You got " + wrong + " questions wrong.");
	}
}


