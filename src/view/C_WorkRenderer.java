package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import model.Work;

public class C_WorkRenderer extends JPanel implements ListCellRenderer<Work>{
	private JLabel work_Title = new JLabel();
	private JLabel Ass_Label = new JLabel();
	private JLabel emergy = new JLabel();
	private JPanel panelText;
	private JPanel emergyIcon;
	
	public C_WorkRenderer() {
		this.setLayout(new BorderLayout(3,5));
		
		panelText = new JPanel(new GridLayout(1,0));
		panelText.add(work_Title);
		panelText.add(Ass_Label);
		
		emergyIcon = new JPanel();
		//emergyIcon.setBorder(new EmptyBorder(5, 5, 5, 5));
		emergyIcon.setPreferredSize(new Dimension(50,50));
		//emergy.setSize(50, 50);
		emergyIcon.add(emergy);

		add(panelText, BorderLayout.CENTER);
		add(emergyIcon, BorderLayout.EAST);
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Work> list, Work work, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		work_Title.setText(work.getWork_name());
		work_Title.setFont(new Font("Serif",Font.BOLD,20));
		Ass_Label.setText(work.getAllocator()[0]);
		Ass_Label.setFont(new Font("Serif",Font.BOLD,20));
		
		if (work.isEmergy() == true) {
			//emergy.setIcon(new ImageIcon("/image/sos.PNG"));
			emergy.setIcon(new ImageIcon("images/work_sos.JPG"));
		}else {
			//emergy.setText("긴급X");
			emergy.setIcon(null);
		}
		
		//JLabel의 배경색을 변경하는 불투명도 설정
		work_Title.setOpaque(true);
		Ass_Label.setOpaque(true);
		emergy.setOpaque(true);
		// when select item
		if (isSelected) {
			work_Title.setBackground(list.getSelectionBackground());
			Ass_Label.setBackground(list.getSelectionBackground());
			emergy.setBackground(list.getSelectionBackground());
			panelText.setBackground(list.getSelectionBackground());
			emergyIcon.setBackground(list.getSelectionBackground());
		} else { // when don't select
			work_Title.setBackground(list.getBackground());
			Ass_Label.setBackground(list.getBackground());
			emergy.setBackground(list.getBackground());
			panelText.setBackground(list.getBackground());
			emergyIcon.setBackground(list.getBackground());
			
		}
		
		return this;
		
	}
	

}
