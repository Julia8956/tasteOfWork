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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;





public class A_AddProject extends JPanel implements ActionListener{

   private MainFrame mf;           //AddProject객체를 필드에다가 만들어놓음   //mf를 또 쓰려고 필드에 만들어줌.
   private A_MainPage mainPage;
   private Dialog addProject;
   private JButton sprintAdd;
   private JButton cancelBtn;
   private JTextArea people;
   private int nameCtn = 0;
   private int  startDayCtn = 0;
   private int endDayCtn = 0;
   //메인프레임을 전달받음
   public A_AddProject(MainFrame mf, A_MainPage mainPage) {   //메인프레임클래스에서 MainFrame을 보냈기 때문에 가능가능

      this.mf = mf;               //전달받은 MainFrame도 필드에다가 만듦
      this.mainPage = mainPage;
      addProject = new Dialog(mf, "새 프로젝트 만들기");       //여기서 this는 AddProject의 객체이다. 

      
      addProject.setSize(515, 560);

      // 팝업위치 조정(화면 가운데)
      addProject.setSize(515, 620);
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension dim = tk.getScreenSize();
      int xPos = (dim.width / 2) - (addProject.getWidth() / 2);
      int yPos = (dim.height / 2) - (addProject.getHeight() / 2);
      addProject.setLocation(xPos, yPos);

      addProject.setUndecorated(true);

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
      
      
      
    //textField에 마우스 클릭시 내용지워지고 빈화면으로 바뀜
      proName.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 
            //아무것도 입력되지 않은 상태에서만 빈칸으로 만들기
            if (nameCtn == 0) {
               proName.setText("");
            }
         }
      });
    //시작일
          JLabel start = new JLabel("시작일");
          start.setLocation(20, 135);
          start.setSize(50, 40);
          start.setFont(new Font("", Font.BOLD, 15));
          addProject.add(start);
  
          JXDatePicker startDay = new DatePicker().getDatePicker();
          startDay.setLocation(70, 135);
          startDay.setSize(120, 40);
          startDay.setFont(new Font("", Font.PLAIN, 15));
          addProject.add(startDay);   

          

    startDay.addKeyListener(new KeyAdapter() {
       @Override
       public void keyPressed(KeyEvent e) {
          startDayCtn++;
       }
    });

      JLabel middle = new JLabel("~");
      middle.setLocation(250,135);
      middle.setSize(300,40);
      middle.setFont(new Font("",Font.PLAIN, 15));
      addProject.add(middle);

      //종료일
      JLabel end = new JLabel("종료일");
      end.setLocation(310, 135);
      end.setSize(50, 40);
      end.setFont(new Font("", Font.BOLD, 15));
      addProject.add(end);
       end.addKeyListener(new KeyAdapter() {
             @Override
             public void keyPressed(KeyEvent e) {
                endDayCtn++;
             }
          });




   JXDatePicker endDayPicker = new DatePicker().getDatePicker();
   

   endDayPicker.setLocation(360, 135);
   endDayPicker.setSize(120, 40);
   endDayPicker.setFont(new Font("", Font.PLAIN, 15));
   addProject.add(endDayPicker);

      
      
      
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
      personAdd.addActionListener(new Add_person()); 
      
          
          

      people = new JTextArea("우리나(woolina)");
      //people.setHorizontalAlignment(JTextField.CENTER);
      people.setLocation(10,385);
      people.setSize(480,90);

      sprintPanel.add(people);
      
      
      //취소버튼
      JButton cancelBtn  = new JButton(new ImageIcon("images/cancelbtn1.png"));
      ImageIcon cancelbtn2 = new ImageIcon("images/cancelbtn2.png");
      cancelBtn.setBorderPainted(false); 
      cancelBtn.setFocusPainted(false); 
      cancelBtn.setContentAreaFilled(false);
      cancelBtn.setRolloverIcon(cancelbtn2);
  
      cancelBtn.setLocation(282,495);
      cancelBtn.setSize(100,40);
      sprintPanel.add(cancelBtn);


      //취소 버튼 클릭시 프로젝트 생성 팝업창 닫힘
      cancelBtn.addActionListener(new ActionListener() {
               
               @Override
               public void actionPerformed(ActionEvent e) {
                  addProject.dispose();
                  
               }
            });
      
  
      
      
      
      //확인버튼
      JButton okBtn = new JButton(new ImageIcon("images/okbtn1.png"));
      ImageIcon okbtn2 = new ImageIcon("images/okbtn2.png");
      okBtn.setBorderPainted(false); 
      okBtn.setFocusPainted(false); 
      okBtn.setContentAreaFilled(false);
      okBtn.setRolloverIcon(okbtn2);
      okBtn.setLocation(392,495);
      okBtn.setSize(100,40);
      sprintPanel.add(okBtn);
      ///okBtn.addActionListener(this);
      //확인 버튼 클릭시 프로젝트 생성 팝업창 닫힘
      okBtn.addActionListener(new ActionListener() {
               
               @Override
               public void actionPerformed(ActionEvent e) {
                  mainPage.makebtn();
                  addProject.dispose();
                  
                  
               }
            });
      addProject.add(sprintPanel);
      addProject.setResizable(false); 
      addProject.setVisible(true);
   
   }
  


 


   @Override
   public void actionPerformed(ActionEvent e) {
      
      if(e.getSource() == sprintAdd) {
         new A_AddSprint(mf).getAddSprint().setVisible(true);
      }
   }

   private class Add_person implements ActionListener{

         @Override
         public void actionPerformed(ActionEvent e) {
            String id;
            id = JOptionPane.showInputDialog("초대 아이디를 입력하세요.");
            System.out.println(id);
            people.append("\n" + id);
            
            
         }
         
      }
   public Dialog getAddProject() {
      return addProject;
   }


}




