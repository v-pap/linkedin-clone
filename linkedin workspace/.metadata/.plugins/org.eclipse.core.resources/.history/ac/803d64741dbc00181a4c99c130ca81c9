package dao;

import java.util.List;

import model.Professional;
import helper.ProfessionalInfo;

public interface ProfessionalDAO 
{
	public Professional find(long id);

    public List<Professional> list();
    
    public boolean emailExists(String email);

    public void create(Professional prof);
    
    public ProfessionalInfo login(String email, String password);

	public ProfessionalInfo register(String name, String surname, String email, String telephone, String password, String job_title);
	
	public ProfessionalInfo changeEmail(String newEmail, Professional prof);
	
	public ProfessionalInfo changePassword(String newPassword, Professional prof);

}