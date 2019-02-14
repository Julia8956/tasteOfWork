package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class C_DonePanel extends JPanel implements ActionListener{
	private MainFrame mainFrame;
	private C_DonePanel DoenPanel;
	private C_SprintMainPage sprintMain;
	
	private JButton Add_Work;
	
	public C_DonePanel(C_SprintMainPage sprintMain,MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.sprintMain = sprintMain;
		this.DoenPanel = this;
		
		this.setPreferredSize(new Dimension(340,700));
		//this.setBackground(Color.blue);

		this.setLayout(new BorderLayout());

		//In Progress이라고 글자 나오는 거
		JPanel Done_Title_panel = new JPanel();
		Done_Title_panel.setPreferredSize(new Dimension(340,55));
		Done_Title_panel.setBackground(Color.decode("#3498db"));


		JLabel Done_Title_label = new JLabel("Done");
		Done_Title_label.setFont(new Font("Serif",Font.BOLD,25));
		Done_Title_label.setForeground(Color.white);

		Done_Title_panel.add(Done_Title_label);

		
		//버튼 패널 -> 다한 할일 모음
		JPanel btn_Panel = new JPanel();
		btn_Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btn_Panel.setBackground(Color.white);
		btn_Panel.setPreferredSize(new Dimension(340,60));
		
		/*JButton*/ Add_Work = new JButton(new ImageIcon("images/Sprint_add.PNG"));
		Add_Work.setPreferredSize(new Dimension(50,50));
		
		Add_Work.setBorderPainted(false); Add_Work.setFocusPainted(false); Add_Work.setContentAreaFilled(false);
		Add_Work.addActionListener(this);
		
		btn_Panel.add(Add_Work);
		
		
		this.add(Done_Title_panel,"North");
		this.add(btn_Panel, "South");
		
		sprintMain.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Add_Work) {
		//	new C_CreatePU(mainFrame).getCreatePU().setVisible(true);
		}
	}

}
