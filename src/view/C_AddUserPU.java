package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class C_AddUserPU extends JPanel{
	private MainFrame mf; 
	private Dialog userPU;
	
	public C_AddUserPU() {}
	
	public C_AddUserPU(MainFrame mf) {
		
		//사용자 @@@@@@@@@@@@@@@@@@@@@@@@@@@
		//사용자 Menu
		userPU = new Dialog(mf,"사용자 정보"); 
		userPU.setLayout(null);
		userPU.setUndecorated(true);	//태두리 없에는거
		//P_User.setBackground(Color.red);
		userPU.setSize(335,335);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width - 120)  - (userPU.getWidth() * 2);
		int yPos = (dim.height / 3 + 45) - (userPU.getHeight() / 2);
		
		userPU.setLocation(xPos,yPos);
		userPU.setBackground(Color.decode("#5A5959"));
		userPU.setVisible(false);
		
				
		JLabel U_label = new JLabel("개인정보");
		U_label.setFont(new Font("맑은 고딕",Font.BOLD,25));
		U_label.setForeground(Color.WHITE);
		U_label.setLocation(10,0);
		U_label.setSize(120, 40);
		userPU.add(U_label);
				
		//개인정보
		JTextArea T_Inf = new JTextArea("최인효 \n inhyo825@gmail.com \n 010-5154-0825");
		T_Inf.setLocation(20, 40);
		T_Inf.setSize(290,100);
		T_Inf.setEditable(false);
		userPU.add(T_Inf);
				
		JLabel Pro_label = new JLabel("진행중인 프로젝트");
		Pro_label.setFont(new Font("맑은 고딕",Font.BOLD,17));
		Pro_label.setForeground(Color.WHITE);
		Pro_label.setLocation(10,140);
		Pro_label.setSize(150, 40);
		userPU.add(Pro_label);

		//진행중인 프로젝트
		JTextArea T_Pro = new JTextArea("미니프로젝트");
		T_Pro.setLocation(20, 180);
		T_Pro.setSize(290,100);
		T_Pro.setEditable(false);
		userPU.add(T_Pro);
				
		//진행중인 프로젝트 스크롤
		JScrollPane Pro_Scroll = new JScrollPane(T_Pro); 
		Pro_Scroll.setLocation(20, 180);
		Pro_Scroll.setSize(290,100);
		userPU.add(Pro_Scroll);
		
		
		JButton closebtn = new JButton("닫기");
		closebtn.setSize(60, 30);
		closebtn.setLocation(250,285);
		closebtn.addActionListener(new CloseEvent());
		
		
		userPU.add(closebtn);
	}
	
	public Dialog getUserPU() {
		return userPU;
	}
	
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			userPU.dispose();
		}

	}
}
