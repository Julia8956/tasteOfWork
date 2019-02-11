package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		
		
		this.setSize(1024,768);
		
//		new LoginPage(this);
		new B_ProjectPage(this);
		//new C_SprintMainPage(this);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	
}
