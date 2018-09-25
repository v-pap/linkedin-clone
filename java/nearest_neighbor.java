import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
//import model.Comment;
//import model.Like;
//import model.Post;
//import model.Professional;
//import model.Relation;

public class nearest_neighbor {
    public List<Post> nearest_neighbor(Professional current_user, List<Professional> network_users, List<Post> recent_posts) {
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
            //System.out.println(user.getId());
        }
        for (Post post : recent_posts) {
            post_ids.add(post.getPostId());
            //System.out.println(post.getPostId());
        }

        Integer[] user_is_contact = new Integer[network_users.size()],
                  user_has_liked = new Integer[recent_posts.size()],
                  user_has_commented = new Integer[recent_posts.size()];

        Arrays.fill(user_is_contact, 0);
        Arrays.fill(user_has_liked, 0);
        Arrays.fill(user_has_commented, 0);

        // Calculate vectors for current user
        for (int i = 0; i < network_ids.size(); i++) {
            for (Relation relation : current_user.getRelations1()) {
                if (relation.getProfessional2().getId() == network_ids.get(i)) {
                    user_is_contact[i] = 1;
                }
            }
        }
        for (int i = 0; i < post_ids.size(); i++) {
            if (current_user.getLikes() != null) {
                for (Like like : current_user.getLikes()) {
                    if (like.getPost().getPostId() == post_ids.get(i)) {
                        user_has_liked[i] = 1;
                    }
                }
            }
            if (current_user.getComments() != null) {
                for (Comment comment : current_user.getComments()) {
                    if (comment.getPost().getPostId() == post_ids.get(i)) {
                        user_has_commented[i] = 1;
                    }
                }
            }
        }

