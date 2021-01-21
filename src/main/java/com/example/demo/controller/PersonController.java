package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/person/")
public class PersonController {

    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping
    public String getAllPersons(Model model){
        model.addAttribute("persons",personService.getPersons());
        model.addAttribute("person",new Person());
        return "Persons";
    }
    @PostMapping("add")
    public String createPerson(@ModelAttribute(value = "person") Person person){
        personService.savePerson(person);
        return "redirect:/api/person/";
    }
    @GetMapping("/helloWorld")
    public String getAllPersons(){
        return "HelloWorld";
    }
}
