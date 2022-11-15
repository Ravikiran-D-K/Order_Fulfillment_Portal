package com.boomi.project.model;

import java.io.Serializable;
import java.util.Date;

public class EmployeePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Email;
    private String Password;

    public EmployeePK() {
    }
    
    public EmployeePK(String email, String password) {
		super();
		this.Email = email;
		this.Password = password;
	}

	public String getEmail() {
		return Email;
	}
    
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		this.Password = password;
	}

	public int hashCode() {
        return (int) Email.hashCode()+(int) Password.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof EmployeePK)) return false;
        if (obj == null) return false;
        EmployeePK pk = (EmployeePK) obj;
        return pk.Password.equals(Password) && pk.Email.equals(Email);
    }
}
