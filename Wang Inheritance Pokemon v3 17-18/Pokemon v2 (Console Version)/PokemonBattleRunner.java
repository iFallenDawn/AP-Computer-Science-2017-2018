//Jordan Wang

import java.util.ArrayList;
import java.util.Scanner;

public class PokemonBattleRunner
{
	public static void main(String[] args) throws Exception
	{
		Starter user = new Starter();
		Starter opponent = new Starter();
		boolean isOver = false;
		boolean choseStarter = false;
		String userInput = "";
		String userStarter = "";
		String opponentStarter = "";
		int turnCount = 1;
		int userdmgDealt = 0;
		int oppdmgDealt = 0;
		int critNum = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Jordan Land");
		System.out.println("Choose a starter!\n");
		System.out.println("Pokemon: Torchic\nType: Fire\nMoves: Scratch\nTorchic is a small, chick Pokémon with stubby, downy, yellow wings.\n");
		System.out.println("Pokemon: Treecko\nType: Grass\nMoves: Pound\nTreecko is a small, green, bipedal reptilian Pokémon.\n");
		System.out.println("Pokemon: Mudkip\nType: Water\nMoves: Tackle\nMudkip is a small, amphibious, quadruped Pokémon.\n");

		while(choseStarter == false)
		{
			System.out.print("What do you choose? ");
			userStarter = sc.next();
			if(userStarter.equalsIgnoreCase("Treecko") || userStarter.equalsIgnoreCase("Torchic") || userStarter.equalsIgnoreCase("Mudkip"))
				choseStarter = true;
			else
			{
				System.out.println("Invalid choice");
				choseStarter = false;
			}
		}
		System.out.println();
		if(userStarter.equalsIgnoreCase("Torchic"))
		{
			user = new Starter("Scratch", 20, "Torchic", "Fire");
			opponent = new Starter("Tackle", 20, "Mudkip", "Water");
		}
		else if(userStarter.equalsIgnoreCase("Treecko"))
		{
			user = new Starter("Pound", 20, "Treecko", "Grass");
			opponent = new Starter("Scratch", 20, "Torchic", "Fire");
		}
		else if(userStarter.equalsIgnoreCase("Mudkip"))
		{
			user = new Starter("Tackle", 20, "Mudkip", "Water");
			opponent = new Starter("Pound", 20, "Treecko", "Grass");
		}
		System.out.print("Would you like to name your pokemon? y/n: ");
		userInput = sc.next();
		if(userInput.equalsIgnoreCase("y"))
		{
			System.out.println("What should it be named?");
			userInput = sc.next();
			user.setName(userInput);
		}
		//battle logic
		while(isOver == false)
		{
			System.out.println("\nTurn: " + turnCount);
			System.out.println("\nPlayer\n" + user);
			System.out.println("Opponent\n" + opponent);
			System.out.println("It's your turn! What would you like to do?");
			System.out.println("Moves: " + user.getAttack());
			userInput = sc.next();
			if(userInput.equalsIgnoreCase(user.getAttack()))
			{
				critNum = (int)(Math.random()*25);
				userdmgDealt = (int)(Math.random()*3)+2;
				oppdmgDealt = (int)(Math.random()*3)+2;

				System.out.println("\n" + user.getName() + " used " + user.getAttack() + "!");
				Thread.sleep(1500);
				if(critNum == 10)
				{
					System.out.println("It was a critical hit!");
					userdmgDealt = userdmgDealt * 2;
				}
				System.out.println(opponent.getName() + " took " + userdmgDealt + " damage!");
				opponent.calculateHealth(userdmgDealt);
				Thread.sleep(1500);

				if(opponent.getHealth() <= 0)
				{
					isOver = true;
					System.out.println("You won the battle!");
				}
				else
				{
					critNum = (int)(Math.random()*25);
					System.out.println("\n" + opponent.getName() + " used " + opponent.getAttack() + "!");
					Thread.sleep(1500);
					if(critNum == 10)
					{
						System.out.println("It was a critical hit!");
						oppdmgDealt = oppdmgDealt * 2;
					}
					System.out.println(user.getName() + " took " + oppdmgDealt + " damage!");
					user.calculateHealth(oppdmgDealt);
					Thread.sleep(1500);
				}
				if(user.getHealth() <= 0)
				{
					isOver = true;
					System.out.println("You blacked out . . .");
				}
				turnCount++;
			}
			else
			{
				System.out.println("Invalid option\n\n");
				Thread.sleep(1500);
			}
		}
	}
}
//Null layout