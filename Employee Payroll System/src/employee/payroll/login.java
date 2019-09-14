package employee.payroll;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Point;
import javax.swing.JPasswordField;

public class login extends JFrame {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
		            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		conn = db.java_db();
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
			
		JLabel label = new JLabel("Please Enter your Username and Password");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Georgia", Font.BOLD, 14));
		label.setBounds(78, 287, 323, 17);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Georgia", Font.BOLD, 14));
		label_1.setBounds(68, 315, 93, 17);
		contentPane.add(label_1);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_username.setColumns(10);
		txt_username.setBounds(205, 310, 196, 25);
		contentPane.add(txt_username);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Georgia", Font.BOLD, 14));
		label_2.setBounds(68, 343, 93, 17);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Select Division");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Georgia", Font.BOLD, 14));
		label_3.setBounds(68, 371, 117, 17);
		contentPane.add(label_3);
		
		JComboBox txt_combo = new JComboBox();
		txt_combo.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Sales", "Sports", "Finance", "Music"}));
		txt_combo.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_combo.setBounds(205, 369, 196, 25);
		contentPane.add(txt_combo);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "SELECT id,username,password,division FROM Users WHERE (username=? and password=? and division=?)";
				try {
					int count = 0;
					
					pst = conn.prepareStatement(sql);
					pst.setString(1, txt_username.getText());
					pst.setString(2, txt_password.getText());
					pst.setString(3, txt_combo.getSelectedItem().toString());
					
					rs = pst.executeQuery();
					while(rs.next()) {
						int id = rs.getInt(1);
						Emp.empId = id;
						String username = rs.getString("username");
						Emp.empname = username;
						count+=1;
					}
					
					String access = (txt_combo.getSelectedItem().toString());
					
					if(access=="Admin") {
						if(count==1) {
							JOptionPane.showMessageDialog(null, "Success");
							MainMenu j = new MainMenu();
							j.setVisible(true);
							dispose();
							
							Date currentDate = GregorianCalendar.getInstance().getTime();
							DateFormat df = DateFormat.getInstance();
							String dateString = df.format(currentDate);
							
							Date d = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
							String timeString = sdf.format(d);
							
							String value0 = timeString;
							String values = dateString;
							
							int value = Emp.empId;
							
							String reg = "INSERT INTO Audit (emp_id, date, status) VALUES ('"+value+"', '"+value0+" On "+values+"','Logged In')";
							
							pst = conn.prepareStatement(reg);
							pst.execute();
							dispose();
							
						}else if(count>1){
			                   JOptionPane.showMessageDialog(null,"Duplicate Username or Password Access denied");
		                   }
		           
		        
						else{
						JOptionPane.showMessageDialog(null,"Username and Password is not correct");
						
						}
		           
					} else if(access=="Sales") {
						if(count==1) {
							JOptionPane.showMessageDialog(null, "Success");
							MainMenu j = new MainMenu();
							j.setVisible(true);
							dispose();
							
							Date currentDate = GregorianCalendar.getInstance().getTime();
							DateFormat df = DateFormat.getInstance();
							String dateString = df.format(currentDate);
							
							Date d = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
							String timeString = sdf.format(d);
							
							String value0 = timeString;
							String values = dateString;
							
							int value = Emp.empId;
							
							String reg = "INSERT INTO Audit (emp_id, date, status) VALUES ('"+value+"', '"+value0+" On "+values+"','Logged In')";
							
							pst = conn.prepareStatement(reg);
							pst.execute();
							dispose();
							
						}else if(count>1){
			                   JOptionPane.showMessageDialog(null,"Duplicate Username or Password Access denied");
		                   }
		           
		        
						else{
						JOptionPane.showMessageDialog(null,"Username and Password is not correct");
						
						}
						
					} else if(access=="Sports") {
						if(count==1) {
							JOptionPane.showMessageDialog(null, "Success");
							MainMenu j = new MainMenu();
							j.setVisible(true);
							dispose();
							
							Date currentDate = GregorianCalendar.getInstance().getTime();
							DateFormat df = DateFormat.getInstance();
							String dateString = df.format(currentDate);
							
							Date d = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
							String timeString = sdf.format(d);
							
							String value0 = timeString;
							String values = dateString;
							
							int value = Emp.empId;
							
							String reg = "INSERT INTO Audit (emp_id, date, status) VALUES ('"+value+"', '"+value0+" On "+values+"','Logged In')";
							
							pst = conn.prepareStatement(reg);
							pst.execute();
							dispose();
							
						}else if(count>1){
			                   JOptionPane.showMessageDialog(null,"Duplicate Username or Password Access denied");
		                   }
		           
		        
						else{
						JOptionPane.showMessageDialog(null,"Username and Password is not correct");
						
						}
						
					}
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
		});
		btnLogin.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnLogin.setBounds(246, 410, 119, 23);
		contentPane.add(btnLogin);
		
		JMenuItem menuItem = new JMenuItem("File");
		menuItem.setFont(new Font("Georgia", Font.BOLD, 14));
		menuItem.setBounds(0, 0, 217, 22);
		contentPane.add(menuItem);
		
		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		JMenuItem lbl_date = new JMenuItem("5/29/2019");
		lbl_date.setFont(new Font("Georgia", Font.BOLD, 14));
		lbl_date.setBounds(217, 0, 217, 22);
		lbl_date.setText((month +1)+"/"+day+"/"+year);	
		contentPane.add(lbl_date);
		
		int second = cal.get(Calendar.SECOND);
		int minute = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR);
		JMenuItem lbl_time = new JMenuItem("9:3:52");
		lbl_time.setFont(new Font("Georgia", Font.BOLD, 14));
		lbl_time.setBounds(434, 0, 217, 22);
		lbl_time.setText(hour+":"+(minute)+":"+second);
		contentPane.add(lbl_time);
		
		txt_password = new JPasswordField();
		txt_password.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_password.setBounds(205, 339, 196, 25);
		contentPane.add(txt_password);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/employee/payroll/images/bk3.jpg")));
		lblNewLabel.setBounds(0, 25, 765, 435);
		contentPane.add(lblNewLabel);
	}
	
}
