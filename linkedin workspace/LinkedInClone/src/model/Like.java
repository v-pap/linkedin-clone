package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private LikePK id;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="post_id")
	@JsonIgnoreProperties({"likes","comments"})
	private Post post;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="id")
	@JsonIgnore
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