package com.aninfo.backend.proyectos.controllers;

import com.aninfo.backend.proyectos.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MyController {
    @Autowired
    MyService service;

    @GetMapping("")
    public String MyEndpoint() {
        return "MyData";
    }
}