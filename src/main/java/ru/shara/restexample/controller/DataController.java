package ru.shara.restexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.shara.restexample.model.Data;
import ru.shara.restexample.service.DataService;

import java.awt.*;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {

    private DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }
    @GetMapping("/greeting")
    public String greeting() {
        return "Greeting";
    }

    @GetMapping("/{analysisString}")
    public Data[] getDataArr(@PathVariable String analysisString) {
        return dataService.getDataArray(analysisString);
    }


}
