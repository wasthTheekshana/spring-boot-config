package com.wasathDev.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting: defualt value}") //deafult message if prop file down
    private String greetingMeesage;

    @Value("gfghjhjhv hjg jhg")
    private String staticMessage;

    @Value("${my.list.values}") //list example
    private List<String> listValue;

    @Value("#{${dbValues}}") //map
    private Map<String, String> dbVaules;

    @Autowired
    private DBSettings dbSettings;

    public GreetingController() {
    }

    @GetMapping("/greeting")
    public String greeting(){
        return dbSettings.getConnection() + dbSettings.getHost() + dbSettings.getPort();
    }
}
