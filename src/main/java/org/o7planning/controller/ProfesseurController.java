package org.o7planning.controller;

import org.o7planning.model.Professeur;
import org.o7planning.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfesseurController {

	@Autowired
    private ProfesseurService professeurService;
	
	// display list of professeur
    @GetMapping("/gererProfesseur")
    public String viewHomePage(Model model) {
        model.addAttribute("listProfesseur", professeurService.getAllProfesseur());
        return "gerer_professeur";
    }
    
    @GetMapping("/showNewProfesseurForm")
    public String showNewProfesseurForm(Model model) {
        // create model attribute to bind form data
        Professeur professeur = new Professeur();
        model.addAttribute("professeur", professeur);
        //return "index";
        return "new_professeur";
    }

    @PostMapping("/saveProfesseur")
    public String saveProfesseur(@ModelAttribute("professeur") Professeur professeur) {
        // save professeur to database
        professeurService.saveProfesseur(professeur);
        return "redirect:/gererProfesseur";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get professeur from the service
    	Professeur professeur = professeurService.getProfesseurById(id);

        // set professeur as a model attribute to pre-populate the form
        model.addAttribute("professeur", professeur);
        return "update_professeur";
    }

    @GetMapping("/deleteProfesseur/{id}")
    public String deleteProfesseur(@PathVariable(value = "id") long id) {

        // call delete professeur method 
        this.professeurService.deleteProfesseurById(id);
        return "redirect:/gererProfesseur";
    }
}
