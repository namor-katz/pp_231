package web.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;
import web.model.Role;

public class RoleEditors extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text.equals("admin")) {
            setValue(new Role(2L, text));   //this admin
        }
        else {
            setValue(new Role(1L, text));   //this user.
        }
    }

    @Override
    public String getAsText() {
        Role role = (Role) getValue();
        if(role != null) {
            return role.getRole();
        } else {
            return "";
        }
    }
}
