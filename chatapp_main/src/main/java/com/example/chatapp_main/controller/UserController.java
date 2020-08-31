package com.example.chatapp_main.controller;

import com.example.chatapp_main.bean.Status;
import com.example.chatapp_main.bean.Response;
import com.example.chatapp_main.bean.UploadFileResponse;
import com.example.chatapp_main.pojo.User;
import com.example.chatapp_main.service.UserService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    FileController fileController;

    @PostMapping("/register")
    public Response register(@RequestBody Map map){
        String user_name = (String) map.get("user_name");
        String password = (String) map.get("password");

        Response response = new Response();
        if(TextUtils.isEmpty(user_name)||TextUtils.isEmpty(password)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            boolean nameIsRegister = userService.userNameIsRegister(user_name);
            if(nameIsRegister){
                response.setStatus(Status.USERISREGISTER);
            }else{
                userService.register(user_name,password);
                response.setStatus(Status.OK);
            }
        }
        return response;
    }

    @PostMapping("/login")
    public Response login(@RequestBody Map map){
        String username = (String) map.get("user_name");
        String password = (String) map.get("password");
        Response response = new Response();
        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            boolean login = userService.login(username,password);
            if(login){
                response.setStatus(Status.OK);
                response.setData(userService.findUserByUsername(username));
            }else{
                response.setStatus(Status.USERNAMEORPADERROR);
            }
        }
        return response;
    }

    @PostMapping("/updateUserInfo")
    public Response updateUserInfo(@RequestHeader("token") String token,
                                    @RequestParam(value = "user_id") String user_id, @RequestParam(value = "nick_name",  required=false) String nickname,
                                   @RequestParam(value = "password",required=false) String password, @RequestParam(value = "tel", required=false)String tel,
                                   @RequestParam(value ="address",  required=false)String address, @RequestParam(value = "file",  required=false) MultipartFile file){
        Response response = new Response();
        User user = new User(user_id, nickname, password, tel, address);
        if(TextUtils.isEmpty(user_id)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            User userByPrimaryKey = userService.selectUserByPrimaryKey(user_id);
            if(userByPrimaryKey==null){
                response.setStatus(Status.NOTFOUNTUSER);
            }else {
                if(file!=null){
                    UploadFileResponse uploadFile = fileController.uploadFile(file);
                    user.setImgurl(uploadFile.getFileDownloadUri());
                }
                userService.updateUserInfo(user);
                response.setStatus(Status.OK);
                response.setData(userService.selectUserByPrimaryKey(user.getUser_id()));
            }
        }
        return response;
    }

    @PostMapping("/findUser")
    public Response addContact(@RequestBody Map map){
        Response response = new Response();
        String user_name = (String) map.get("user_name");
        if(TextUtils.isEmpty(user_name)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            User user = userService.findUserByUsername(user_name);
            response.setStatus(Status.OK);
            response.setData(user);
        }

        return response;
    }

}
