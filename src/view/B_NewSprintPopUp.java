package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXDatePicker;

import model.vo.Project;
import model.vo.Sprint;

public class B_NewSprintPopUp extends JPanel {
	
	private MainFrame mainFrame;
	private JButton plusButton;
	private Dialog newSprintPopUp;
	
	//Sprint필드에 저장할 속성
	private String sprintTitle;
	private Date sprintStartDay;
	private Date sprintEndDay;
	private String sprintDetail;
	private String sprintToDo;
	
	private int nameCtn = 0;
	//private int startDayCtn = 0;
	//private int endDayCtn = 0;
	private int descriptionCtn = 0;
	
	public B_NewSprintPopUp(MainFrame mainFrame, B_SprintPanel sprintPanel) {
		
		newSprintPopUp = new Dialog(mainFrame, "새 스프린트 만들기");
		//newSprintPopUp.setBackground(Color.darkGray);
		//newSprintPopUp.setBounds(100, 80, 515, 680);
		
		//팝업위치조정(화면가운데)
		newSprintPopUp.setSize(515, 680);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (newSprintPopUp.getWidth() / 2);
		int yPos = (dim.height / 2) - (newSprintPopUp.getHeight() / 2);
		newSprintPopUp.setLocation(xPos, yPos);
		
		
		newSprintPopUp.setLayout(null);
		//newSprintPopUp.setOpacity(0.5f);
		newSprintPopUp.setUndecorated(true);
		newSprintPopUp.setBackground(B_ProjectPage.POPUP_COLOR);
		
		setUIFont (new javax.swing.plaf.FontUIResource("맑은 고딕", Font.ITALIC, 15));
		
		
		//이름
		JTextField sprintName = new JTextField("새 스프린트 이름", 30);
		//sprintName.setFont(new Font("",Font.BOLD, 20));
		sprintName.setLocation(30, 50);				
		sprintName.setSize(450,45);
		newSprintPopUp.add(sprintName);

		//textField에 마우스 클릭시 내용지워지고 빈화면으로 바뀜
		sprintName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//아무것도 입력되지 않은 상태에서만 빈칸으로 만들기
				if (nameCtn == 0) {
					sprintName.setText("");
				}
			}
		});

		
		sprintName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//키보드 입력 발생시 ctn++해주고 mouse이벤트 발생하지 않도록함
				nameCtn++;
			}
		});
		
		/*if(sprintName.getText().equals("")) {
			sprintName.setText("새 스프린트 이름");
		}*/

		//시작일
		JLabel start = new JLabel("시작일");
		start.setLocation(30, 115);
		start.setSize(50, 40);
		start.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		newSprintPopUp.add(start);

		
		//시작일
		JXDatePicker startDayPicker = new DatePicker().getDatePicker();
		
		//JTextField startDay = new JTextField("스프린트 시작일", 15);
		startDayPicker.setLocation(80, 115);
		startDayPicker.setSize(120, 40);
		///startDayPicker.setFont(new Font("맑은 고딕", Font., 15));
		newSprintPopUp.add(startDayPicker);	
		
		/*startDayPicker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(startDayCtn == 0) {
					startDayPicker.setText("");
				}
			}
		});*/
		
		/*tartDayPicker.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				startDayCtn++;
			}
		});*/
		
		
		//~
		JLabel fromTo = new JLabel("~");
		fromTo.setLocation(240, 115);
		fromTo.setSize(50, 40);
		fromTo.setFont(new Font("",Font.BOLD, 30));
		newSprintPopUp.add(fromTo);
		
		//종료일
		JLabel end = new JLabel("종료일");
		end.setLocation(310, 115);
		end.setSize(50, 40);
		end.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		newSprintPopUp.add(end);


		
		//종료일
		JXDatePicker endDayPicker = new DatePicker().getDatePicker();
		
		//JTextField endDay = new JTextField("스프린트 종료일", 15);
		endDayPicker.setLocation(360, 115);
		endDayPicker.setSize(120, 40);
		//endDayPicker.setFont(new Font("", Font.PLAIN, 15));
		newSprintPopUp.add(endDayPicker);
		
		/*endDayPicker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(endDayCtn == 0) {
					//endDayPicker.setText("");
				}
			}
		});*/
		
		
		/*endDayPicker.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				endDayCtn++;
			}
		});*/

		
		
		//설명
		JTextArea description = new JTextArea("설명", 3, 30);
		description.setLocation(30, 175);
		description.setSize(453,135);
		//description.setFont(new Font("", Font.PLAIN, 15));
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		//int numOfLines = description.getLineCount();
		
		/*JScrollPane scrollBar = new JScrollPane(description, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setPreferredSize(new Dimension(453, 135));
		scrollBar.setLocation(20, 175);*/
		
		newSprintPopUp.add(description);
		
		
		
		description.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(descriptionCtn == 0) {
					description.setText("");
				}
			}
		});
		
		
		description.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				descriptionCtn++;
			}
		});

		

		//할일입력
		JTextField toDo = new JTextField("주요 할 일", 50);
		toDo.setLocation(30, 330);
		toDo.setSize(410, 45);
		//toDo.setFont(new Font("", Font.PLAIN, 15));
		newSprintPopUp.add(toDo);
		
		toDo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toDo.setText("");
			}
		});
		
		//할일 입력후 +버튼 클릭시 아래 textArea로 넘어가야 함
		plusButton = new JButton("+");
			
		plusButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		plusButton.setLocation(450, 330);
		plusButton.setOpaque(false);
		//plusButton.setBackground(Color.lightGray);
		plusButton.setContentAreaFilled(false);
		plusButton.setBorder(null);
		//plusButton.setBorderPainted(false);
		plusButton.setSize(30, 40);
		
		plusButton.setToolTipText("할 일 추가");
		
		newSprintPopUp.add(plusButton);
		
		

		//입력한 할일 보여주는 textArea
		//readOnly (수정불가)
		JTextArea toDoList = new JTextArea(30, 10);
		toDoList.setLocation(30, 390);
		toDoList.setSize(455, 200);
		toDoList.setFont(new Font("", Font.PLAIN, 15));
		toDoList.setEditable(false);
		toDoList.setAutoscrolls(true);
		
		newSprintPopUp.add(toDoList);
		
		//+버튼 입력시 아래 할일 창에 내용 추가됨
		plusButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = toDo.getText();

				toDoList.append(text + "\n");
				toDo.setText("");
				toDo.requestFocus();

			}
		});
		
		//할일 입력후 엔터눌러도 아래 할일 창에 내용 추가됨
		toDo.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {

				if(e.getKeyChar() == '\n') {
					toDoList.append(toDo.getText() + "\n");
					toDo.setText("");
				}
			}

		});

		//스프린트 생성 취소버튼
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setLocation(275,610);
		cancelBtn.setSize(90,40);
		newSprintPopUp.add(cancelBtn);
		
		//취소버튼 클릭시 스프린트 생성 팝업창 닫힘
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newSprintPopUp.dispose();
				
			}
		});
		
		//스프린트생성 확인버튼
		JButton okBtn = new JButton("확인");
		okBtn.setLocation(385,610);
		okBtn.setSize(90,40);
		newSprintPopUp.add(okBtn);
		
		
		
		//확인버튼 클릭시 이벤트 연결
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sprintTitle = sprintName.getText();
				sprintStartDay = startDayPicker.getDate();
				sprintEndDay = endDayPicker.getDate();
				sprintDetail = description.getText();
				sprintToDo = toDoList.getText();
				
				
				sprintPanel.addSprintOnList(sprintTitle, sprintStartDay, sprintEndDay, sprintDetail, sprintToDo);
				
				newSprintPopUp.dispose();
			}
		});
		
		
		sprintName.requestFocus();
		
		
	}
	
	
	
	public Dialog getNewSprintPopUp() {
		return newSprintPopUp;
	}
	
	public static void setUIFont (javax.swing.plaf.FontUIResource f){
	    java.util.Enumeration keys = UIManager.getDefaults().keys();
	    while (keys.hasMoreElements()) {
	      Object key = keys.nextElement();
	      Object value = UIManager.get (key);
	      if (value instanceof javax.swing.plaf.FontUIResource)
	        UIManager.put (key, f);
	      }
	 } 
	
	
}
