package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class B_SprintPanel extends JPanel implements ActionListener {


	private MainFrame mainFrame;
	private B_SprintPanel sprintPanel;
	private JButton newSprintButton;
	
	public B_SprintPanel(B_ProjectPage projectPage, MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		//this.setSize(350, 688);
		//this.setPreferredSize(new Dimension(350, 688));
		//this.setLocation(0, 80);
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		
		//전체 폰트 스타일 적용
		setUIFont (new javax.swing.plaf.FontUIResource("맑은 고딕", Font.PLAIN, 15));
		
		
		//스프린트생성버튼, 스프린트 리스트 패널
		JPanel sprintPanel = new JPanel();
		sprintPanel.setBackground(Color.WHITE);
		//sprintPanel.setBackground(new Color(0.1f, 0.5f, 1f, 0.8f));
		
		sprintPanel.setLayout(new BorderLayout());
		
		JPanel newSprintPanel = new JPanel();
		newSprintPanel.setBackground(Color.WHITE);
		newSprintPanel.setBackground(new Color(0.1f, 0.5f, 1f, 0.5f));
		newSprintPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		//스프린트 생성 버튼 (클릭시 팝업 떠야함)
		newSprintButton = new JButton();
		newSprintButton.setText("새 스프린트 추가  +");
		newSprintButton.setSize(150, 50);
		//addSprint.setLocation(200, 80);
		
		
		//스프린트 생성 버튼에 이벤트 연결
		newSprintButton.addActionListener(this);
		
		newSprintPanel.add(newSprintButton, "North");

		sprintPanel.add(newSprintPanel, "North");
		
		
		//생성된 스프린트 리스트 (선택해서 스프린트 페이지로 넘어가도록 만들어야 함)
		//임시로 Sprint리스트 만들어 놓음
		String[] sprintExample = {"Sprint 1", "Sprint 2", "Sprint 3", "Sprint 4", "Sprint 5", "Sprint 6", "Sprint 7",
				"Sprint8", "Sprint9", "Sprint10", "Sprint11", "Sprint12", "Sprint13", "Sprint14", "Sprint15", "Sprint16",
				"Sprint17"};
		//스프린트 리스트 올릴 리스트
		JList sprintList = new JList(sprintExample);
		//sprintList.setFont(new Font("", Font.HANGING_BASELINE, 20));
		
		sprintList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		//스크롤러에 리스트 올리기
		JScrollPane scroller = new JScrollPane(sprintList);
		//scroller.setPreferredSize(new Dimension(350, 1000));
		//scroller.setLocation(0, 0);
		sprintList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sprintPanel.add(scroller, "Center");
		
		
		this.add(sprintPanel, "Center");
		
		
		
		projectPage.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == newSprintButton) {
			new B_NewSprintPopUp(this.mainFrame).getNewSprintPopUp().setVisible(true);;
		}
	}
	
	//전체 폰트적용 메소드
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
