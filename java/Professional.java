import java.util.List;

public class Professional {
	private int id;
	private String email;
	private String jobTitle;
	private String name;
	private String password;
	private String path;
	private boolean skillsPrivate;
	private String surname;
	private String telephone;
	private List<Comment> comments;
	private List<JobApply> jobApplies;
	private List<JobOffer> jobOffers1;
	private List<JobOffer> jobOffers2;
	private List<Like> likes;
	private List<Post> posts1;
	private List<Post> posts2;
	private List<Relation> relations1;
	private List<Relation> relations2;
	private List<Skill> skills;

	public Professional() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean getSkillsPrivate() {
		return this.skillsPrivate;
	}

	public void setSkillsPrivate(boolean skillsPrivate) {
		this.skillsPrivate = skillsPrivate;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setProfessional(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setProfessional(null);

		return comment;
	}

	public List<JobApply> getJobApplies() {
		return this.jobApplies;
	}

	public void setJobApplies(List<JobApply> jobApplies) {
		this.jobApplies = jobApplies;
	}

	public JobApply addJobApply(JobApply jobApply) {
		getJobApplies().add(jobApply);
		jobApply.setProfessional(this);

		return jobApply;
	}

	public JobApply removeJobApply(JobApply jobApply) {
		getJobApplies().remove(jobApply);
		jobApply.setProfessional(null);

		return jobApply;
	}

	public List<JobOffer> getJobOffers1() {
		return this.jobOffers1;
	}

	public void setJobOffers1(List<JobOffer> jobOffers1) {
		this.jobOffers1 = jobOffers1;
	}

	public List<JobOffer> getJobOffers2() {
		return this.jobOffers2;
	}

	public void setJobOffers2(List<JobOffer> jobOffers2) {
		this.jobOffers2 = jobOffers2;
	}

	public JobOffer addJobOffers2(JobOffer jobOffers2) {
		getJobOffers2().add(jobOffers2);
		jobOffers2.setProfessional(this);

		return jobOffers2;
	}

	public JobOffer removeJobOffers2(JobOffer jobOffers2) {
		getJobOffers2().remove(jobOffers2);
		jobOffers2.setProfessional(null);

		return jobOffers2;
	}

	public List<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Like addLike(Like like) {
		getLikes().add(like);
		like.setProfessional(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setProfessional(null);

		return like;
	}

	public List<Post> getPosts1() {
		return this.posts1;
	}

	public void setPosts1(List<Post> posts1) {
		this.posts1 = posts1;
	}

	public List<Post> getPosts2() {
		return this.posts2;
	}

	public void setPosts2(List<Post> posts2) {
		this.posts2 = posts2;
	}

	public Post addPosts2(Post posts2) {
		getPosts2().add(posts2);
		posts2.setProfessional(this);

		return posts2;
	}

	public Post removePosts2(Post posts2) {
		getPosts2().remove(posts2);
		posts2.setProfessional(null);

		return posts2;
	}

	public List<Relation> getRelations1() {
		return this.relations1;
	}

	public void setRelations1(List<Relation> relations1) {
		this.relations1 = relations1;
	}

	public Relation addRelations1(Relation relations1) {
		getRelations1().add(relations1);
		relations1.setProfessional1(this);

		return relations1;
	}

	public Relation removeRelations1(Relation relations1) {
		getRelations1().remove(relations1);
		relations1.setProfessional1(null);

		return relations1;
	}

	public List<Relation> getRelations2() {
		return this.relations2;
	}

	public void setRelations2(List<Relation> relations2) {
		this.relations2 = relations2;
	}

	public Relation addRelations2(Relation relations2) {
		getRelations2().add(relations2);
		relations2.setProfessional2(this);

		return relations2;
	}

	public Relation removeRelations2(Relation relations2) {
		getRelations2().remove(relations2);
		relations2.setProfessional2(null);

		return relations2;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Skill addSkill(Skill skill) {
		getSkills().add(skill);
		skill.setProfessional(this);

		return skill;
	}

	public Skill removeSkill(Skill skill) {
		getSkills().remove(skill);
		skill.setProfessional(null);

		return skill;
	}

	 public boolean findRemoveProfessional(List<Professional> profs)
	 {
	    for(Professional temp_prof : profs)
	    {
	        if(temp_prof.getId() == id)
	        {
	        	profs.remove(temp_prof);
	            return true;
	        }
	    }
	    return false;
	}

	 public boolean alreadyApplied(int id)
	 {
	    for(JobOffer job_offer : this.jobOffers1)
	    {
	        if(job_offer.getJobId() == id)
	        {
	            return true;
	        }
	    }
	    return false;
	}

}