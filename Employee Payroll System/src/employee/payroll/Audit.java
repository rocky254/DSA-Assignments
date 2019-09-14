package employee.payroll;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Audit extends JFrame {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	
	private JPanel contentPane;
	private JTextField txt_search;
	private JTable tbl_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Audit frame = new Audit();
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
		            java.util.logging.Logger.getLogger(Audit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(Audit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(Audit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(Audit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Audit() {
		conn=db.java_db();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 777, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Search by ID:");
		label.setFont(new Font("Georgia", Font.BOLD, 14));
		label.setBounds(43, 56, 103, 18);
		contentPane.add(label);
		
		txt_search = new JTextField();
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String sql = "SELECT * FROM Audit WHERE emp_id = ?";
					
					pst = conn.prepareStatement(sql);
					pst.setString(1, txt_search.getText());
					rs = pst.executeQuery();
					
					tbl_1.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				
				catch(Exception e) {
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
		txt_search.setFont(new Font("Georgia", Font.PLAIN, 14));
		txt_search.setColumns(10);
		txt_search.setBounds(156, 51, 282, 30);
		contentPane.add(txt_search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 110, 670, 296);
		contentPane.add(scrollPane);
		
		tbl_1 = new JTable();
		scrollPane.setViewportView(tbl_1);
		
		JButton btnNewButton = new JButton("RESET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Update_table();
				txt_search.setText(" ");
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnNewButton.setBounds(590, 434, 120, 23);
		contentPane.add(btnNewButton);
		
		Update_table();
	}
	
	private void Update_table() {
		try {
			String sql = "SELECT * FROM Audit";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			tbl_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}
		
		catch(Exception e) {
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
