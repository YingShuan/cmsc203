/*
 * Class: CMSC203 
 * Instructor:
 * Description: This procedure requires users to guess random numbers. It will narrow the selection range based on the user's previous guesses, and continue to prompt the user to enter the guess until the guess is correct.
 * Due: 6/28/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: YingShuan Lin
   
   
   Pseudo Code:
   1. Start
   2. Declare veriables
   3. Display the header
   4. Generate a random number between range 0~100 for guess
   5. Ask user to enter first guess number of random number between 0~100
   6. While the number user guess is not in the range, display the range for lowGuess and highGuess
   7. Display try again
   8. Display and get the guess number
   9. If random number equals to guess number, print out congratulations, you guessed correctly
   10. 	When user guessed correctly, ask if the user wants to try another round
   11. 	If user want to try another round, generate a random number between the range 0~100 for guess
   12. 		Ask user to enter the first guess
   13. 	Else if the user does not want to try again, print out Thanks for playing...
   14. Else if random number > guess number, display Your guess is too high
   15. Else if random number < guess number, display Your guess is too low
   16. number of guess plus one
   17. Ask user to enter another number between range
   18. Print out programmer's name
   19. End
*/

import java.util.Scanner;
 
public class RandomNumberGuesser {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RNG rng = new RNG();
		int randNum = 0; //random number
		int nextGuess = 0; //the number user guess
		int highGuess = 100, lowGuess = 0; // range is 0 to 100
		// print a header
		System.out.println("=======Project Assigment 2========");
		randNum = rng.rang(101); //generate a random number in range 0~100 for guess
		System.out.println("Enter your first guess");

		while(true) {// Allow user to give another guess between the previous low and high guesses
			// ask the user for an initial guess of the Random Number between 0 and 100
			nextGuess = scanner.nextInt();
			scanner.nextLine();

			// Print out the result for that guess using the methods from the RNG class					
			while(!rng.inputValidation(nextGuess, highGuess, lowGuess)){ //while the number user guess is not in the range, print the range and try again
				System.out.println("	>>> Guess must be between " + lowGuess + " and " + highGuess + ". Try again");
				nextGuess = scanner.nextInt();
				scanner.nextLine();
			}

			// Display the number of guesses
			System.out.println("Number of guess is " + rng.getCount());

			if(randNum == nextGuess) {
				System.out.println("Congratulations, you guessed correctly"); //if the number user guess equals to random number, print out Congratulations, your guessed correctly
				System.out.println("Try again? (yes or no)"); // When user guessed correctly, ask if the user wants to try another round
				if(scanner.nextLine().equals("yes")) {
					randNum = rng.rang(101); //generate a random number in range 0~100 for guess
					highGuess = 100;
					lowGuess = 0;
					rng.resetCount(1);	
					System.out.println("Enter your first guess"); //ask user to enter first guess
					continue;
				}	else {
					System.out.println("Thanks for playing..."); //the user does not want to try again
					break;
				}
			}else {		
				if(nextGuess > randNum) {
					System.out.println("Your guess is too high"); //when the number that user guess is too high, print out You guess is too high
					highGuess = nextGuess; 
				}else if(nextGuess < randNum){
					System.out.println("Your guess is too low"); //when the number that user guess is too low, print out You guess is too low
					lowGuess = nextGuess; 
				}
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess); // display the range for next guess
				rng.resetCount(rng.getCount() + 1); //number of guess plus one
				continue;
			}
						
		}		
		
		
		
		
		// Print the Programmer's name at the end
		System.out.println("=======Project by YingShuan Lin========");
		
		// Refer to the program sample run for more clarification
	}

}
