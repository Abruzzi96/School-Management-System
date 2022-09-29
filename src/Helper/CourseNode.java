package Helper;

import java.util.Random;

import Item.Course;

public class CourseNode {
	private Course course;
	private double passCredit;
	private String passGrade;
	private static final Random random = new Random();
	private static final double[] points = {4.0,3.5,3.0,2.5,2.0};
	private static final String[] grades = {"AA","BA","BB","CB","CC"};
	
	public CourseNode(Course course) {
		this.course = course;
		int randomIndex = random.nextInt(5);
		this.passCredit = points[randomIndex];
		this.passGrade = grades[randomIndex];
	}
	
	public CourseNode(Course course, boolean isNull) {
		this.course = course;
		this.passCredit = 0.0;
		this.passGrade = null;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the passCredit
	 */
	public double getPassCredit() {
		return passCredit;
	}

	/**
	 * @param passCredit the passCredit to set
	 */
	public void setPassCredit(double passCredit) {
		this.passCredit = passCredit;
	}

	/**
	 * @return the passGrade
	 */
	public String getPassGrade() {
		return passGrade;
	}

	/**
	 * @param passGrade the passGrade to set
	 */
	public void setPassGrade(String passGrade) {
		this.passGrade = passGrade;
	}

	/**
	 * @return the random
	 */
	public static Random getRandom() {
		return random;
	}

	/**
	 * @return the points
	 */
	public static double[] getPoints() {
		return points;
	}

	/**
	 * @return the grades
	 */
	public static String[] getGrades() {
		return grades;
	}
	
	
	
}
