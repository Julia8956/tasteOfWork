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
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class C_OpenPanel extends JPanel implements ActionListener,MouseListener{
	private MainFrame mainFrame;
	private C_OpenPanel openPanel;
	private C_SprintMainPage sprintMain;
	private JButton Add_Work;
	
	private JTable open_Table;
	
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
		
		
		/*JTable*/ open_Table = new JTable(model);
		open_Table.setRowHeight(50);
		open_Table.setFont(new Font("Serif",Font.BOLD,15));
		
		open_Table.getColumnModel().getColumn(2).setCellEditor(new TableCell());
		open_Table.getColumnModel().getColumn(2).setCellRenderer(new TableCell());	
		

		//단일 선택
		open_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//open_Table.addMouseListener(new TableEvent());
		open_Table.addMouseListener(this);

		//열이동 금지
		open_Table.getTableHeader().setReorderingAllowed(false);
		
		//드래그
		open_Table.setDragEnabled(true);
		open_Table.setDropMode(DropMode.INSERT_ROWS);
		//open_Table.setTransferHandler(new TableRowTransferHandler(open_Table)); 

		JScrollPane open_scroll = new JScrollPane(open_Table);
		open_scroll.setPreferredSize(new Dimension(340,600));
		open_scroll.setBackground(Color.white);
		
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

	//테이블안에 사진 넣는 클래스
	 class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
	        JLabel imagesos;
	 
	        public TableCell() {
	            imagesos = new JLabel(new ImageIcon("images/work_sos.JPG"));
	        }
	 
	        @Override
	        public Object getCellEditorValue() {
	            return null;
	        }
	 
	        @Override
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
	                int row, int column) {
	        	if (row %2 == 0) {	
	        		return imagesos;
	        	}
	        	
	        	return null;
	        }
	 
	        @Override
	        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
	                int column) {
	            return imagesos;
	        }
	    } // end class TableCell extends AbstractCellEditor implements TableCellEditor,
	        // TableCellRenderer

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == open_Table) {
			if (e.getClickCount() ==2) {
				int row = open_Table.getSelectedRow();
				String title = open_Table.getValueAt(row,0)+"";
				new C_CheckPU(this.mainFrame,title).getCheckPU().setVisible(true);
				
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


	 
	 
	 
}
