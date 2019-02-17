package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class A_UserEdit extends JPanel {
	//이베일 비번 연락처 수정
	private A_AddUserPU adduserPU;
	private Dialog userEdit;
	private MainFrame mf;
	private String EditEmail;
	private String userPwd;
	private String userPhoneNum;
	private JButton savebtn;
	 
	public A_UserEdit() {}
	
	//public A_UserEdit(MainFrame mf, Dialog userEdit) {}

	public A_UserEdit(MainFrame mf) {
		this.mf = mf;
		this.adduserPU = adduserPU;
		
		userEdit = new Dialog(mf,"사용자 정보 수정");
		userEdit.setLayout(null);
		userEdit.setResizable(false);
		userEdit.setUndecorated(true);  //테두리 없에는것
		userEdit.setBackground(Color.decode("#5A5959"));
		userEdit.setSize(335, 335);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width - 120)  - (userEdit.getWidth() * 2);
		int yPos = (dim.height / 3 + 45) - (userEdit.getHeight() / 2);
		
		userEdit.setLocation(xPos,yPos);
		userEdit.setVisible(true);
		
		// 이메일 수정
		JLabel userEmailLB = new JLabel("이메일");
		userEmailLB.setFont(new Font("맑은 고딕",Font.BOLD,15));
		userEmailLB.setForeground(Color.white);
		userEmailLB.setLocation(10, 0);
		userEmailLB.setSize(120,40);
		userEdit.add(userEmailLB);
		
		JTextField userEmailTF = new JTextField("변경할 이메일을 입력 하시오");
		userEmailTF.setSize(260,30);
		userEmailTF.setLocation(10, 40);
		userEdit.add(userEmailTF);
		
		//비밀번호 수정
		JLabel userPwdLB = new JLabel("비밀번호");
		userPwdLB.setFont(new Font("맑은 고딕",Font.BOLD,15));
		userPwdLB.setForeground(Color.white);
		userPwdLB.setLocation(10, 80);
		userPwdLB.setSize(120,40);
		userEdit.add(userPwdLB);
		
		JTextField userPwdTF = new JTextField("변경할 비밀번호를 입력하시오");
		userPwdTF.setSize(260,30);
		userPwdTF.setLocation(10,120);
		userEdit.add(userPwdTF);
		
		//휴대폰 번호 변경
		JLabel userPhoneNumLB = new JLabel("번호");
		userPhoneNumLB.setFont(new Font("맑은 고딕",Font.BOLD,15));
		userPhoneNumLB.setForeground(Color.white);
		userPhoneNumLB.setLocation(10, 160);
		userPhoneNumLB.setSize(120,40);
		userEdit.add(userPhoneNumLB);
		
		JTextField userPhoneNumTF = new JTextField("변경할 휴대폰번호를 입력하시오");
		userPhoneNumTF.setSize(260,30);
		userPhoneNumTF.setLocation(10,200);
		userEdit.add(userPhoneNumTF);
		
		//저장버튼
		savebtn = new JButton("저장");
		savebtn.setSize(60, 30);
		savebtn.setLocation(20, 280);
		userEdit.add(savebtn);
		//변경 사항 저장 이벤트
		savebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton closebtn = new JButton("닫기");
		closebtn.setSize(60, 30);
		closebtn.setLocation(250, 280);
		userEdit.add(closebtn);
		
		//닫기 이벤트
		closebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userEdit.dispose();
				
			}
		});
		
		
		
		
		
		
		
		
		
		
	}
	
	
		
}

