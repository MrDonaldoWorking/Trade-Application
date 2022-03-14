package com.example.user.controller;

import com.example.user.dao.UserDao;
import com.example.user.dao.UserInMemoryDao;
import com.example.user.service.StockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final StockService service = new StockService("http://localhost", 11451);
    private final UserDao dao = new UserInMemoryDao();

    @PostMapping("/new")
    public int newUser() {
        return dao.addUser();
    }
}
