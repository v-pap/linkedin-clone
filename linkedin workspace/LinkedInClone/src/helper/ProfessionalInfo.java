package helper;
import model.Professional;

public class ProfessionalInfo extends ObjectInfo
{
	private Professional prof;
	
	public ProfessionalInfo(Professional prof, String error)
	{
		this.prof = prof;
		this.error = error;
	}
	
	public Professional getProf()
	{
		return prof;
	}
	
	public void setProf(Professional prof)
	{
		this.prof = prof;
	}
}
