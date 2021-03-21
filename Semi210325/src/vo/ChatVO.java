package vo;

public class ChatVO {

	private String id = "";
	private String nickname = "";
	private String password = "";

	public ChatVO() {
	}

	public ChatVO(String id, String password) {
		this.id = id;
		this.nickname = "";
		this.password = password;
	}

	public ChatVO(String id, String nickname, String password) {
		this.id = id;
		this.nickname = nickname;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
