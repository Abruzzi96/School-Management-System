package Helper;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Student;
import Operations.Main;

public class RankCalculator {
	static HashMap<String, Student> studentList;
	
	public RankCalculator() {
		studentList = Main.studentList;
	}
	
	public void updateRanks() {
		for(String key : Main.curriculumList.keySet()) {
			updateRanksOfStudents(key);
		}
	}

	private void updateRanksOfStudents(String department) {
		ArrayList<Student> departmentStudent = new ArrayList<>();
		
		for(Student student : studentList.values()) {
			if(student.getDepartment().equals(department)) {
				departmentStudent.add(student);
			}
		}
		
		bubbleSort(departmentStudent);
		
		for(int i = 0; i<departmentStudent.size(); i++) {
			Student x = Main.studentList.get(departmentStudent.get(i).getID());
			x.setRank(departmentStudent.size()-i);
			Main.studentList.put(x.getID(), x);
		}
	}

	private void bubbleSort(ArrayList<Student> studentArraylist) {
		int n = studentArraylist.size();
		
		for(int i = 0; i<n-1; i++) {
			for(int j = 0; j<n-i-1; j++) {
				if(studentArraylist.get(j).getGPA() > studentArraylist.get(j+1).getGPA()) {
					Student temp = studentArraylist.get(j);
					studentArraylist.set(j, studentArraylist.get(j+1));
					studentArraylist.set(j+1, temp);
				}
			}
		}
		
	}

}
