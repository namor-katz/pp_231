package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class NewUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newUserCreate() {
        return "new_user";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("user") User user) {
//        System.out.println("ща создам юзера!");
        userService.save(user);
        return "redirect:/list";
    }
}
