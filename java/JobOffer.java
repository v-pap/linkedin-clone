import java.util.List;

public class JobOffer {
	private int jobId;
	private String path;
	private String text;
	private List<JobApply> jobApplies;
	private List<Professional> professionals;
	private Professional professional;

	public JobOffer() {
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
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

	public boolean alreadyApplied(int id)
	{
	    for(Professional prof : professionals)
	    {
	        if(prof.getId() == id)
	        {
	            return true;
	        }
	    }
	    return false;
	}

}