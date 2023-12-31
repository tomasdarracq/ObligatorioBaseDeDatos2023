package com.ucu.obligatoriobasededatos2023.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/login")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public List<Login> getLogins() {
        return loginService.getLogins();

    }

    @PostMapping
    public Login addLogin(@RequestBody Login login) {
    return loginService.addLogin(login);
    }
    @PostMapping(path = "/add")
    public void addNewLogin(@RequestBody Login login) {
         loginService.addNewLogin(login);
    }

    @PostMapping(path = "/admin")
    public boolean validateAdmin(@RequestBody Login login) {
        return loginService.validateAdmin(login);
    }
    @DeleteMapping(path = "{logId}")
    public void deleteLogin(@PathVariable("logId") long logId) {
        loginService.deleteLogin(logId);
    }

}