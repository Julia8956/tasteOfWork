package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Join extends JPanel {
	
	
	public Join() {
		
		
		this.setSize(1024,768);
		
		this.setBackground(Color.GRAY);
		
		JLabel id = new JLabel("아이디");
		id.setLocation(360,100);
		id.setSize(150, 50);
		
		JLabel pwd = new JLabel("비밀번호");
		pwd.setLocation(360, 150);
		pwd.setSize(150, 50);
		
		JLabel pwd1 = new JLabel("비밀번호 확인");
		pwd1.setLocation(360, 200);
		pwd1.setSize(150, 50);
		
		JLabel name = new JLabel("이름");
		name.setLocation(360, 250);
		name.setSize(150, 50);
		
		JLabel gender = new JLabel("성별(남자/여자)");
		gender.setLocation(360, 300);
		gender.setSize(150, 50);
		
		JLabel phone = new JLabel("연락처");
		phone.setLocation(360, 350);
		phone.setSize(150, 50);
		
		JLabel email = new JLabel("이메일");
		email.setLocation(360, 400);
		email.setSize(150, 50);
		
		JButton join = new JButton("회원 가입");
		join.setLocation(550, 450);
		join.setSize(100, 45);
		
		JButton cancel = new JButton("취소");
		cancel.setLocation(360, 450);
		cancel.setSize(100, 45);
		
		JButton check = new JButton("아이디 중복확인");
		check.setLocation(660, 100);
		check.setSize(150, 40);
		
		
		Image icon = new ImageIcon("images/joinin.PNG")
				.getImage().getScaledInstance(208, 66, 0);

		JLabel ilogo = new JLabel(new ImageIcon(icon));
		ilogo.setLocation(412,10);
		ilogo.setSize(208,66);
		
		JTextField tf1 = new JTextField(20);
		tf1.setLocation(450, 100);
		tf1.setSize(200, 40);
		
		JTextField tf2 = new JTextField(20);
		tf2.setLocation(450, 150);
		tf2.setSize(200, 40);
		
		JTextField tf3 = new JTextField(20);
		tf3.setLocation(450, 200);
		tf3.setSize(200, 40);
		
		JTextField tf4 = new JTextField(20);
		tf4.setLocation(450, 250);
		tf4.setSize(200, 40);
		
		JTextField tf7 = new JTextField(20);
		tf7.setLocation(450, 300);
		tf7.setSize(200, 40);
		
		
		JTextField tf5 = new JTextField(20);
		tf5.setLocation(450, 350);
		tf5.setSize(200, 40);
		
		JTextField tf6 = new JTextField(20);
		tf6.setLocation(450, 400);
		tf6.setSize(200, 40);
		
		
		
		
		
		this.add(id);
		this.add(pwd);
		this.add(pwd1);
		this.add(gender);
		this.add(name);
		this.add(phone);
		this.add(email);
		this.add(ilogo);
		this.add(join);
		this.add(cancel);
		this.add(tf1);
		this.add(tf2);
		this.add(tf3);
		this.add(tf4);
		this.add(tf5);
		this.add(tf6);
		this.add(check);
		this.add(tf7);
		
	}

	
	
}
