package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the skills database table.
 * 
 */
@Entity
@Table(name="skills")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SkillPK id;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="id")
	@JsonIgnore
	private Professional professional;

	public Skill() {
	}

	public SkillPK getId() {
		return this.id;
	}

	public void setId(SkillPK id) {
		this.id = id;
	}

	public Professional getProfessional() {
		return this.professional;
	}

	public void setProfessional(Professional professional) {
		this.professional = professional;
	}

}