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
@RequestMapping
public class EditUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam long id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editResult(@RequestParam long id, @RequestParam String name,
                             @RequestParam String email, @RequestParam int maxWeight) {

        userService.editById(id, name, email, maxWeight);

        return "redirect:/list";
    }

}
