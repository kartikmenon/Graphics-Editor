/**
 * EllipseButtonCmd.java
 * Command class to perform an ellipse command.
 * 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Command
 */

import java.awt.*;

public class EllipseButtonCmd extends Command {
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
	// add an initial ellipse to arraylist when mouse pressed
	dwg.add(new Ellipse(color, p));
	}
	
	public void executeDrag(Point p, Drawing dwg) {
		
		// height and width of bounding box of ellipse
		width = Math.abs(p.x - startX);
		height = Math.abs(p.y - startY);
		
		// remove old ellipse and add new one with updated dimensions.
		Point p1 = new Point((int) Math.min(p.x, startX), (int) Math.min(p.y, startY));
		Ellipse updated = new Ellipse(color, p1);
		updated.setDimensions((int) width, (int) height);
		dwg.replace(updated);
	
	}
}