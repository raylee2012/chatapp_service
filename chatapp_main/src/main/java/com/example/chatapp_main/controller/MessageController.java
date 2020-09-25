package com.example.chatapp_main.controller;

import com.example.chatapp_main.core.Response;
import com.example.chatapp_main.core.Status;
import com.example.chatapp_main.core.UploadFileResponse;
import com.example.chatapp_main.entity.Message;
import com.example.chatapp_main.service.MessageService;
import com.example.chatapp_main.util.StringUtil;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    FileController fileController;
    @Autowired
    MessageService messageService;

    @PostMapping("/sendMessage")
    public Response sendMessage(@RequestHeader("token") String token,
                                   @RequestParam(value = "message_create_user_id") String message_create_user_id, @RequestParam(value = "message_group_id") String message_group_id,
                                   @RequestParam(value ="message_type")String message_type, @RequestParam(value = "message_content",required=false) String message_content,
                                   @RequestParam(value = "file",  required=false) MultipartFile file){
        Response response = new Response();
        if(TextUtils.isEmpty(message_create_user_id)||TextUtils.isEmpty(message_group_id)
                ||TextUtils.isEmpty(message_type)
                ||(TextUtils.isEmpty(message_content)&&file==null)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            Message message=new Message();
            message.setMessage_id(StringUtil.newGUID());
            message.setMessage_create_user_id(message_create_user_id);
            message.setMessage_group_id(message_group_id);
            if(file!=null){
                UploadFileResponse uploadFile = fileController.uploadFile(file);
                message.setMessage_attach_url(uploadFile.getFileDownloadUri());
                message.setMessage_attach_name(uploadFile.getFileName());
                message.setMessage_attach_size(uploadFile.getSize()+"");
            }else{
                message.setMessage_content(message_content);
            }
            messageService.sendMessage(message);
            response.setStatus(Status.OK);
            response.setData(messageService.selectUserByPrimaryKey(message.getMessage_id()));
        }
        return response;
    }

    @PostMapping("/revocationMessage")
    public Response revocationMessage(@RequestHeader("token") String token,
                                @RequestParam(value = "message_id") String message_id){
        Response response = new Response();
        if(TextUtils.isEmpty(message_id)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            messageService.revocationMessage(message_id);
            response.setStatus(Status.OK);
            response.setData(messageService.selectUserByPrimaryKey(message_id));
        }
        return response;
    }

}
