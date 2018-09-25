import java.util.ArrayList;
import java.util.List;

public class NN
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

        List<Relation> l_r_1 = new ArrayList<Relation>();
        l_r_1.add(r_1_2);
        user1.setRelations1(l_r_1);

        Relation r_2_1 = new Relation();
        r_2_1.setProfessional1(user2);
        r_2_1.setProfessional2(user1);

        Relation r_2_3 = new Relation();
        r_2_3.setProfessional1(user2);
        r_2_3.setProfessional2(user3);

        Relation r_2_4 = new Relation();
        r_2_4.setProfessional1(user2);
        r_2_4.setProfessional2(user4);

        List<Relation> l_r_2 = new ArrayList<Relation>();
        l_r_2.add(r_2_1);
        l_r_2.add(r_2_3);
        l_r_2.add(r_2_4);
        user2.setRelations1(l_r_2);

        Relation r_3_2 = new Relation();
        r_3_2.setProfessional1(user3);
        r_3_2.setProfessional2(user2);

        List<Relation> l_r_3 = new ArrayList<Relation>();
        l_r_3.add(r_3_2);
        user3.setRelations1(l_r_3);

        Relation r_4_2 = new Relation();
        r_4_2.setProfessional1(user4);
        r_4_2.setProfessional2(user2);

        List<Relation> l_r_4 = new ArrayList<Relation>();
        l_r_4.add(r_4_2);
        user4.setRelations1(l_r_4);

        ///

        Like like_from_user1 = new Like(),
             like_from_user3 = new Like();
        like_from_user1.setProfessional(user1);
        like_from_user3.setProfessional(user3);

        ///

        Post post = new Post();
        post.setPostId(1);
        post.setProfessional(user2);

        List<Professional> users1_3 = new ArrayList<Professional>();
        users1_3.add(user1);
        users1_3.add(user3);
        post.setProfessional(user2);
        post.setProfessionals(users1_3);

        ///

        like_from_user1.setPost(post);
        like_from_user3.setPost(post);

        List<Post> l_post = new ArrayList<Post>();
        l_post.add(post);
        user2.setPosts1(l_post);

        ///

        List<Like> like_1 = new ArrayList<Like>();
        like_1.add(like_from_user1);
        user1.setLikes(like_1);

        List<Like> like_3 = new ArrayList<Like>();
        like_3.add(like_from_user3);
        user3.setLikes(like_3);


        List<Professional> users2_3 = new ArrayList<Professional>();
        users2_3.add(user2);
        users2_3.add(user3);

        List<Professional> users2_3_4 = new ArrayList<Professional>();
        users2_3_4.add(user2);
        users2_3_4.add(user3);
        users2_3_4.add(user4);

        nearest_neighbor nn = new nearest_neighbor();
        nn.nearest_neighbor(user1, users2_3_4, l_post);

        System.out.println("Done.");
    }
}