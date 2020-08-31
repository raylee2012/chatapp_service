package com.example.chatapp_main.controller;

import com.example.chatapp_main.bean.Response;
import com.example.chatapp_main.bean.Status;
import com.example.chatapp_main.service.ContactService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactService contactService;

    @PostMapping("/addContact")
    public Response addContact(@RequestBody Map map){
        Response response = new Response();
        String applicant_id = (String) map.get("applicant_id");
        String receiver_id = (String) map.get("receiver_id");
        String application_content = (String) map.get("application_content");
        if(TextUtils.isEmpty(receiver_id)||TextUtils.isEmpty(applicant_id)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            contactService.addOrUpdateContact(applicant_id,receiver_id,application_content);
            response.setStatus(Status.OK);
            response.setData(contactService.selectContactByContactores(applicant_id,receiver_id));
        }

        return response;
    }

    @PostMapping("/accessContactApply")
    public Response accessContactApply(@RequestBody Map map){
        Response response = new Response();
        String contact_id = (String) map.get("contact_id");
        String status = (String) map.get("status");
        if(TextUtils.isEmpty(contact_id)||TextUtils.isEmpty(status)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            contactService.updateContactStatus(contact_id,status);
            response.setStatus(Status.OK);
            response.setData(contactService.selectContactByPrimaryKey(contact_id));
        }
        return response;
    }

    @PostMapping("/getApplicantList")
    public Response getApplicantList(@RequestBody Map map){
        Response response = new Response();
        String receiver_id = (String) map.get("receiver_id");
        if(TextUtils.isEmpty(receiver_id)){
            response.setStatus(Status.PARAMILLEGAL);
        }else{
            //contactService.updateContactStatus(contact_id,status);
            response.setStatus(Status.OK);
           // response.setData(contactService.selectContactByPrimaryKey(contact_id));
        }
        return response;
    }

}
