package messenger.util;

import java.util.List;
import java.util.Vector;

import messenger.server.TalkServerThread;

public class Room {
	// 해당 톡방에 입장한 유저 리스트(스레드)
	public List<TalkServerThread>	userList		= new Vector<TalkServerThread>();
	// 해당 톡방에 입장한 유저의 아이디
	public List<String>				idList			= new Vector<String>();
	// 해당 톡방에 입장한 유저의 닉네임
	public List<String>				nicknameList	= new Vector<String>();
	private String					title			= null;								// 단톡방 이름
	private String					state			= null;								// 대기실, 참여중
	int								max				= 0;								// 최대정원수
	private int						current;											// 현재 정원수

	public Room() {
	}

	public Room(String title, int current) {
		this.title = title;
		this.current = current;
	}

	public Room(String title, String state, int current) {
		this.title = title;
		this.state = state;
		this.current = current;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}
