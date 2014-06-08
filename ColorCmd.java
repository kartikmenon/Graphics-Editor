/**
/ * ColorCmd.java
 * Command class to perform a color command.
 * 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Command
 */

import java.awt.Point;

public class ColorCmd extends Command {
	
	public void executeClick(Point p, Drawing dwg) {
		dwg.setColor(p); // calls drawing method
	}
}
