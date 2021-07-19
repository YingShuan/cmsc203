
/*
 * Class: CMSC203 47729
 * Instructor: Pro. Grigoriy Grinberg
 * Description: This is an application that lets the user create a management company. They will build to rent and charges them a management fee as the percentages of the monthly rental amount. The properties cannot overlap each other, and each property must be within the limits of the management company¡¦s plot.
 * Due: 7/19/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: YingShuan Lin
   
   
 * Pseudocode
 * 1. start
 * 2. declare all variables
 * 3. create a management company
 * 4. add three properties, with plots
 * 5. set mgmt co to null
 * 6. add property with 4 args and default plot (0,0,1,1)
 * 7. add property with 8 args
 * 8. add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
 * 9. test if maxRentProp contains the maximum rent of properties
 * 10. test if totalRent returns the total rent of properties
 * 11. end
 * 
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1 ,p2,p3,p4,p5,p6;
	ManagementCompany m ; 	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m= new ManagementCompany("YingShuan", "745632333",3);
		
		//student add three properties, with plots, to mgmt co
		p1 = new Property ("Mist", "Maryland", 2343, "Andy Jones",1,1,1,1);
		p2 = new Property ("Board Way", "Maryland", 6332, "Air Jordan",2,1,1,1);
		p3 = new Property ("Moon Ridge", "Washington", 3342, "Lady Gaga",3,1,1,1);
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		p1=p2=p3=p4=p5=p6=null;
		m=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property ("Oak hill", "Virginia", 4844.00, "James Smith");
		assertEquals(m.addProperty(p4),3,0);
		//student should add property with 8 args
		p5 = new Property ("Pond", "Maryland", 4114, "Scott Taylor",4,1,1,1);
		assertEquals(m.addProperty(p5),4,0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		p6 = new Property ("Shell Beach", "Miami", 2312, "Paul Young",5,1,1,1);
		assertEquals(m.addProperty(p6),-1,0);	
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m.maxRentProp(),6332.0,0);
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(),12017.0,0);
	}

 }
