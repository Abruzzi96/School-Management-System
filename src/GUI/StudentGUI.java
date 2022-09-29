package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Item.Course;
import Operations.Main;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class StudentGUI extends JFrame {

	static double totalCredit;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					StudentGUI frame = new StudentGUI(args[0]);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentGUI(String ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 914, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INSTRUCTOR PANEL");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 46, 914, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome,");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 79, 90, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbl_stdName = new JLabel(Main.studentList.get(ID).getName());
		lbl_stdName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_stdName.setBounds(110, 79, 814, 36);
		contentPane.add(lbl_stdName);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 115, 914, 435);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Information", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(StudentGUI.class.getResource("/Args/7.png")));
		lblNewLabel_3.setBounds(46, 11, 500, 385);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4.setBounds(624, 11, 275, 30);
		panel.add(lblNewLabel_4);
		
		JLabel lbl_StdName = new JLabel(Main.studentList.get(ID).getName());
		lbl_StdName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_StdName.setBounds(624, 36, 275, 30);
		panel.add(lbl_StdName);
		
		JLabel lblNewLabel_4_2 = new JLabel("Surname");
		lblNewLabel_4_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_2.setBounds(624, 64, 275, 34);
		panel.add(lblNewLabel_4_2);
		
		JLabel lbl_StdSurname = new JLabel(Main.studentList.get(ID).getSurname());
		lbl_StdSurname.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_StdSurname.setBounds(624, 89, 275, 34);
		panel.add(lbl_StdSurname);
		
		JLabel lblNewLabel_4_3 = new JLabel("ID");
		lblNewLabel_4_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_3.setBounds(624, 117, 275, 34);
		panel.add(lblNewLabel_4_3);
		
		JLabel lbl_StdID = new JLabel(Main.studentList.get(ID).getID());
		lbl_StdID.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_StdID.setBounds(624, 142, 275, 34);
		panel.add(lbl_StdID);
		
		JLabel lblNewLabel_4_4 = new JLabel("Class");
		lblNewLabel_4_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_4.setBounds(624, 170, 275, 34);
		panel.add(lblNewLabel_4_4);
		
		JLabel lbl_StdClass = new JLabel(String.valueOf(Main.studentList.get(ID).getClassLevel()));
		lbl_StdClass.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_StdClass.setBounds(624, 195, 275, 34);
		panel.add(lbl_StdClass);
		
		JLabel lblNewLabel_4_5 = new JLabel("Department");
		lblNewLabel_4_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_5.setBounds(624, 226, 275, 34);
		panel.add(lblNewLabel_4_5);
		
		JLabel lbl_StdDepartment = new JLabel(Main.studentList.get(ID).getDepartment());
		lbl_StdDepartment.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_StdDepartment.setBounds(624, 251, 275, 34);
		panel.add(lbl_StdDepartment);
		
		JLabel lblNewLabel_4_6 = new JLabel("GPA");
		lblNewLabel_4_6.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_6.setBounds(624, 336, 275, 34);
		panel.add(lblNewLabel_4_6);
		
		JLabel lbl_StdGPA = new JLabel(String.valueOf(Main.studentList.get(ID).getGPA()));
		lbl_StdGPA.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_StdGPA.setBounds(624, 361, 275, 34);
		panel.add(lbl_StdGPA);
		
		JLabel lblNewLabel_4_6_1 = new JLabel("Faculty");
		lblNewLabel_4_6_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_6_1.setBounds(624, 281, 275, 34);
		panel.add(lblNewLabel_4_6_1);
		
		JLabel lbl_StdFaculty = new JLabel(Main.studentList.get(ID).getFaculty());
		lbl_StdFaculty.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_StdFaculty.setBounds(624, 306, 275, 34);
		panel.add(lbl_StdFaculty);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(600, 11, 2, 385);
		panel.add(panel_4);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Taken Courses", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 899, 385);
		panel_1.add(scrollPane);
		
		String[] columnsCourse = new String[] {"Course Code", "Course Name", "Credit", "Semester"};
		Object[][] courses = new Object[Main.studentList.get(ID).getTakenCourses().size()][4];
		calculateTakenCourses(courses, ID);

		table = new JTable(courses, columnsCourse);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Transcript", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		columnsCourse = new String[] {"Course Code", "Course Name", "Credit","Semester","Pass Credit","Pass Grade"};
		courses = new Object[Main.studentList.get(ID).getTranscript().getCompletedCourses().size()][6];
		calculateTranscriptCourses(courses,ID);
		
		JLabel lblNewLabel_4_7 = new JLabel("GPA");
		lblNewLabel_4_7.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_7.setBounds(660, 11, 239, 34);
		panel_2.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_1_6 = new JLabel(String.valueOf(Main.studentList.get(ID).getGPA()));
		lblNewLabel_4_1_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewLabel_4_1_6.setBounds(660, 40, 239, 34);
		panel_2.add(lblNewLabel_4_1_6);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Total Credits Earned");
		lblNewLabel_4_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_2_1.setBounds(660, 72, 239, 34);
		panel_2.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel(String.valueOf(totalCredit));
		lblNewLabel_4_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewLabel_4_1_1_1.setBounds(660, 101, 239, 34);
		panel_2.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Rank in Department");
		lblNewLabel_4_3_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_3_1.setBounds(660, 133, 239, 34);
		panel_2.add(lblNewLabel_4_3_1);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel(String.valueOf(Main.studentList.get(ID).getRank()));
		lblNewLabel_4_1_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewLabel_4_1_2_1.setBounds(660, 162, 239, 34);
		panel_2.add(lblNewLabel_4_1_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 640, 385);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable(courses,columnsCourse);
		scrollPane_1.setViewportView(table_1);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(3);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(5);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(5);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(5);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Curriculum", null, panel_3, null);
		panel_3.setLayout(null);
		
		columnsCourse = new String[] {"Course Code", "Course Name", "Credit", "Semester"};
		courses = new Object[Main.studentList.get(ID).getCurriculum().size()][4];
		calculateCuriculumCourses(courses, ID);
		
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 889, 385);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable(courses,columnsCourse);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(90);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(3);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(5);
		scrollPane_2.setViewportView(table_2);
	}

	private void calculateCuriculumCourses(Object[][] courses, String ID) {
		for(int i = 0; i < Main.studentList.get(ID).getCurriculum().size(); i++) {
			Course course = Main.studentList.get(ID).getCurriculum().get(i);
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
		}
		
	}

	private void calculateTranscriptCourses(Object[][] courses, String iD) {
		totalCredit = 0.0;
		
		for(int i = 0; i<Main.studentList.get(iD).getTranscript().getCompletedCourses().size(); i++) {
			Course course = Main.studentList.get(iD).getTranscript().getCompletedCourses().get(i).getCourse();
			
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
			courses[i][4] = Main.studentList.get(iD).getTranscript().getCompletedCourses().get(i).getPassCredit();
			courses[i][5] = Main.studentList.get(iD).getTranscript().getCompletedCourses().get(i).getPassGrade();
			
			totalCredit = course.getCredit();
		}
	}

	private void calculateTakenCourses(Object[][] courses, String ID) {
		for(int i = 0; i < Main.studentList.get(ID).getTakenCourses().size(); i++) {
			Course course = Main.studentList.get(ID).getTakenCourses().get(i).getCourse();
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
		}
	}
}
