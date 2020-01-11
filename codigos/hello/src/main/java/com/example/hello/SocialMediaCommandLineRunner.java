package com.example.hello;

import com.example.hello.post.Post;
import com.example.hello.post.PostDaoService;
import com.example.hello.user.User;
import com.example.hello.user.UserDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class SocialMediaCommandLineRunner implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(SocialMediaCommandLineRunner.class);


    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private PostDaoService postDaoService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Juan", new Date());
        User user2 = new User(null, "Pedro", new Date());
        User user3 = new User(null, "Andres", new Date());

        Post post1 = new Post(null, "Post 1 de Juan", user1);
        Post post2 = new Post(null, "Post 1 de Pedro", user2);
        Post post3 = new Post(null, "Post 1 de Andres", user3);
        Post post4 = new Post(null, "Post 2 de Pedro", user2);
        Post post5 = new Post(null, "Post 3 de Pedro", user2);

        user1.addPost(post1);
        user2.addPost(post2);
        user2.addPost(post4);
        user2.addPost(post5);
        user3.addPost(post3);

        userDaoService.save(user1);
        userDaoService.save(user2);
        userDaoService.save(user3);

        postDaoService.save(post1);
        postDaoService.save(post2);
        postDaoService.save(post3);
        postDaoService.save(post4);
        postDaoService.save(post5);
    }
}

