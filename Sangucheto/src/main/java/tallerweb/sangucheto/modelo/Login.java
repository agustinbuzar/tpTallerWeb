package tallerweb.sangucheto.modelo;

public class Login {
	
	private String user;
	private String pass;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public Boolean validarAdmin(Administrador administrador){
		
		if(administrador.getUser().equals(user) && administrador.getPass().equals(pass)){
			return true;
		}else
			return false;
	}

}
