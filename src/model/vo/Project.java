package model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Project {
	protected String projectTitle;
	protected Date projectStartDay;
	protected Date projectEndDay;
	protected String projectPeople;
	

	public Project() {}
	
	

	public Project(String projectTitle, Date projectStartDay, Date projectEndDay, String projectPeople) {
		super();
		this.projectTitle = projectTitle;
		this.projectStartDay = projectStartDay;
		this.projectEndDay = projectEndDay;
		this.projectPeople = projectPeople;
	}



	public String getProjectTitle() {
		return projectTitle;
	}




	public Date getProjectStartDay() {
		return projectStartDay;
	}




	public String getProjectPeople() {
		return projectPeople;
	}




	public void setProjectPeople(String projectPeople) {
		this.projectPeople = projectPeople;
	}




	public Date getProjectEndDay() {
		return projectEndDay;
	}




	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}




	public void setProjectStartDay(Date projectStartDay) {
		this.projectStartDay = projectStartDay;
	}




	public void setProjectEndDay(Date projectEndDay) {
		this.projectEndDay = projectEndDay;
	}




	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return projectTitle + "\n " + sdf.format(projectStartDay) + " ~ " + sdf.format(projectEndDay) /*+ projectPeople*/;
	}




}
