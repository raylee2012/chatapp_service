package com.example.chatapp_main.controller;

import com.example.chatapp_main.core.Response;
import com.example.chatapp_main.core.Status;
import com.example.chatapp_main.entity.Group;
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
            response.setData(groupService.selectByGroupId(group_id));
            response.setStatus(Status.OK);
        }
        return response;
    }

    @PostMapping("/exitGroup")
    public Response exitGroup(@RequestBody Map map){
        Response response=new Response();
        String group_id = (String) map.get("group_id");
        String group_member_user_id = (String) map.get("group_member_user_id");
        if(TextUtils.isEmpty(group_id)||TextUtils.isEmpty(group_member_user_id)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            Group group = groupService.selectByGroupId(group_id);
            if(group_member_user_id.equals(group.getCreate_user_id())){
                response.setStatus(Status.PARAMILLEGAL);
            }else{
                groupService.exitGroup(group_id,group_member_user_id);
                response.setStatus(Status.OK);
            }
        }
        return response;
    }

    @PostMapping("/deleteGroup")
    public Response deleteGroup(@RequestBody Map map){
        Response response=new Response();
        String group_id = (String) map.get("group_id");
        String create_user_id = (String) map.get("create_user_id");
        if(TextUtils.isEmpty(group_id)||TextUtils.isEmpty(create_user_id)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            Group group = groupService.selectByGroupId(group_id);
            if(create_user_id.equals(group.getCreate_user_id())){
                groupService.deleteGroup(group_id);
                response.setStatus(Status.OK);
            }else{
                response.setStatus(Status.PARAMILLEGAL);
            }
        }
        return response;
    }

    @PostMapping("/addMembers")
    public Response addMembers(@RequestBody Map map){
        Response response=new Response();
        String group_id = (String) map.get("group_id");
        String member_user_ids = (String) map.get("member_user_ids");
        if(TextUtils.isEmpty(group_id)||TextUtils.isEmpty(member_user_ids)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            Group group = groupService.selectByGroupId(group_id);
            if(group==null){
                response.setStatus(Status.PARAMILLEGAL);
            }else{
                String[] split = member_user_ids.split(",");
                List<String> ids=new ArrayList<>();
                for(String member_user_id:split){
                    ids.add(member_user_id);
                }
                groupService.addMembers(group_id,ids);
                response.setStatus(Status.OK);
            }
        }
        return response;
    }

    @PostMapping("/changDisturb")
    public Response changDisturb(@RequestBody Map map){
        Response response=new Response();
        String group_id = (String) map.get("group_id");
        String member_user_id = (String) map.get("member_user_id");
        String group_disturb = (String) map.get("group_disturb");
        if(TextUtils.isEmpty(group_id)||TextUtils.isEmpty(member_user_id)||
                TextUtils.isEmpty(group_disturb)||(!"0".equals(group_disturb)&&!"1".equals(group_disturb))){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            groupService.changDisturb(group_id,member_user_id,group_disturb);
            response.setStatus(Status.OK);
        }
        return response;
    }

    @PostMapping("/saveToContact")
    public Response saveToContact(@RequestBody Map map){
        Response response=new Response();
        String group_id = (String) map.get("group_id");
        String member_user_id = (String) map.get("member_user_id");
        String group_to_contact = (String) map.get("group_to_contact");
        if(TextUtils.isEmpty(group_id)||TextUtils.isEmpty(member_user_id)||
                TextUtils.isEmpty(group_to_contact)||(!"0".equals(group_to_contact)&&!"1".equals(group_to_contact))){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            groupService.saveToContact(group_id,member_user_id,group_to_contact);
            response.setStatus(Status.OK);
        }
        return response;
    }

    @PostMapping("/setGroupTop")
    public Response setGroupTop(@RequestBody Map map){
        Response response=new Response();
        String group_id = (String) map.get("group_id");
        String member_user_id = (String) map.get("member_user_id");
        String group_top = (String) map.get("group_top");
        if(TextUtils.isEmpty(group_id)||TextUtils.isEmpty(member_user_id)||
                TextUtils.isEmpty(group_top)||(!"0".equals(group_top)&&!"1".equals(group_top))){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            groupService.setGroupTop(group_id,member_user_id,group_top);
            response.setStatus(Status.OK);
        }
        return response;
    }

    @PostMapping("/setGroupNickName")
    public Response setGroupNickName(@RequestBody Map map){
        Response response=new Response();
        String group_id = (String) map.get("group_id");
        String member_user_id = (String) map.get("member_user_id");
        String group_nick_name = (String) map.get("group_nick_name");
        if(TextUtils.isEmpty(group_id)||TextUtils.isEmpty(member_user_id)||
                TextUtils.isEmpty(group_nick_name)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            groupService.setGroupNickName(group_id,member_user_id,group_nick_name);
            response.setStatus(Status.OK);
        }
        return response;
    }


}
