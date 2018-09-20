package helper;
import model.Administrator;

public class AdministratorInfo extends ObjectInfo
{
	private Administrator admin;
	
	public AdministratorInfo(Administrator admin, String error)
	{
		this.admin = admin;
		this.error = error;
	}
	
	public Administrator getAdmin()
	{
		return admin;
	}
	
	public void setAdmin(Administrator admin)
	{
		this.admin = admin;
	}
}