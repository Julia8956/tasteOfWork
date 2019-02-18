package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.vo.A_Member;
import model.vo.Project;

public class B_HomeBarPanel extends JPanel implements MouseListener, ActionListener {

	private MainFrame mainFrame;
	private B_ProjectPage projectPage;
	private B_HomeBarPanel homeBarPanel;
	private JButton User_btn;
	private JButton Member_btn;
	private JButton homeButton;
	private JButton backButton;
	
	private Project selectedProject;
	private A_Member user;

	public B_HomeBarPanel(MainFrame mainFrame, B_ProjectPage projectPage, Project selectedProject, A_Member user) {

		this.projectPage = projectPage;
		this.homeBarPanel = this;
		this.mainFrame = mainFrame;
		
		this.selectedProject = selectedProject;
		this.user = user;
		// this.setSize(1024, 80);
		this.setPreferredSize(new Dimension(1024, 65));
		// this.setLocation(0, 0);
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());

		// 홈버튼과 뒤로가기 버튼을 올리는 패널
		JPanel West_Panel = new JPanel();
		West_Panel.setPreferredSize(new Dimension(130, 65));
		West_Panel.setLayout(new BorderLayout());
		West_Panel.setBackground(Color.GRAY);

		// 홈버튼
		homeButton = new JButton(new ImageIcon("images/home.PNG"));
		ImageIcon home2 = new ImageIcon("images/home2.PNG");
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setRolloverIcon(home2);
		homeButton.setPreferredSize(new Dimension(40, 40));
		homeButton.addActionListener(this);
		homeButton.setToolTipText("메인페이지로 이동");

		/*// 뒤로가기 버튼
		backButton = new JButton(new ImageIcon("images/back.PNG"));
		ImageIcon back2 = new ImageIcon("images/back2.PNG");

		// 버튼 뒤에 배경 지우는 함수
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setRolloverIcon(back2);
		backButton.setPreferredSize(new Dimension(40, 40));
		backButton.addActionListener(this);*/

		West_Panel.add(homeButton, "West");
		//West_Panel.add(backButton, "Center");

		JPanel Center_Panel = new JPanel();
		Center_Panel.setPreferredSize(new Dimension(300, 65));
		Center_Panel.setLayout(new BoxLayout(Center_Panel, BoxLayout.Y_AXIS));
		// Center_Panel.setLayout(null);
		Center_Panel.setBackground(Color.GRAY);

		JPanel pro_Panel = new JPanel();
		pro_Panel.setPreferredSize(new Dimension(100, 10));
		pro_Panel.setBackground(Color.GRAY);

		// 진행바
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		
		Date startDay = selectedProject.getProjectStartDay();
		Date endDay = selectedProject.getProjectEndDay();
		Date today = new Date();
		
		
		long totalTime = endDay.getTime() - startDay.getTime(); 	//밀리세컨드
		int totalDay = (int)(((((totalTime / 1000) / 60) / 60) / 24)); 
		long timePast = today.getTime() - startDay.getTime();
		int dayPast = (int)(((((timePast / 1000) / 60) / 60) / 24)) + 1;
		
		//int totalDay = B_DdayPanel.totalDay;
		//int dayPast = B_DdayPanel.dayPast;
		/*int progress;
		if(totalDay != 0) {
			progress = dayPast);
		}else {
			progress = 0;
		}
		*/
		progressBar.setMaximum(totalDay);
		progressBar.setValue(dayPast);
		progressBar.setForeground(Color.decode("#72f07e"));

		// progressBar.setLocation(320,50);
		// progressBar.setSize(350,10);
		progressBar.setPreferredSize(new Dimension(350, 10));
		progressBar.setAlignmentX(CENTER_ALIGNMENT);
		progressBar.setAlignmentY(CENTER_ALIGNMENT);

		pro_Panel.add(progressBar);

		JLabel Sprint_Title = new JLabel();
		Sprint_Title.setText(selectedProject.toString());
		Sprint_Title.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		Sprint_Title.setAlignmentX(CENTER_ALIGNMENT);
		Sprint_Title.setAlignmentY(CENTER_ALIGNMENT);
		// Sprint_Title.setLocation(100,10);
		// Sprint_Title.setSize(600, 35);

		Sprint_Title.setPreferredSize(new Dimension(600, 50));

		Center_Panel.add(Sprint_Title);
		Center_Panel.add(pro_Panel);

		// Center_Panel.add(BoxLayout_Panel,"Center");

		// East Panel -> 사용자 정보 버튼, 멤버 버튼
		JPanel East_Panel = new JPanel();
		East_Panel.setPreferredSize(new Dimension(120, 65));
		East_Panel.setLayout(new BorderLayout());
		East_Panel.setBackground(Color.gray);

