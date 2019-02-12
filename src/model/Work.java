package model;

import java.util.Arrays;

public class Work {
	private String work_name;		//할일 이름
	private String work_start;		//할일 시작날짜
	private String work_end;		//할일 종료날짜
	private String[] allocator;		//할당자
	private boolean emergy; 		//긴급
	private String work_content; 	//할일 세부내용
	private String feedback;		//피드백
	
	public Work() {}
	
	public Work(String work_name, String[] allocator, boolean emergy) {
		this.work_name = work_name;
		this.allocator = allocator;
		this.emergy = emergy;
	}

	public Work(String work_name, String work_start, String work_end, boolean emergy) {
		super();
		this.work_name = work_name;
		this.work_start = work_start;
		this.work_end = work_end;
		this.emergy = emergy;
	}

	public Work(String work_name, String work_start, String work_end, String[] allocator, boolean emergy,
			String work_content, String feedback) {
		super();
		this.work_name = work_name;
		this.work_start = work_start;
		this.work_end = work_end;
		this.allocator = allocator;
		this.emergy = emergy;
		this.work_content = work_content;
		this.feedback = feedback;
	}
	
	

	public String getWork_name() {
		return work_name;
	}

	public void setWork_name(String work_name) {
		this.work_name = work_name;
	}

	public String getWork_start() {
		return work_start;
	}

	public void setWork_start(String work_start) {
		this.work_start = work_start;
	}

	public String getWork_end() {
		return work_end;
	}

	public void setWork_end(String work_end) {
		this.work_end = work_end;
	}

	public String[] getAllocator() {
		return allocator;
	}

	public void setAllocator(String[] allocator) {
		this.allocator = allocator;
	}

	public boolean isEmergy() {
		return emergy;
	}

	public void setEmergy(boolean emergy) {
		this.emergy = emergy;
	}

	public String getWork_content() {
		return work_content;
	}

	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Work [work_name=" + work_name + ", allocator=" + Arrays.toString(allocator) + ", emergy=" + emergy
				+ "]";
	}
	
	

}
