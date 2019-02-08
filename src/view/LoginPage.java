package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class LoginPage extends JPanel{
	private MainFrame mf;
	private JPanel loginPage;
	
	
	public LoginPage(MainFrame mf) {
		
		
		this.mf=mf;
		this.loginPage=this;
		
		this.setSize(1024,768);
		this.setBackground(Color.gray);
		
		JLabel name = new JLabel("아이디");
		name.setLocation(360,350);
		name.setSize(150, 50);
		
		JLabel password = new JLabel("비밀번호");
		password.setLocation(360, 400);
		password.setSize(150, 50);
		
		
		JTextField tf1 = new JTextField(20);
		tf1.setLocation(410, 350);
		tf1.setSize(200, 40);
		
		JTextField tf2 = new JTextField(20);
		tf2.setLocation(410, 400);
		tf2.setSize(200, 40);
		
		JButton btn = new JButton("로그인");
		btn.setLocation(620, 350);
		btn.setSize(100, 90);
		btn.addMouseListener(new MyMouseAdapter3());
		
		Image icon = new ImageIcon("images/logo.PNG")
				.getImage().getScaledInstance(225, 250, 0);

		JLabel ilogo = new JLabel(new ImageIcon(icon));
		ilogo.setLocation(410,100);
		ilogo.setSize(225,250);
		
		JButton joinus = new JButton("아직 회원이 아니신가요?");
		joinus.setLocation(350, 440);
		joinus.setSize(180,30);
		joinus.addMouseListener(new MyMouseAdapter1());
		
		JButton find = new JButton("아이디/비밀번호 찾기");
		find.setLocation(620, 440);
		find.setSize(180,30);
		find.addMouseListener(new MyMouseAdapter2());
		
		
		
		
		
		this.setLayout(null);
		this.add(name);
		this.add(password);
		this.add(tf2);
		this.add(tf1);
		this.add(btn);
		this.add(ilogo);
		this.add(joinus);
		this.add(find);
		
		
		
		mf.add(this);
		
	}
class MyMouseAdapter1 extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, loginPage, new Join());
		}
	}
class MyMouseAdapter2 extends MouseAdapter{
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ChangePanel.changePanel(mf, loginPage, new FindIdPwd());
	}
}
class MyMouseAdapter3 extends MouseAdapter{
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ChangePanel.changePanel(mf, loginPage, new MainPage());
	}
}
}
