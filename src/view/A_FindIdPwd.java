package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.A_MemberManager;
import model.dao.A_MemberDao;

public class A_FindIdPwd extends JPanel {
	
	private MainFrame mf;
	private Dialog a_findIdPwd;
	private A_MemberDao memberDao = new A_MemberDao();
	private A_MemberManager a_mm = new A_MemberManager();
	
	
	public A_FindIdPwd(MainFrame mf) {
		
		a_findIdPwd = new Dialog(mf,"아이디/비밀번호 찾기");
		a_findIdPwd.setSize(700,700);
		a_findIdPwd.setLayout(null);
		a_findIdPwd.setBackground(Color.gray);
		
		JLabel name = new JLabel("이름");
		name.setLocation(10, 100);
		name.setSize(150,50);
		
		JLabel phone1 = new JLabel("연락처");
		phone1.setLocation(10, 150);
		phone1.setSize(150,50);
		
		JLabel email1 = new JLabel("이메일");
		email1.setLocation(10, 200);
		email1.setSize(150,50);
		
		JLabel id = new JLabel("아이디");
		id.setLocation(430, 100);
		id.setSize(150,50);
		
		JLabel phone2 = new JLabel("연락처");
		phone2.setLocation(430, 150);
		phone2.setSize(150,50);
		
		JLabel email2 = new JLabel("이메일");
		email2.setLocation(430, 200);
		email2.setSize(150,50);
		
		
		
		JTextField namet1 = new JTextField(20);
		namet1.setLocation(60, 100);
		namet1.setSize(200, 40);
		
		JTextField phonet1 = new JTextField(20);
		phonet1.setLocation(60, 150);
		phonet1.setSize(200, 40);
		
		JTextField emailt1 = new JTextField(20);
		emailt1.setLocation(60, 200);
		emailt1.setSize(200, 40);
		
		JTextField idt = new JTextField(20);
		idt.setLocation(480, 100);
		idt.setSize(200, 40);
		
		JTextField phonet2 = new JTextField(20);
		phonet2.setLocation(480, 150);
		phonet2.setSize(200, 40);
		
		JTextField emailt2 = new JTextField(20);
		emailt2.setLocation(480, 200);
		emailt2.setSize(200, 40);
		
		
		Image idicon = new ImageIcon("images/findId.PNG")
				.getImage().getScaledInstance(163, 37, 0);

		JLabel idcon = new JLabel(new ImageIcon(idicon));
		idcon.setLocation(10,50);
		idcon.setSize(163,37);
		
		Image pwdicon = new ImageIcon("images/findPwd.PNG")
				.getImage().getScaledInstance(193, 37, 0);

		JLabel pwdcon = new JLabel(new ImageIcon(pwdicon));
		pwdcon.setLocation(450,50);
		pwdcon.setSize(193,37);
		
		
		JButton find1 = new JButton("찾기");
		find1.setLocation(195, 250);
		find1.setSize(70,50);
		find1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				a_mm.findId(namet1.getText(), phonet1.getText(), emailt1.getText());
			}
		});
		
		
		JButton find2 = new JButton("찾기");
		find2.setLocation(615, 250);
		find2.setSize(70,50);
		find2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				a_mm.findId(idt.getText(), phonet1.getText(), emailt1.getText());				
			}
		});
		
		JButton cancel = new JButton("취소");
		cancel.setLocation(615, 350);
		cancel.setSize(70,50);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				a_findIdPwd.dispose();
				
			}
		});
		
		
		a_findIdPwd.add(idcon);
		a_findIdPwd.add(pwdcon);
		a_findIdPwd.add(name);
		a_findIdPwd.add(phone1);
		a_findIdPwd.add(phone2);
		a_findIdPwd.add(email1);
		a_findIdPwd.add(email2);
		a_findIdPwd.add(id);
		a_findIdPwd.add(find1);
		a_findIdPwd.add(find2);
		a_findIdPwd.add(cancel);
		a_findIdPwd.add(namet1);
		a_findIdPwd.add(phonet1);
		a_findIdPwd.add(emailt1);
		a_findIdPwd.add(idt);
		a_findIdPwd.add(phonet2);
		a_findIdPwd.add(emailt2);
	
		a_findIdPwd.setResizable(false); 
		a_findIdPwd.setVisible(true);
		
	}
	 public Dialog getA_FindIdPwd() {
	      return a_findIdPwd;
	   }
	
	
}
