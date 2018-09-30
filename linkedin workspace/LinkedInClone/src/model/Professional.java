package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the professionals database table.
 * 
 */
@Entity
@Table(name="professionals")
@NamedQueries({
@NamedQuery(name="Professional.findAll", query="SELECT p FROM Professional p"),
@NamedQuery(name="Professional.search", query="SELECT DISTINCT p FROM Professional p WHERE (UPPER(CONCAT(p.name,p.surname)) LIKE UPPER(:search_name) OR UPPER(CONCAT(p.surname,p.name)) LIKE UPPER(:search_name))")
})
public class Professional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="`id`")
	private int id;

	@Column(name="education_private")
	private boolean educationPrivate;

	private String email;

	@Column(name="experience_private")
	private boolean experiencePrivate;

	@Column(name="job_title")
	private String jobTitle;

	@Column(name="`name`")
	private String name;

	private String password;

	private String path;

	@Column(name="skills_private")
	private boolean skillsPrivate;

	@Column(name="`surname`")
	private String surname;

	@Column(name="`telephone`")
	private String telephone;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="professional", cascade = CascadeType.ALL) 
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Comment> comments;

	//bi-directional many-to-one association to Education
	@OneToMany(mappedBy="professional", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Education> educations;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="professional", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Experience> experiences;

	//bi-directional many-to-one association to JobApply
	@OneToMany(mappedBy="professional", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<JobApply> jobApplies;

	//bi-directional many-to-many association to JobOffer
	@ManyToMany(mappedBy="professionals", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<JobOffer> jobOffers1;

	//bi-directional many-to-one association to JobOffer
	@OneToMany(mappedBy="professional", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<JobOffer> jobOffers2;

	//bi-directional many-to-one association to Like
	@OneToMany(mappedBy="professional", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Like> likes;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="professional1", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="professional2", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Message> messages2;

	//bi-directional many-to-many association to Post
	@ManyToMany(mappedBy="professionals", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Post> posts1;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="professional", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Post> posts2;

	//bi-directional many-to-one association to Relation
	@OneToMany(mappedBy="professional1", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Relation> relations1;

	//bi-directional many-to-one association to Relation
	@OneToMany(mappedBy="professional2", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Relation> relations2;

	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="professional", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"professional","professional1","professional2","relations1","relations2"})
	private List<Skill> skills;

	public Professional() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getEducationPrivate() {
		return this.educationPrivate;
	}

	public void setEducationPrivate(boolean educationPrivate) {
		this.educationPrivate = educationPrivate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getExperiencePrivate() {
		return this.experiencePrivate;
	}

	public void setExperiencePrivate(boolean experiencePrivate) {
		this.experiencePrivate = experiencePrivate;
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

	public List<Education> getEducations() {
		return this.educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public Education addEducation(Education education) {
		getEducations().add(education);
		education.setProfessional(this);

		return education;
	}

	public Education removeEducation(Education education) {
		getEducations().remove(education);
		education.setProfessional(null);

		return education;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setProfessional(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setProfessional(null);

		return experience;
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

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setProfessional1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setProfessional1(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setProfessional2(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setProfessional2(null);

		return messages2;
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
	 
	 public boolean alreadyLiked(int id)
	 {
	    for(Like like : this.likes)
	    {
	        if(like.getPost().getPostId() == id)
	        {
	            return true;
	        }
	    }
	    return false;
	}
	 
	 public boolean Connected(int id)
	 {
	    for(Relation rel : this.relations1)
	    {
	        if(rel.getProfessional2().getId() == id)
	        {
	        	if(rel.getStatus() == 0)
	        		return true;
	        	else
	        		return false;
	        }
	    }
	    for(Relation rel : this.relations2)
	    {
	        if(rel.getProfessional1().getId() == id)
	        {
	        	if(rel.getStatus() == 0)
	        		return true;
	        	else
	        		return false;
	        }
	    }
	    return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + (educationPrivate ? 1231 : 1237);
		result = prime * result + ((educations == null) ? 0 : educations.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (experiencePrivate ? 1231 : 1237);
		result = prime * result + ((experiences == null) ? 0 : experiences.hashCode());
		result = prime * result + id;
		result = prime * result + ((jobApplies == null) ? 0 : jobApplies.hashCode());
		result = prime * result + ((jobOffers1 == null) ? 0 : jobOffers1.hashCode());
		result = prime * result + ((jobOffers2 == null) ? 0 : jobOffers2.hashCode());
		result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result + ((messages1 == null) ? 0 : messages1.hashCode());
		result = prime * result + ((messages2 == null) ? 0 : messages2.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((posts1 == null) ? 0 : posts1.hashCode());
		result = prime * result + ((posts2 == null) ? 0 : posts2.hashCode());
		result = prime * result + ((relations1 == null) ? 0 : relations1.hashCode());
		result = prime * result + ((relations2 == null) ? 0 : relations2.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + (skillsPrivate ? 1231 : 1237);
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professional other = (Professional) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (educationPrivate != other.educationPrivate)
			return false;
		if (educations == null) {
			if (other.educations != null)
				return false;
		} else if (!educations.equals(other.educations))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (experiencePrivate != other.experiencePrivate)
			return false;
		if (experiences == null) {
			if (other.experiences != null)
				return false;
		} else if (!experiences.equals(other.experiences))
			return false;
		if (id != other.id)
			return false;
		if (jobApplies == null) {
			if (other.jobApplies != null)
				return false;
		} else if (!jobApplies.equals(other.jobApplies))
			return false;
		if (jobOffers1 == null) {
			if (other.jobOffers1 != null)
				return false;
		} else if (!jobOffers1.equals(other.jobOffers1))
			return false;
		if (jobOffers2 == null) {
			if (other.jobOffers2 != null)
				return false;
		} else if (!jobOffers2.equals(other.jobOffers2))
			return false;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (likes == null) {
			if (other.likes != null)
				return false;
		} else if (!likes.equals(other.likes))
			return false;
		if (messages1 == null) {
			if (other.messages1 != null)
				return false;
		} else if (!messages1.equals(other.messages1))
			return false;
		if (messages2 == null) {
			if (other.messages2 != null)
				return false;
		} else if (!messages2.equals(other.messages2))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (posts1 == null) {
			if (other.posts1 != null)
				return false;
		} else if (!posts1.equals(other.posts1))
			return false;
		if (posts2 == null) {
			if (other.posts2 != null)
				return false;
		} else if (!posts2.equals(other.posts2))
			return false;
		if (relations1 == null) {
			if (other.relations1 != null)
				return false;
		} else if (!relations1.equals(other.relations1))
			return false;
		if (relations2 == null) {
			if (other.relations2 != null)
				return false;
		} else if (!relations2.equals(other.relations2))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		if (skillsPrivate != other.skillsPrivate)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

}