
/*
 * Pseudocode
 * 1. start
 * 2. declare all variables to private
 * 3. let city, owner, and propertyName be empty, and rentAmount be 0.0
 * 4. for Plot, sets the x, y values to zero, depth and width to 1
 * 5. creates a new object using the information of the object passed to it
 * 6. Parameterized Constructor, no Plot information provided
 * 7. Parameterized Constructor with Plot
 * 8. return city, owner, propertyName, and rentAmount
 * 9. set the Plot values and return the Plot instance
 * 10. set the city, owner, propertyName, and rentAmount
 * 11. Prints out the name, city, owner and rent amount for a property
 * 12. end
 */
public class Property extends java.lang.Object{
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount ;
	private Plot plot;
	//private String city;
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0.0;
		plot = new Plot(0, 0, 1, 1);
	}
	
	public Property(Property p){ 
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;
		plot = new Plot(p.plot.getX(), p.plot.getY(), p.plot.getWidth(), p.plot.getDepth());		
	}
	
	public Property(String strpropertyName,String strcity,double drentAmount,String strowner){
		propertyName = strpropertyName;
		city = strcity;
		rentAmount = drentAmount;
		owner = strowner;
		plot = new Plot(0, 0, 1, 1);
	}
	
	public Property(String strpropertyName, String strcity, double drentAmount, String strowner, int x, int y, int width, int depth) {
		city = strcity;
		owner = strowner;
		propertyName = strpropertyName;
		rentAmount = drentAmount;
		plot = new Plot(x, y, width, depth);				
	}
	
	String getCity() {
		return city;
	}
	
	String getOwner() {
		return owner;
	}
	
	String getPropertyName() {
		return propertyName;
	}
	
	double getRentAmount() {
		return rentAmount;
	}
	
	Plot getPlot() {
		return plot;
	}
	Plot setPlot(int x, int y, int width, int depth) {
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
		return plot;
	}
	void setCity(String strcity) {
		city = strcity;
	}
	void setOwner(String strowner) {
		owner = strowner;
	}
	
	void setPropertyName(String strpropertyName) {
		propertyName = strpropertyName;
	}
	
	void setRentAmount(double drentAmount) {
		rentAmount = drentAmount;
	}
	
	public String toString() {
		String ret = "    Property Name: " + propertyName + "\r\n";
		ret += "     Located in " + city + "\r\n";
		ret += "     Belonging to " + owner + "\r\n";
		ret += "     Rent Amount " + String.valueOf(rentAmount) + "\r\n";
		
		return ret; 
	}
}
