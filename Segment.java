/**
 * Segment.java
 * Class for a line segment.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 * Modified by Kartik Menon and Amy Jiang. 
 *
 * @author Thomas H. Cormen
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Shape
 */

import java.awt.*;

public class Segment extends Shape {
	private int endX;
	private int endY;
	private int startX;
	private int startY;
	private Color color;
	private double TOLERANCE = 3.0;


  // Helper method that returns true if Point p is within a TOLERANCE of a
  // given bounding box. Here, the bounding box is given by the coordinates of
  // its left, top, right, and bottom.
	
  public Segment(Color c, Point start, Point end) {
		super(c);
		startX = start.x;
		startY = start.y;
		endX = end.x;
		endY = end.y;
	}
  
  // midpoint formula for a line
  public Point getCenter() {
  	Point center = new Point ((int) (startX + endX) / 2, (int) (startY + endY) / 2);
  	return center;
  }
  
  // update all the coordinates by a change in x, y
  public void move(int deltaX, int deltaY) {
  	startX += deltaX;
  	startY += deltaY;
  	endX += deltaX;
  	endY += deltaY;
  }
  
  public boolean containsPoint(Point p) {

  	//Tests
  //System.out.println(startX + " " + startY + " , " + endX + " " + endY);
  //System.out.println(almostContainsPoint(p, startX, startY, endX, endY, TOLERANCE) && 
  		//distanceToPoint(p, startX, startY, endX, endY) <= TOLERANCE);
  
  // need min, max functions to make sure that points will be found inside tolerance box of segment
  return almostContainsPoint(p, Math.min(startX, endX), Math.min(startY, endY), 
  		Math.max(startX, endX), Math.max(startY, endY), TOLERANCE) &&
  		distanceToPoint(p, startX, startY, endX, endY) <= TOLERANCE;
  
  }
  
  public void drawShape(Graphics page) {
  	page.setColor(color);
  	page.drawLine(startX, startY, endX, endY);
  }

  
  private static boolean almostContainsPoint(Point p, int left, int top,
      int right, int bottom, double TOLERANCE) {
    return p.x >= left - TOLERANCE && p.y >= top - TOLERANCE
        && p.x <= right + TOLERANCE && p.y <= bottom + TOLERANCE;
  }

  // Helper method that returns the distance from Point p to the line
  // containing a line segment whose endpoints are given.
  private static double distanceToPoint(Point p, int x1, int y1, int x2,
      int y2) {
    if (x1 == x2) // vertical segment?
      return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
    else if (y1 == y2) // horizontal segment?
      return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
    else {
      // Here, we know that the segment is neither vertical nor
      // horizontal.
      // Compute m, the slope of the line containing the segment.
      double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

      // Compute mperp, the slope of the line perpendicular to the
      // segment.
      double mperp = -1.0 / m;

      // Compute the (x, y) intersection of the line containing the
      // segment and the line that is perpendicular to the segment and that
      // contains Point p.
      double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
          / (mperp - m);
      double y = m * (x - x1) + y1;

      // Return the distance between Point p and (x, y).
      return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
  }
}
