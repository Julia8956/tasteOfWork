package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;




public class SprintMainPage extends JPanel {
	private MainFrame mf; //의미 브여
	private JPanel  mainPage;
	
	private JPanel P_User;		//사용자 panel
	private JPanel Add_panel;	//초대 panel
	private JButton B_add;		//초대 Button
	private JButton Delete_Button; 	//탈퇴 button
	private JButton B_user;		//사용자 Button
	//private JPanel P_BG;
	private int count = 0;
	
	private JList O_List; 		//OPEN List
	
	public SprintMainPage() {}
	
	
	public SprintMainPage(MainFrame mf) {
		this.mf = mf;
		this.mainPage = this;
	
		//this는 panel
		this.setSize(1024,768);
		this.setLayout(null);
		
		//다른 배경 panel 
		JPanel P_BG = new JPanel();
		P_BG.setLayout(null);
		P_BG.setSize(1024, 728);
		P_BG.setLocation(0, 0);
		
		
		//Menu바
		JPanel M_panel = new JPanel();
		M_panel.setLayout(null);
		M_panel.setBackground(Color.decode("#bebebe"));
		M_panel.setLocation(0,0);
		M_panel.setSize(1024,65);
		
		//Home 버튼
		JButton home = new JButton(new ImageIcon("Image/home.PNG"));
		
		//버튼 뒤에 배경 지우는 함수
		home.setBorderPainted(false); home.setFocusPainted(false); home.setContentAreaFilled(false);

		home.setLocation(10,0);
		home.setSize(40, 40);
		
		//진행바
		JProgressBar p = new JProgressBar();
		p.setMinimum(0);
		p.setMaximum(100);
		p.setValue(50);
		
		p.setLocation(320,40);
		p.setSize(350,10);
		
		M_panel.add(p);
	
		//초대 panel 
		Add_panel = new JPanel();
		Add_panel.setLayout(null);
		Add_panel.setLocation(625, 40);
		Add_panel.setSize(310, 310);
		Add_panel.setBackground(Color.decode("#5A5959"));
		Add_panel.setVisible(false);
		
		//멤버
		JLabel Add_label = new JLabel("프로젝트 멤버");
		Add_label.setFont(new Font("Serif",Font.BOLD,18));
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
		
		JButton Add_Button = new JButton("초대");
		Add_Button.setSize(80,40);
		Add_Button.setLocation(20,10);
		
		Add_Button.addActionListener(new Add_person());
		
		JButton Fire_Button = new JButton("강퇴");
		Fire_Button.setSize(80,40);
		Fire_Button.setLocation(120,10);
		
		
		/*JButton*/ Delete_Button = new JButton("탈퇴");
		Delete_Button.setSize(80,40);
		Delete_Button.setLocation(220,10);
		
		Delete_Button.addActionListener(new DeleteEvent());
		
		Man_Div_panel.add(Add_Button);
		Man_Div_panel.add(Delete_Button);
		Man_Div_panel.add(Fire_Button);
		
		
		Add_panel.add(Add_label);
		Add_panel.add(M_Scroll);
		Add_panel.add(Man_Div_panel);
		
		P_BG.add(Add_panel);
		
		//초대 버튼
		/*JButton */ B_add = new JButton("초대");
		B_add.setBackground(Color.GRAY);
		B_add.setLocation(850, 0);
		B_add.setSize(80,40);
	
		B_add.addMouseListener(new PanelEvent());
		
	
		JLabel L_add = new JLabel("6명");
		L_add.setFont(new Font("Serif",Font.BOLD,18));
		L_add.setLocation(935,0);
		L_add.setSize(40,40);
		
		//사용자 Menu
		/*JPanel*/ P_User = new JPanel();
		P_User.setLayout(null);
		//P_User.setBackground(Color.red);
		P_User.setSize(335,335);
		P_User.setLocation(680,40);
		P_User.setBackground(Color.decode("#5A5959"));
		P_User.setVisible(false);
		
		JLabel U_label = new JLabel("개인정보");
		U_label.setFont(new Font("Serif",Font.BOLD,25));
		U_label.setForeground(Color.WHITE);
		U_label.setLocation(10,0);
		U_label.setSize(120, 40);
		
		//개인정보
		JTextArea T_Inf = new JTextArea("최인효 \n inhyo825@gmail.com \n 010-5154-0825");
		T_Inf.setLocation(20, 40);
		T_Inf.setSize(290,100);
		T_Inf.setEditable(false);
		
		
		JLabel Pro_label = new JLabel("진행중인 프로젝트");
		Pro_label.setFont(new Font("Serif",Font.BOLD,17));
		Pro_label.setForeground(Color.WHITE);
		Pro_label.setLocation(10,140);
		Pro_label.setSize(150, 40);

		//진행중인 프로젝트
		JTextArea T_Pro = new JTextArea("미니프로젝트");
		/*T_Pro.setLocation(20, 180);
		T_Pro.setSize(290,100);*/
		T_Pro.setEditable(false);
		
		//진행중인 프로젝트 스크롤
		JScrollPane Pro_Scroll = new JScrollPane(T_Pro); 
		Pro_Scroll.setLocation(20, 180);
		Pro_Scroll.setSize(290,100);
		
		P_User.add(U_label);
		P_User.add(T_Inf);
		P_User.add(Pro_label);
		P_User.add(Pro_Scroll);
		
		P_BG.add(P_User);
		
		//사용자 정보 
		/*JButton*/ B_user = new JButton(new ImageIcon("Image/user.PNG"));
		
		
		//버튼 뒤에 배경 지우는 함수
		B_user.setBorderPainted(false); B_user.setFocusPainted(false); B_user.setContentAreaFilled(false);

		B_user.setLocation(968,0);
		B_user.setSize(40, 40);
		

		//사용자 정보 띄우기
		B_user.addMouseListener(new PanelEvent());			
		
	
		///////
		M_panel.add(home);
		M_panel.add(B_add);
		M_panel.add(L_add);
		M_panel.add(B_user);
		
		
		
		JLabel name = new JLabel();
		name.setText("프로젝트 명 - 스프린트명 (yyyy/MM/dd ~ yyyy/MM/dd)");
		name.setFont(new Font("Serif",Font.BOLD,19));
		name.setLocation(250,0);
		name.setSize(490, 35);
		
		M_panel.add(name);
	
		/////////////////////////////////////////////
		//Open 창 : 해야할 일
		JPanel O_panel = new JPanel();
		//O_panel.setBackground(Color.green);
		O_panel.setLayout(null);
		O_panel.setLocation(0, 65);
		O_panel.setSize(340,700);
		
		//OPEN이라고 글자 나오는 거
		JPanel O_label_panel = new JPanel();
		O_label_panel.setLocation(0,0);
		O_label_panel.setSize(340,55);
		O_label_panel.setBackground(Color.decode("#2ecc71"));
		
		
		JLabel O_label = new JLabel("OPEN");
		O_label.setFont(new Font("Serif",Font.BOLD,25));
		O_label.setForeground(Color.white);
		//rgb(46, 204, 113)
		O_label.setLocation(0, 0);
		O_label.setSize(340,20);
		
		O_label_panel.add(O_label);
		
		//OPEN List
		JPanel O_List_panel = new JPanel();
		O_List_panel.setLayout(null);
		//O_List_panel.setBackground(Color.red);
		O_List_panel.setLocation(0, 55);
		O_List_panel.setSize(340,548);
		
		String[] W_name = {"할일 이름1 - 할당자 ","할일 이름2  - 할당자","할일 이름3  - 할당자","할일 이름4  - 할당자","할일 이름5  - 할당자","할일 이름6  - 할당자","할일 이름7  - 할당자"};
		
		/*JList*/ O_List = new JList(W_name);
		O_List.setBounds(0, 20, 20, 100);
		O_List.setFont(new Font("Serif",Font.BOLD,25));
		O_List.setBackground(Color.decode("#ECEAE4"));
		
		//경계선
		//O_List.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		//리스트에 스크롤바 추가
		JScrollPane O_List_Scroll =new JScrollPane(O_List);
		O_List_Scroll.setSize(340,548);
		O_List_Scroll.setLocation(0, 0);
		
		//Dimension 크기를 지정하기 위한 클래스이다.
		//스크롤패널의 사이즈를 지정하기 위해 Dimension타입의 객체를 인자로 넣어야한다.
		O_List_Scroll.setPreferredSize(new Dimension(200,100));

		//리스트의 선택 모드를 단일 선택모드로 변경
		O_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		O_List.addMouseListener(new ListEvent());
		
		O_List_panel.add(O_List_Scroll);


		O_panel.add(O_List_panel);

		
		//할일 추가 하는 버튼
		JButton O_add  =new JButton(new ImageIcon("image/add.PNG"));
		O_add.setLocation(280, 600);
		O_add.setSize(50,50);
		
		//버튼 뒤에 배경 지우는 함수
		O_add.setBorderPainted(false); O_add.setFocusPainted(false); O_add.setContentAreaFilled(false);
		
		//할일 이벤트
		O_add.addActionListener(new Add_Work());
		
		O_panel.add(O_label_panel);
		O_panel.add(O_add);
		
		//////////////////////////
		//Progress 창 : 실행창
		JPanel P_panel = new JPanel();
		P_panel.setLayout(null);
		//P_panel.setBackground(Color.yellow);
		P_panel.setLocation(340, 65);
		P_panel.setSize(340,700);
		
		//IM Progress 라고 글자 나오는 것
		JPanel P_label_panel = new JPanel();
		P_label_panel.setLocation(0,0);
		P_label_panel.setSize(340,55);
		P_label_panel.setBackground(Color.decode("#f1c40f"));
		
		
		JLabel P_label = new JLabel("In Progress");
		P_label.setFont(new Font("Serif",Font.BOLD,25));
		P_label.setForeground(Color.white);
		P_label.setLocation(0, 0);
		P_label.setSize(340,20);
		
		P_label_panel.add(P_label);
		
		//할일 추가 하는 버튼
		JButton P_add  =new JButton(new ImageIcon("image/add.PNG"));
		P_add.setLocation(280, 600);
		P_add.setSize(50,50);

		//버튼 뒤에 배경 지우는 함수
		P_add.setBorderPainted(false); P_add.setFocusPainted(false); P_add.setContentAreaFilled(false);
		
		//할일 이벤트
		P_add.addActionListener(new Add_Work());
		
		
		P_panel.add(P_label_panel);
		P_panel.add(P_add);
		
		///////////////////////////////////////////
		//Done 창 : 끝난창
		JPanel D_panel = new JPanel();
		//D_panel.setBackground(Color.red);
		D_panel.setLayout(null);
		D_panel.setLocation(680,65);
		D_panel.setSize(340, 700);
		
		//Done이라고 나오는 것
		JPanel D_label_panel = new JPanel();
		D_label_panel.setLocation(0,0);
		D_label_panel.setSize(340,55);
		D_label_panel.setBackground(Color.decode("#3498db"));
		
		
		JLabel D_label = new JLabel("In Progress");
		D_label.setFont(new Font("Serif",Font.BOLD,25));
		D_label.setForeground(Color.white);
		D_label.setLocation(0, 0);
		D_label.setSize(340,20);
		
		D_label_panel.add(D_label);
		
		//할일 추가 하는 버튼
		JButton D_add  =new JButton(new ImageIcon("image/add.PNG"));
		D_add.setLocation(270, 600);
		D_add.setSize(50,50);

		//버튼 뒤에 배경 지우는 함수
		D_add.setBorderPainted(false); D_add.setFocusPainted(false); D_add.setContentAreaFilled(false);
		
		//할일 이벤트
		D_add.addActionListener(new Add_Work());

		
		D_panel.add(D_label_panel);
		D_panel.add(D_add);
		
		P_BG.add(M_panel);
		P_BG.add(O_panel);
		P_BG.add(P_panel);
		P_BG.add(D_panel);

		this.add(P_BG);
		
		//mainFrame에 현재 panel을 올리는것
		mf.add(this);
	}

