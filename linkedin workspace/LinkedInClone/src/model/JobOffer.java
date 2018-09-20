package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the job_offers database table.
 * 
 */
@Entity
@Table(name="job_offers")
@NamedQuery(name="JobOffer.findAll", query="SELECT j FROM JobOffer j")
public class JobOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="job_id")
	private int jobId;

	private String text;

	//bi-directional many-to-one association to JobApply
	@OneToMany(mappedBy="jobOffer")
	private List<JobApply> jobApplies;

	//bi-directional many-to-many association to Professional
	@ManyToMany
	@JoinTable(
		name="job_applies"
		, joinColumns={
			@JoinColumn(name="job_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id")
			}
		)
	private List<Professional> professionals;

	//bi-directional many-to-one association to Professional
	@ManyToOne
	@JoinColumn(name="id")
	private Professional professional;

	public JobOffer() {
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<JobApply> getJobApplies() {
		return this.jobApplies;
	}

	public void setJobApplies(List<JobApply> jobApplies) {
		this.jobApplies = jobApplies;
	}

	public JobApply addJobApply(JobApply jobApply) {
		getJobApplies().add(jobApply);
		jobApply.setJobOffer(this);

		return jobApply;
	}

	public JobApply removeJobApply(JobApply jobApply) {
		getJobApplies().remove(jobApply);
		jobApply.setJobOffer(null);

		return jobApply;
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