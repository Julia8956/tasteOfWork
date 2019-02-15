package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import model.vo.Work;

//import org.jdesktop.swingx.JXDatePicker;

public class C_CheckPU extends JPanel implements ActionListener{
	private MainFrame mf;
	private Dialog checkpu;

	private String work_title; 		//할일명
	private JButton iB;				//
	private JButton label_btn;		//라벨 색깔 버튼
	private Color color;			//색깔
	private JComboBox asscom;		//컴보박스 - 할당자
	private JButton reviseB;		//닫기
	
	private JTextField wN;			//할일명 TextField
	private JTextField label_Text;	//라벨 TextField
	private JTextField fT;			//
	private JTextArea fa;
	private JButton insertB;
	
	private C_OpenPanel openpanel;
	private C_ProgressPanel progresspanel;
	private C_DonePanel donepanel;
	
	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	private Work work;
	
	public C_CheckPU(MainFrame mf,Work work) {
		this.mf = mf;
		this.work = work;
		
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
		/*JTextField*/ wN = new JTextField(15);
		//wN.setFont(new Font("Serif",Font.BOLD,20));
		wN.setSize(200, 40);
		wN.setLocation(150, 10);
		wN.setText(work.getWork_name());
		//System.out.println(this.getWork_title());
		
		//textField에 마우스 클릭시 내용지워지고 빈화면으로 바뀜
		wN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//아무것도 입력되지 않은 상태에서만 빈칸으로 만들기
				//if (nameCtn == 0) {
				wN.setText("");
				//}
			}
		});

		JXDatePicker term1DayPicker = new DatePicker().getDatePicker();
		term1DayPicker.setSize(120, 40);
		term1DayPicker.setLocation(80, 70);
		checkpu.add(term1DayPicker);

		JLabel wave = new JLabel(" ~ ");
		wave.setSize(100, 25);
		wave.setLocation(230, 85);
		wave.setFont(new Font("Serif",Font.BOLD,15));


		JXDatePicker term2DayPicker = new DatePicker().getDatePicker();
		term2DayPicker.setSize(120, 40);
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

		
		
		/*JComboBox*/ asscom = new JComboBox();
	//	asscom.setModel();

		if (work.getAllocator() == null) {
			asscom.addItem("선택하세요");
		}else {
			String[] ass_member = new String[work.getAllocator().length];

			for (int i = 0 ; i < ass_member.length ; i++) {
				ass_member[i] = work.getAllocator()[i];

				System.out.println(ass_member[i]);
				asscom.addItem(ass_member[i]);
			}

			//asscom.addItem((String[])ass_member);
		}
		
		asscom.setSize(200,30);
		asscom.setLocation(130, 170);
		asscom.setSelectedIndex(0);

		JLabel label = new JLabel("라벨");
		label.setFont(new Font("Serif",Font.BOLD,15));
		label.setSize(40,50);
		label.setLocation(50,210);

		/*JTextField*/ label_Text = new JTextField(10);
		label_Text.setText(work.getLabel_name());
		label_Text.setSize(200,30);
		label_Text.setLocation(100,220);
		

		//textField에 마우스 클릭시 내용지워지고 빈화면으로 바뀜
		label_Text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//아무것도 입력되지 않은 상태에서만 빈칸으로 만들기
				//if (nameCtn == 0) {
				label_Text.setText("");
				//}
			}
		});
		

		/*JButton*/ label_btn = new JButton();
		label_btn.setSize(30, 30);
		label_btn.setLocation(310, 220);
		label_btn.setBackground(work.getLabel_color());

		label_btn.addActionListener(this);

		JLabel feedback = new JLabel("피드백");	
		feedback.setSize(100, 70);
		feedback.setLocation(50, 270);
		iB.setFont(new Font("Serif",Font.BOLD,18));

		iB.addActionListener(this);


		//피드백을 입력 한다
		/*JTextField*/ fT = new JTextField(100);	
		fT.setSize(300, 65);
		fT.setLocation(50, 320);



		//입력버튼을 누르면 이제 피드백 내용으로 입력값이 전달된다
		/*JButton*/ insertB = new JButton("입력");
		insertB.setSize(65, 65);
		insertB.setLocation(360, 320);
		
		insertB.addActionListener(this);

		JLabel fDL = new JLabel("피드백내용");	
		fDL.setSize(100, 70);
		fDL.setLocation(50, 365);

		//피드백을 을 입력하면, 이곳에 저장 된다
		/*JTextArea*/ fa = new JTextArea();
		fa.setEditable(false);
		/*fa.setSize(365, 270);
		fa.setLocation(50, 410);*/

		JScrollPane faScroller = new JScrollPane(fa);
		faScroller.setSize(365, 160);
		faScroller.setLocation(50, 410);

		fT.addActionListener(this);

		JButton deleteB = new JButton("삭제"); //삭제할 내용을 삭제 한다
		deleteB.setSize(60, 30);
		deleteB.setLocation(50, 600);


		/*JButton*/ reviseB = new JButton("닫기");
		reviseB.setSize(60, 30);
		reviseB.setLocation(350, 600);

		

		checkpu.add(wN);
		checkpu.add(dT);
		checkpu.add(wave);
		checkpu.add(addMember);
		checkpu.add(iB);
		checkpu.add(asscom);
		checkpu.add(label);
		checkpu.add(label_Text);
		checkpu.add(label_btn);
		checkpu.add(feedback);
		checkpu.add(fT);
		checkpu.add(insertB);
		checkpu.add(fDL);
		checkpu.add(faScroller);
		checkpu.add(deleteB);
		checkpu.add(reviseB);
		
	}
	
	//CheckPopUp 할일을 누르면 세부사항이 보이는 창
	public C_CheckPU(MainFrame mf,Work work,C_OpenPanel openpanel) {
		this(mf,work);
		
		this.openpanel = openpanel;
		
		reviseB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String work_name = wN.getText();
				String Allocator = (String)asscom.getSelectedItem();
				String label_name = label_Text.getText();
				Color btn_color = label_btn.getBackground();
				
				work.setWork_name(work_name);
				work.setLabel_name(label_name);
				work.setLabel_color(btn_color);
				
				openpanel.changeWorkOnList(work);
				
				checkpu.dispose();
			}
			
		});
	}
	
	public C_CheckPU(MainFrame mf, Work work , C_ProgressPanel progresspanel) {
		this(mf,work);
		
		this.progresspanel = progresspanel;
		
		reviseB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String work_name = wN.getText();
				String Allocator = (String)asscom.getSelectedItem();
				String label_name = label_Text.getText();
				Color btn_color = label_btn.getBackground();
				
				work.setWork_name(work_name);
				work.setLabel_name(label_name);
				work.setLabel_color(btn_color);
				
				progresspanel.changeWorkOnList(work);
				
				checkpu.dispose();
			}
			
		});
	}
	
	public C_CheckPU(MainFrame mf, Work work, C_DonePanel donepanel) {
		this(mf,work);
		
		this.donepanel = donepanel;
		
		reviseB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String work_name = wN.getText();
				String Allocator = (String)asscom.getSelectedItem();
				String label_name = label_Text.getText();
				Color btn_color = label_btn.getBackground();
				
				work.setWork_name(work_name);
				work.setLabel_name(label_name);
				work.setLabel_color(btn_color);
				
				donepanel.changeWorkOnList(work);
				
				checkpu.dispose();
			}
			
		});
		
		
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
			String message = "할당시킬 멤버를 고르세요.";
			new C_SprintDialog(this.mf,this,message).getAsspanel().setVisible(true);
		}

		if (e.getSource() == label_btn) {
			new C_ColorDialog(mf,this).getColordialog().setVisible(true);
		}
		
		if (e.getSource() == fT || e.getSource() == insertB) {
			String text = fT.getText();
			fa.append(text + "\n");

			fT.setText("");
			fT.requestFocus();
			
		}
	}


	public void ChangColor(Color color) {
		label_btn.setBackground(color);
		
		checkpu.revalidate();
	}
	
	public void ChangeAss(String str) {
		//초기화
		asscom.removeAllItems();
	
		//System.out.println("----------------------");
		//System.out.println(str);
		
		String[] sarr = str.split("/");
		
		HashSet<String> memberSet = new HashSet<String>();
		
		for (int i = 0 ; i < sarr.length ; i++) {
			memberSet.add(sarr[i]);
			
		}
		
		//System.out.println(memberSet);
		
		Object[] objass = memberSet.toArray();
		
		String[] checkmember = new String[objass.length];
		
		for (int i = 0 ; i < checkmember.length ; i++) {
			checkmember[i] = (String)objass[i];
			
		}
		
		work.setAllocator(checkmember);
		
		for (int i = 0 ; i < checkmember.length ; i++) {
			checkmember[i] = work.getAllocator()[i];
			
			asscom.addItem(checkmember[i]);
		}
		checkpu.revalidate();
	}
}
