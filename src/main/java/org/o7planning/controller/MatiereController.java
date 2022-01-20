package org.o7planning.controller;

import org.o7planning.model.Matiere;
import org.o7planning.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MatiereController {

	@Autowired
	private MatiereService matiereService;
	
	// display list of matiere
    @GetMapping("/gererMatiere")
    public String viewHomePage(Model model) {
        model.addAttribute("listMatiere", matiereService.getAllMatiere());
        return "gerer_matiere";
    }
    
    @GetMapping("/showNewMatiereForm")
    public String showNewMatiereForm(Model model) {
        // create model attribute to bind form data
        Matiere matiere = new Matiere();
        model.addAttribute("matiere", matiere);
        //return "index";
        return "new_matiere";
    }

    @PostMapping("/saveMatiere")
    public String saveMatiere(@ModelAttribute("matiere") Matiere matiere) {
        // save matiere to database
    	matiereService.saveMatiere(matiere);
        return "redirect:/gererMatiere";
    }

    @GetMapping("/showFormForUpdateMatiere/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get matiere from the service
    	Matiere matiere = matiereService.getMatiereById(id);

        // set matiere as a model attribute to pre-populate the form
        model.addAttribute("matiere", matiere);
        return "update_matiere";
    }

    @GetMapping("/deleteMatiere/{id}")
    public String deleteMatiere(@PathVariable(value = "id") long id) {

        // call delete matiere method 
        this.matiereService.deleteMatiereById(id);
        return "redirect:/gererMatiere";
    }
}
