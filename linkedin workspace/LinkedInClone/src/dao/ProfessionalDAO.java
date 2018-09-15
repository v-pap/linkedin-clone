package dao;

import java.util.List;

import model.Professional;

public interface ProfessionalDAO 
{
	public Professional find(long id);

    public List<Professional> list();
    
    public boolean emailExists(String email);

    public void create(Professional prof);
    
    public Professional login(String email, String password);

	public Professional register(String name, String surname, String email, String telephone, String password, String job_title);

}