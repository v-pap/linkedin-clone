package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the administrators database table.
 * 
 */
@Entity
@Table(name="administrators")
@NamedQuery(name="Administrator.findAll", query="SELECT a FROM Administrator a")
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String password;

	public Administrator() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}