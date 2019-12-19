package com.example.hello.resource;

import com.example.hello.exceptions.UserNotFoundException;
import com.example.hello.post.Post;
import com.example.hello.post.PostDaoService;
import com.example.hello.repository.PostRepository;
import com.example.hello.repository.UserRepository;
import com.example.hello.user.User;
import com.example.hello.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PostJPAResource {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jpa/posts")
    public List<Post> retrieveAllPosts(){
        return postRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllPostByUserId(@PathVariable int id){
        System.out.println("@#@# retrieveAllPostByUserId invoked!");
        return postRepository.findAllByUserId(id);
    }

    @GetMapping("/jpa/users/{id}/posts/{postId}")
    public Post retrievePostByUserIdAndPostId(
              @PathVariable(name="id") int userId,
              @PathVariable int postId ){
        System.out.println("@#@# retrievePostByUserIdAndPostId invoked!");
        //Post post = postRepository.findPostByUserIdAndPostId(userId, postId);
        Optional<Post> opPost = postRepository.findById(postId);
        if(!opPost.isPresent()){
            throw new UserNotFoundException("userid-" + userId + " , postId-"+postId);
        }
        return opPost.get();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> create(@PathVariable int id,
                                         @RequestBody Post post){


        Optional<User> opUser = userRepository.findById(id);
        User user = null;
        Post savedPost = null;
        if(opUser.isPresent()){
            user = opUser.get();
            post.setUser(user);
            savedPost = postRepository.save(post);
        }else{
            throw new UserNotFoundException("userid-" + id);
        }

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{postId}")
                        .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
