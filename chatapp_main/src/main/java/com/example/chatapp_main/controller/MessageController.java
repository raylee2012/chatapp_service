package com.example.chatapp_main.controller;

import com.example.chatapp_main.core.Response;
import com.example.chatapp_main.core.Status;
import com.example.chatapp_main.core.UploadFileResponse;
import com.example.chatapp_main.entity.User;
import org.apache.http.util.TextUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/message")
public class MessageController {

    @PostMapping("/sendMessage")
    public Response updateUserInfo(@RequestHeader("token") String token,
                                   @RequestParam(value = "user_id") String user_id, @RequestParam(value = "nick_name",  required=false) String nickname,
                                   @RequestParam(value = "password",required=false) String password, @RequestParam(value = "tel", required=false)String tel,
                                   @RequestParam(value ="address",  required=false)String address, @RequestParam(value = "file",  required=false) MultipartFile file){
        Response response = new Response();
        User user = new User(user_id, nickname, password, tel, address);
        if(TextUtils.isEmpty(user_id)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{

        }
        return response;
    }

}
