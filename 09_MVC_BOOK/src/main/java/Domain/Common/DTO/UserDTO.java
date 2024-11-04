package Domain.Common.DTO;

public class UserDTO {
	private String username;
	private String password;
	private String role;
	private boolean isLocked;
	//디폴트 생성자
	public UserDTO() {}
	
	//모든인자 생성자
	public UserDTO(String username, String password, String role, boolean isLocked) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.isLocked = isLocked;
	}
	
	//Getter and Setter
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", role=" + role + ", isLocked=" + isLocked
				+ "]";
	}

	
	
	
	
}
