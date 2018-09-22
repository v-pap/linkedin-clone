package dao;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpautils.EntityManagerHelper;
import model.Experience;
import model.Professional;
import helper.ProfessionalInfo;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Professional> list() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createNamedQuery("Professional.findAll");
		List<Professional> profs;
		try {
			profs = query.getResultList();
		} catch (Exception e) {
        	return null;
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return profs;
	}

	@Override
	public void create(Professional prof) 
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.persist(prof);
		EntityManagerHelper.closeEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ProfessionalInfo login(String email, String password) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		String qString = "SELECT p FROM Professional p WHERE p.email = :email AND p.password = :password";
        Query q = em.createQuery(qString);
        q.setParameter("email",email);
        q.setParameter("password",password);
        List<Professional> results;
        try {
        	results = q.getResultList();
        } catch (Exception e) {
        	return new ProfessionalInfo(null,"DB error");
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        if(results.isEmpty())	return new ProfessionalInfo(null,"Wrong email or password");
        return new ProfessionalInfo(results.get(0),"");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ProfessionalInfo register(String name, String surname, String email,
			String telephone, String password, String job_title, String path)
	{
		String qString = "SELECT p FROM Professional p WHERE p.email = :email";
		EntityManager em = EntityManagerHelper.getEntityManager();
        Query q = em.createQuery(qString);
        q.setParameter("email",email);
        List<Professional> results;
        try {
        	results = q.getResultList();
        } catch (Exception e) {
        	EntityManagerHelper.closeEntityManager();
        	return new ProfessionalInfo(null,"DB error");
        }
        if(!results.isEmpty()) return new ProfessionalInfo(null,"The email is already in use");
        Professional prof = new Professional();
        prof.setEmail(email);
        prof.setPassword(password);
        prof.setName(name);
        prof.setSurname(surname);
        prof.setTelephone(telephone);
        prof.setJobTitle(job_title);
        prof.setPath(path);
        try {
        	EntityManagerHelper.beginTransaction();
            em.persist(prof); //em.merge(u); for updates
            em.getTransaction().commit();
        } catch (Exception e) {
        	return new ProfessionalInfo(null,"DB error");
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return login(email,password);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ProfessionalInfo changeEmail(String newEmail, Professional prof)
	{
		String qString = "SELECT p FROM Professional p WHERE p.email = :email";
		EntityManager em = EntityManagerHelper.getEntityManager();
        Query q = em.createQuery(qString);
        q.setParameter("email",newEmail);
        List<Professional> results;
        try {
        	results = q.getResultList();
        } catch (Exception e) {
        	return new ProfessionalInfo(null,"DB error");
        }
        if(!results.isEmpty()) return new ProfessionalInfo(null,"The email is already in use");
        prof.setEmail(newEmail);
        try {
        	em.getTransaction().begin();
            prof = em.merge(prof);
            em.getTransaction().commit();
        } catch (Exception e) {
        	return new ProfessionalInfo(null,"DB error");
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return new ProfessionalInfo(prof,"");
	}
	
	@Override
	public ProfessionalInfo changePassword(String newPassword, Professional prof)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
        prof.setPassword(newPassword);
        try {
        	em.getTransaction().begin();
            prof = em.merge(prof);
            em.getTransaction().commit();
        } catch (Exception e) {
        	return new ProfessionalInfo(null,"DB error");
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return new ProfessionalInfo(prof,"");
	}
	
	@Override
	public ProfessionalInfo refreshProfile(Professional prof)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
        try {
        	em.getTransaction().begin();
        	prof = em.merge(prof);
        	prof.getEducations().size();
        	prof.getExperiences().size();
        	prof.getSkills().size();
        } catch (Exception e) {
        	e.printStackTrace(); 
            System.out.println(e); 
        	return new ProfessionalInfo(null,"DB error");
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return new ProfessionalInfo(prof,"");
	}
	
	@Override
	public ProfessionalInfo updateProfile(Professional prof, List<Experience> experiences)
	{
		EntityManager em = EntityManagerHelper.getEntityManager();
        try {
        	em.getTransaction().begin();
        	prof = em.merge(prof);
        	/*for (Iterator<Experience> it = experiences.iterator(); it.hasNext();) {
                Experience exp = it.next();

                em.persist(exp);
                em.flush();
                em.clear();
            }*/
            em.getTransaction().commit();
        } catch (Exception e) {
        	e.printStackTrace(); 
            System.out.println(e); 
        	return new ProfessionalInfo(null,"DB error");
        } finally {
        	EntityManagerHelper.closeEntityManager();
        }
        return refreshProfile(prof);
	}

}