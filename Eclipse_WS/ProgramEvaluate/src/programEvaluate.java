import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class programEvaluate
{

    public static void main(String[] args) throws FileNotFoundException
    {
    	Scanner keyboard = new Scanner(System.in);
    	String fileName = "";
    	String wantByte = "";
    	
    	System.out.println("Enter file name: ");
    	
    	if (keyboard.hasNextLine()) {
    		fileName = keyboard.nextLine();
    	} else {
            System.out.println("You must enter a file name!");
            System.exit(1);
        }
    	System.out.println("Enter character to count: ");
    	if (keyboard.hasNext()) {
    		wantByte = keyboard.next();
    	} else {
            System.out.println("You must enter a wanted character!");
            System.exit(1);
        }
    	File file = new File(fileName);
    	Scanner inputFile = new Scanner(file);
    	
    	int meetCount = 0;
		while (inputFile.hasNext())
		{
			String scanData = inputFile.next();
			//System.out.println(scanData);
			for(int i = 0; i < scanData.length() ; i++) {
				String scanByte = scanData.substring(i, i+1); 
				if(scanByte.equals(wantByte)) {
					meetCount++;
				}
				//System.out.println("scanByte -> " + scanByte + ", meetCount -> " + meetCount);
			}
		}
		inputFile.close();
		//System.out.println("Meet byte count: " + meetCount);
		
		System.out.println("The character '" + wantByte + "' appears in the file " + fileName + " " + meetCount + " times.");
    	/*
    	      Scanner keyboard = new Scanner(System.in);
    	      double vehicleSpeed = 0;
    	      int timeTravelled = 0;
    	      double distanceTravelled = 0;
    	      DecimalFormat df = new DecimalFormat("#0.##");
    	      
    	      while (vehicleSpeed <= 0) {
    	    	  System.out.print("Enter the vehicle speed: ");
        	      vehicleSpeed = keyboard.nextDouble();
    	      } 
    	      while (timeTravelled <= 0) {
    	    	  System.out.print("Enter time travelled (in hrs): ");
        	      timeTravelled = keyboard.nextInt();
    	      }
    	      
    	      
    	      System.out.println("Hour\tDistance Travelled\n--------------------------");
    	      for (int hour = 1; hour <= timeTravelled; hour++) {
    	    	  distanceTravelled = (hour * vehicleSpeed);
    	    	  System.out.println(hour + "		" + df.format(distanceTravelled));
    	    	  
    	      }
    	      */
    }
    	
    	
    	
    	
    	
    	
    	
    	
    	/* File file = new File("MyName.txt");
    	Scanner inputFile = new Scanner(file);
    		
		if (inputFile.hasNext())
		{
			String str = inputFile.nextLine();
			System.out.println(str);
			str = inputFile.nextLine();
			System.out.println(str);
			str = inputFile.nextLine();
			System.out.println(str);
		}
		inputFile.close();
    	
    	
       * //System.out.println("java SoftwareSales\n");
      DecimalFormat df = new DecimalFormat("#0.00");
      df.setMaximumFractionDigits(2);
      // declare variables
      Scanner keyboard = new Scanner(System.in);
      int packages_purchased = 0;
      final int retailUnitPrice = 99;
      
      // ask for total packages purchased
      System.out.print("Enter number of packages purchased: ");
      if (keyboard.hasNextInt()) {
        packages_purchased = keyboard.nextInt();
      } else {
        System.out.println("You must enter a number!");
        System.exit(1);
      }
      
      // output the discount and total amount if the quantity is between 10 and 99
      if (packages_purchased < 10) {
          System.out.println("Your discount is: $0.00" + "\nYour total is: $" + df.format(packages_purchased * retailUnitPrice));
      } else {
    	  double disCountPrice = 0.0f;
	      if (packages_purchased >= 10 && packages_purchased < 20) {
	    	  disCountPrice = packages_purchased * retailUnitPrice * .20; 
	      } else if (packages_purchased >= 20 && packages_purchased < 50) {
	    	  disCountPrice = packages_purchased * retailUnitPrice * .30; 
	      } else if(packages_purchased >= 50 && packages_purchased < 100) {
	    	  disCountPrice = packages_purchased * retailUnitPrice * .40; 
	      } else if (packages_purchased >= 100) {
	    	  disCountPrice = packages_purchased * retailUnitPrice * .50;   	
	      }
	      System.out.println("Your discount is: $" + df.format(disCountPrice) + "\nYour total is: $" + df.format(packages_purchased * retailUnitPrice - disCountPrice));
	   }   
	   */
    } // end main()

 // end QuantityDiscounts class

