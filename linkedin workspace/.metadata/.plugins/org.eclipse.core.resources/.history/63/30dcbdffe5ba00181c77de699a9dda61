package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the skills database table.
 * 
 */
@Embeddable
public class SkillPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int id;

	private String description;

	public SkillPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SkillPK)) {
			return false;
		}
		SkillPK castOther = (SkillPK)other;
		return 
			(this.id == castOther.id)
			&& this.description.equals(castOther.description);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.description.hashCode();
		
		return hash;
	}
}