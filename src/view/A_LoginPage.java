package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



	public class A_LoginPage extends JPanel{
		private MainFrame mf;
		private A_LoginPage lp;
		
		public A_LoginPage(MainFrame mf) {
			this.mf= mf;
			this.lp = this;
			
			this.setSize(1024, 768);
			this.setLayout(new BorderLayout());

			/*JPanel mainPanel = new JPanel();
			//mainPanel.setLayout(new BorderLayout());
			mainPanel.setSize(new Dimension(200,500));
			mainPanel.setBackground(Color.cyan);
			
			JPanel SubPanel = new JPanel();
			SubPanel.setBackground(Color.yellow);
			SubPanel.setSize(new Dimension(400,200));
			
			this.add(mainPanel,"West");
			this.add(SubPanel, "Center");*/
			
			this.setLayout(new BorderLayout());
	        
	        //여기서부터
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.GRAY);
	        panel.setPreferredSize(new Dimension(1024,120));
	        this.add(panel, BorderLayout.NORTH);
	        
	        JPanel panel2 = new JPanel();
	        panel2.setBackground(Color.GRAY);
	        panel2.setPreferredSize(new Dimension(50,768));
	        this.add(panel2, BorderLayout.WEST);
	        
	        JPanel panel3 = new JPanel();
	        panel3.setBackground(Color.GRAY);
	        panel3.setPreferredSize(new Dimension(50,768));
	        this.add(panel3, BorderLayout.EAST);
	        
	        
	        JPanel panel4 = new JPanel();
	        panel4.setBackground(Color.GRAY);
	        panel4.setPreferredSize(new Dimension(1024,80));
	        this.add(panel4, BorderLayout.SOUTH);
	        //여기까지는 쓸모없는 패널로 그냥 mainPanel 위치 찹아주는 거입니다.
	        
	        JPanel mainPanel = new JPanel();
	        mainPanel.setPreferredSize(new Dimension(500,500));
	       // mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
	        mainPanel.setLayout(new BorderLayout());
	       mainPanel.setBackground(Color.GRAY);
	        
	        JLabel logoimage = new JLabel(new ImageIcon("images/logo.PNG"));
	        logoimage.setPreferredSize(new Dimension(100,300));

	        mainPanel.add(logoimage,BorderLayout.NORTH);

	        JPanel SubPanel = new JPanel();
	        //SubPanel.setLayout(null);
	        SubPanel.setPreferredSize(new Dimension(100,300));
	        SubPanel.setLayout(new BorderLayout());
	        SubPanel.setBackground(Color.GRAY);
	        
	        JPanel LoginPanel =new JPanel();
	        LoginPanel.setPreferredSize(new Dimension(300,100));
	        LoginPanel.setLayout(new FlowLayout());
	        LoginPanel.setBackground(Color.GRAY);
	        
	        
	        JPanel TextFieldPanel =new JPanel();
	        TextFieldPanel.setLayout(new BoxLayout(TextFieldPanel,BoxLayout.Y_AXIS));
	        TextFieldPanel.setPreferredSize(new Dimension(300,60));
	        
	        JPanel idPanel = new JPanel();
	        idPanel.setLayout(new FlowLayout());
	        idPanel.setBackground(Color.GRAY);
	        idPanel.setPreferredSize(new Dimension(50,80));
	       
	        
	        JLabel id = new JLabel("ID     ");
			//id.setLocation(360,350);
			id.setSize(50, 50);


			JTextField idt = new JTextField(20);
			//idt.setLocation(410, 350);
			//idt.setSize(200, 40);

			idPanel.add(id);
			idPanel.add(idt);
			
			
			JPanel PwdPanel = new JPanel();
			PwdPanel.setLayout(new FlowLayout());
			PwdPanel.setBackground(Color.GRAY);
			PwdPanel.setPreferredSize(new Dimension(50,80));

			JLabel password = new JLabel("PWD");
			//password.setLocation(360, 400);
			//password.setSize(150, 50);

			
			JTextField pwdt = new JTextField(20);
			//pwdt.setLocation(410, 400);
			//pwdt.setSize(20, 40);

			PwdPanel.add(password);
			PwdPanel.add(pwdt);
			
			TextFieldPanel.add(idPanel);
			TextFieldPanel.add(PwdPanel);
			
			LoginPanel.add(TextFieldPanel);
			
			JButton login_btn = new JButton("로그인");
			//login_btn.setLocation(620, 350);
			login_btn.setPreferredSize(new Dimension(80,60));
			
			login_btn.addMouseListener(new MyMouseAdapter1());
			//login_btn.addActionListener(this)
			
			LoginPanel.add(login_btn);
			
			JPanel Buttons_panel = new JPanel();
			Buttons_panel.setLayout(new BoxLayout(Buttons_panel,BoxLayout.Y_AXIS));
			Buttons_panel.setBackground(Color.GREEN);
			Buttons_panel.setPreferredSize(new Dimension(50,5));

			JPanel buttonpanel = new JPanel();
			buttonpanel.setLayout(new FlowLayout());
			buttonpanel.setBackground(Color.GRAY);
			buttonpanel.setPreferredSize(new Dimension(50,80));
			

			JButton joinus = new JButton("아직 회원이 아니신가요?");
			joinus.setLocation(350, 440);
			joinus.setSize(180,30);
			joinus.addActionListener(new Joinevent());
			//joinus.addMouseListener(new MyMouseAdapter1());


			JButton find = new JButton("아이디/비밀번호 찾기");
			find.setLocation(620, 440);
			find.setSize(180,30);
			//find.addMouseListener(new MyMouseAdapter2());
			find.addActionListener(new Findevent());
			buttonpanel.add(joinus);
			buttonpanel.add(find);
			
			
			/*JButton login_btn = new JButton("로그인");
			//login_btn.setLocation(620, 350);
			login_btn.setPreferredSize(new Dimension(50,80));
			//login_btn.addMouseListener(new MyMouseAdapter3());
			//login_btn.addActionListener(this);

			Buttons_panel.add(buttonpanel); 
			Buttons_panel.add(login_btn); */
			Buttons_panel.add(buttonpanel); 
			
			//SubPanel.add(id);
			//SubPanel.add(idt);
			SubPanel.add(LoginPanel,BorderLayout.NORTH);
			//SubPanel.add(password);
			//SubPanel.add(pwdt);
			SubPanel.add(Buttons_panel,BorderLayout.CENTER);
			//SubPanel.add(login_btn);
			//SubPanel.add(joinus);
			//SubPanel.add(find);
			//SubPanel.add(Buttons_panel,BorderLayout.SOUTH);
	        
	        mainPanel.add(SubPanel,BorderLayout.CENTER);
	        
	        this.add(mainPanel, BorderLayout.CENTER);
			
			mf.add(this);
			
		
		}
		class Findevent implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//JFrame mf = new JFrame();
				//new FindIdPwd(mf).getFindIdPwd().setVisible(true);
			}
		}
		class Joinevent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//JFrame mf = new JFrame();
			//new JoinPage(mf).getJoinPage().setVisible(true);
		}
		
		
	}
	  class MyMouseAdapter1 extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, lp, new A_MainPage(mf));
			}
		}
	

}
