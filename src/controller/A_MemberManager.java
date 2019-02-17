package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.A_MemberDao;
import model.vo.A_Member;
import view.A_LoginPage;
import view.A_MainPage;

import view.ChangePanel;
import view.MainFrame;

public class A_MemberManager {
	private MainFrame mf;
	private A_MemberDao md = new A_MemberDao();
	private A_LoginPage lp;
	
	public void joinMember(A_Member a_Member) {
		
		//파일에 기록된 리스트 조회
		ArrayList<A_Member> list = md.readMemberList();
		
		//
		if(list==null) {
			
			list = new ArrayList<A_Member>();
		}
		//리스트에 member 객체 추가
		list.add(a_Member);
		
		//리스트를 파일에 기록 후 결과값 정수로 리턴
		int result = md.writeMemberList(list);
		
		
	}
	
	
	public void loginMember(String id, String pwd, A_LoginPage lp) {
		this.lp = lp;
		//전체 멤버를 조회
		ArrayList<A_Member> list = md.readMemberList();
		
		//System.out.println(id);
		//System.out.println(pwd);
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
			
		} //list에 배열이 들어가 있는지 확인했음
		
		/*System.out.println(id.hashCode());
		System.out.println(list.get(1).getId().hashCode());*/ //해쉬코드 확인
		
		
		/*System.out.println(pwd.hashCode());
		System.out.println(list.get(1).getPwd().hashCode());*/
		
		
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id) && list.get(i).getPwd().equals(pwd)) {
				lp.goToMainPage(lp);
				return;
				
		}
	}
		
		for(int i =0; i<list.size(); i++) {
		if(list.get(i).getId() != id && list.get(i).getPwd()!= pwd) {
			
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요"); 
			return;
			
		}else if(list.get(i).getId() == " " && list.get(i).getPwd()== " "){
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력하세요");
			return;
		}
		
		
		}
		
		
	}
	
	public void idcheck(String id) {
		ArrayList<A_Member> list = md.readMemberList();
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				JOptionPane.showMessageDialog(null, "사용중인 아이디 입니다.");
				return;
			}
			
		}
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getId() != id){
			
			JOptionPane.showMessageDialog(null, "사용할 수 있는 아이디 입니다.");
				return;
			
		}
		}
	}
   
	public void findId(String name, String phone, String email) {
		
		ArrayList<A_Member> list = md.readMemberList();
		
		
		
		for(int i =0; i<list.size(); i++) {
			
			if(list.get(i).getName().equals(name) 
					&& list.get(i).getPhone().equals(phone) 
					&& list.get(i).getEmail().equals(email)) {
				
				JOptionPane.showMessageDialog(null, name+"님의 아이디는" +list.get(i).getId()+ "입니다");
				return;
			}
		}
			
			
			JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.");
				
	
		}
	public void findPwd(String id, String phone, String email) {
		ArrayList<A_Member> list = md.readMemberList();
		
		
		
		for(int i =0; i<list.size(); i++) {
			
			if(list.get(i).getName().equals(id) 
					&& list.get(i).getPhone().equals(phone) 
					&& list.get(i).getEmail().equals(email)) {
				
				JOptionPane.showMessageDialog(null, list.get(i).getName()+"님의 비밀번호는" +list.get(i).getPwd()+ "입니다");
				return;
			}
		}
			
			JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.");
				
	
		}
	
}



