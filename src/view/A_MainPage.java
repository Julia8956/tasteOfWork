package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProjectManager;
import model.vo.Project;
import model.vo.Sprint;

public class A_MainPage extends JPanel{

	private MainFrame mf;
	private JButton sprintAdd;
	private A_MainPage mainPage;
	private Dialog mainDial;
	private A_LoginPage lp;
	private A_AddProject ap;
	private JPanel projectbtnPanel = new JPanel();
	private JPanel newprojectbtnPanel = new JPanel();

	private Dialog addProject;

	private JButton projectBtn;
	private ArrayList btnList = new ArrayList();
	
	private ProjectManager pm = new ProjectManager();
	private Project selectedProject;

	//private ArrayList<Project> projectArrList = new ArrayList<Project>();

	public A_MainPage(MainFrame mf) {


		this.mf=mf;
		this.mainPage=this;
		this.lp = lp;


		this.setSize(1024, 768);
		this.setLayout(new BorderLayout());


		JPanel upup  = new JPanel();

		upup.setPreferredSize(new Dimension(1024,65));
		upup.setLayout(new BorderLayout());
		upup.setBackground(Color.GRAY);

		//상단 홈 버튼


		JButton home = new JButton(new ImageIcon("images/home.png"));

		ImageIcon home2 = new ImageIcon("images/home2.png");
		home.setBorderPainted(false); 
		home.setFocusPainted(false); 
		home.setContentAreaFilled(false);
		home.setRolloverIcon(home2);
		home.setLocation(10,12);
		home.setSize(40, 40);


		upup.add(home, BorderLayout.WEST);

		//상단 검색 버튼

		JPanel findpanel = new JPanel();
		findpanel.setPreferredSize(new Dimension(100,65));
		findpanel.setLayout(null);
		//findpanel.setLayout(new FlowLayout());
		findpanel.setBackground(Color.GRAY);

		/*JButton find = new JButton(new ImageIcon("images/serch.PNG"));
		ImageIcon find2 = new ImageIcon("images/serch2.PNG");
		find.setBorderPainted(false); 
		find.setFocusPainted(false); 
		find.setContentAreaFilled(false);
		find.setRolloverIcon(find2);
		find.setSize(30, 30);
		find.setLocation(10,20);

		JTextField findt = new JTextField(20);
		findt.setLocation(40,20);
		findt.setSize(170,30);

		findpanel.add(find);
		findpanel.add(findt);*/

		upup.add(findpanel, BorderLayout.CENTER);

		//상단 계정 버튼


		JButton person = new JButton(new ImageIcon("images/user.PNG"));
		ImageIcon person2 = new ImageIcon("images/user2.PNG");
		person.setBorderPainted(false); 
		person.setFocusPainted(false); 
		person.setContentAreaFilled(false);
		person.setRolloverIcon(person2);
		person.setLocation(968,12);
		person.setSize(40, 40);
		person.addActionListener(new UserEvent());

		upup.add(person, BorderLayout.EAST);


		this.add(upup, BorderLayout.NORTH);






		JPanel side = new JPanel();
		side.setPreferredSize(new Dimension(300,768));
		//side.setBackground(Color.CYAN);
		side.setBackground(Color.decode("#99cccc"));
		side.setLayout(null);

		JButton find = new JButton(new ImageIcon("images/serch.PNG"));
		ImageIcon find2 = new ImageIcon("images/serch2.PNG");
		find.setBorderPainted(false); 
		find.setFocusPainted(false); 
		find.setContentAreaFilled(false);
		find.setRolloverIcon(find2);
		find.setSize(30, 30);
		find.setLocation(10,20);

		JTextField findt = new JTextField(20);
		findt.setLocation(40,20);
		findt.setSize(170,30);

		side.add(find);
		side.add(findt);



		//JButton pro = new JButton("새 프로젝트 추가");
		JButton pro = new JButton(new ImageIcon("images/newProjectbtn.png"));
		pro.setBorderPainted(false); 
		pro.setFocusPainted(false); 
		pro.setContentAreaFilled(false);
		pro.setSize(200,50);
		pro.setLocation(10,80);
		//pro.addMouseListener(new MyMouseAdapter1());;
		pro.addActionListener(new ProEvent());

		side.add(pro);

		this.add(side, BorderLayout.WEST);

		//projectbtnPanel.setSize(800, 768);
		//projectbtnPanel.setBackground(Color.YELLOW);
		projectbtnPanel.setLayout(new BorderLayout());

		//newprojectbtnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		newprojectbtnPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		newprojectbtnPanel.setBackground(Color.decode("#99cccc"));
		newprojectbtnPanel.setPreferredSize(new Dimension(700,600));
		//newprojectbtnPanel.setBackground(Color.YELLOW);

		JPanel ingPanel = new JPanel();
		ingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		ingPanel.setPreferredSize(new Dimension(700,200));
		ingPanel.setBackground(Color.decode("#99cccc"));

		//JLabel ingLabel = new JLabel("진행중인 프로젝트");
		JLabel ingLabel = new JLabel("◎ 진행중인 프로젝트 ◎");
		ingLabel.setFont(new Font("HY바다M", Font.BOLD, 21));
		ingPanel.add(ingLabel);

		projectbtnPanel.add(ingPanel, "North");
		projectbtnPanel.add(newprojectbtnPanel,"Center");

		this.add(projectbtnPanel, "Center");

		JPanel addButton = new JPanel();
		addButton.setLayout(null);
		addButton.setBackground(Color.decode("#99cccc"));
		addButton.setSize(600,300);
		addButton.setLocation(200,100);



		JButton btn1 = new JButton("자바칩프라푸치노");
		btn1.setSize(200,130);
		btn1.setLocation(105,35);
		btn1.setBorderPainted(false);
		btn1.setBackground(Color.white); 

		addButton.add(btn1);

		JButton btn2 = new JButton("자바칩프라푸치노+사이즈업");
		btn2.setSize(200,130);
		btn2.setLocation(310,35);
		btn2.setBorderPainted(false);
		btn2.setBackground(Color.white); 
		addButton.add(btn2);


		
		this.add(addButton);
		//this.add(projectbtnPanel,BorderLayout.CENTER);

		/*JButton btn1 = new JButton("버튼1");
		newprojectbtnPanel.add(btn1);*/
		this.add(projectbtnPanel,BorderLayout.CENTER);
		//this.add(projectbtnPanel);


		//projectBtn.addMouseListener(this);


	}
	
	
	
