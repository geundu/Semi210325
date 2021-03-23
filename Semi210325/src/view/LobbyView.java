package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LobbyView extends JFrame {
	// [채팅방 리스트 패널]
	JPanel				panel_roomList		= null;

	JList<String>		roomList			= null;
	JScrollPane			scrollPane_roomList	= null;
	String[]			roomName			= { "채팅방1", "채팅방2", "채팅방3", "채팅방4" };
	// [채팅방 리스트 패널 끝]

	// [유저 리스트 패널]
	JPanel				panel_userList		= null;
	JPanel				centerInnerPanel	= null;
	JPanel				southInnerPanel		= null;

	JTable				table_userList		= null;
	DefaultTableModel	dtm_userList		= null;
	JScrollPane			scrollPane_userList	= null;

	JButton[]			buttons				= null;
	String[]			buttonName			= { "Chat", "Multi Chat", "Delete Account", "Sign out" };
	String[][]			data				= new String[0][1];
	String[]			column				= { "USER LIST" };
	// [유저 리스트 패널 끝]

	public LobbyView() {
		initDisplay();
	}

	public void initDisplay() {

		Font	buttonFont	= new Font("맑은 고딕", Font.PLAIN, 12);
		Font	roomFont	= new Font("맑은 고딕", Font.PLAIN, 20);

		panel_roomList = new JPanel(new BorderLayout());
		roomList = new JList<String>(roomName);
		roomList.setFont(roomFont);
		scrollPane_roomList = new JScrollPane(roomList);
		panel_roomList.add("Center", scrollPane_roomList);

		panel_userList = new JPanel(new BorderLayout());
		centerInnerPanel = new JPanel(new BorderLayout());
		southInnerPanel = new JPanel(new GridLayout(2, 2, 5, 5));

		dtm_userList = new DefaultTableModel(data, column);
		table_userList = new JTable(dtm_userList);
		scrollPane_userList = new JScrollPane(table_userList);
		buttons = new JButton[buttonName.length];

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonName[i]);
			buttons[i].setFont(buttonFont);
//			buttons[i].addActionListener(null);
			southInnerPanel.add(buttons[i]);
		}

		centerInnerPanel.add(scrollPane_userList);
		panel_userList.add("Center", centerInnerPanel);
		panel_userList.add("South", southInnerPanel);

		this.setLayout(new GridLayout(1, 2, 3, 3));
		this.add(panel_roomList);
		this.add(panel_userList);

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("LobbyView");
		this.setSize(700, 600);
		this.setResizable(false);
		this.setVisible(true);
	}

//	public static void main(String[] args) {
//		new LobbyView();
//	}
}
