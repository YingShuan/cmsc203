/*
 * Pseudocode
 * 1. start
 * 2. declare all variables to private
 * 3. creates a default Plot with args x=0, y=0, width=1, depth=1
 * 4. creates a new object using the information of the object passed to it
 * 5. Parameterized Constructor
 * 6. determines if this plot overlaps the parameter,returns true if the two plots overlap, false otherwise
 * 7. takes a Plot instance and determines if the current plot contains it
 * 8. Sets the x value, and returns the x value
 * 9. Sets the y value, and returns the y value
 * 10. Sets the width value, and returns the width value
 * 11. Sets the depth value, and returns the depth value
 * 12. Prints the X,Y of the upper left corner, the width and the depth
 * 13. end
 */

/**
 * Represents a Plot object
 * 
 * @author yingshuan lin
 *
 */
public class Plot extends java.lang.Object{
	private int x;
	private int y;
	private int width;
	private int depth;
	public Plot() {
		x = 0;
		y = 0;
		width = 0;
		depth = 0;
	}

	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}

	public Plot(int ix, int iy, int iwidth, int idepth) {
		x = ix;
		y = iy;
		width = iwidth;
		depth = idepth;
	}
	public boolean overlaps(Plot plot) {
		if(((plot.x < x && x < plot.x + plot.width) && (plot.y < y && y < plot.y + plot.depth))  
			|| ((plot.x < x + width && x + width < plot.x + plot.width) && (plot.y < y + depth && y + depth < plot.y + plot.depth))
			|| ((x < plot.x && plot.x < x + width) && (y < plot.y && plot.y < y + depth))
			|| ((x < plot.x + plot.width && plot.x + plot.width < x + width) && (y < plot.y + plot.depth && plot.y + plot.depth < y + depth))
			|| ((plot.x < x && x < plot.x + plot.width) && (plot.y < y + depth && y + depth < plot.y + plot.depth))
			|| ((plot.x < x + width && x + width < plot.x + plot.width) && (plot.y < y && y < plot.y + plot.depth))
			|| ((x < plot.x && plot.x < x + width) && (y < plot.y + plot.depth && plot.y + plot.depth < y + depth))
			|| ((x < plot.x + plot.width && plot.x + plot.width < x + width) && (y < plot.y && plot.y < y + depth))
			|| ((x == plot.x && y == plot.y) || (x + width == plot.x + plot.width && y + depth == plot.y + plot.depth))
			|| ((plot.x < x && x < plot.x + plot.width) && (y == plot.y || y + depth == plot.y + plot.depth))
			|| ((plot.y < y && y < plot.y + plot.depth) && (x == plot.x || x + width == plot.x + plot.width))
			|| ((x < plot.x && plot.x < x + width) && (plot.y == y || plot.y + plot.depth == y + depth))
			|| ((y < plot.y && plot.y < y + depth) && (plot.x == x || plot.x + plot.width == x + width))
			) {
			return true;
		}
		return false;
	}
	
	public boolean encompasses(Plot plot) {
		if(x <= plot.x && y <= plot.y && ((x+width) >= (plot.x + plot.width))
				&& ((y+depth) >= (plot.y + plot.depth))) {
			return true;
		}
		return false;
	}
	void setX(int ix) {
		// do some check here
		x = ix;
	}
	
	int getX() {
		return x;
	}
	void setY(int iy) {
		y = iy;
	}
	
	int getY() {
		return y;
	}
	
	void setWidth(int iwidth) {
		width = iwidth;
	}
	
	protected int getWidth() {
		return width;
	}
	
	void setDepth(int idepth) {
		depth = idepth;
	}
	
	int getDepth() {
		return depth;
	}
	
	public String toString() {
		return "Upper left: (" + Integer.toString(x) + "," + Integer.toString(y) + "); Width: " + Integer.toString(width) + " Depth: " + Integer.toString(depth);
	}
}
