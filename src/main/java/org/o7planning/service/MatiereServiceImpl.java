package org.o7planning.service;

import java.util.List;
import java.util.Optional;

import org.o7planning.model.Matiere;
import org.o7planning.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatiereServiceImpl implements MatiereService {
	
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private ProfesseurService professeurService;
	
	@Override
	public List<Matiere> getAllMatiere() {
		return matiereRepository.findAll();
	}

	@Override
	public void saveMatiere(Matiere matiere) {
		matiere.setProfesseur(professeurService.getProfesseurById(matiere.getIdproff()));
		this.matiereRepository.save(matiere);

	}

	@Override
	public Matiere getMatiereById(long id) {
		Optional < Matiere > optional = matiereRepository.findById(id);
		Matiere matiere = null;
        if (optional.isPresent()) {
        	matiere = optional.get();
        } else {
            throw new RuntimeException(" Matiere not found for id :: " + id);
        }
        return matiere;
	}

	@Override
	public void deleteMatiereById(long id) {
		this.matiereRepository.deleteById(id);

	}

}
