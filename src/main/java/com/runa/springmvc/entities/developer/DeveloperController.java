package com.runa.springmvc.entities.developer;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/developers/")
@RequiredArgsConstructor
public class DeveloperController {

    private final IDeveloperService developerService;

    @GetMapping
    public Page<DeveloperDto> getAllDevelopers(@PageableDefault(sort = {"lastName"}) Pageable pageable) {
        return developerService.getAllDevelopers(pageable);
        //TODO display
    }

    @GetMapping(value = "{id}")
    public String getDeveloperById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("message", "dev by id");
        model.addAttribute("dev", developerService.getDeveloperById(id));
        return "dev";
     }
    
    @GetMapping(value = "bylastName")
    public String getDeveloperByLastName(Model model, @RequestBody String lastName) {
        model.addAttribute("message", "dev by LastName");
        model.addAttribute("devs", developerService.getDeveloperByLastName(lastName));
      //TODO display
        return "fn";
     }
    
    @GetMapping(value = "bylet")
    public String getDeveloperByLet(Model model,  @RequestBody String let) {
        model.addAttribute("message", "dev by let");
        model.addAttribute("devs", developerService.developerNameStartsWith(let));
      //TODO display
        return "devs";
     }
   }