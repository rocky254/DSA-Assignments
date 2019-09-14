package employee.payroll;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaySlip extends JFrame {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	
	private JPanel contentPane;
	private JTextField txt_search;
	private JTextField txt_id;
	private JTextField txt_firstname;
	private JTextField txt_surname;
	private JTextField txt_dob;
	private JTextField txt_dep;
	private JTextField txt_desg;
	private JTextField txt_salary;
	private JTextField txt_job;
	private JTextField txt_doj;
	private JTextField txt_status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaySlip frame = new PaySlip();
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
		            java.util.logging.Logger.getLogger(PaySlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(PaySlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(PaySlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(PaySlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaySlip() {
		setTitle("Generate Employee Pay Slip");
		conn=db.java_db();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Search by ID:");
		label.setFont(new Font("Georgia", Font.BOLD, 14));
		label.setBounds(10, 41, 103, 18);
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
		            txt_desg.setText(add17);
	
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
		txt_search.setBounds(123, 39, 562, 27);
		contentPane.add(txt_search);
		
		JLabel label_1 = new JLabel("Employee ID:");
		label_1.setFont(new Font("Georgia", Font.BOLD, 14));
		label_1.setBounds(10, 105, 147, 18);
		contentPane.add(label_1);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_id.setEditable(false);
		txt_id.setColumns(10);
		txt_id.setBounds(174, 105, 147, 27);
		contentPane.add(txt_id);
		
		JLabel label_2 = new JLabel("First Name:");
		label_2.setFont(new Font("Georgia", Font.BOLD, 14));
		label_2.setBounds(10, 136, 147, 18);
		contentPane.add(label_2);
		
		txt_firstname = new JTextField();
		txt_firstname.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_firstname.setEditable(false);
		txt_firstname.setColumns(10);
		txt_firstname.setBounds(174, 136, 147, 27);
		contentPane.add(txt_firstname);
		
		JLabel label_3 = new JLabel("Surname:");
		label_3.setFont(new Font("Georgia", Font.BOLD, 14));
		label_3.setBounds(10, 167, 147, 18);
		contentPane.add(label_3);
		
		txt_surname = new JTextField();
		txt_surname.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_surname.setEditable(false);
		txt_surname.setColumns(10);
		txt_surname.setBounds(174, 167, 147, 27);
		contentPane.add(txt_surname);
		
		JLabel label_4 = new JLabel("Date of Birth:");
		label_4.setFont(new Font("Georgia", Font.BOLD, 14));
		label_4.setBounds(10, 198, 147, 18);
		contentPane.add(label_4);
		
		txt_dob = new JTextField();
		txt_dob.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_dob.setEditable(false);
		txt_dob.setColumns(10);
		txt_dob.setBounds(174, 198, 147, 27);
		contentPane.add(txt_dob);
		
		JLabel label_5 = new JLabel("Department:");
		label_5.setFont(new Font("Georgia", Font.BOLD, 14));
		label_5.setBounds(10, 229, 147, 18);
		contentPane.add(label_5);
		
		txt_dep = new JTextField();
		txt_dep.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_dep.setEditable(false);
		txt_dep.setColumns(10);
		txt_dep.setBounds(174, 229, 147, 27);
		contentPane.add(txt_dep);
		
		JLabel label_6 = new JLabel("Designation:");
		label_6.setFont(new Font("Georgia", Font.BOLD, 14));
		label_6.setBounds(425, 107, 147, 18);
		contentPane.add(label_6);
		
		txt_desg = new JTextField();
		txt_desg.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_desg.setEditable(false);
		txt_desg.setColumns(10);
		txt_desg.setBounds(589, 107, 147, 27);
		contentPane.add(txt_desg);
		
		JLabel label_7 = new JLabel("Status:");
		label_7.setFont(new Font("Georgia", Font.BOLD, 14));
		label_7.setBounds(425, 138, 147, 18);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Date Hired:");
		label_8.setFont(new Font("Georgia", Font.BOLD, 14));
		label_8.setBounds(425, 169, 147, 18);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Job Title:");
		label_9.setFont(new Font("Georgia", Font.BOLD, 14));
		label_9.setBounds(425, 200, 147, 18);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Salary:");
		label_10.setFont(new Font("Georgia", Font.BOLD, 14));
		label_10.setBounds(425, 231, 147, 18);
		contentPane.add(label_10);
		
		txt_salary = new JTextField();
		txt_salary.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_salary.setEditable(false);
		txt_salary.setColumns(10);
		txt_salary.setBounds(589, 231, 147, 27);
		contentPane.add(txt_salary);
		
		txt_job = new JTextField();
		txt_job.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_job.setEditable(false);
		txt_job.setColumns(10);
		txt_job.setBounds(589, 200, 147, 27);
		contentPane.add(txt_job);
		
		txt_doj = new JTextField();
		txt_doj.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_doj.setEditable(false);
		txt_doj.setColumns(10);
		txt_doj.setBounds(589, 169, 147, 27);
		contentPane.add(txt_doj);
		
		txt_status = new JTextField();
		txt_status.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_status.setEditable(false);
		txt_status.setColumns(10);
		txt_status.setBounds(589, 138, 147, 27);
		contentPane.add(txt_status);
		
		JButton btnNewButton = new JButton("GENERATE SLIP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = txt_firstname.getText();
				String value0 = txt_surname.getText();
				String value1 = txt_id.getText();
				String value2 = txt_desg.getText();
				String value3 = txt_dep.getText();
				
				JFileChooser dialog = new JFileChooser();
				dialog.setSelectedFile(new File(value+" "+value0+" "+"-Salary Slip"+".pdf"));
				int dialogResult = dialog.showSaveDialog(null);
				
				if(dialogResult == JFileChooser.APPROVE_OPTION) {
					String filePath = dialog.getSelectedFile().getPath();
					
					try {
						String sql ="SELECT * from Deductions WHERE emp_id = '"+value1+"'";
			            pst=conn.prepareStatement(sql);
			            rs=pst.executeQuery(); 
			            String val = rs.getString(5);
			            String reason = rs.getString(6);
			            rs.close();
			            pst.close();
			          
			            String sq ="SELECT * from Allowance WHERE emp_id = '"+value1+"'";
			            pst=conn.prepareStatement(sq);
			            rs=pst.executeQuery(); 
			           
			            
			            int calcTotal = Integer.parseInt(txt_salary.getText());
			            float x = Float.valueOf(rs.getString(9));
			            int v = Integer.parseInt(val);
			            float total = calcTotal + x - v;
			            
			            
			            Document myDocument = new Document();
			            PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
			            myDocument.open();
			            
			            myDocument.add(new Paragraph("PAY SLIP",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
			            myDocument.add(new Paragraph(new Date().toString()));
			            myDocument.add(new Paragraph("------------------------------------------------------------------------------"));
			            myDocument.add((new Paragraph("EMPLOYEE DETAILS",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD))));
			            myDocument.add((new Paragraph("Name of Employee: " +value + " "+value0,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
			            myDocument.add((new Paragraph("Designation: "+value2,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
			            myDocument.add((new Paragraph("Department: "+value3,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
			            myDocument.add(new Paragraph("------------------------------------------------------------------------------"));
			            myDocument.add(new Paragraph("SALARY",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
			            myDocument.add(new Paragraph("Basic Salary: $"+calcTotal,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
			            myDocument.add(new Paragraph("Overtime: "+rs.getString(2)+" Hours",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
			            myDocument.add(new Paragraph("Medical: $" +rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
			            myDocument.add(new Paragraph("Bonus: $"+rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
			            myDocument.add(new Paragraph("Other: $"+rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
			            myDocument.add(new Paragraph("------------------------------------------------------------------------------"));
			            myDocument.add(new Paragraph("DEDUCTION",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
			            myDocument.add(new Paragraph("Deduction Details: "+reason,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
			            myDocument.add(new Paragraph("Total Deductions : $"+val ,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
			            myDocument.add(new Paragraph("------------------------------------------------------------------------------"));
			            myDocument.add(new Paragraph("TOTAL PAYMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
			            myDocument.add(new Paragraph("Total Earnings: "+rs.getString(9),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
			            myDocument.add(new Paragraph("Net Pay : " +total,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
			            myDocument.add(new Paragraph("------------------------------------------------------------------------------"));
			            
			            
			            myDocument.newPage();
			            myDocument.close();
			            JOptionPane.showMessageDialog(null, "Report was successfully generated");
			            
						
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
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
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnNewButton.setBounds(261, 314, 155, 42);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("CLEAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_id.setText("");
		        txt_firstname.setText("");
		        txt_surname.setText("");
		        txt_dob.setText("");
		        txt_dep.setText("");
		        txt_status.setText("");
		        txt_salary.setText("");
		        txt_desg.setText("");
		        txt_job.setText("");
		        txt_doj.setText("");
		        txt_search.setText("");
			}
		});
		button.setFont(new Font("Georgia", Font.BOLD, 14));
		button.setBounds(620, 314, 116, 42);
		contentPane.add(button);
	}
}
