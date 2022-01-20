package org.o7planning.service;

import java.util.List;
import java.util.Optional;

import org.o7planning.model.Eleve;
import org.o7planning.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleveServiceImpl implements EleveService {

	@Autowired
	private EleveRepository eleveRepository;
	
	@Override
	public List<Eleve> getAllEleve() {
		return eleveRepository.findAll();
	}

	@Override
	public void saveEleve(Eleve eleve) {
		this.eleveRepository.save(eleve);

	}

	@Override
	public Eleve getEleveById(long id) {
		Optional < Eleve > optional = eleveRepository.findById(id);
		Eleve eleve = null;
        if (optional.isPresent()) {
        	eleve = optional.get();
        } else {
            throw new RuntimeException(" Eleve not found for id :: " + id);
        }
        return eleve;
	}

	@Override
	public void deleteEleveById(long id) {
		this.eleveRepository.deleteById(id);

	}

}
