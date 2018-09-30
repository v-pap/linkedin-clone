package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashSet;
import model.Comment;
import model.JobOffer;
import model.Like;
import model.Post;
import model.Professional;
import model.Relation;
import model.Skill;

public class NearestNeighbor {
    public List<Post> NearestNeighborPosts(Professional current_user, List<Professional> network_users, List<Post> recent_posts) {
        /*
        Use nearest neighbor algorithm to calculate the vectors for users and find the most relevant
        posts for the currently logged in user.
        Arguments:
            current_user: currently logged in user
            networks_users: currently logged in user's contacts and their contacts
            recent_posts: all posts from the last 2 months

        Returns:
            posts_to_display: list of posts to be displayed in the order they are returned
        */
        ArrayList<Integer> network_ids = new ArrayList<Integer>();
        ArrayList<Integer> post_ids = new ArrayList<Integer>();

        for (Professional user : network_users) {
            network_ids.add(user.getId());
        }
        for (Post post : recent_posts) {
            post_ids.add(post.getPostId());
        }

        Integer[] user_is_contact = new Integer[network_users.size()],
                  user_has_liked = new Integer[recent_posts.size()],
                  user_has_commented = new Integer[recent_posts.size()];

        Arrays.fill(user_is_contact, 0);
        Arrays.fill(user_has_liked, 0);
        Arrays.fill(user_has_commented, 0);

        // Calculate vectors for current user
        for (int i = 0; i < network_ids.size(); i++) {
            if (current_user.getRelations1() != null) {
                for (Relation relation : current_user.getRelations1()) {
                    if (relation.getProfessional2().getId() == network_ids.get(i)) {
                        user_is_contact[i] = 1;
                        break;
                    }
                }
            }
            else {
                break;
            }
        }
        for (int i = 0; i < post_ids.size(); i++) {
            if (current_user.getLikes() != null) {
                for (Like like : current_user.getLikes()) {
                    if (like.getPost().getPostId() == post_ids.get(i)) {
                        user_has_liked[i] = 1;
                        break;
                    }
                }
            }
            else {
                break;
            }
        }
        for (int i = 0; i < post_ids.size(); i++) {
            if (current_user.getComments() != null) {
                for (Comment comment : current_user.getComments()) {
                    if (comment.getPost().getPostId() == post_ids.get(i)) {
                        user_has_commented[i] = 1;
                        break;
                    }
                }
            }
            else {
                break;
            }
        }


        List<Double> distance_list = new ArrayList<Double>();

        // Calculate vectors for network users
        for (int i = 0; i < network_ids.size(); i++) {
            Integer[] professional_is_contact = new Integer[network_users.size()],
                      professional_has_liked = new Integer[recent_posts.size()],
                      professional_has_commented = new Integer[recent_posts.size()];

            Arrays.fill(professional_is_contact, 0);
            Arrays.fill(professional_has_liked, 0);
            Arrays.fill(professional_has_commented, 0);

            for (int j = 0; j < network_ids.size(); j++) {
                if (network_users.get(i).getRelations1() != null) {
                    for (Relation relation : network_users.get(i).getRelations1()) {
                        if (relation.getProfessional2().getId() == network_ids.get(j) || j == i) {
                            professional_is_contact[j] = 1;
                            break;
                        }
                    }
                }
                else {
                    break;
                }
            }
            for (int j = 0; j < post_ids.size(); j++) {
                if (network_users.get(i).getLikes() != null) {
                    for (Like like : network_users.get(i).getLikes()) {
                        if (like.getPost().getPostId() == post_ids.get(j)) {
                            professional_has_liked[j] = 1;
                            break;
                        }
                    }
                }
                else {
                    break;
                }
            }
            for (int j = 0; j < post_ids.size(); j++) {
                if (network_users.get(i).getComments() != null) {
                    for (Comment comment : network_users.get(i).getComments()) {
                        if (comment.getPost().getPostId() == post_ids.get(j)) {
                            professional_has_commented[j] = 1;
                            break;
                        }
                    }
                }
                else {
                    break;
                }
            }
            Double contact_distance = eucleidian_distance(user_is_contact, professional_is_contact),
                   likes_distance = eucleidian_distance(user_has_liked, professional_has_liked),
                   comment_distance = eucleidian_distance(user_has_commented, professional_has_commented);

            distance_list.add((contact_distance + likes_distance + comment_distance) / 3);

        }

        TreeMap<Double, List<Professional>> map = new TreeMap<Double, List<Professional>>();
        for (int i = 0; i < network_users.size(); i++) {
            if (map.containsKey(distance_list.get(i))) {
                map.get(distance_list.get(i)).add(network_users.get(i));
            }
            else {
                ArrayList<Professional> network_users_list = new ArrayList<Professional>();
                network_users_list.add(network_users.get(i));
                map.put(distance_list.get(i), network_users_list);
            }
        }

        // TreeMap<Integer, Post> posts_map = new TreeMap<Integer, Post>();
        ArrayList<Post> posts_to_display = new ArrayList<Post>();

        for (Map.Entry<Double, List<Professional>> entry : map.entrySet()) {
            for (Post post : recent_posts) {
                for (Professional professional : entry.getValue()) {
                    if (post.getProfessional().getId() == professional.getId()) {
                        posts_to_display.add(post);
                    }
                }
            }
        }

        return posts_to_display;
    }

