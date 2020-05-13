package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserServiceImp;

@Controller
@RequestMapping("/")
public class NewUserController {

    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newUserCreate(Model model) {
        model.addAttribute("userForm", new User());
        return "new_user";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("userForm") User user) {
        userServiceImp.save(user);
        return "redirect:/list";
    }
}
