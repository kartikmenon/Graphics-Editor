/**
 * RectButtonCmd.java
 * Command class to perform a rectangle command.
 * 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Command
 */

import java.awt.*;

public class RectButtonCmd extends Command {
	double startX;
	double startY;
	double width;
	double height;
	Color color;
	
	public void executePress(Point p, Drawing dwg) {
	startX = p.x;
	startY = p.y;
	width = 0;
	height = 0;
	color = dwg.getColor();
	
	// add a new rectangle shape object to the arraylist in drawing
	dwg.add(new Rect(color, p));
	}
	
	
	public void executeDrag(Point p, Drawing dwg) {
		
		// modify the width and height as the difference between the mouse and the starting point
		width = Math.abs(p.x - startX);
		height = Math.abs(p.y - startY);
		Point p1 = new Point((int) Math.min(p.x, startX), (int) Math.min(p.y, startY));
		
		// update the height and width and replace the rectangle in the arraylist
		Rect updated = new Rect(color, p1);
		updated.setDimensions((int) width, (int) height);
		dwg.replace(updated);
	
	}
}