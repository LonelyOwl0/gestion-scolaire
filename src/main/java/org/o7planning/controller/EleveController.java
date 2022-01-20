package org.o7planning.controller;

import org.o7planning.model.Eleve;
import org.o7planning.service.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EleveController {
	
	@Autowired
	private EleveService eleveService;
	
	// display list of eleve
    @GetMapping("/gererEleve")
    public String viewHomePage(Model model) {
        model.addAttribute("listEleve", eleveService.getAllEleve());
        return "gerer_eleve";
    }
    
    @GetMapping("/showNewEleveForm")
    public String showNewEleveForm(Model model) {
        // create model attribute to bind form data
        Eleve eleve = new Eleve();
        model.addAttribute("eleve", eleve);
        //return "index";
        return "new_eleve";
    }

    @PostMapping("/saveEleve")
    public String saveEleve(@ModelAttribute("eleve") Eleve eleve) {
        // save eleve to database
        eleveService.saveEleve(eleve);
        return "redirect:/gererEleve";
    }

    @GetMapping("/showFormForUpdateEleve/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get eleve from the service
    	Eleve eleve = eleveService.getEleveById(id);

        // set eleve as a model attribute to pre-populate the form
        model.addAttribute("eleve", eleve);
        return "update_eleve";
    }

    @GetMapping("/deleteEleve/{id}")
    public String deleteEleve(@PathVariable(value = "id") long id) {

        // call delete eleve method 
        this.eleveService.deleteEleveById(id);
        return "redirect:/gererEleve";
    }
}
