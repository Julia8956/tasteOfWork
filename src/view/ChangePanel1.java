package view;

import javax.swing.JPanel;

public class ChangePanel1 {
	public static void changePanel1(SubFrame sf, JPanel op, JPanel np) {
		
		sf.remove(op);
		sf.add(np);
		sf.repaint();
		
		
	}
}