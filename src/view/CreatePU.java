package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreatePU extends JPanel{
	private JFrame mf;
	private JPanel mp;
	
	public CreatePU(JFrame mf) {
		this.mf = mf;
		this.mp = this;
		
		mf.setSize(390,380);
		this.setLayout(null);
		
		JLabel wL = new JLabel("할일 이름");	
		wL.setLocation(30, 4);
		wL.setSize(100, 100);
		
		JLabel dL = new JLabel("세부 내용");
		//dL.setFont(new Font("Serif",Font.BOLD,15));
		dL.setLocation(30, 40);
		dL.setSize(100, 100);
		
		//사용자가 할일의 이름을 입력하여 이름을 정해준다
		//CheckPU wN의 라벨로 들어간다
		JTextField wT = new JTextField(15);	
		wT.setLocation(100, 40);			
		wT.setSize(230, 25);
					
		//사용자가 세부내용을 입력하는 부분, 입력을 끝내면 CheckPU dT 텍스트 필드에서 보여진다
		JTextField dT = new JTextField(100);	
		dT.setLocation(30, 110);			
		dT.setSize(300, 50);
		
		
		//기간 Label
		JLabel L_tearm = new JLabel("기간");
		L_tearm.setFont(new Font("Serif",Font.BOLD,15));
		L_tearm.setSize(100, 25);					
		L_tearm.setLocation(30, 180);
		
		//시작하는 날짜 를 입력하면, CheckPU term1에 라벨로 들어간다
		JTextField term1 = new JTextField(20);
		term1.setText("시작날짜");
		term1.setSize(100, 25);					
		term1.setLocation(30, 210);
		
		JLabel wave = new JLabel(" ~ ");
		wave.setSize(60, 50);
		wave.setLocation(170, 200);
		
		//끝나는 날짜를 입력하면, CheckPU term2에 라벨로 들어간다
		JTextField term2 = new JTextField(20);
		term2.setText("종료날짜");
		term2.setSize(100, 25);					
		term2.setLocation(220, 210);
		
		//닫기 버튼을 누르면 창이 닫아진다
		JButton closeB = new JButton("닫기");		
		closeB.setSize(60, 30);
		closeB.setLocation(30, 280);
		
		closeB.addActionListener(new CloseEvent());
		
		//저장 버튼을 누르면 변경 사항이 저장이 되어, CheckPU의 객체가 생성된다
		JButton saveB = new JButton("저장");		
		saveB.setSize(60, 30);					
		saveB.setLocation(250, 280);
		
		this.add(wL);
		this.add(dL);
		this.add(wT);
		this.add(dT);
		this.add(L_tearm);
		this.add(term1);
		this.add(term2);
		this.add(wave);
		this.add(closeB);
		this.add(saveB);
		
		mf.add(this);
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
	
	
	//닫기
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
				mf.dispose();
		}
		
	}
}
