package model.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String projectTitle;
	protected Date projectStartDay;
	protected Date projectEndDay;
	protected transient ArrayList<Sprint> sprints;
	protected String projectAdmin;
	protected ArrayList<String> memberList;
	

	public Project() {}
	
	

	public Project(String projectTitle, Date projectStartDay, Date projectEndDay, 
			ArrayList<Sprint> sprints, String projectAdmin, ArrayList<String> memberList) {
		super();
		this.projectTitle = projectTitle;
		this.projectStartDay = projectStartDay;
		this.projectEndDay = projectEndDay;
		this.sprints = sprints;
		this.projectAdmin = projectAdmin;
		this.memberList = memberList;
	}



	public String getProjectTitle() {
		return projectTitle;
	}




	public Date getProjectStartDay() {
		return projectStartDay;
	}


	public Date getProjectEndDay() {
		return projectEndDay;
	}

	

	public ArrayList<Sprint> getSprints() {
		return sprints;
	}

	public String getProjectAdmin() {
		return projectAdmin;
	}


	public ArrayList<String> getMemberList() {
		return memberList;
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

	

	public void setSprints(ArrayList<Sprint> sprints) {
		this.sprints = sprints;
	}


	public void setProjectAdmin(String projectAdmin) {
		this.projectAdmin = projectAdmin;
	}

	public void setMemberList(ArrayList<String> memberList) {
		this.memberList = memberList;
	}


	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return projectTitle + "  (" + sdf.format(projectStartDay) + " ~ " + sdf.format(projectEndDay) + ")" /*+ projectPeople*/;
	}




}
