package modelo;

public class NombreIncorrectoException extends Exception{

	private String nickname;
	public NombreIncorrectoException(String msg, String nickname) {
		super (msg);
		this.nickname = nickname;
	}

	public String darNickname() {
		return nickname;
	}
}
