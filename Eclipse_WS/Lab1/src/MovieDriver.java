import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {
		Movie movie = new Movie();
		Scanner scanner = new Scanner(System.in);

		// task 1 
		/*System.out.println("Enter the name of movie");
	    movie.setTitle(scanner.nextLine());
		
		System.out.println("Enter the rating of the movie");
		movie.setRating(scanner.nextLine());
		
		System.out.println("Enter the number of tickets sold for this movie");
		movie.setSoldTickets(scanner.nextInt());
		scanner.nextLine();
		
		String tooutstr = movie.toString();
		System.out.println(tooutstr);
		
		System.out.println("Goodbye"); */
		
		// task 2		
		while (true)
		{		
		    System.out.println("Enter the name of movie");
		    movie.setTitle(scanner.nextLine());
    		
    		System.out.println("Enter the rating of the movie");
    		movie.setRating(scanner.nextLine());
    		
    		System.out.println("Enter the number of tickets sold for this movie");
    		movie.setSoldTickets(scanner.nextInt());
    		scanner.nextLine();
    		
    		String tooutstr = movie.toString();
    		System.out.println(tooutstr);
    		
    		System.out.println("Do you want to enter another? (y or n)");
    		
		    if(scanner.nextLine().equals("n")){
	            System.out.println("Goodbye");
	            break;
		    }
		}    
		scanner.close();
	} 

}
