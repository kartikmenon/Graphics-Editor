/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 * Modified by Kartik Menon and Amy Jiang.
 *
 * @author Thomas H. Cormen 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Shape
 */

import java.awt.*;

public class Ellipse extends Shape {


	// instance variables are height and width of bounding box of Ellipse
	private double width;
	private double height;
	private double startX;
	private double startY;
	private Color color;
	
  public Ellipse(Color c, Point p) {
		super(c);
		startX = p.x;
		startY = p.y;
	}
  
  // Helper method that returns whether Point p is in an Ellipse with the given
  // top left corner and size.
  private static boolean pointInEllipse(Point p, int left, int top, int width,
      int height) {
    double a = width / 2.0; // half of the width
    double b = height / 2.0; // half of the height
    double centerx = left + a; // x-coord of the center
    double centery = top + b; // y-coord of the center
    double x = p.x - centerx; // horizontal distance between p and center
    double y = p.y - centery; // vertical distance between p and center

    // Now we just apply the standard geometry formula.
    // (See CRC, 29th edition, p. 178.)
    return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
  }
  // extended from Shape
  public Point getCenter() {
  	
  	double x = width / 2;
  	double y = height / 2;
  	
  	double centerx = startX + x;
  	double centery = startY + y;
  	
  	Point center = new Point((int) centerx, (int) centery);
  	
  	return center;
  }
  // calls another function
  public boolean containsPoint(Point p) {
  	return pointInEllipse(p, (int) startX, (int) startY, (int) width, (int) height);
  }
  
  public void drawShape(Graphics page) {
  	page.setColor(color);
  	page.fillOval((int) startX, (int) startY, (int) width, (int) height);
  	
  }
  // simple enough
  public void move(int deltaX, int deltaY) {
  	startX += deltaX;
  	startY += deltaY;
  }
	public void setDimensions(double ellipseWidth, double ellipseHeight) {
		width = ellipseWidth;
		height = ellipseHeight;
	}
}

