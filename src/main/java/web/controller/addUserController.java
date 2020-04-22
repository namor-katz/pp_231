package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;

@Controller
@RequestMapping("/")
public class addUserController  {

    @RequestMapping(value = "add")
    public String addUser(User user) {



        return "add";
    }
}
