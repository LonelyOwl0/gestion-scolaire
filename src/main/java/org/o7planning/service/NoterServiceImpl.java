package org.o7planning.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.o7planning.model.Noter;
import org.o7planning.repository.NoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoterServiceImpl implements NoterService {

	@Autowired
	private NoterRepository noterRepository;
	@Autowired
	private ProfesseurService professeurService;
	@Autowired
	private EleveService eleveService;
	@Autowired
	private MatiereService matiereService;
	
	@Override
	public List<Noter> getAllNoter() {
		return noterRepository.findAll();
	}

	@Override
	public void saveNoter(Noter noterr) {
		noterr.setProfesseur(professeurService.getProfesseurById(noterr.getIdprof()));
		noterr.setEleve(eleveService.getEleveById(noterr.getIdelevee()));
		noterr.setMatiere(matiereService.getMatiereById(noterr.getIdmatiere()));
		noterr.setDate(new Date());
		this.noterRepository.save(noterr);

	}

	@Override
	public Noter getNoterById(long id) {
		Optional < Noter > optional = noterRepository.findById(id);
		Noter noter = null;
        if (optional.isPresent()) {
        	noter = optional.get();
        } else {
            throw new RuntimeException(" Noter not found for id :: " + id);
        }
        return noter;
	}

	@Override
	public void deleteNoterById(long id) {
		this.noterRepository.deleteById(id);

	}

}
