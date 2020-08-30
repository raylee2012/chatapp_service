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

    @PostMapping("/updateUserInfo")
    public Response updateUserInfo(@RequestParam(value = "id",required=true,  defaultValue = "0") int id, @RequestParam(value = "nickname",  required=false) String nickname,
                                   @RequestParam(value = "password",required=false) String password, @RequestParam(value = "tel", required=false)String tel,
                                   @RequestParam(value ="tel",  required=false)String address, @RequestParam(value = "file",  required=false) MultipartFile file){
        Response response = new Response();
        User user = new User(id, nickname, password, tel, address);
        if(id<=0){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            User userByPrimaryKey = userService.selectUserByPrimaryKey(id);
            if(userByPrimaryKey==null){
                response.setStatus(Status.NOTFOUNTUSER);
            }else {
                UploadFileResponse uploadFile=null;
                if(file!=null){
                    uploadFile = fileController.uploadFile(file);
                    user.setImgurl(uploadFile.getFileDownloadUri());
                }
                userService.updateUserInfo(user);
                response.setStatus(Status.OK);
                response.setData(userService.selectUserByPrimaryKey(user.getId()));
            }
        }
        return response;
    }

}
