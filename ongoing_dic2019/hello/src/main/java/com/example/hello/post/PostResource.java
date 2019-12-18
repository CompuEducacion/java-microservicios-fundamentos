package com.example.hello.post;

import com.example.hello.exceptions.UserNotFoundException;
import com.example.hello.user.User;
import com.example.hello.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {
    @Autowired
    private PostDaoService service;

    @Autowired
    private UserDaoService userService;

    @GetMapping("/posts")
    public List<Post> retrieveAllPosts(){
        return service.findAll();
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPostByUserId(@PathVariable int id){
        System.out.println("@#@# retrieveAllPostByUserId invoked!");
        return service.findAllByUserId(id);
    }

    @GetMapping("/users/{id}/posts/{postId}")
    public Post retrievePostByUserIdAndPostId(
              @PathVariable(name="id") int userId,
              @PathVariable int postId ){
        System.out.println("@#@# retrievePostByUserIdAndPostId invoked!");
        Post post = service.findPostByUserIdAndPostId(userId, postId);
        if(post == null){
            throw new UserNotFoundException("userid-" + userId +
                                            ", postId-"+postId);
        }
        return post;
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> create(@PathVariable int id,
                                         @RequestBody Post post){

        Post savedPost = service.save(post);
        User user = userService.findOne(id);
        user.addPost(savedPost);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{postId}")
                        .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
