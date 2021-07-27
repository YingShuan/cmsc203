/*
 * Class: CMSC203 47729
 * Instructor: Pro. Grigoriy Grinberg
 * Description: Use Caesar Cipher and Bellaso Cipher to encrypt and decrypt a string.
 * Due: 7/26/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: YingShuan Lin
   */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = null;
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		dataSetSTUDENT = new double[][]{{0,2,1},{2,3},{6,4,5,9}};
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
//		fail("Student testGetTotal not implemented");
		assertEquals(32.0,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
		
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
//		fail("Student testGetAverage not implemented");	
		assertEquals(32.0/9.0,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
		
		
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
//		fail("Student testGetRowTotal not implemented");
		assertEquals(3.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,0),.001);
		
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
//		fail("Student testGetColumnTotal not implemented");	
		assertEquals(6.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,2),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
//		fail("Student testGetHighestInArray not implemented");	
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT,outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(0.0, array[0][0],.001);
		assertEquals(2.0, array[0][1],.001);
		assertEquals(1.0, array[0][2],.001);
		assertEquals(2.0, array[1][0],.001);
		assertEquals(3.0, array[1][1],.001);
		assertEquals(6.0, array[2][0],.001);
		assertEquals(4.0, array[2][1],.001);
		assertEquals(5.0, array[2][2],.001);
		assertEquals(9.0, array[2][3],.001);
	}

}