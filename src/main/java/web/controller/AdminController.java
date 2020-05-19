package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import web.editors.RoleEditors;
import web.model.Role;
import web.model.User;
import web.service.UserServiceImp;

import java.util.List;

// this controller target: add, delete and edit any user, viewe list all users.
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserServiceImp userServiceImp;

    @Autowired
    public AdminController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    //======== do create new user ==========
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
//========== begin create new user ===========

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Role.class, new RoleEditors());
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String returnListUsers(ModelMap model) {
        List<User> list = userServiceImp.getUserList();
        model.addAttribute("list", list);
        return "listAllUsers";
    }

    @GetMapping(value = "delete")
    public String deleteUser(@RequestParam long id) {
        userServiceImp.deleteById(id);
        return "redirect:/admin/list";
    }

    //======== edit user block do ==========
    @GetMapping(value = "edit")
    public String editUser(@RequestParam long id, ModelMap model) {
        User user = userServiceImp.getUserById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping(value = "edit")
    public String editUser(@RequestParam long id, @RequestParam String name,
                           @RequestParam String email, @RequestParam int maxweight) {
        userServiceImp.editById(id, name, email, maxweight);
        return "redirect:/admin/list";
    }
    //============== eidt user block end ==============
}
