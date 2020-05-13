package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import web.model.User;
import web.service.UserServiceImp;
import java.util.List;

@Controller
@RequestMapping("/")
public class ListAllUserController {

    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String returnListUsers(ModelMap model) {
        List<User> list = userServiceImp.getUserList();
        model.addAttribute("list", list);
        return "listAllUsers";
    }
}
