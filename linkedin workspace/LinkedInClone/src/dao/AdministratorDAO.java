package dao;

import java.util.List;

import model.Administrator;
import helper.AdministratorInfo;

public interface AdministratorDAO 
{
	public Administrator find(long id);

    public List<Administrator> list();

    public void create(Administrator admin);
    
    public AdministratorInfo login(String email, String password);

}