import java.util.Scanner;
 
public class RandomNumberGuesser {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RNG rng = new RNG();
		int randNum = 0;
		int nextGuess = 0;
		int highGuess = 100, lowGuess = 0;
		// print a header
		System.out.println("=======Project Assigment 2========");
		randNum = rng.rang(101); //generate a random number in range 0~100 for guess
		System.out.println("Enter your first guess");

		while(true) {// Allow user to give another guess between the previous low and high guesses
			// ask the user for an initial guess of the Random Number between 0 and 100
			nextGuess = scanner.nextInt();
			scanner.nextLine();

			// Print out the result for that guess using the methods from the RNG class					
			while(!rng.inputValidation(nextGuess, highGuess, lowGuess)){
				System.out.println("	>>> Guess must be between " + lowGuess + " and " + highGuess + ". Try again");
				nextGuess = scanner.nextInt();
				scanner.nextLine();
			}

			// Display the number of guesses
			System.out.println("Number of guess is " + rng.getCount());

			if(randNum == nextGuess) {
				System.out.println("Congragulations, your guessed correctly");
				System.out.println("Try again? (yes or no)");
				if(scanner.nextLine().equals("yes")) {
					randNum = rng.rang(101);
					highGuess = 100;
					lowGuess = 0;
					rng.resetCount(1);	
					System.out.println("Enter your first guess");
					continue;
				}	else {
					System.out.println("Thanks for play...");
					break;
				}
			}else {		
				if(nextGuess > randNum) {
					System.out.println("You guess is too high");
					highGuess = nextGuess; 
				}else if(nextGuess < randNum){
					System.out.println("You guess is too low");
					lowGuess = nextGuess; 
				}
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				rng.resetCount(rng.getCount() + 1);
				continue;
			}
						
		}		
		
		
		// When user guesses correctly, ask if the user wants to try another round
		
		// Print the Programmer's name at the end
		System.out.println("=======Project via YingShuan Lin========");
		
		// Refer to the program sample run for more clarification
	}

}
