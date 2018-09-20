package model;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;


/**
 * The persistent class for the education database table.
 * 
 */
@Entity
@Table(name="education")
@NamedQuery(name="Education.findAll", query="SELECT e FROM Education e")
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="`education_id`")
	private int educationId;

	@Column(name="`from`")
	private LocalDate from;

	@Column(name="`private`")
	private boolean private_;
	
	@Column(name="`title`")
	private String title;
	
	@Column(name="`description`")
	private String description;

	@Column(name="`to`")
	private LocalDate to;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="id")
	private Professional professional;

	public Education() {
	}

	public int getEducationId() {
		return this.educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public LocalDate getFrom() {
		return this.from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public boolean getPrivate_() {
		return this.private_;
	}

	public void setPrivate_(boolean private_) {
		this.private_ = private_;
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

	public LocalDate getTo() {
		return this.to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}