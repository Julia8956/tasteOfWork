package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class B_CalendarPanel extends JPanel {

	
	private Calendar cal;
	private DefaultTableModel model;
	private JLabel monthName;
	private B_CalendarPanel calendarPanel;
	
	
	public B_CalendarPanel(B_ProjectPage projectPage) {
		
		//this.setSize(400, 688);
		//this.setPreferredSize(new Dimension(400, 688));
		//this.setLocation(350, 80);
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		//this -> 캘린더 넣을 영역패널
		
		
		JPanel addMemoPanel = new JPanel();
		
		JButton addMemo = new JButton("달력에 일정 추가");
		
		
		
		//calendar -> 캘린더구성할 패널
		JPanel calendar = new JPanel();
		calendar.setBackground(Color.WHITE);
		calendar.setLayout(new BorderLayout());
		//calendar.setSize(300, 300);
		
		/*JTextField temp = new JTextField("달력칸");
		this.add(temp);*/
		
		//월이름, 이전달, 다음달 버튼 포함 패널
		JPanel calendarHeadPanel = new JPanel();
		calendarHeadPanel.setBackground(Color.WHITE);
		calendarHeadPanel.setLayout(new BorderLayout());
		calendarHeadPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		
		
		JPanel showTodayPanel = new JPanel();
		showTodayPanel.setBackground(Color.WHITE);
		showTodayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel showToday = new JLabel();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(today);
		showToday.setFont(new Font("", Font.ITALIC, 17));
		showToday.setText("Today : " + str);
		showTodayPanel.add(showToday);
		calendarHeadPanel.add(showTodayPanel, "North");
		
		
		
		//월이름 보여줄 라벨
		monthName = new JLabel();
		monthName.setHorizontalAlignment(JLabel.CENTER);
		monthName.setFont(new Font("", Font.ITALIC, 20));
		calendarHeadPanel.add(monthName, "Center");
		
		//캘린더 객체
		cal = new GregorianCalendar();
		//이전달로 넘어갈 버튼
		JButton prevMonthBtn = new JButton("< 이전 달");
		calendarHeadPanel.add(prevMonthBtn, "West");
		prevMonthBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//월 -1
				cal.add(Calendar.MONTH, -1);
				updateMonth();
			}
			
		});
		//다음달로 넘어갈 버튼
		JButton nextMonthBtn = new JButton("다음 달 >");
		calendarHeadPanel.add(nextMonthBtn, "East");
		nextMonthBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//월 +1
				cal.add(Calendar.MONTH, 1);
				updateMonth();
			}
		});
		
		
		
		String[] columns = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		//요일을 열로 하고, 행은 null로 하는 테이블모델만들기
		model = new DefaultTableModel(null, columns);
		
		//model.isCellEditable();
		JTable calendarTable = new JTable(model);
		//Dimension d = new Dimension(300, 300);
		//calendarTable.setSize(d);
		calendarTable.setCellSelectionEnabled(true);
		calendarTable.setRowSelectionAllowed(false);
		calendarTable.setColumnSelectionAllowed(false);
		calendarTable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		calendarTable.setFont(new Font("", Font.PLAIN, 15));
		
		//Column head 움직이지 못하게 하기
		calendarTable.getTableHeader().setReorderingAllowed(false);
		
		//calendarTable.setFillsViewportHeight(true);
		
		
		
		//calendarTable.setRowHeight(calendarTable.getColumn(0).getWidth());
		calendarTable.setRowHeight(70);
		//DefaultTableCellRenderer cellAlingCenter = new DefaultTableCellRenderer();
		
		
		/*MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();
		calendarTable.setDefaultRenderer(String[].class, renderer);*/
		
		
		calendarTable.getColumn("SUN").setCellRenderer(new TextAreaRenderer());
		calendarTable.getColumn("SUN").setCellEditor(new TextAreaEditor());
		calendarTable.getColumn("MON").setCellRenderer(new TextAreaRenderer());
		calendarTable.getColumn("MON").setCellEditor(new TextAreaEditor());
		calendarTable.getColumn("TUE").setCellRenderer(new TextAreaRenderer());
		calendarTable.getColumn("TUE").setCellEditor(new TextAreaEditor());
		calendarTable.getColumn("WED").setCellRenderer(new TextAreaRenderer());
		calendarTable.getColumn("WED").setCellEditor(new TextAreaEditor());
		calendarTable.getColumn("THU").setCellRenderer(new TextAreaRenderer());
		calendarTable.getColumn("THU").setCellEditor(new TextAreaEditor());
		calendarTable.getColumn("FRI").setCellRenderer(new TextAreaRenderer());
		calendarTable.getColumn("FRI").setCellEditor(new TextAreaEditor());
		calendarTable.getColumn("SAT").setCellRenderer(new TextAreaRenderer());
		calendarTable.getColumn("SAT").setCellEditor(new TextAreaEditor());
		
		
		
		JScrollPane scroll = new JScrollPane(calendarTable);
		//scroll.setSize(d);
		//scroll.setOpaque(true);
		scroll.setSize(calendarTable.getSize());
		scroll.setViewportBorder(BorderFactory.createEmptyBorder());
		scroll.setViewportBorder(null);
		scroll.getViewport().setBackground(Color.WHITE);
		scroll.setBackground(Color.WHITE);
		scroll.setForeground(Color.WHITE);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		//scroll.setViewportBorder(null);
		
		calendar.add(calendarHeadPanel, "North");
		calendar.add(scroll, "Center");
		
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.white);
		southPanel.setSize(300, 500);
		calendar.add(southPanel, "South");
		
		
		
		this.add(calendar, "Center");
		
		
		
		this.updateMonth();
		
		
		projectPage.add(this);
	}
	
	
	public void updateMonth() {
		//초기값 1일로 set하기
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		//월을 January로 표현하기
		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = cal.get(Calendar.YEAR);
		monthName.setText(month + " " + year);
		
		//int today 
		
		//1일이 무슨요일인지
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		//한달에 몇일인지
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//한달에 몇주인지
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		model.setRowCount(0);
		model.setRowCount(weeks);
		//model.setRowCount(6);
		
		/*JPanel cellAreaPanel = new JPanel();
		JTextArea cellArea = new JTextArea("", 3, 10);
		cellAreaPanel.add(cellArea);*/
		//ArrayList cell = new ArrayList();
		//String[] cell = new String[10];
		
		//1일에 해당하는 요일-1
		int i = startDay - 1;
		for (int day = 1; day <= numberOfDays; day++) {
			//cellArea.setText(day+ "");
			/*cell[0] = day + "";
			cell[1] = "일정 추가";*/
			
			model.setValueAt(day, i/7, i%7);
			i = i + 1;
		}
		
		
	}
	
	/*class MultiLineTableCellRenderer extends JList<String> implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			//셀(Object value)안의 값이 String[]일때 여러줄을 만들기
			if(value instanceof String[]) {
				setListData((String[]) value);
			}
			
			//cell background color when selected
			if(isSelected) {
				setBackground(UIManager.getColor("Table.selectionBackground"));
			}else {
				setBackground(UIManager.getColor("Table.background"));
			}
			
			return this;
		}
		
	}*/
	
	
	
}

