package employee.payroll;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateSalary extends JFrame {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private JPanel contentPane;
	private JTextField txt_search;
	private JTextField txt_empid;
	private JTextField txt_firstname;
	private JTextField txt_surname;
	private JTextField txt_department;
	private JTextField txt_salary;
	private JTextField txt_dob;
	private JTextField txt_d1;
	private JTextField txt_d2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSalary frame = new UpdateSalary();
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
		            java.util.logging.Logger.getLogger(UpdateSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(UpdateSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(UpdateSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(UpdateSalary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateSalary() {
		setTitle("Salary Update");
		conn = db.java_db();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 763, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		txt_search = new JTextField();
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String sql = "SELECT * FROM Staff_information WHERE id=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, txt_search.getText());
					rs = pst.executeQuery();
					
					String add1 = rs.getString("id");
					txt_empid.setText(add1);
					
					String add2 = rs.getString("first_name");
					txt_firstname.setText(add2);
					
					String add3 = rs.getString("surname");
					txt_surname.setText(add3);
					
					String add4 = rs.getString("DOB");
					txt_dob.setText(add4);
					
					String add5 = rs.getString("Salary");
					txt_salary.setText(add5);
					
					String add6 = rs.getString("Department");
					txt_department.setText(add6);
				
					
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
		});
		txt_search.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_search.setColumns(10);
		txt_search.setBounds(123, 46, 583, 27);
		contentPane.add(txt_search);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setFont(new Font("Georgia", Font.BOLD, 14));
		lblEmployeeId.setBounds(10, 48, 103, 18);
		contentPane.add(lblEmployeeId);
		
		JLabel label = new JLabel("Employee ID:");
		label.setFont(new Font("Georgia", Font.BOLD, 14));
		label.setBounds(10, 112, 103, 18);
		contentPane.add(label);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Georgia", Font.BOLD, 14));
		lblFirstName.setBounds(10, 141, 103, 18);
		contentPane.add(lblFirstName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Georgia", Font.BOLD, 14));
		lblSurname.setBounds(10, 170, 103, 18);
		contentPane.add(lblSurname);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDateOfBirth.setBounds(364, 112, 103, 18);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary:");
		lblBasicSalary.setFont(new Font("Georgia", Font.BOLD, 14));
		lblBasicSalary.setBounds(364, 141, 103, 18);
		contentPane.add(lblBasicSalary);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDepartment.setBounds(364, 170, 103, 18);
		contentPane.add(lblDepartment);
		
		txt_empid = new JTextField();
		txt_empid.setEditable(false);
		txt_empid.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_empid.setColumns(10);
		txt_empid.setBounds(110, 112, 234, 27);
		contentPane.add(txt_empid);
		
		txt_firstname = new JTextField();
		txt_firstname.setEditable(false);
		txt_firstname.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_firstname.setColumns(10);
		txt_firstname.setBounds(110, 141, 234, 27);
		contentPane.add(txt_firstname);
		
		txt_surname = new JTextField();
		txt_surname.setEditable(false);
		txt_surname.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_surname.setColumns(10);
		txt_surname.setBounds(110, 170, 234, 27);
		contentPane.add(txt_surname);
		
		txt_department = new JTextField();
		txt_department.setEditable(false);
		txt_department.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_department.setColumns(10);
		txt_department.setBounds(472, 170, 234, 27);
		contentPane.add(txt_department);
		
		txt_salary = new JTextField();
		txt_salary.setEditable(false);
		txt_salary.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_salary.setColumns(10);
		txt_salary.setBounds(472, 141, 234, 27);
		contentPane.add(txt_salary);
		
		txt_dob = new JTextField();
		txt_dob.setEditable(false);
		txt_dob.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_dob.setColumns(10);
		txt_dob.setBounds(472, 112, 234, 27);
		contentPane.add(txt_dob);
		
		JRadioButton r_percentage = new JRadioButton("Percentage(%)");
		JRadioButton r_amount = new JRadioButton("Amount");
		r_percentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r_percentage.setSelected(true);
				r_amount.setSelected(false);
				txt_d2.setEnabled(false);
				txt_d1.setEditable(true);
				txt_d1.setEnabled(true);
				txt_d2.setText("");
			}
		});
		r_percentage.setFont(new Font("Georgia", Font.PLAIN, 14));
		r_percentage.setBounds(142, 239, 126, 23);
		contentPane.add(r_percentage);
		
		JLabel lblUpdateSalary = new JLabel("Update Salary by:");
		lblUpdateSalary.setFont(new Font("Georgia", Font.BOLD, 14));
		lblUpdateSalary.setBounds(10, 239, 139, 18);
		contentPane.add(lblUpdateSalary);
		

		r_amount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r_amount.setSelected(true);
				r_percentage.setSelected(false);
				txt_d1.setEnabled(false);
				txt_d2.setEditable(true);
				txt_d2.setEnabled(true);
				txt_d1.setText("");
			}
		});
		r_amount.setFont(new Font("Georgia", Font.PLAIN, 14));
		r_amount.setBounds(267, 239, 126, 23);
		contentPane.add(r_amount);
		
		JLabel lblPercentage = new JLabel("Percentage:");
		lblPercentage.setFont(new Font("Georgia", Font.BOLD, 14));
		lblPercentage.setBounds(10, 276, 103, 18);
		contentPane.add(lblPercentage);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Georgia", Font.BOLD, 14));
		lblAmount.setBounds(10, 305, 103, 18);
		contentPane.add(lblAmount);
		
		txt_d1 = new JTextField();
		txt_d1.setEditable(false);
		txt_d1.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_d1.setColumns(10);
		txt_d1.setBounds(110, 271, 234, 27);
		contentPane.add(txt_d1);
		
		txt_d2 = new JTextField();
		txt_d2.setEditable(false);
		txt_d2.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_d2.setColumns(10);
		txt_d2.setBounds(110, 300, 234, 27);
		contentPane.add(txt_d2);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int salary  = Integer.parseInt(txt_salary.getText());
					if(r_percentage.isSelected()==true) {
						int getPercentage = Integer.parseInt(txt_d1.getText());
						int calcPercentage = (salary/100 * getPercentage) + salary;
						String xP = String.valueOf(calcPercentage);
						txt_salary.setText(xP);
					}
					else if (r_amount.isSelected()==true) {
						int getAmount = Integer.parseInt(txt_d2.getText());
						int calcAmount = salary + getAmount;
						String xA = String.valueOf(calcAmount);
						txt_salary.setText(xA);
					}
				try {
					String value1 = txt_empid.getText();
					String value2 = txt_salary.getText();
					
					String sql = "UPDATE Staff_information SET id = '"+value1+"', Salary = '"+value2+"' WHERE id = '"+value1+"' ";
					pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Salary Updated!");
					
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
					try{
			            Date currentDate = GregorianCalendar.getInstance().getTime();
			            DateFormat df = DateFormat.getDateInstance();
			            String dateString = df.format(currentDate);
	
			            Date d = new Date();
			            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			            String timeString = sdf.format(d);
	
			            String value0 = timeString;
			            String values = dateString;
			            String val = txt_empid.getText().toString();
			            
			            
			                String reg= "insert into Audit (emp_id, date, status) values ('"+val+"','"+value0+" / "+values+"','Updated Salary Record')";
			                pst=conn.prepareStatement(reg);
			                pst.execute();
			            }
			          catch (Exception e)
	
			            {
			                JOptionPane.showMessageDialog(null,e);
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
		});
		btnUpdate.setFont(new Font("Georgia", Font.BOLD, 14));
		btnUpdate.setBounds(557, 297, 149, 35);
		contentPane.add(btnUpdate);
		
		JLabel label_1 = new JLabel("Logged In As:");
		label_1.setFont(new Font("Georgia", Font.PLAIN, 14));
		label_1.setBounds(10, 365, 86, 15);
		contentPane.add(label_1);
		
		JLabel lbl_emp = new JLabel("null");
		lbl_emp.setFont(new Font("Georgia", Font.PLAIN, 14));
		lbl_emp.setBounds(106, 365, 86, 15);
		contentPane.add(lbl_emp);
		lbl_emp.setText(String.valueOf(Emp.empId).toString());
	}
}
