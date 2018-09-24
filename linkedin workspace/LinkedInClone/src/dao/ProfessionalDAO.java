package dao;

import java.util.List;

import model.Experience;
import model.Message;
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
	
	public ProfessionalInfo updateRelations(Professional prof);
	
	public Relation find_relation(Professional prof1, Professional prof2);
	
	public List<Message> list_messages(Professional prof1, Professional prof2);

}