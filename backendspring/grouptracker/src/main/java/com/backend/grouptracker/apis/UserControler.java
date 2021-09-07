package com.backend.grouptracker.apis;


import com.backend.grouptracker.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserControler {

    private static final List<User> userlist = Arrays.asList(
            new User("test1","test2"),
            new User("test3","test3"),
            new User("test4","test4"),
            new User("test5","test5")
    );

    @GetMapping(path = "{userid}")
    public User getUser(@PathVariable  String userid){
        return userlist.stream().filter(user -> userid.equals(user.getId())).findFirst().orElseThrow(()-> new IllegalStateException("User "+userid+" does not exites"));
    }

    @GetMapping(path = "/all")
    public List<User> getallUser(){
        return  userlist;
    }
}
