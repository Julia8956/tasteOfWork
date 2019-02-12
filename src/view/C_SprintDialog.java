package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class C_SprintDialog extends JPanel implements ActionListener{
	private MainFrame mainframe;
	private C_CheckPU checkpu;
	private Dialog C_SprintDialog;

	private int count = 0;
	private String[] checkmember = new String[10];
	private String result = "";

	private JButton OK_btn;
	
	private String message;

	public C_SprintDialog() {}

	public C_SprintDialog(MainFrame mainframe,String message) {
		this.mainframe = mainframe;
		
		this.message = message;

		C_SprintDialog = new Dialog(mainframe,"할당자 선택창");
		C_SprintDialog.setLayout(null);
		C_SprintDialog.setSize(350,350);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width /2 )  - (C_SprintDialog.getWidth() / 2);
		int yPos = (dim.height / 2) - (C_SprintDialog.getHeight() / 2);
		
		C_SprintDialog.setLocation(xPos, yPos);


		JLabel title = new JLabel(message);
		title.setFont(new Font("Serif",Font.BOLD, 15));
		title.setSize(180, 50);
		title.setLocation(15, 30);

		//패널에 값넣기
		String[] names = {"김규형","문지원","송낙규", "우리나", "정민지", "최인효"};


		JCheckBox[] Ass_Check = new JCheckBox[names.length];

		for (int i = 0 ; i < Ass_Check.length ; i++) {
			Ass_Check[i] = new JCheckBox(names[i]);
		}

		//Panel 위에 얹기 -> CheckPanel
		JPanel checkPanel = new JPanel();

		BoxLayout layout = new BoxLayout(checkPanel, BoxLayout.Y_AXIS);
		checkPanel.setLayout(layout);

		for (int i = 0 ; i < Ass_Check.length ; i++) {
			checkPanel.add(Ass_Check[i]);
		}

		//JLabel text = new JLabel("선택한 과일이 없습니다.");
	
		for (int i = 0  ; i < Ass_Check.length ; i++) {
			Ass_Check[i].addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					int tep = 0;
					String result1 = "";
					
					for (int i = 0; i < Ass_Check.length ; i++) {
						if (Ass_Check[i].isSelected()) {							
							
							result += Ass_Check[i].getText() + "/";
							
							tep++;
						}

						
					}
				}

			});
		}
	

		//System.out.println(text.getText()+"");

		JScrollPane scroll = new JScrollPane(checkPanel);
		scroll.setSize(180, 200);
		scroll.setLocation(30, 80);
		//checkPanel.add(scroll);

		/*JButton */ OK_btn = new JButton("확인");
		OK_btn.setLocation(220, 290);
		OK_btn.setSize(80,30);

		OK_btn.addActionListener(this);

		JButton Cancel_btn = new JButton("닫기");
		Cancel_btn.setLocation(20, 290);
		Cancel_btn.setSize(80,30);

		Cancel_btn.addActionListener(new CloseEvent());

		C_SprintDialog.add(title);
		C_SprintDialog.add(scroll);
		C_SprintDialog.add(OK_btn);
		C_SprintDialog.add(Cancel_btn);

		//mainFrame.add(AssPanel);

		//return AssPanel;
	}

	public String[] getCheckmember() {
		return checkmember;
	}

	public void setCheckmember(String[] checkmember) {
		this.checkmember = checkmember;
	}

	public Dialog getAsspanel() {
		return this.C_SprintDialog;
	}

	//닫기
	private class CloseEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			C_SprintDialog.dispose();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == OK_btn) {
			//new C_CheckPU().setMemeber(this.checkmember);
			System.out.println(result);
					
			String[] name = result.split("/");
			
			name = new HashSet<String>(Arrays.asList(name)).toArray(new String[0]);
			System.out.println("after length=" + name.length);
			
			/*String[]*/ checkmember = new String[name.length];
			
			for (int i = 0 ; i < checkmember.length ; i++) {
				checkmember[i] = name[i];
				System.out.println(checkmember[i]);
			}
			
			//JList returnlist = new JList(checkmember);
			
			//new C_CheckPU(this.mainframe,new C_CheckPU().getName()).getDialogMember(checkmember);
			
			C_SprintDialog.dispose();
		}
	}



}
