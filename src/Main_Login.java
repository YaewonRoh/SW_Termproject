import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main_Login extends JFrame {

	public Main_Login() {

		getContentPane().setLayout(null);

		JButton Btn_Manager = new JButton("관리");
		Btn_Manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Manager MM = new Main_Manager();
				MM.setBounds(500, 100, 800, 500);
				MM.setVisible(true);
				setVisible(false);
			}
		});
		Btn_Manager.setBounds(206, 104, 122, 44);
		getContentPane().add(Btn_Manager);

		JButton Btn_User = new JButton("내 냉장고 보기");
		Btn_User.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_User MU = new Main_User();
				MU.setBounds(500, 100, 800, 500);
				MU.setVisible(true);
				setVisible(false);
			}
		});
		Btn_User.setBounds(72, 104, 122, 44);
		getContentPane().add(Btn_User);
	}
}