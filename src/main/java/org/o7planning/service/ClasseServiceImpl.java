package org.o7planning.service;

import java.util.List;
import java.util.Optional;

import org.o7planning.model.Classe;
import org.o7planning.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasseServiceImpl implements ClasseService {

	@Autowired
	private ClasseRepository classeRepository;
	
	@Override
	public List<Classe> getAllClasse() {
		return classeRepository.findAll();
	}

	@Override
	public void saveClasse(Classe classe) {
		this.classeRepository.save(classe);

	}

	@Override
	public Classe getClasseById(long id) {
		Optional < Classe > optional = classeRepository.findById(id);
		Classe classe = null;
        if (optional.isPresent()) {
        	classe = optional.get();
        } else {
            throw new RuntimeException(" Classe not found for id :: " + id);
        }
        return classe;
	}

	@Override
	public void deleteClasseById(long id) {
		this.classeRepository.deleteById(id);

	}

}
