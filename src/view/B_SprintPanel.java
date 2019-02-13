package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import model.vo.Project;
import model.vo.Sprint;

public class B_SprintPanel extends JPanel implements ActionListener {


	private MainFrame mainFrame;
	private B_ProjectPage projectPage;
	private B_SprintPanel sprintPanel;
	private JButton newSprintButton;
	private String[] sprintInfo;
	private DefaultListModel sprintModel;
	private JList sprintJList;
	private ArrayList<Sprint> sprintArrList = new ArrayList<Sprint>();
	
	private Project selectedProject;
	
	public B_SprintPanel(B_ProjectPage projectPage, MainFrame mainFrame, Project selectedProject) {
		
		this.mainFrame = mainFrame;
		this.projectPage = projectPage;
		this.sprintPanel = this;
		
		this.selectedProject = selectedProject;
		
		//this.setSize(350, 688);
		//this.setPreferredSize(new Dimension(350, 688));
		//this.setLocation(0, 80);
		//this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		
		//전체 폰트 스타일 적용
		setUIFont (new javax.swing.plaf.FontUIResource("맑은 고딕", Font.PLAIN, 15));
		
		
		//스프린트생성버튼, 스프린트 리스트 패널
		JPanel sprintPanel = new JPanel();
		//sprintPanel.setBackground(Color.WHITE);
		sprintPanel.setBackground(B_ProjectPage.BG_COLOR);
		
		sprintPanel.setLayout(new BorderLayout());
		
		JPanel newSprintPanel = new JPanel();
		//newSprintPanel.setBackground(Color.WHITE);
		newSprintPanel.setBackground(B_ProjectPage.BG_COLOR);
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
		sprintModel =  new DefaultListModel();
		//스프린트 리스트 올릴 리스트
		sprintJList = new JList(sprintModel);
		sprintJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sprintJList.setToolTipText("더블클릭시 해당 스프린트로 이동");
		
		//스프린트리스트에 이벤트 연결
		sprintJList.addMouseListener(new MouseAdapter() {
			
					
			@Override
			public void mouseClicked(MouseEvent e) {

				if(e.getClickCount() == 2) {
					Sprint selectedSprint = (Sprint)sprintJList.getSelectedValue();
					projectPage.goToSprintPage(selectedSprint);
					
				}
			}
		});
		
		
		/*sprintJList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//선택된 스프린트 저장 -> 불러올때 써야함
			}
		});*/
		
		
		sprintJList.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		//스크롤러에 리스트 올리기
		JScrollPane scroller = new JScrollPane(sprintJList);
		//scroller.setPreferredSize(new Dimension(350, 1000));
		//scroller.setLocation(0, 0);
		sprintPanel.add(scroller, "Center");
		
		
		
		
		
		
		
		this.add(sprintPanel, "Center");
		
		
		
		projectPage.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == newSprintButton) {
			new B_NewSprintPopUp(mainFrame, sprintPanel).getNewSprintPopUp().setVisible(true);;
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

	//팝업에서 확인버튼 누르면 실행할 메소드
	public void addSprintOnList(String sprintTitle, Date sprintStartDay, Date sprintEndDay) {
		//받아온 스프린트명, 시작일, 종료일로 Sprint객체 생성해서 arrayList에 올리기
		
		Sprint newSprint = new Sprint(selectedProject, sprintTitle, sprintStartDay, sprintEndDay);
		sprintArrList.add(newSprint);
		sprintModel.addElement(newSprint);
		sprintPanel.revalidate();
		
	}


	
	
	
	
	
	
	
}
