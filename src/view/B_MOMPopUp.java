package view;

import java.awt.Color;
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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

public class B_MOMPopUp extends JPanel {

	private MainFrame mainFrame;
	private JButton plusButton;
	private Dialog Mompopup;
	private int nameCtn = 0;
	private int descriptionCtn = 0;

	public B_MOMPopUp(MainFrame mainFrame) {

		Mompopup = new Dialog(mainFrame, "새 회의록");
		Mompopup.setLayout(null);

		// 팝업위치 조정(화면 가운데)
		Mompopup.setSize(515, 620);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (Mompopup.getWidth() / 2);
		int yPos = (dim.height / 2) - (Mompopup.getHeight() / 2);
		Mompopup.setLocation(xPos, yPos);

		// 이름
		JTextField momName = new JTextField("회의명", 30);
		momName.setFont(new Font("맑은 고딕", Font.BOLD,

				15));
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


		JLabel writerLabel = new JLabel("작성자");
		writerLabel.setLocation(40, 115);
		writerLabel.setSize(100, 45);
		writerLabel.setFont(new Font("맑은 고딕", Font.BOLD,20));
		Mompopup.add(writerLabel);

		JTextField writer = new JTextField(50);
		writer.setLocation(130, 120);
		writer.setSize(120, 40);
		Mompopup.add(writer);

		// 회의 날짜
		JLabel DayLabel = new JLabel("날짜");
		DayLabel.setLocation(280, 115);
		DayLabel.setSize(140, 40);
		DayLabel.setFont(new Font("맑은 고딕", Font.BOLD,20));
		Mompopup.add(DayLabel);
		//달력
		JXDatePicker Day = new DatePicker().getDatePicker();
		Day.setLocation(330, 120);
		Day.setSize(140, 40);
		Day.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Mompopup.add(Day);

		
		JLabel attend = new JLabel("참석자");
		attend.setLocation(40, 175);
		attend.setSize(100, 45);
		attend.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Mompopup.add(attend);

		// 참석자 Text필드
		JTextField name = new JTextField("참석자이름 추가", 50);
		name.setLocation(130, 185);
		name.setSize(300, 30);
		Mompopup.add(name);

		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});

		// 참석자 입력후 +버튼 클릭시 아래 textArea로 넘어가야 함
		plusButton = new JButton("+");

		plusButton.setFont(new Font("맑은 고딕", Font.PLAIN,

				20));
		plusButton.setLocation(440, 175);
		plusButton.setOpaque(false);
		plusButton.setContentAreaFilled(false);
		plusButton.setBackground(Color.lightGray);
		plusButton.setBorder(null);
		plusButton.setSize(30, 40);
		plusButton.setToolTipText("참석자 추가");

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
			public void actionPerformed(ActionEvent e)

			{
				String text = name.getText();

				person.append(text + "  ");
				name.setText("");
				name.requestFocus();

			}
		});
		// 엔터 눌러도 추가됨
		name.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {

				if (e.getKeyChar() == '\n') {
					person.append

					(name.getText() + "  ");
					name.setText("");
				}
			}

		});

		// 내용 라벨
		JLabel text = new JLabel("내용");
		text.setLocation(40, 300);
		text.setSize(100, 45);
		text.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Mompopup.add(text);

		// 내용 작성 칸
		JTextArea description = new JTextArea("내용 작성", 3,

				30);
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

		// 취소버튼 클릭시 팝업창 닫힘
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)

			{
				Mompopup.dispose();

			}
		});

		// 확인버튼
		JButton okBtn = new JButton("확인");
		okBtn.setLocation(385, 550);
		okBtn.setSize(90, 40);
		Mompopup.add(okBtn);
		// 버튼에 이벤트 연결
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)

			{
				Mompopup.dispose();
			}
		});

		Mompopup.setUndecorated(true);
	}

	public Dialog getMomPopup() {
		return Mompopup;
	}

}