    public List<JobOffer> NearestNeighborJobOffers(Professional current_user, List<JobOffer> recent_job_offers) {
        Integer[] user_is_contact = new Integer[recent_job_offers.size()],
                  user_has_common_contacts = new Integer[recent_job_offers.size()],
                  user_has_skills = new Integer[recent_job_offers.size()];

        Arrays.fill(user_is_contact, 0);
        Arrays.fill(user_has_common_contacts, 0);
        Arrays.fill(user_has_skills, 0);

        // Calculate vectors
        for (int i = 0; i < recent_job_offers.size(); i++) {
            if (current_user.getRelations1() != null) {
                for (Relation relation : current_user.getRelations1()) {
                    if (relation.getProfessional2().getId() == recent_job_offers.get(i).getProfessional().getId()) {
                        user_is_contact[i] = 1;
                        break;
                    }
                }
            }
            else {
                break;
            }
        }
        for (int i = 0; i < recent_job_offers.size(); i++) {
            if (current_user.getRelations1() != null) {
                for (Relation relation : current_user.getRelations1()) {
                    for (Relation professional_relation : relation.getProfessional2().getRelations1()) {
                        if (professional_relation.getProfessional2().getId() == recent_job_offers.get(i).getProfessional().getId() ||
                            professional_relation.getProfessional1().getId() == recent_job_offers.get(i).getProfessional().getId()) {
                            user_has_common_contacts[i] += 1;
                        }
                    }
                }
            }
            else {
                break;
            }
        }
        for (int i = 0; i < recent_job_offers.size(); i++) {
            HashSet<String> job_description_tokens = new HashSet<String>(Arrays.asList(recent_job_offers.get(i).getText().toLowerCase().split(" "))),
                            job_title_tokens = new  HashSet<String>(Arrays.asList(recent_job_offers.get(i).getJobTitle().toLowerCase().split(" ")));
            for (Skill skill : current_user.getSkills()) {
                if (job_description_tokens.contains(skill.getId().getDescription().toLowerCase())) {
                    user_has_skills[i] += 1;
                }
                if (job_title_tokens.contains(skill.getId().getDescription().toLowerCase())) {
                    user_has_skills[i] += 1;
                }
            }
        }

        ArrayList<Double> distance_list = new ArrayList<Double>();
        Integer[] user_vector = new Integer[]{1, current_user.getRelations1().size(), current_user.getSkills().size()};

        for (int i = 0; i < recent_job_offers.size(); i++) {
            Integer[] professional_vector = new Integer[]{user_is_contact[i], user_has_common_contacts[i], user_has_skills[i]};
            distance_list.add(eucleidian_distance(user_vector, professional_vector));
        }


        TreeMap<Double, List<JobOffer>> map = new TreeMap<Double, List<JobOffer>>();
        for (int i = 0; i < recent_job_offers.size(); i++) {
            if (map.containsKey(distance_list.get(i))) {
                map.get(distance_list.get(i)).add(recent_job_offers.get(i));
            }
            else {
                ArrayList<JobOffer> job_offers_list = new ArrayList<JobOffer>();
                job_offers_list.add(recent_job_offers.get(i));
                map.put(distance_list.get(i), job_offers_list);
            }
        }

        ArrayList<JobOffer> job_offers_to_display = new ArrayList<JobOffer>();

        for (Map.Entry<Double, List<JobOffer>> entry : map.entrySet()) {
            for (JobOffer job_offer : entry.getValue()) {
                job_offers_to_display.add(job_offer);
            }
        }

        return job_offers_to_display;
    }

    private Double eucleidian_distance(Integer[] x, Integer[] y) {
        Double dist = 0.0;
        for (int i = 0; i < x.length; i++) {
            dist += Math.pow(x[i] - y[i], 2);
        }
        return Math.sqrt(dist);
    }
}
