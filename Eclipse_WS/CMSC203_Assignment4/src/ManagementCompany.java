import java.util.ArrayList;


//import com.sun.tools.javac.util.List;

public class ManagementCompany extends java.lang.Object{
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private ArrayList<Property> properties;
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;

	public ManagementCompany() {
		mgmFeePer = 0.0;
		name = "";
		taxID = "";
		properties = new ArrayList<Property>();
		plot = new Plot(0, 0, 10, 10);		
	}
	public ManagementCompany(String strname,String strtaxID, double mgmFee) {
		mgmFeePer = mgmFee;
		name = strname;
		taxID = strtaxID;
		properties = new ArrayList<Property>(); 
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);				
	}
	public ManagementCompany(String strname,String strtaxID,double mgmFee, int x,int y,int width,int depth) {
		mgmFeePer = mgmFee;
		name = strname;
		taxID = strtaxID;
		properties = new ArrayList<Property>();
		plot = new Plot(x, y, width, depth);				
	}
	public ManagementCompany(ManagementCompany otherCompany) {
		mgmFeePer = otherCompany.mgmFeePer;
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		properties = new ArrayList<Property>();
		plot = new Plot(otherCompany.plot.getX(), otherCompany.plot.getY(), otherCompany.plot.getWidth(), otherCompany.plot.getDepth());		
	}
	public String getName() {
		return name;
	}
	public void setName(String strName) {
		name = strName;
	}
	public Plot getPlot() {
		return plot;
	}
	public Plot setPlot(int x, int y, int width, int depth) {
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
		return plot;
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	public int addProperty(Property prtproperty) {		  
        if(properties.size() >= MAX_PROPERTY) {
        	return -1;
        }else if(prtproperty == null) {
        	return -2;
        }else if(!this.plot.encompasses(prtproperty.getPlot())) {
        	return -3;
        }else {
        	for(int i = 0; i < properties.size(); i++) {
        		if(prtproperty.getPlot().overlaps(properties.get(i).getPlot())) {
        			return -4;
        		}
        	}
        }  
        properties.add(prtproperty);
        return properties.size()-1;
	    
	}
	public int addProperty(String name,String city,double rent,String owner) {
        if(properties.size() > MAX_PROPERTY) {
        	return -1;
        }
        Property prtproperty = new Property(name, city, rent, owner);
        if(!this.plot.encompasses(prtproperty.getPlot())) {
        	return -3;
        }else {
        	for(int i = 0; i < properties.size(); i++) {
        		if(prtproperty.getPlot().overlaps(properties.get(i).getPlot())) {
        			return -3;
        		}
        	}
        }
        properties.add(prtproperty);
        return properties.size()-1;
	}
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) {
        if(properties.size() > MAX_PROPERTY) {
        	return -1;
        }
        Property prtproperty = new Property(name, city, rent, owner);
        plot = prtproperty.setPlot(x, y, width, depth);
        if(!this.plot.encompasses(plot)) {
        	return -3;
        }else {
        	for(int i = 0; i < properties.size(); i++) {
        		if(prtproperty.getPlot().overlaps(properties.get(i).getPlot())) {
        			return -3;
        		}
        	}
        }
        properties.add(prtproperty);
        return properties.size()-1;
	}
	public double totalRent() {
		double sumRent = 0.0;
    	for(int i = 0; i < properties.size(); i++) {
    		sumRent += properties.get(i).getRentAmount();
    	}
		
		return sumRent;
	}
	public int maxRentPropertyIndex() {
		int ret = 0;
    	for(int i = 1; i < properties.size(); i++) {
    		if(properties.get(ret).getRentAmount() < properties.get(i).getRentAmount()) {
    			ret = i;
    		}
    	}
    	return ret;
	}
	public double maxRentProp() {
		double ret = 0;
    	for(int i = 0; i < properties.size(); i++) {
    		if(ret < properties.get(i).getRentAmount()) {
    			ret = properties.get(i).getRentAmount();
    		}
    	}
    	return ret;
	}
	public String toString(){
		String ret = "  List of the properties for " + name + ", taxID: " + taxID  + "\r\n";
		ret += "______________________________________________________\r\n"; 
		//System.out.println("properties: " + Integer.toString(properties.size()));
		for(int i = 0; i < properties.size(); i++) {
			//System.out.println("i: " + Integer.toString(i));
    		ret += properties.get(i).toString();
    	}
		ret += "______________________________________________________\r\n"; 
		ret += "  total management Fee: "  + String.valueOf(totalRent()) + "\r\n";
		return ret;

	}


}
