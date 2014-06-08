/**
 * DeleteCmd.java
 * Command class to perform a delete command.
 * 
 * @author Kartik Menon and Amy Jiang - October 20, 2013
 * @see Command
 */

import java.awt.*;

public class DeleteCmd extends Command {
	
	public void executeClick(Point p, Drawing dwg) {
    // Find the frontmost shape containing p.
    Shape s = dwg.getFrontmostContainer(p);
    dwg.delete(s); // calls drawing method
    }
	}
