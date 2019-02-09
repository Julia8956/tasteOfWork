package view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class B_DdayPanel extends JPanel{

	public B_DdayPanel(B_ProjectPage projectPage) {

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		//디데이 : 프로젝트 생성시 날짜로 카운트 해야함//계속 변하도록 
		JLabel projectDday = new JLabel("D-Day", JLabel.LEFT); 
		projectDday.setHorizontalAlignment(JLabel.CENTER);
		projectDday.setFont(new Font("", Font.BOLD, 20));
		this.add(projectDday);
		
		projectPage.add(this);
	}
}
