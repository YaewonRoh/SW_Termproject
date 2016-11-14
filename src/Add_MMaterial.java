import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Add_MMaterial extends JFrame{
	private JTextField text_Name;
	private JTextField text_Life;
	Pop A = new Pop();
	public Add_MMaterial() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\uC644\uB8CC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DB_AddMM Query = new DB_AddMM(text_Name,text_Life);
				setVisible(false);
				A.Message("추가 되었습니다.");
			}
		});
		btnNewButton.setBounds(162, 202, 97, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(80, 60, 57, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAE30\uBCF8 \uC720\uD1B5\uAE30\uD55C");
		lblNewLabel_1.setBounds(47, 119, 90, 15);
		getContentPane().add(lblNewLabel_1);
		
		text_Name = new JTextField();
		text_Name.setBounds(143, 57, 116, 21);
		getContentPane().add(text_Name);
		text_Name.setColumns(10);
		
		text_Life = new JTextField();
		text_Life.setBounds(143, 116, 116, 21);
		getContentPane().add(text_Life);
		text_Life.setColumns(10);
	}
}

class DB_AddMM{
	public DB_AddMM(JTextField text_A,JTextField text_B){
		Connection c = null;
		Statement stmt = null;
		try{
			String x = text_A.getText();
			String y = text_B.getText();
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
			c.setAutoCommit(false);//뭐지
			System.out.println("ㅇㅇ그래완성");
			
			stmt = c.createStatement();
			String sql = "INSERT INTO Manager (Name,Life) VALUES('"+x+"',"+y+");";
			stmt.executeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
		}catch(Exception e1){
			System.err.println(e1.getClass().getName()+": "+e1.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}
}
