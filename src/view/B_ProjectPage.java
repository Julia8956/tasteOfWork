package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

//프로젝트 메인 페이지
public class B_ProjectPage extends JPanel{

	private MainFrame mainFrame;
	
	private B_ProjectPage projectPage;
	
	public B_ProjectPage(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		this.projectPage = this;
		
		this.setSize(1024, 768);
		this.setBackground(Color.BLUE);
		GridBagLayout gridbag = new GridBagLayout();
		this.setLayout(gridbag);
		GridBagConstraints gc = new GridBagConstraints();
		//this.getPreferredSize();
		//this.setLayout(null);
		
		
		//상단바
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 0.0;
		gc.weighty = 0.1;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.gridheight = 1;
		gridbag.setConstraints(new B_HomeBarPanel(this), gc);
		
		//디데이패널
		gc.weightx = 0.1;
		gc.weighty = 0.05;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gridbag.setConstraints(new B_DdayPanel(this), gc);
		
		//프로젝트명 패널
		gc.weightx = 0.5;
		gc.weighty = 0.05;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.gridheight = 1;
		//프로젝트명 패널
		gridbag.setConstraints(new B_ProjectNamePanel(this), gc);
		
		
		
		//스프린트 패널
		gc.weightx = 0.1;
		gc.weighty = 0.9;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gridbag.setConstraints(new B_SprintPanel(this, mainFrame), gc);
		
		
		//달력패널
		gc.weightx = 0.5;
		gc.weighty = 0.9;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gridbag.setConstraints(new B_CalendarPanel(this), gc);
		
		//회의록 패널
		gc.weightx = 0.2;
		gc.weighty = 0.1;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.gridheight = 1;
		gridbag.setConstraints(new B_MOMPanel(this), gc);
		//new MOMPanel(this);
		
		this.setVisible(true);
		
		
		mainFrame.add(this);
	}
	
	
}
