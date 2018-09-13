package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Professional;

public class ProfessionalDAOImpl implements ProfessionalDAO 
{

	@Override
	public Professional find(long id) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Professional prof = em.find(Professional.class, id);
		EntityManagerHelper.closeEntityManager();
        return prof;
	}

	@Override
	public List<Professional> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createNamedQuery("Professional.findAll");
		@SuppressWarnings("unchecked")
		List<Professional> profs = query.getResultList();
		EntityManagerHelper.closeEntityManager();
        return profs;
	}

	@Override
	public void create(Professional prof) 
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(prof);
		EntityManagerHelper.closeEntityManager();
	}
	
	@Override
	public Professional login(String email, String password) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		String qString = "SELECT p FROM Professional p WHERE p.email = :email AND p.password = :password";
        Query q = em.createQuery(qString);
        q.setParameter("email",email);
        q.setParameter("password",password);
        Professional prof;
        try {
        	prof = (Professional) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return prof;
	}
	
	@Override
	public Professional register(String name, String surname, String email, String telephone, String password, String job_title) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		String qString = "SELECT p FROM Professional p WHERE p.email = :email AND p.password = :password";
		//"INSERT INTO professional (`email`, `password`, `name`, `surname`, `telephone`, `job_title`, `education_private`, `experience_private`, `skills_private`) VALUES (:email, :password, :name, :surname, :telephone, :job_title, 1, 1, 1)"
        Query q = em.createQuery(qString);
        q.setParameter("email",email);
        q.setParameter("password",password);
        Professional prof;
        try {
        	prof = (Professional) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return prof;
	}
	

}