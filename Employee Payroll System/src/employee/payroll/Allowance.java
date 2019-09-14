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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Allowance extends JFrame {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private JPanel contentPane;
	private JTextField txt_search;
	private JTextField txt_empid;
	private JLabel lblFirstName;
	private JTextField txt_firstname;
	private JLabel lblSurname;
	private JTextField txt_sur;
	private JLabel lblDateOfBirth;
	private JTextField txt_dob;
	private JLabel lblBasicSalary;
	private JTextField txt_salary;
	private JLabel lblDepartment;
	private JTextField txt_dep;
	private JTextField txt_overtime;
	private JTextField txt_med;
	private JTextField txt_bonus;
	private JTextField txt_other;
	private JTextField txt_hw;
	private JTextField txt_rate;
	private JTable table_allowance;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allowance frame = new Allowance();
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
		            java.util.logging.Logger.getLogger(Allowance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(Allowance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(Allowance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(Allowance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Allowance() {
		setTitle("Employee Allowance");
		conn = db.java_db();
		Update_table();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 926, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		txt_search = new JTextField();
		txt_search.setBounds(149, 44, 583, 28);
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
					txt_sur.setText(add3);
					
					String add4 = rs.getString("DOB");
					txt_dob.setText(add4);
					
					String add5 = rs.getString("Salary");
					txt_salary.setText(add5);
					
					String add6 = rs.getString("Department");
					txt_dep.setText(add6);
				
					
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
		});
		contentPane.setLayout(null);
		txt_search.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_search.setColumns(10);
		contentPane.add(txt_search);
		
		JLabel label = new JLabel("Employee ID:");
		label.setBounds(36, 46, 103, 18);
		label.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Employee ID:");
		label_1.setBounds(36, 127, 103, 18);
		label_1.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(label_1);
		
		txt_empid = new JTextField();
		txt_empid.setEditable(false);
		txt_empid.setBounds(149, 125, 140, 28);
		txt_empid.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_empid.setColumns(10);
		contentPane.add(txt_empid);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(36, 158, 103, 18);
		lblFirstName.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblFirstName);
		
		txt_firstname = new JTextField();
		txt_firstname.setEditable(false);
		txt_firstname.setBounds(149, 156, 140, 28);
		txt_firstname.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_firstname.setColumns(10);
		contentPane.add(txt_firstname);
		
		lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(36, 189, 103, 18);
		lblSurname.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblSurname);
		
		txt_sur = new JTextField();
		txt_sur.setEditable(false);
		txt_sur.setBounds(149, 187, 140, 28);
		txt_sur.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_sur.setColumns(10);
		contentPane.add(txt_sur);
		
		lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(36, 220, 103, 18);
		lblDateOfBirth.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblDateOfBirth);
		
		txt_dob = new JTextField();
		txt_dob.setEditable(false);
		txt_dob.setBounds(149, 218, 140, 28);
		txt_dob.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_dob.setColumns(10);
		contentPane.add(txt_dob);
		
		lblBasicSalary = new JLabel("Basic Salary:");
		lblBasicSalary.setBounds(36, 251, 103, 18);
		lblBasicSalary.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblBasicSalary);
		
		txt_salary = new JTextField();
		txt_salary.setEditable(false);
		txt_salary.setBounds(149, 249, 140, 28);
		txt_salary.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_salary.setColumns(10);
		contentPane.add(txt_salary);
		
		lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(36, 282, 103, 18);
		lblDepartment.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblDepartment);
		
		txt_dep = new JTextField();
		txt_dep.setEditable(false);
		txt_dep.setBounds(149, 280, 140, 28);
		txt_dep.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_dep.setColumns(10);
		contentPane.add(txt_dep);
		
		JLabel lblOvertime = new JLabel("Overtime:");
		lblOvertime.setBounds(312, 129, 103, 18);
		lblOvertime.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblOvertime);
		
		txt_overtime = new JTextField();
		txt_overtime.setBounds(425, 127, 140, 28);
		txt_overtime.setText("0");
		txt_overtime.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_overtime.setColumns(10);
		contentPane.add(txt_overtime);
		
		JLabel lblMedical = new JLabel("Medical:");
		lblMedical.setBounds(312, 160, 103, 18);
		lblMedical.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblMedical);
		
		txt_med = new JTextField();
		txt_med.setBounds(425, 158, 140, 28);
		txt_med.setText("0");
		txt_med.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_med.setColumns(10);
		contentPane.add(txt_med);
		
		JLabel lblBonus = new JLabel("Bonus:");
		lblBonus.setBounds(312, 194, 103, 18);
		lblBonus.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblBonus);
		
		txt_bonus = new JTextField();
		txt_bonus.setBounds(425, 192, 140, 28);
		txt_bonus.setText("0");
		txt_bonus.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_bonus.setColumns(10);
		contentPane.add(txt_bonus);
		
		JLabel lblOther = new JLabel("Other:");
		lblOther.setBounds(312, 222, 103, 18);
		lblOther.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblOther);
		
		txt_other = new JTextField();
		txt_other.setBounds(425, 223, 140, 28);
		txt_other.setText("0");
		txt_other.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_other.setColumns(10);
		contentPane.add(txt_other);
		
		JLabel lblTotalOvertime = new JLabel("Total Overtime");
		lblTotalOvertime.setBounds(593, 130, 139, 18);
		lblTotalOvertime.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblTotalOvertime);
		
		txt_hw = new JTextField();
		txt_hw.setEditable(false);
		txt_hw.setBounds(592, 156, 140, 28);
		txt_hw.setText("0");
		txt_hw.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_hw.setColumns(10);
		contentPane.add(txt_hw);
		
		txt_rate = new JTextField();
		txt_rate.setEditable(false);
		txt_rate.setBounds(593, 218, 140, 28);
		txt_rate.setText("0");
		txt_rate.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_rate.setColumns(10);
		contentPane.add(txt_rate);
		
		JLabel lblRatePerHour = new JLabel("Rate per Hour");
		lblRatePerHour.setBounds(594, 192, 139, 18);
		lblRatePerHour.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblRatePerHour);
		
		JLabel lblTotalAmount = new JLabel("Total Amount:");
		lblTotalAmount.setBounds(425, 279, 157, 18);
		lblTotalAmount.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lblTotalAmount);
		
		JLabel lbl_total = new JLabel("0.00");
		lbl_total.setBounds(593, 280, 140, 18);
		lbl_total.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(lbl_total);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBounds(747, 325, 153, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txt_empid.getText().equals("")) {
			        JOptionPane.showMessageDialog(null, "Employee id Field is empty");
			    } else if (txt_firstname.getText().equals("")) {
			        JOptionPane.showMessageDialog(null, "First name Field is empty");
			        
			     } else if (txt_sur.getText().equals("")) {
			        JOptionPane.showMessageDialog(null, "Surname name Field is empty");
			        
			    }
			     else if (txt_dob.getText().equals("")) {
			        JOptionPane.showMessageDialog(null, "Date of Birth name Field is empty");
			        
			    }
			      else if (txt_salary.getText().equals("")) {
			        JOptionPane.showMessageDialog(null, "Salary Field is empty");
			        
			    }
			       else if (txt_dep.getText().equals("")) {
			        JOptionPane.showMessageDialog(null, "Department Field is empty");
			        
			    }
			      
			    else {
				try {
					int value = Emp.empId;
					String value1 = txt_salary.getText();
					String value2 = txt_bonus.getText();
					String value3 = txt_med.getText();
					String value4 = txt_other.getText();
					String value5 = txt_rate.getText();
					String value6 = txt_hw.getText();
					String value7 = lbl_total.getText();
					String value8 = txt_empid.getText();
					String value9 = txt_firstname.getText();
					String value10 = txt_sur.getText();
					
					String sql = "INSERT INTO Allowance (created_by,emp_id,overtime,medical,bonus,other,salary,rate,total_allowance,firstname,surname) VALUES ('"+value+"','"+value8+"','"+value6+"','"+value3+"','"+value2+"','"+value4+"','"+value1+"','"+value5+"','"+value7+"','"+value9+"','"+value10+"')";
					
					pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Allowance Added");
					
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
			            
			            
			                String reg= "insert into Audit (emp_id, date, status) values ('"+val+"','"+value0+" / "+values+"','Updated Allowance Record')";
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
						
					}
					
				}
				
			    }
				Update_table();
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		JButton btnCalculate = new JButton("CALCULATE");
		btnCalculate.setBounds(747, 359, 153, 23);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int salary = Integer.parseInt(txt_salary.getText());
				int overtime = Integer.parseInt(txt_overtime.getText());
				
				double eight = 8;
				double days = 25;
				double dbop = 0;
				double overtimeRate = 1.5;
				
				double Total_Overtime = overtime * overtimeRate;
				String x = String.valueOf(Total_Overtime);
				txt_hw.setText(x);
				
				dbop = salary/days/eight;
				String s = String.valueOf(dbop);
				txt_rate.setText(s);
				
				int med = Integer.parseInt(txt_med.getText());
				int bonus = Integer.parseInt(txt_bonus.getText());
				int other = Integer.parseInt(txt_other.getText());
				int f = med + bonus + other;
				double calc = (Total_Overtime * dbop) + f;
				String c = String.valueOf(calc);
				lbl_total.setText(c);
			}
		});
		btnCalculate.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(btnCalculate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(747, 393, 153, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_empid.setText("");
				txt_firstname.setText("");
				txt_sur.setText("");
				txt_salary.setText("");
				txt_dob.setText("");
				txt_dep.setText("");
				txt_med.setText("0");
				txt_bonus.setText("0");
				txt_other.setText("0");
				txt_hw.setText("0");
				txt_rate.setText("0");
				txt_overtime.setText("0");
				lbl_total.setText("0.00");
				txt_search.setText("");
			}
		});
		btnClear.setFont(new Font("Georgia", Font.BOLD, 14));
		contentPane.add(btnClear);
		
		JLabel label_3 = new JLabel("Logged In As:");
		label_3.setBounds(36, 528, 86, 15);
		label_3.setFont(new Font("Georgia", Font.PLAIN, 14));
		contentPane.add(label_3);
		
		JLabel lbl_empid = new JLabel("null");
		lbl_empid.setBounds(132, 528, 86, 15);
		lbl_empid.setFont(new Font("Georgia", Font.PLAIN, 14));
		contentPane.add(lbl_empid);
		lbl_empid.setText(String.valueOf(Emp.empId).toString());
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 325, 696, 192);
		contentPane.add(scrollPane);
		
		table_allowance = new JTable();
		scrollPane.setViewportView(table_allowance);
	}
	private void Update_table() {
		try {
			String sql = "SELECT * FROM Allowance";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table_allowance.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		finally {
			try {
				rs.close();
				pst.close();
				
			}
			catch(Exception e) {
				
			}
			
		}
	}
}
