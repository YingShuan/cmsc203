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


public class HolidayBonus {

//	Calculates the holiday bonus for each store	
	public static double[] 	calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double array[] = new double[data.length];
		
		for(int i = 0; i < data.length; i++)
		{
			array[i] = 0;
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] > 0) {
					if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
						array[i] += high; 
					}else if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
							array[i] += low; 
					}else {
						array[i] += other;
					}
				}
			}
		}
		return array;
	}

//	Calculates the total holiday bonuses
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double array[] = new double[data.length];
		double total = 0;
		for(int i = 0; i < data.length; i++)
		{
			array[i] = 0;
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] > 0) {
					if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
						array[i] += high;
					}else if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
						array[i] += low; 
					}else {
						array[i] += other;
					}
				}
			}
		}
		for(int i = 0; i < data.length; i++) {
			total += array[i];
		}
		return total;		
	}
}
