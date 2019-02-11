package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

import view.C_OpenPanel.TableCell;



public class C_ProgressPanel extends JPanel implements ActionListener,MouseListener{
	private MainFrame mainFrame;
	private C_ProgressPanel progressPanel;
	private C_SprintMainPage sprintMain;
	
	private JTable progress_Table;
	private JButton Add_Work;
	
	
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
		
		//진행중인 일들 리스트
		String[] name = {"할일 명","할당자" , "긴급"};
		Object[][] date = {};

		//내용 수정 못하게
		DefaultTableModel model = new DefaultTableModel(date,name) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
		};
		
		
		/*JTable*/ progress_Table = new JTable(model);
		progress_Table.setRowHeight(50);
		progress_Table.setFont(new Font("Serif",Font.BOLD,15));
		progress_Table.getColumnModel().getColumn(2).setCellEditor(new TableCell());
		progress_Table.getColumnModel().getColumn(2).setCellRenderer(new TableCell());


		//단일 선택
		progress_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//open_Table.addMouseListener(new TableEvent());
		progress_Table.addMouseListener(this);

		//열이동 금지
		progress_Table.getTableHeader().setReorderingAllowed(false);
		
		//드래그
		progress_Table.setDragEnabled(true);
		progress_Table.setDropMode(DropMode.INSERT_ROWS);
		//progress_Table.setTransferHandler(new TableRowTransferHandler(progress_Table)); 
		
		JScrollPane progress_scroll = new JScrollPane(progress_Table);
		progress_scroll.setPreferredSize(new Dimension(340,600));
		progress_scroll.setBackground(Color.white);
		
		
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
			new C_CreatePU(this.mainFrame).getCreatePU().setVisible(true);
		}
	}

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
			return imagesos;
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
		if (e.getSource() == progress_Table) {
			if (e.getClickCount() ==2) {
				int row = progress_Table.getSelectedRow();
				String title = progress_Table.getValueAt(row,0)+"";
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
