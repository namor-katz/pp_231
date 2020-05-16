package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserServiceImp;

@Controller
@RequestMapping("/fuck34")
public class DeleteUserController {

    @Autowired
    UserServiceImp userServiceImp;

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam long id) {
        userServiceImp.deleteById(id);
        return "redirect:/list";
    }
}
