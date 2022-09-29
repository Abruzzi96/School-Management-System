package Model;

import java.util.HashMap;

import Item.Course;

public class Instructor extends User{
	private String faculty, department;
	private boolean isAdvisor;
	private HashMap<String, Student> advisedStudents;
	private HashMap<String, Course> taughtCourses;
	
	public Instructor(String name, String surname, String iD, String faculty, String department, boolean isAdvisor) {
		super(name, surname, iD);
		this.faculty = faculty;
		this.department = department;
		this.isAdvisor = isAdvisor;
		this.advisedStudents = new HashMap<>();
		this.taughtCourses = new HashMap<>();
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isAdvisor() {
		return isAdvisor;
	}

	public void setAdvisor(boolean isAdvisor) {
		this.isAdvisor = isAdvisor;
	}

	public HashMap<String, Student> getAdvisedStudents() {
		return advisedStudents;
	}

	public void setAdvisedStudents(HashMap<String, Student> advisedStudents) {
		this.advisedStudents = advisedStudents;
	}

	public HashMap<String, Course> getTaughtCourses() {
		return taughtCourses;
	}

	public void setTaughtCourses(HashMap<String, Course> taughtCourses) {
		this.taughtCourses = taughtCourses;
	}
}
