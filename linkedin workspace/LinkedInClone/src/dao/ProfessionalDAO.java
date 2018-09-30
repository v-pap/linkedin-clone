package dao;

import java.util.List;

import model.Experience;
import model.JobOffer;
import model.Message;
import model.Post;
import model.Professional;
import model.Relation;
import helper.ProfessionalInfo;

public interface ProfessionalDAO 
{
	public Professional find(int id);

    public List<Professional> list();
    
    public boolean emailExists(String email);

    public void create(Professional prof);
    
    public ProfessionalInfo login(String email, String password);

	public ProfessionalInfo register(String name, String surname, String email, String telephone, String password, String job_title, String path);
	
	public ProfessionalInfo changeEmail(String newEmail, Professional prof);
	
	public ProfessionalInfo changePassword(String newPassword, Professional prof);
	
	public ProfessionalInfo refreshProfile(Professional prof);
	
	public ProfessionalInfo refreshMessages(Professional prof);
	
	public ProfessionalInfo updateProfile(Professional prof);
	
	public List<Professional> list_connected(Professional prof);
	
	public List<Professional> list_pending(Professional prof);
	
	public List<Professional> list_search(String searchName);
	
	public int check_status(Professional prof1, Professional prof2);
	
	public ProfessionalInfo updateRelations(Professional prof1, Professional prof2, int status);
	
	public ProfessionalInfo updateJobApplications(Professional prof);
	
	public Relation find_relation(Professional prof1, Professional prof2);
	
	public List<Message> list_messages(Professional prof1, Professional prof2);
	
	public List<JobOffer> list_available_jobs(Professional prof);
	
	public JobOffer find_job_offer(int id);
	
	public ProfessionalInfo updateJobOffers(Professional prof);
	
	public ProfessionalInfo refreshJobApplications(Professional prof);
	
	public List<JobOffer> list_my_jobs(Professional prof);
	
	public List<Post> list_posts(Professional prof);
	
	public ProfessionalInfo updatePosts(Professional prof);
	
	public Post find_post(int id);
	
	public ProfessionalInfo updateComments(Professional prof);
	
	public ProfessionalInfo updateLikes(Professional prof);
	
	public List<Post> list_myposts(Professional prof);
	
	public Professional find_latest_prof(Professional prof);

}