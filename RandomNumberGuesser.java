/*
 * Class: CMSC203 
 * Instructor: Professor David Kuijt
 * Description: This program asks the user to guess a number between 0-100. 
   The user gets 7 guesses. With each incorrect guess, the range of numbers shown to the user is decreased.
 * Due: 09/25/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mikhail Mallari
*/


import java.util.Scanner;

public class RandomNumberGuesser 
{

	public static void main(String[] args) 
	{
		final String PROGRAMMER_NAME = "Mikhail Mallari";
		
		System.out.println("This application generates a random integer between 0 and 100");
		System.out.println("and asks the user to guess repeatedly until they guess correctly");
		
		Scanner scan = new Scanner(System.in);
		int userInput = 0;
		boolean playAgain = true;
		int correctNum = 0;
		
		while (playAgain)
		{
			boolean winGame = false;
			int highGuess = 100;
			int lowGuess = 0;
			
			correctNum = RNG.rand();
			RNG.resetCount();
			System.out.println("Enter your first guess: ");

			while (RNG.getCount() <= 7)
			{
				userInput = scan.nextInt();
		
				while (!RNG.inputValidation(userInput, lowGuess, highGuess))
				{
					userInput = scan.nextInt();
				}
				if (userInput == correctNum && RNG.getCount() != 8)
				{
					winGame = true;
					break;
				}
				else if (userInput > correctNum && RNG.getCount() != 8)
				{
					System.out.println("Your guess is too high\nNumber of guesses is: " + RNG.getCount());
					highGuess = userInput;
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				}
				else if (userInput < correctNum && RNG.getCount() != 8)
				{
					System.out.println("Your guess is too low\nNumber of guesses is: " + RNG.getCount());
					lowGuess = userInput;
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				}
			}
			
			if (winGame)
			{
				boolean validation = false;
				System.out.println("Congrats, you guessed the number correctly!");
				do {
					System.out.println("Would you like to play again? (Yes or No)");
					String tryAgain = scan.next();
					if (tryAgain.compareToIgnoreCase("No") == 0)
					{
						playAgain = false;
					}
					else if(tryAgain.compareToIgnoreCase("Yes") == 0)
					{
						playAgain = true;
					}
					else validation = true;
				} while (validation);
			}
			else 
			{
				playAgain = false;
				System.out.println("You have exceeded the maximum number of guesses, 7. Try again.");
			}
		}
		System.out.println("Thank you for playing!");
		System.out.println("Programmer Name: " + PROGRAMMER_NAME);
		System.exit(0);
	}

}
