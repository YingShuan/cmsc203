/*
 * Class: CMSC203 47729
 * Instructor: Pro. Grigoriy Grinberg
 * Description: Prepare bonuses to their employees in Retail District #5 as required. The bonuses are calculated based on how much each retail store sold in each category. * Due: 7/26/2021
 * Programmer: YingShuan Lin
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: YingShuan Lin
   */

import java.util.ArrayList;
import java.util.*;
import java.io.*;


public class TwoDimRaggedArrayUtility extends java.lang.Object {

//	Returns the average of the elements in the two dimensional array	
	public static double getAverage(double[][] data) {
		
		double sum = 0;
		double average = 0;
		int countItem = 0;		
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0;j<data[i].length;j++)
			{
				sum += data[i][j];
				countItem++;
			}
		}
		if(countItem > 0) {
			average = (sum/countItem);
		}else {
			average = 0;
		}	
		return average;
	}
	
//	Returns the total of the selected column in the two dimensional array index 0 refers to the first column	
	public static double getColumnTotal(double[][] data, int col){
        double sum = 0;	
        for (int i = 0; i < data.length; i++) {
        	if(col < data[i].length) {	
                sum += data[i][col];
        	}
        }
        return sum;
	}
      
//	Returns the largest element in the two dimensional array	
	public static double getHighestInArray(double[][] data){
		double max = -Double.MAX_VALUE;		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
	        	if (max < data[i][j]) {
	            	max = data[i][j];
	        	}
			}
		}
		return max;
	}
	
//	Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column	
	public static double getHighestInColumn(double[][] data, int col) {
		double max = -Double.MAX_VALUE;		
		for (int i = 0; i < data.length; i++) {
			if(col < data[i].length) {
	        	if (max < data[i][col]) {
	            	max = data[i][col];
	        	}
			}
		}
		return max;
	}
	
//	Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double max = -Double.MAX_VALUE;		
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if(col < data[i].length) {
	        	if (max < data[i][col]) {
	            	max = data[i][col];
	            	index = i;
	        	}
			}	
		}
		return index;
	
	}
	
//	Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row	
	public static double getHighestInRow(double[][] data, int row) {
		double max = -Double.MAX_VALUE;		
		if(row >= data.length) {
			return 0;
		}	
		for (int i = 0; i < data[row].length; i++) {
			
        	if (max < data[row][i]) {
            	max = data[row][i];
        	}
		}
		return max;
	}
	 
//	Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row	
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max = -Double.MAX_VALUE;
		if(row >= data.length) {
			return 0;
		}	
		int index = 0;
		for (int i = 0; i < data[row].length; i++) {
        	if (max < data[row][i]) {
            	max = data[row][i];
            	index = i;
        	}
		}
	
		return index;
	}
	
//	Returns the smallest element in the two dimensional array	
	public static double getLowestInArray(double[][] data) {
		double min = Double.MAX_VALUE;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
	        	if (min > data[i][j]) {
	            	min = data[i][j];
	        	}
			}
		}
		return min;
	}
	
	
//	Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column	
	public static double getLowestInColumn(double[][] data, int col) {
		double min = Double.MAX_VALUE;
		for (int i = 0; i < data.length; i++) {
			if(col < data[i].length) {
	        	if (min > data[i][col]) {
	            	min = data[i][col];
	        	}
			}
			
		}
		return min;
	}
	
	
//	Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double min = Double.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if(col < data[i].length) {
	        	if (min > data[i][col]) {
	            	min = data[i][col];
	            	index = i;
	        	}
			}
		}
		return index;
	
	}
	
//	Returns the smallest element of the selected row in the two dimensional array index 0 refers to the first row.	
	public static double getLowestInRow(double[][] data, int row) {
		double min = Double.MAX_VALUE;
		if(row >= data.length) {
			return 0;
		}
		for (int i = 0; i < data[row].length; i++) {			
        	if (min > data[row][i]) {
            	min = data[row][i];
        	}
		}
	return min;
	}
	
//	Returns the index of the smallest element of the selected row in the two dimensional array index 0 refers to the first row	
	public static int getLowestInRowIndex(double[][] data, int row) {
		double min = Double.MAX_VALUE;
		if(row >= data.length) {
			return 0;
		}
		int index = 0;
		for (int i = 0; i < data[row].length; i++) {
			
        	if (min > data[row][i]) {
            	min = data[row][i];
            	index = i;
        	}
		}
	
		return index;
	}
	
	
//	Returns the total of the selected row in the two dimensional array index 0 refers to the first row	
	public static double getRowTotal(double[][] data, int row) {
		double sum = 0;
		if(row >= data.length)
			return 0;
		for (int i = 0; i < data[row].length; i++) {
	        sum += data[row][i];
		}
		return sum;
	}


	
//	Returns the total of all the elements of the two dimensional array	
	public static double getTotal(double[][] data) {
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
	        	sum += data[i][j];
			}
		}
		return sum;
	}
	
	// @SuppressWarnings("finally")
	
//	Reads from a file and returns a ragged array of doubles 
//	The maximum rows is 10 and the maximum columns for each row is 10 
//	Each row in the file is separated by a new line 
//	Each element in the row is separated by a space
	public static double[][] readFile(java.io.File file){
		String strAry[] = new String[10];
		double[][] array;
		try {
			int row = 0;
			BufferedReader fileReader = new BufferedReader(new FileReader(file.getPath()));
			while(true) {
				strAry[row] = fileReader.readLine();
				if(strAry[row] == null) {
					break;
				}
				row++;
			}
			array = new double [row][];
			for(int i = 0; i < row; i++) {
				String[] strLines = strAry[i].split(" ");
				array[i] = new double [strLines.length];
				for(int j = 0; j < strLines.length; j++) {
					array[i][j] = Double.parseDouble(strLines[j]);
				}
			}
			fileReader.close();
			return array;
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	
//	Writes the ragged array of doubles into the file	
	public static void writeToFile(double[][] data, java.io.File outputFile){
		System.out.println(outputFile.getPath());	
		BufferedWriter fileWriter;
		try {
			fileWriter = new BufferedWriter(new FileWriter(outputFile.getPath()));
			for(int i = 0; i < data.length; i++) {
				String strLine = ""; 
				for(int j = 0; j < data[i].length; j++) {
					strLine += (Double.toString(data[i][j]) + " ");
				}
				fileWriter.write(strLine);
				fileWriter.write("\n");
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("writeToFile Exception");	
		}
	}	

}
