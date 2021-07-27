
public class HolidayBonus {

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
