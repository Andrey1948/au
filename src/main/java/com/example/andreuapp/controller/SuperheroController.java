package com.example.andreuapp.controller;

import com.example.andreuapp.dto.SuperheroCreateDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/test")
public class SuperheroController {

    @PostMapping()
    public SuperheroCreateDto test(@RequestBody SuperheroCreateDto dto) {
        System.out.println("---");
        return dto;
    }
}