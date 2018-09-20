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
	@Column(name="experience_id")
	private int experienceId;

	private int from;

	@Column(name="private")
	private byte private_;

	private String title;

	private int to;

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

	public int getFrom() {
		return this.from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public byte getPrivate_() {
		return this.private_;
	}

	public void setPrivate_(byte private_) {
		this.private_ = private_;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTo() {
		return this.to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}