package Item;

import java.util.HashMap;

import Helper.CourseNode;

public class Curriculum {
	private String department;
	private HashMap<String,HashMap<String,Course>> courseMap;
	
	public Curriculum(String department, HashMap<String,HashMap<String,Course>> courseMap) {
		this.department = department;
		this.courseMap = courseMap;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the courseMap
	 */
	public HashMap<String, HashMap<String, Course>> getCourseMap() {
		return courseMap;
	}

	/**
	 * @param courseMap the courseMap to set
	 */
	public void setCourseMap(HashMap<String, HashMap<String, Course>> courseMap) {
		this.courseMap = courseMap;
	}
	
	
}
