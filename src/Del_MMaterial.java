import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Del_MMaterial extends JFrame {
	private JTextField text_Name;
	Pop A = new Pop();
	
	public Del_MMaterial() {
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC2DD\uB8CC\uD488 \uC0AD\uC81C");
		lblNewLabel.setBounds(14, 12, 84, 18);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC218\uB7C9");
		lblNewLabel_1.setBounds(51, 70, 36, 18);
		getContentPane().add(lblNewLabel_1);

		text_Name = new JTextField();
		text_Name.setBounds(101, 67, 133, 24);
		getContentPane().add(text_Name);
		text_Name.setColumns(10);

		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(168, 121, 105, 27);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC644\uB8CC");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DB_DelMM Query = new DB_DelMM(text_Name);
				A.Message("삭제 되었습니다.");
			}
		});
		btnNewButton_1.setBounds(49, 121, 105, 27);
		getContentPane().add(btnNewButton_1);
	}

}

class DB_DelMM {
	public DB_DelMM(JTextField text_A) {
		Connection c = null;
		Statement stmt = null;
		
		try {
			String x = text_A.getText();
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "DELETE FROM Manager WHERE Name='"+x+"';";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e1) {
			System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
			System.exit(0);
		}
	}
}