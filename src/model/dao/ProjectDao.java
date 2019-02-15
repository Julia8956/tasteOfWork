package model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import model.vo.Project;
import model.vo.Sprint;

public class ProjectDao {

	private String projectTitle;
	private ArrayList<Project> projectList;
	private HashMap<String, ArrayList<Sprint>> allSprintList;
	private ArrayList<Sprint> sprintList;
	
	public ProjectDao(String projectTitle) {
		
		this.projectTitle = projectTitle;
		projectList = new ArrayList();
		allSprintList = new HashMap<String, ArrayList<Sprint>>();
		sprintList = new ArrayList();
		

		try (ObjectInputStream prjIn = new ObjectInputStream(new FileInputStream("project_list.dat"));
				/*ObjectInputStream sprIn = new ObjectInputStream(new FileInputStream(projectTitle + "_sprint_list.dat"))*/) {
			
			while(true) {
				Project p = (Project)prjIn.readObject();
				projectList.add(p);
				/*Sprint s = (Sprint)sprIn.readObject();
				sprintList.add(s);*/
			}
			

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");

		} catch (EOFException e) {
			System.out.println("프로젝트 파일 불러오기 완료");
			try(ObjectInputStream sprIn = new ObjectInputStream(new FileInputStream(projectTitle + "_sprint_list.dat"))) {
				
				while(true) {
					Sprint s = (Sprint)sprIn.readObject();
					sprintList.add(s);
				}
				
			} catch (FileNotFoundException e1) {
				System.out.println("스프린트 파일을 찾을 수 없습니다!");
			} catch (EOFException e1) {
				System.out.println("스프린트 파일 불러오기 완료");
			} catch (IOException e1) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 


		


	}
	
	
	public void saveProjects() {
		
		try (ObjectOutputStream prjOut = new ObjectOutputStream(new FileOutputStream("project_list.dat"));
				ObjectOutputStream sprOut = new ObjectOutputStream(new FileOutputStream(projectTitle + "_sprint_list.dat"))) {

			for(int i = 0; i < projectList.size(); i++) {
				prjOut.writeObject(projectList.get(i));
			}
			for(int i = 0; i < sprintList.size(); i++) {
				sprOut.writeObject(sprintList.get(i));
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void saveSprints() {
		try (ObjectOutputStream sprOut = new ObjectOutputStream(new FileOutputStream(projectTitle + "_sprint_list.dat"))) {

			for(int i = 0; i < sprintList.size(); i++) {
				sprOut.writeObject(sprintList.get(i));
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void makeProject(Project project) {
		projectList.add(project);
		allSprintList.put(projectTitle, project.getSprints());
		sprintList.addAll(project.getSprints());
		
		saveProjects();
	}
	
	public Project findProject() {

		Project selectedProject = null;
		for(int i = 0; i < projectList.size(); i++) {
			Project project = (Project)projectList.get(i);
			if(project.getProjectTitle().equals(projectTitle)) {
				System.out.println("일치하는 프로젝트 찾음!");
				selectedProject = project;
				selectedProject.setSprints(sprintList);
				break;
			}
		}
		if(selectedProject != null) {
			return selectedProject;
		}else {
			System.out.println("!선택하신 프로젝트가 존재하지 않습니다!");
			return null;
		}
	}
	
	public void addSprint(ArrayList<Sprint> sprintList) {
		this.sprintList.addAll(sprintList);
		saveSprints();
	}
	

}
