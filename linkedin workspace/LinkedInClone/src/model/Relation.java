package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the relations database table.
 * 
 */
@Entity
@Table(name="relations")
@NamedQuery(name="Relation.findAll", query="SELECT r FROM Relation r")
public class Relation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RelationPK id;

	private int status;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="id1")
	private Professional professional1;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="id2")
	private Professional professional2;

	public Relation() {
	}

	public RelationPK getId() {
		return this.id;
	}

	public void setId(RelationPK id) {
		this.id = id;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Professional getProfessional1() {
		return this.professional1;
	}

	public void setProfessional1(Professional professional1) {
		this.professional1 = professional1;
	}

	public Professional getProfessional2() {
		return this.professional2;
	}

	public void setProfessional2(Professional professional2) {
		this.professional2 = professional2;
	}

}