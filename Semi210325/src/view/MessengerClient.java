package view;

import java.awt.Color;
import java.awt.Font;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

public class MessengerClient extends JFrame {
	SignInView			signInView			= null;
	JTabbedPane			tabbedPane			= new JTabbedPane(JTabbedPane.LEFT);
	FriendListView		friendListView		= null;
	RoomListView		roomListView		= null;
	Socket				mySocket			= null;
	ObjectInputStream	ois					= null;
	ObjectOutputStream	oos					= null;
	String				ip					= "121.139.85.156";
	int					port				= 9234;
	String				nickname			= null;

	JMenuBar			menuBar				= null;
	JMenu				menu_myPage			= null;
	String[]			myPageName			= { "닉네임 변경", "로그아웃", "회원탈퇴" };
	JMenuItem[]			menuItem_myPage		= null;
	JMenu				menu_talkRoom		= null;
	String[]			talkRoomName		= { "오픈톡", "친구톡", "친구추가" };
	JMenuItem[]			menuItem_talkRoom	= null;

	public MessengerClient() {

	}

	public MessengerClient(SignInView signInView) {
		this.signInView = signInView;
		nickname = signInView.nickname;

		try {
			initDisplay();
			getConnection();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		this.setTitle(nickname + "님");

		try {
			mySocket = new Socket(ip, port);

			// 해당 부분에서 스레드 없으면 대기타는 것 같음
			oos = new ObjectOutputStream(mySocket.getOutputStream());
			ois = new ObjectInputStream(mySocket.getInputStream());
			// 톡방 정보 담기
			Room room = new Room();
			room.setTitle("스마트웹모바일 응용SW엔지니어");
			room.current = 10;
			room.state = "대기";
			// 100|나초보
////			oos.writeObject(Protocol.ROOM_IN+Protocol.seperator+nickName+Protocol.seperator+room.getTitle());
//			oos.writeObject(Protocol.WAIT
//										+ Protocol.seperator + nickname
//										+ Protocol.seperator + room.state);
//			MessengerClientThread msgrClientThread = new MessengerClientThread(this);
//			msgrClientThread.start();// TalkClientThread의 run호출됨.-콜백함수
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initDisplay() throws Exception {

		friendListView = new FriendListView(this);
		roomListView = new RoomListView(this);
		menuBar = new JMenuBar();
		menu_myPage = new JMenu("마이페이지");
		menuItem_myPage = new JMenuItem[myPageName.length];
		menu_talkRoom = new JMenu("톡방");
		menuItem_talkRoom = new JMenuItem[talkRoomName.length];

		for (int i = 0; i < myPageName.length; i++) {
			menuItem_myPage[i] = new JMenuItem(myPageName[i]);
			menu_myPage.add(menuItem_myPage[i]);
		}

		for (int i = 0; i < talkRoomName.length; i++) {
			menuItem_talkRoom[i] = new JMenuItem(talkRoomName[i]);
			menu_talkRoom.add(menuItem_talkRoom[i]);
		}

		tabbedPane.addTab("친구목록", friendListView);
		tabbedPane.addTab("톡방목록", roomListView);
		this.getContentPane().setBackground(Color.ORANGE);
		tabbedPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tabbedPane.setToolTipText("");
		menuBar.add(menu_myPage);
		menuBar.add(menu_talkRoom);

		this.setJMenuBar(menuBar);
		this.setResizable(false);
		this.add(tabbedPane);
		this.setSize(400, 600);
		this.setVisible(true);
	}
}