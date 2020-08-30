package com.example.chatapp_main.controller;

import com.example.chatapp_main.bean.Status;
import com.example.chatapp_main.bean.Response;
import com.example.chatapp_main.service.UserService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Response register(@RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");

        Response response = new Response();
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            boolean nameIsRegister = userService.userNameIsRegister(username);
            if(nameIsRegister){
                response.setStatus(Status.USERISREGISTER);
            }else{
                userService.register(username,password);
                response.setStatus(Status.OK);
            }
        }
        return response;
    }

    @PostMapping("/login")
    public Response login(@RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        Response response = new Response();
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            boolean login = userService.login(username,password);
            if(login){
                response.setStatus(Status.OK);
            }else{
                response.setStatus(Status.USERNAMEORPADERROR);
            }
        }
        return response;
    }

}
