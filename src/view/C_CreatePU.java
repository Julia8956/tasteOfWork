package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import model.vo.Work;

//import org.jdesktop.swingx.JXDatePicker;

public class C_CreatePU extends JPanel{
	private MainFrame mf;
	private Dialog cp;
	private String work_name;
	private String work_subject;
	
	public C_CreatePU() {}
	
	public C_CreatePU(MainFrame mf, C_ProgressPanel progressPanel) {}
	
	public C_CreatePU(MainFrame mf, C_DonePanel DoenPanel) {}
	
	public C_CreatePU(MainFrame mf, C_OpenPanel openPanel) {
		
		
		cp = new Dialog(mf,"할일 생성");
		
		cp.setSize(390,400);
		cp.setResizable(false);    //프레임 고정
		cp.setLayout(null);
		
		//프레임 창 안보이게
		cp.setUndecorated(true);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width /2 )  - (cp.getWidth() / 2);
		int yPos = (dim.height / 2) - (cp.getHeight() / 2);
		
		cp.setLocation(xPos, yPos);
		
		JLabel wL = new JLabel("할일 이름");	
		wL.setLocation(30, 4);
		wL.setSize(100, 100);
		
		
		//사용자가 할일의 이름을 입력하여 이름을 정해준다
		
		JTextField wT = new JTextField(15);	//할일 TextField
		wT.setLocation(100, 40);			
		wT.setSize(230, 25);
		
		
		
		//기간 Label
		JLabel L_tearm = new JLabel("기간");
		L_tearm.setFont(new Font("Serif",Font.BOLD,15));
		L_tearm.setSize(100, 25);					
		L_tearm.setLocation(30, 80);    	//30,180
		
		
		JXDatePicker term1DayPicker = new DatePicker().getDatePicker();
		term1DayPicker.setLocation(30, 110);	//30,210
		term1DayPicker.setSize(120, 40);
		cp.add(term1DayPicker);
		
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(60, 50);
		wave.setFont(new Font("",Font.BOLD,10));
		wave.setLocation(170, 100);
		
		
		JXDatePicker term2DayPicker = new DatePicker().getDatePicker();
		term2DayPicker.setLocation(220, 110);
		term2DayPicker.setSize(120, 40);
		cp.add(term2DayPicker);
		
		JLabel dL = new JLabel("세부 내용");
		//dL.setFont(new Font("Serif",Font.BOLD,15));
		dL.setLocation(30, 130);			//30,40
		dL.setSize(100, 100);
		
		//사용자가 세부내용을 입력하는 부분, 입력을 끝내면 CheckPU dT 텍스트 필드에서 보여진다
		JTextField dT = new JTextField("세부 사항을 입력 하시오",100);  //세부사항 TextField 
		dT.setLocation(30, 190);			
		dT.setSize(300, 70);

		//textField에 마우스 클릭시 내용지워지고 빈화면으로 바뀜
		dT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//아무것도 입력되지 않은 상태에서만 빈칸으로 만들기
				//if (nameCtn == 0) {
				dT.setText("");
				//}
			}
		});

		
		//worksubject !!!!!!!
		JLabel work_subjectLable = new JLabel("Label");
		work_subjectLable.setSize(110, 110);
		work_subjectLable.setLocation(30, 235);
		
		//긴급 textField
		JTextField work_subjectText = new JTextField("Label 입력",15);
		work_subjectText.setSize(150, 25);
		work_subjectText.setLocation(100, 280);

		//textField에 마우스 클릭시 내용지워지고 빈화면으로 바뀜
		work_subjectText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//아무것도 입력되지 않은 상태에서만 빈칸으로 만들기
				//if (nameCtn == 0) {
				work_subjectText.setText("");
				//}
			}
		});
		
		//닫기 버튼을 누르면 창이 닫아진다
		JButton closeB = new JButton("닫기");		
		closeB.setSize(70, 30);
		closeB.setLocation(30, 320);
		
		closeB.addActionListener(new CloseEvent());
		
		//저장 버튼을 누르면 변경 사항이 저장이 되어, openpanel에 올라간다
		JButton saveB = new JButton("저장");		
		saveB.setSize(70, 30);					
		saveB.setLocation(250, 320);
		
		saveB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				work_name = wT.getText();
				work_subject = work_subjectText.getText();
				
				Work work = new Work();
				work.setWork_name(work_name);
				work.setLabel_name(work_subject);
				
				openPanel.addWorkOnList(work);
				
				cp.dispose();
			}
		});
				
				
				
		
		cp.add(wL);
		cp.add(dL);
		cp.add(wT);
		cp.add(dT);
		cp.add(L_tearm);
		cp.add(wave);
		cp.add(work_subjectText);
		cp.add(work_subjectLable);
		cp.add(closeB);
		cp.add(saveB);
		

	}
	
	
	//닫기
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				cp.dispose();
		}
		
	}
	
	public Dialog getCreatePU() {
		return cp;
	}
}
