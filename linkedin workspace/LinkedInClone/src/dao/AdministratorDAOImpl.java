package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Administrator;

public class AdministratorDAOImpl implements AdministratorDAO 
{

	@Override
	public Administrator find(long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Administrator admin = em.find(Administrator.class, id);
		EntityManagerHelper.closeEntityManager();
        return admin;
	}

	@Override
	public List<Administrator> list() {
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
	
	@Override
	public Administrator login(String email, String password) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		String qString = "SELECT a FROM Administrator a WHERE a.email = :email AND a.password = :password";
        Query q = em.createQuery(qString);
        q.setParameter("email",email);
        q.setParameter("password",password);
        Administrator admin;
        try {
        	admin = (Administrator) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return admin;
	}
	

}
