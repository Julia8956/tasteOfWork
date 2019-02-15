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
	protected ArrayList<String> ids;
	

	public Project() {}
	
	

	public Project(String projectTitle, Date projectStartDay, Date projectEndDay, 
			ArrayList<Sprint> sprints, ArrayList<String> ids) {
		super();
		this.projectTitle = projectTitle;
		this.projectStartDay = projectStartDay;
		this.projectEndDay = projectEndDay;
		this.sprints = sprints;
		this.ids = ids;
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



	public ArrayList<String> getIds() {
		return ids;
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



	public void setIds(ArrayList<String> ids) {
		this.ids = ids;
	}


	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return projectTitle + "  (" + sdf.format(projectStartDay) + " ~ " + sdf.format(projectEndDay) + ")" /*+ projectPeople*/;
	}




}
