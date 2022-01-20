package org.o7planning.service;

import java.util.List;

import org.o7planning.model.Professeur;

public interface ProfesseurService {
	List < Professeur > getAllProfesseur();
    void saveProfesseur(Professeur professeur);
    Professeur getProfesseurById(long id);
    void deleteProfesseurById(long id);
}
