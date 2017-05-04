package compadresToy;

public class Doll extends Toy {

	private String nickname;

	public Doll() {
		setNickname("");
	}

	public Doll(String nickname) {

		setNickname(nickname);
	}

	public Doll(String nickname, int code) {

		setNickname(nickname);
		setCode(code);
	}

	public Doll(String nickname, String description) {

		setNickname(nickname);
		setDescription(description);
	}
	
	public Doll(String nickname, int code, String description) {

		setNickname(nickname);
		setCode(code);
		setDescription(description);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
