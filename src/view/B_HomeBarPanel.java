package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class B_HomeBarPanel extends JPanel{

	private B_ProjectPage projectPage;
	private B_HomeBarPanel homeBarPanel;
	
	public B_HomeBarPanel(B_ProjectPage projectPage) {
		
		this.projectPage = projectPage;
		this.homeBarPanel = this;
		
		//this.setSize(1024, 80);
		this.setPreferredSize(new Dimension(1024, 65));
		//this.setLocation(0, 0);
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BorderLayout());
		
		//홈버튼 -> 클릭시 마이페이지로 넘어가야 함
		JButton homeButton =  new JButton();
		homeButton.setText("홈");
		homeButton.setSize(60, 60);
		//homeButton.setLocation(40, 10);
		this.add(homeButton, "West");
					
		//인원버튼과 계정버튼 포함 패널
		JPanel peopleAndProfilePanel = new JPanel();
		//peopleAndProfilePanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		
		
		
		//계정 프로필 버튼 -> 팝업으로 계정정보 보여주기
		JButton profileButton = new JButton();
		profileButton.setText("계정정보");
		profileButton.setSize(100, 60);
		//profileButton.setLocation(850, 10);
		//profileButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		//profileButton.setHorizontalAlignment(JButton.CENTER);
		peopleAndProfilePanel.add(profileButton);
		//프로젝트에 할당된 인원 리스트
		JButton showPeopleButton = new JButton();
		showPeopleButton.setText("프로젝트 인원 보기");
		showPeopleButton.setSize(130, 60);
		//showPeopleButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		//showPeopleButton.setLocation(670, 10);
		peopleAndProfilePanel.add(showPeopleButton);
		
		this.add(peopleAndProfilePanel, "East");
		
		
		projectPage.add(this);
		
	}
	
}
