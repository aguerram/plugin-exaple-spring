package com.adria.plugins.usermanagement.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserManagementService {
    List<String> users;

    @PostConstruct
    private void init() {
        users = new ArrayList<>();
        users.addAll(Arrays.asList("User 1", "User 2", "User 22"));
    }

    public List<String> getUsers() {
        return this.users;
    }
}
