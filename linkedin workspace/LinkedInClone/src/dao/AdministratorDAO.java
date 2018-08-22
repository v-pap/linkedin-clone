package dao;

import java.util.List;

import model.Administrator;

public interface AdministratorDAO 
{
	public Administrator find(long id);

    public List<Administrator> list();

    public void create(Administrator admin);
    
    public Administrator login(String email, String password);

}