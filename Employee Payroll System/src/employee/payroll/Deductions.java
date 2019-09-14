package employee.payroll;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deductions extends JFrame {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	
	
	private JPanel contentPane;
	private JTextField txt_search;
	private JLabel lblEmployeeId;
	private JTextField txt_id;
	private JLabel lblFirstName;
	private JTextField txt_firstname;
	private JLabel lblSurname;
	private JTextField txt_surname;
	private JLabel lblDateOfBirth;
	private JTextField txt_dob;
	private JLabel lblDepartment;
	private JTextField txt_dep;
	private JLabel lblDesignation;
	private JTextField txt_designation;
	private JLabel lblStatus;
	private JTextField txt_status;
	private JLabel lblDateHired;
	private JTextField txt_doj;
	private JLabel lblJobTitle;
	private JTextField txt_job;
	private JLabel lblSalary;
	private JTextField txt_salary;
	private JLabel lblUpdateSalaryBy;
	private JTextField txt_percentage;
	private JTextField txt_amount;
	private JLabel lblSalaryAfterDeduction;
	private JLabel lbl_salary;
	private JLabel lblReasonForDeduction;
	private JTextField txt_reason;
	private JLabel lbl_emp;
	private JLabel label_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deductions frame = new Deductions();
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
		            java.util.logging.Logger.getLogger(Deductions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(Deductions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(Deductions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(Deductions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Deductions() {
		conn=db.java_db();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 782, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Search by ID:");
		label.setFont(new Font("Georgia", Font.BOLD, 14));
		label.setBounds(10, 29, 103, 18);
		contentPane.add(label);
		
		txt_search = new JTextField();
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
	
		            String sql ="SELECT * from Staff_information where id=? ";
		
		            pst=conn.prepareStatement(sql);
		            pst.setString(1,txt_search.getText());
		            rs=pst.executeQuery();
		
		            String add1 =rs.getString("id");
		            txt_id.setText(add1);
		
		            String add2 =rs.getString("first_name");
		            txt_firstname.setText(add2);
		
		            String add3 =rs.getString("surname");
		            txt_surname.setText(add3);
		
		            String add4 =rs.getString("Dob");
		            txt_dob.setText(add4);
		
		            String add5 =rs.getString("Department");
		            txt_dep.setText(add5);
		
		            String add7 =rs.getString("Salary");
		            txt_salary.setText(add7);
		
		            String add8 =rs.getString("Status");
		            txt_status.setText(add8);
		
		            String add9 =rs.getString("Date_hired");
		            txt_doj.setText(add9);
		
		            String add10 =rs.getString("job_title");
		            txt_job.setText(add10);
		
		            String add17 =rs.getString("Designation");
		            txt_designation.setText(add17);
	
		        }catch(Exception e){
		            JOptionPane.showMessageDialog(null, "No Data");
		            
		        }
		        finally {
		
		            try{
		
		                rs.close();
		                pst.close();
		
		            }
		            catch(Exception e){
		
		            }
		        }
	
				}
			});
		txt_search.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_search.setColumns(10);
		txt_search.setBounds(123, 27, 615, 27);
		contentPane.add(txt_search);
		
		lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setFont(new Font("Georgia", Font.BOLD, 14));
		lblEmployeeId.setBounds(10, 94, 103, 18);
		contentPane.add(lblEmployeeId);
		
		txt_id = new JTextField();
		txt_id.setEditable(false);
		txt_id.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_id.setColumns(10);
		txt_id.setBounds(123, 92, 199, 27);
		contentPane.add(txt_id);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Georgia", Font.BOLD, 14));
		lblFirstName.setBounds(10, 125, 103, 18);
		contentPane.add(lblFirstName);
		
		txt_firstname = new JTextField();
		txt_firstname.setEditable(false);
		txt_firstname.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_firstname.setColumns(10);
		txt_firstname.setBounds(123, 123, 199, 27);
		contentPane.add(txt_firstname);
		
		lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Georgia", Font.BOLD, 14));
		lblSurname.setBounds(10, 156, 103, 18);
		contentPane.add(lblSurname);
		
		txt_surname = new JTextField();
		txt_surname.setEditable(false);
		txt_surname.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_surname.setColumns(10);
		txt_surname.setBounds(123, 154, 199, 27);
		contentPane.add(txt_surname);
		
		lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDateOfBirth.setBounds(10, 187, 103, 18);
		contentPane.add(lblDateOfBirth);
		
		txt_dob = new JTextField();
		txt_dob.setEditable(false);
		txt_dob.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_dob.setColumns(10);
		txt_dob.setBounds(123, 185, 199, 27);
		contentPane.add(txt_dob);
		
		lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDepartment.setBounds(10, 218, 103, 18);
		contentPane.add(lblDepartment);
		
		txt_dep = new JTextField();
		txt_dep.setEditable(false);
		txt_dep.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_dep.setColumns(10);
		txt_dep.setBounds(123, 216, 199, 27);
		contentPane.add(txt_dep);
		
		lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDesignation.setBounds(425, 96, 103, 18);
		contentPane.add(lblDesignation);
		
		txt_designation = new JTextField();
		txt_designation.setEditable(false);
		txt_designation.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_designation.setColumns(10);
		txt_designation.setBounds(538, 94, 200, 27);
		contentPane.add(txt_designation);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Georgia", Font.BOLD, 14));
		lblStatus.setBounds(425, 127, 103, 18);
		contentPane.add(lblStatus);
		
		txt_status = new JTextField();
		txt_status.setEditable(false);
		txt_status.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_status.setColumns(10);
		txt_status.setBounds(538, 125, 200, 27);
		contentPane.add(txt_status);
		
		lblDateHired = new JLabel("Date Hired:");
		lblDateHired.setFont(new Font("Georgia", Font.BOLD, 14));
		lblDateHired.setBounds(425, 158, 103, 18);
		contentPane.add(lblDateHired);
		
		txt_doj = new JTextField();
		txt_doj.setEditable(false);
		txt_doj.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_doj.setColumns(10);
		txt_doj.setBounds(538, 156, 200, 27);
		contentPane.add(txt_doj);
		
		lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setFont(new Font("Georgia", Font.BOLD, 14));
		lblJobTitle.setBounds(425, 189, 103, 18);
		contentPane.add(lblJobTitle);
		
		txt_job = new JTextField();
		txt_job.setEditable(false);
		txt_job.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_job.setColumns(10);
		txt_job.setBounds(538, 187, 200, 27);
		contentPane.add(txt_job);
		
		lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Georgia", Font.BOLD, 14));
		lblSalary.setBounds(425, 220, 103, 18);
		contentPane.add(lblSalary);
		
		txt_salary = new JTextField();
		txt_salary.setEditable(false);
		txt_salary.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_salary.setColumns(10);
		txt_salary.setBounds(538, 218, 200, 27);
		contentPane.add(txt_salary);
		
		lblUpdateSalaryBy = new JLabel("Update Salary by:");
		lblUpdateSalaryBy.setFont(new Font("Georgia", Font.BOLD, 14));
		lblUpdateSalaryBy.setBounds(10, 281, 128, 18);
		contentPane.add(lblUpdateSalaryBy);
		
		JRadioButton r_percentage = new JRadioButton("Percentage (%)");
		JRadioButton r_amount = new JRadioButton("Amount");
		r_amount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r_amount.setSelected(true);
		        r_percentage.setSelected(false);
		        //r_percentage.setEnabled(false);
		        txt_percentage.setEnabled(false);
		        txt_amount.setEditable(true);
		        txt_amount.setEnabled(true);
		        txt_percentage.setText("");
			}
		});
		r_percentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				r_percentage.setSelected(true);
		        r_amount.setSelected(false);
		        //r_amount.setEnabled(false);
		        txt_amount.setEnabled(false);
		        txt_percentage.setEditable(true);
		        txt_percentage.setEnabled(true);
		        txt_amount.setText("");
			}
		});
		r_percentage.setFont(new Font("Georgia", Font.BOLD, 14));
		r_percentage.setBounds(161, 280, 139, 23);
		contentPane.add(r_percentage);
		
		
		r_amount.setFont(new Font("Georgia", Font.BOLD, 14));
		r_amount.setBounds(318, 280, 139, 23);
		contentPane.add(r_amount);
		
		JLabel lblPercentage = new JLabel("Percentage:");
		lblPercentage.setFont(new Font("Georgia", Font.BOLD, 14));
		lblPercentage.setBounds(10, 312, 103, 18);
		contentPane.add(lblPercentage);
		
		txt_percentage = new JTextField();
		txt_percentage.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_percentage.setColumns(10);
		txt_percentage.setBounds(123, 310, 147, 27);
		contentPane.add(txt_percentage);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Georgia", Font.BOLD, 14));
		lblAmount.setBounds(10, 343, 103, 18);
		contentPane.add(lblAmount);
		
		txt_amount = new JTextField();
		txt_amount.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_amount.setColumns(10);
		txt_amount.setBounds(123, 341, 147, 27);
		contentPane.add(txt_amount);
		
		JLabel lblTotalDeduction = new JLabel("Total Deduction:");
		lblTotalDeduction.setFont(new Font("Georgia", Font.BOLD, 14));
		lblTotalDeduction.setBounds(425, 310, 128, 18);
		contentPane.add(lblTotalDeduction);
		
		JLabel lbl_total = new JLabel("0.00");
		lbl_total.setFont(new Font("Georgia", Font.BOLD, 14));
		lbl_total.setBounds(582, 310, 103, 18);
		contentPane.add(lbl_total);
		
		lblSalaryAfterDeduction = new JLabel("Salary After Deduction:");
		lblSalaryAfterDeduction.setFont(new Font("Georgia", Font.BOLD, 14));
		lblSalaryAfterDeduction.setBounds(380, 343, 173, 18);
		contentPane.add(lblSalaryAfterDeduction);
		
		lbl_salary = new JLabel("0.00");
		lbl_salary.setFont(new Font("Georgia", Font.BOLD, 14));
		lbl_salary.setBounds(582, 343, 103, 18);
		contentPane.add(lbl_salary);
		
		lblReasonForDeduction = new JLabel("Reason for Deduction:");
		lblReasonForDeduction.setFont(new Font("Georgia", Font.BOLD, 14));
		lblReasonForDeduction.setBounds(10, 394, 173, 18);
		contentPane.add(lblReasonForDeduction);
		
		txt_reason = new JTextField();
		txt_reason.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_reason.setColumns(10);
		txt_reason.setBounds(179, 389, 506, 27);
		contentPane.add(txt_reason);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
		        if(p==0){
		
		              String value3 = lbl_emp.getText();
		            try {
		
		                String sql ="INSERT INTO Deductions (firstname,surname,salary,deduction_amount,deduction_reason,emp_id,made_by) values (?,?,?,?,?,?,'"+value3+"')";
		                pst=conn.prepareStatement(sql);
		                pst.setString(1,txt_firstname.getText());
		                pst.setString(2,txt_surname.getText());
		                pst.setString(3,txt_salary.getText());
		                pst.setString(4,lbl_total.getText());
		                pst.setString(5,txt_reason.getText());
		                pst.setString(6,txt_id.getText());
		  
		                pst.execute();
		                JOptionPane.showMessageDialog(null,"Data is saved successfully");
		
		            }
		            catch (Exception e)
		
		            {
		                JOptionPane.showMessageDialog(null,e);
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
				                String val = lbl_emp.getText().toString();
				                
				                
				                    String reg= "insert into Audit (emp_id, date, status) values ('"+val+"','"+value0+" / "+values+"','Updated Deduction Record')";
				                    pst=conn.prepareStatement(reg);
				                    pst.execute();
				                }
				            	catch (Exception e)
		
				                {
				                    JOptionPane.showMessageDialog(null,e);
				                }
		           
		         finally {
		
		                try{
		                    rs.close();
		                    pst.close();
		
		                }
		                 catch(Exception e){
		                   JOptionPane.showMessageDialog(null,e);
		                }
		            }
		        }

			}
		});
		btnSave.setFont(new Font("Georgia", Font.BOLD, 14));
		btnSave.setBounds(119, 434, 94, 25);
		contentPane.add(btnSave);
		
		JButton btnCalculate = new JButton("CALCULATE");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  int salary = Integer.parseInt(txt_salary.getText());
        
		         if(r_percentage.isSelected()== true){
			        int percentage = Integer.parseInt(txt_percentage.getText());
			        //calculate the total hours of overtime
			        int total_percentage_deduction = salary /100 * percentage;
			        String x = String.valueOf(total_percentage_deduction);
			        int sal = salary - total_percentage_deduction;
			        lbl_total.setText(x);
			        lbl_salary.setText(String.valueOf(sal));
		         }
		        
		        if(r_amount.isSelected()== true){
			        int deduction = Integer.parseInt(txt_amount.getText());
			        //calculate the total hours of overtime
			        int total_amount_deduction =  salary - deduction;
			        String s = String.valueOf(total_amount_deduction);
			       
			        lbl_salary.setText(s);
			        lbl_total.setText(String.valueOf(deduction));

		        }
			}
		});
		btnCalculate.setFont(new Font("Georgia", Font.BOLD, 14));
		btnCalculate.setBounds(271, 435, 147, 24);
		contentPane.add(btnCalculate);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					txt_id.setText("");
			        txt_firstname.setText("");
			        txt_surname.setText("");
			        txt_dob.setText("");
			        txt_dep.setText("");
			        txt_status.setText("");
			        txt_salary.setText("");
			        txt_designation.setText("");
			        txt_job.setText("");
			        txt_doj.setText("");
			        lbl_total.setText("0.00");
			        txt_percentage.setText("");
			        txt_amount.setText("");
			        txt_reason.setText("");
			        txt_search.setText("");
			        lbl_salary.setText("0.00");
			}
		});
		btnClear.setFont(new Font("Georgia", Font.BOLD, 14));
		btnClear.setBounds(464, 435, 89, 24);
		contentPane.add(btnClear);
		
		lbl_emp = new JLabel("0");
		lbl_emp.setFont(new Font("Georgia", Font.PLAIN, 14));
		lbl_emp.setBounds(106, 470, 86, 15);
		contentPane.add(lbl_emp);
		lbl_emp.setText(String.valueOf(Emp.empId).toString());
		
		label_4 = new JLabel("Logged In As:");
		label_4.setFont(new Font("Georgia", Font.PLAIN, 14));
		label_4.setBounds(10, 470, 86, 15);
		contentPane.add(label_4);
	}
}
