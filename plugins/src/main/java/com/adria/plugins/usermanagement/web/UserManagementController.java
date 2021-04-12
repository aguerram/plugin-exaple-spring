package com.adria.plugins.usermanagement.web;

import com.adria.plugins.PluginEntry;
import com.adria.plugins.annotations.RegisterPlugin;
import com.adria.plugins.usermanagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@Component
@RegisterPlugin(id = "users", version = "1.0", name = "Users Management", entryName = "com.adria.plugins.usermanagement.web.UserManagementController", enabled = true)
public class UserManagementController implements PluginEntry {
    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping(path = {"/", "/users"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> getUsers() {
        return userManagementService.getUsers();
    }

    @RequestMapping(
            path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST
    )
    @ResponseBody
    public ResponseEntity<?> getUserFromList(@PathVariable int id, @RequestParam("suffix") String suffix) {
        String user = this.userManagementService.getUserById(id);
        if (user == null)
            ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .build();
        return ResponseEntity.ok(user + suffix);
    }

}

