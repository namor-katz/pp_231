package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import web.model.User;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class listAllUser {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String returnListUsers(ModelMap model) {
        List<User> list = new LinkedList<>();

        return "listAllUsers";
    }
}
