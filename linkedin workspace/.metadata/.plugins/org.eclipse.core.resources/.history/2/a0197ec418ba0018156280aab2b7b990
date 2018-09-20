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
	public boolean emailExists(String email) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		String qString = "SELECT p FROM Professional p WHERE p.email = :email";
        Query q = em.createQuery(qString);
        q.setParameter("email",email);
        try {
        	Professional prof;
        	prof = (Professional) q.getSingleResult();
        	if(prof == null) return false;
        } catch (Exception e) {
            return false;
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return true;
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
	public Professional register(String name, String surname, String email,
			String telephone, String password, String job_title)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
        Professional prof = new Professional();
        prof.setEmail(email);
        prof.setPassword(password);
        prof.setName(name);
        prof.setSurname(surname);
        prof.setTelephone(telephone);
        prof.setJobTitle(job_title);
        try {
        	em.getTransaction().begin();
            em.persist(prof); //em.merge(u); for updates
            em.getTransaction().commit();
        } catch (Exception e) {
            return null;
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return prof;
	}
	

}