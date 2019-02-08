package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CheckPU extends JPanel{
	private JFrame mf;
	private JPanel mp;
	
	private JButton iB;
	//CheckPopUp 할일을 누르면 세부사항이 보이는 창
	public CheckPU(JFrame mf) {
		this.mf = mf;
		this.mp = this;
		
		mf.setBounds(200, 100, 500, 800);
		this.setLayout(null);
		
	
		//할일 이름이뜨는 부분 
		//CreatePU 에서 JTextField wT에 입력한 값이 들어감
		JLabel wN = new JLabel("Test(할일 이름)");
		wN.setFont(new Font("Serif",Font.BOLD,20));
		wN.setSize(150, 70);
		wN.setLocation(170, 0);
		
		//생성창에서 TextField로 입력을하면  여기에 Label에 들어감
		JLabel term1 = new JLabel("할일 시작");	
		term1.setSize(100, 70);					
		term1.setLocation(120, 50);
		term1.setFont(new Font("Serif",Font.BOLD,15));
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(100, 70);
		wave.setLocation(240, 50);
		wave.setFont(new Font("Serif",Font.BOLD,15));
		JLabel term2 = new JLabel("할일 종료");
		term2.setSize(100, 70);
		term2.setLocation(300, 50);
		term2.setFont(new Font("Serif",Font.BOLD,15));
		
		//세부사항이 보여 지는 곳
		//CreatePU 에서 JTextField wT에 입력한 값이 전달 된다
		JTextArea dT = new JTextArea("세부내용");	
		dT.setSize(400, 40);
		dT.setLocation(50, 115);
		dT.setEditable(false);
		
		
		JLabel addMember = new JLabel("할당자");
		addMember.setSize(100, 70);
		addMember.setLocation(50, 140);
		addMember.setFont(new Font("Serif",Font.BOLD,15));
		
		//InvitePU로 이동한다 초대버튼을 누르면 할당자가 초대 된다
		/*JButton*/ iB = new JButton("+");	
		iB.setFont(new Font("Serif",Font.BOLD,15));
		iB.setSize(60, 30);
		iB.setLocation(80, 160);
		
		
		
		//버튼 뒤에 배경 지우는 함수
		iB.setBorderPainted(false); iB.setFocusPainted(false); iB.setContentAreaFilled(false);
		
		//iB.addActionListener(new AsoEvent());
		
		
		//InvitePU에서 초대를 함면 member 배열에 들어간다 
		String[] member = {"민지","규형","인효","리나","지원","낙규"};	//test용 
		JList memberList = new JList(member);				
		memberList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		/*memberList.setLocation(60, 200);
		memberList.setSize(300, 120);*/
		JScrollPane scroller = new JScrollPane(memberList);
		scroller.setPreferredSize(new Dimension(200, 100));
		scroller.setLocation(50, 190);
		scroller.setSize(350, 80);
		
		
		JLabel feedback = new JLabel("피드백");	
		feedback.setSize(100, 70);
		feedback.setLocation(50, 260);
		iB.setFont(new Font("Serif",Font.BOLD,18));
		
		
		//피드백을 입력 한다
		JTextField fT = new JTextField(100);	
		fT.setSize(300, 65);
		fT.setLocation(50, 310);
		
		
		
		//입력버튼을 누르면 이제 피드백 내용으로 입력값이 전달된다
		JButton insertB = new JButton("입력");
		insertB.setSize(65, 65);
		insertB.setLocation(360, 310);
		
		JLabel fDL = new JLabel("피드백내용");	
		fDL.setSize(100, 70);
		fDL.setLocation(50, 360);
		
		//피드백을 을 입력하면, 이곳에 저장 된다
		JTextArea fa = new JTextArea();
		fa.setEditable(false);
		/*fa.setSize(365, 270);
		fa.setLocation(50, 410);*/
		
		JScrollPane faScroller = new JScrollPane(fa);
		faScroller.setSize(365, 270);
		faScroller.setLocation(50, 410);
		
		fT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = fT.getText();
				fa.append(text + "\n");
				
				fT.setText("");
				fT.requestFocus();
				
			}
		});
		
		JButton deleteB = new JButton("삭제"); //삭제할 내용을 삭제 한다
		deleteB.setSize(60, 30);
		deleteB.setLocation(50, 700);

		
		JButton saveB = new JButton("수정");	//모든 내욜을 저장한다
		saveB.setSize(60, 30);
		saveB.setLocation(280, 700);
		
		JButton reviseB = new JButton("닫기");
		reviseB.setSize(60, 30);
		reviseB.setLocation(350, 700);
		
		reviseB.addActionListener(new CloseEvent());
		
		this.add(wN);
		this.add(dT);
		this.add(term1);
		this.add(wave);
		this.add(term2);
		this.add(addMember);
		this.add(iB);
		//this.add(memberList);
		//this.add(scroller);
		//this.add(T_Member);
		this.add(scroller);
		this.add(feedback);
		this.add(fT);
		this.add(insertB);
		this.add(fDL);
		//this.add(fa);
		this.add(faScroller);
		this.add(deleteB);
		this.add(saveB);
		this.add(reviseB);
		
		mf.add(this);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	//닫기
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mf.dispose();
		}

	}
	
	/*//할당자 이벤트
	private class AsoEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame mf = new JFrame();
			Object[] ob= new Sprint_CheckBox().Assignor(mf);
		//	member = new String[ob.length];
			
			int ctn = 0;
			for (int i = 0 ; i < ob.length ; i++) {
				member[ctn] = (String)ob[i]; 
				
				ctn++;
			}
		}
		
	}*/
}
