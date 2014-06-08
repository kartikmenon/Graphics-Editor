/**
 * SegmentButtonCmd.java
 * Command class to perform a segment command.
 * 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Command
 */

import java.awt.*;

public class SegmentButtonCmd extends Command {
	double startX;
	double startY;
	double endX;
	double endY;
	Color color;
	
	
	public void executePress(Point p, Drawing dwg) {
		startX = p.x;
		startY = p.y;
		
		// add a new segment to the arraylist
		color = dwg.getColor();
		dwg.add(new Segment(color, p, p));
	}
	
	public void executeDrag(Point p, Drawing dwg) {
		endX = p.x;
		endY = p.y;
		
		// do the segment from the starting point to the mouse point
		Point start = new Point((int) startX, (int) startY);
		
		Segment newSegment = new Segment(color, start, p);
		dwg.replace(newSegment);
		
	}
}