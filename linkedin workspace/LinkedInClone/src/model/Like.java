package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the likes database table.
 * 
 */
@Entity
@Table(name="likes")
@NamedQuery(name="Like.findAll", query="SELECT l FROM Like l")
public class Like implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LikePK id;

	//bi-directional one-to-one association to Post
	@OneToOne
	@JoinColumn(name="post_id")
	private Post post;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="email")
	private Professional professional;

	public Like() {
	}

	public LikePK getId() {
		return this.id;
	}

	public void setId(LikePK id) {
		this.id = id;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}