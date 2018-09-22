package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the experience database table.
 * 
 */
@Entity
@Table(name="experience")
@NamedQuery(name="Experience.findAll", query="SELECT e FROM Experience e")
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="`experience_id`")
	private int experienceId;

	@Column(name="`from`")
	private String from;

	@Column(name="`title`")
	private String title;
	
	@Column(name="`description`")
	private String description;

	@Column(name="`to`")
	private String to;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="id")
	private Professional professional;

	public Experience() {
	}

	public int getExperienceId() {
		return this.experienceId;
	}

	public void setExperienceId(int experienceId) {
		this.experienceId = experienceId;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}