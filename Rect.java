/**
 * Rect.java
 * Class for a rectangle.
 *
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Shape
 */

import java.awt.*;

public class Rect extends Shape {
	private double startX;
	private double startY;
	private double width;
	private double height;
	private Color color;
	
	// constructor for rectangle object
	public Rect(Color c, Point p) {
		super(c);
		startX = p.x;
		startY = p.y;
		width = 0;
		height = 0;
	}

	// draw the rectangle
	public void drawShape(Graphics page) {
		page.setColor(color);
		page.fillRect((int) startX, (int) startY, (int) width, (int) height);
	}

	// see if it's contained in boundaries.
	public boolean containsPoint(Point p) {
		if (startX < p.x && p.x < startX + width && startY < p.y && p.y < startY + height) {
			return true;
		}
		return false;
	}


	public void move(int deltaX, int deltaY) {
		startX += deltaX;
		startY += deltaY;
	}

	// return center point
	public Point getCenter() {
		double x = width / 2;
  	double y = height / 2;
  	
  	double centerx = startX + x;
  	double centery = startY + y;
  	
  	Point center = new Point((int) centerx, (int) centery);
  	
  	return center;
	}
	// to be called in rect command.
	public void setDimensions(double rectWidth, double rectHeight) {
		width = rectWidth;
		height = rectHeight;
	}
}