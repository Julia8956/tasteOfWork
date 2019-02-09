package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class B_CalendarPanel extends JPanel {

	
	private Calendar cal;
	private DefaultTableModel model;
	private JLabel monthName;
	private B_CalendarPanel calendarPanel;
	
	
	public B_CalendarPanel(B_ProjectPage projectPage) {
		
		//this.setSize(400, 688);
		//this.setPreferredSize(new Dimension(400, 688));
		//this.setLocation(350, 80);
		
		//this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		//this -> 캘린더 넣을 영역패널
		
		
		JPanel addMemoPanel = new JPanel();
		
		JButton addMemo = new JButton("달력에 일정 추가");
		
		
		
		//calendar -> 캘린더구성할 패널
		JPanel calendar = new JPanel();
		calendar.setLayout(new BorderLayout());
		//calendar.setSize(300, 300);
		
		/*JTextField temp = new JTextField("달력칸");
		this.add(temp);*/
		
		//월이름, 이전달, 다음달 버튼 포함 패널
		JPanel calendarHeadPanel = new JPanel();
		calendarHeadPanel.setLayout(new BorderLayout());
		calendarHeadPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
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
		calendarTable.setRowHeight(70);
		calendarTable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		//calendarTable.setAlignmentX(CENTER_ALIGNMENT);
		//calendarTable.setAlignmentY(CENTER_ALIGNMENT);
		//calendarTable.setFocusable(focusable);
		calendarTable.setFont(new Font("", Font.PLAIN, 15));
		
		JScrollPane scroll = new JScrollPane(calendarTable);
		//scroll.setSize(d);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		//scroll.setViewportBorder(null);
		
		calendar.add(calendarHeadPanel, "North");
		calendar.add(scroll, "Center");
		
		
		this.add(calendar, "Center");
		
		
		
		this.updateMonth();
		
		
		projectPage.add(this);
	}
	
	
	public void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		//월을 January로 표현하기
		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = cal.get(Calendar.YEAR);
		monthName.setText(month + " " + year);
		
		//int today 
		
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		//한달에 몇일인지
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//한달에 몇주인지
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		
		model.setRowCount(0);
		model.setRowCount(weeks);
		
		int i = startDay - 1;
		for (int day = 1; day <= numberOfDays; day++) {
			//1을 0행 1열에 넣기
			//2를 0행 2열에 넣기
			//7을 1행 0열에 넣기
			model.setValueAt(day, i/7, i%7);
			i = i + 1;
		}
		
		
	}
	
	
	
}
