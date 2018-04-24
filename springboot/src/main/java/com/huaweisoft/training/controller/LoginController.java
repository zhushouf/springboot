package com.huaweisoft.training.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String toLogin(){
        return "index";  
    }
     
    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greeting(@RequestParam(value="id", required=false, defaultValue="World") String id, Model model) {
        model.addAttribute("name", getNameById(id));
        return "greeting";
    }
   
    private String getNameById(String id){
        Map<String, String> users = new HashMap<String,String>();
        users.put("1","zhang san");
        users.put("2","li si");
        users.put("3","wang wu");
        
        return users.get(id);
    }
    
}
