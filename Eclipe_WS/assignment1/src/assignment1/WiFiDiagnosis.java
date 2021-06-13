/*
 * Class: CMSC203 
 * Instructor: Pro. Grigoriy 
 * Description: (Give a brief description for each Class)
 * Due: 6/14/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Ying-Shuan Lin
   
   Pseudo Code:
   1. start
   2. Display the briefly description for the problem with internet connectivity.
   3. Display the first step
   4. Ask user if are you able to connect with the internet
   5. Ask user to enter the answer1
   6. If answer1 is yes
         display it works      
   7. Else 
         display second step and ask are you able to connect the internet 
   8.    Ask user to enter the answer2
   9.    If answer2 is yes, 
            display it works
   10.   Else 
            display second step and ask are you able to connect the internet 
   11.      Ask user to enter the answer3
   12.      If answer3 is yes, 
               display it works
   13.      Else 
               display fourth step and ask are you able to connect the internet
   14.         Ask user to enter the answer4
   15.         If answer4 is yes, 
                  display it works
   16.         Else 
                  display fifth step and make sure your ISP is hooked up to your router.
   17. End
   
*/


package assignment1;

import java.util.Scanner;

public class WiFiDiagnosis {
	public static void main(String[] args) {
		String name = "tImothy";
		if( name.equalsIgnoreCase("Timothy"))
		{
			System.out.println("Do I know you?");
		}
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.\n");
		System.out.println("First step: reboot your computer");
		System.out.println("Are you able to connect with the internet? (yes or no)");
		Scanner in = new Scanner(System.in);
        String answer1 = in.nextLine();
        if(answer1.equals("yes")) {
        	System.out.println("Rebooting your computer seemed to work");
        } else if(answer1.equals("no")) {
        	System.out.println("Second step: reboot your router");
            System.out.println("Now are you able to connect with the internet? (yes or no)");
            String answer2 = in.nextLine();
            if(answer2.equals("yes")){
            	System.out.println("Rebooting your router seemed to work");
            } else if(answer2.equals("no")) {
            	System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power");
                System.out.println("Now are you able to connect with the internet? (yes or no)");
                String answer3 = in.nextLine();
                if (answer3.equals("yes")){
                    System.out.println("Checking the router's cables seemed to work");
                } else if (answer3.equals("no")){
                    System.out.println("Fourth step: move your computer closer to your router");
                    System.out.println("Now are you able to connect with the internet? (yes or no)");
                    String answer4 = in.nextLine();
                    if (answer4.equals("yes")){
                        System.out.println("Moving your computer seened to work");
                    } else if (answer4.equals("no")){
                    System.out.println("Fifth step: contact your ISP");
                    System.out.println("Make sure your ISP is hooked up to your router.");
                    }    
                }
            }
        }
        System.out.println("\nProgrammer: Ying-Shuan Lin");
	}
}
