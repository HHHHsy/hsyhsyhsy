package com.example.student.controller;

import com.example.student.entity.User;
import com.example.student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    //添加一个用户
    @PostMapping("/register")
    public Object AddUser(Long sid,String sname,String sremakers,String ssex,String sage){
        User user = new User();

        user.setSid(sid);
        user.setSname(sname);
        user.setSremakers(sremakers);
        user.setSsex(ssex);
        user.setSage(sage);
        if (sid==null) {
            return ResponseEntity.badRequest().body("请输入学号！！");
        }
        User user1 = userRepository.save(user);
        return user1;
    }


    //修改指定用户
    @PutMapping("/study/{id}")
    public Object putUser(@RequestParam("sid") Long sid,String sname,
                          String sremakers, String ssex, String sage){

        User user = new User();
        user.setSid(sid);
        user.setSname(sname);
        user.setSremakers(sremakers);
        user.setSsex(ssex);
        user.setSage(sage);
        User user1 = userRepository.save(user);
        return user1;
    }


    //删除指定用户
    @DeleteMapping("/study/{sid}")
    public void delSid(Long sid){
        if (sid==null) {
           System.out.printf("输入需要删除的学号");
        }
        userRepository.deleteBySid(sid);
    }

    //查找指定用户
    @GetMapping("/study/{sid}")
    public List<User> findSid(@RequestParam("sid")Long sid){
        if (sid==null) {
            System.out.println("nulllllllllllllllllllllllllllllllllllllll");
            return null;
        }
        return userRepository.findBysid(sid);
    }

    //显示所有用户
    @GetMapping("/study")
    public List<User> findAll(){

        return userRepository.findAll();
    }


}
