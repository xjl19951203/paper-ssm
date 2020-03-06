package com.paper.ssm.controller;


import com.paper.ssm.model.structure.Scene;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/model")
public class ModelController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Scene get() {
        return new Scene();
    }

}
