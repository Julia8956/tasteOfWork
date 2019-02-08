package view;

import javax.swing.JFrame;

public class SubFrame extends JFrame {
	public SubFrame() {
		
		
		this.setSize(515,560);
		
		new AddSprint(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
}
