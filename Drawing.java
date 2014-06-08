/**
 * Drawing.java
 * Class to set up arraylist containing all shapes.
 * 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 */
import java.awt.*;
import java.util.*;

public class Drawing {
	private Color color;
	// arraylist will hold shapes to be drawn
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	
	public Drawing(Color C) {
		color = C;
	}
	// go through arraylist backwards to draw shapes in order on apge
	public void draw(Graphics page) {

		for (int i = shapeList.size() - 1; i >= 0; i--) {
			shapeList.get(i).draw(page);
		}
	}
	
	public Shape getFrontmostContainer(Point p) {
		for (Shape shape : shapeList) {
			if (shape.containsPoint(p)) {
				return shape; 
			}
		}
		return null;
	}
	// overloaded setcolor, one to modify a shape, one to set the color indicator box
	public void setColor(Point p) {
		if (getFrontmostContainer(p) != null) {
		getFrontmostContainer(p).setColor(color);
		}
	}
	
	public void setColor(Color C) {
		color = C;
	}
	
	public Color getColor() {
		return color;
	}
	
	// moves the shape to the front of the arraylist
	public void moveToFront(Point p) {
		Shape temp = getFrontmostContainer(p);
		delete(getFrontmostContainer(p)); // delete the relevant object from the middle of the arraylist
		add(temp); // add it to the beginning
	}	
	// moves it to the back
	public void moveToBack(Point p) {
		Shape temp = getFrontmostContainer(p);
		delete(getFrontmostContainer(p));
		shapeList.add(temp);
	}
	
	public void delete(Shape shape) {
		shapeList.remove(shape);
	}
	
	public void add(Shape shape) {
		shapeList.add(0, shape);
	}
	
	// so that command buttons can be updated properly
	public void replace(Shape shape) {
		shapeList.remove(0);
		add(shape);
	}
	
}