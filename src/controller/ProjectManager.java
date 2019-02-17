package controller;

import java.util.ArrayList;
import java.util.Date;

import model.dao.ProjectDao;
import model.vo.Project;
import model.vo.Sprint;

public class ProjectManager {

	private ProjectDao pdao;
	private ArrayList<Sprint> sprints = new ArrayList<Sprint>(); 
	//private SprintDao sdao;
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
		
		if(project != null) {
			pdao = new ProjectDao(project.getProjectTitle());
			pdao.addSprint(sprints);
		}
		
		return project;
	
	}
	
	public void addSprintOnProject(Project project) {
		project.setSprints(sprints);
	}


	public ArrayList<String> addPeople(String id) {

		ids.add(id);
		
		
		return ids;
	}
	
	
	public void makeNewProject(String projectTitle, Date projectStartDay, Date projectEndDay, ArrayList<Sprint> sprintList) {
		
		//ArrayList<Project> projects = new ArrayList<Project>();
		Project newProject = new Project(projectTitle, projectStartDay, projectEndDay, sprintList, ids);
		pdao = new ProjectDao(projectTitle);
		pdao.makeProject(newProject);
		//projects.add(newProject);
		
		//sdao = new SprintDao();
		
		//return newProject;
	}
	
	public Project getProject(String titleSelected) {
		
		pdao = new ProjectDao(titleSelected);
		//getSprintList();
		return pdao.findProject();
	}
	
	public ArrayList<Sprint> getSprintList() {
		
		//pdao = new ProjectDao(project.getProjectTitle());
		sprints = pdao.getSprintList();
		return sprints;
	}
	
	public void modifyProject(Project project, String projectTitle, Date projectStartDay, Date projectEndDay, ArrayList<Sprint> sprintList) {
		
		pdao = new ProjectDao(project.getProjectTitle());
		project.setProjectTitle(projectTitle);
		project.setProjectStartDay(projectStartDay);
		project.setProjectEndDay(projectEndDay);
		project.setSprints(sprintList);
		project.setIds(ids);
		pdao.modifyProject(project);
		
		//return project;
	}
	
	public void makeNewMOM(Project project) {
		
	}
	
	
	
}
