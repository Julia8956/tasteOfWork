package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.vo.Work;


public class C_ProgressPanel extends JPanel implements ActionListener,MouseListener{
	private MainFrame mainFrame;
	private C_ProgressPanel progressPanel;
	private C_SprintMainPage sprintMain;
	
	private JTable progress_Table;
	private JButton Add_Work;
	
	private ArrayList<Work> workArrList = new ArrayList<Work>(); //추가 한부분
	
	private JList<Work> progresslist;
	DefaultListModel<Work> progrssmodel = new DefaultListModel<>();
	private int index; 
	
	
	public C_ProgressPanel(C_SprintMainPage sprintMain,MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.sprintMain = sprintMain;
		this.progressPanel = this;
		
		this.setPreferredSize(new Dimension(340,700));
		//this.setBackground(Color.yellow);
		this.setLayout(new BorderLayout());
		
		//In Progress이라고 글자 나오는 거
		JPanel Progress_Title_panel = new JPanel();
		Progress_Title_panel.setPreferredSize(new Dimension(340,55));
		Progress_Title_panel.setBackground(Color.decode("#f1c40f"));


		JLabel Progress_Title_label = new JLabel("In Progress");
		Progress_Title_label.setFont(new Font("Serif",Font.BOLD,25));
		Progress_Title_label.setForeground(Color.white);

		Progress_Title_panel.add(Progress_Title_label);

		this.add(Progress_Title_panel,"North");
		
		//Progress 리스트 창
		JScrollPane progress_scroll = new JScrollPane(progresslist = createprogresslist());
		progress_scroll.setPreferredSize(new Dimension(340,600));
		progress_scroll.setBackground(Color.white);
		
		//리스트 확인창 이벤트
		progresslist.addMouseListener(this);
		
		//버튼 패널 -> 실행중인 패널에 추가 하는것
		JPanel btn_Panel = new JPanel();
		btn_Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btn_Panel.setBackground(Color.white);
		btn_Panel.setPreferredSize(new Dimension(340,60));
		
		/*JButton*/ Add_Work = new JButton(new ImageIcon("images/Sprint_add.PNG"));
		Add_Work.setPreferredSize(new Dimension(50,50));
		
		Add_Work.setBorderPainted(false); Add_Work.setFocusPainted(false); Add_Work.setContentAreaFilled(false);
		
		Add_Work.addActionListener(this);
		
		btn_Panel.add(Add_Work);
		
		
		this.add(Progress_Title_panel, "North");
		this.add(progress_scroll, "Center");
		this.add(btn_Panel, "South");
		
		sprintMain.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Add_Work) {
			new C_CreatePU(this.mainFrame,this.progressPanel).getCreatePU().setVisible(true);
		}
	}

	private JList<Work> createprogresslist(){
		//DefaultListModel<Work> model = new DefaultListModel<>();

		String[] member = {"김규형","우리나"};
		progrssmodel.addElement(new Work("할일명", member , "긴급"));
		//String[] member2 = {"송낙규","최인효","김규형"};
		//model.addElement(new Work("할일명2", member2, false));


		JList<Work> list = new JList<Work>(progrssmodel);

		list.setCellRenderer(new C_WorkRenderer());

		return list;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == progresslist) {
			if (e.getClickCount() ==2) {
				/*int*/ index = progresslist.getSelectedIndex();
				Work work = progresslist.getSelectedValue();
				new C_CheckPU(this.mainFrame,work,this.progressPanel).getCheckPU().setVisible(true);
				//System.out.println("누름");


			}
		}
		
	}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		//C_CreatePU에서 확인 버튼을 누르면 실행할 메소드
		public void addWorkOnList(Work newwork) {
			//입력한 할일명, 긴급표시 Work객체 생성 해서 List에 올리기
			//Work newWork = new Work();
			newwork.setAllocator(null);

			progrssmodel.addElement(new Work(newwork.getWork_name(),newwork.getAllocator(),newwork.getLabel_name()));
			workArrList.add(newwork);

			progressPanel.revalidate();
		}
		
		//C_CheckPU에서 확인버튼 느렴 실행하는 메소드
		public void changeWorkOnList(Work changework) {
			progrssmodel.removeElementAt(index);
			
			progrssmodel.addElement(new Work(changework.getWork_name(),changework.getAllocator(),changework.getLabel_name(),changework.getLabel_color()));
			workArrList.add(changework);
			
			progressPanel.revalidate();
		}

}
