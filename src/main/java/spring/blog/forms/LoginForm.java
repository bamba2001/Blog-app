package spring.blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
	
	@Size(min=2, max=30, message="La taille du nom d'utilisateur doit être comprise dans la plage [2...30]")
	private String userName;
	
	@NotNull
	@Size(min=1, max=50)
	private String password;
	
	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}
}
