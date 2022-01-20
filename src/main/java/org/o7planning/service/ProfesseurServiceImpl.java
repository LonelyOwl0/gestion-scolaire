package org.o7planning.service;

import java.util.List;
import java.util.Optional;

import org.o7planning.model.Professeur;
import org.o7planning.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

	@Autowired
	private ProfesseurRepository professeurRepository;
	 
	@Override
	public List<Professeur> getAllProfesseur() {
		return professeurRepository.findAll();
	}

	@Override
	public void saveProfesseur(Professeur professeur) {
		this.professeurRepository.save(professeur);

	}

	@Override
	public Professeur getProfesseurById(long id) {
		Optional < Professeur > optional = professeurRepository.findById(id);
		Professeur professeur = null;
        if (optional.isPresent()) {
        	professeur = optional.get();
        } else {
            throw new RuntimeException(" Professeur not found for id :: " + id);
        }
        return professeur;
	}

	@Override
	public void deleteProfesseurById(long id) {
        this.professeurRepository.deleteById(id);

	}

}
