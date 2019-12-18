package com.example.hello.post;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class PostDaoService {
    private static List<Post> posts = new ArrayList<>();

    private static int postCount = 0;

    public List<Post> findAll(){
        return posts;
    }

    public List<Post> findAllByUserId(int userId){
        System.out.println("@#@# findAllByUserId invoked!");
        List<Post> resultList = new ArrayList<>();
        for(Post post : posts){
            if (post.getUser().getId() == userId){
                resultList.add(post);
            }
        }
        System.out.println("@#@# Lista de posts: " + resultList);
        return resultList;
    }

    public Post findPostByUserIdAndPostId(int userId, int postId){
        System.out.println("@#@# Executing: findPostByUserIdAndPostId");
        List<Post> allPostsForUser = findAllByUserId(userId);
        for(Post post : allPostsForUser){
            if (post.getId() == postId){
                return post;
            }
        }
        return null;
    }


    public Post save(Post post){
        if(post.getId() == null)
            post.setId(++postCount);
        posts.add(post);
        return post;
    }

    public Post findOne(int id){
        for(Post post :  posts){
            if(post.getId() == id){
                return post;
            }
        }
        return null;
    }

    public Post deleteById(int id){
        Iterator<Post> iterator = posts.iterator();
        while(iterator.hasNext()){
            Post post = iterator.next();
            if(post.getId() == id){
                iterator.remove();
                return post;
            }
        }
        return null;
    }

}
