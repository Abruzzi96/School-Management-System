package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import Item.Course;
import Operations.Main;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class InstructorGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					InstructorGUI frame = new InstructorGUI(args[0]);
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
	public InstructorGUI(String ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
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
		
		JLabel lblNewLabel_2_1 = new JLabel(Main.instructorList.get(ID).getName());
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(110, 79, 814, 36);
		contentPane.add(lblNewLabel_2_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 110, 914, 440);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Information", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(InstructorGUI.class.getResource("/Args/InstructorInfo.png")));
		lblNewLabel_3.setBounds(10, 11, 604, 390);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4.setBounds(668, 10, 241, 34);
		panel.add(lblNewLabel_4);
		
		JLabel lbl_InsName = new JLabel(Main.instructorList.get(ID).getName());
		lbl_InsName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_InsName.setBounds(668, 35, 241, 34);
		panel.add(lbl_InsName);
		
		JLabel lblNewLabel_4_2 = new JLabel("Surname");
		lblNewLabel_4_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_2.setBounds(668, 65, 241, 34);
		panel.add(lblNewLabel_4_2);
		
		JLabel lbl_InsSurname = new JLabel(Main.instructorList.get(ID).getSurname());
		lbl_InsSurname.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_InsSurname.setBounds(668, 90, 241, 34);
		panel.add(lbl_InsSurname);
		
		JLabel lblNewLabel_4_3 = new JLabel("ID");
		lblNewLabel_4_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_3.setBounds(668, 120, 241, 34);
		panel.add(lblNewLabel_4_3);
		
		JLabel lbl_InsID = new JLabel(Main.instructorList.get(ID).getID());
		lbl_InsID.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_InsID.setBounds(668, 145, 241, 34);
		panel.add(lbl_InsID);
		
		JLabel lblNewLabel_4_4 = new JLabel("Faculty");
		lblNewLabel_4_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_4.setBounds(668, 175, 241, 34);
		panel.add(lblNewLabel_4_4);
		
		JLabel lbl_InsFaculty = new JLabel(Main.instructorList.get(ID).getFaculty());
		lbl_InsFaculty.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_InsFaculty.setBounds(668, 200, 241, 34);
		panel.add(lbl_InsFaculty);
		
		JLabel lblNewLabel_4_5 = new JLabel("Department");
		lblNewLabel_4_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_5.setBounds(668, 230, 241, 34);
		panel.add(lblNewLabel_4_5);
		
		JLabel lbl_InsDepartment = new JLabel(Main.instructorList.get(ID).getDepartment());
		lbl_InsDepartment.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_InsDepartment.setBounds(668, 255, 241, 34);
		panel.add(lbl_InsDepartment);
		
		JLabel lblNewLabel_4_6 = new JLabel("Is Advisor ?");
		lblNewLabel_4_6.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_4_6.setBounds(668, 285, 241, 34);
		panel.add(lblNewLabel_4_6);
		
		JLabel lbl_InsIsAdvisor = new JLabel(Main.instructorList.get(ID).isAdvisor() ? "True":"False");
		lbl_InsIsAdvisor.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_InsIsAdvisor.setBounds(668, 305, 241, 34);
		panel.add(lbl_InsIsAdvisor);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(656, 11, 2, 390);
		panel.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Taught Courses", null, panel_1, null);
		panel_1.setLayout(null);
		
		String[] columns = new String[]  {"Course Code", "Course Name", "Credit", "Semester"};
		Object[][] courses = new Object[Main.instructorList.get(ID).getTaughtCourses().size()][4];
		calculateCourses(courses, ID);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 889, 390);
		panel_1.add(scrollPane);
		
		
		
		table = new JTable(courses,columns);
		scrollPane.setViewportView(table);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(20);
		columnModel.getColumn(2).setPreferredWidth(10);
	}

	private void calculateCourses(Object[][] courses, String iD) {
		int i = 0;
		for(Course course : Main.instructorList.get(iD).getTaughtCourses().values() ) {
			courses[i][0] = course.getCourseCode();
			courses[i][1] = course.getCourseName();
			courses[i][2] = course.getCredit();
			courses[i][3] = course.getSemester();
			i++;
		}
	}
}
