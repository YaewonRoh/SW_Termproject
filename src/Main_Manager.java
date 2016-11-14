import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Manager extends JFrame{
	public Main_Manager() {
		
		getContentPane().setLayout(null);
		//재료등록 눌렀을때
		JButton btn_Add = new JButton("\uC7AC\uB8CC \uB4F1\uB85D");
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_MMaterial AM = new Add_MMaterial();
				AM.setBounds(100,100,300,300);
				AM.setVisible(true);
			}
		});
		btn_Add.setBounds(39, 23, 85, 69);
		getContentPane().add(btn_Add);
		
		//재료삭제 눌렀을때
		JButton btn_Del = new JButton("\uC7AC\uB8CC \uC0AD\uC81C");
		btn_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Del_MMaterial DM = new Del_MMaterial();
				DM.setBounds(100,100,300,300);
				DM.setVisible(true);
			}
		});
		btn_Del.setBounds(308, 23, 85, 69);
		getContentPane().add(btn_Del);
	}

}
