import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class Main_User extends JFrame {

	public Main_User() {

		PreparedStatement pstmt;
		ResultSet rset;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:SWdb.db");
			setBounds(500, 100, 800, 520);
			getContentPane().setLayout(null);

			// 추가버튼********************************************************************
			JButton Btn_Add = new JButton("\uCD94\uAC00");
			Btn_Add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Add_UMaterial fa = new Add_UMaterial();
					fa.setBounds(100, 100, 365, 320);
					fa.setVisible(true);
				}
			});

			Btn_Add.setBounds(353, 38, 81, 41);
			getContentPane().add(Btn_Add);
			// 추가버튼
			// 끝*****************************************************************
			// 삭제버튼*******************************************************************
			JButton Btn_Del = new JButton("\uC0AD\uC81C");
			Btn_Del.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Del_UMaterial fd = new Del_UMaterial();
					fd.setBounds(100, 100, 305, 215);
					fd.setVisible(true);
				}
			});
			Btn_Del.setBounds(483, 38, 81, 41);
			getContentPane().add(Btn_Del);
			// 삭제버튼
			// 끝****************************************************************
			// 냉동********************************************************************

			pstmt = c.prepareStatement("select r_name,r_count,r_life from ref");
			rset = pstmt.executeQuery();
			int count = 0;
			while (rset.next())
				count++;

			JPanel panel_1 = new JPanel();
			panel_1.setBounds(14, 15, 269, 145);
			getContentPane().add(panel_1);
			panel_1.setLayout(null);

			JLabel Label_Ref = new JLabel("\uB0C9\uB3D9");
			Label_Ref.setBounds(0, 0, 36, 38);
			panel_1.add(Label_Ref);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 34, 236, 98);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane);

			pstmt = c.prepareStatement("select r_name,r_count,r_life from ref");
			rset = pstmt.executeQuery();
			
			String[] strs1 = new String[100];
			strs1[0] = null;
			int[] strs2 = new int[100];
			strs2[0] = 0;
			int[] strs3 = new int[100];
			strs3[0] = 0;
			String[] strs = new String[count];
			strs[0] = null;			

			int i = 0;

			while (rset.next()) {
				strs1[i] = rset.getString("r_name");
				strs2[i] = rset.getInt("r_count");
				strs3[i] = rset.getInt("r_life");
				strs[i] = strs1[i] + " " + strs2[i] + " " + strs3[i];
				System.out.println(strs[i]);
				i++;
			}

			// CheckboxListItem[] CLI = { new CheckboxListItem("계란", 3, 1), new
			// CheckboxListItem("달걀", 2, 3) };

			JList List_Ref = new JList(createData(strs));
			scrollPane.setViewportView(List_Ref);
			// Use a CheckboxListRenderer (see below)
			// to renderer list cells
			List_Ref.setCellRenderer(new CheckListRenderer());
			List_Ref.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			// Add a mouse listener to handle changing selection
			List_Ref.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					JList list_3 = (JList) event.getSource();
					// Get index of item clicked
					int index = list_3.locationToIndex(event.getPoint());
					CheckboxListItem item = (CheckboxListItem) list_3.getModel().getElementAt(index);
					// Toggle selected state
					item.setSelected(!item.isSelected());
					// Repaint cell
					list_3.repaint(list_3.getCellBounds(index, index));
				}
			});

			// 냉동
			// 끝*****************************************************************

			// 냉장*******************************************************************
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(14, 162, 269, 145);
			getContentPane().add(panel_2);
			panel_2.setLayout(null);

			JLabel Label_Cold = new JLabel("\uB0C9\uC7A5");
			Label_Cold.setBounds(0, 0, 62, 18);
			panel_2.add(Label_Cold);

			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(17, 26, 235, 104);
			scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_2.add(scrollPane_1);
			
			pstmt = c.prepareStatement("select c_name,c_count,c_life from cold");
			rset = pstmt.executeQuery();
			count = 0;

			while (rset.next())
				count++;
			
			strs1 = new String[100];
			strs1[0] = null;
			strs2 = new int[100];
			strs2[0] = 0;
			strs3 = new int[100];
			strs3[0] = 0;
			strs = new String[count];
			strs[0] = null;

			pstmt = c.prepareStatement("select c_name,c_count,c_life from cold");
			rset = pstmt.executeQuery();

			i = 0;
			while (rset.next()) {
				strs1[i] = rset.getString("c_name");
				strs2[i] = rset.getInt("c_count");
				strs3[i] = rset.getInt("c_life");
				strs[i] = strs1[i] + " " + strs2[i] + " " + strs3[i];
				System.out.println(strs[i]);
				i++;
			}

			JList List_Cold = new JList(createData(strs));
			scrollPane_1.setViewportView(List_Cold);

			// Use a CheckboxListRenderer (see below)
			// to renderer list cells
			List_Cold.setCellRenderer(new CheckListRenderer());
			List_Cold.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			// Add a mouse listener to handle changing selection
			List_Cold.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					JList list_1 = (JList) event.getSource();
					// Get index of item clicked
					int index = list_1.locationToIndex(event.getPoint());
					CheckboxListItem item = (CheckboxListItem) list_1.getModel().getElementAt(index);
					// Toggle selected state
					item.setSelected(!item.isSelected());
					// Repaint cell
					list_1.repaint(list_1.getCellBounds(index, index));
				}
			});
			// 냉장
			// 끝******************************************************************
			// 상온********************************************************************
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(14, 304, 269, 145);
			getContentPane().add(panel);

			JLabel Label_Ordinary = new JLabel("\uC0C1\uC628");
			Label_Ordinary.setBounds(0, 0, 41, 27);
			panel.add(Label_Ordinary);

			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_2.setBounds(17, 30, 235, 100);
			panel.add(scrollPane_2);

			pstmt = c.prepareStatement("select o_name,o_count,o_life from ordinary");
			rset = pstmt.executeQuery();
			count = 0;

			while (rset.next())
				count++;

			strs1 = new String[100];
			strs1[0] = null;
			strs2 = new int[100];
			strs2[0] = 0;
			strs3 = new int[100];
			strs3[0] = 0;
			strs = new String[count];
			strs[0] = null;

			pstmt = c.prepareStatement("select o_name,o_count,o_life from ordinary");
			rset = pstmt.executeQuery();

			i = 0;
			while (rset.next()) {
				strs1[i] = rset.getString("o_name");
				strs2[i] = rset.getInt("o_count");
				strs3[i] = rset.getInt("o_life");
				strs[i] = strs1[i] + " " + strs2[i] + " " + strs3[i];
				System.out.println(strs[i]);
				i++;
			}

			JList List_Ordinary = new JList(createData(strs));
			scrollPane_2.setViewportView(List_Ordinary);

			// Use a CheckboxListRenderer (see below)
			// to renderer list cells
			List_Ordinary.setCellRenderer(new CheckListRenderer());
			List_Ordinary.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JButton button = new JButton("\uBA54\uB274\uBCF4\uAE30");
			button.setBounds(620, 38, 81, 41);
			getContentPane().add(button);

			// Add a mouse listener to handle changing selection
			List_Ordinary.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					JList list_2 = (JList) event.getSource();
					// Get index of item clicked
					int index = list_2.locationToIndex(event.getPoint());
					CheckboxListItem item = (CheckboxListItem) list_2.getModel().getElementAt(index);
					// Toggle selected state
					item.setSelected(!item.isSelected());
					// Repaint cell
					list_2.repaint(list_2.getCellBounds(index, index));
				}
			});
			// 상온
			// 끝********************************************************************
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	// 체크박스리스트********************************************************************
	private CheckboxListItem[] createData(String[] strs) {
		int n = strs.length;
		CheckboxListItem[] items = new CheckboxListItem[n];
		for (int i = 0; i < n; i++) {
			items[i] = new CheckboxListItem(strs[i]);
		}
		return items;
	}

	class CheckboxListItem {
		private String f_name;
		private int f_num;
		private int f_date;
		private String str;
		private boolean isSelected = false;

		public CheckboxListItem(String f_name, int f_num, int f_date) {
			this.f_name = f_name;
			this.f_num = f_num;
			this.f_date = f_date;
		}

		////////////////////////////////////////// 체크리스트에 필요한
		/*
		 * public String setName(String name) { this.f_name = name; return
		 * f_name; }
		 * 
		 * public int setNum(int num) { this.f_num = num; return f_num; }
		 * 
		 * public int setDate(int num) { this.f_date = num; return f_date; }
		 */
		/////////////////////////////////////////////
		public boolean isSelected() {
			return isSelected;
		}

		public void setSelected(boolean isSelected) {
			this.isSelected = isSelected;
		}

		public CheckboxListItem(String str) {
			this.str = str;
			isSelected = false;
		}

		public String toString() {
			return str;
		}
	}

	// Handles rendering cells in the list using a check box
	/*
	 * class CheckboxListRenderer extends JCheckBox implements
	 * ListCellRenderer<CheckboxListItem> {
	 * 
	 * @Override public Component getListCellRendererComponent(JList<? extends
	 * CheckboxListItem> list, CheckboxListItem value, int index, boolean
	 * isSelected, boolean cellHasFocus) { setEnabled(list.isEnabled());
	 * setSelected(value.isSelected()); setFont(list.getFont());
	 * setBackground(list.getBackground()); setForeground(list.getForeground());
	 * setText(value.toString()); return this; } }
	 */
	class CheckListRenderer extends JCheckBox implements ListCellRenderer {

		public CheckListRenderer() {
			setBackground(UIManager.getColor("List.textBackground"));
			setForeground(UIManager.getColor("List.textForeground"));
		}

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean hasFocus) {
			setEnabled(list.isEnabled());
			setSelected(((CheckboxListItem) value).isSelected());
			setFont(list.getFont());
			setText(value.toString());
			return this;
		}
	}
}
