package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import model.Work;

//import org.jdesktop.swingx.JXDatePicker;

public class C_CheckPU extends JPanel implements ActionListener{
	private MainFrame mf;
	private Dialog checkpu;
	
	private String work_title;
	private JButton iB;
	
	
	//CheckPopUp 할일을 누르면 세부사항이 보이는 창
	public C_CheckPU(MainFrame mf,Work work) {
		checkpu= new Dialog(mf, "할일 생성");
		
		checkpu.setBounds(200, 100, 500, 680);
		checkpu.setResizable(false);     	//프레임 고정
		checkpu.setUndecorated(true);		//상태바 없애기
		checkpu.setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width /2 )  - (checkpu.getWidth() / 2);
		int yPos = (dim.height / 2) - (checkpu.getHeight() / 2);
		
		checkpu.setLocation(xPos, yPos);
		
		//할일 이름이뜨는 부분 
		//CreatePU 에서 JTextField wT에 입력한 값이 들어감
		JTextField wN = new JTextField(15);
		//wN.setFont(new Font("Serif",Font.BOLD,20));
		wN.setSize(200, 40);
		wN.setLocation(150, 10);
		wN.setText(work.getWork_name());
		//System.out.println(this.getWork_title());
		
		JXDatePicker term1DayPicker = new DatePicker().getDatePicker();
		term1DayPicker.setSize(100, 40);
		term1DayPicker.setLocation(80, 70);
		checkpu.add(term1DayPicker);
		
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(100, 25);
		wave.setLocation(230, 85);
		wave.setFont(new Font("Serif",Font.BOLD,15));
		
		
		JXDatePicker term2DayPicker = new DatePicker().getDatePicker();
		term2DayPicker.setSize(100, 40);
		term2DayPicker.setLocation(300, 70);
		checkpu.add(term2DayPicker);
		
		
		//세부사항이 보여 지는 곳
		//CreatePU 에서 JTextField wT에 입력한 값이 전달 된다
		JTextArea dT = new JTextArea(work.getWork_content());	
		dT.setSize(400, 40);
		dT.setLocation(50, 125);
		//dT.setEditable(false);
		
		
		JLabel addMember = new JLabel("할당자");
		addMember.setSize(100, 70);
		addMember.setLocation(50, 150);
		addMember.setFont(new Font("Serif",Font.BOLD,15));
		
		//InvitePU로 이동한다 초대버튼을 누르면 할당자가 초대 된다
		/*JButton*/ iB = new JButton("+");	
		iB.setFont(new Font("Serif",Font.BOLD,15));
		iB.setSize(60, 30);
		iB.setLocation(80, 170);
		
		
		
		//버튼 뒤에 배경 지우는 함수
		iB.setBorderPainted(false); iB.setFocusPainted(false); iB.setContentAreaFilled(false);
		
		//iB.addActionListener(new AsoEvent());
		
		
		//InvitePU에서 초대를 함면 member 배열에 들어간다 
		//String[] member = {"민지","규형","인효","리나","지원","낙규"};	//test용 
		JList memberList = new JList(work.getAllocator());				
		memberList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		JScrollPane scroller = new JScrollPane(memberList);
		scroller.setPreferredSize(new Dimension(200, 100));
		scroller.setLocation(50, 200);
		scroller.setSize(350, 80);
		
		
		JLabel feedback = new JLabel("피드백");	
		feedback.setSize(100, 70);
		feedback.setLocation(50, 270);
		iB.setFont(new Font("Serif",Font.BOLD,18));
		
		iB.addActionListener(this);
		
		
		//피드백을 입력 한다
		JTextField fT = new JTextField(100);	
		fT.setSize(300, 65);
		fT.setLocation(50, 320);
		
		
		
		//입력버튼을 누르면 이제 피드백 내용으로 입력값이 전달된다
		JButton insertB = new JButton("입력");
		insertB.setSize(65, 65);
		insertB.setLocation(360, 320);
		
		JLabel fDL = new JLabel("피드백내용");	
		fDL.setSize(100, 70);
		fDL.setLocation(50, 365);
		
		//피드백을 을 입력하면, 이곳에 저장 된다
		JTextArea fa = new JTextArea();
		fa.setEditable(false);
		/*fa.setSize(365, 270);
		fa.setLocation(50, 410);*/
		
		JScrollPane faScroller = new JScrollPane(fa);
		faScroller.setSize(365, 160);
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
		deleteB.setLocation(50, 600);

		
		JButton reviseB = new JButton("닫기");
		reviseB.setSize(60, 30);
		reviseB.setLocation(350, 600);
		
		reviseB.addActionListener(new CloseEvent());
		
		checkpu.add(wN);
		checkpu.add(dT);
		checkpu.add(wave);
		checkpu.add(addMember);
		checkpu.add(iB);
		//this.add(memberList);
		//this.add(scroller);
		//this.add(T_Member);
		checkpu.add(scroller);
		checkpu.add(feedback);
		checkpu.add(fT);
		checkpu.add(insertB);
		checkpu.add(fDL);
		//this.add(fa);
		checkpu.add(faScroller);
		checkpu.add(deleteB);
		checkpu.add(reviseB);
		
	
	}


	public String getWork_title() {
		return work_title;
	}


	public void setWork_title(String work_title) {
		this.work_title = work_title;
	}


	//닫기
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			checkpu.dispose();
		}

	}


	public Dialog getCheckPU() {
		 return checkpu;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == iB) {
			System.out.println("누름");
			String message = "할당시킬 멤버를 고르세요.";
			new C_SprintDialog(this.mf,message).getAsspanel().setVisible(true);
		/*	memeber = new C_SprintDialog().getCheckmember();
			
			for (String m : memeber) {
				System.out.println("-----------------");
				System.out.println(m);
			}
			
			JList memberList*/
		}
	}
	
	
}
