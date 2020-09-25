package com.example.chatapp_main.controller;

import com.example.chatapp_main.core.Status;
import com.example.chatapp_main.core.Response;
import com.example.chatapp_main.core.UploadFileResponse;
import com.example.chatapp_main.entity.User;
import com.example.chatapp_main.entity.vo.FindUser;
import com.example.chatapp_main.service.UserService;
import io.swagger.annotations.*;
import org.apache.http.util.TextUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "用户管理类")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);


    @Autowired
    UserService userService;
    @Autowired
    FileController fileController;

    @PostMapping("/register")
    @ApiOperation(value = "注册")
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
        log.warn("url:"+"/register;"+"param:"+map+";response:"+response);
        return response;
    }

    @PostMapping("/login")
    @ApiOperation(value = "登陆")
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
    @ApiOperation(value = "更新用户信息")
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
    @ApiOperation(value = "查询用户信息")
    public Response addContact(@RequestBody Map map){
        Response response = new Response();
        String user_name = (String) map.get("user_name");
        if(TextUtils.isEmpty(user_name)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            FindUser user = userService.findUserByUsername(user_name);
            response.setStatus(Status.OK);
            response.setData(user);
        }

        return response;
    }

}
