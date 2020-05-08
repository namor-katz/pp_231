package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserInfoController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String userInfo(ModelMap model, @RequestParam long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userInfo";
    }
}
