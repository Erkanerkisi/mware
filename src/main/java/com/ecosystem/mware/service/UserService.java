package com.ecosystem.mware.service;

import com.ecosystem.mware.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {


       public static final List<User> userList =  new ArrayList<User>() {
            {
                add(new User(Long.valueOf(1),"erkanerkisi","12345","Erkan","Erkişi"));
                add(new User(Long.valueOf(2),"erkanerkisi1","123456","Erkan1","Erkişi"));
                add(new User(Long.valueOf(3),"erkanerkisi2","123457","Erkan2","Erkişi"));
            }
        };

    public User getUserByUsername(String userName){
        Optional<User> user= userList.stream().filter(e -> e.getUserName().equals(userName))
                .findAny();
        if (user.get() == null ){
            throw new UsernameNotFoundException("user not found");
        }
        return user.get();
    }

    public User loadUserById(Long id) {

        Optional<User> user= userList.stream().filter(e -> e.getUserId() == id )
                .findAny();
        if (user.get() == null ){
            throw new UsernameNotFoundException("User not found with id" + id);
        }

        return user.get();
    }

    public boolean existsByUsername(String userName){
        Optional<User> user= userList.stream().filter(e -> e.getUserName().equals(userName))
                .findAny();
        if (user.isPresent()){
            return true;
        }
        return false;
    }
    public User addUser(User user){
        userList.add(user);
        return user;
    }

}
