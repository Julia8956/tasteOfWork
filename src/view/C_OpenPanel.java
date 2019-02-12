package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import model.Work;

public class C_OpenPanel extends JPanel implements ActionListener,MouseListener{
	private MainFrame mainFrame;
	private C_OpenPanel openPanel;
	private C_SprintMainPage sprintMain;
	private JButton Add_Work;
	
	private JTable open_Table;
	private JList<Work> openworklist;
	private DefaultListModel<Work> model = new DefaultListModel<>();
	
	//public C_OpenPanel() {}
	
	public C_OpenPanel(C_SprintMainPage sprintMain,MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.sprintMain = sprintMain;
		this.openPanel = this;
		
		//this.setBackground(Color.white);
		
		this.setPreferredSize(new Dimension(340,700));
		//this.setBackground(Color.GREEN);
		this.setLayout(new BorderLayout());

		//OPEN이라고 글자 나오는 거
		JPanel Open_Title_panel = new JPanel();
		Open_Title_panel.setPreferredSize(new Dimension(340,55));
		Open_Title_panel.setBackground(Color.decode("#2ecc71"));


		JLabel Open_Title_label = new JLabel("OPEN");
		Open_Title_label.setFont(new Font("Serif",Font.BOLD,25));
		Open_Title_label.setForeground(Color.white);
		
		Open_Title_panel.add(Open_Title_label);
		
		//OPEN 테이블 -> 해야 할 일 정렬
		String[] name = {"할일 명","할당자" , "긴급"};
		Object[][] date = {{"할일명1", "송낙규"},{"할일명2", "우리나"},{"할일명3", "문지원"}};

		//내용 수정 못하게
		DefaultTableModel model = new DefaultTableModel(date,name) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
		};
		
		
		JScrollPane open_scroll = new JScrollPane(openworklist = createopenworklists());
		open_scroll.setPreferredSize(new Dimension(340,600));
		open_scroll.setBackground(Color.white);
		
		//리스트 확인창 이벤트
		openworklist.addMouseListener(this);
		
		
		//OPEN 마지막에 버튼 창
		JPanel btn_Panel = new JPanel();
		btn_Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btn_Panel.setBackground(Color.white);
		btn_Panel.setPreferredSize(new Dimension(340,60));
		
		/*JButton */Add_Work = new JButton(new ImageIcon("images/Sprint_add.PNG"));
		Add_Work.setPreferredSize(new Dimension(50,50));
		
		Add_Work.setBorderPainted(false); Add_Work.setFocusPainted(false); Add_Work.setContentAreaFilled(false);
		
		Add_Work.addActionListener(this);
		
		btn_Panel.add(Add_Work);
		
		this.add(Open_Title_panel,"North");
		this.add(open_scroll, "Center");
		this.add(btn_Panel, "South");
		
		sprintMain.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Add_Work) {
			new C_CreatePU(this.mainFrame).getCreatePU().setVisible(true);
		}
	
	}

	//테이블 선택시 어떤 테이블 선택했는지 알수 있음
/*	private class TableEvent extends MouseAdapter{
		//MainFrame mainFrame;
		@Override
		public void mouseClicked(MouseEvent e) {
			//mainFrame =
			int row = open_Table.getSelectedRow();
			int colunn = open_Table.getSelectedColumn();

			System.out.println(open_Table.getValueAt(row,0));
			

		}
	}*/


	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == openworklist) {
			if (e.getClickCount() ==2) {
				Work work = openworklist.getSelectedValue();
				new C_CheckPU(this.mainFrame,work).getCheckPU().setVisible(true);
				System.out.println("누름");

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


	private JList<Work> createopenworklists(){
		//DefaultListModel<Work> model = new DefaultListModel<>();
		
		String[] member = {"문지원","정민지","우리나"};
		model.addElement(new Work("할일명", member , true));
		String[] member2 = {"송낙규","최인효","김규형"};
		model.addElement(new Work("할일명2", member2, false));

		
		JList<Work> list = new JList<Work>(model);
		
		list.setCellRenderer(new C_WorkRenderer());
		
		return list;
		
	}
	 
	 
	 
}
