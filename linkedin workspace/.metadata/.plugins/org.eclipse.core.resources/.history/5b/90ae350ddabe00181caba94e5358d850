package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the relations database table.
 * 
 */
@Entity
@Table(name="relations")
@NamedQueries({
@NamedQuery(name="Relation.findAll", query="SELECT r FROM Relation r"),
@NamedQuery(name="Relation.findConnected", query="SELECT r FROM Relation r WHERE r.status = 0 AND (r.professional1 = :prof OR r.professional2 = :prof)"),
@NamedQuery(name="Relation.findStatus", query="SELECT r.status FROM Relation r WHERE (r.professional1 = :prof1 AND r.professional2 = :prof2) OR (r.professional1 = :prof2 AND r.professional2 = :prof1)")
}) 
public class Relation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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