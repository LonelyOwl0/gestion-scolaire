package org.o7planning.service;

import java.util.List;

import org.o7planning.model.Classe;

public interface ClasseService {
	List < Classe > getAllClasse();
    void saveClasse(Classe classe);
    Classe getClasseById(long id);
    void deleteClasseById(long id);
}
