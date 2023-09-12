package com.brie.flower.controller;


import com.brie.flower.model.Iris;
import com.brie.flower.service.IrisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/iris")
public class IrisController {

    @Autowired
    private IrisService service;


@GetMapping("/ping")
    public String homepage(){
    ///CODE
    return "RESPONSE IS GOOD";
}

    @RequestMapping(value = "/", produces ="application/json", method = RequestMethod.GET)
    public List<Iris> findAllIrises() {
        return service.findAll();
    }


/**
 * RoadMap:
 * Backend Services
 * 0. Create Iris Class, Parser and Service
 *  1. Finish Controller
 *  2. Finish Parsing CSV file
 *  3. Test the Controller such there's minimal mistakes (run program and use postman)
 * Frontend Actions
 *  1. Create a simple React/Angular Project.
 *  2. Create Model object that will be similar to the backend-model Iris object
 *  3. Learn how to use array objects in javascript, and parse JSON objects (for step 2 model objects)
 *  4. Learn how to setup front-end actions/events to point to each URL that you're trying to hit.
 *      a. Example: <b>Search All button, will point to localhost:8080/iris/</b>
 *  5. You will definitely run into CORS issue and need to setup a proxy.
 */


}
