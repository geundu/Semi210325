package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RoomListView extends JPanel implements ActionListener {
	MessengerClient	msgrClient		= null;
	String[]		roomName		= { "0번 방", "1번 방", "2번 방", "3번 방", "4번 방", "5번 방", "6번 방", "7번 방", "8번 방", "9번 방"
	};
	JList<String>	roomList		= new JList<>(roomName);
	JScrollPane		scrollPane_list	= new JScrollPane(roomList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public RoomListView() {

	}

	public RoomListView(MessengerClient msgrClient) {
		this.msgrClient = msgrClient;
		initDisplay();
	}

	public void initDisplay() {
		Font font = new Font("맑은 고딕", Font.PLAIN, 15);
		roomList.setFont(font);
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
