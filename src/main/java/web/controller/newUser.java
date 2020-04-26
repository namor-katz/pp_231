package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;

import java.util.Map;

@Controller
@RequestMapping("/")
public class newUser {

    @Autowired
    UserService userService;

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newCustomerForm(ModelMap model) {
//        User user = new User();
//        model.put("user", user);
        return "new_user";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("user") User user) {
//        userService.save(user);
        System.out.println("ёба");
        System.out.println(user.getEmail());    //black magick, блядь! О_О
        userService.save(user);
        return "redirect:/list";
    }
}
