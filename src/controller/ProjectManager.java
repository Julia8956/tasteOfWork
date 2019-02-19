package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.dao.ProjectDao;
import model.vo.A_Member;
import model.vo.MOM;
import model.vo.Project;
import model.vo.Sprint;

public class ProjectManager {

	private ProjectDao pdao;
	private ArrayList<Project> projectList = new ArrayList<Project>();
	private ArrayList<Sprint> sprintList = new ArrayList<Sprint>(); 
	private ArrayList<String> memberList = new ArrayList<String>();
	private ArrayList<MOM> MOMList = new ArrayList<MOM>(); 
	
	public ProjectManager() {}

	
	
	
	public ArrayList<Project> getProjectList() {
		
		pdao = new ProjectDao();
		
		ArrayList<Project> projectList = pdao.getProjectList();
		if(projectList != null) {
			this.projectList = projectList;
		}
		
		
		return this.projectList;
	}
	
	
	
	
	

	public Sprint makeNewSprint(String sprintTitle, Date sprintListtartDay, 
			Date sprintEndDay, String sprintDetail, String sprintToDo) {
		
		Sprint newSprint = new Sprint(sprintTitle, sprintListtartDay, sprintEndDay, sprintDetail, sprintToDo);
		sprintList.add(newSprint);
		return newSprint;
	}
	
	//////////////
	public MOM makeNewMOM(String mOMTitle, String mOMWriter, Date mOMDay, String mOMPerson,
			String mOMDescription) {

		MOM newMOM = new MOM(mOMTitle, mOMWriter, mOMDay, mOMPerson, mOMDescription);
		MOMList.add(newMOM);
		return newMOM;
	}
	////////////////
	
	
	public Project addNewSprint(Project project, String sprintTitle, Date sprintListtartDay, 
			Date sprintEndDay, String sprintDetail, String sprintToDo) {

		sprintList = project.getSprintList();
		Sprint newSprint = new Sprint(sprintTitle, sprintListtartDay, sprintEndDay, sprintDetail, sprintToDo);
		sprintList.add(newSprint);
		project.setSprintList(sprintList);
		
		if(project != null) {
			pdao = new ProjectDao(project.getProjectTitle());
			pdao.addSprint(sprintList);
		}
		
		return project;
	
	}
	
	///////////////////
	public Project addNewMOM(Project project, String MOMTitle, String MOMWriter, Date MOMDay, String MOMPerson, String MOMDescription) {

		if(project.getMOMList() != null) {
			MOMList = project.getMOMList();
		}
		MOM newMOM = new MOM( MOMTitle, MOMWriter, MOMDay, MOMPerson, MOMDescription);

		MOMList.add(newMOM);

		project.setMOMList(MOMList);

		pdao = new ProjectDao(project.getProjectTitle());
		pdao.addMOM(MOMList);

		return project;

	}
	//////////////////
	
	
	public void addSprintOnProject(Project project) {
		project.setSprintList(sprintList);
	}

	///////////
	public void addMOMOnProject(Project project) {
		project.setMOMList(MOMList);
	}
	///////////

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
	
	
	
	
	public Project deleteMember(Project project, String member) {
		
		memberList = project.getMemberList();
		memberList.remove(member);
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
		
		Project newProject = new Project(projectTitle, projectStartDay, projectEndDay, sprintList, projectAdmin, memberList, MOMList);
		pdao = new ProjectDao(projectTitle);
		pdao.makeProject(newProject);
	}
	
	
	
	
	public Project getProject(String titleSelected) {
		
		pdao = new ProjectDao(titleSelected);
		//getSprintList();
		return pdao.findProject();
	}
	
	public ArrayList<Sprint> getSprintList() {
		
		//pdao = new ProjectDao(project.getProjectTitle());
		sprintList = pdao.getSprintList();
		return sprintList;
	}
	
	///////
	public ArrayList<MOM> getMOMList() {

		MOMList = pdao.getMOMList();
		return MOMList;
	}
	//////////////
	
	
	public void modifyProject(Project project, String projectTitle, Date projectStartDay, Date projectEndDay, ArrayList<Sprint> sprintList, ArrayList<String> memberList) {
		
		pdao = new ProjectDao(project.getProjectTitle());
		project.setProjectTitle(projectTitle);
		project.setProjectStartDay(projectStartDay);
		project.setProjectEndDay(projectEndDay);
		project.setSprintList(sprintList);
		project.setMemberList(memberList);
		pdao.modifyProject(project);
		
		//return project;
	}
	
	public Project modifySprint(Project project, Sprint sprint, String sprintTitle, Date sprintListtartDay, 
			Date sprintEndDay, String sprintDetail, String sprintToDo) {
		
		//System.out.println("old : " + sprint);
		pdao = new ProjectDao(project.getProjectTitle());
		Sprint updatedSprint = new Sprint(sprintTitle, sprintListtartDay, sprintEndDay, sprintDetail, sprintToDo);
		//System.out.println("new : " + updatedSprint);
		sprintList = pdao.modifySprint(project, sprint, updatedSprint);
		project.setSprintList(sprintList);
		return project;
	}
	
	//////
	public Project modifyMOM(Project project, MOM mom, String MOMTitle, String MOMWriter, Date MOMDay, String MOMPerson, String MOMDescription) {

		pdao = new ProjectDao(project.getProjectTitle());
		MOM updatedMOM = new MOM(MOMTitle, MOMWriter, MOMDay, MOMPerson, MOMDescription);
		MOMList = pdao.modifyMOM(project, mom, updatedMOM);
		project.setMOMList(MOMList);
		
		return project;
	}
	/////////
	
	
	
	public void deleteProject(Project project) {
		
		pdao = new ProjectDao(project.getProjectTitle());
		pdao.deleteProject();
	}
	
	
	public Project deleteSprint(Project project, Sprint sprint) {
		
		sprintList = project.getSprintList();
		sprintList.remove(sprint);
		project.setSprintList(sprintList);
		if(project != null) {
			pdao = new ProjectDao(project.getProjectTitle());
			pdao.addSprint(sprintList);
		}
		
		return project;
	}
	
	public Project deleteMOM(Project project, MOM mom) {
		
		MOMList = project.getMOMList();
		MOMList.remove(mom);
		project.setMOMList(MOMList);
		if(project != null) {
			pdao = new ProjectDao(project.getProjectTitle());
			pdao.addMOM(MOMList);
		}
		
		return project;
	}
	
	/*public void makeNewMOM(Project project) {
		
	}*/
	
	
	public void saveCalendar(Project project, HashMap calendarMap) {
		project.setCalendarMap(calendarMap);
		pdao = new ProjectDao(project.getProjectTitle());
		pdao.modifyProject(project);
		
	}
	
	
}
