package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Administrator;
import model.Professional;
import helper.AdministratorInfo;
import helper.ProfessionalInfo;

public class AdministratorDAOImpl implements AdministratorDAO 
{

	@Override
	public Administrator find(long id)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		Administrator admin = em.find(Administrator.class, id);
		EntityManagerHelper.closeEntityManager();
        return admin;
	}

	@Override
	public List<Administrator> list()
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createNamedQuery("admin.findAll");
		@SuppressWarnings("unchecked")
		List<Administrator> admins = query.getResultList();  
		EntityManagerHelper.closeEntityManager();
        return admins;
	}

	@Override
	public void create(Administrator admin) 
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(admin);
		EntityManagerHelper.closeEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public AdministratorInfo login(String email, String password)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		String qString = "SELECT a FROM Administrator a WHERE a.email = :email AND a.password = :password";
        Query q = em.createQuery(qString);
        q.setParameter("email",email);
        q.setParameter("password",password);
        List<Administrator> results;
        try {
        	results = q.getResultList();
        } catch (Exception e) {
        	return new AdministratorInfo(null,"DB error");
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        if(results.isEmpty())	return new AdministratorInfo(null,"Wrong email or password");
        return new AdministratorInfo(results.get(0),"");
	}
	

}
