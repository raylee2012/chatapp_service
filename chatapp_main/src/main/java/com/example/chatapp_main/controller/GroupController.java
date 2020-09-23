package com.example.chatapp_main.controller;

import com.example.chatapp_main.core.Response;
import com.example.chatapp_main.core.Status;
import com.example.chatapp_main.service.GroupService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping("/cteateGroup")
    public Response createGroup(@RequestBody Map map){
        Response response=new Response();
        String create_user_id = (String) map.get("create_user_id");
        String member_user_ids = (String) map.get("member_user_ids");
        if(TextUtils.isEmpty(create_user_id)||TextUtils.isEmpty(member_user_ids)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            String[] ids = member_user_ids.split(",");
            List<String> idList=new ArrayList<>();
            for(String id:ids){
                idList.add(id);
                if(create_user_id.equals(id)){
                    response.setStatus(Status.UMCHATWITHMYSELF);
                    return response;
                }
            }
            groupService.createGroup(create_user_id, idList);
            response.setStatus(Status.OK);
        }
        return response;
    }

    @PostMapping("/updateGroupInfo")
    public Response updateGroupInfo(@RequestBody Map map){
        Response response=new Response();
        String group_id = (String) map.get("group_id");
        String group_name = (String) map.get("group_name");
        String group_notice = (String) map.get("group_notice");
        if(TextUtils.isEmpty(group_id)||(TextUtils.isEmpty(group_name)&&TextUtils.isEmpty(group_notice))){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            groupService.updateGroupInfo(group_id,group_name, group_notice);
            response.setStatus(Status.OK);
        }
        return response;
    }

}
