package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the posts database table.
 * 
 */
@Entity
@Table(name="posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="post_id")
	private int postId;

	@Lob
	private String text;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="post")
	private List<Comment> comments;

	//bi-directional one-to-one association to Like
	@OneToOne(mappedBy="post")
	private Like like;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="email")
	private Professional professional;

	//bi-directional many-to-many association to Professional
	@ManyToMany
	@JoinTable(
		name="likes"
		, joinColumns={
			@JoinColumn(name="post_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="email")
			}
		)
	private List<Professional> professionals;

	public Post() {
	}

	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setPost(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setPost(null);

		return comment;
	}

	public Like getLike() {
		return this.like;
	}

	public void setLike(Like like) {
		this.like = like;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

	public List<Professional> getProfessionals() {
		return this.professionals;
	}

	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}

}