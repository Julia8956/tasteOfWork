package controller;

import java.util.ArrayList;
import java.util.Date;

import model.dao.ProjectDao;
import model.dao.SprintDao;
import model.vo.Project;
import model.vo.Sprint;

public class ProjectManager {

	private ProjectDao pdao;
	private ArrayList<Sprint> sprints = new ArrayList<Sprint>(); 
	private SprintDao sdao;
	private ArrayList<String> ids = new ArrayList<String>();

	public ProjectManager() {}


	public Sprint makeNewSprint(String sprintTitle, Date sprintStartDay, 
			Date sprintEndDay, String sprintDetail, String sprintToDo) {
		
		Sprint newSprint = new Sprint(sprintTitle, sprintStartDay, sprintEndDay, sprintDetail, sprintToDo);
		sprints.add(newSprint);
		return newSprint;
	}
	
	
	
	
	public Project addNewSprint(Project project, String sprintTitle, Date sprintStartDay, 
			Date sprintEndDay, String sprintDetail, String sprintToDo) {

		sprints = project.getSprints();
		Sprint newSprint = new Sprint(sprintTitle, sprintStartDay, sprintEndDay, sprintDetail, sprintToDo);
		sprints.add(newSprint);
		project.setSprints(sprints);
		
		pdao = new ProjectDao(project.getProjectTitle());
		pdao.addSprint(sprints);
		
		return project;
	
	}
	
	public void addSprintOnProject(Project project) {
		project.setSprints(sprints);
	}


	public ArrayList<String> addPeople(String id) {

		ids.add(id);
		
		
		return ids;
	}
	
	
	public void makeNewProject(String projectTitle, Date projectStartDay, Date projectEndDay) {
		
		//ArrayList<Project> projects = new ArrayList<Project>();
		Project newProject = new Project(projectTitle, projectStartDay, projectEndDay, sprints,ids);
		pdao = new ProjectDao(projectTitle);
		pdao.makeProject(newProject);
		//projects.add(newProject);
		
		//sdao = new SprintDao();
		
		
	}
	
	public Project getProject(String titleSelected) {
		
		pdao = new ProjectDao(titleSelected);
		return pdao.findProject();
	}
	
	
	
	
	
	
}
