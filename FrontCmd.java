/**
 * FrontCmd.java
 * Command class to perform a move to front command.
 * 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Command
 */

import java.awt.*;

public class FrontCmd extends Command {
	
	public void executeClick(Point p, Drawing dwg) {
		dwg.moveToFront(p); // calls drawing method
		
	}
}