package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FriendListView extends JPanel implements ActionListener {
	MessengerClient	msgrClient		= null;
	String[]		friendName		= { "강지우", "유성열", "이민주", "임동혁" };
	JList<String>	friendList		= new JList<>(friendName);
	JScrollPane		scrollPane_list	= new JScrollPane(friendList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public FriendListView() {

	}

	public FriendListView(MessengerClient msgrClient) {
		this.msgrClient = msgrClient;
		initDisplay();
	}

	public void initDisplay() {
		Font font = new Font("맑은 고딕", Font.PLAIN, 15);
		friendList.setFont(font);
		this.setLayout(new BorderLayout());
		this.add("Center", scrollPane_list);
		this.setSize(500, 400);
		this.setVisible(true);
	}

	public void message_process(String msg, String imgChoice) {

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

	}
}
