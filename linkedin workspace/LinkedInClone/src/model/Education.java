package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="`education_id`")
	private int educationId;

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
	@JsonIgnore
	private Professional professional;

	public Education() {
	}

	public int getEducationId() {
		return this.educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
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