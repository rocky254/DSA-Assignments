package employee.payroll;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.Toolkit;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MainMenu extends JFrame {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
		            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		conn=db.java_db();
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 762, 508);
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Employee");
		mnNewMenu.setFont(new Font("Georgia", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Reports");
		mnNewMenu_1.setFont(new Font("Georgia", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Employees Report");
		mntmNewMenuItem.setFont(new Font("Georgia", Font.PLAIN, 14));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				    JFileChooser dialog = new JFileChooser();
		            dialog.setSelectedFile(new File("Employees Report.pdf"));
		            int dialogResult = dialog.showSaveDialog(null);
		            if (dialogResult==JFileChooser.APPROVE_OPTION){
		            String filePath = dialog.getSelectedFile().getPath();
		           
				        try {
				            String sql ="select * from Staff_information";
				            
				 
				            pst=conn.prepareStatement(sql);
				            rs=pst.executeQuery();
				            
				           
				           Document myDocument = new Document();
				           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
				           PdfPTable table = new PdfPTable(13);
				           myDocument.open();
				           
				   
				           float[] columnWidths = new float[] {3,8,7,5,5,9,8,9,6,6,6,8,8};
				           table.setWidths(columnWidths);
			
				           table.setWidthPercentage(100); //set table width to 100%
				           
				          
				          myDocument.add(new Paragraph("Employees List",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
				          myDocument.add(new Paragraph(new Date().toString()));
				          myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
				          table.addCell(new PdfPCell(new Paragraph("ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("First Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Surname",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Date of Birth",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Email",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Telephone",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Address",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Department",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Gender",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Salary",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Status",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Date Hired",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Job Title",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD))));
				          
				          while(rs.next())
				            {
				                
				           
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(8),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(10),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(11),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(16),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(17),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(18),FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.PLAIN))));
				          
				            }
				           
				           myDocument.add(table);
				           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
				           myDocument.close();  
				           JOptionPane.showMessageDialog(null,"Report was successfully generated");
				            
				     }
				        catch(Exception e){
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
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Employees Total Allowance Report");
		mntmNewMenuItem_1.setFont(new Font("Georgia", Font.PLAIN, 14));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dialog = new JFileChooser();
	            dialog.setSelectedFile(new File("Employee Allowance Report.pdf"));
	            int dialogResult = dialog.showSaveDialog(null);
	            if (dialogResult==JFileChooser.APPROVE_OPTION){
	            String filePath = dialog.getSelectedFile().getPath();
	           
			        try {
			            String sql ="select * from Allowance";
			            
			 
			            pst=conn.prepareStatement(sql);
			            rs=pst.executeQuery();
			            
			           
			           Document myDocument = new Document();
			           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
			           PdfPTable table = new PdfPTable(11);
			           myDocument.open();
			           
			   
			           float[] columnWidths = new float[] { 3,7,7,5,5,9,6,5,8,8,8};
			           table.setWidths(columnWidths);
		
			           table.setWidthPercentage(100); //set table width to 100%
			           
			          
			           myDocument.add(new Paragraph("Employees Allowance List",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
			           myDocument.add(new Paragraph(new Date().toString()));
			           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
			          table.addCell(new PdfPCell(new Paragraph("ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("Overtime",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("Medical",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("Bonus",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("Other",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("Employee ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("Salary",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("Rate",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("Allowance",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("First Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          table.addCell(new PdfPCell(new Paragraph("Surname",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
			          
			          
			          while(rs.next())
			            {
			                
			           
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(8),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(9),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(10),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			           table.addCell(new PdfPCell(new Paragraph(rs.getString(11),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
			          
			            }
			           
			           myDocument.add(table);
			           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
			           myDocument.close();  
			           JOptionPane.showMessageDialog(null,"Report was successfully generated");
			            
			     }
			        
			     catch(Exception e){
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
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Employee Total Deduction Report");
		mntmNewMenuItem_2.setFont(new Font("Georgia", Font.PLAIN, 14));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						JFileChooser dialog = new JFileChooser();
				        dialog.setSelectedFile(new File("Employee Deduction Report.pdf"));
				        int dialogResult = dialog.showSaveDialog(null);
				        if (dialogResult==JFileChooser.APPROVE_OPTION){
				        String filePath = dialog.getSelectedFile().getPath();
				           
				        try {
				            // TODO add your handling code here:
				            
				            String sql ="select * from Deductions";
				            
				 
				            pst=conn.prepareStatement(sql);
				            rs=pst.executeQuery();
				            
				           
				           Document myDocument = new Document();
				           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath ));
				           PdfPTable table = new PdfPTable(8);
				           myDocument.open();
				           
				   
				           float[] columnWidths = new float[] { 3,7,7,5,5,9,6,5};
				           table.setWidths(columnWidths);
			
				           table.setWidthPercentage(100); //set table width to 100%
				           
				          
				           myDocument.add(new Paragraph("Employees Deduction List",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
				           myDocument.add(new Paragraph(new Date().toString()));
				           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
				          table.addCell(new PdfPCell(new Paragraph("ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("First Name",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Surname",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Salary",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Deduction Amount",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Deduction Reason",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Employee ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
				          table.addCell(new PdfPCell(new Paragraph("Created By",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD))));
				     
				          
				          
				          while(rs.next())
				            {
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(1),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(2),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(6),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(7),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
				           table.addCell(new PdfPCell(new Paragraph(rs.getString(8),FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.PLAIN))));
				          
				          
				            }
				           
				           myDocument.add(table);
				           myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------"));
				           myDocument.close();  
				           JOptionPane.showMessageDialog(null,"Report was successfully generated");
				            
				     }
				        catch(Exception e){
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
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Audit");
		mnNewMenu_2.setFont(new Font("Georgia", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Audit Trail");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Audit x = new Audit();
				x.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Georgia", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("About");
		mnNewMenu_3.setFont(new Font("Georgia", Font.BOLD, 14));
		menuBar.add(mnNewMenu_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(694, 11, 42, 35);
		btnNewButton.setIcon(new ImageIcon(MainMenu.class.getResource("/employee/payroll/images/logout.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login x = new login();
				x.setVisible(true);
				dispose();
				
				try {
					Date currentDate = GregorianCalendar.getInstance().getTime();
					DateFormat df = DateFormat.getInstance();
					String dateString = df.format(currentDate);
					
					Date d = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					String timeString = sdf.format(d);
					
					String value0 = timeString;
					String values = dateString;
					
					int value = Emp.empId;
					
					String reg = "INSERT INTO Audit (emp_id, date, status) VALUES ('"+value+"', '"+value0+" On "+values+"','Logged Out')";
					
					pst = conn.prepareStatement(reg);
					pst.execute();
					dispose();
					
				}
				
				catch (Exception e) {
					
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
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 14));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Logged In As:");
		lblNewLabel.setBounds(32, 415, 86, 15);
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lbl_emp = new JLabel("emp");
		lbl_emp.setBounds(128, 415, 86, 15);
		lbl_emp.setFont(new Font("Georgia", Font.PLAIN, 14));
		contentPane.add(lbl_emp);
		lbl_emp.setText(String.valueOf(Emp.empname).toString());
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(MainMenu.class.getResource("/employee/payroll/images/Add_Employee.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEmployee x = new addEmployee();
				x.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnNewButton_1.setBounds(329, 277, 129, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnUpdateSalary = new JButton("");
		btnUpdateSalary.setIcon(new ImageIcon(MainMenu.class.getResource("/employee/payroll/images/Update.png")));
		btnUpdateSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateSalary x = new UpdateSalary();
				x.setVisible(true);
			}
		});
		btnUpdateSalary.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnUpdateSalary.setBounds(329, 371, 129, 59);
		contentPane.add(btnUpdateSalary);
		
		JButton btnDeduction = new JButton("");
		btnDeduction.setIcon(new ImageIcon(MainMenu.class.getResource("/employee/payroll/images/Deduction.png")));
		btnDeduction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deductions x = new Deductions();
				x.setVisible(true);
			}
		});
		btnDeduction.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnDeduction.setBounds(468, 371, 129, 59);
		contentPane.add(btnDeduction);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(MainMenu.class.getResource("/employee/payroll/images/Search.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEmployee x = new addEmployee();
				x.setVisible(true);
			}
		});
		btnSearch.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnSearch.setBounds(468, 277, 129, 59);
		contentPane.add(btnSearch);
		
		JButton btnPayment = new JButton("");
		btnPayment.setIcon(new ImageIcon(MainMenu.class.getResource("/employee/payroll/images/Payment.png")));
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PaySlip x = new PaySlip();
				x.setVisible(true);
			}
		});
		btnPayment.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnPayment.setBounds(607, 371, 129, 59);
		contentPane.add(btnPayment);
		
		JButton btnAllowance = new JButton("");
		btnAllowance.setIcon(new ImageIcon(MainMenu.class.getResource("/employee/payroll/images/Allowance.png")));
		btnAllowance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Allowance x = new Allowance();
				x.setVisible(true);
			}
		});
		btnAllowance.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnAllowance.setBounds(607, 277, 129, 59);
		contentPane.add(btnAllowance);
		
		JLabel lblEmployeeManager = new JLabel("Employee Manager");
		lblEmployeeManager.setForeground(Color.WHITE);
		lblEmployeeManager.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 12));
		lblEmployeeManager.setBounds(332, 259, 129, 15);
		contentPane.add(lblEmployeeManager);
		
		JLabel lblUpdateSalary = new JLabel("Update Salary");
		lblUpdateSalary.setForeground(Color.WHITE);
		lblUpdateSalary.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 12));
		lblUpdateSalary.setBounds(329, 355, 129, 15);
		contentPane.add(lblUpdateSalary);
		
		JLabel lblSearchEmployee = new JLabel("Search Employee");
		lblSearchEmployee.setForeground(Color.WHITE);
		lblSearchEmployee.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 12));
		lblSearchEmployee.setBounds(468, 260, 129, 15);
		contentPane.add(lblSearchEmployee);
		
		JLabel lblDeductSalary = new JLabel("Deduct Salary");
		lblDeductSalary.setForeground(Color.WHITE);
		lblDeductSalary.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 12));
		lblDeductSalary.setBounds(468, 355, 129, 15);
		contentPane.add(lblDeductSalary);
		
		JLabel lblAddAllowance = new JLabel("Add Allowance");
		lblAddAllowance.setForeground(Color.WHITE);
		lblAddAllowance.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 12));
		lblAddAllowance.setBounds(607, 259, 129, 15);
		contentPane.add(lblAddAllowance);
		
		JLabel lblEmployeePayslips = new JLabel("Employee Payslips");
		lblEmployeePayslips.setForeground(Color.WHITE);
		lblEmployeePayslips.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 12));
		lblEmployeePayslips.setBounds(607, 353, 129, 15);
		contentPane.add(lblEmployeePayslips);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MainMenu.class.getResource("/employee/payroll/images/bk2.jpg")));
		lblNewLabel_1.setBounds(0, 0, 746, 448);
		contentPane.add(lblNewLabel_1);
	}
}