        // System.out.println("User");
        // System.out.println(Arrays.toString(user_is_contact));
        // System.out.println(Arrays.toString(user_has_liked));
        // System.out.println(Arrays.toString(user_has_commented));

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
                for (Relation relation : network_users.get(i).getRelations1()) {
                    if (relation.getProfessional2().getId() == network_ids.get(j) || j == i) {
                        professional_is_contact[j] = 1;
                    }
                }
            }
            for (int j = 0; j < post_ids.size(); j++) {
                if (network_users.get(i).getLikes() != null) {
                    for (Like like : network_users.get(i).getLikes()) {
                        if (like.getPost().getPostId() == post_ids.get(j)) {
                            professional_has_liked[j] = 1;
                        }
                    }
                }
                if (network_users.get(i).getComments() != null) {
                    for (Comment comment : network_users.get(i).getComments()) {
                        if (comment.getPost().getPostId() == post_ids.get(j)) {
                            professional_has_commented[j] = 1;
                        }
                    }
                }
            }
            Double contact_distance = eucleidian_distance(user_is_contact, professional_is_contact),
                   likes_distance = eucleidian_distance(user_has_liked, professional_has_liked),
                   comment_distance = eucleidian_distance(user_has_commented, professional_has_commented);

            distance_list.add((contact_distance + likes_distance + comment_distance) / 3);

            // System.out.println(network_ids.get(i));
            // System.out.println(Arrays.toString(professional_is_contact));
            // System.out.println(Arrays.toString(professional_has_liked));
            // System.out.println(Arrays.toString(professional_has_commented));
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
                    System.out.println("Key: " + entry.getKey() + " Value: " + professional.getId());
                }
            }
        }

        return posts_to_display;
    }

    public List<JobOffer> nearest_neighbor_job_offers(Professional current_user, List<Professional> network_users, List<JobOffer> recent_job_offers) {
        ArrayList<Integer> network_ids = new ArrayList<Integer>();
        ArrayList<Integer> job_offer_ids = new ArrayList<Integer>();

        for (Professional user : network_users) {
            network_ids.add(user.getId());
            //System.out.println(user.getId());
        }
        for (JobOffer job_offer : recent_job_offers) {
            job_offer_ids.add(job_offer.getJobId());
            //System.out.println(job_offer.getJobId());
        }

        Integer[] user_is_contact = new Integer[network_users.size()],
                  user_has_liked = new Integer[recent_job_offers.size()],
                  user_has_commented = new Integer[recent_job_offers.size()];

        Arrays.fill(user_is_contact, 0);
        Arrays.fill(user_has_liked, 0);
        Arrays.fill(user_has_commented, 0);

        // Calculate vectors for current user
        for (int i = 0; i < network_ids.size(); i++) {
            for (Relation relation : current_user.getRelations1()) {
                if (relation.getProfessional2().getId() == network_ids.get(i)) {
                    user_is_contact[i] = 1;
                }
            }
        }
        for (int i = 0; i < job_offer_ids.size(); i++) {
            if (current_user.getLikes() != null) {
                for (Like like : current_user.getLikes()) {
                    if (like.getPost().getPostId() == job_offer_ids.get(i)) { //!!!
                        user_has_liked[i] = 1;
                    }
                }
            }
            if (current_user.getComments() != null) {
                for (Comment comment : current_user.getComments()) {
                    if (comment.getPost().getPostId() == job_offer_ids.get(i)) { //!!!
                        user_has_commented[i] = 1;
                    }
                }
            }
        }

        // System.out.println("User");
        // System.out.println(Arrays.toString(user_is_contact));
        // System.out.println(Arrays.toString(user_has_liked));
        // System.out.println(Arrays.toString(user_has_commented));

        List<Double> distance_list = new ArrayList<Double>();

        // Calculate vectors for network users
        for (int i = 0; i < network_ids.size(); i++) {
            Integer[] professional_is_contact = new Integer[network_users.size()],
                      professional_has_liked = new Integer[recent_job_offers.size()],
                      professional_has_commented = new Integer[recent_job_offers.size()];

            Arrays.fill(professional_is_contact, 0);
            Arrays.fill(professional_has_liked, 0);
            Arrays.fill(professional_has_commented, 0);

            for (int j = 0; j < network_ids.size(); j++) {
                for (Relation relation : network_users.get(i).getRelations1()) {
                    if (relation.getProfessional2().getId() == network_ids.get(j) || j == i) {
                        professional_is_contact[j] = 1;
                    }
                }
            }
            for (int j = 0; j < job_offer_ids.size(); j++) {
                if (network_users.get(i).getLikes() != null) {
                    for (Like like : network_users.get(i).getLikes()) {
                        if (like.getPost().getPostId() == job_offer_ids.get(j)) { //!!!
                            professional_has_liked[j] = 1;
                        }
                    }
                }
                if (network_users.get(i).getComments() != null) {
                    for (Comment comment : network_users.get(i).getComments()) {
                        if (comment.getPost().getPostId() == job_offer_ids.get(j)) { //!!!
                            professional_has_commented[j] = 1;
                        }
                    }
                }
            }
            Double contact_distance = eucleidian_distance(user_is_contact, professional_is_contact),
                   likes_distance = eucleidian_distance(user_has_liked, professional_has_liked),
                   comment_distance = eucleidian_distance(user_has_commented, professional_has_commented);

            distance_list.add((contact_distance + likes_distance + comment_distance) / 3);

            // System.out.println(network_ids.get(i));
            // System.out.println(Arrays.toString(professional_is_contact));
            // System.out.println(Arrays.toString(professional_has_liked));
            // System.out.println(Arrays.toString(professional_has_commented));
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
        ArrayList<JobOffer> job_offers_to_display = new ArrayList<JobOffer>();

        for (Map.Entry<Double, List<Professional>> entry : map.entrySet()) {
            for (JobOffer job_offer : recent_job_offers) {
                for (Professional professional : entry.getValue()) {
                    if (job_offer.getProfessional().getId() == professional.getId()) {
                        job_offers_to_display.add(job_offer);
                    }
                    System.out.println("Key: " + entry.getKey() + " Value: " + professional.getId());
                }
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
