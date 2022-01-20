package org.o7planning.controller;

import org.o7planning.model.Classe;
import org.o7planning.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClasseController {
	@Autowired
	private ClasseService classeService;
	
	// display list of classe
    @GetMapping("/gererClasse")
    public String viewHomePage(Model model) {
        model.addAttribute("listClasse", classeService.getAllClasse());
        return "gerer_classe";
    }
    
    @GetMapping("/showNewClasseForm")
    public String showNewClasseForm(Model model) {
        // create model attribute to bind form data
    	Classe classe = new Classe();
        model.addAttribute("classe", classe);
        //return "index";
        return "new_classe";
    }

    @PostMapping("/saveClasse")
    public String saveClasse(@ModelAttribute("classe") Classe classe) {
        // save classe to database
    	classeService.saveClasse(classe);
        return "redirect:/gererClasse";
    }

    @GetMapping("/showFormForUpdateClasse/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get classe from the service
    	Classe classe = classeService.getClasseById(id);

        // set classe as a model attribute to pre-populate the form
        model.addAttribute("classe", classe);
        return "update_classe";
    }

    @GetMapping("/deleteClasse/{id}")
    public String deleteClasse(@PathVariable(value = "id") long id) {

        // call delete classe method 
        this.classeService.deleteClasseById(id);
        return "redirect:/gererClasse";
    }
}
