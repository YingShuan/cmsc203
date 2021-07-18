

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
		m= new ManagementCompany("Sharon", "745632333",3);
		
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
