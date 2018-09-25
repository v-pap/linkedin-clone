import java.util.List;

public class Post {
	private int postId;
	private String text;
	private List<Comment> comments;
	private List<Like> likes;
	private List<Professional> professionals;
	private Professional professional;

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

	public List<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Like addLike(Like like) {
		getLikes().add(like);
		like.setPost(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setPost(null);

		return like;
	}

	public List<Professional> getProfessionals() {
		return this.professionals;
	}

	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}