package org.o7planning.service;

import java.util.List;

import org.o7planning.model.Matiere;

public interface MatiereService {
	List < Matiere > getAllMatiere();
    void saveMatiere(Matiere matiere);
    Matiere getMatiereById(long id);
    void deleteMatiereById(long id);
}
