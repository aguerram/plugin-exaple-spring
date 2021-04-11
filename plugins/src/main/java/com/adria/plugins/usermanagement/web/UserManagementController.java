package com.adria.plugins.usermanagement.web;

import com.adria.plugins.PluginEntry;
import com.adria.plugins.usermanagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
public class UserManagementController implements PluginEntry {
    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping(path = {"/", "/users"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getUsers() {
        return userManagementService.getUsers();
    }
}
