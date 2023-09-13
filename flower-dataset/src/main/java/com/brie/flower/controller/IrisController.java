package com.brie.flower.controller;


import com.brie.flower.model.Iris;
import com.brie.flower.service.IrisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/iris")
public class IrisController {

    @Autowired
    private IrisService service;

    //localhost:8080/iris/pring
    @GetMapping("/ping")
    public String homepage() {
        ///CODE
        return "RESPONSE IS GOOD";
    }

    //localhost:8080/iris/all
    @RequestMapping(value = "/all", produces = "application/json", method = RequestMethod.GET)
    public List<Iris> findAllIrises() {
        return service.findAll();
    }
@RequestMapping(value="/all/{id}",method=RequestMethod.GET)
    public Iris findBy(@PathVariable(value="id",required = true) Integer id){
        return service.findBy(id);
}
@RequestMapping(value = "/all",method = RequestMethod.POST)
public Iris addIris(@RequestBody Iris iris){
        return service.addIris(iris);
}
@RequestMapping(value="/all/{id}",method =RequestMethod.POST)
public Iris updateIris(@PathVariable(value="id",required = true)Integer id, @RequestBody Iris iris){
        return service.updateIris(iris,id);
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
