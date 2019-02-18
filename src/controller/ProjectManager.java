package controller;

import java.util.ArrayList;
import java.util.Date;

import model.dao.ProjectDao;
import model.vo.A_Member;
import model.vo.Project;
import model.vo.Sprint;

public class ProjectManager {

	private ProjectDao pdao;
	private ArrayList<Sprint> sprints = new ArrayList<Sprint>(); 
	//private SprintDao sdao;
	private ArrayList<String> memberList = new ArrayList<String>();

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


	//(¹Î)
	public Project addMember(Project project, A_Member member) {

		memberList = project.getMemberList();
		memberList.add(member.getId());
		project.setMemberList(memberList);
		if(project != null) {
			pdao = new ProjectDao(project.getProjectTitle());
			pdao.addMember(memberList);
		}
		
		return project;
	}
	
	public Project changeAdmin(Project project, String projectAdmin) {
	
		project.setProjectAdmin(projectAdmin);
		pdao = new ProjectDao(project.getProjectTitle());
		pdao.changeAdmin(projectAdmin);
		return project;
	}
	
	
	public void makeNewProject(String projectTitle, Date projectStartDay, Date projectEndDay, ArrayList<Sprint> sprintList, String projectAdmin, ArrayList<String> memberList) {
		
		//ArrayList<Project> projects = new ArrayList<Project>();
		Project newProject = new Project(projectTitle, projectStartDay, projectEndDay, sprintList, projectAdmin, memberList);
		pdao = new ProjectDao(projectTitle);
		pdao.makeProject(newProject);
		//projects.add(newProject);
		
		//sdao = new SprintDao();
		
		//return newProject;
	}
	
	
	public ArrayList<Project> getMyAdminProjects() {
		
		return null;
	}
	
	public ArrayList<Project> getMyProjects() {
		
		return null;
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
	
	public void modifyProject(Project project, String projectTitle, Date projectStartDay, Date projectEndDay, ArrayList<Sprint> sprintList, ArrayList<String> memberList) {
		
		pdao = new ProjectDao(project.getProjectTitle());
		project.setProjectTitle(projectTitle);
		project.setProjectStartDay(projectStartDay);
		project.setProjectEndDay(projectEndDay);
		project.setSprints(sprintList);
		project.setMemberList(memberList);
		pdao.modifyProject(project);
		
		//return project;
	}
	
	public void makeNewMOM(Project project) {
		
	}
	
	
	
}
