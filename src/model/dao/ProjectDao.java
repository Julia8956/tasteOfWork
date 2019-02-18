package model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import model.vo.A_Member;
import model.vo.MOM;
import model.vo.Project;
import model.vo.Sprint;

public class ProjectDao {

	private String projectTitle;
	private ArrayList<Project> projectList;
	private HashMap<String, ArrayList<Sprint>> allSprintList;
	private ArrayList<Sprint> sprintList;
	//private ArrayList<String> memberList;
	private ArrayList<MOM> MOMList;
	
	private int index;
	
	public ProjectDao() {
		
		
		projectList = new ArrayList();
		//allSprintList = new HashMap<String, ArrayList<Sprint>>();
		sprintList = new ArrayList();
		MOMList = new ArrayList();
		
		try (ObjectInputStream prjIn = new ObjectInputStream(new FileInputStream("project_list.dat"))) {
			
			while(true) {
				Project p = (Project)prjIn.readObject();
				projectList.add(p);
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
				
				/*for(int i=0; i < sprintList.size();i++) {
					System.out.println(sprintList.get(i)); ///////////save 잘됨
				}*/
				/////////////////////////////////////////////////
				try (ObjectInputStream MOMIn = new ObjectInputStream(
						new FileInputStream(projectTitle + "_MOM_list.dat"))) {

					while (true) {
						MOM m = (MOM) MOMIn.readObject();
						MOMList.add(m);
					}

				} catch (FileNotFoundException e11) {
					System.out.println("회의록 파일을 찾을 수 없습니다!");
				} catch (EOFException e11) {
					System.out.println("회의록 파일 불러오기 완료");
					/*for(int i=0; i < MOMList.size();i++) {
						System.out.println(MOMList.get(i));///////////save 잘됨
					}*/
				} catch (IOException e11) {
					e11.printStackTrace();
				} catch (ClassNotFoundException e11) {
					e11.printStackTrace();
				}
				/////////////////////////////////////////////////////////////////////
				
				
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
	
	public ProjectDao(String projectTitle) {
		
		this.projectTitle = projectTitle;
		projectList = new ArrayList();
		allSprintList = new HashMap<String, ArrayList<Sprint>>();
		sprintList = new ArrayList();
		MOMList = new ArrayList();

		try (ObjectInputStream prjIn = new ObjectInputStream(new FileInputStream("project_list.dat"));
				/*ObjectInputStream sprIn = new ObjectInputStream(new FileInputStream(projectTitle + "_sprint_list.dat"))*/) {
			
			while(true) {
				Project p = (Project)prjIn.readObject();
				projectList.add(p);
				//memberList.addAll(p.getMemberList());
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

				/*for(int i=0; i < sprintList.size();i++) {
				System.out.println(sprintList.get(i)); ///////////save 잘됨
				}*/
				/////////////////////////////////////////////////
				try (ObjectInputStream MOMIn = new ObjectInputStream(
						new FileInputStream(projectTitle + "_MOM_list.dat"))) {

					while (true) {
						MOM m = (MOM) MOMIn.readObject();
						MOMList.add(m);
					}

				} catch (FileNotFoundException e11) {
					System.out.println("회의록 파일을 찾을 수 없습니다!");
				} catch (EOFException e11) {
					System.out.println("회의록 파일 불러오기 완료");
					/*for(int i=0; i < MOMList.size();i++) {
					System.out.println(MOMList.get(i));///////////save 잘됨
				}*/
				} catch (IOException e11) {
					e11.printStackTrace();
				} catch (ClassNotFoundException e11) {
					e11.printStackTrace();
				}
				/////////////////////////////////////////////////////////////////////


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

		//if(file.createNewFile())
		File projectfile = new File("project_list.dat");
		try {
			if(!projectfile.createNewFile()) {
				projectfile.delete();
				System.out.println("이전 프로젝트 파일 삭제함");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (ObjectOutputStream prjOut = new ObjectOutputStream(new FileOutputStream("project_list.dat"))) {

			System.out.println("프로젝트 파일 재생성");
			for(int i = 0; i < projectList.size(); i++) {
				prjOut.writeObject(projectList.get(i));
				prjOut.flush();
			}
			System.out.println("새로운 파일에 프로젝트 작성 완료");


		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void saveSprints() {
		
		//if(file.createNewFile())
		File sprintfile = new File(projectTitle + "_sprint_list.dat");
		try {
			if(!sprintfile.createNewFile()) {
				sprintfile.delete();
				System.out.println("기존 스프린트 파일 삭제함");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try (ObjectOutputStream sprOut = new ObjectOutputStream(new FileOutputStream(projectTitle+ "_sprint_list.dat"))) {

			System.out.println("스프린트 파일 재생성함");
			for(int i = 0; i < sprintList.size(); i++) {
				sprOut.writeObject(sprintList.get(i));
				sprOut.flush();
			}
			System.out.println("새로운 파일에 스프린트 저장 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/////////////////////
	public void saveMOMList() {

		// if(file.createNewFile())
		File MOMFile = new File(projectTitle + "_MOM_list.dat");
		try {
			if (!MOMFile.createNewFile()) {
				MOMFile.delete();
				System.out.println("기존 회의록 파일 삭제함");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (ObjectOutputStream MOMOut = new ObjectOutputStream(new FileOutputStream(projectTitle + "_MOM_list.dat"))) {

			System.out.println("회의록 파일 재생성함");
			for (int i = 0; i < MOMList.size(); i++) {
				MOMOut.writeObject(MOMList.get(i));
				MOMOut.flush();
			}
			System.out.println("새로운 파일에 회의록 저장 완료");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/////////////////////
	
	public void makeProject(Project project) {
		projectList.add(project);
		allSprintList.put(projectTitle, project.getSprintList());
		sprintList.addAll(project.getSprintList());
		saveSprints();
		saveProjects();
	}
	
	public Project findProject() {

		Project selectedProject = null;
		for(int i = 0; i < projectList.size(); i++) {
			Project project = (Project)projectList.get(i);
			if(project.getProjectTitle().equals(projectTitle)) {
				System.out.println("일치하는 프로젝트 찾음!");
				index = i;
				selectedProject = project;
				selectedProject.setSprintList(sprintList);
				
				////
				selectedProject.setMOMList(MOMList);
				////
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
	
	public Sprint findSprint(Sprint sprint) {
		
		for(int i = 0;  i < sprintList.size(); i++) {
			Sprint s = (Sprint)sprintList.get(i);
			if(s.toString().equals(sprint.toString())) {
				System.out.println("일치하는 스프린트 찾음");
				index = i;
				return s;
			}
		}
		
		System.out.println("스프린트가 존재하지 않습니다.");
		return null;
	}
	
	public MOM findMOM(MOM mom) {
		
		for(int i = 0;  i < MOMList.size(); i++) {
			MOM m = (MOM)MOMList.get(i);
			if(m.toString().equals(mom.toString())) {
				System.out.println("일치하는 회의록 찾음");
				index = i;
				return m;
			}
		}
		
		System.out.println("회의록이 존재하지 않습니다.");
		return null;
		
	}
	

	public ArrayList<Project> getProjectList() {
		return projectList;
	}

	public ArrayList<Sprint> getSprintList() {
		return sprintList;
	}
	
	//////////////////////
	public ArrayList<MOM> getMOMList() {
		return MOMList;
	}
	///////////////////
	
	public void deleteProject() {
		findProject();
		projectList.remove(index);
		saveProjects();
	}
	
	
	public void addSprint(ArrayList<Sprint> sprintList) {
		this.sprintList.clear();
		this.sprintList.addAll(sprintList);
		saveSprints();
	}
	
	//////////////////
	public void addMOM(ArrayList<MOM> MOMList) {
		this.MOMList.clear();
		this.MOMList.addAll(MOMList);
		saveMOMList();
	}
	/////////////////////
	
	
	
	public void addMember(ArrayList<String> memberList) {
		Project projectToBeChanged = findProject();
		projectToBeChanged.setMemberList(memberList);
		projectList.set(index, projectToBeChanged);
		saveProjects();
		
	}
	
	public void changeAdmin(String projectAdmin) {
		Project projectToBeChanged = findProject();
		projectToBeChanged.setProjectAdmin(projectAdmin);
		projectList.set(index, projectToBeChanged);
		saveProjects();
	}
	
	
	public void modifyProject(Project project) {
		Project projectToBeChanged = findProject();
		projectToBeChanged = project;
		projectTitle = projectToBeChanged.getProjectTitle();
		projectList.set(index, projectToBeChanged);
		sprintList.clear();
		sprintList.addAll(project.getSprintList());
		saveSprints();
		saveProjects();
		
	}
	
	public ArrayList<Sprint> modifySprint(Project project, Sprint sprint, Sprint updatedSprint) {
		
		Sprint sprintToBeChanged = findSprint(sprint);
		if(sprintToBeChanged != null) {
			sprintToBeChanged = updatedSprint;
			sprintList.set(index, sprintToBeChanged);
		}
		
		saveSprints();
		return sprintList;
	}
	
	public ArrayList<MOM> modifyMOM(Project project, MOM mom, MOM updatedMOM) {
		
		MOM momToBeChanged = findMOM(mom);
		if(momToBeChanged != null) {
			momToBeChanged = updatedMOM;
			MOMList.set(index, momToBeChanged);
		}
		saveMOMList();
		return MOMList;
	}
	
	

}
