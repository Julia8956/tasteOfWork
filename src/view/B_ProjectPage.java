package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.vo.A_Member;
import model.vo.A_Member;
import model.vo.Project;
import model.vo.Sprint;

//프로젝트 메인 페이지
public class B_ProjectPage extends JPanel{

	private MainFrame mainFrame;
	public static final Color BG_COLOR = new Color(204, 245,255); 
	public static final Color POPUP_COLOR = new Color(1f, 0.7f, 0.7f, 0.8f);
	
	private A_MainPage mainPage;
	private B_ProjectPage projectPage;
	
	private Project selectedProject;
	private A_Member user;
	
	public B_ProjectPage(MainFrame mainFrame, A_MainPage mainPage, Project selectedProject, A_Member user) {
		
		this.mainFrame = mainFrame;
		this.projectPage = this;
		
		this.mainPage = mainPage;
		//현재페이지와 연결된 객체
		this.selectedProject = selectedProject;
		this.user = user;
		
		this.setSize(1024, 768);
		//this.setBackground(Color.BLUE);
		GridBagLayout gridbag = new GridBagLayout();
		this.setLayout(gridbag);
		GridBagConstraints gc = new GridBagConstraints();
		//this.getPreferredSize();
		//this.setLayout(null);
		
		
		//상단바
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 0.0;
		gc.weighty = 0.0;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_HomeBarPanel(mainFrame, this, selectedProject, user), gc);
		
		//디데이패널
		gc.weightx = 1;
		//gc.weighty = 0.05;
		gc.gridwidth = 1;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_DdayPanel(this, selectedProject), gc);
		
		//프로젝트명 패널
		gc.weightx = 0.5;
		//gc.weighty = 0.05;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		//gc.gridheight = 1;
		
		gridbag.setConstraints(new B_ProjectNamePanel(this), gc);
		
		
		
		//스프린트 패널
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridwidth = 1;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_SprintPanel(this, mainFrame, selectedProject), gc);
		
		
		//달력패널
		gc.weightx = 1;
		//gc.weighty = 0.9;
		gc.gridwidth = 1;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_CalendarPanel(this, selectedProject), gc);
		
		//회의록 패널
		gc.weightx = 1;
		//gc.weighty = 0.1;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		//gc.gridheight = 1;
		gridbag.setConstraints(new B_MOMPanel(this, mainFrame, selectedProject), gc);
		//new MOMPanel(this);
		
		this.setVisible(true);
		
		
		mainFrame.add(this);
	}
	
	public void goToMainPage() {
		ChangePanel.changePanel(mainFrame, this, mainPage);
	}
	
	public void goToSprintPage(Project selectedProject, Sprint selectedSprint) {
		ChangePanel.changePanel(mainFrame, this, new C_SprintMainPage(mainFrame, this, selectedProject, selectedSprint));
	}
	
	
	
	
}
