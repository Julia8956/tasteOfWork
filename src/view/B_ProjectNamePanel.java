package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class B_ProjectNamePanel extends JPanel {

	public B_ProjectNamePanel(B_ProjectPage projectPage) {
		
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setBackground(Color.WHITE);
		//프로젝트명 : 프로젝트 생성시 입력한 이름으로 받아와야 함
		JLabel projectName = new JLabel("프로젝트명", JLabel.LEFT);
		projectName.setHorizontalAlignment(JLabel.CENTER);
		projectName.setVerticalAlignment(JLabel.CENTER);
		projectName.setFont(new Font("", Font.BOLD, 30));
		//this.add(projectName);
		
		projectPage.add(this);
	}
}
