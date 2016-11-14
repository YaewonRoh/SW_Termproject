import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JRadioButton;

public class Add_UMaterial extends JFrame {
	private JTextField textField_1;

	public Add_UMaterial() {
		String[] CbIndex = new String[500]; // 동적배열찾아보기
		int i = 0;
		ButtonGroup group = new ButtonGroup();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
			System.out.println("Opened database successfully");
			PreparedStatement pstmt = c.prepareStatement("select name from Manager");
			ResultSet rset = pstmt.executeQuery();

			getContentPane().setLayout(null);

			JLabel label = new JLabel("\uC2DD\uB8CC\uD488 \uCD94\uAC00");
			label.setBounds(14, 12, 100, 18);
			getContentPane().add(label);

			JLabel lblNewLabel = new JLabel("\uC774\uB984");
			lblNewLabel.setBounds(60, 83, 62, 18);
			getContentPane().add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("\uAC1C\uC218");
			lblNewLabel_1.setBounds(60, 113, 62, 18);
			getContentPane().add(lblNewLabel_1);

			textField_1 = new JTextField();
			textField_1.setBounds(136, 110, 116, 24);
			getContentPane().add(textField_1);

			JRadioButton Radio_Ref = new JRadioButton("\uB0C9\uB3D9");
			Radio_Ref.setBounds(136, 139, 55, 23);
			getContentPane().add(Radio_Ref);
			
			JRadioButton Radio_Cold = new JRadioButton("\uB0C9\uC7A5");
			Radio_Cold.setBounds(203, 140, 55, 23);
			getContentPane().add(Radio_Cold);
			
			JRadioButton Radio_Ordinary = new JRadioButton("\uC0C1\uC628");
			Radio_Ordinary.setBounds(268, 139, 62, 23);
			getContentPane().add(Radio_Ordinary);
			
			group.add(Radio_Ref); group.add(Radio_Cold); group.add(Radio_Ordinary);
			
			JLabel lblNewLabel_3 = new JLabel("\uAD6C\uBD84");
			lblNewLabel_3.setBounds(60, 141, 62, 18);
			getContentPane().add(lblNewLabel_3);

			JComboBox comboBox = new JComboBox();
			while (rset.next()) {
				CbIndex[i] = rset.getString("name");
				comboBox.addItem(CbIndex[i]);
				i++;
			}

			comboBox.setToolTipText("");
			comboBox.setBounds(136, 80, 116, 24);
			getContentPane().add(comboBox);

			JButton btnNewButton = new JButton("\uCDE8\uC18C");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			JButton btnNewButton_1 = new JButton("\uC644\uB8CC");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Radio_Ref.isSelected()) {
						Connection c = null;
						Statement stmt = null;
						try {
							Class.forName("org.sqlite.JDBC");
							c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
							c.setAutoCommit(false);
							System.out.println("성공적으로 데이터 베이스 열었슴돠");
							System.out.println(comboBox.getSelectedItem());
							stmt = c.createStatement();
							ResultSet rs = stmt.executeQuery(
									"SELECT name,life FROM Manager Where name ='" + comboBox.getSelectedItem() + "';");
							String name = rs.getString("name");
							int life = rs.getInt("life");
							System.out.println("NAME = " + name);
							System.out.println("LIFE = " + life);
							//rs.close();
							//stmt.close();
							//c.close();

							String x = name;
							int y = life;
							String z = textField_1.getText();
							//Class.forName("org.sqlite.JDBC");
							//c.setAutoCommit(false);
							System.out.println("Opened database successfully");

							stmt = c.createStatement();
							String sql = "INSERT INTO ref (r_NAME,r_life,r_count) VALUES ('" + x + "'," + y + "," + z + ");";
							stmt.executeUpdate(sql);

							stmt.close();
							c.commit();
							c.close();
						} catch (Exception e1) {
							System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
							System.exit(0);
						}
						System.out.println("Records created successfully");

					} else if (Radio_Cold.isSelected()) {
						Connection c = null;
						Statement stmt = null;
						try {

							Class.forName("org.sqlite.JDBC");
							c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
							c.setAutoCommit(false);
							System.out.println("성공적으로 데이터 베이스 열었슴돠");

							stmt = c.createStatement();
							ResultSet rs = stmt.executeQuery(
									"SELECT name,life FROM Manager Where name ='" + comboBox.getSelectedItem() + "';");
							String name = rs.getString("name");
							int life = rs.getInt("life");
							System.out.println("NAME = " + name);
							System.out.println("LIFE = " + life);
							rs.close();
							stmt.close();
							c.close();

							String x = name;
							String y = textField_1.getText();
							int z = life;
							
							Class.forName("org.sqlite.JDBC");
							c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
							c.setAutoCommit(false);
							System.out.println("Opened database successfully");

							stmt = c.createStatement();
							String sql = "INSERT INTO cold (c_name,c_count,c_life) VALUES ('" + x + "'," + y + "," + z + ");";
							stmt.executeUpdate(sql);

							stmt.close();
							c.commit();
							c.close();
						} catch (Exception e1) {
							System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
							System.exit(0);
						}
						System.out.println("Records created successfully");

					} else if (Radio_Ordinary.isSelected()) {
						Connection c = null;
						Statement stmt = null;
						try {

							Class.forName("org.sqlite.JDBC");
							c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
							c.setAutoCommit(false);
							System.out.println("성공적으로 데이터 베이스 열었슴돠");

							stmt = c.createStatement();
							ResultSet rs = stmt.executeQuery(
									"SELECT name,life FROM Manager Where name ='" + comboBox.getSelectedItem() + "';");
							String name = rs.getString("name");
							int life = rs.getInt("life");
							System.out.println("NAME = " + name);
							System.out.println("LIFE = " + life);
							rs.close();
							stmt.close();
							c.close();

							String x = name;
							String y = textField_1.getText();
							int z = life;
							
							Class.forName("org.sqlite.JDBC");
							c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
							c.setAutoCommit(false);
							System.out.println("Opened database successfully");

							stmt = c.createStatement();
							String sql = "INSERT INTO ordinary (o_NAME,o_count,o_life) VALUES ('" + x + "'," + y + "," + z
									+ ");";
							stmt.executeUpdate(sql);

							stmt.close();
							c.commit();
							c.close();
						} catch (Exception e1) {
							System.err.println(e1.getClass().getName() + ": " + e1.getMessage());
							System.exit(0);
						}
						System.out.println("Records created successfully");

					}

				}
			});
			btnNewButton_1.setBounds(76, 186, 105, 27);
			getContentPane().add(btnNewButton_1);

			btnNewButton.setBounds(212, 186, 105, 27);
			getContentPane().add(btnNewButton);
			
			
			c.close();
			////////////////////////////////////
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		///////////////////////////////////

	}
}
