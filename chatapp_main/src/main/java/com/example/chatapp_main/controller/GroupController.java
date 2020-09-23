package com.example.chatapp_main.controller;

import com.example.chatapp_main.core.Response;
import com.example.chatapp_main.core.Status;
import com.example.chatapp_main.service.GroupService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @RequestMapping("/add")
    public Response addGroup(@RequestBody Map map){
        Response response=new Response();
        String create_user_id = (String) map.get("create_user_id");
        String member_user_ids = (String) map.get("member_user_ids");
        if(TextUtils.isEmpty(create_user_id)||TextUtils.isEmpty(member_user_ids)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            String[] ids = member_user_ids.split(",");
            for(String id:ids){
                if(create_user_id.equals(id)){
                    response.setStatus(Status.UMCHATWITHMYSELF);
                    return response;
                }
            }
            groupService.createGroup(create_user_id, Arrays.asList(ids));
            response.setStatus(Status.OK);
        }
        return response;
    }

}
