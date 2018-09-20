package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the job_applies database table.
 * 
 */
@Embeddable
public class JobApplyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="job_id", insertable=false, updatable=false)
	private int jobId;

	@Column(insertable=false, updatable=false)
	private int id;

	public JobApplyPK() {
	}
	public int getJobId() {
		return this.jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobApplyPK)) {
			return false;
		}
		JobApplyPK castOther = (JobApplyPK)other;
		return 
			(this.jobId == castOther.jobId)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.jobId;
		hash = hash * prime + this.id;
		
		return hash;
	}
}