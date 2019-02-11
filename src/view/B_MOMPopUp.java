package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class B_MOMPopUp extends JPanel{

	private MainFrame mainFrame;
	private JButton plusButton;
	private Dialog Mompopup;
	private int nameCtn = 0;
	private int descriptionCtn = 0;

	public B_MOMPopUp(MainFrame mainFrame) {

		Mompopup = new Dialog(mainFrame, "새 회의록");
		Mompopup.setBounds(150, 150, 515, 620);

		Mompopup.setLayout(null);

		// 이름
		JTextField momName = new JTextField("회의명", 30);
		momName.setFont(new Font("", Font.BOLD, 15));
		momName.setLocation(20, 50);
		momName.setSize(450, 45);
		Mompopup.add(momName);

		// textField에 마우스 클릭시 내용지워지고 빈화면으로 바뀜
		momName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 아무것도 입력되지 않은 상태에서만 빈칸으로 만들기
				if (nameCtn == 0) {
					momName.setText("");
				}
			}
		});

		momName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// 키보드 입력 발생시 ctn++해주고 mouse이벤트 발생하지 않도록함
				nameCtn++;
			}
		});

		/*
		 * if(momName.getText().equals("")) { momName.setText("새 스프린트 이름"); }
		 */

		// 회의 날짜
		JTextField Day = new JTextField("회의 날짜", 15);
		Day.setLocation(20, 115);
		Day.setSize(140, 40);
		Mompopup.add(Day);

		JLabel attend = new JLabel("참석자");
		attend.setLocation(40, 175);
		attend.setSize(100, 45);
		attend.setFont(new Font("", Font.BOLD, 20));
		Mompopup.add(attend);

		// 참석자 이름
		JTextField name = new JTextField("참석자이름 추가",50);
		name.setLocation(130, 175);
		name.setSize(300, 45);
		Mompopup.add(name);

		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});

		// 참석자 입력후 +버튼 클릭시 아래 textArea로 넘어가야 함
		plusButton = new JButton("+");

		plusButton.setFont(new Font("", Font.PLAIN, 20));
		plusButton.setLocation(440, 175);
		plusButton.setOpaque(false);
		plusButton.setBackground(Color.lightGray);
		plusButton.setBorder(null);
		plusButton.setSize(30, 40);

		Mompopup.add(plusButton);

		// 입력한 참석자 보여주는 textArea
		// readOnly (수정불가)
		JTextArea person = new JTextArea(30, 10);
		person.setLocation(130, 230); 
		person.setSize(350, 50);
		person.setEditable(false);

		Mompopup.add(person);

		plusButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = name.getText();

				person.append(text + "  ");
				name.setText("");
				name.requestFocus();

			}
		});

		//내용 라벨
		JLabel text = new JLabel("내용");
		text.setLocation(40, 300);
		text.setSize(100, 45);
		text.setFont(new Font("", Font.BOLD, 20));
		Mompopup.add(text);
		
		// 내용 작성 칸
		JTextArea description = new JTextArea("내용 작성", 3, 30);
		description.setLocation(130, 300);
		description.setSize(350, 220);
		Mompopup.add(description);

		description.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (descriptionCtn == 0) {
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

		
		// 취소버튼
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setLocation(275, 550);
		cancelBtn.setSize(90, 40);
		Mompopup.add(cancelBtn);

		// 취소버튼 클릭시 스프린트 생성 팝업창 닫힘
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Mompopup.dispose();

			}
		});

		//  확인버튼
		JButton okBtn = new JButton("확인");
		okBtn.setLocation(385, 550);
		okBtn.setSize(90, 40);
		Mompopup.add(okBtn);
		// 버튼에 이벤트 연결
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 확인버튼 클릭시 팝업창 닫히고
				Mompopup.dispose();
				// 스프린트 목록에 스프린트 이름 추가되고, 세부 스프린트 페이지 생성되어야함
				// 세부 스프린트 페이지는 리스트에 생성된 스프린트 이름 클릭시 창 넘어가야 함
			}
		});
		
		Mompopup.setUndecorated(true);

	}
	
	

	public Dialog getMomPopup() {
		return Mompopup;
	}

	// private MainFrame mf;
	// private JPanel mainPage;
	//
	// public Mompopup() {
	// JFrame frame = new JFrame("회의목록 작성"); // 프레임 타이틀지정
	// JPanel panel = new JPanel();
	//
	// // Table Parameters
	// String col[] = { "스프린트 이름", "스프린트 날짜" }; // 필드명(열제목) 지정
	//
	// Object values[][] = { { "자바킹", "12-05-01" }, // 레코드값!
	// { "자바킹", "12-05-02" },
	//
	// { "12-05-15", "자바킹" } };
	//
	// JTable table = new JTable(values, col); // 생성자 : public JTable(Object[][]
	// rowData, Object[] columnNames)
	//
	// // Table Container Parameters
	// JScrollPane pane = new JScrollPane(table); // 테이블에 스크롤바 나오도록 Jscrollpane생성
	// panel.add(pane); // JPanel 에 JScrollPane 추가
	// frame.add(panel); // Jframe 에 JPanel추가
	//
	// frame.pack(); // 내용에 맞게 프레임크기 맞춤
	// frame.setVisible(true); // 프레이보이게
	// }
	
	
}
