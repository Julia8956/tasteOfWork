package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class C_SprintMainPage extends JPanel{
	private MainFrame mf;
	private C_SprintMainPage sprintPage;
	
	public C_SprintMainPage(MainFrame mf) {
		this.mf = mf;
		this.sprintPage = sprintPage;
		
		this.setSize(1024,768);
		//this.setBackground(Color.WHITE);
		GridBagLayout gridBag = new GridBagLayout();
		this.setLayout(gridBag);
		GridBagConstraints gc = new GridBagConstraints();
		
		//메뉴바 == 상단바
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 0.0;
		gc.weighty = 0.1;
		gc.gridwidth= GridBagConstraints.REMAINDER;
		gc.gridheight = 1;
		gridBag.setConstraints(new C_MenuBarPanel(this, this.mf), gc);
	
		
		//OPEN패널
		gc.weightx = 0.1;
		gc.weighty = 0.9;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gridBag.setConstraints(new C_OpenPanel(this, this.mf), gc);
		
		//IN Progress 패널
		gc.weightx = 0.1;
		gc.weighty = 0.9;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gridBag.setConstraints(new C_ProgressPanel(this, this.mf), gc);
		
		//Done 패널
		gc.weightx = 0.1;
		gc.weighty = 0.9;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.gridwidth = 1;
		gridBag.setConstraints(new C_DonePanel(this,mf), gc);
		
		this.setVisible(true);
		
		mf.add(this);
		
	}
}