	public void makeNewProject(String projectTitle, Date projectStartDay, Date projectEndDay, ArrayList<Sprint> sprintList) {


		/*Project project = */pm.makeNewProject(projectTitle, projectStartDay, projectEndDay, sprintList);
		
		//JButton projectTitle = new JButton();
		
		projectBtn = new JButton(projectTitle);
		
		/*ButtonGroup bg = new ButtonGroup();
		bg.add(projectBtn);*/

		btnList.add(projectBtn);
		projectBtn.setPreferredSize(new Dimension(200,130));
		projectBtn.setVisible(true);
		projectBtn.setBackground(Color.white); 
		projectBtn.setBorderPainted(false);
		projectBtn.setToolTipText("마우스 오른쪽 버튼을 눌러 프로젝트 정보를 수정하세요");
		newprojectbtnPanel.add(projectBtn);
		//newprojectbtnPanel.addMouseListener(new projectEvent());
		projectbtnPanel.revalidate();
		newprojectbtnPanel.revalidate();
		eventLink();

		
		
	}

	public void eventLink() {
		for(int i = 0; i < btnList.size(); i++) {
			JButton projectBtn = (JButton)btnList.get(i);
			projectBtn.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {

					if (e.getButton() == 1) {
						
						String titleSelected = projectBtn.getText();
						selectedProject = pm.getProject(titleSelected);
						goToProjectPage(selectedProject);
					}
					
					if (e.getButton() == 3) {
						String titleSelected = projectBtn.getText();
						selectedProject = pm.getProject(titleSelected);
						new A_AddProject(mf, mainPage, selectedProject).getAddProject().setVisible(true);
						
					}
				}
			});
		}
	}
	
	
	public void modifyProject(Project project, String projectTitle, Date projectStartDay, Date projectEndDay, ArrayList<Sprint> sprintList) {
		
		pm.modifyProject(project, projectTitle, projectStartDay, projectEndDay, sprintList);
		
		projectBtn.setText(projectTitle);

		//projectBtn.addMouseListener(this);
	}

	


	
	
	//프로젝트생성버튼 클릭시 동작하는 이벤트
	class ProEvent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new A_AddProject(mf, mainPage, null).getAddProject().setVisible(true);
		}
	}
	
	
	
	
	class UserEvent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new A_AddUserPU(mf,lp).getUserPU().setVisible(true);
		}
	}
	
	
	
	
	public void goToProjectPage(Project selectedProject) {
		ChangePanel.changePanel(mf, this, new B_ProjectPage(mf, this, selectedProject));
	}
	
	public void goToLoginPage() {
		ChangePanel.changePanel(mf, this, new A_LoginPage(mf));
	}
	
	public Dialog getMainDial() {
		return mainDial;
	}
	
	
	
	
	

}




