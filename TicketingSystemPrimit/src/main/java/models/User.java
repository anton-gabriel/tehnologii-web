package models;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idutilizator;

	private String password;

	private String tiputilizator;

	private String username;

	public User() {
	}

	public Integer getIdutilizator() {
		return this.idutilizator;
	}

	public void setIdutilizator(Integer idutilizator) {
		this.idutilizator = idutilizator;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTiputilizator() {
		return this.tiputilizator;
	}

	public void setTiputilizator(String tiputilizator) {
		this.tiputilizator = tiputilizator;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

public User(String username, String password, String userType) {
		super();
		this.password = password;
		this.tiputilizator = userType;
		this.username = username;
	}

	public User(String username, String password) {
		super();
		this.password = password;
		this.username = username;
	}

	public User(int i, String string, String string2, String string3) {
		super();
		this.idutilizator=i;
		this.password = string;
		this.tiputilizator = string2;
		this.username = string3;
	}

	@Override
	public String toString() {
		return "Utilizatori [idutilizator=" + idutilizator + ", password=" + password + ", tiputilizator="
				+ tiputilizator + ", username=" + username + "]";
	}

}