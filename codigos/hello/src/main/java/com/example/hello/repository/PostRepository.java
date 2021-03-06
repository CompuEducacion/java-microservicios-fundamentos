package com.example.hello.repository;

import com.example.hello.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository
        extends JpaRepository <Post, Integer>{
    public List<Post> findAllByUserId(Integer userId);

}
