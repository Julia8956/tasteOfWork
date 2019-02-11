package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class AddProject extends JPanel implements ActionListener{

   private MainFrame mf;           //AddProject객체를 필드에다가 만들어놓음   //mf를 또 쓰려고 필드에 만들어줌.
   private Dialog addProject;
   private JButton sprintAdd;
   private JButton cancelBtn;

   //메인프레임을 전달받음
   public AddProject(MainFrame mf) {   //메인프레임클래스에서 MainFrame을 보냈기 때문에 가능가능

      this.mf = mf;               //전달받은 MainFrame도 필드에다가 만듦
      
      addProject = new Dialog(mf, "새 프로젝트 만들기");       //여기서 this는 AddProject의 객체이다. 

      
      addProject.setSize(515, 560);


      addProject.setLayout(null);               



      JLabel label = new JLabel("프로젝트 추가");
      label.setFont(new Font("",Font.BOLD, 30));
      label.setLocation(10,10);            
      label.setSize(200,100);
      addProject.add(label);
      
      JTextField proName = new JTextField("프로젝트명",20);
      proName.setLocation(10,85);
      proName.setSize(485,40);
      addProject.add(proName);

      JTextField startProject = new JTextField("시작날짜");
      startProject.setLocation(10,135);
      startProject.setSize(150,40);
      addProject.add(startProject);   

      JLabel middle = new JLabel("~");
      middle.setLocation(250,135);
      middle.setSize(300,40);
      middle.setFont(new Font("",Font.PLAIN, 15));
      addProject.add(middle);

      JTextField endProject = new JTextField("종료날짜");
      endProject.setLocation(345,135);
      endProject.setSize(150,40);
      addProject.add(endProject);

      
      
      
      //두번째 패널
      JPanel sprintPanel = new JPanel();
      sprintPanel.setLayout(null);
      sprintPanel.setSize(515,560);


      JLabel sprintLabel = new JLabel("스프린트 추가");
      sprintLabel.setLocation(15,160);
      sprintLabel.setSize(400, 100);
      sprintLabel.setFont(new Font("",Font.BOLD, 20));

      sprintPanel.add(sprintLabel);



      //스프린트 추가 버튼
      sprintAdd = new JButton("+");
      sprintAdd.setFont(new Font("",Font.PLAIN, 20));
      sprintAdd.setLocation(145,195);
      //sprintAdd.setBackground(Color.WHITE);
      sprintAdd.setBorder(null);
      sprintAdd.setSize(20,35);
      sprintAdd .setOpaque(false);
      sprintAdd .setBackground(Color.lightGray);

      //스프린트 버튼 클릭시 스프린트 창 나오기
      sprintAdd.addActionListener(this);
      sprintPanel.add(sprintAdd);
      addProject.add(sprintPanel);

      

      
      String col[] = { "스프린트 명", "스프린트 날짜" };   

      String values[][] = { { "자바킹킹","12-05-01"  }, 
            {"자바킹", "12-05-02" },
            { "자바", "12-05-12" } };

      JTable sprintTable = new JTable(values,col); 
      sprintTable.getTableHeader().setReorderingAllowed(false);

     
     // sprintTable.setEditColumn(false);
     // sprintTable.setEditingColumn(0);
      //sprintTable.setEditingRow(0);
      
      JScrollPane pane = new JScrollPane(sprintTable);   
      pane.setLocation(10,245);
      pane.setSize(480,100);
      
      sprintPanel.add(pane);




      //초대

      JLabel invite = new JLabel("초대");
      invite.setFont(new Font("",Font.BOLD, 20));
      invite.setLocation(15,320);
      invite.setSize(400,100);


      sprintPanel.add(invite);


      JButton  personAdd = new JButton("+");
      personAdd.setFont(new Font("",Font.PLAIN, 20));
      personAdd.setLocation(60,355);
      personAdd.setBackground(Color.WHITE);
      personAdd.setBorder(null);
      personAdd.setSize(20,35);
      personAdd .setOpaque(false);
      personAdd .setBackground(Color.lightGray);
      sprintPanel.add(personAdd);
      


      JTextArea people = new JTextArea("우리나(woolina)");
      //people.setHorizontalAlignment(JTextField.CENTER);
      people.setLocation(10,385);
      people.setSize(480,90);

      sprintPanel.add(people);

      JButton cancelBtn = new JButton("취소");
      cancelBtn.setLocation(282,495);
      cancelBtn.setSize(100,40);
      sprintPanel.add(cancelBtn);
      //cancelBtn.addActionListener(this);
      //취소버튼 클릭시 프로젝트 생성 팝업창 닫힘
      cancelBtn.addActionListener(new ActionListener() {
               
               @Override
               public void actionPerformed(ActionEvent e) {
            	   addProject.dispose();
                  
               }
            });
      JButton okBtn = new JButton("확인");
      okBtn.setLocation(392,495);
      okBtn.setSize(100,40);
      sprintPanel.add(okBtn);
      ///okBtn.addActionListener(this);
      //취소버튼 클릭시 프로젝트 생성 팝업창 닫힘
      okBtn.addActionListener(new ActionListener() {
               
               @Override
               public void actionPerformed(ActionEvent e) {
            	   addProject.dispose();
                  
               }
            });
      addProject.add(sprintPanel);
      addProject.setResizable(false); 
      addProject.setVisible(true);
     // mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
  


 


   @Override
   public void actionPerformed(ActionEvent e) {
	   
	   if(e.getSource() == sprintAdd) {
		   new AddSprint(mf).getAddSprint().setVisible(true);
	   }
   }


   public Dialog getAddProject() {
      return addProject;
   }


}





   
