/**
 * MoveCmd.java
 * Command class to perform a move command.
 * 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Command
 */

import java.awt.*;

public class MoveCmd extends Command {
	// get the right shape and a point 
	private Shape relevantShape;
	private Point oldPosition;
	
	public void executePress(Point p, Drawing dwg) {
		// find what's right under the mouse
		relevantShape = dwg.getFrontmostContainer(p);	
		
		// set position to mouse
		if (relevantShape != null) {
			oldPosition = p;
		}
	}
	
	public void executeDrag(Point p, Drawing dwg) {
	// keep updating old position with mouse
	if (relevantShape != null) {
		relevantShape.move(p.x - oldPosition.x, p.y - oldPosition.y);
		oldPosition = p;
	}
	}
}