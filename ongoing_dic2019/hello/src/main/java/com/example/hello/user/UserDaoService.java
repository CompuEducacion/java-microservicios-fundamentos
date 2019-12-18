package com.example.hello.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;



    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null)
            user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findOne(int id){
        System.out.println("#@# findOne invoked!");
        for(User user :  users){
            Integer userId = user.getId();
            System.out.println("userId = " + userId);
            if(user.getId() == id){
                System.out.println("match!");
                return user;
            }
        }
        System.out.println("@#@# returning null!");
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }

        }
        return null;
    }

}
