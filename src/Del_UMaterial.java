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
import java.awt.event.ActionEvent;

public class Del_UMaterial extends JFrame {
	private JTextField textField;

	public Del_UMaterial() {
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC2DD\uB8CC\uD488 \uC0AD\uC81C");
		lblNewLabel.setBounds(14, 12, 84, 18);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC218\uB7C9");
		lblNewLabel_1.setBounds(51, 70, 36, 18);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(101, 67, 133, 24);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(168, 121, 105, 27);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC644\uB8CC");
		btnNewButton_1.setBounds(49, 121, 105, 27);
		getContentPane().add(btnNewButton_1);
	}

}