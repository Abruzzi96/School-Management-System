package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Operations.Main;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField fld_loginID;
	private JTextField fld_loginPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main.main(args);
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel login_title = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		login_title.setForeground(new Color(0, 0, 0));
		login_title.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		login_title.setHorizontalAlignment(SwingConstants.CENTER);
		login_title.setBounds(10, 11, 664, 41);
		contentPane.add(login_title);
		
		JLabel login_logo = new JLabel("");
		login_logo.setIcon(new ImageIcon(LoginGUI.class.getResource("/Args/loginLogo.png")));
		login_logo.setHorizontalAlignment(SwingConstants.CENTER);
		login_logo.setForeground(Color.BLACK);
		login_logo.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		login_logo.setBounds(10, 63, 664, 300);
		contentPane.add(login_logo);
		
		JLabel lbl_loginID = new JLabel("ID:");
		lbl_loginID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_loginID.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lbl_loginID.setBounds(127, 374, 96, 27);
		contentPane.add(lbl_loginID);
		
		JLabel lbl_loginPass = new JLabel("Password:");
		lbl_loginPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_loginPass.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lbl_loginPass.setBounds(105, 415, 118, 27);
		contentPane.add(lbl_loginPass);
		
		fld_loginID = new JTextField();
		fld_loginID.setBounds(233, 377, 237, 27);
		contentPane.add(fld_loginID);
		fld_loginID.setColumns(10);
		
		fld_loginPass = new JTextField();
		fld_loginPass.setColumns(10);
		fld_loginPass.setBounds(233, 416, 237, 27);
		contentPane.add(fld_loginPass);
		
		JRadioButton btn_loginStudent = new JRadioButton("Student Login");
		btn_loginStudent.setActionCommand("Student");
		btn_loginStudent.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btn_loginStudent.setBackground(new Color(255, 255, 255));
		btn_loginStudent.setBounds(140, 455, 123, 23);
		contentPane.add(btn_loginStudent);
		
		JRadioButton btn_loginTeacher = new JRadioButton("Teacher Login");
		btn_loginTeacher.setActionCommand("Teacher");
		btn_loginTeacher.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btn_loginTeacher.setBackground(new Color(255, 255, 255));
		btn_loginTeacher.setBounds(294, 455, 129, 23);
		contentPane.add(btn_loginTeacher);
		
		JRadioButton btn_loginManager = new JRadioButton("Manager Login");
		btn_loginManager.setActionCommand("Manager");
		btn_loginManager.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btn_loginManager.setBackground(new Color(255, 255, 255));
		btn_loginManager.setBounds(453, 455, 129, 23);
		contentPane.add(btn_loginManager);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(btn_loginManager);
		buttonGroup.add(btn_loginTeacher);
		buttonGroup.add(btn_loginStudent);
		
		JButton btn_login = new JButton("LOGIN");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(buttonGroup.getSelection().getActionCommand().equals("Manager")) {
					String ID = fld_loginID.getText();
					String passWord = "m"+ID;
					
					if(Main.managerList.containsKey(ID) && passWord.equals(String.valueOf(fld_loginPass.getText()))) {
						Helper.showMessage("girisok");
						LoginGUI.getFrames()[0].dispose();
						String[] array = new String[1];
						array[0] = Main.managerList.get(ID).getName();
						AdminGUI.main(array);
					}
					else {
						Helper.showMessage("wrong");
					}
				}
				else if(buttonGroup.getSelection().getActionCommand().equals("Teacher")) {
					String ID = fld_loginID.getText();
					String passWord = "t"+ID;
					
					if(Main.instructorList.containsKey(ID) && passWord.equals(String.valueOf(fld_loginPass.getText()))) {
						Helper.showMessage("girisok");
						LoginGUI.getFrames()[0].dispose();
						String[] array = new String[1];
						array[0] = Main.instructorList.get(ID).getID();
						InstructorGUI.main(array);
					}
					else {
						Helper.showMessage("wrong");
					}
				}
				else if(buttonGroup.getSelection().getActionCommand().equals("Student")){
					String ID = fld_loginID.getText();
					String passWord = "s"+ID;
					
					if(Main.studentList.containsKey(ID) && passWord.equals(String.valueOf(fld_loginPass.getText()))) {
						Helper.showMessage("girisok");
						LoginGUI.getFrames()[0].dispose();
						String[] array = new String[1];
						array[0] = Main.studentList.get(ID).getID();
						StudentGUI.main(array);
					}
					else {
						Helper.showMessage("wrong");
					}
				}
			}
		});
		btn_login.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btn_login.setBackground(new Color(255, 255, 255));
		btn_login.setBounds(304, 486, 89, 23);
		contentPane.add(btn_login);
	}
}
