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
	private JButton sprintAdd;
	private JPanel project;
	private JPanel sprintPanel;
	private JFrame proframe;
	
	public MainPage(MainFrame mf) {
	
		
		
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
		
		
		
		JTextField findt = new JTextField(10);
		findt.setLocation(85, 10);
		findt.setSize(150, 30);
		
		
		upup.add(person);
		upup.add(find);
		upup.add(home);
		upup.add(findt);
		
		
		
		
		
		
		
		this.add(pro);
	
		
		
		
		
		
		
		
		
		
	
		
	}
	
	
	
	class ProEvent implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//JFrame mf = new JFrame();
			new AddProject(mf).getAddProject().setVisible(true);
		}
		
		
	}
	
	
}



	


	