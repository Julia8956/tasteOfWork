package model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import view.C_SprintMainPage;

public class Sprint {

	private String sprintTitle;
	private Date sprintStartDay;
	private Date sprintEndDay;
	private Project selectedProject;
	
	public Sprint(Project selectedProject, String sprintTitle, Date sprintStartDay, Date sprintEndDay) {
		super();
		this.selectedProject = selectedProject;
		this.sprintTitle = sprintTitle;
		this.sprintStartDay = sprintStartDay;
		this.sprintEndDay = sprintEndDay;
	}
	
	
	public Project getSelectedProject() {
		return selectedProject;
	}
	
	public String getSprintTitle() {
		return sprintTitle;
	}




	public Date getSprintStartDay() {
		return sprintStartDay;
	}




	public Date getSprintEndDay() {
		return sprintEndDay;
	}




	public void setSprintTitle(String sprintTitle) {
		this.sprintTitle = sprintTitle;
	}




	public void setSprintStartDay(Date sprintStartDay) {
		this.sprintStartDay = sprintStartDay;
	}




	public void setSprintEndDay(Date sprintEndDay) {
		this.sprintEndDay = sprintEndDay;
	}




	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sprintTitle + " " + sdf.format(sprintStartDay) + " ~ " + sdf.format(sprintEndDay);
	}




	
	
}
