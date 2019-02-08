package view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindIdPwd extends JPanel {
	public FindIdPwd() {
		
		
		this.setSize(1024,768);
		this.setBackground(Color.gray);
		
		JLabel name = new JLabel("이름");
		name.setLocation(10, 100);
		name.setSize(150,50);
		
		JLabel phone1 = new JLabel("연락처");
		phone1.setLocation(10, 150);
		phone1.setSize(150,50);
		
		JLabel email1 = new JLabel("이메일");
		email1.setLocation(10, 200);
		email1.setSize(150,50);
		
		JLabel id = new JLabel("이름");
		id.setLocation(450, 100);
		id.setSize(150,50);
		
		JLabel phone2 = new JLabel("연락처");
		phone2.setLocation(450, 150);
		phone2.setSize(150,50);
		
		JLabel email2 = new JLabel("이메일");
		email2.setLocation(450, 200);
		email2.setSize(150,50);
		
		
		JButton find1 = new JButton("찾기");
		find1.setLocation(195, 250);
		find1.setSize(70,50);
		
		JButton find2 = new JButton("찾기");
		find2.setLocation(635, 250);
		find2.setSize(70,50);
		
		JButton cancel = new JButton("취소");
		cancel.setLocation(635, 350);
		cancel.setSize(70,50);
		
		
		JTextField tf1 = new JTextField(20);
		tf1.setLocation(60, 100);
		tf1.setSize(200, 40);
		
		JTextField tf2 = new JTextField(20);
		tf2.setLocation(60, 150);
		tf2.setSize(200, 40);
		
		JTextField tf3 = new JTextField(20);
		tf3.setLocation(60, 200);
		tf3.setSize(200, 40);
		
		JTextField tf4 = new JTextField(20);
		tf4.setLocation(500, 100);
		tf4.setSize(200, 40);
		
		JTextField tf5 = new JTextField(20);
		tf5.setLocation(500, 150);
		tf5.setSize(200, 40);
		
		JTextField tf6 = new JTextField(20);
		tf6.setLocation(500, 200);
		tf6.setSize(200, 40);
		
		
		Image idicon = new ImageIcon("images/findId.PNG")
				.getImage().getScaledInstance(163, 37, 0);

		JLabel idcon = new JLabel(new ImageIcon(idicon));
		idcon.setLocation(10,10);
		idcon.setSize(163,37);
		
		Image pwdicon = new ImageIcon("images/findPwd.PNG")
				.getImage().getScaledInstance(193, 37, 0);

		JLabel pwdcon = new JLabel(new ImageIcon(pwdicon));
		pwdcon.setLocation(450,10);
		pwdcon.setSize(193,37);
		
		
		this.add(idcon);
		this.add(pwdcon);
		this.add(name);
		this.add(phone1);
		this.add(phone2);
		this.add(email1);
		this.add(email2);
		this.add(id);
		this.add(find1);
		this.add(find2);
		this.add(cancel);
		this.add(tf1);
		this.add(tf2);
		this.add(tf3);
		this.add(tf4);
		this.add(tf5);
		this.add(tf6);
	
		
		
	}
	
	
}
