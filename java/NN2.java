import java.util.ArrayList;
import java.util.List;

public class NN2
{
    public static void main(String[] args)
    {

        Professional user1 = new Professional(),
                     user2 = new Professional(),
                     user3 = new Professional(),
                     user4 = new Professional();
        user1.setId(1);
        user2.setId(2);
        user3.setId(3);
        user4.setId(4);

        ///

        Relation r_1_2 = new Relation();
        r_1_2.setProfessional1(user1);
        r_1_2.setProfessional2(user2);

        Relation r_1_4 = new Relation();
        r_1_4.setProfessional1(user1);
        r_1_4.setProfessional2(user4);

        List<Relation> l_r_1 = new ArrayList<Relation>();
        l_r_1.add(r_1_2);
        l_r_1.add(r_1_4);
        user1.setRelations1(l_r_1);

        Relation r_2_1 = new Relation();
        r_2_1.setProfessional1(user2);
        r_2_1.setProfessional2(user1);

        List<Relation> l_r_2 = new ArrayList<Relation>();
        l_r_2.add(r_2_1);
        user2.setRelations1(l_r_2);

        Relation r_4_1 = new Relation();
        r_4_1.setProfessional1(user4);
        r_4_1.setProfessional2(user1);

        List<Relation> l_r_4 = new ArrayList<Relation>();
        l_r_4.add(r_4_1);
        user4.setRelations1(l_r_4);

        ///

        SkillPK skill_pk_1 = new SkillPK();
        skill_pk_1.setId(1);
        skill_pk_1.setDescription("Programmer");

        Skill skill_1 = new Skill();
        skill_1.setId(skill_pk_1);
        skill_1.setProfessional(user1);

        SkillPK skill_pk_2 = new SkillPK();
        skill_pk_2.setId(2);
        skill_pk_2.setDescription("C++");

        Skill skill_2 = new Skill();
        skill_2.setId(skill_pk_2);
        skill_2.setProfessional(user1);

        SkillPK skill_pk_3 = new SkillPK();
        skill_pk_3.setId(3);
        skill_pk_3.setDescription("Python");

        Skill skill_3 = new Skill();
        skill_3.setId(skill_pk_3);
        skill_3.setProfessional(user1);

        List<Skill> l_s = new ArrayList<Skill>();
        l_s.add(skill_1);
        l_s.add(skill_2);
        l_s.add(skill_3);

        user1.setSkills(l_s);

        ///

        JobOffer job_offer_2 = new JobOffer(),
                 job_offer_3 = new JobOffer();

        job_offer_2.setJobId(2);
        job_offer_3.setJobId(3);

        job_offer_2.setText("programmer python java");
        job_offer_3.setText("C#");

        job_offer_2.setProfessional(user2);
        job_offer_3.setProfessional(user3);

        List<JobOffer> l_jb_2 = new ArrayList<JobOffer>(),
                       l_jb_3 = new ArrayList<JobOffer>();

        l_jb_2.add(job_offer_2);
        l_jb_3.add(job_offer_3);

        user2.setJobOffers2(l_jb_2);
        user3.setJobOffers2(l_jb_3);

        ///

        List<JobOffer> job_offers_list = new ArrayList<JobOffer>();
        job_offers_list.add(job_offer_2);
        job_offers_list.add(job_offer_3);

        nearest_neighbor nn = new nearest_neighbor();
        nn.nearest_neighbor_job_offers(user1, job_offers_list);

        System.out.println("Done.");
    }
}