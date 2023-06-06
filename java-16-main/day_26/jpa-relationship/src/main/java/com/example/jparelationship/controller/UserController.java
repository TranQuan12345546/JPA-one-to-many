package com.example.jparelationship.controller;

import com.example.jparelationship.entity.FileServer;
import com.example.jparelationship.service.FileServerService;
import com.example.jparelationship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileServerService fileServerService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @GetMapping("/users/{id}/files")
    public String getFiles(@PathVariable Integer id, Model model) {
        model.addAttribute("files", fileServerService.getFilesOfUser(id));
        model.addAttribute("userId", id);
        return "file";
    }

    // 1. Upload file
    @PostMapping("/users/{id}/files")
    public ResponseEntity<?> uploadFile(@ModelAttribute("file") MultipartFile file, @PathVariable Integer id) {
        return ResponseEntity.ok(fileServerService.uploadFile(id, file));
    }
}
