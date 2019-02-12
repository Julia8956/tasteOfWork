package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class C_MenuBarPanel extends JPanel implements MouseListener,ActionListener{
	
	private MainFrame mf;
	private C_SprintMainPage sprintMain;
	private C_MenuBarPanel MenuPanel;
	
	private JButton User_btn;
	private JButton home;
	private JButton back;
	
	public C_MenuBarPanel(C_SprintMainPage sprintMain, MainFrame mf) {
		this.sprintMain = sprintMain;
		this.MenuPanel = this;
		this.mf = mf;
		
		//this.setPreferredSize(new Dimension(1024,65));
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		
		//홈버튼과 뒤로가기 버튼
		JPanel West_Panel = new JPanel();
		West_Panel.setPreferredSize(new Dimension(130,65));
		West_Panel.setLayout(new BorderLayout());
		West_Panel.setBackground(Color.GRAY);
		
		//Home 버튼
		/*JButton*/ home = new JButton(new ImageIcon("images/home.PNG"));
		ImageIcon home2 = new ImageIcon("images/home2.PNG");
		//버튼 뒤에 배경 지우는 함수
		home.setBorderPainted(false); 
		home.setFocusPainted(false); 
		home.setContentAreaFilled(false);
		home.setRolloverIcon(home2);
		
		//버튼에 마우스 올릴시 텍스트 뜨도록 추가함
		home.setToolTipText("메인페이지로 이동");

		//home.setLocation(10,12);
		//home.setSize(40, 40);
		home.setPreferredSize(new Dimension(40,40));
		home.addActionListener(this);
		
		//back 버튼
		/*JButton*/ back = new JButton(new ImageIcon("images/back.PNG"));
		ImageIcon back2 = new ImageIcon("images/back2.PNG");

		//버튼 뒤에 배경 지우는 함수
		back.setBorderPainted(false); 
		back.setFocusPainted(false); 
		back.setContentAreaFilled(false);
		back.setRolloverIcon(back2);

		//버튼에 마우스 올릴시 보일것
		back.setToolTipText("프로젝트 페이지로 이동");
		
		
		back.addActionListener(this);
		//back.setLocation(65,13);
		//back.setSize(40, 40);
		
		back.setPreferredSize(new Dimension(40,40));
		
		West_Panel.add(home,"West");
		West_Panel.add(back,"Center");
		
		//중간 Panel = 포로젝트 명 과 프로젝트 바
		JPanel Center_Panel = new JPanel();
		Center_Panel.setPreferredSize(new Dimension(300,65));
		Center_Panel.setLayout(new BoxLayout(Center_Panel,BoxLayout.Y_AXIS));
		//Center_Panel.setLayout(null);
		Center_Panel.setBackground(Color.GRAY);
		
		JPanel pro_Panel = new JPanel();
		pro_Panel.setPreferredSize(new Dimension(100,10));
		pro_Panel.setBackground(Color.GRAY);
	
		//진행바
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(50);
		progressBar.setForeground(Color.decode("#72f07e"));

		//progressBar.setLocation(320,50);
		//progressBar.setSize(350,10);
		progressBar.setPreferredSize(new Dimension(350,10));
		progressBar.setAlignmentX(CENTER_ALIGNMENT);
		progressBar.setAlignmentY(CENTER_ALIGNMENT);
		
		pro_Panel.add(progressBar);
		
		JLabel Sprint_Title = new JLabel();
		Sprint_Title.setText("프로젝트 명 - 스프린트명 (yyyy/MM/dd ~ yyyy/MM/dd)");
		Sprint_Title.setFont(new Font("맑은 고딕",Font.BOLD,19));
		Sprint_Title.setAlignmentX(CENTER_ALIGNMENT);
		Sprint_Title.setAlignmentY(CENTER_ALIGNMENT);
		//Sprint_Title.setLocation(100,10);
		//Sprint_Title.setSize(600, 35);
		
		Sprint_Title.setPreferredSize(new Dimension(600,50));
		
		Center_Panel.add(Sprint_Title);
		Center_Panel.add(pro_Panel);
		
		//Center_Panel.add(BoxLayout_Panel,"Center");
		
		//East Panel -> 사용자 정보 버튼, 멤버 버튼
		JPanel East_Panel = new JPanel();
		East_Panel.setPreferredSize(new Dimension(120,65));
		East_Panel.setLayout(new BorderLayout());
		East_Panel.setBackground(Color.gray);
		
		//사용자 버튼
		User_btn = new JButton(new ImageIcon("images/user.PNG"));
		ImageIcon User2_btn = new ImageIcon("images/user2.PNG");
		//버튼 뒤에 배경 지우는 함수
		User_btn.setBorderPainted(false); 
		User_btn.setFocusPainted(false); 
		User_btn.setContentAreaFilled(false);
		User_btn.setRolloverIcon(User2_btn);

		User_btn.setLocation(968,12);
		User_btn.setSize(40, 40);
		
		User_btn.addMouseListener(this);
		
		
		//멤버버튼
		JButton Member_btn = new JButton(new ImageIcon("images/circle.png"));
		ImageIcon Member_addIcon = new ImageIcon("images/circle2.PNG");
		Member_btn.setBorderPainted(false); 
		Member_btn.setFocusPainted(false); 
		Member_btn.setContentAreaFilled(false);
		Member_btn.setRolloverIcon(Member_addIcon);
		Member_btn.setBackground(Color.GRAY);
		Member_btn.setLocation(920, 12);
		Member_btn.setSize(40,40);

		//초대 panel 
		JPanel Member_panel = new JPanel();
		Member_panel.setLayout(null);
		Member_panel.setLocation(625, 40);
		Member_panel.setSize(310, 310);
		Member_panel.setBackground(Color.decode("#5A5959"));
		Member_panel.setVisible(true);

		//멤버
		JLabel Add_label = new JLabel("프로젝트 멤버");
		Add_label.setFont(new Font("맑은 고딕",Font.BOLD,18));
		Add_label.setForeground(Color.WHITE);
		Add_label.setLocation(10,0);
		Add_label.setSize(120, 40);

		//멤버보여지는 것
		JTextArea T_Member = new JTextArea("● 김규형 \n ● 문지원\n ● 송낙규\n ● 우리나\n ● 정민지\n ● 최인효 ");
		T_Member.setEditable(false);

		//멤버 스크롤
		JScrollPane M_Scroll = new JScrollPane(T_Member); 
		M_Scroll.setLocation(20, 40);
		M_Scroll.setSize(250,200);

		//관리자 panel
		JPanel Man_Div_panel = new JPanel();
		Man_Div_panel.setLayout(null);
		Man_Div_panel.setSize(310,100);
		Man_Div_panel.setLocation(0,242);
		Man_Div_panel.setBackground(Color.decode("#5A5959"));

		//멤버 초대 버튼
		JButton Add_Button = new JButton(new ImageIcon("images/button1-1.png"));
		ImageIcon Add_ButtonIcon = new ImageIcon("images/button1-2.png");
		Add_Button.setBorderPainted(false); 
		Add_Button.setFocusPainted(false); 
		Add_Button.setContentAreaFilled(false);
		Add_Button.setRolloverIcon(Add_ButtonIcon);
		Add_Button.setSize(80,40);
		Add_Button.setLocation(20,10);
		//Add_Button.addActionListener(new Add_person());

		//멤버 강퇴 버튼
		JButton Fire_Button = new JButton(new ImageIcon("images/button2-1.png"));
		ImageIcon Fire_ButtonIcon = new ImageIcon("images/button2-2.png");
		Fire_Button.setBorderPainted(false); 
		Fire_Button.setFocusPainted(false); 
		Fire_Button.setContentAreaFilled(false);
		Fire_Button.setRolloverIcon(Fire_ButtonIcon);
		Fire_Button.setSize(80,40);
		Fire_Button.setLocation(115,10);

		// 멤버 탈퇴 버튼
		JButton Delete_Button = new JButton(new ImageIcon("images/button3-1.png"));
		ImageIcon Delete_ButtonIcon = new ImageIcon("images/button3-2.png");
		Delete_Button.setBorderPainted(false); 
		Delete_Button.setFocusPainted(false); 
		Delete_Button.setContentAreaFilled(false);
		Delete_Button.setRolloverIcon(Delete_ButtonIcon);
		Delete_Button.setSize(80,40);
		Delete_Button.setLocation(210,10);

		//Delete_Button.addActionListener(new DeleteEvent());

		Man_Div_panel.add(Add_Button);
		Man_Div_panel.add(Delete_Button);
		Man_Div_panel.add(Fire_Button);


		Member_panel.add(Add_label);
		Member_panel.add(M_Scroll);
		Member_panel.add(Man_Div_panel);

		
		
		East_Panel.add(Member_panel,"East");
		
		East_Panel.add(User_btn,"Center");
		East_Panel.add(Member_btn,"West");
		
		this.add(West_Panel, "West");
		this.add(Center_Panel,"Center");
		this.add(East_Panel,"East");
		
		sprintMain.add(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == User_btn) {
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == home) {
			//C_SprintMainPage sm = new C_SprintMainPage(mf);
			//MainPage mp = new MainPage(mf);
			sprintMain.goToMainPage();
			//ChangePanel.changePanel(mf, loginPage, new Join());
			//ChangePanel.changePanel(mf,this.sprintMain, mp);
		}
		if (e.getSource() == back) {
			//B_ProjectPage projectPage = new B_ProjectPage(mf);
			sprintMain.goToProjectPage();
			//ChangePanel.changePanel(mf, this.sprintMain, projectPage);			
		}
	}
	
	
}
