package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

//import org.jdesktop.swingx.JXDatePicker;

public class C_CreatePU extends JPanel{
	private MainFrame mf;
	private Dialog cp;
	
	public C_CreatePU(MainFrame mf) {
		
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
		//CheckPU wN의 라벨로 들어간다
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
		term1DayPicker.setSize(100, 40);
		cp.add(term1DayPicker);
		
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(60, 50);
		wave.setLocation(170, 100);
		
		
		JXDatePicker term2DayPicker = new DatePicker().getDatePicker();
		term2DayPicker.setLocation(220, 110);
		term2DayPicker.setSize(100, 40);
		cp.add(term2DayPicker);
		
		JLabel dL = new JLabel("세부 내용");
		//dL.setFont(new Font("Serif",Font.BOLD,15));
		dL.setLocation(30, 130);			//30,40
		dL.setSize(100, 100);
		
		//사용자가 세부내용을 입력하는 부분, 입력을 끝내면 CheckPU dT 텍스트 필드에서 보여진다
		JTextField dT = new JTextField(100);  //세부사항 TextField 
		dT.setLocation(30, 190);			
		dT.setSize(300, 70);
		
		//긴급 라벨 !!!!!!!
		JLabel emergencyL = new JLabel("긴급");
		emergencyL.setSize(110, 110);
		emergencyL.setLocation(250, 235);
		
		//긴급 체크박스
		JCheckBox emergencyCB = new JCheckBox();
		emergencyCB.setSize(50, 50);
		emergencyCB.setLocation(280, 265);
		
		//닫기 버튼을 누르면 창이 닫아진다
		JButton closeB = new JButton("닫기");		
		closeB.setSize(60, 30);
		closeB.setLocation(30, 320);
		
		closeB.addActionListener(new CloseEvent());
		
		//저장 버튼을 누르면 변경 사항이 저장이 되어, CheckPU의 객체가 생성된다
		JButton saveB = new JButton("저장");		
		saveB.setSize(60, 30);					
		saveB.setLocation(250, 320);
		
		cp.add(wL);
		cp.add(dL);
		cp.add(wT);
		cp.add(dT);
		cp.add(L_tearm);
		cp.add(wave);
		cp.add(emergencyL);
		cp.add(emergencyCB);
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
