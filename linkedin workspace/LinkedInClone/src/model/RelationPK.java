package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the relations database table.
 * 
 */
@Embeddable
public class RelationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String email1;

	@Column(insertable=false, updatable=false)
	private String email2;

	public RelationPK() {
	}
	public String getEmail1() {
		return this.email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return this.email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RelationPK)) {
			return false;
		}
		RelationPK castOther = (RelationPK)other;
		return 
			this.email1.equals(castOther.email1)
			&& this.email2.equals(castOther.email2);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.email1.hashCode();
		hash = hash * prime + this.email2.hashCode();
		
		return hash;
	}
}