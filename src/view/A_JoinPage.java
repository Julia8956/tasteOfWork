package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class A_JoinPage extends JPanel {
	
	private MainFrame mf;
	private Dialog a_joinPage;
	
	public A_JoinPage(MainFrame mf) {
		
		
		Image icon = new ImageIcon("images/joinin.PNG")
				.getImage().getScaledInstance(208, 66, 0);
		
		
		
		a_joinPage = new Dialog(mf, "회원가입");
		a_joinPage.setBackground(Color.GRAY);
		a_joinPage.setSize(700, 700);
		a_joinPage.setLayout(null);
		
		JLabel ilogo = new JLabel(new ImageIcon(icon));
		ilogo.setLocation(270,100);
		ilogo.setSize(208,66);
		a_joinPage.add(ilogo);
		
		
		JLabel id = new JLabel("아이디");
		id.setLocation(180, 180);
		id.setSize(150, 50);
		a_joinPage.add(id);
		
		JButton check = new JButton("아이디 중복확인");
		check.setLocation(480, 180);
		check.setSize(150, 40);
		a_joinPage.add(check);
		
		JTextField idt = new JTextField(20);
		idt.setLocation(270, 180);
		idt.setSize(200, 40);
		a_joinPage.add(idt);
		
		JLabel pwd = new JLabel("비밀번호");
		pwd.setLocation(180, 230);
		pwd.setSize(150, 50);
		a_joinPage.add(pwd);
		
		JTextField pwdt = new JTextField(20);
		pwdt.setLocation(270, 230);
		pwdt.setSize(200, 40);
		a_joinPage.add(pwdt);
		
		JLabel pwd1 = new JLabel("비밀번호 확인");
		pwd1.setLocation(180, 280);
		pwd1.setSize(150, 50);
		a_joinPage.add(pwd1);
		
		JTextField pwdt1 = new JTextField(20);
		pwdt1.setLocation(270, 280);
		pwdt1.setSize(200, 40);
		a_joinPage.add(pwdt1);
		
		JLabel name = new JLabel("이름");
		name.setLocation(180, 330);
		name.setSize(150, 50);
		a_joinPage.add(name);
		
		JTextField namet = new JTextField(20);
		namet.setLocation(270, 330);
		namet.setSize(200, 40);
		a_joinPage.add(namet);
		
		JLabel gender = new JLabel("성별(남자/여자)");
		gender.setLocation(180, 380);
		gender.setSize(150, 50);
		a_joinPage.add(gender);
		
		JTextField gendert = new JTextField(20);
		gendert.setLocation(270, 380);
		gendert.setSize(200, 40);
		a_joinPage.add(gendert);
		
		JLabel phone = new JLabel("연락처");
		phone.setLocation(180, 430);
		phone.setSize(150, 50);
		a_joinPage.add(phone);
		
		JTextField phonet = new JTextField(20);
		phonet.setLocation(270, 430);
		phonet.setSize(200, 40);
		a_joinPage.add(phonet);
		
		JLabel email = new JLabel("이메일");
		email.setLocation(180, 480);
		email.setSize(150, 50);
		a_joinPage.add(email);
		
		JTextField emailt = new JTextField(20);
		emailt.setLocation(270, 480);
		emailt.setSize(200, 40);
		a_joinPage.add(emailt);
		
		JButton join = new JButton("회원 가입");
		join.setLocation(350, 550);
		join.setSize(100, 45);
		join.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	a_joinPage.dispose();
         	     
            }
         });
		a_joinPage.add(join);
		
		JButton cancel = new JButton("취소");
		cancel.setLocation(250, 550);
		cancel.setSize(100, 45);
		cancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	a_joinPage.dispose();
               
            }
         });
		
		a_joinPage.add(cancel);
		

		a_joinPage.setResizable(false); 
		a_joinPage.setVisible(true);
		
		
		
		
	}
	 public Dialog getA_JoinPage() {
	      return a_joinPage;
	   }

	
	
}
