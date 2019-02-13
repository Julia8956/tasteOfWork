package model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import view.C_SprintMainPage;

public class Sprint {

	private String sprintTitle;
	private Date sprintStartDay;
	private Date sprintEndDay;
	
	public Sprint(String sprintTitle, Date sprintStartDay, Date sprintEndDay) {
		super();
		this.sprintTitle = sprintTitle;
		this.sprintStartDay = sprintStartDay;
		this.sprintEndDay = sprintEndDay;
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