class TextAreaRenderer extends JScrollPane implements TableCellRenderer {

	JTextArea textArea;
	public TextAreaRenderer() {
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		//textArea.setBorder(new TitledBorder("일정"));
		getViewport().add(textArea);
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		if(isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
			textArea.setForeground(table.getSelectionForeground());
			textArea.setBackground(table.getSelectionBackground());
		}else {
			setForeground(table.getForeground());
			setBackground(table.getBackground());
			textArea.setForeground(table.getForeground());
			textArea.setBackground(table.getBackground());
		}
		if(value != null) {
			textArea.setText(value + "");
		}else {
			textArea.setText("");
		}
		textArea.setCaretPosition(0);
		return this;
	}
	
}

class TextAreaEditor extends DefaultCellEditor {

	protected JScrollPane scrollpane;
	protected JTextArea textArea;
	
	public TextAreaEditor() {
		super(new JTextField());
		scrollpane = new JScrollPane();
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		//textArea.setBorder(new TitledBorder("일정"));
		scrollpane.getViewport().add(textArea);
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
			int row, int column) {
		if (value != null) {
			textArea.setText(value + "");
		}else {
			textArea.setText("");
		}
		return scrollpane;
	}
	public Object getCellEditorValue() {
		return textArea.getText();
	}
}


