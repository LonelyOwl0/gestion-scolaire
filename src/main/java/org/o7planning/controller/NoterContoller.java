package org.o7planning.controller;

import org.o7planning.model.Noter;
import org.o7planning.service.NoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoterContoller {

	@Autowired
	private NoterService noterService;
	
	// display list of noter
    @GetMapping("/gererNoter")
    public String viewHomePage(Model model) {
        model.addAttribute("listNoter", noterService.getAllNoter());
        return "gerer_noter";
    }
    
    @GetMapping("/showNewNoterForm")
    public String showNewNoterForm(Model model) {
        // create model attribute to bind form data
        Noter noter = new Noter();
        model.addAttribute("noter", noter);
        //return "index";
        return "new_noter";
    }

    @PostMapping("/saveNoter")
    public String saveNoter(@ModelAttribute("noter") Noter noter) {
        // save noter to database
    	noterService.saveNoter(noter);
        return "redirect:/gererNoter";
    }

    @GetMapping("/showFormForUpdateNoter/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get noter from the service
    	Noter noter = noterService.getNoterById(id);

        // set noter as a model attribute to pre-populate the form
        model.addAttribute("noter", noter);
        return "update_noter";
    }

    @GetMapping("/deleteNoter/{id}")
    public String deleteNoter(@PathVariable(value = "id") long id) {

        // call delete noter method 
        this.noterService.deleteNoterById(id);
        return "redirect:/gererNoter";
    }
}
