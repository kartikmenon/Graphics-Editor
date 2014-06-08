/**
 * BackCmd.java
 * Command class to perform a move to back command.
 * 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Command
 */

import java.awt.*;

public class BackCmd extends Command {
	
	public void executeClick(Point p, Drawing dwg) {
		dwg.moveToBack(p); // calls drawing method
	}
}