	//사용자 , 초대 창 나오기
	private class PanelEvent extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			if (count %2 ==0) {
				if (e.getSource() == B_user) {
				P_User.setVisible(true);

				System.out.println(count);
				count ++;
				}else if (e.getSource() == B_add){
					Add_panel.setVisible(true);
					
					System.out.println(count);
					count ++;
				}
			}else {
				if (e.getSource() == B_user) {
					P_User.setVisible(false);

					System.out.println(count);
					count ++;
					}else if (e.getSource() == B_add){
						Add_panel.setVisible(false);
						
						System.out.println(count);
						count ++;
					}
			}
			
		}
		
		
	}
	
	//초대
	private class Add_person implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame Add_Frame = new JFrame();
			new InvitePU(Add_Frame);
		}
		
	}
	
	//할일 생성
	private class Add_Work implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame Create = new JFrame();
			new CreatePU(Create);
		}
		
	}
	
	//리스트 이벤트
	private class ListEvent extends MouseAdapter{
		int cnt = 0 ;
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == O_List) {
				cnt++;
				
				if (cnt >= 2) {
					JFrame fm = new JFrame();
					new CheckPU(fm);
					
					cnt = 0;
				}
				
			}
			
		}
	}
	
	//멤버 탈퇴
	private class DeleteEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Delete_Button) {
				JFrame mf = new JFrame();
				new Sprint_CheckBox().delete_Member(mf);
			}
		}
		
	}
	
}
