package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the post_pictures database table.
 * 
 */
@Entity
@Table(name="post_pictures")
@NamedQuery(name="PostPicture.findAll", query="SELECT p FROM PostPicture p")
public class PostPicture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="picture_id")
	private int pictureId;

	private String path;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;

	public PostPicture() {
	}

	public int getPictureId() {
		return this.pictureId;
	}

	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}