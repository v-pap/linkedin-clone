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
	private int id1;

	@Column(insertable=false, updatable=false)
	private int id2;

	public RelationPK() {
	}
	public int getId1() {
		return this.id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public int getId2() {
		return this.id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
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
			(this.id1 == castOther.id1)
			&& (this.id2 == castOther.id2);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id1;
		hash = hash * prime + this.id2;
		
		return hash;
	}
}