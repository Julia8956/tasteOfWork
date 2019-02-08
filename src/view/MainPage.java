package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPage extends JPanel {
	private MainFrame mf;
	private SubFrame sf;
	private JButton sprintAdd;
	private Dialog MainPage;
	private JPanel project;
	private JPanel sprintPanel;
	private JFrame proframe;
	public MainPage() {
	
		
		this.setSize(1024,768);
		
		JLabel upup  = new JLabel("");
		upup.setOpaque(true);
		upup.setBackground(Color.GRAY);
		upup.setSize(1024, 50);
		upup.setLocation(0,0);
		this.add(upup);
		
		JButton pro = new JButton("새 프로젝트 추가");
		pro.setSize(150,50);
		pro.setLocation(10,150);
		//pro.addMouseListener(new MyMouseAdapter1());;
		pro.addActionListener(new ProEvent());
		
		Image homeim = new ImageIcon("images/home.PNG")
				.getImage().getScaledInstance(30, 33, 0);
		
		Image findim = new ImageIcon("images/findimage.PNG")
				.getImage().getScaledInstance(36, 33,0);
		
		Image personim =new ImageIcon("images/person.PNG")
				.getImage().getScaledInstance(35, 33, 0);

		
		JButton home = new JButton(new ImageIcon(homeim));
		home.setSize(30,33);
		home.setLocation(10,10);
		
		JButton find = new JButton(new ImageIcon(findim));
		find.setSize(36,33);
		find.setLocation(50,10);
		
		JButton person = new JButton(new ImageIcon(personim));
		person.setSize(35,33);
		person.setLocation(960,10);
		
		
		
		JTextField tf1 = new JTextField(10);
		tf1.setLocation(85, 10);
		tf1.setSize(150, 30);
		
		
		upup.add(person);
		upup.add(find);
		upup.add(home);
		upup.add(tf1);
		
		
		
		
		
		
		
		this.add(pro);
	
		
		
		
		
		
		
		
		
		
		
		//프로젝트 추가 시작
		JFrame proframe = new JFrame();
		proframe.setSize(515,560);
		proframe.setLocation(100, 200);
		
		
		//project.setLayout(null);
		
		JLabel label = new JLabel("프로젝트 추가");
	      label.setFont(new Font("",Font.BOLD, 30));
	      label.setLocation(10,-10);            
	      label.setSize(200,100);
	      proframe.add(label);
	      
	      JTextField proName = new JTextField("프로젝트명",20);
	      proName.setLocation(10,65);
	      proName.setSize(485,40);
	      proframe.add(proName);

	      JTextField startProject = new JTextField("시작날짜");
	      startProject.setLocation(10,115);
	      startProject.setSize(150,40);
	      proframe.add(startProject);   

	      JLabel middle = new JLabel("~");
	      middle.setLocation(250,115);
	      middle.setSize(300,40);
	      middle.setFont(new Font("",Font.PLAIN, 15));
	      proframe.add(middle);

	      JTextField endProject = new JTextField("종료날짜");
	      endProject.setLocation(345,115);
	      endProject.setSize(150,40);
	      proframe.add(endProject);
		
	    
	     JPanel sprintPanel = new JPanel();
	      sprintPanel.setLayout(null);


	      JLabel sprintLabel = new JLabel("스프린트 추가");
	      sprintLabel.setLocation(15,140);
	      sprintLabel.setSize(400, 100);
	      sprintLabel.setFont(new Font("",Font.BOLD, 20));

	      sprintPanel.add(sprintLabel);



	      //스프린트 추가 버튼
	     JButton sprintAdd =new JButton();
	      sprintAdd = new JButton("+");
	      sprintAdd.setFont(new Font("",Font.PLAIN, 20));
	      sprintAdd.setLocation(145,175);
	      //sprintAdd.setBackground(Color.WHITE);
	      sprintAdd.setBorder(null);
	      sprintAdd.setSize(20,35);
	      sprintAdd .setOpaque(false);
	      sprintAdd .setBackground(Color.lightGray);
	      
	      //스프린트 버튼 클릭시 스프린트 창 나오기
	      //sprintAdd.addActionListener();
	      
	     // sprintPanel.add(sprintAdd);
	      proframe.add(sprintAdd);
	      sprintAdd.addMouseListener(new MyMouseAdapter());
	     
	      

	      
	      String col[] = { "스프린트 명", "스프린트 날짜" };   

	      String values[][] = { { "자바킹킹","12-05-01"  }, 
	            {"자바킹", "12-05-02" },
	            { "자바", "12-05-12" } };

	      JTable sprintTable = new JTable(values,col); 
	      


	   
	      JScrollPane pane = new JScrollPane(sprintTable);   
	      pane.setLocation(10,225);
	      pane.setSize(480,100);
	      
	      sprintPanel.add(pane);




	      //초대

	      JLabel invite = new JLabel("초대");
	      invite.setFont(new Font("",Font.BOLD, 20));
	      invite.setLocation(15,300);
	      invite.setSize(400,100);


	      sprintPanel.add(invite);


	      JButton  personAdd = new JButton("+");
	      personAdd.setFont(new Font("",Font.PLAIN, 20));
	      personAdd.setLocation(60,335);
	      personAdd.setBackground(Color.WHITE);
	      personAdd.setBorder(null);
	      personAdd.setSize(20,35);
	      personAdd .setOpaque(false);
	      personAdd .setBackground(Color.lightGray);
	      sprintPanel.add(personAdd);
	      


	      JTextArea people = new JTextArea("우리나(woolina)");
	      //people.setHorizontalAlignment(JTextField.CENTER);
	      people.setLocation(10,365);
	      people.setSize(480,90);

	      sprintPanel.add(people);

	      JButton cancelBtn = new JButton("취소");
	      cancelBtn.setLocation(282,465);
	      cancelBtn.setSize(100,40);
	      sprintPanel.add(cancelBtn);
	      //cancelBtn.addActionListener(this);
	      //취소버튼 클릭시 프로젝트 생성 팝업창 닫힘
	      /*cancelBtn.addActionListener(new ActionListener() {
	               
	               @Override
	               public void actionPerformed(ActionEvent e) {
	                  AddProject.dispose();
	                  
	               }
	            });*/
	      JButton okBtn = new JButton("확인");
	      okBtn.setLocation(392,465);
	      okBtn.setSize(100,40);
	      sprintPanel.add(okBtn);
	      
	     

	      proframe.add(sprintPanel);

	      
	     
	     
	     
		
		/*proframe.setVisible(true);
		proframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
		
		
		
		
	}
	
	class MyMouseAdapter extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			AddSprint as = new AddSprint(sf);
			ChangePanel1.changePanel1(sf, sprintPanel, as.addSprint);
		}
	}
	
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sprintAdd) {
	         //JFrame sprint = new JFrame();
	         (new AddSprint()).getAddSprint().setVisible(true);
	         //new AddSprint(sprint);
	         if(e.getSource() == cancelBtn) {
	            mf.dispose();
	         }
	      }
*/

	class ProEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame mf = new JFrame();
			new AddProject(mf);
		}
		
		
	}

	


	