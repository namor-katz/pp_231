package web.editors;

import java.beans.PropertyEditorSupport;
import web.model.Role;

public class RoleEditors extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text.equals("admin")) {
            setValue(new Role(2L, "ROLE_ADMIN"));   //this admin
        }
        else if (text.equals("user")) {
            setValue(new Role(1L, "ROLE_USER"));   //this user.
        }
        else {
            setValue((new Role(1L, "ROLE_USER")));
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
