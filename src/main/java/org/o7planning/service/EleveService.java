package org.o7planning.service;

import java.util.List;

import org.o7planning.model.Eleve;

public interface EleveService {
	List < Eleve > getAllEleve();
    void saveEleve(Eleve eleve);
    Eleve getEleveById(long id);
    void deleteEleveById(long id);
}
