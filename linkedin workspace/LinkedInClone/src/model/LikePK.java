package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the likes database table.
 * 
 */
@Embeddable
public class LikePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int id;

	@Column(name="post_id", insertable=false, updatable=false)
	private int postId;

	public LikePK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostId() {
		return this.postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LikePK)) {
			return false;
		}
		LikePK castOther = (LikePK)other;
		return 
			(this.id == castOther.id)
			&& (this.postId == castOther.postId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.postId;
		
		return hash;
	}
}