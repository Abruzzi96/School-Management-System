package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import Helper.CourseNode;
import Helper.Helper;
import Item.Course;
import Item.Transcript;
import Operations.Main;
import Model.Instructor;
import Model.Student;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	private JTable tbl_student;
	private JTextField fld_addStdName;
	private JTextField fld_addStdSurname;
	private JTextField fld_addStdID;
	private JTextField fld_addStdClass;
	private JTextField fld_addStdFaculty;
	private JTextField fld_addStdDepartment;
	private JTextField fld_addStdAdvisor;
	private JTextField fld_loggedAdminDelID;
	private JTextField fld_addInsName;
	private JTextField fld_addInsSurname;
	private JTextField fld_addInsID;
	private JTextField fld_addInsFaculty;
	private JTextField fld_addInsDepartment;
	private JTextField fld_delInsID;
	private JTable tbl_instructors;
	private JTextField fld_addCourseCode;
	private JTextField fld_addCourseName;
	private JTextField fld_addCourseCredit;
	private JTextField fld_addCourseSemester;
	private JTextField fld_delCourseCode;
	private JTable tbl_courses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AdminGUI frame = new AdminGUI(args[0]);
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
	public AdminGUI(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logged_title = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		logged_title.setHorizontalAlignment(SwingConstants.CENTER);
		logged_title.setForeground(Color.BLACK);
		logged_title.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		logged_title.setBounds(10, 0, 914, 41);
		contentPane.add(logged_title);
		
		JLabel logged_title2 = new JLabel("ADMIN PANEL");
		logged_title2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		logged_title2.setHorizontalAlignment(SwingConstants.CENTER);
		logged_title2.setBounds(10, 35, 914, 22);
		contentPane.add(logged_title2);
		
		JLabel logged_welcomeAdmin = new JLabel("Welcome,");
		logged_welcomeAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		logged_welcomeAdmin.setBounds(10, 54, 90, 36);
		contentPane.add(logged_welcomeAdmin);
		
		JLabel logged_nameAdmin = new JLabel(name);
		logged_nameAdmin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		logged_nameAdmin.setBounds(110, 54, 814, 36);
		contentPane.add(logged_nameAdmin);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 93, 914, 457);
		contentPane.add(tabbedPane);
		
		JPanel pnl_stdMan = new JPanel();
		tabbedPane.addTab("Student Management", null, pnl_stdMan, null);
		pnl_stdMan.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 675, 407);
		pnl_stdMan.add(scrollPane);
		
		String[] columns = new String[] {"Name","Surname","ID","Class","Faculty","Department","Advisor ID"};
		Object[][] students = new Object[Main.studentList.values().size()][7];
		calculateStudents(students);
		
		tbl_student = new JTable(students,columns);
		scrollPane.setViewportView(tbl_student);
		TableColumnModel columnModel = tbl_student.getColumnModel();
		
		//scrollPane.setViewportView(table);
		
		tbl_student.setCellSelectionEnabled(true);
		tbl_student.setBackground(new Color(255, 255, 255));
		
		
		columnModel.getColumn(2).setPreferredWidth(5);
		columnModel.getColumn(3).setPreferredWidth(5);
		columnModel.getColumn(6).setPreferredWidth(10);
		
		JLabel lbl_loggedAdminName = new JLabel("Name");
		lbl_loggedAdminName.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminName.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminName.setBounds(695, 5, 204, 20);
		pnl_stdMan.add(lbl_loggedAdminName);
		
		fld_addStdName = new JTextField();
		fld_addStdName.setBounds(695, 25, 204, 20);
		pnl_stdMan.add(fld_addStdName);
		fld_addStdName.setColumns(10);
		
		JLabel lbl_loggedAdminSurname = new JLabel("Surname");
		lbl_loggedAdminSurname.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminSurname.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminSurname.setBounds(695, 45, 204, 20);
		pnl_stdMan.add(lbl_loggedAdminSurname);
		
		fld_addStdSurname = new JTextField();
		fld_addStdSurname.setColumns(10);
		fld_addStdSurname.setBounds(695, 66, 204, 20);
		pnl_stdMan.add(fld_addStdSurname);
		
		JLabel lbl_loggedAdminID = new JLabel("ID");
		lbl_loggedAdminID.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminID.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminID.setBounds(695, 88, 204, 20);
		pnl_stdMan.add(lbl_loggedAdminID);
		
		fld_addStdID = new JTextField();
		fld_addStdID.setColumns(10);
		fld_addStdID.setBounds(695, 107, 204, 20);
		pnl_stdMan.add(fld_addStdID);
		
		JLabel lbl_loggedAdminClass = new JLabel("Class");
		lbl_loggedAdminClass.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminClass.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminClass.setBounds(695, 128, 204, 20);
		pnl_stdMan.add(lbl_loggedAdminClass);
		
		fld_addStdClass = new JTextField();
		fld_addStdClass.setColumns(10);
		fld_addStdClass.setBounds(695, 148, 204, 20);
		pnl_stdMan.add(fld_addStdClass);
		
		JLabel lbl_loggedAdminFaculty = new JLabel("Faculty");
		lbl_loggedAdminFaculty.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminFaculty.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminFaculty.setBounds(695, 169, 204, 20);
		pnl_stdMan.add(lbl_loggedAdminFaculty);
		
		fld_addStdFaculty = new JTextField();
		fld_addStdFaculty.setColumns(10);
		fld_addStdFaculty.setBounds(695, 189, 204, 20);
		pnl_stdMan.add(fld_addStdFaculty);
		
		JLabel lbl_loggedAdminDepartment = new JLabel("Department");
		lbl_loggedAdminDepartment.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminDepartment.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminDepartment.setBounds(695, 210, 204, 20);
		pnl_stdMan.add(lbl_loggedAdminDepartment);
		
		fld_addStdDepartment = new JTextField();
		fld_addStdDepartment.setColumns(10);
		fld_addStdDepartment.setBounds(695, 230, 204, 20);
		pnl_stdMan.add(fld_addStdDepartment);
		
		JLabel lbl_loggedAdminAdvisorID = new JLabel("Advisor ID");
		lbl_loggedAdminAdvisorID.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminAdvisorID.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminAdvisorID.setBounds(695, 250, 204, 20);
		pnl_stdMan.add(lbl_loggedAdminAdvisorID);
		
		fld_addStdAdvisor = new JTextField();
		fld_addStdAdvisor.setColumns(10);
		fld_addStdAdvisor.setBounds(695, 270, 204, 20);
		pnl_stdMan.add(fld_addStdAdvisor);
		
		JLabel lbl_loggedAdminDelID = new JLabel("ID");
		lbl_loggedAdminDelID.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminDelID.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminDelID.setBounds(695, 348, 204, 20);
		pnl_stdMan.add(lbl_loggedAdminDelID);
		
		fld_loggedAdminDelID = new JTextField();
		fld_loggedAdminDelID.setColumns(10);
		fld_loggedAdminDelID.setBounds(695, 368, 204, 20);
		pnl_stdMan.add(fld_loggedAdminDelID);
		
		JButton btn_loggedAddStudent = new JButton("Add New Student");
		btn_loggedAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_addStdName.getText().length() != 0 && fld_addStdSurname.getText().length() != 0 &&
						fld_addStdID.getText().length() != 0 && fld_addStdClass.getText().length() != 0 && 
						fld_addStdFaculty.getText().length() != 0 && fld_addStdDepartment.getText().length() != 0 &&
						fld_addStdAdvisor.getText().length() != 0) {

					Student student = new Student(fld_addStdName.getText(), fld_addStdSurname.getText(), fld_addStdID.getText(),
							Integer.parseInt(fld_addStdClass.getText()), fld_addStdFaculty.getText(), fld_addStdDepartment.getText(),
							Main.instructorList.get(fld_addStdAdvisor.getText()));
					
					student.setCurriculum(Main.curriculumList.get(student.getDepartment()));
					
					
					HashMap<String, Student> newAdvisedStudentList = Main.instructorList.get(student.getAdvisor().getID()).getAdvisedStudents();
					newAdvisedStudentList.put(student.getID(), student);
					Main.instructorList.get(student.getAdvisor().getID()).setAdvisedStudents(newAdvisedStudentList);
					
					for(int i = 0; i<Main.curriculumList.get(student.getDepartment()).size(); i++) {
						if(Main.curriculumList.get(student.getDepartment()).get(i).getSemester() < student.getClassLevel()*2) {
							ArrayList<CourseNode> studentsCompletedCourses = student.getTranscript().getCompletedCourses();
							studentsCompletedCourses.add(new CourseNode(Main.curriculumList.get(student.getDepartment()).get(i)));
							
							Transcript studentTranscript = student.getTranscript();
							studentTranscript.setCompletedCourses(studentsCompletedCourses);
							studentTranscript.updateGPA();
							student.setTranscript(studentTranscript);
						}

						if(Main.curriculumList.get(student.getDepartment()).get(i).getSemester() == student.getClassLevel()*2) {
							ArrayList<CourseNode> studentTakenCourses = student.getTakenCourses();
							studentTakenCourses.add(new CourseNode(Main.curriculumList.get(student.getDepartment()).get(i),true));
							student.setTakenCourses(studentTakenCourses);
						}
					}
					
					Main.studentList.put(student.getID(), student);
					Helper.showMessage("success");
					
					fld_addStdName.setText("");
					fld_addStdSurname.setText("");
					fld_addStdAdvisor.setText("");
					fld_addStdClass.setText("");
					fld_addStdDepartment.setText("");
					fld_addStdFaculty.setText("");
					fld_addStdID.setText("");
				}
				else {
					Helper.showMessage("fill");
				}
				updateStudentsTable();		
			}

			
		});
		btn_loggedAddStudent.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btn_loggedAddStudent.setBounds(695, 295, 204, 23);
		pnl_stdMan.add(btn_loggedAddStudent);
		
		JButton btn_loggedAdminDelID = new JButton("Delete Student");
		btn_loggedAdminDelID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fld_loggedAdminDelID.getText().length() != 0) {
					if(Main.studentList.get(fld_loggedAdminDelID.getText()) != null) {
						if(Helper.confirm("sure")) {
							Main.studentList.remove(fld_loggedAdminDelID.getText(),Main.studentList.get(fld_loggedAdminDelID.getText()));
							updateStudentsTable();
							Helper.showMessage("success");
							fld_loggedAdminDelID.setText("");
						}
						
					}
					else {
						Helper.showMessage("error");
					}
				}
				else {
					Helper.showMessage("fill");
				}
				
			}
		});
		btn_loggedAdminDelID.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btn_loggedAdminDelID.setBounds(695, 395, 204, 23);
		pnl_stdMan.add(btn_loggedAdminDelID);
		
		
		
		JPanel pnl_InsMan = new JPanel();
		tabbedPane.addTab("Instructor Management", null, pnl_InsMan, null);
		pnl_InsMan.setLayout(null);
		
		JLabel lbl_loggedAdminName2 = new JLabel("Name");
		lbl_loggedAdminName2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminName2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminName2.setBounds(695, 11, 204, 20);
		pnl_InsMan.add(lbl_loggedAdminName2);
		
		fld_addInsName = new JTextField();
		fld_addInsName.setColumns(10);
		fld_addInsName.setBounds(695, 31, 204, 20);
		pnl_InsMan.add(fld_addInsName);
		
		JLabel lbl_loggedAdminSurname2 = new JLabel("Surname");
		lbl_loggedAdminSurname2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminSurname2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminSurname2.setBounds(695, 51, 204, 20);
		pnl_InsMan.add(lbl_loggedAdminSurname2);
		
		fld_addInsSurname = new JTextField();
		fld_addInsSurname.setColumns(10);
		fld_addInsSurname.setBounds(695, 72, 204, 20);
		pnl_InsMan.add(fld_addInsSurname);
		
		JLabel lbl_loggedAdminID2 = new JLabel("ID");
		lbl_loggedAdminID2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminID2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminID2.setBounds(695, 94, 204, 20);
		pnl_InsMan.add(lbl_loggedAdminID2);
		
		fld_addInsID = new JTextField();
		fld_addInsID.setColumns(10);
		fld_addInsID.setBounds(695, 113, 204, 20);
		pnl_InsMan.add(fld_addInsID);
		
		fld_addInsFaculty = new JTextField();
		fld_addInsFaculty.setColumns(10);
		fld_addInsFaculty.setBounds(695, 158, 204, 20);
		pnl_InsMan.add(fld_addInsFaculty);
		
		JLabel lbl_loggedAdminFaculty2 = new JLabel("Faculty");
		lbl_loggedAdminFaculty2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminFaculty2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminFaculty2.setBounds(695, 138, 204, 20);
		pnl_InsMan.add(lbl_loggedAdminFaculty2);
		
		JLabel lbl_loggedAdminDepartment2 = new JLabel("Department");
		lbl_loggedAdminDepartment2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminDepartment2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminDepartment2.setBounds(695, 179, 204, 20);
		pnl_InsMan.add(lbl_loggedAdminDepartment2);
		
		fld_addInsDepartment = new JTextField();
		fld_addInsDepartment.setColumns(10);
		fld_addInsDepartment.setBounds(695, 199, 204, 20);
		pnl_InsMan.add(fld_addInsDepartment);
		
		JLabel lbl_loggedAdminAdvisor2 = new JLabel("Is Advisor ?");
		lbl_loggedAdminAdvisor2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminAdvisor2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminAdvisor2.setBounds(695, 219, 204, 20);
		pnl_InsMan.add(lbl_loggedAdminAdvisor2);
		
		JRadioButton rb_isAdvisorTrue = new JRadioButton("True");
		rb_isAdvisorTrue.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		rb_isAdvisorTrue.setBounds(691, 238, 72, 23);
		pnl_InsMan.add(rb_isAdvisorTrue);
		
		JRadioButton rb_isAdvisorFalse = new JRadioButton("False");
		rb_isAdvisorFalse.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		rb_isAdvisorFalse.setBounds(794, 238, 109, 23);
		pnl_InsMan.add(rb_isAdvisorFalse);
		
		rb_isAdvisorTrue.setActionCommand("True");
		rb_isAdvisorFalse.setActionCommand("False");
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rb_isAdvisorTrue);
		bg1.add(rb_isAdvisorFalse);
		
		JButton btn_addNewInstructor = new JButton("Add New Instructor");
		btn_addNewInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_addInsName.getText().length() != 0 && fld_addInsSurname.getText().length() != 0 && fld_addInsID.getText().length()
						!= 0 && fld_addInsFaculty.getText().length() != 0 && fld_addInsDepartment.getText().length() != 0 &&
						bg1.getSelection() != null) {
					if(bg1.getSelection().getActionCommand().equals("True")) {
						Instructor instructor = new Instructor(fld_addInsName.getText(), fld_addInsSurname.getText(), fld_addInsID.getText(),
								fld_addInsFaculty.getText(), fld_addInsDepartment.getText(), true);
						
						Main.instructorList.put(instructor.getID(), instructor);
						Main.setInstructorsTaughtCourses();
						Helper.showMessage("success");
					}else if (bg1.getSelection().getActionCommand().equals("False")) {
						Instructor instructor = new Instructor(fld_addInsName.getText(), fld_addInsSurname.getText(), fld_addInsID.getText(),
								fld_addInsFaculty.getText(), fld_addInsDepartment.getText(), false);
						
						Main.instructorList.put(instructor.getID(), instructor);
						Main.setInstructorsTaughtCourses();
						Helper.showMessage("success");
					}
				}
				else {
					Helper.showMessage("fill");
				}
				
				fld_addInsName.setText("");
				fld_addInsSurname.setText("");
				bg1.clearSelection();
				fld_addInsDepartment.setText("");
				fld_addInsFaculty.setText("");
				fld_addInsID.setText("");
				updateInstructorTable();
			}

			
		});
		
		btn_addNewInstructor.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btn_addNewInstructor.setBounds(691, 268, 204, 23);
		pnl_InsMan.add(btn_addNewInstructor);
		
		JLabel lbl_loggedAdminDelID2 = new JLabel("ID");
		lbl_loggedAdminDelID2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminDelID2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminDelID2.setBounds(695, 348, 204, 20);
		pnl_InsMan.add(lbl_loggedAdminDelID2);
		
		fld_delInsID = new JTextField();
		fld_delInsID.setColumns(10);
		fld_delInsID.setBounds(695, 368, 204, 20);
		pnl_InsMan.add(fld_delInsID);
		
		JButton btn_delInstructor = new JButton("Delete Instructor");
		btn_delInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_delInsID.getText().length() != 0) {
					if(Main.instructorList.get(fld_delInsID.getText()) != null) {
						if(Helper.confirm("sure")) {
							Main.instructorList.remove(fld_delInsID.getText(), Main.instructorList.get(fld_delInsID.getText() ));
							updateInstructorTable();
							Helper.showMessage("success");
							fld_delInsID.setText("");
						}
					}
					else {
						Helper.showMessage("error");
					}
				}else {
					Helper.showMessage("fill");
				}
			}
		});
		btn_delInstructor.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btn_delInstructor.setBounds(695, 395, 204, 23);
		pnl_InsMan.add(btn_delInstructor);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 675, 407);
		pnl_InsMan.add(scrollPane_1);
		
		
		
		JPanel pnl_courseMan = new JPanel();
		tabbedPane.addTab("Course Management", null, pnl_courseMan, null);
		pnl_courseMan.setLayout(null);
		
		JLabel lbl_loggedAdminCode = new JLabel("Course Code");
		lbl_loggedAdminCode.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminCode.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminCode.setBounds(695, 11, 204, 20);
		pnl_courseMan.add(lbl_loggedAdminCode);
		
		fld_addCourseCode = new JTextField();
		fld_addCourseCode.setColumns(10);
		fld_addCourseCode.setBounds(695, 31, 204, 20);
		pnl_courseMan.add(fld_addCourseCode);
		
		JLabel lbl_loggedAdminCName = new JLabel("Course Name");
		lbl_loggedAdminCName.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminCName.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminCName.setBounds(695, 51, 204, 20);
		pnl_courseMan.add(lbl_loggedAdminCName);
		
		fld_addCourseName = new JTextField();
		fld_addCourseName.setColumns(10);
		fld_addCourseName.setBounds(695, 72, 204, 20);
		pnl_courseMan.add(fld_addCourseName);
		
		JLabel lbl_loggedAdminCredit = new JLabel("Credit");
		lbl_loggedAdminCredit.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminCredit.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminCredit.setBounds(695, 94, 204, 20);
		pnl_courseMan.add(lbl_loggedAdminCredit);
		
		fld_addCourseCredit = new JTextField();
		fld_addCourseCredit.setColumns(10);
		fld_addCourseCredit.setBounds(695, 113, 204, 20);
		pnl_courseMan.add(fld_addCourseCredit);
		
		JLabel lbl_loggedAdminSemester = new JLabel("Semester");
		lbl_loggedAdminSemester.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminSemester.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminSemester.setBounds(695, 134, 204, 20);
		pnl_courseMan.add(lbl_loggedAdminSemester);
		
		fld_addCourseSemester = new JTextField();
		fld_addCourseSemester.setColumns(10);
		fld_addCourseSemester.setBounds(695, 154, 204, 20);
		pnl_courseMan.add(fld_addCourseSemester);
		
		JButton btn_loggedAdminAddC = new JButton("Add Course");
		btn_loggedAdminAddC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fld_addCourseCode.getText().length() != 0 && fld_addCourseName.getText().length() != 0 
						&& fld_addCourseCredit.getText().length() != 0 && fld_addCourseSemester.getText().length() != 0) {
					Course course = new Course(fld_addCourseCode.getText(), fld_addCourseName.getText(), 
							Integer.parseInt(fld_addCourseCredit.getText()), Integer.parseInt(fld_addCourseSemester.getText()));	
					Main.courseList.put(course.getCourseCode(), course);
					Helper.showMessage("success");
				}else {
					Helper.showMessage("fill");
				}
				fld_addCourseCode.setText("");
				fld_addCourseName.setText("");
				fld_addCourseCredit.setText("");
				fld_addCourseSemester.setText("");
				updateCourseTable();
			}

			
		});
		btn_loggedAdminAddC.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btn_loggedAdminAddC.setBounds(695, 185, 204, 23);
		pnl_courseMan.add(btn_loggedAdminAddC);
		
		JLabel lbl_loggedAdminDelCode = new JLabel("Course Code");
		lbl_loggedAdminDelCode.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_loggedAdminDelCode.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lbl_loggedAdminDelCode.setBounds(695, 348, 204, 20);
		pnl_courseMan.add(lbl_loggedAdminDelCode);
		
		fld_delCourseCode = new JTextField();
		fld_delCourseCode.setColumns(10);
		fld_delCourseCode.setBounds(695, 368, 204, 20);
		pnl_courseMan.add(fld_delCourseCode);
		
		JButton btn_loggedAdminDelCode = new JButton("Delete Course");
		btn_loggedAdminDelCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_delCourseCode.getText().length() != 0) {
					if(Main.courseList.get(fld_delCourseCode.getText()) != null ) {
						if(Helper.confirm("sure")) {
							Main.courseList.remove(fld_delCourseCode.getText() , Main.courseList.get(fld_delCourseCode.getText()));
							updateCourseTable();
							Helper.showMessage("success");
							fld_delCourseCode.setText("");
						}		
						
					}else {
						Helper.showMessage("error");
					}
				}
				else {
					Helper.showMessage("fill");
				}
				
			}
		});
		btn_loggedAdminDelCode.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btn_loggedAdminDelCode.setBounds(695, 395, 204, 23);
		pnl_courseMan.add(btn_loggedAdminDelCode);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 681, 407);
		pnl_courseMan.add(scrollPane_2);
		
		Object[][] courses = new Object[Main.courseList.values().size()][4];
		String[] columnsCourse = new String[] {"Course Code","Course Name","Credit","Semester"};
		calculateCourses(courses);
		
		
		tbl_courses = new JTable(courses,columnsCourse);
		scrollPane_2.setViewportView(tbl_courses);
		tbl_courses.setCellSelectionEnabled(true);
		tbl_courses.setBackground(Color.WHITE);
		
		String[] columnsInstructor = new String[] {"Name","Surname","ID","Faculty","Department","IsAdvisor"};
		Object[][] instructors = new Object[Main.instructorList.values().size()][6];
		calculateInstructors(instructors);
		
		tbl_instructors = new JTable(instructors,columnsInstructor);
		scrollPane_1.setViewportView(tbl_instructors);
		tbl_instructors.setCellSelectionEnabled(true);
		tbl_instructors.setBackground(Color.WHITE);
		
		TableColumnModel columnModelInstructor = tbl_instructors.getColumnModel();
		columnModelInstructor.getColumn(0).setPreferredWidth(20);
		columnModelInstructor.getColumn(1).setPreferredWidth(20);
		columnModelInstructor.getColumn(2).setPreferredWidth(10);
	}
	
	private void calculateInstructors(Object[][] instructors) {
		int i = 0;
		
		for(Instructor instructor : Main.instructorList.values()) {
			instructors[i][0] = instructor.getName();
			instructors[i][1] = instructor.getSurname();
			instructors[i][2] = instructor.getID();
			instructors[i][3] = instructor.getFaculty();
			instructors[i][4] = instructor.getDepartment();
			instructors[i][5] = instructor.isAdvisor();
			i++;
		}
	}

	private void calculateStudents(Object[][] students) {
		int i = 0;
		
		for(Student student : Main.studentList.values()) {
			students[i][0] = student.getName();
			students[i][1] = student.getSurname();
			students[i][2] = student.getID();
			students[i][3] = student.getClassLevel();
			students[i][4] = student.getFaculty();
			students[i][5] = student.getDepartment();
			students[i][6] = student.getAdvisor().getID();
			i++;
		}
	}
	
	private void updateStudentsTable() {
		
		Object[][] students = new Object[Main.studentList.values().size()][7];
		String[] columns = new String[] {"Name","Surname","ID","Class","Faculty","Department","Advisor ID"};
		
		calculateStudents(students);
		JTable testTable = new JTable(students, columns);
		TableModel tablemodel = testTable.getModel();
		tbl_student.setModel(tablemodel);
		
		TableColumnModel columnModel = tbl_student.getColumnModel();
		columnModel.getColumn(2).setPreferredWidth(5);
		columnModel.getColumn(3).setPreferredWidth(5);
		columnModel.getColumn(6).setPreferredWidth(10);
	}
	
	private void updateInstructorTable() {
		Object[][] instructors = new Object[Main.instructorList.values().size()][6];
		String[] columns = new String[] {"Name","Surname","ID","Faculty","Department","IsAdvisor"};
		
		calculateInstructors(instructors);
		
		JTable testTable = new JTable(instructors, columns);
		tbl_instructors.setModel(testTable.getModel());
		
		TableColumnModel columnModel = tbl_instructors.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(20);
		columnModel.getColumn(2).setPreferredWidth(10);
	}
	
	private void updateCourseTable() {
		Object[][] courses = new Object[Main.courseList.values().size()][4];
		String[] columns = new String[] {"Course Code","Course Name","Credit","Semester"};
		calculateCourses(courses);
		tbl_courses.setModel(new JTable(courses, columns).getModel());
	}

	private void calculateCourses(Object[][] courses) {
		int i = 0;
		for(Course course : Main.courseList.values()) {
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
			i++;
		}
		
	}
}
