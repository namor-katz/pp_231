package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import web.editors.RoleEditors;
import web.model.Role;
import web.model.User;
import web.service.UserServiceImp;

@Controller
@RequestMapping("/fuck")
public class NewUserController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping(value = "new")
    public String newUserPage(Model model) {
        model.addAttribute("userForm", new User());
        return "new_user";
    }

    @PostMapping(value = "new")
    public String saveNewUser(@ModelAttribute("userForm") User user) {
        userServiceImp.save(user);
        return "redirect:/admin/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Role.class, new RoleEditors());
    }
}