		// 사용자 버튼
		User_btn = new JButton(new ImageIcon("images/user.PNG"));
		ImageIcon User2_btn = new ImageIcon("images/user2.PNG");
		// 버튼 뒤에 배경 지우는 함수
		User_btn.setBorderPainted(false);
		User_btn.setFocusPainted(false);
		User_btn.setContentAreaFilled(false);
		User_btn.setRolloverIcon(User2_btn);

		User_btn.setLocation(968, 12);
		User_btn.setSize(40, 40);

		User_btn.addMouseListener(this);

		// 멤버버튼
		Member_btn = new JButton(new ImageIcon("images/circle.png"));
		ImageIcon Member_addIcon = new ImageIcon("images/circle2.PNG");
		Member_btn.setBorderPainted(false);
		Member_btn.setFocusPainted(false);
		Member_btn.setContentAreaFilled(false);
		Member_btn.setRolloverIcon(Member_addIcon);
		Member_btn.setBackground(Color.GRAY);
		Member_btn.setLocation(920, 12);
		Member_btn.setSize(40, 40);
		
		Member_btn.addMouseListener(this);

		/*// 초대 panel
		JPanel Member_panel = new JPanel();
		Member_panel.setLayout(null);
		Member_panel.setLocation(625, 40);
		Member_panel.setSize(310, 310);
		Member_panel.setBackground(Color.decode("#5A5959"));
		Member_panel.setVisible(true);

		// 멤버
		JLabel Add_label = new JLabel("프로젝트 멤버");
		Add_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		Add_label.setForeground(Color.WHITE);
		Add_label.setLocation(10, 0);
		Add_label.setSize(120, 40);

		// 멤버보여지는 것
		JTextArea T_Member = new JTextArea("● 김규형 \n ● 문지원\n ● 송낙규\n ● 우리나\n ● 정민지\n ● 최인효 ");
		T_Member.setEditable(false);

		// 멤버 스크롤
		JScrollPane M_Scroll = new JScrollPane(T_Member);
		M_Scroll.setLocation(20, 40);
		M_Scroll.setSize(250, 200);

		// 관리자 panel
		JPanel Man_Div_panel = new JPanel();
		Man_Div_panel.setLayout(null);
		Man_Div_panel.setSize(310, 100);
		Man_Div_panel.setLocation(0, 242);
		Man_Div_panel.setBackground(Color.decode("#5A5959"));

		// 멤버 초대 버튼
		JButton Add_Button = new JButton(new ImageIcon("images/button1-1.png"));
		ImageIcon Add_ButtonIcon = new ImageIcon("images/button1-2.png");
		Add_Button.setBorderPainted(false);
		Add_Button.setFocusPainted(false);
		Add_Button.setContentAreaFilled(false);
		Add_Button.setRolloverIcon(Add_ButtonIcon);
		Add_Button.setSize(80, 40);
		Add_Button.setLocation(20, 10);
		// Add_Button.addActionListener(new Add_person());

		// 멤버 강퇴 버튼
		JButton Fire_Button = new JButton(new ImageIcon("images/button2-1.png"));
		ImageIcon Fire_ButtonIcon = new ImageIcon("images/button2-2.png");
		Fire_Button.setBorderPainted(false);
		Fire_Button.setFocusPainted(false);
		Fire_Button.setContentAreaFilled(false);
		Fire_Button.setRolloverIcon(Fire_ButtonIcon);
		Fire_Button.setSize(80, 40);
		Fire_Button.setLocation(115, 10);

		// 멤버 탈퇴 버튼
		JButton Delete_Button = new JButton(new ImageIcon("images/button3-1.png"));
		ImageIcon Delete_ButtonIcon = new ImageIcon("images/button3-2.png");
		Delete_Button.setBorderPainted(false);
		Delete_Button.setFocusPainted(false);
		Delete_Button.setContentAreaFilled(false);
		Delete_Button.setRolloverIcon(Delete_ButtonIcon);
		Delete_Button.setSize(80, 40);
		Delete_Button.setLocation(210, 10);

		// Delete_Button.addActionListener(new DeleteEvent());

		Man_Div_panel.add(Add_Button);
		Man_Div_panel.add(Delete_Button);
		Man_Div_panel.add(Fire_Button);

		Member_panel.add(Add_label);
		Member_panel.add(M_Scroll);
		Member_panel.add(Man_Div_panel);

		East_Panel.add(Member_panel, "East");*/

		East_Panel.add(User_btn, "Center");
		East_Panel.add(Member_btn, "West");

		this.add(West_Panel, "West");
		this.add(Center_Panel, "Center");
		this.add(East_Panel, "East");
		
		
		
		projectPage.add(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == User_btn) {
			new A_AddUserPU(mainFrame, user).getUserPU().setVisible(true);
		}
		if (e.getSource() == Member_btn) {
			new B_AddInvitePU(mainFrame, selectedProject, user).getinvitePU().setVisible(true);
		}
	}

	
	//홈버튼 클릭시 메인페이지로 넘어가는 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == homeButton) {
			projectPage.goToMainPage();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
