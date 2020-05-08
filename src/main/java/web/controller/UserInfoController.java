package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImp;

@Controller
@RequestMapping("/")
public class UserInfoController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String userInfo(ModelMap model) {

        User principal  = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", principal);
        return "userInfo";
    }
}
