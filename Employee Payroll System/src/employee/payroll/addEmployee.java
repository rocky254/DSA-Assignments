package employee.payroll;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class addEmployee extends JFrame {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_firstname;
	private JTextField txt_surname;
	private JTextField txt_dob;
	private JTextField txt_email;
	private JTextField txt_tel;
	private JTextField txt_add1;
	private JTextField txt_add2;
	private JTextField txt_datehired;
	private JTextField txt_salary;
	private JTextField txt_title;
	private JTextField txt_status;
	private JTextField txt_designation;
	private JTextField txt_department;
	private JTextField txt_post;
	private JTextField txt_apt;
	private JLabel lblGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addEmployee frame = new addEmployee();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					int w = frame.getSize().width;
					int h = frame.getSize().height;
					int x = (dim.width-w)/2;
					int y = (dim.height-h)/2;
					frame.setLocation(x,y);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Nimbus".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
		        } catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(addEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addEmployee() {
		conn = db.java_db();
		setTitle("Add Employees");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 879, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		txt_id = new JTextField();
		txt_id.setEditable(false);
		txt_id.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_id.setBounds(123, 79, 181, 30);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_firstname = new JTextField();
		txt_firstname.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_firstname.setColumns(10);
		txt_firstname.setBounds(123, 113, 181, 30);
		contentPane.add(txt_firstname);
		
		txt_surname = new JTextField();
		txt_surname.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_surname.setColumns(10);
		txt_surname.setBounds(123, 147, 181, 30);
		contentPane.add(txt_surname);
		
		txt_dob = new JTextField();
		txt_dob.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_dob.setColumns(10);
		txt_dob.setBounds(123, 181, 181, 30);
		contentPane.add(txt_dob);
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_email.setColumns(10);
		txt_email.setBounds(123, 249, 181, 30);
		contentPane.add(txt_email);
		
		txt_tel = new JTextField();
		txt_tel.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_tel.setColumns(10);
		txt_tel.setBounds(123, 283, 181, 30);
		contentPane.add(txt_tel);
		
		txt_add1 = new JTextField();
		txt_add1.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_add1.setColumns(10);
		txt_add1.setBounds(123, 317, 181, 30);
		contentPane.add(txt_add1);
		
		txt_add2 = new JTextField();
		txt_add2.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_add2.setColumns(10);
		txt_add2.setBounds(123, 351, 181, 30);
		contentPane.add(txt_add2);
		
		txt_datehired = new JTextField();
		txt_datehired.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_datehired.setColumns(10);
		txt_datehired.setBounds(448, 215, 181, 30);
		contentPane.add(txt_datehired);
		
		txt_salary = new JTextField();
		txt_salary.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_salary.setColumns(10);
		txt_salary.setBounds(448, 249, 181, 30);
		contentPane.add(txt_salary);
		
		txt_title = new JTextField();
		txt_title.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_title.setColumns(10);
		txt_title.setBounds(448, 283, 181, 30);
		contentPane.add(txt_title);
		
		txt_status = new JTextField();
		txt_status.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_status.setColumns(10);
		txt_status.setBounds(448, 317, 181, 30);
		contentPane.add(txt_status);
		
		txt_designation = new JTextField();
		txt_designation.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_designation.setColumns(10);
		txt_designation.setBounds(448, 181, 181, 30);
		contentPane.add(txt_designation);
		
		txt_department = new JTextField();
		txt_department.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_department.setColumns(10);
		txt_department.setBounds(448, 147, 181, 30);
		contentPane.add(txt_department);
		
		txt_post = new JTextField();
		txt_post.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_post.setColumns(10);
		txt_post.setBounds(448, 113, 181, 30);
		contentPane.add(txt_post);
		
		txt_apt = new JTextField();
		txt_apt.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_apt.setColumns(10);
		txt_apt.setBounds(448, 79, 181, 30);
		contentPane.add(txt_apt);
		
		JLabel lblNewLabel = new JLabel("Employee ID:");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 81, 103, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Georgia", Font.BOLD, 14));
		lblFirstName.setBounds(10, 116, 103, 18);
		contentPane.add(lblFirstName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Georgia", Font.BOLD, 14));
		lblSurname.setBounds(10, 150, 103, 18);
		contentPane.add(lblSurname);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDateOfBirth.setBounds(10, 184, 103, 18);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Georgia", Font.BOLD, 14));
		lblEmail.setBounds(10, 252, 103, 18);
		contentPane.add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Georgia", Font.BOLD, 14));
		lblContact.setBounds(10, 286, 103, 18);
		contentPane.add(lblContact);
		
		JLabel lblAddress = new JLabel("Address 1:");
		lblAddress.setFont(new Font("Georgia", Font.BOLD, 14));
		lblAddress.setBounds(10, 320, 103, 18);
		contentPane.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address 2:");
		lblAddress_1.setFont(new Font("Georgia", Font.BOLD, 14));
		lblAddress_1.setBounds(10, 354, 103, 18);
		contentPane.add(lblAddress_1);
		
		JLabel lblApthouseNo = new JLabel("Apt./House No. :");
		lblApthouseNo.setFont(new Font("Georgia", Font.BOLD, 14));
		lblApthouseNo.setBounds(320, 81, 128, 18);
		contentPane.add(lblApthouseNo);
		
		JLabel lblPostCode = new JLabel("Post Code:");
		lblPostCode.setFont(new Font("Georgia", Font.BOLD, 14));
		lblPostCode.setBounds(320, 116, 118, 18);
		contentPane.add(lblPostCode);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDepartment.setBounds(320, 150, 118, 18);
		contentPane.add(lblDepartment);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDesignation.setBounds(320, 184, 118, 18);
		contentPane.add(lblDesignation);
		
		JLabel lblDateHired = new JLabel("Date Hired:");
		lblDateHired.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDateHired.setBounds(320, 218, 118, 18);
		contentPane.add(lblDateHired);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary:");
		lblBasicSalary.setFont(new Font("Georgia", Font.BOLD, 14));
		lblBasicSalary.setBounds(320, 252, 118, 18);
		contentPane.add(lblBasicSalary);
		
		JLabel lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setFont(new Font("Georgia", Font.BOLD, 14));
		lblJobTitle.setBounds(320, 286, 118, 18);
		contentPane.add(lblJobTitle);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Georgia", Font.BOLD, 14));
		lblStatus.setBounds(320, 320, 118, 18);
		contentPane.add(lblStatus);
		
		JButton btnAdd = new JButton("ADD RECORD");
		btnAdd.setIcon(new ImageIcon(addEmployee.class.getResource("/employee/payroll/images/attach.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this Record?","Add Record",JOptionPane.YES_NO_OPTION);
				if(x==0) {
				try {
					String sql = "INSERT INTO Staff_information (first_name, surname, DOB, Email, Telephone, Address1, Department, Image, Salary, Gender, Address2, Post_code, Designation, Status, Job_title, Apartment, Date_hired) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pst = conn.prepareStatement(sql);
					pst.setString(1, txt_firstname.getText());
					pst.setString(2, txt_surname.getText());
					pst.setString(3, txt_dob.getText());
					pst.setString(4, txt_email.getText());
					pst.setString(5, txt_tel.getText());
					pst.setString(6, txt_add1.getText());
					pst.setString(7, txt_department.getText());
					pst.setBytes(8, person_image);
					pst.setString(9, txt_salary.getText());
					pst.setString(10, gender);
					pst.setString(11, txt_add2.getText());
					pst.setString(12, txt_post.getText());
					pst.setString(13, txt_designation.getText());
					pst.setString(14, txt_status.getText());
					pst.setString(15, txt_title.getText());
					pst.setString(16, txt_apt.getText());
					pst.setString(17, txt_datehired.getText());
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Saved Successfully");
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
					
				}
				
				try {
					String sq = "SELECT * FROM Staff_information WHERE (id) NOT IN (SELECT id FROM Users)";
					pst = conn.prepareStatement(sq);
					rs = pst.executeQuery();
					while(rs.next()) {
						String add1 = rs.getString("id");
						String add2 = rs.getString("first_name");
						String add3 = rs.getString("DOB");
						String result = add3.replace("/","");
						String add4 = rs.getString("Department");
						
						String sql = "INSERT INTO Users (Division, Username, Password, emp_id) VALUES ('"+add4+"','"+add2+"','"+result+"','"+add1+"')";
						pst = conn.prepareStatement(sql);
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "User account has been Created Successfully:" + "\n" + "Username: "+ add2 + "\n" + "Password: "+ result);
						
					}
					
					
					
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
					
				}
				
				finally {
					try {
						rs.close();
						pst.close();
						
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			
			}
			else {
				JOptionPane.showMessageDialog(null,"Record not Inserted into Database");
			}
				
			}
		});
		btnAdd.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnAdd.setBounds(98, 385, 189, 43);
		contentPane.add(btnAdd);
		
		lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Georgia", Font.BOLD, 14));
		lblGender.setBounds(10, 220, 103, 18);
		contentPane.add(lblGender);
		
		JRadioButton radio_male = new JRadioButton("Male");	
		JRadioButton radio_female = new JRadioButton("Female");
		radio_male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender = "Male";
				radio_male.setSelected(true);
				radio_female.setSelected(false);
			}
		});
		radio_male.setFont(new Font("Georgia", Font.PLAIN, 14));
		radio_male.setBounds(123, 219, 74, 23);
		contentPane.add(radio_male);
		

		radio_female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender = "Female";
				radio_female.setSelected(true);
				radio_male.setSelected(false);
			}
		});
		radio_female.setFont(new Font("Georgia", Font.PLAIN, 14));
		radio_female.setBounds(230, 219, 74, 23);
		contentPane.add(radio_female);
		
		JLabel img = new JLabel("");
		img.setBackground(Color.WHITE);
		img.setBounds(661, 79, 183, 172);
		contentPane.add(img);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setIcon(new ImageIcon(addEmployee.class.getResource("/employee/payroll/images/erase-128.png")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_id.setText("");
				txt_firstname.setText("");
				txt_surname.setText("");
				txt_tel.setText("");
				txt_dob.setText("");
				txt_email.setText("");
				txt_add1.setText("");
				txt_department.setText("");
				txt_status.setText("");
				txt_salary.setText("");
				txt_add2.setText("");
				txt_post.setText("");
				txt_title.setText("");
				txt_apt.setText("");
				txt_datehired.setText("");
				txt_designation.setText("");
				txt_search.setText("");
				radio_male.setSelected(false);
				radio_female.setSelected(false);
				img.setIcon(null);
			}
		});
		btnClear.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnClear.setBounds(302, 385, 136, 43);
		contentPane.add(btnClear);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		desktopPane.setBounds(651, 265, 191, -185);
		contentPane.add(desktopPane);
		
		JButton btnAttachImage = new JButton("ATTACH IMAGE");
		btnAttachImage.setIcon(new ImageIcon(addEmployee.class.getResource("/employee/payroll/images/attachment-512.png")));
		btnAttachImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				
				filename = f.getAbsolutePath();
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT));
				
				img.setIcon(imageIcon);
				
				try {
					File image = new File(filename);
					FileInputStream fix = new FileInputStream(image);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					
					for (int number;(number = fix.read(buf))!= -1;) {
						bos.write(buf,0,number);
					}
					
					person_image = bos.toByteArray();
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnAttachImage.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnAttachImage.setBounds(455, 385, 174, 43);
		contentPane.add(btnAttachImage);
		
		JLabel lblPassportPhoto = new JLabel("Passport Photo:");
		lblPassportPhoto.setFont(new Font("Georgia", Font.BOLD, 14));
		lblPassportPhoto.setBounds(661, 51, 118, 18);
		contentPane.add(lblPassportPhoto);
		
		JLabel lblSearch = new JLabel("Search by ID:");
		lblSearch.setFont(new Font("Georgia", Font.BOLD, 14));
		lblSearch.setBounds(10, 24, 103, 18);
		contentPane.add(lblSearch);
		
		txt_search = new JTextField();
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String sql = "SELECT * FROM Staff_information where id=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, txt_search.getText());
					rs = pst.executeQuery();
					
					String add1 = rs.getString("id");
					txt_id.setText(add1);
					
					String add2 = rs.getString("first_name");
					txt_firstname.setText(add2);
					
					String add3 = rs.getString("surname");
					txt_surname.setText(add3);
					
					String add4 = rs.getString("DOB");
					txt_dob.setText(add4);
					
					String add5 = rs.getString("Email");
					txt_email.setText(add5);
					
					String add6 = rs.getString("Telephone");
					txt_tel.setText(add6);
					
					String add7 = rs.getString("Address1");
					txt_add1.setText(add7);
					
					String add8 = rs.getString("Department");
					txt_department.setText(add8);
					
					String add10 = rs.getString("Salary");
					txt_salary.setText(add10);
					
					String add11 = rs.getString("Address2");
					txt_add2.setText(add11);
					
					String add12 = rs.getString("Apartment");
					txt_apt.setText(add12);
					
					String add13 = rs.getString("Post_code");
					txt_post.setText(add13);
					
					String add14 = rs.getString("Status");
					txt_status.setText(add14);
					
					String add15 = rs.getString("Date_hired");
					txt_datehired.setText(add15);
					
					String add16 = rs.getString("job_title");
					txt_title.setText(add16);
					
					String add17 = rs.getString("Designation");
					txt_designation.setText(add17);
					
					String add18 = rs.getString("Gender");
					if(add18.equals("Male")) {
						radio_male.setSelected(true);
						radio_female.setSelected(false);
					}
					else {
						radio_female.setSelected(true);
						radio_male.setSelected(false);
					}
					
					byte[] image = rs.getBytes("Image");
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH));
					img.setIcon(imageIcon);
					
					
				}
				catch (Exception e) {
					
				}
				finally {
					try {
						rs.close();
						pst.close();
						
					}
					catch (Exception e) {
						
					}
				}
			}
		});
		txt_search.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_search.setColumns(10);
		txt_search.setBounds(123, 22, 506, 30);
		contentPane.add(txt_search);
		
		JButton btnDeleteRecord = new JButton("DELETE RECORD");
		btnDeleteRecord.setIcon(new ImageIcon(addEmployee.class.getResource("/employee/payroll/images/delete_16x16.gif")));
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action=JOptionPane.showConfirmDialog(null, "Do you really want to remove this?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
				if(action==0) {
					try {
						String sql = "DELETE FROM Staff_information WHERE id=?";
						pst = conn.prepareStatement(sql);
						pst.setString(1, txt_id.getText());
						pst.execute();
						
						JOptionPane.showMessageDialog(null, "Record Successfully Deleted");
						
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
						
					}
					finally {
						try {
							rs.close();
							pst.close();
						}
						catch (Exception e) {
							
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "That was Close!!!");
				}
			}
		});
		btnDeleteRecord.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnDeleteRecord.setBounds(98, 439, 189, 42);
		contentPane.add(btnDeleteRecord);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setIcon(new ImageIcon(addEmployee.class.getResource("/employee/payroll/images/update icon.png")));
		btnUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String val4 = txt_id.getText();
				int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this Record?","Update Record",JOptionPane.YES_NO_OPTION);
				if(x==0) {
				try {
					String val1 = txt_firstname.getText();
					String val2 = txt_surname.getText();
					String val3 = txt_dob.getText();
					String val5 = txt_email.getText();
					String val6 = txt_tel.getText();
					String val7 = txt_add1.getText();
					String val8 = txt_department.getText();
					String val9 = txt_add2.getText();
					String val10 = txt_apt.getText();
					String val11 = txt_post.getText();
					String val12 = txt_designation.getText();
					String val13 = txt_status.getText();
					String val14 = txt_salary.getText();
					String val15 = txt_title.getText();
					String val16 = txt_datehired.getText();
					
					String sql = "UPDATE Staff_information SET first_name = '"+val1+"', surname = '"+val2+"', DOB = '"+val3+"', Email = '"+val5+"', Telephone = '"+val6+"', Address1 = '"+val7+"', Department = '"+val8+"', Address2 = '"+val9+"', Apartment = '"+val10+"', Post_code = '"+val11+"', Designation = '"+val12+"', Status = '"+val13+"', Salary = '"+val14+"', job_title = '"+val15+"', date_hired = '"+val16+"', Gender = '"+gender+"' WHERE id = '"+val4+"'  ";
					pst = conn.prepareStatement(sql);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Record Updated");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
				try {
					File file = new File(filename);
					FileInputStream fis = new FileInputStream(file);
					byte [] image = new byte[(int) file.length()];
					fis.read(image);
					
					String sql = "UPDATE Staff_information SET image = ? WHERE id = '"+val4+"' ";
					pst = conn.prepareStatement(sql);
					pst.setBytes(1, image);
					pst.executeUpdate();
					pst.close();
					fis.close();
					
				}
				catch (Exception e) {
					//JOptionPane.showMessageDialog(null, e);
					
				}
				
				finally {
					try {
						rs.close();
						pst.close();
						
					}
					catch (Exception e) {
						
						
					}
				}
				}
				else {
					JOptionPane.showMessageDialog(null,"Record Updated in Database");
				}
			}
		});
		btnUpdate.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnUpdate.setBounds(302, 440, 136, 41);
		contentPane.add(btnUpdate);

	}
	
	private ImageIcon format = null;
	String filename = null;
	byte[] person_image = null;
	
	private String gender;
	private JTextField txt_search;
}
